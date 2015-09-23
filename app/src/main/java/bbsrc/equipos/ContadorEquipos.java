package bbsrc.equipos;

import java.io.Serializable;

public class ContadorEquipos implements Serializable {

    private static final long serialVersionUID = 8274810961685409728L;

    private static int contador = 0;

    public static int getId() {
        return contador++;
    }

    public static int getContador() {
        return contador;
    }

    public static void setId(int id) {
        contador = id;
    }

}
