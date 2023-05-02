class TurmaService {

    static async cadastrar() {
        let turma = new TurmaController().createAsJson();
        let response = await fetch("http://localhost:8080/turma", {
            method: "POST",
            body: turma, 
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

    static async resgatar() {
        let turma = new TurmaController().getTurmaData(); 
        let response = await fetch("http://localhost:8080/turma/resgatar", {
            method: "POST",
            body: turma,
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

    static async resgatarAll() {
        let response = await fetch("http://localhost:8080/turma/all", {
            method: "GET",
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