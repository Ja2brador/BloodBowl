package bbsrc.mesa;

import java.io.Serializable;

import bbsrc.jugadores.Jugador;

public class Balon implements Serializable {

    private static final long serialVersionUID = -8242668982939036358L;

    private Jugador jugador;
    private Casilla casilla;

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
}
