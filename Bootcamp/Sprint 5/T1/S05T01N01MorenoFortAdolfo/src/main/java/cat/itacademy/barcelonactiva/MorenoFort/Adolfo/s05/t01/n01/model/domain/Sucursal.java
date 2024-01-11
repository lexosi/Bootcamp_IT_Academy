package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_SucursalID;
    private String nombreSucursal;
    private String paisSucursal;

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }
    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }
    public String getNombreSucursal() {
        return nombreSucursal;
    }
    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
    public String getPaisSucursal() {
        return paisSucursal;
    }
    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
    
}
