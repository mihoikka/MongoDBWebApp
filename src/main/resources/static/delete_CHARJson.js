let PORT=443;
function deleteCharacterData(){
    let xhr = new XMLHttpRequest();

    let urlstring = "https://" + location.hostname + ":" + PORT + "/api/character/delete";
    let name = document.getElementById("charToDelete").value;
    if (name !== "ALL"){
        urlstring +=  "/" + name.split(" ").join("_");
    }
    if (name === ""){
        alert("Please enter a valid character name.");
        return;
    }
    alert(urlstring);
    xhr.open(method="delete", action=urlstring, true);

    xhr.setRequestHeader('Content-Type', 'application/json; charset UTF-8');
    xhr.send();
}