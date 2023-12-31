package med.voll.api.paciente;

public record ListagemPacientes(Long id ,String nome, String email, String cpf, String telefone) {
    public ListagemPacientes(Paciente paciente){
        this(paciente.getId(),paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
