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
















function botonBaja(evento) {
	evento.preventDefault();
	let bajaLink = document.getElementById('confirmarBajaLink');
	bajaLink.href = evento.target.href;

	let bajaModal = new bootstrap.Modal(document.getElementById('bajaModal'));
	bajaModal.show();
}

function addClickListener2(button) {
	button.addEventListener('click', botonBaja);
}

function ponerBotonesAFuncionar2() {
	let buttons = document.querySelectorAll('[id^="bajaBtn"]');
	buttons.forEach(addClickListener2);
}

document.addEventListener('DOMContentLoaded', ponerBotonesAFuncionar2);


