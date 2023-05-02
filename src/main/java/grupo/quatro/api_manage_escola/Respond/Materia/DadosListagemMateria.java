package grupo.quatro.api_manage_escola.Respond.Materia;

import grupo.quatro.api_manage_escola.Domain.Materia;

import java.math.BigInteger;

public record DadosListagemMateria(
        BigInteger id,
        String titulo


) {

    public DadosListagemMateria(Materia materia) {
        this(materia.getId(), materia.getTitulo());
    }

}
