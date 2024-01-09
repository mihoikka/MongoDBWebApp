let PORT_NUM = 443;

function submitForm(...args){
    const form = document.getElementById("char_form");
    const item_arr = form.elements.namedItem("items").value.split("\n")

    const relationship_arr = form.elements.namedItem("relations").value.split("\n")

    const xhr = new XMLHttpRequest();

    const name = form.elements.namedItem("first_name").value + " " + //
        form.elements.namedItem("last_name").value;

    //construct the url for the update request
    const urlstring = "http://" + location.hostname + ":" + PORT_NUM +  "/api/character/update/" + name + args[0];
    xhr.open(form.method, urlstring, true)
    let body = "{\"charId\" : {\"firstName\":" + "\"" + form.elements.namedItem("first_name").value + "\"" +
        ", \"lastName\":" + "\"" + form.elements.namedItem("last_name").value + "\"" +
        ", \"curr_time\":" + form.elements.namedItem("curr_time").value +
        "}, \"Ability\":" + "\"" + form.elements.namedItem("ability").value + "\"" +
        ", \"role\":" + "\""  + form.elements.namedItem("role").value + "\"" +
        ", \"description\":" + "\""  + form.elements.namedItem("description").value + "\"" +
        ", \"items\":" + JSON.stringify(item_arr) +
        ", \"relations\":" + JSON.stringify(relationship_arr) +  "}"
    xhr.setRequestHeader('Content-Type', 'application/json; charset UTF-8');
    xhr.send(body);
}

// Supposedly it is better to not use embedded javascript to add function calls to buttons
//const subButton = document.querySelector(".submitButton")
//subButton.addEventListener("click", submitForm)