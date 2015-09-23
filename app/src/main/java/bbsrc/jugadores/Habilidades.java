package bbsrc.jugadores;

import java.io.Serializable;

public class Habilidades implements Serializable {

    private static final long serialVersionUID = -4383121045301414239L;

    private final int rstring;
    private final int[] rskillsstring;

    public Habilidades(int rstring, int[] skills) {
        this.rstring = rstring;
        rskillsstring = skills;
    }

    public int[] getIdHabilidades() {
        return rskillsstring;
    }

    public int getArray() {
        return rstring;
    }

}
