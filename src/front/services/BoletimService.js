class BoletimService {

    static async resgatarAllTurmaAno(materia_id, ano) {
        
        const response = await fetch(`http://localhost:8080/boletim/materia/${materia_id}/ano/${ano}`, {
            method: "GET",
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

    static async resgatarAllAlunoAno(aluno_id, ano) {
        const response = await fetch(`http://localhost:8080/boletim/aluno/${aluno_id}/${ano}`, {
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

    static async cadastrar(boletim) {

        const response = await fetch(`http://localhost:8080/boletim/registrar`, {
            method: "POST", 
            body: BoletimController.toJson(boletim),
            headers: {
                'Content-Type': 'application/json'
            }
        });

        return {
            json: await response.json(), 
            status: response.status,
            text: response.statusText
        }

    }


}