package ar.edu.unahur.obj2.profugo;

public class ArteMarcialDecorator extends ProfugoDecorator {
    public ArteMarcialDecorator(Iprofugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getHabilidad() {
        return Math.min(100, profugo.getHabilidad() * 2);
    }
}
