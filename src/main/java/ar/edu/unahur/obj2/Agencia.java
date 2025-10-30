package ar.edu.unahur.obj2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.Zona.Zona;
import ar.edu.unahur.obj2.cazador.Cazador;
import ar.edu.unahur.obj2.profugo.Iprofugo;

public class Agencia {
    private Set<Iprofugo> totalProfugosCapturados = new HashSet<>();
    private Set<Cazador> cazadoresAgencia = new HashSet<>();

    public Agencia(Set<Cazador> cazadoresAgencia) {
        this.cazadoresAgencia = cazadoresAgencia;
    }

    public void agregarCazador(Cazador cazador) {
        cazadoresAgencia.add(cazador);
    }

    public void eliminarCazador(Cazador cazador) {
        cazadoresAgencia.remove(cazador);
    }

    public void realizarProcesoCaptura(Cazador cazador, Zona zona) {
        cazador.realizarProcesoCaptura(zona);
    }

    public Set<Iprofugo> todosLosProfugosCapturados() {
        return (Set<Iprofugo>) cazadoresAgencia.stream().flatMap(cazador -> cazador.getProfugosCapturados().stream())
                .collect(Collectors.toList());
    }

    public Optional<Iprofugo> profugoMasHabilCapturado() {
        return this.todosLosProfugosCapturados().stream().max(Comparator.comparing(Iprofugo::getHabilidad));
    }

    public Optional<Cazador> cazadorConMasCapturas() {
        return Optional
                .ofNullable(cazadoresAgencia.stream().filter(cazador -> !cazador.getProfugosCapturados().isEmpty())
                        .max(Comparator.comparingInt(cazador -> cazador.getProfugosCapturados().size()))
                        .orElseThrow(() -> new IllegalStateException("No hay profugos capturados")));
    }

}
