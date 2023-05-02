class TurmaController {
    anoEscolar = document.querySelector("input[id='serie']")
    letra = document.querySelector("input[id='letra']")
    nome = document.querySelector("input[id='turma']")
    id = document.querySelector("select[id='turma']")

    constructor() {

    }

    create() {
        return new Turma(this.anoEscolar?.value, this.letra?.value, this.id?.value);
    }

    createAsJson() {
        let turma = this.create(); 
        return JSON.stringify(turma);
    }

    getTurmaData() {

        const nome = this.nome?.value; 

        return JSON.stringify({
            anoEscolar: nome[0],
            letra: nome[1].toUpperCase()
        })
    }

}