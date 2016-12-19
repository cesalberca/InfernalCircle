package es.cesalberca.infernalrcircle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar
 */
public class Asteroide extends ObjetoVolador implements Sujeto, Runnable {

    private Nave nave;

    public static final int MAX_RADIO_ASTEROIDE = 40;
    public static final int NUM_MAX_ASTEROIDES = 60;
    public static final int MAX_RADIO = 1200;
    public static final int MIN_RADIO = 400;

    private List<Observador> observadores;

    public Asteroide(int centroX, int centroY, int angulo, int radio, Nave nave) {
        super(centroX, centroY, angulo, radio);

        this.nave = nave;
        observadores = new ArrayList<>();
    }

    @Override
    public void mover() {
        if (getDistanciaDelCentro() > 0) {
            setDistanciaDelCentro(getDistanciaDelCentro() - 1);
            setPosX(this.moverPosY(getAngulo()));
            setPosY(this.moverPosX(getAngulo()));
        } else {
            int nuevaDistanciaDelCentro = (int) (Math.random() * MIN_RADIO);
            setDistanciaDelCentro(nuevaDistanciaDelCentro);
        }

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

                if(GestorColisiones.hayColision(nave,this)) {
                    setEstaVivo(false);
                    GestorPuntuacion.sumarPuntos();
                }

                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
