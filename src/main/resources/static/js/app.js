
var bttSignin = document.querySelector("#signin");
var bttSignup = document.querySelector("#signup");

var body = document.querySelector("body");

bttSignin.addEventListener("click", function () {
    body.className = "sign-in-js";
});

bttSignup.addEventListener("click", function () {
    body.className = "sign-up-js";
});