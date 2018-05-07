function catchPedido(id) {
    document.getElementById('catchPedido').value = id
    console.log(document.getElementById('catchPedido').value)
}

function catchMensajero(id) {
    document.getElementById('catchMensajero').value = id
    console.log(document.getElementById('catchMensajero').value)
}

document.getElementById('despachar').addEventListener('click', e => {
    if (document.getElementById('catchPedido').value == -1 || 
            document.getElementById('catchMensajero').value == -1) {
        alert('Seleccione un pedido y un mensajero');
        e.preventDefault();
    }
});