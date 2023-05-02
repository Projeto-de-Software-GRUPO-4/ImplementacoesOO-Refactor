class OcorrenciaController {

    aluno_cpf = document.querySelector("input[id='cpf_aluno']")
    ocorrencia_texto = document.querySelector("textarea[id='ocorrencia']")

    constructor() {

    }

    create() {
        return new Ocorrencia(this.ocorrencia_texto?.value, this.aluno_cpf?.value);
    };

    createAsJson() {
        let ocorrencia = this.create(); 
        return JSON.stringify(ocorrencia);
    };

}