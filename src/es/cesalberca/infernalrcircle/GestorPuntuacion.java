package es.cesalberca.infernalrcircle;

/**
 * Created by Cesar
 */
class GestorPuntuacion {
    private static int puntuacion = 0;

    static void sumarPuntos() {
        puntuacion++;
    }

    static int getPuntuacion() {
        return puntuacion;
    }
}
