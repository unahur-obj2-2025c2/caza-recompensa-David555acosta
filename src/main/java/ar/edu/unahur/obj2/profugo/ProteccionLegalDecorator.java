package ar.edu.unahur.obj2.profugo;

public class ProteccionLegalDecorator extends ProfugoDecorator {

    public ProteccionLegalDecorator(Iprofugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getNivelDeInosencia() {
        return Math.max(profugo.getNivelDeInosencia(), 40);
    }
}
