package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.domain.Fruta;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.repository.FrutaRepository;

@Service
public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;

    // Métodos para agregar, actualizar, eliminar y obtener frutas
}