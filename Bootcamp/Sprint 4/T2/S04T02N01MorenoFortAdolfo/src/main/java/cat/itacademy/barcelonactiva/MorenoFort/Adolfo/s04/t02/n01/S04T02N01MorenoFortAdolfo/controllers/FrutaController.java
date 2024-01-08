package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.model.services.FrutaService;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    // Métodos para manejar las peticiones HTTP
}