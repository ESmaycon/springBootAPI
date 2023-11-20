package med.voll.api.controller;

import med.voll.api.medic.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @PostMapping
    public void register(@RequestBody DadosCadastroMedico dados){

        System.out.println(dados);
    }
}
