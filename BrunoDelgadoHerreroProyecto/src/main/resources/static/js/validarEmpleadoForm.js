function validarFormulario() {
	var nombre = document.getElementById('nombre').value;
	var apellido = document.getElementById('apellido').value;
	var dni = document.getElementById('dni').value;
	var sueldo = document.getElementById('sueldo').value;
	var fechaIngreso = document.getElementById('fechaIngreso').value;
	var fechaSalida = document.getElementById('fechaSalida').value;
	var foto = document.getElementById('foto').value;
	var errorDiv = document.getElementById('error-message');


	if (nombre === '' || apellido === '' || dni === '' || sueldo === '' || fechaIngreso === '' || foto === '') {
		errorDiv.innerText = 'Por favor, complete todos los campos (no hace falta poner fecha de salida)';
		return false;
	}


	var dniRegex = /^[0-9]{8}[A-Za-z]$/;
	if (!dniRegex.test(dni)) {
		errorDiv.innerText = 'El DNI debe contener 8 números seguidos de una letra (por ejemplo 12345678A)';
		return false;
	}


	if (fechaSalida !== '' && new Date(fechaSalida) < new Date(fechaIngreso)) {
		errorDiv.innerText = 'La fecha de salida no puede ser anterior a la fecha de ingreso';
		return false;
	}


	errorDiv.innerText = '';
	return true;
}
