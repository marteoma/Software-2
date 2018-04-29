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
    document.getElementById('content')
            .innerHTML += `<div id="chat">
                                <div id="close">X</div>  
    
                                <div class="historical" id="${rol}-historial-${id}"></div>
    
                                <form>
                                    <input type="text" id="mensaje" required>
                                    <input type="submit" id="${id}" value="enviar"> 
                                </form>
                            </div>`;
    let path = '/mensajes/' + rol + '/' + id + '/';
    
    //EVENTO DE LECTURA DE DATOS
    let messages = database.ref().child('mensajes/'+rol+'/'+id);
    messages.on('value', (snapshot) => {
        let data = snapshot.val();
        let keys = Object.keys(data);
        let div = document.getElementById(rol+'-historial-'+id);
        for (let i = 0; i < keys.length; i++) {
            let k = keys[i];
            div.innerHTML += `<div class="message">${data[k].mensaje}</div>`;
        }
    });
    
    //Evento cerrar form
    document.getElementById('close').addEventListener('click', () => {
        document.getElementById('chat').remove();
    });
    
    //SUBMIT mssage
    document.getElementById(id).addEventListener("click", () => {
        //SUBE LOS DATOS        
        let postKey = database.ref().child('mensajes').push().key;
        let ups = {};
        ups[path + postKey] = {
            mensaje: document.getElementById('mensaje').value,
            fecha: new Date().toLocaleString()
        };
        database.ref().update(ups);
        document.getElementById(rol+'-historial-'+id).innerHTML = '';
    });
}



