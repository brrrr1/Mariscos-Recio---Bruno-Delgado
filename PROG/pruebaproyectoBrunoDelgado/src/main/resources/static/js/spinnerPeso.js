	let pesoValor = document.getElementById('pesoValor');

		function actualizarValor() {
			pesoValor.textContent = pesoInput.value;
		}

		pesoInput.addEventListener('input', actualizarValor);

		actualizarValor();