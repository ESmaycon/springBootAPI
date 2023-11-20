package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.medic.DadosCadastroMedico;
import med.voll.api.medic.Medico;
import med.voll.api.medic.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void register(@RequestBody DadosCadastroMedico dados){

        repository.save(new Medico(dados));
    }
}
