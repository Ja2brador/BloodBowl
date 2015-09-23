package bbsrc.mesa;

import java.io.Serializable;
import java.util.ArrayList;

import bbsrc.jugadores.Jugador;


public abstract class Casilla implements Serializable {

    private static final long serialVersionUID = 6465588041784611398L;

    private final Tablero tablero;
    private Jugador jugador;
    private Balon balon;
    private boolean disponible;
    private int x, y;

    public Casilla(Tablero tablero, int x, int y) {
        this.tablero = tablero;
        this.jugador = null;
        this.balon = null;
        this.disponible = false;
        this.x = x;
        this.y = y;
    }

    public boolean esTouchdown() {
        return false;
    }

    public boolean esLateral() {
        return false;
    }

    public boolean esFuera() {
        return false;
    }

    public boolean esGolpe() {
        return false;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Balon getBalon() {
        return balon;
    }

    public void setBalon(Balon balon) {
        this.balon = balon;
    }

    public boolean diagonalAdyacente(Casilla casilla) {
        return Math.abs(this.getX() + this.getY() - casilla.getX() - casilla.getY()) == 2;
    }

    public ArrayList<Casilla> casillasDisponiblesEmpujeExtra(Casilla casilla) {
        ArrayList<Casilla> res = new ArrayList<Casilla>();
        Casilla[] todas = casilla.adyacentes();
        Casilla[] empuje = new Casilla[7];
        int j = 0;
        for (int i = 0; i < empuje.length; i++) {
            if (todas[j] != this)
                empuje[i] = todas[i];
            j++;
        }
        int tot = 0;
        for (int i = 0; i < empuje.length; i++)
            if (empuje[i].getJugador() == null) {
                empuje[i].disponible = true;
                res.add(empuje[i]);
            } else
                tot++;
        if (tot == 7)
            return this.casillasDisponiblesEmpuje(casilla);
        return res;
    }

    public ArrayList<Casilla> casillasDisponiblesEmpuje(Casilla casilla) {
        ArrayList<Casilla> res = new ArrayList<Casilla>();
        Casilla[] empuje = new Casilla[3];
        int x = casilla.getX();
        int y = casilla.getY();
        if (this.diagonalAdyacente(casilla))
            switch (this.posicionDiagonal(casilla)) {
                case 1:
                    empuje[0] = (tablero.getCasilla(x, y - 1));
                    empuje[1] = (tablero.getCasilla(x + 1, y - 1));
                    empuje[2] = (tablero.getCasilla(x + 1, y));
                    break;
                case 2:
                    empuje[0] = (tablero.getCasilla(x, y + 1));
                    empuje[1] = (tablero.getCasilla(x + 1, y + 1));
                    empuje[2] = (tablero.getCasilla(x + 1, y));
                    break;
                case 3:
                    empuje[0] = (tablero.getCasilla(x, y + 1));
                    empuje[1] = (tablero.getCasilla(x - 1, y + 1));
                    empuje[2] = (tablero.getCasilla(x - 1, y));
                    break;
                case 4:
                    empuje[0] = (tablero.getCasilla(x, y - 1));
                    empuje[1] = (tablero.getCasilla(x - 1, y - 1));
                    empuje[2] = (tablero.getCasilla(x - 1, y));
                    break;
            }
        else {
            int nx, ny;
            switch (this.posicionCruz(casilla)) {
                case 1:
                    ny = y - 1;
                    for (nx = -1; nx < 2; nx++)
                        empuje[nx + 1] = (tablero.getCasilla(x + nx, ny));
                    break;
                case 2:
                    nx = x + 1;
                    for (ny = -1; ny < 2; ny++)
                        empuje[ny + 1] = (tablero.getCasilla(nx, y + ny));
                    break;
                case 3:
                    ny = y + 1;
                    for (nx = -1; nx < 2; nx++)
                        empuje[nx + 1] = (tablero.getCasilla(x + nx, ny));
                    break;
                case 4:
                    nx = x - 1;
                    for (ny = -1; ny < 2; ny++)
                        empuje[ny + 1] = (tablero.getCasilla(nx, y + ny));
                    break;
            }
        }
        int tot = 0;
        for (int i = 0; i < empuje.length; i++)
            if (empuje[i].getJugador() == null)
                empuje[i].disponible = true;
            else
                tot++;
        if (tot == 3)
            for (int i = 0; i < empuje.length; i++)
                empuje[i].disponible = true;
        for (int i = 0; i < empuje.length; i++)
            if (empuje[i].disponible)
                res.add(empuje[i]);
        return res;
    }

    //Devuelve 1 si la casilla esta arriba a la izquierda
    //Devuelve 2 si la casilla esta arriba a la derecha
    //Devuelve 3 si la casilla esta abajo a la derecha
    //Devuelve 4 si la casilla esta abajo a la izquierda
    public int posicionDiagonal(Casilla casilla) {
        int x = this.getX();
        int y = this.getY();
        int nx = casilla.getX();
        int ny = casilla.getY();
        if (x + 1 == nx && y - 1 == ny)
            return 1;
        if (x + 1 == nx && y + 1 == ny)
            return 2;
        if (x - 1 == nx && y + 1 == ny)
            return 3;
        if (x - 1 == nx && y - 1 == ny)
            return 4;
        return 0;
    }

    //Devuelve 1 si la casilla esta a la izquierda
    //Devuelve 2 si la casilla esta arriba
    //Devuelve 3 si la casilla esta a la derecha
    //Devuelve 4 si la casilla esta abajo
    public int posicionCruz(Casilla casilla) {
        int x = this.getX();
        int y = this.getY();
        int nx = casilla.getX();
        int ny = casilla.getY();
        if (y - 1 == ny)
            return 1;
        if (x + 1 == nx)
            return 2;
        if (y + 1 == ny)
            return 3;
        if (x - 1 == nx)
            return 4;
        return 0;
    }

    // 6 7 8
    // 4 X 5
    // 1 2 3
    public Casilla[] adyacentes() {
        Casilla[] res = new Casilla[8];
        Tablero tab = this.getTablero();
        int x = this.x;
        int y = this.y;
        int k = 0;
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++) {
                int newx = i + x;
                int newy = j + y;
                if (!(i == 0 && j == 0)) {
                    res[k] = tab.getCasilla(newx, newy);
                    k++;
                }
            }
        return res;
    }

    public static class CasFuera extends Casilla {

        private static final long serialVersionUID = 3033524068838819165L;

        public CasFuera(Tablero tablero, int x, int y) {
            super(tablero, x, y);
        }

        public boolean esFuera() {
            return true;
        }

    }

    public static class CasGolpe extends Casilla {

        private static final long serialVersionUID = -6231545516627692589L;

        public CasGolpe(Tablero tablero, int x, int y) {
            super(tablero, x, y);
        }

        public boolean esGolpe() {
            return true;
        }

    }

    public static class CasillaCentro extends Casilla {

        private static final long serialVersionUID = -4137988119175921953L;

        public CasillaCentro(Tablero tablero, int x, int y) {
            super(tablero, x, y);
        }

    }

    public static class CasLateral extends Casilla {

        private static final long serialVersionUID = 882288793073663032L;

        public CasLateral(Tablero tablero, int x, int y) {
            super(tablero, x, y);
        }

        public boolean esLateral() {
            return true;
        }

    }

    public static class CasTDCentro extends Casilla {

        private static final long serialVersionUID = 5600897383044502429L;

        public CasTDCentro(Tablero tablero, int x, int y) {
            super(tablero, x, y);
        }

        public boolean esTouchdown() {
            return true;
        }

    }

    public static class CasTDLateral extends Casilla {

        private static final long serialVersionUID = 8479639476485113860L;

        public CasTDLateral(Tablero tablero, int x, int y) {
            super(tablero, x, y);
        }

        public boolean esTouchdown() {
            return true;
        }

        public boolean esLateral() {
            return true;
        }

    }

    public int imprimir() {
        if (this instanceof CasGolpe) {
            return 5;
        }
        if (this instanceof CasLateral) {
            return 3;
        }
        if (this instanceof CasillaCentro) {
            return 4;
        }
        if (this instanceof CasTDLateral) {
            return 2;
        }
        if (this instanceof CasTDCentro) {
            return 1;
        }
        return 0;
    }

}
