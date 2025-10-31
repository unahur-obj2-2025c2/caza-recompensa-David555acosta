package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

public class AgenciaTest {
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
    Iprofugo profugoF;
    Iprofugo profugoG;

    Iprofugo conArtesMarciales;
    Iprofugo conProteccionLegal;
    Iprofugo conEntrenamientoDeElite;

    Zona zona1;
    Zona zona2;

    Agencia agencia;

    @BeforeEach
    public void setUp() {
        cazadorRural1 = new CazadorRural("David", 50);

        cazadorRural2 = new CazadorRural("Pepe", 20);

        cazadorSigiloso1 = new CazadorSigiloso("Rogelio", 60);

        cazadorSigiloso2 = new CazadorSigiloso("Raul", 70);

        cazadorUrbano1 = new CazadorUrbano("Luis", 90);

        cazadorUrbano2 = new CazadorUrbano("Juan", 100);

        ///// Profugos

        profugoA = new Profugo(20, 30, true);

        profugoB = new Profugo(30, 50, false);

        profugoC = new Profugo(60, 100, true);

        profugoD = new Profugo(0, 100, true);

        profugoE = new Profugo(0, 80, true);

        profugoF = new Profugo(50, 70, true);

        profugoG = new Profugo(40, 50, false);

        conArtesMarciales = new ArteMarcialDecorator(profugoA);

        conEntrenamientoDeElite = new EntrenamientoDeEliteDecorator(profugoC);

        conProteccionLegal = new ProteccionLegalDecorator(profugoD);

        // Zonas

        zona1 = new Zona("Zona1");
        zona2 = new Zona("Zona2");

        zona1.agregarProfugo(conArtesMarciales);
        zona1.agregarProfugo(profugoB);
        zona1.agregarProfugo(conEntrenamientoDeElite);

        zona2.agregarProfugo(profugoE);
        zona2.agregarProfugo(conProteccionLegal);
        zona2.agregarProfugo(profugoF);
        zona2.agregarProfugo(profugoG);

        agencia = new Agencia();
        agencia.agregarCazador(cazadorRural1);
        agencia.agregarCazador(cazadorUrbano2);
    }

    @Test
    void pruebaBasica() {
        agencia.realizarProcesoCaptura(cazadorRural1, zona1);
        agencia.realizarProcesoCaptura(cazadorUrbano2, zona2);

        // CazadorRural1: Experiencia : 50

        // Zona1 Profugos:

        // ConArtesMarciales : inosencia 20 , habilidad 60 , EsNervioso

        // Profugo B : inosencia 30 , habilidad 50 , noEsNervioso

        // ConEntrenamientoDeElite: inosencia 60 , habilidad 100 , noEsNervioso

        // CazadorRural : Capturados = 1



        // CazadorUrbano2: Experiencia = 100

        // Zona 2 Profugos:

        // ProfugoE , Inosencia 0 , habilidad 80 , esNervioso

        // ConProteccionLegal Inosencia 40 , habilidad 100 , esNervioso

        // ProfugoF inosencia 50 , habilidad 70 , esNervioso

        assertEquals(2, agencia.todosLosProfugosCapturados().size());
    }

}
