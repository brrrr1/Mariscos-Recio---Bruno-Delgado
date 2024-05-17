document.getElementById('registroForm').addEventListener('submit', function(event) {
	event.preventDefault();
	validateForm();
});

function validateForm() {
	let dniInput = document.getElementById('dni');
	let dniError = document.getElementById('dniError');
	let dniRegex = /^[0-9]{8}[a-zA-Z]$/;

	if (!dniRegex.test(dniInput.value)) {
		dniError.textContent = 'El DNI debe tener 8 números seguidos de una letra.';
		document.getElementById('errorMessage').textContent = 'Por favor, corrija los errores en el formulario.';
		return;
	} else {
		dniError.textContent = '';
	}

	let emailInput = document.getElementById('email');
	if (emailInput.value.indexOf('@') === -1) {
		document.getElementById('errorMessage').textContent = 'El correo debe contener el símbolo "@".';
		return;
	}

	let inputs = document.querySelectorAll('input:not([type="submit"])');
	for (let i = 0; i < inputs.length; i++) {
		if (!inputs[i].value) {
			document.getElementById('errorMessage').textContent = 'Por favor complete todos los campos.';
			return;
		}
	}

	// Si pasa todas las validaciones, puedes enviar el formulario aquí
	document.getElementById('registroForm').submit();
}