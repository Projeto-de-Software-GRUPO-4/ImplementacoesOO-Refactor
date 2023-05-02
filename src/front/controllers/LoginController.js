class LoginController {

    id = document.querySelector("input[id='cpf']")
    senha = document.querySelector("input[id='senha']")

    create() {
        return new Login(this.id?.value, this.senha?.value);
    }

    createToJson() {
        return JSON.stringify(this.create());
    }

}