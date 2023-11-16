package med.voll.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @PostMapping
    public void register(@RequestBody String json){
        System.out.println(json);
    }
}
