var websocket = new WebSocket("ws://localhost:8080/onlineshop-web/websocket");
var ausgabe = document.getElementById("ausgabe");

websocket.onopen = function(evt) {
	ausgabe.innerHTML += "Verbunden mit " + websocket.url + "<br>";
};

websocket.onmessage = function(evt) {
	ausgabe.innerHTML += evt.data + "<br>";
};

websocket.onerror = function(evt) {
	ausgabe.innerHTML += "Fehler: " + evt.data + "<br>";
};

function sende() {
    websocket.send(benutzer.value + ": " + nachricht.value);
}