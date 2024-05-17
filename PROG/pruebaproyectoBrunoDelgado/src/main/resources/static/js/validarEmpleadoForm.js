        function validarFormulario() {
            var nombre = document.getElementById('nombre').value;
            var apellido = document.getElementById('apellido').value;
            var sueldo = document.getElementById('sueldo').value;
            var fechaIngreso = document.getElementById('fechaIngreso').value;
            var foto = document.getElementById('foto').value;
            var errorDiv = document.getElementById('error-message');


            if (nombre === '' || apellido === '' || sueldo === '' || fechaIngreso === '' || foto === '') {
                errorDiv.innerText = 'Por favor, complete todos los campos (no hace falta poner fecha de salida)';
                return false;
            } else {
                errorDiv.innerText = '';
            }

            return true;
        }