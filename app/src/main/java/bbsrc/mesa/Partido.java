package bbsrc.mesa;

import java.io.Serializable;

import bbsrc.equipos.Equipo;


public class Partido implements Serializable {

    private static final long serialVersionUID = 6648515297004373122L;

    private Equipo receptor, pateador;

    public Equipo getReceptor() {
        return receptor;
    }

    public Equipo getPateador() {
        return pateador;
    }

    public void setPateador(Equipo pateador) {
        this.pateador = pateador;
    }

    public void setReceptor(Equipo receptor) {
        this.receptor = receptor;
    }

    public void cambiarEquipos() {
        Equipo temp = this.receptor;
        this.receptor = this.pateador;
        this.pateador = temp;
    }
}
