package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.domain.Fruta;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.repository.FrutaRepository;

@Service
public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;
    
     public Fruta add(Fruta fruta) {
        return frutaRepository.save(fruta);
        }

        public Fruta update(Fruta fruta) {
            return frutaRepository.save(fruta);
        }

        public void delete(int id) {
            frutaRepository.deleteById(id);
        }

        @Deprecated
        public void getOne (int id) {
            frutaRepository.getOne(id);
        }

        public List<Fruta> getAll () {
            return frutaRepository.findAll();
        }
    }

