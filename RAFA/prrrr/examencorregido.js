//EJERCICIO01
let icono = document.getElementById("verPwd");
let pwdInput = document.getElementById("pwd");






icono.addEventListener("mouseenter", function () {
    pwdInput.type = "text";
});




icono.addEventListener("mouseleave", function () {
    pwdInput.type = "password";
});




//EJERCICIO02




let numBocatas = 0;


let btnActualizar = document.getElementById('actualizar')
btnActualizar.addEventListener('click', actualizarCarrito);


function actualizarCarrito() {
    validarFormulario();
    actualizarMensajeCarrito();
    actualizarTablaCarrito();
}
function validarFormulario() {
    let todoOk = true;
    for (let campo of document.forms.formulario.elements) {
        todoOk &&= campo.value;


    }
    if (todoOk) {
        let btnTramitar = document.getElementById('tramitar');
        btnTramitar.classList.remove('btn-info');
        btnTramitar.classList.add('btn-success');
        numBocatas += document.forms.formulario.elements.cantidad.value;
    }
}
function actualizarMensajeCarrito() {
    let divMensaje = document.getElementById('numBocatas');
    divMensaje.innerText = (numBocatas) ? "Su carrito tiene " + numBocatas + " bocadillos" : "No ha encargado nada";
}




function actualizarTablaCarrito() {
    let tabla = document.querySelector('table');
    let nuevoTr = document.createElement('tr');
    let tdBocadillo = document.createElement('td');
    let tdTamano = document.createElement('td');
    let tdCantidad = document.createElement('td');


    let campos = document.forms.formulario.elements;
    tdBocadillo.innerText = campos.bocata.value;
    tdTamano.innerText = campos.tamano.value;
    tdCantidad.innerText = campos.cantidad.value;


    nuevoTr.append(tdBocadillo);
    nuevoTr.append(tdTamano);
    nuevoTr.append(tdCantidad);


    tabla.append(nuevoTr);


}


//EJERCICIO03


let btnTramitar = document.getElementById('tramitar');
btnTramitar.addEventListener('click', tramitarPedido);


function tramitarPedido() {
    let modalBody = document.querySelector('.modal-body');
    if (numBocatas) {
        let nuevaTabla = document.querySelector('table').cloneNode(true);
        modalBody.append(nuevaTabla);
        modalBody.firstElementChild.remove();
    } else {
        modalBody.firstElementChild.innerText = "Debe encargar algo para poder tramitar el pedido";
}
    }
