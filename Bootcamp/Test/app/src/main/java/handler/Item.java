package handler;

public class Item {
    String nombre;
    String tipo;
    double precio;
    double desgaste;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getDesgaste() {
        return desgaste;
    }
    public void setDesgaste(double desgaste) {
        this.desgaste = desgaste;
    }
    public Item(String nombre, String tipo, double precio, double desgaste) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.desgaste = desgaste;
    }

    
}
