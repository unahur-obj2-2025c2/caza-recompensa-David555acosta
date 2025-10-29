package ar.edu.unahur.obj2.Zona;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.profugo.Iprofugo;

public class Zona {
    private String nombre;
    private Set<Iprofugo> profugos = new HashSet<>();

    public Zona(String nombre, Set<Iprofugo> profugos) {
        this.nombre = nombre;
        this.profugos = profugos;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Iprofugo> getProfugos() {
        return profugos;
    }

    public void agregarProfugo(Iprofugo profugo) {
        profugos.add(profugo);
    }

    public void eliminarProfugo(Iprofugo profugo) {
        profugos.remove(profugo);
    }

}
