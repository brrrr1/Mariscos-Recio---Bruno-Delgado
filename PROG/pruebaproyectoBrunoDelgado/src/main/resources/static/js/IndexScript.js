function botonBorrar(evento) {
	evento.preventDefault();
	let borrarLink = document.getElementById('confirmarBorradoLink');
	borrarLink.href = evento.target.href;

	let borrarModal = new bootstrap.Modal(document.getElementById('borrarModal'));
	borrarModal.show();
}

function addClickListener(button) {
	button.addEventListener('click', botonBorrar);
}

function ponerBotonesAFuncionar() {
	let buttons = document.querySelectorAll('[id^="borrarBtn"]');
	buttons.forEach(addClickListener);
}

document.addEventListener('DOMContentLoaded', ponerBotonesAFuncionar);
