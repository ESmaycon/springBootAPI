package med.voll.api.paciente;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medic.AtualizarDadosMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<ListagemPacientes> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable).map(ListagemPacientes::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarDadosPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInfo(dados);
    }
}
