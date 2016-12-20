package es.cesalberca.infernalrcircle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Cesar
 */
public class Temporizador {
    private int segundos;
    private Timer timer;
    private TimerTask task;

    public Temporizador() {
        this.segundos = 0;

        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                segundos++;
            }
        };
    }

    int getSegundos() {
        return segundos;
    }

    void comenzar() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
}
