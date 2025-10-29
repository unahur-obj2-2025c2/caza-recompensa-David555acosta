package ar.edu.unahur.obj2.profugo;

public class Profugo implements Iprofugo {
    private Integer nivelDeInosencia;
    private Integer nivelDeHabilidad;
    private Boolean esNervioso;

    public Profugo(Integer inocencia, Integer habilidad, Boolean esNervioso) {
        if (habilidad <= 0 || habilidad > 100)
            throw new IllegalArgumentException("La habilidad es un valor entre 1 y 100");
        this.nivelDeInosencia = inocencia;
        this.nivelDeHabilidad = habilidad;
        this.esNervioso = esNervioso;
    }

    @Override
    public Integer getHabilidad() {
        return this.nivelDeHabilidad;
    }

    @Override
    public Integer getNivelDeInosencia() {
        return this.nivelDeInosencia;
    }

    @Override
    public Boolean esNervioso() {
        return this.esNervioso;
    }

    @Override
    public void volverseNervioso() {
        this.esNervioso = Boolean.TRUE;
    }

    @Override
    public void dejarDeEstarNervioso() {
        this.esNervioso = Boolean.FALSE;
    }

    @Override
    public void reducirHabilidad() {
        this.nivelDeHabilidad -= 5;
    }

    @Override
    public void disminuirInocencia() {
        this.nivelDeInosencia -= 2;
    }
}
