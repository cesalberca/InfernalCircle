package es.cesalberca.infernalrcircle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar
 */
public abstract class ObjetoVolador implements Sujeto {
    final private int centroX;
    final private int centroY;

    private int posX;
    private int posY;
    private int distanciaDelCentro;
    private int angulo;
    private int dir;
    private boolean estaVivo;

    ObjetoVolador(int centroX, int centroY, int angulo, int distanciaDelCentro) {
        this.centroX = centroX;
        this.centroY = centroY;
        this.posX = centroX;
        this.posY = centroY;
        this.angulo = angulo;
        this.distanciaDelCentro = distanciaDelCentro;
        this.dir = 1;
        this.estaVivo = true;

        List<Observador> observadores = new ArrayList<>();
    }

    public abstract void mover();

    double cos(int angulo) {
        return Math.cos(Math.toRadians(angulo));
    }

    double sin(int angulo) {
        return Math.sin(Math.toRadians(angulo));
    }

    void cambiarDireccion(int nuevaDireccion) {
        if (nuevaDireccion != this.dir) this.dir *= -1;
    }

    int getCentroX() {
        return centroX;
    }

    int getCentroY() {
        return centroY;
    }

    int getPosX() {
        return posX;
    }

    int getPosY() {
        return posY;
    }

    void setPosX(int posX) {
        this.posX = posX;
    }

    void setPosY(int posY) {
        this.posY = posY;
    }

    void setDistanciaDelCentro(int distanciaDelCentro) {
        this.distanciaDelCentro = distanciaDelCentro;
    }

    int getDistanciaDelCentro() {
        return distanciaDelCentro;
    }

    int getAngulo() {
        return angulo;
    }

    void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    int getDir() {
        return dir;
    }

    boolean estaVivo() {
        return estaVivo;
    }

    void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    @Override
    public String toString() {
        return "ObjetoVolador{" +
                "centroX=" + centroX +
                ", centroY=" + centroY +
                ", posX=" + posX +
                ", posY=" + posY +
                ", distanciaDelCentro=" + distanciaDelCentro +
                ", angulo=" + angulo +
                '}';
    }
}
