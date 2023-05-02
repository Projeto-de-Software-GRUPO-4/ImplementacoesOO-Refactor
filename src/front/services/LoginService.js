class LoginService {

    static async login() {
        let login = new LoginController().createToJson();
        let response = await fetch("http://localhost:8080/login", {
            method: "POST",
            body: login,
            headers: {
                'Content-Type': 'application/json'
            }
        })

        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        };
    }
}