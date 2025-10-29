package ar.edu.unahur.obj2.cazador;

import ar.edu.unahur.obj2.profugo.Iprofugo;
import ar.edu.unahur.obj2.profugo.Profugo;

public class CazadorRural extends Cazador {

    public CazadorRural(String nombre, Integer experiencia) {
        super(nombre, experiencia);
    }

    @Override
    protected Boolean condicionEspecifica(Iprofugo profugo) {
        return profugo.esNervioso();
    }

    @Override
    protected void consecuenciaIntimidacionSegunTipo(Iprofugo profugo) {
        profugo.volverseNervioso();
    }

}
