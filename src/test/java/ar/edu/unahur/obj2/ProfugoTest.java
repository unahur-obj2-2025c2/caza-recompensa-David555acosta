package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cazador.CazadorRural;
import ar.edu.unahur.obj2.cazador.CazadorSigiloso;
import ar.edu.unahur.obj2.cazador.CazadorUrbano;
import ar.edu.unahur.obj2.profugo.ArteMarcialDecorator;
import ar.edu.unahur.obj2.profugo.EntrenamientoDeEliteDecorator;
import ar.edu.unahur.obj2.profugo.Iprofugo;
import ar.edu.unahur.obj2.profugo.Profugo;
import ar.edu.unahur.obj2.profugo.ProteccionLegalDecorator;

public class ProfugoTest {
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

    @BeforeEach
    public void setUp() {

        profugoA = new Profugo(20, 30, true);

        profugoB = new Profugo(30, 50, false);

        profugoC = new Profugo(60, 100, true);

        profugoD = new Profugo(0, 100, true);

        profugoE = new Profugo(0, 80, true);

        conArtesMarciales = new ArteMarcialDecorator(profugoC);

        conEntrenamientoDeElite = new EntrenamientoDeEliteDecorator(profugoA);

        conProteccionLegal = new ProteccionLegalDecorator(profugoD);
    }

    @Test
    void pruebaBasica() {
        assertTrue(profugoA.esNervioso().equals(Boolean.TRUE));
        assertTrue(profugoA.getHabilidad().equals(30));
        assertTrue(profugoA.getNivelDeInosencia().equals(20));
        assertEquals(30, profugoA.getHabilidad());
    }

    @Test
    void dadoUnProfugoRecibeEntrenamientoDeEliteYDejaDeEstarNervioso() {
        assertTrue(profugoA.esNervioso().equals(Boolean.TRUE));
        assertTrue(conEntrenamientoDeElite.esNervioso().equals(Boolean.FALSE));
        assertEquals(30, conEntrenamientoDeElite.getHabilidad());
    }

    @Test
    void dadoUnProfugoRecibeEntrenamientoDeEliteYArtesMarciales() {
        assertTrue(profugoA.esNervioso().equals(Boolean.TRUE));
        assertTrue(conEntrenamientoDeElite.esNervioso().equals(Boolean.FALSE));

        ArteMarcialDecorator profugoConArteMarcialYEntrenamientoDeElite = new ArteMarcialDecorator(
                conEntrenamientoDeElite);

        assertEquals(Boolean.FALSE, profugoConArteMarcialYEntrenamientoDeElite.esNervioso());

        assertEquals(60, profugoConArteMarcialYEntrenamientoDeElite.getHabilidad());
    }

    @Test
    void dadoUnProfugoRecibeEntrenamientoDeEliteArtesMarcialesYProteccionLegal() {
        Iprofugo profugoScope = new Profugo(20, 70, true);

        EntrenamientoDeEliteDecorator profugoScopeRecibeEntrenamientoDeElite = new EntrenamientoDeEliteDecorator(
                profugoScope);

        ArteMarcialDecorator profugoConEntrenamientoDeEliteRecibeArtesMarciales = new ArteMarcialDecorator(
                profugoScopeRecibeEntrenamientoDeElite);

        ProteccionLegalDecorator profugoConEntrenamientoYArtesMarcialesRecibeProteccionLegal = new ProteccionLegalDecorator(
                profugoConEntrenamientoDeEliteRecibeArtesMarciales);

        assertEquals(Boolean.FALSE, profugoConEntrenamientoYArtesMarcialesRecibeProteccionLegal.esNervioso());

        assertEquals(100, profugoConEntrenamientoYArtesMarcialesRecibeProteccionLegal.getHabilidad());

        assertEquals(40, profugoConEntrenamientoYArtesMarcialesRecibeProteccionLegal.getNivelDeInosencia());
    }
}
