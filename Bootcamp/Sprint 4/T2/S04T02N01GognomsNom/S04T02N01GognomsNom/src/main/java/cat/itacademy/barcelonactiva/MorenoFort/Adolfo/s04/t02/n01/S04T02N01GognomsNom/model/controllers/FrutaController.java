package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01GognomsNom.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/fruita")
public class FrutaController {

    @Autowired
    private cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01GognomsNom.model.services.FrutaService frutaService;

    // métodos para manejar las peticiones
}