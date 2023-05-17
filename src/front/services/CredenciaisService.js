class CredenciaisService {

    static async mudarSenha() {
        
        const response = await fetch(`http://localhost:8080/credentials/me`, {
            method: "PUT",
            body: new CredenciaisController().createToJson(),
            headers: {
                'Content-Type': 'application/json'
            }
        });

        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        };

        
    }
}