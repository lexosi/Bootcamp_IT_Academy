package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01GognomsNom.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.model.repository.FrutaRepository;

public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;

    // métodos para agregar, actualizar, eliminar y obtener frutas
}