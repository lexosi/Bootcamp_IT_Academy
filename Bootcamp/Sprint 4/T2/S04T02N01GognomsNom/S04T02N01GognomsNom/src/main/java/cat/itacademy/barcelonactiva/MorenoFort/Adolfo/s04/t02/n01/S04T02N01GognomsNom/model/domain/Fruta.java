package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s04.t02.n01.S04T02N01GognomsNom.model.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Fruta {

    @org.springframework.data.annotation.Id
    private int id;
    private String nombre;
    private Integer cantidadQuilos;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCantidadQuilos() {
        return cantidadQuilos;
    }
    public void setCantidadQuilos(Integer cantidadQuilos) {
        this.cantidadQuilos = cantidadQuilos;
    }
   
}