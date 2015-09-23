package bbsrc.mesa;


public class Tablero {

    private final Casilla[][] celda;
    private static final int longitud = 28;
    private static final int anchura = 17;

    public Tablero() {
        this.celda = new Casilla[anchura][longitud];
        for (int j = 0; j < anchura; j++)
            if (j == 0 || j == 16)
                celda[j] = casillasFuera(j);
            else if (j > 0 && j < 5 || j > 11 && j < 16)
                celda[j] = casillasLateral(j);
            else
                celda[j] = casillasCentro(j);
    }

    public Casilla[] casillasFuera(int fila) {
        Casilla[] res = new Casilla[28];
        for (int i = 0; i < 28; i++)
            res[i] = new Casilla.CasFuera(this, fila, i);
        return res;
    }

    public Casilla[] casillasLateral(int fila) {
        Casilla[] res = new Casilla[28];
        res[0] = new Casilla.CasFuera(this, fila, 0);
        res[27] = new Casilla.CasFuera(this, fila, 27);
        res[1] = new Casilla.CasTDLateral(this, fila, 1);
        res[26] = new Casilla.CasTDLateral(this, fila, 26);
        for (int i = 2; i < 26; i++)
            res[i] = new Casilla.CasLateral(this, fila, i);
        return res;
    }

    public Casilla[] casillasCentro(int fila) {
        Casilla[] res = new Casilla[28];
        res[0] = new Casilla.CasFuera(this, fila, 0);
        res[27] = new Casilla.CasFuera(this, fila, 27);
        res[1] = new Casilla.CasTDCentro(this, fila, 1);
        res[26] = new Casilla.CasTDCentro(this, fila, 26);
        res[13] = new Casilla.CasGolpe(this, fila, 13);
        res[14] = new Casilla.CasGolpe(this, fila, 14);
        for (int i = 2; i < 13; i++)
            res[i] = new Casilla.CasillaCentro(this, fila, i);
        for (int i = 15; i < 26; i++)
            res[i] = new Casilla.CasillaCentro(this, fila, i);
        return res;
    }

    public void imprimir() {
        String linea;
        for (int i = 0; i < anchura; i++) {
            linea = "";
            for (int j = 0; j < longitud; j++) {
                linea += String.valueOf(celda[i][j].imprimir());
            }
            System.out.println(linea);
        }
    }

    public Casilla getCasilla(int x, int y) {
        return celda[x][y];
    }

    public static int getLongitud() {
        return longitud;
    }

    public static int getAnchura() {
        return anchura;
    }

}
