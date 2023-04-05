function mostrarSenha(){
    var senhaInput = document.getElementById("senha");
    if(senhaInput.type === "password"){
        senhaInput.type = "text";
    }else{
        senhaInput.type = "password";
    }
}

function mostrarNova(){
    var senhaInput = document.getElementById("nova");
    if(senhaInput.type === "password"){
        senhaInput.type = "text";
    }else{
        senhaInput.type = "password";
    }
}

function mostrarRepita(){
    var senhaInput = document.getElementById("repita");
    if(senhaInput.type === "password"){
        senhaInput.type = "text";
    }else{
        senhaInput.type = "password";
    }
}