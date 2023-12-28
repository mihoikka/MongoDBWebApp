let item_arr = document.getElementById("char_form").elements["items"].value.split("\n")

let relationship_arr = document.getElementById("char_form").elements["relations"].value.split("\n")
function submitForm(){
    alert("Sending JSON");
    const xhr = new XMLHttpRequest();
    let form = document.forms[0];
    xhr.open(form.method, "localhost:8080/api/character/update", true)
    let body = "{\"charId\" : {\"name\":" + "\"" + document.getElementById("char_form").elements["name"] + "\"" +
        ", \"curr_time\":" + document.getElementById("char_form").elements["time"] +
        "}, \"Ability\":" + "\"" + document.getElementById("char_form").elements["ability"] + "\"" +
        ", \"role\":" + "\""  + document.getElementById("char_form").elements["role"] + "\"" +
        ", \"description\":" + "\""  + document.getElementById("char_form").elements["description"] + "\"" +
        ", \"items\":" + JSON.stringify(item_arr) +
        ", \"relations\":" + JSON.stringify(relationship_arr) +  "}"
    xhr.setRequestHeader('Content-Type', 'application/json; charset UTF-8');
    //xhr.send(JSON.stringify(body))
    xhr.send(body);
}