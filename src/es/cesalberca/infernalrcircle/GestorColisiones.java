package es.cesalberca.infernalrcircle;


/**
 * Created by Cesar
 */
class GestorColisiones {
    static boolean hayColision(Nave nave, Asteroide asteroide) {
        int dx = asteroide.getPosX() - nave.getPosX();
        int dy = asteroide.getPosY() - nave.getPosY();
        int distancia = (int) Math.sqrt(dx * dx + dy * dy);

        return distancia < Nave.MAX_RADIO_NAVE + Asteroide.MAX_RADIO_ASTEROIDE - 20;
    }
}
