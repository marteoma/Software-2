// Initialize Firebase
var config = {
    apiKey: "AIzaSyBGqlUkPdLxNZG7fECEBaWwq_7fZJYRjtk",
    authDomain: "mrcheese-8172d.firebaseapp.com",
    databaseURL: "https://mrcheese-8172d.firebaseio.com",
    projectId: "mrcheese-8172d",
    storageBucket: "mrcheese-8172d.appspot.com",
    messagingSenderId: "170156843715"
};
var defaultApp = firebase.initializeApp(config);

var database = defaultApp.database();

function openChat(id) {
    document.getElementById('content')
            .innerHTML += `<div id="chat">
     <div id="close">X</div>                    
     <form>
     <input type="text" id="mensaje">
     <input type="submit" id="${id}" value="enviar"> 
     </form>
     </div>`;
    console.log(id);
    document.getElementById(id).addEventListener("click", () => {
        database.ref('mensaje/').set({
            id: id,
            mensaje: document.getElementById('mensaje').value
        });
    });


}



