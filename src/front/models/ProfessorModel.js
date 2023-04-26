class Professor extends Usuario {
    
    telefone
    salarioHora
    cargaHorariaDiaria

    constructor(
        nome, cpf, dataDeNascimento, 
        diaDePagamento, salarioHora, cargaHorariaDiaria, 
        telefone, senha
    ) {
        super(nome, cpf, 
            dataDeNascimento != null ?
            DateHelper.stringToFormattedString(dataDeNascimento)
            :
            dataDeNascimento, 
            parseInt(diaDePagamento), senha, "Professor");
        this.salarioHora = parseFloat(salarioHora);
        this.cargaHorariaDiaria = parseInt(cargaHorariaDiaria);
        this.telefone = telefone;
    }
}