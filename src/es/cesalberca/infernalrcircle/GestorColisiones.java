package es.cesalberca.infernalrcircle;


/**
 * Created by Cesar
 */
public class GestorColisiones {
    public static boolean hayColision(Nave nave, Asteroide asteroide) {
        int dx = asteroide.getPosX() - nave.getPosX();
        int dy = asteroide.getPosY() - nave.getPosY();
        int distancia = (int) Math.sqrt(dx * dx + dy * dy);

        if (distancia < Nave.MAX_RADIO_NAVE + Asteroide.MAX_RADIO_ASTEROIDE - 20) {
            return true;
        } else {
            return false;
        }
    }
}
