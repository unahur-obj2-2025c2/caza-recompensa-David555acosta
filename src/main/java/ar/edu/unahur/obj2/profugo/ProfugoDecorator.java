package ar.edu.unahur.obj2.profugo;

public abstract class ProfugoDecorator implements Iprofugo {
    protected Iprofugo profugo;

    public ProfugoDecorator(Iprofugo profugo) {
        this.profugo = profugo;
    }

    @Override
    public Integer getNivelDeInosencia() {
        return profugo.getNivelDeInosencia();
    }

    @Override
    public Integer getHabilidad() {
        return profugo.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return profugo.esNervioso();
    }

    @Override
    public void volverseNervioso() {
        profugo.volverseNervioso();
    }

    @Override
    public void dejarDeEstarNervioso() {
        profugo.dejarDeEstarNervioso();
    }

    @Override
    public void reducirHabilidad() {
        profugo.reducirHabilidad();
    }

    @Override
    public void disminuirInocencia() {
        profugo.disminuirInocencia();
        ;
    }
}
