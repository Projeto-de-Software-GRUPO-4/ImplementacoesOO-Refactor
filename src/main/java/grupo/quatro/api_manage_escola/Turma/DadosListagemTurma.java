package grupo.quatro.api_manage_escola.Turma;

public record DadosListagemTurma(int anoEscolar, String letra) {
    public DadosListagemTurma(Turma turma) {
        this(turma.getAnoEscolar(), turma.getLetra());
    }

}
