package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01GognomsNom.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fruta {

    @Id
    private int id;
    private String nombre;
    private Integer cantidadQuilos;

    // getters y setters
}