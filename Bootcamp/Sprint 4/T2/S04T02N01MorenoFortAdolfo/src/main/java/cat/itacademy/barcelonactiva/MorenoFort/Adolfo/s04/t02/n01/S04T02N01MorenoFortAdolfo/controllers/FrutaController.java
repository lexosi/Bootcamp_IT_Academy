package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.domain.Fruta;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.services.FrutaService;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @PostMapping
    public Fruta createFruta(@RequestBody Fruta fruta) {
        return frutaService.add(fruta);
    }

    @GetMapping
    public List<Fruta> getAllFrutas() {
        return frutaService.getAll();
    }

    @Deprecated
    @GetMapping("/{id}")
    public ResponseEntity<Fruta> getFrutaById(@PathVariable int id) {
        Fruta fruta = frutaService.getOne(id);
        if (fruta != null) {
            return ResponseEntity.ok(fruta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Deprecated
    @PutMapping("/{id}")
    public Fruta updateFruta(@PathVariable int id, @RequestBody Fruta frutaDetails) {
        Fruta fruta = frutaService.getOne(id);
        if (fruta != null) {
            fruta.setNombre(frutaDetails.getNombre());
            fruta.setCantidadQuilos(frutaDetails.getCantidadQuilos());
            return frutaService.update(fruta);
        } else {
            return null;
        }

   
    }

    
}
