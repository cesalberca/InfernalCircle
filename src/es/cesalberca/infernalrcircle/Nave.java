package es.cesalberca.infernalrcircle;

import java.util.ArrayList;

/**
 * Created by Cesar
 */
public class Nave extends ObjetoVolador implements Runnable {

    public static int MAX_RADIO_NAVE = 40;

    private ArrayList<Observador> observadores;

    public Nave(int centroX, int centroY, int angulo, int radio) {
        super(centroX, centroY, angulo, radio);

        observadores = new ArrayList<>();
    }

    @Override
    public void mover() {
        setPosX(this.moverPosY(getAngulo()));
        setPosY(this.moverPosX(getAngulo()));

        if (getAngulo() % 360 == 0)
            setAngulo(0);

        if (getDir() == 1)
            setAngulo(getAngulo() + 1);
        else if (getDir() == -1)
            setAngulo(getAngulo() - 1);

        this.notificarObservadores();
    }

    private int moverPosX(int angulo) {
        return (int) (getCentroX() + (getDistanciaDelCentro() * cos(angulo)));
    }

    private int moverPosY(int angulo) {
        return (int) (getCentroY() + (getDistanciaDelCentro() * sin(angulo)));
    }

    @Override
    public void run() {
        while (estaVivo()) {
            try {
                mover();
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
