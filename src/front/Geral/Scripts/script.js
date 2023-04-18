function mostrarSenha(){
    var senhaInput = document.getElementById("senha");
    var senhaBotao = document.getElementById("botaosenha");

    if(senhaInput.type === "password"){
        senhaInput.type = "text";
        senhaBotao.src = "../Geral/Imagens/eye-slash-solid.png";
    }else{
        senhaInput.type = "password";
        senhaBotao.src = "../Geral/Imagens/eye-solid.png";
    }
}

function mostrarNova(){
    var senhaInput = document.getElementById("nova");
    if(senhaInput.type === "password"){
        senhaInput.type = "text";
        senhaBotao.src = "../Geral/Imagens/eye-slash-solid.png";
    }else{
        senhaInput.type = "password";
        senhaBotao.src = "../Geral/Imagens/eye-solid.png";
    }
}

function mostrarRepita(){
    var senhaInput = document.getElementById("repita");
    if(senhaInput.type === "password"){
        senhaInput.type = "text";
        senhaBotao.src = "../Geral/Imagens/eye-slash-solid.png";
    }else{
        senhaInput.type = "password";
        senhaBotao.src = "../Geral/Imagens/eye-solid.png";
    }
}

function isvalid(cpf){
    var result = 0, verificador1 = 0, verificador2 = 0;
    if(cpf.length != 11){
        return false;
    }

    if(cpf[0] === cpf[1] && cpf[1] === cpf[2] && cpf[2] === cpf[3] && 
        cpf[3] === cpf[4] && cpf[4] === cpf[5] && cpf[5] === cpf[6] && 
        cpf[6] === cpf[7] && cpf[7] === cpf[8] && cpf[8] === cpf[9] && 
        cpf[9] === cpf[10]){

        return false;
    }

    for(var i = 10, j = 0; i >= 2; i--, j++){
        result = result + (parseInt(cpf[j]) * i);
    }

    if(result%11 < 2){
        verificador1 = 0;
    }else{
        verificador1 = 11 - (result%11);
    }

    if(verificador1 !== parseInt(cpf[9])){
        return false;
    }

    result = 0;
    for(var i = 11, j = 0; i >= 2; i--, j++){
        result = result + (parseInt(cpf[j]) * i);
    }

    if(result%11 < 2){
        verificador2 = 0;
    }else{
        verificador2 = 11 - (result%11);
    }

    if(verificador2 !== parseInt(cpf[10])){
        return false;
    }

    return true;
}