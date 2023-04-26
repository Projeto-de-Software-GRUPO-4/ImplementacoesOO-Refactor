class AlunoController extends UsuarioController {

    responsavelCpf = document.querySelector("input[id='responsavelCpf']");
    responsavelNome = document.querySelector("input[id='responsavelNome']");
    responsavelNumero = document.querySelector("input[id='responsavelNumero']");
    anoEscolar = document.querySelector("input[id='serie']");
    mensalidade = document.querySelector("input[id='mensalidade']");
    turma = null; 
    suspenso = false; 

    constructor() {
        super();
        // this.responsavelCpf = document.querySelector("input[id='responsavelCpf']");
        // this.responsavelNome = document.querySelector("input[id='responsavelNome']");
        // this.responsavelNumero = document.querySelector("input[id='responsavelNumero']");
        // this.anoEscolar = document.querySelector("input[id='serie']");
        // this.mensalidade = document.querySelector("input[id='mensalidade']");
        // this.turma = null; 
        // this.suspenso = false; 
    }

    create() {

        const responsavel = {
            nome: this.responsavelNome?.value,
            cpf: this.responsavelCpf?.value,
            telefone: this.responsavelNumero?.value
        }


        return new Aluno(
            this.nome?.value, this.cpf?.value, this.dataDeNascimento?.value,
            this.diaDePagamento?.value, this.turma, responsavel, 
            this.anoEscolar?.value, this.mensalidade?.value, this.suspenso, this.senha?.value
        );
    }

    createAsJson() {
        let aluno = this.create();
        return JSON.stringify(aluno);
    }


}