class ProfessorService {
    static async cadastrar() {
        let professor = new ProfessorController().createAsJson();
        let response = await fetch("http://localhost:8080/professor", {
            method: "POST",
            body: professor,
            headers: {
                'Content-Type': 'application/json'
            }
        })

        console.log(professor)

        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        };

    }

    static async atualizar() {
        let professor = new ProfessorController().createAsJson();
        let response = await fetch(`http://localhost:8080/professor`, {
            method: "PUT",
            body: professor,
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
        let professor = new ProfessorController().create();
        let response = await fetch(`http://localhost:8080/professor/${professor.cpf}`, {
            method: "GET",
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

    static async resgatarMyTurmas(id_professor) {
        let response = await fetch(`http://localhost:8080/professor/minhas_turmas/${id_professor}`, {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        })
        
        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        }

    }

    static async deletar() {
        let professor = new ProfessorController().create();
        let response = await fetch(`http://localhost:8080/professor/${professor.cpf}`, {
            method: "DELETE",
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

    static async linkarATurma() {
        let professor = new ProfessorController().create();
        let turma = new TurmaController().create();

        const turma_professor = JSON.stringify({
            id_usuario: professor.cpf,
            id_turma: turma.id
        })

        let response = await fetch(`http://localhost:8080/professor/adicionar_a_turma`, {
            method: "POST",
            body: turma_professor,
            headers: {
                'Content-Type': 'application/json'
            }
        })

        return {
            json: await response.json(),
            status: response.status, 
            text: response.statusText
        }

    }

    static async deslinkarATurma() {
        let professor = new ProfessorController().create();
        let turma = new TurmaController().create();

        const turma_professor = JSON.stringify({
            id_usuario: professor.cpf,
            id_turma: turma.id
        })

        let response = await fetch(`http://localhost:8080/professor/remover_da_turma`, {
            method: "DELETE",
            body: turma_professor,
            headers: {
                'Content-Type': 'application/json'
            }
        })

        return {
            json: await response.json(),
            status: response.status, 
            text: response.statusText
        }

    }



}