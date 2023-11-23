package med.voll.api.medic;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.Endereco;
import med.voll.api.endereco.EnderecoDados;

public record AtualizarDadosMedicos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDados endereco) {

}
