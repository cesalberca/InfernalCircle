package es.cesalberca.infernalrcircle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar
 */
public class Juego extends JFrame implements Observador {
    private JPanel jpJuego;
    private JPanel jpControles;
    private JPanel jpCanvas;
    private JButton jbIzq;
    private JButton jbDcha;
    private JButton jbNave;
    private JLabel jlPuntuacion;
    private JLabel jlTiempo;

    Temporizador temporizador;

    private Nave nave;
    private List<Asteroide> asteroides;
    private List<JButton> jbAsteroides;

    public Juego() {
        this.setTitle("Círculo Infernal");
        this.setPreferredSize(new Dimension(1200, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jbIzq.addActionListener(e -> nave.cambiarDireccion(1));
        jbDcha.addActionListener(e -> nave.cambiarDireccion(-1));

        this.add(jpJuego);
        this.pack();
        this.setVisible(true);

        comenzarJuego();
    }

    public void comenzarJuego() {

        temporizador = new Temporizador();
        temporizador.comenzar();

        jbAsteroides = new ArrayList<>();
        asteroides = new ArrayList<>();

        nave = new Nave(0, 0, 90, 100);
        nave.registrarObservador(this);

        JButton asteroideACrear;
        for (int i = 0; i < Asteroide.NUM_MAX_ASTEROIDES; i++) {
            asteroides.add(new Asteroide(0, 0, 30 * i, (int) (Math.random() * (Asteroide.MAX_RADIO - Asteroide.MIN_RADIO) + Asteroide.MIN_RADIO), nave));
            asteroides.get(i).registrarObservador(this);

            asteroideACrear = new JButton("*");
            jbAsteroides.add(asteroideACrear);
            jpControles.setLayout(null);
            jpControles.add(asteroideACrear);
        }

        Thread tNave = new Thread(nave);
        tNave.start();

        Thread tAsteroide;
        for (Asteroide asteroide : asteroides) {
            tAsteroide = new Thread(asteroide);
            tAsteroide.start();
        }
    }

    private int getAnchoPantalla() {
        return (int) this.getContentPane().getSize().getWidth() / 2;
    }

    private int getAltoPantalla() {
        return (int) this.getContentPane().getSize().getHeight() / 2;
    }

    public void setPosicionNave() {
        jbNave.setBounds(
                nave.getPosX() + getAnchoPantalla(),
                nave.getPosY() + getAltoPantalla(),
                Nave.MAX_RADIO_NAVE,
                Nave.MAX_RADIO_NAVE
        );
    }

    public void setPosicionAsteroides() {
        for (int i = 0; i < asteroides.size(); i++) {

            if (!asteroides.get(i).estaVivo())
                jbAsteroides.get(i).setVisible(false);

            jbAsteroides.get(i).setBounds(
                    asteroides.get(i).getPosX() + getAnchoPantalla(),
                    asteroides.get(i).getPosY() + getAltoPantalla(),
                    Asteroide.MAX_RADIO_ASTEROIDE,
                    Asteroide.MAX_RADIO_ASTEROIDE
            );
        }
    }

    private void actualizarPuntuacion() {
        jlPuntuacion.setText(String.valueOf(GestorPuntuacion.getPuntuacion()));
    }

    private void actualizarTemporizador() {
        jlTiempo.setText(String.valueOf(temporizador.getSegundos()));
    }

    @Override
    public void actualizar() {
        setPosicionNave();
        setPosicionAsteroides();
        actualizarPuntuacion();
        actualizarTemporizador();
    }
}
