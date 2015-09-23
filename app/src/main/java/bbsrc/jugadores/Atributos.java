package bbsrc.jugadores;

import java.io.Serializable;

public class Atributos implements Serializable {

    private static final long serialVersionUID = 5781730474232557675L;

    private Integer Mp, Fp, AGp, ARp, Mm, Fm, AGm, ARm;
    private final AtributosEstandar atest;

    public Atributos(AtributosEstandar atest) {
        this.atest = atest;
    }

    public boolean cambiadoMovimiento() {
        return Mp != null || Mm != null;
    }

    public int[] cambiosMovimiento() {
        return new int[]{Mp, Mm};
    }

    public int cambioTotalMovimiento() {
        int temp = 0;
        if (Mp != null)
            temp += Mp;
        if (Mm != null)
            temp += Mm;
        return temp;
    }

    public boolean cambiadoFuerza() {
        return Fp != null || Fm != null;
    }

    public int[] cambiosFuerza() {
        return new int[]{Fp, Fm};
    }

    public int cambioTotalFuerza() {
        int temp = 0;
        if (Fp != null)
            temp += Fp;
        if (Fm != null)
            temp += Fm;
        return temp;
    }

    public boolean cambiadoAgilidad() {
        return AGp != null || AGm != null;
    }

    public int[] cambiosAgilidad() {
        return new int[]{AGp, AGm};
    }

    public int cambioTotalAgilidad() {
        int temp = 0;
        if (AGp != null)
            temp += AGp;
        if (AGm != null)
            temp += AGm;
        return temp;
    }

    public boolean cambiadoArmadura() {
        return ARp != null || ARm != null;
    }

    public int[] cambiosArmadura() {
        return new int[]{ARp, ARm};
    }

    public int cambioTotalArmadura() {
        int temp = 0;
        if (ARp != null)
            temp += ARp;
        if (ARm != null)
            temp += ARm;
        return temp;
    }

    public int getMovimientoEstandar() {
        return atest.getMovimiento();
    }

    public int getFuerzaEstandar() {
        return atest.getFuerza();
    }

    public int getAgilidadEstandar() {
        return atest.getAgilidad();
    }

    public int getArmaduraEstandar() {
        return atest.getArmadura();
    }

    public int getMovimiento() {
        int temp = getMovimientoEstandar();
        if (Mp != null)
            temp += Mp;
        return temp;
    }

    public int getFuerza() {
        int temp = getFuerzaEstandar();
        if (Fp != null)
            temp += Fp;
        return temp;
    }

    public int getAgilidad() {
        int temp = getAgilidadEstandar();
        if (AGp != null)
            temp += AGp;
        return temp;
    }

    public int getArmadura() {
        int temp = getArmaduraEstandar();
        if (ARp != null)
            temp += ARp;
        return temp;
    }

    public int setFuerza(int f) {
        int temp = this.Fp;
        this.Fp = f;
        return temp;
    }

    public void aumentarMovimiento() {
        if (Mp == null)
            Mp = 1;
        else
            Mp += 1;
    }

    public void aumentarFuerza() {
        if (Fp == null)
            Fp = 1;
        else
            Fp += 1;
    }

    public void aumentarAgilidad() {
        if (AGp == null)
            AGp = 1;
        else
            AGp += 1;
    }

    public void aumentarArmadura() {
        if (ARp == null)
            ARp = 1;
        else
            ARp += 1;
    }

    public void disminuirMovimiento() {
        if (Mm == null)
            Mm = -1;
        else
            Mm -= 1;
    }

    public void disminuirFuerza() {
        if (Fm == null)
            Fm = -1;
        else
            Fm -= 1;
    }

    public void disminuirAgilidad() {
        if (AGm == null)
            AGm = -1;
        else
            AGm -= 1;
    }

    public void disminuirArmadura() {
        if (ARm == null)
            ARm = -1;
        else
            ARm -= 1;
    }

}
