package es.cesalberca.infernalrcircle;

/**
 * Created by Cesar
 */
public class GestorPuntuacion {
    private static int puntuacion = 0;

    public static void sumarPuntos() {
        puntuacion++;
    }

    public static int getPuntuacion() {
        return puntuacion;
    }
}
