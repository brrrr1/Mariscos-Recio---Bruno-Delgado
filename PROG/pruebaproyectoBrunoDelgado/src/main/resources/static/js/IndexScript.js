function confirmarBorrado(event) {
	let confirmacion = confirm('¿Estás seguro de que deseas borrar este elemento?');
	if (!confirmacion) {
		event.preventDefault();
	}
}

function asociarEventListeners() {

	let botonesBorrar = document.querySelectorAll('[id^="borrarBtn"]');

	botonesBorrar.forEach(asociarEvento);
}

function asociarEvento(boton) {
	boton.addEventListener('click', confirmarBorrado);
}

document.addEventListener('DOMContentLoaded', asociarEventListeners);