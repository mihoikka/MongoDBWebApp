function submitForm(){

    let item_arr = document.getElementById("char_form").elements.namedItem("items").value.split("\n")

    let relationship_arr = document.getElementById("char_form").elements.namedItem("relations").value.split("\n")

    const xhr = new XMLHttpRequest();
    let form = document.forms[0];
    xhr.open(form.method, "http://localhost:8080/api/character/update", true)
    let body = "{\"charId\" : {\"name\":" + "\"" + document.getElementById("char_form").elements.namedItem("first_name").value + "\"" +
        ", \"curr_time\":" + document.getElementById("char_form").elements.namedItem("curr_time").value +
        "}, \"Ability\":" + "\"" + document.getElementById("char_form").elements.namedItem("ability").value + "\"" +
        ", \"role\":" + "\""  + document.getElementById("char_form").elements.namedItem("role").value + "\"" +
        ", \"description\":" + "\""  + document.getElementById("char_form").elements.namedItem("description").value + "\"" +
        ", \"items\":" + JSON.stringify(item_arr) +
        ", \"relations\":" + JSON.stringify(relationship_arr) +  "}"
    xhr.setRequestHeader('Content-Type', 'application/json; charset UTF-8');
    xhr.send(body);
    alert(body);
}