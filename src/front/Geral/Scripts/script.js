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

function errado(){
    const error = document.getElementById('error');
    var cpf = document.getElementById('cpf').value;
    var senha = document.getElementById('senha').value;

    if(cpf === ""){
        error.textContent = "O campo de CPF é obrigatório!";
    }else if(senha === ""){
        error.textContent = "O campo de senha é obrigatório!";
    }else{
        error.textContent = "Senha incorreta! (falta verificar no DB)";
    }
}