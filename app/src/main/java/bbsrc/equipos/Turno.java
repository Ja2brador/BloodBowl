package bbsrc.equipos;

import java.io.Serializable;

public class Turno implements Serializable {

    private static final long serialVersionUID = -2544537124007488915L;

    private boolean[] jugadores, accionpendiente;
    private int jugadoresdisponibles, turno;
    private boolean segundatirada;

    public Turno() {
        jugadores = new boolean[16];
        accionpendiente = new boolean[16];
        jugadoresdisponibles = 11;
        segundatirada = false;
        turno = 0;
    }

    public boolean getSegundaTirada() {
        return segundatirada;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurno() {
        return turno;
    }

    public void accionRealizada(int jugador) {
        accionpendiente[jugador] = false;
        jugadoresdisponibles--;
    }

    public void resetTurno(int[] jugando) {
        jugadores = new boolean[16];
        accionpendiente = new boolean[16];
        jugadoresdisponibles = jugando.length;
        for (int i = 0; i < jugadoresdisponibles; i++) {
            jugadores[i] = true;
            accionpendiente[i] = true;
        }
        turno++;
        segundatirada = false;
    }

    public boolean finDeTurno() {
        for (int i = 0; i < accionpendiente.length; i++)
            if (accionpendiente[i])
                return false;
        return true;
    }

}
