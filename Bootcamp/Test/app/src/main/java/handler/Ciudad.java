package handler;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    String nombre;
    List<AbstractNPC> npcs = new ArrayList<>();
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<AbstractNPC> getNpcs() {
        return npcs;
    }
    public void setNpcs(List<AbstractNPC> npcs) {
        this.npcs = npcs;
    }
    public Ciudad(String nombre, List<AbstractNPC> npcs) {
        this.nombre = nombre;
        this.npcs = npcs;
    }

    
}
