// Initialize Firebase
var config = {
    apiKey: "AIzaSyBGqlUkPdLxNZG7fECEBaWwq_7fZJYRjtk",
    authDomain: "mrcheese-8172d.firebaseapp.com",
    databaseURL: "https://mrcheese-8172d.firebaseio.com",
    projectId: "mrcheese-8172d",
    storageBucket: "mrcheese-8172d.appspot.com",
    messagingSenderId: "170156843715"
};
let defaultApp = firebase.initializeApp(config);
let database = defaultApp.database();


function openChat(rol, id) {
    let newId = rol + '-' + id;
    if (document.getElementById(newId) === null) {
        let path = '/mensajes/' + rol + '/' + id + '/';
        document.getElementById('content')
                .innerHTML += `<div class="chat" id="${newId}">
                                    <div class="close" onclick="closeListener(event)">X</div>  

                                    <div class="historical" id="${rol}-historial-${id}"></div>

                                    <form class="form-message">
                                            <input type="text" id="mensaje" required>
                                            <input type="submit" id="${id}" value="enviar"> 
                                    </form>
                                </div>`;


        //EVENTO DE LECTURA DE DATOS
        let messages = database.ref().child('mensajes/' + rol + '/' + id);
        messages.on('value', (snapshot) => {
            let data = snapshot.val();
            let keys = Object.keys(data);
            let div = document.getElementById(rol + '-historial-' + id);
            for (let i = 0; i < keys.length; i++) {
                let k = keys[i];
                div.innerHTML += `<div class="message sender-${data[k].sender}">${data[k].mensaje}</div>`;
            }
        });

        //SUBMIT mssage
        document.getElementById(id).addEventListener("click", () => {
            //SUBE LOS DATOS        
            //let postKey = database.ref().child('mensajes').push().key;
            let postKey = new Date().toLocaleString().replace("/", "-").replace("/", "-")
            let ups = {};
            ups[path + postKey] = {
                mensaje: document.getElementById('mensaje').value,
                //fecha: new Date().toLocaleString(),
                sender: 1
            };
            database.ref().update(ups);
            document.getElementById(rol + '-historial-' + id).innerHTML = '';
        });
    }
}

function closeListener(e) {
    e.target.parentNode.remove();
}

