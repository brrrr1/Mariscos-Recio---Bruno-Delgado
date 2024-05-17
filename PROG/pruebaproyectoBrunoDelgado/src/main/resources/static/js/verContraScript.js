let icono = document.getElementById("verPwd");
let pwdInput = document.getElementById("pwd");






icono.addEventListener("mouseenter", function () {
    pwdInput.type = "text";
});




icono.addEventListener("mouseleave", function () {
    pwdInput.type = "password";
});



