package bbsrc.jugadores;

import java.io.Serializable;

import bbsrc.extra.Dados;

public class Mejora implements Serializable {

    private static final long serialVersionUID = 5749928764658566916L;

    private final int tirada;
    private boolean doble;

    public Mejora() {
        tirada = Dados.sumarDosDadosD6doble(doble);
    }

    public int getTirada() {
        return tirada;
    }

    public boolean getDoble() {
        return doble;
    }

    public boolean getMARExtra() {
        return tirada == 10;
    }

    public boolean getAGExtra() {
        return tirada == 11;
    }

    public boolean getFExtra() {
        return tirada == 12;
    }

}
