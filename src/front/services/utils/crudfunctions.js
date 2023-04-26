async function cadastrar(userType) {
    if (userType == UserType.Aluno) {

        let aluno = new AlunoController().createAsJson();
        let response = await fetch("http://localhost:8080/aluno", {
            method: "POST",
            body: aluno,
            headers: {
                'Content-Type': 'application/json'
            }
        })

        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        };

    } else if (userType == UserType.Professor) {
        let professor = new ProfessorController().createAsJson();
        let response = await fetch("http://localhost:8080/professor", {
            method: "POST",
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

    } else if (userType == UserType.Turma) {
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

}

async function atualizar(userType) {
    if (userType == UserType.Aluno) {
        let aluno = new AlunoController().createAsJson();
        let response = await fetch(`http://localhost:8080/aluno`, {
            method: "PUT",
            body: aluno,
            headers: {
                'Content-Type': 'application/json'
            }
        })

        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        };
    } else if (userType == UserType.Professor) {
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
}

async function resgatar(userType) {
    if (userType == UserType.Aluno) { 
        let aluno = new AlunoController().create(); 
        let response = await fetch(`http://localhost:8080/aluno/${aluno.cpf}`);

        return {
            json: await response.json(),
            status: response.status, 
            text: response.statusText
        }
        
    } else if (userType == UserType.Professor) {
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

}

async function deletar(userType) {
    if (userType == UserType.Aluno) {
        let aluno = new AlunoController().create();
        let response = await fetch(`http://localhost:8080/aluno/${aluno.cpf}`, {
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

    } else if (userType == UserType.Professor) {
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
}