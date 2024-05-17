function validarFormulario() {
	let nombre = document.getElementById('nombre').value;
	let descripcion = document.getElementById('descripcion').value;
	let foto = document.getElementById('foto').value;
	let precio = parseFloat(document.getElementById('precio').value);
	let stock = parseInt(document.getElementById('stock').value);
	let errorMensaje = document.getElementById('errorMensaje');

	if (nombre.trim() === '' || descripcion.trim() === '' || foto.trim() === '' || isNaN(precio) || isNaN(stock) || precio < 0 || stock < 0) {
		errorMensaje.innerHTML = '<span style="color: white;">Por favor, rellene todos los campos y asegúrese de que los números no sean negativos.</span>';
		return false;
	}

	errorMensaje.innerHTML = '';
	return true;
}