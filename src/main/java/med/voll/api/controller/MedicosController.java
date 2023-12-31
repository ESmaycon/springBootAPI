package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DadosCadastroMedico dados){

        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<ListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
       return repository.findAllByAtivoTrue(pageable).map(ListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarDadosMedicos dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
