package es.cesalberca.infernalrcircle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar
 */
public interface Sujeto {
    List<Observador> observadores = new ArrayList<>();

    default void registrarObservador(Observador observador) {
        observadores.add(observador);
    }

    default void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    default void notificarObservadores() {
        observadores.forEach(observador -> observador.actualizar());
    }
}
