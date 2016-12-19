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

    private List<Observador> observadores;

    public ObjetoVolador(int centroX, int centroY, int angulo, int distanciaDelCentro) {
        this.centroX = centroX;
        this.centroY = centroY;
        this.posX = centroX;
        this.posY = centroY;
        this.angulo = angulo;
        this.distanciaDelCentro = distanciaDelCentro;
        this.dir = 1;
        this.estaVivo = true;

        observadores = new ArrayList<>();
    }

    public abstract void mover();

    public double cos(int angulo) {
        return Math.cos(Math.toRadians(angulo));
    }

    public double sin(int angulo) {
        return Math.sin(Math.toRadians(angulo));
    }

    public void cambiarDireccion(int nuevaDireccion) {
        if (nuevaDireccion != this.dir) this.dir *= -1;
    }

    public int getCentroX() {
        return centroX;
    }

    public int getCentroY() {
        return centroY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setDistanciaDelCentro(int distanciaDelCentro) {
        this.distanciaDelCentro = distanciaDelCentro;
    }

    public int getDistanciaDelCentro() {
        return distanciaDelCentro;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public int getDir() {
        return dir;
    }

    public boolean estaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
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
