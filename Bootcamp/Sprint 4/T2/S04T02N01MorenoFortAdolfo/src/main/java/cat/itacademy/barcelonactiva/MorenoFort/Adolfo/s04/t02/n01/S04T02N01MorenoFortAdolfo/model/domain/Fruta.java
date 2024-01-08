package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01MorenoFortAdolfo.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private int cantidadQuilos;

    // Getters y setters
}
