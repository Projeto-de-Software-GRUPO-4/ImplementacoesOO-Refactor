class Usuario {
    id
    nome 
    cpf
    dataDeNascimento
    diaDePagamento 
    senha
    userType

    constructor(nome, cpf, dataDeNascimento, diaDePagamento, senha, userType) {
        this.nome = nome; 
        this.cpf = cpf;
        this.id = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.diaDePagamento = diaDePagamento;
        this.senha = senha;
        this.userType = userType;
    }

    // Getters

    get nome() {
        return this.nome; 
    }

    get cpf() {
        return this.cpf; 
    }

    get dataDeNascimento() {
        return this.dataDeNascimento;
    }

    get diaDePagamento() {
        return this.diaDePagamento;
    }

    // Setters

    set nome(nome) {
        this.nome = nome; 
    }

    set cpf(cpf) {
        this.cpf = cpf; 
    }

    set dataDeNascimento(dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    set diaDePagamento(diaDePagamento) {
        this.diaDePagamento = diaDePagamento;
    }
}