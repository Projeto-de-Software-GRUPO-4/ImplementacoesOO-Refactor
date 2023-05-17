class CredenciaisController {

    tentativaSenha = document.querySelector("input[id='senha']");
    novaSenha = document.querySelector("input[id='nova']");
    id = localStorage.getItem("usuario_id");

    createToJson() {
        console.log(JSON.stringify({
            tentativaSenha: this.tentativaSenha?.value,
            novaSenha: this.novaSenha?.value, 
            usuario_id: this.id
        }));
        return JSON.stringify({
            tentativaSenha: this.tentativaSenha?.value,
            novaSenha: this.novaSenha?.value, 
            usuario_id: this.id
        });
    }

}