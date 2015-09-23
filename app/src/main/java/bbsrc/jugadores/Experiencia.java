package bbsrc.jugadores;

import java.io.Serializable;
import java.util.ArrayList;


public class Experiencia implements Serializable {

    private static final long serialVersionUID = 529154676571917099L;

    private int nivel, experiencia, mejoradisp;
    private final Crecimiento crecimiento;
    private ArrayList<Mejora> mejoras;

    public Experiencia(Crecimiento crecimiento) {
        nivel = 0;
        experiencia = 0;
        this.crecimiento = crecimiento;
        this.mejoras = new ArrayList<Mejora>();
    }

    public Crecimiento getCrecimiento() {
        return crecimiento;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getMejorasDisponibles() {
        return mejoradisp;
    }

    public void aumentoExp(int exp) {
        this.experiencia += exp;
        if (subidaNivel()) {
            mejoras.add(new Mejora());
            mejoradisp++;
            nivel++;
        }
    }

    public void mejoraRealizada() {
        mejoras.remove(0);
        mejoradisp--;
    }

    public int experienciaNextLevel() {
        switch (this.nivel) {
            case 0:
                return 6;
            case 1:
                return 16;
            case 2:
                return 31;
            case 3:
                return 51;
            case 4:
                return 76;
            case 5:
                return 175;
            default:
                return 0;
        }
    }

    private boolean subidaNivel() {
        switch (this.nivel) {
            case 0:
                if (this.experiencia > 5)
                    return true;
                break;
            case 1:
                if (this.experiencia > 15)
                    return true;
                break;
            case 2:
                if (this.experiencia > 30)
                    return true;
                break;
            case 3:
                if (this.experiencia > 50)
                    return true;
                break;
            case 4:
                if (this.experiencia > 75)
                    return true;
                break;
            case 5:
                if (this.experiencia > 175)
                    return true;
                break;
        }
        return false;
    }

}
