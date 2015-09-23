package bbsrc.jugadores;

import java.io.Serializable;

public class Estado implements Serializable {

    private static final long serialVersionUID = 3666260967870082791L;

    private int lesionespermanentes;

    private boolean tumbado, aturdido, lesionado, muerto, inconsciente, zonadefensa,
            pendientearmadura, pendienteempujar, siguientepartida,
            accionplacaje, accionpase, accionmovimiento, accionpenetracion;

    public Estado() {
        lesionespermanentes = 0;
        tumbado = false;
        aturdido = false;
        inconsciente = false;
        lesionado = false;
        muerto = false;
        siguientepartida = false;
        pendientearmadura = false;
        pendienteempujar = false;
        accionplacaje = false;
        accionpase = false;
        accionmovimiento = false;
        accionpenetracion = false;
        zonadefensa = true;
    }

    public int getLesionespermanentes() {
        return lesionespermanentes;
    }

    public void lesionPermanente() {
        lesionespermanentes++;
    }

    public boolean getZonaDefensa() {
        return zonadefensa;
    }

    public boolean getAccionPlacaje() {
        return accionplacaje;
    }

    public boolean getAccionPase() {
        return accionpase;
    }

    public boolean getAccionMovimiento() {
        return accionmovimiento;
    }

    public boolean getAccionPenetracion() {
        return accionpenetracion;
    }

    public boolean getTiradaArmaduraPendiente() {
        return pendientearmadura;
    }

    public boolean getTumbado() {
        return tumbado;
    }

    public boolean getAturdido() {
        return aturdido;
    }

    public boolean getInconsciente() {
        return inconsciente;
    }

    public boolean getLesionado() {
        return lesionado;
    }

    public boolean getMuerto() {
        return muerto;
    }

    public boolean getPendienteEmpujar() {
        return pendienteempujar;
    }

    public void setTiradaArmadura(boolean armadura) {
        this.pendientearmadura = armadura;
    }

    public void setTumbado(boolean tumbado) {
        this.tumbado = tumbado;
    }

    public void setAturdido(boolean aturdido) {
        this.aturdido = aturdido;
    }

    public void setInconsciente(boolean inconsciente) {
        this.inconsciente = inconsciente;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    public void setEmpujar(boolean empujar) {
        this.pendienteempujar = empujar;
    }

    public void setAccionPlacaje(boolean placaje) {
        this.accionplacaje = placaje;
    }

    public void setAccionMovimiento(boolean mov) {
        this.accionmovimiento = mov;
    }

    public void setAccionPase(boolean pase) {
        this.accionpase = pase;
    }

    public void setAccionPenetracion(boolean pen) {
        this.accionpenetracion = pen;
    }

    public void setZonaDefensa(boolean def) {
        this.zonadefensa = def;
    }

    public boolean getSiguientepartida() {
        return siguientepartida;
    }

    public void setSiguientepartida(boolean siguientepartida) {
        this.siguientepartida = siguientepartida;
    }
}
