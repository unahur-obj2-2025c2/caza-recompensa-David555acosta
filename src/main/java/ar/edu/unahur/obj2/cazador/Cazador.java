package ar.edu.unahur.obj2.cazador;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import ar.edu.unahur.obj2.Zona.Zona;
import ar.edu.unahur.obj2.profugo.Iprofugo;

public abstract class Cazador {
    private String nombre;
    private Integer experiencia;
    private Set<Iprofugo> profugosCapturados = new HashSet<>();
    private Set<Iprofugo> profugosIntimidados = new HashSet<>();

    public Cazador(String nombre, Integer experiencia) {
        this.nombre = nombre;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public Set<Iprofugo> getProfugosCapturados() {
        return profugosCapturados;
    }

    public Set<Iprofugo> getProfugosIntimidados() {
        return profugosIntimidados;
    }

    public void realizarProcesoCaptura(Zona zona) {
        Set<Iprofugo> profugosACapturar = new HashSet<>(zona.getProfugos());

        profugosACapturar.stream()
                .forEach(profugoRecorrido -> this.evaluarSiCapturarOIntimidar(zona, profugoRecorrido));
    }

    private void evaluarSiCapturarOIntimidar(Zona zona, Iprofugo profugo) {
        if (this.cumpleCondicionesDeCaptura(profugo)) {
            this.capturar(zona, profugo);
        } else {
            this.intimidar(profugo);
        }
    }

    // Acciones
    public void capturar(Zona zona, Iprofugo profugo) {
        this.profugosCapturados.add(profugo);
        zona.eliminarProfugo(profugo);
    }

    private void intimidar(Iprofugo profugo) {
        profugo.disminuirInocencia();
        this.consecuenciaIntimidacionSegunTipo(profugo);
        this.profugosIntimidados.add(profugo);
    }

    // Accion template method
    protected abstract void consecuenciaIntimidacionSegunTipo(Iprofugo profugo);

    // Evaluaciones
    private Boolean condicionGeneral(Iprofugo profugoX) {
        return this.experiencia > profugoX.getNivelDeInosencia();
    }

    // Evaluacion templateMethod
    protected abstract Boolean condicionEspecifica(Iprofugo profugo);

    // Evaluacion entre 2 condiciones
    public Boolean cumpleCondicionesDeCaptura(Iprofugo profugo) {
        return this.condicionGeneral(profugo) && this.condicionEspecifica(profugo);
    }

    private void SumarExperiencia(Set<Iprofugo> intimidados) {
        Optional<Integer> minimaHabilidadEntreIntimidados = encontrarminimaHabilidadEntreLosIntimidados(
                intimidados);

        experiencia += minimaHabilidadEntreIntimidados.isPresent() ? minimaHabilidadEntreIntimidados.get()
                : 0 + 2 * profugosCapturados.size();
    }

    private Optional<Integer> encontrarminimaHabilidadEntreLosIntimidados(Set<Iprofugo> intimidados) {
        return intimidados.stream().map(Iprofugo::getHabilidad).min(Comparator.naturalOrder());
    }

}