document.addEventListener('DOMContentLoaded', function() {
	let form = document.querySelector('form');
	form.addEventListener('submit', function(event) {
		let todoRelleno = true;
		let dniValido = true;

		let inputs = form.querySelectorAll('input[required]');
		inputs.forEach(input => {
			if (!input.value.trim()) {
				todoRelleno = false;
				input.classList.add('is-invalid');
			} else {
				input.classList.remove('is-invalid');
			}
		});


		let dniEntrada = form.querySelector('input[name="dni"]');
		let dniFormato = /^[0-9]{8}[A-Za-z]$/;
		if (!dniFormato.test(dniEntrada.value)) {
			dniValido = false;
			dniEntrada.classList.add('is-invalid');
			alert('El DNI debe estar formado por 8 números y una letra (por ejemplo, 12345678A).');
		} else {
			dniEntrada.classList.remove('is-invalid');
		}

		if (!todoRelleno || !dniValido) {
			event.preventDefault();
			if (!todoRelleno) {
				alert('Por favor, rellene todos los campos.');
			}
		}
	});
});