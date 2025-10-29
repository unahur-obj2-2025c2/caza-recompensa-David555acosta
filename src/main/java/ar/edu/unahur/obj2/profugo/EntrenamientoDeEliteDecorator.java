package ar.edu.unahur.obj2.profugo;

public class EntrenamientoDeEliteDecorator extends ProfugoDecorator {

    public EntrenamientoDeEliteDecorator(Iprofugo profugo) {
        super(profugo);

    }

    @Override
    public Boolean esNervioso() {
        return Boolean.FALSE;
    }

}
