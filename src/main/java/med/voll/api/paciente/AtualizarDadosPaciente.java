package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoDados;

public record AtualizarDadosPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDados endereco
    ) {
}
