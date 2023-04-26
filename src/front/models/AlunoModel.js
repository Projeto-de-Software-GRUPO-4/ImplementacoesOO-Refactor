class Aluno extends Usuario {

    turma
    responsavel
    anoEscolar
    mensalidade
    suspenso

    constructor(
        nome, cpf, dataDeNascimento, 
        diaDePagamento, turma, responsavel, 
        anoEscolar, mensalidade, suspenso, senha
    ) {
        super(nome, cpf, 
            dataDeNascimento != null ?
            DateHelper.stringToFormattedString(dataDeNascimento)
            :
            dataDeNascimento, 
            parseInt(diaDePagamento), senha, "Aluno");
        this.turma = turma;
        this.responsavel = responsavel;
        this.anoEscolar = parseInt(anoEscolar);
        this.mensalidade = parseFloat(mensalidade);
        this.suspenso = suspenso;
    }


}