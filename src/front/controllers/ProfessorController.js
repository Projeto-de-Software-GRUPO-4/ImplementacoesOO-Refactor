class ProfessorController extends UsuarioController {

    telefone = document.querySelector("input[id='telefone']")
    salarioHora = document.querySelector("input[id='mensalidade']")
    cargaHorariaDiaria = document.querySelector("input[id='cargaHoraria']")

    constructor() {
        super();
        // this.telefone = document.querySelector("input[id='telefone']");
        // this.salarioHora = document.querySelector("input[id='mensalidade']");
        // this.telefone = document.querySelector("input[id='cargaHoraria']");
    }

    create() {
        return new Professor(
            this.nome?.value, this.cpf?.value,
            this.dataDeNascimento?.value, this.diaDePagamento?.value,
            this.salarioHora?.value, this.cargaHorariaDiaria?.value,
            this.telefone?.value, this.senha?.value
        );

    }
    
    createAsJson() {
        let professor = this.create();
        return JSON.stringify(professor);
    }

}