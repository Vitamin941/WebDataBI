$( function() {
    $( "#draggable" ).draggable();
} );

function mouseDown() {
    document.getElementById("draggable").style.cursor = "move";
}

function mouseUp() {
    document.getElementById("draggable").style.cursor = "default";
}