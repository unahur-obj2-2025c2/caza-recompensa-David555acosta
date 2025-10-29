package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Zona.Zona;
import ar.edu.unahur.obj2.cazador.CazadorRural;
import ar.edu.unahur.obj2.cazador.CazadorSigiloso;
import ar.edu.unahur.obj2.cazador.CazadorUrbano;
import ar.edu.unahur.obj2.profugo.ArteMarcialDecorator;
import ar.edu.unahur.obj2.profugo.EntrenamientoDeEliteDecorator;
import ar.edu.unahur.obj2.profugo.Iprofugo;
import ar.edu.unahur.obj2.profugo.Profugo;
import ar.edu.unahur.obj2.profugo.ProteccionLegalDecorator;

public class CazadorTest {
    CazadorRural cazadorRural1;
    CazadorRural cazadorRural2;

    CazadorSigiloso cazadorSigiloso1;
    CazadorSigiloso cazadorSigiloso2;

    CazadorUrbano cazadorUrbano1;
    CazadorUrbano cazadorUrbano2;

    Iprofugo profugoA;
    Iprofugo profugoB;
    Iprofugo profugoC;
    Iprofugo profugoD;
    Iprofugo profugoE;

    Iprofugo conArtesMarciales;
    Iprofugo conProteccionLegal;
    Iprofugo conEntrenamientoDeElite;

    Zona zona1;
    Zona zona2;

    @BeforeEach
    public void setUp() {
        cazadorRural1 = new CazadorRural("David", 50);

        cazadorRural2 = new CazadorRural("Pepe", 20);

        cazadorSigiloso1 = new CazadorSigiloso("Rogelio", 60);

        cazadorSigiloso2 = new CazadorSigiloso("Raul", 70);

        cazadorUrbano1 = new CazadorUrbano("Luis", 90);

        cazadorUrbano2 = new CazadorUrbano("Juan", 100);

        profugoA = new Profugo(20, 30, true);

        profugoB = new Profugo(30, 50, false);

        profugoC = new Profugo(60, 100, true);

        profugoD = new Profugo(0, 100, true);

        profugoE = new Profugo(0, 80, true);

        conArtesMarciales = new ArteMarcialDecorator(profugoA);

        conEntrenamientoDeElite = new EntrenamientoDeEliteDecorator(profugoC);

        conProteccionLegal = new ProteccionLegalDecorator(profugoD);

        zona1 = new Zona("Zona1");
        zona2 = new Zona("Zona2");

        zona1.agregarProfugo(conArtesMarciales);
        zona1.agregarProfugo(profugoB);
        zona1.agregarProfugo(conEntrenamientoDeElite);

        zona2.agregarProfugo(profugoE);
        zona2.agregarProfugo(conProteccionLegal);

    }

    @Test
    void pruebaBasica() {
        assertEquals("David", cazadorRural1.getNombre());
        assertEquals(0, cazadorRural1.getProfugosCapturados().size());
    }
}
