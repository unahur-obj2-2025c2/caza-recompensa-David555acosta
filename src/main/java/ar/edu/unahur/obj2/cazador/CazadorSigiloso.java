package ar.edu.unahur.obj2.cazador;

import ar.edu.unahur.obj2.profugo.Iprofugo;
import ar.edu.unahur.obj2.profugo.Profugo;

public class CazadorSigiloso extends Cazador {

    public CazadorSigiloso(String nombre, Integer experiencia) {
        super(nombre, experiencia);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Boolean condicionEspecifica(Iprofugo profugo) {
        return profugo.getHabilidad() < 50;
    }

    @Override
    protected void consecuenciaIntimidacionSegunTipo(Iprofugo profugo) {
        profugo.reducirHabilidad();
    }

}
