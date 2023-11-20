package med.voll.api.medic;

import med.voll.api.endereco.EnderecoDados;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, EnderecoDados endereco){
}
