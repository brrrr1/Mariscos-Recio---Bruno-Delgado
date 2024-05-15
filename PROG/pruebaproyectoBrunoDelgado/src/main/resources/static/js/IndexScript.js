function handleButtonClick(event) {
	event.preventDefault();
	const borrarLink = document.getElementById('confirmarBorradoLink');
	borrarLink.href = event.target.href;

	const borrarModal = new bootstrap.Modal(document.getElementById('borrarModal'));
	borrarModal.show();
}

document.querySelectorAll('[id^="borrarBtn"]').forEach(function(button) {
	button.addEventListener('click', handleButtonClick);
});
