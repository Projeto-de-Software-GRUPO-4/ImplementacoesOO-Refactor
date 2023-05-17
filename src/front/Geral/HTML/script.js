var qm_chamou = localStorage.getItem("qm_chamou");
// alert("quem chamou foi " + qm_chamou + ", logo, precisamos buscar a senha no db dele e alterar la");

function ok(){
    if(qm_chamou === "admin"){
        window.location.href = "../../Admin/admin_function.html";
    }else if(qm_chamou === "aluno"){
        window.location.href = "../../Aluno/aluno_function.html";
    }else if(qm_chamou === "professor"){
        window.location.href = "../../Professor/prof_function.html";
    }
}

function onde(id){
    var x = document.getElementById(id);

    if(qm_chamou === "admin" && id === "home"){
        x.href = "../../Admin/admin_function.html";
    }else if(qm_chamou === "admin" && id === "perfil"){
        x.href = "../../Admin/perfil_admin.html";
    }else if(qm_chamou === "aluno" && id === "perfil"){
        x.href = "../../Aluno/perfil_aluno.html";
    }else if(qm_chamou === "aluno" && id === "home"){
        x.href = "../../Aluno/aluno_function.html";
    }else if(qm_chamou === "professor" && id === "perfil"){
        x.href = "../../Professor/perfil_prof.html";
    }else if(qm_chamou === "professor" && id === "home"){
        x.href = "../../Professor/prof_function.html";
    }
}

function enviar(){
    var inputs = document.querySelectorAll("input");
    var alterada = document.getElementById("alterada");
    var div = document.getElementById("div_alterada");

    for(var i = 0; i < inputs.length; i++){
        if(inputs[i].value === ""){
            document.getElementById("error").textContent = "Todos os campos são obrigatórios!";
            return;
        }
    }
    
    document.querySelector('#main').style.pointerEvents = 'none';
    document.querySelector('#main').style.opacity = '0.5';
    div.style.display = "block";
    alterada.textContent = "Senha alterada com sucesso!";
}

function compara(){
    var senha = document.getElementById("senha").value;
    var nova = document.getElementById("nova").value;
    var repita = document.getElementById("repita").value;
    var error = document.getElementById("error");

    if(senha === nova && nova !== ""){
        error.textContent = "A nova senha deve ser diferente da atual!";
        return false;
    }else if(nova !== repita && repita !== ""){
        error.textContent = "As senhas não coincidem!";
        return false;
    }else if(senha !== nova){
        error.textContent = "";
    }else if(senha !== nova && nova === repita){
        error.textContent = "";
        return true;
    }
}

function mostrarSenha(){
    var senhaInput = document.getElementById("senha");
    var senhaBotao = document.getElementById("botaosenha");

    if(senhaInput.type === "password"){
        senhaInput.type = "text";
        senhaBotao.src = "../Imagens/eye-slash-solid.png"
    }else{
        senhaInput.type = "password";
        senhaBotao.src = "../Imagens/eye-solid.png";
    }
}

function mostrarNova(){
    var senhaInput = document.getElementById("nova");
    var senhaBotao = document.getElementById("botaonova");

    if(senhaInput.type === "password"){
        senhaInput.type = "text";
        senhaBotao.src = "../Imagens/eye-slash-solid.png";
    }else{
        senhaInput.type = "password";
        senhaBotao.src = "../Imagens/eye-solid.png";
    }
}

function mostrarRepita(){
    var senhaBotao = document.getElementById("botaorepita");
    var senhaInput = document.getElementById("repita");

    if(senhaInput.type === "password"){
        senhaInput.type = "text";
        senhaBotao.src = "../Imagens/eye-slash-solid.png";
    }else{
        senhaInput.type = "password";
        senhaBotao.src = "../Imagens/eye-solid.png";
    }
}