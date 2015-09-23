package bbsrc.jugadores;

import android.graphics.Color;

import com.example.ja2brador.bloodbowl.R;

import java.io.Serializable;
import java.util.ArrayList;

import bbsrc.equipos.Equipo;
import bbsrc.mesa.Balon;
import bbsrc.mesa.Casilla;

public class Jugador implements Serializable {

    private static final long serialVersionUID = -2154109805034683704L;

    private final int numero;
    private final Equipo equipo;
    private Casilla casilla;
    private Balon balon;
    private Atributos atributos;
    private Habilidades habilidades;
    private int precio, lp;
    private MejoraRealizada[] mejorasrealizadas;
    private Experiencia exp;
    private boolean lppe, enpie, tiradaarmadura, aturdido, inconsciente, zonadefensa, penetracion, empujado;

    private final String jugador, nombre;

    public Jugador(Equipo equipo, String jugador, String nombre, Habilidades habilidades, int numero, int precio,
                   Crecimiento crecimiento, AtributosEstandar atributos) {
        this.casilla = null;
        this.habilidades = habilidades;
        this.precio = precio;
        this.atributos = new Atributos(atributos);
        this.exp = new Experiencia(crecimiento);
        this.numero = numero;
        this.equipo = equipo;
        this.nombre = nombre;
        this.jugador = jugador;
        this.lppe = false;
        this.lp = 0;
        this.enpie = true;
        this.tiradaarmadura = false;
        this.aturdido = false;
        this.inconsciente = false;
        this.zonadefensa = true;
        this.penetracion = false;
        this.empujado = false;
        this.mejorasrealizadas = new MejoraRealizada[6];
    }

    public boolean getLPPE() {
        return lppe;
    }

    public int getLesionesPermanentes() {
        return lp;
    }

    public int getNumero() {
        return numero;
    }

    public int getCrecimiento() {
        return exp.getCrecimiento().getNombre();
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
        casilla.setJugador(this);
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public boolean perteneceEquipo(Equipo equipo) {
        return getEquipo().getNombre().equals(equipo.getNombre());
    }

    public int[] getAtributos() {
        int M = atributos.getMovimiento();
        int F = atributos.getFuerza();
        int AG = atributos.getAgilidad();
        int AR = atributos.getArmadura();
        return new int[]{M, F, AG, AR};
    }

    public int[] cambiosAtributos() {
        return new int[]{
                atributos.cambioTotalMovimiento(),
                atributos.cambioTotalFuerza(),
                atributos.cambioTotalAgilidad(),
                atributos.cambioTotalArmadura()
        };
    }

    public int[] coloresAtributo() {
        int[] cambios = cambiosAtributos();
        int[] res = new int[4];
        int cambio;
        for (int i = 0; i < 4; i++) {
            cambio = cambios[i];
            switch (cambio) {
                case 2:
                    res[i] = Color.BLUE;
                    break;
                case 1:
                    res[i] = Color.CYAN;
                    break;
                case 0:
                    res[i] = Color.GREEN;
                    break;
                case -1:
                    res[i] = Color.YELLOW;
                    break;
                case -2:
                    res[i] = Color.RED;
                    break;
            }
        }
        return res;
    }

    public boolean mejorarMovimiento() {
        int M = atributos.getMovimiento();
        return M < 10 || atributos.cambioTotalMovimiento() < 2;
    }

    public boolean mejorarFuerza() {
        return atributos.getFuerza() - atributos.cambioTotalFuerza() < 2;
    }

    public boolean mejorarAgilidad() {
        return atributos.getAgilidad() - atributos.cambioTotalAgilidad() < 2;
    }

    public boolean mejorarArmadura() {
        int AR = atributos.getArmadura();
        return AR < 10 || AR - atributos.cambioTotalArmadura() < 2;
    }

    public Habilidades getHabilidades() {
        return habilidades;
    }

    public int getPrecio() {
        return precio;
    }

    public int getNivel() {
        return exp.getNivel();
    }

    public int getExperiencia() {
        return exp.getExperiencia();
    }

    public int getExperienciaSiguienteNivel() {
        return exp.experienciaNextLevel();
    }

    public String getJugador() {
        return jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void levantar() {
        enpie = true;
    }

    public void tumbar() {
        enpie = false;
    }

    public void derribado() {
        enpie = true;
        tiradaarmadura = true;
    }

    public void aturdir() {
        aturdido = true;
    }

    public void ponerseBocaArriba() {
        aturdido = false;
    }

    public void inconsciente() {
        inconsciente = true;
        enpie = true;
    }

    public boolean tieneHabilidad(int habilidad) {
        int[] ids = habilidades.getIdHabilidades();
        for (int id : ids)
            if (habilidad == id)
                return true;
        for (MejoraRealizada mr : mejorasrealizadas)
            if (mr instanceof MejoraRealizada.HabilidadAprendida && mr.getMejora() == habilidad)
                return true;
        return false;
    }

    public int apoyo(Jugador jugador, int fuerza) {
        ArrayList<Jugador> aliados = jugador.adyacenteEquipoContrario();
        ArrayList<Jugador> contrapoyo;
        Jugador aliado;
        Jugador contrario;
        for (int i = 0; i < aliados.size(); i++) {
            aliado = aliados.get(i);
            if (aliado.tieneHabilidad(R.string.guardSkill)) {
                fuerza++;
            } else {
                contrapoyo = aliado.adyacenteEquipoContrario();
                if (contrapoyo.size() == 1
                        && !aliado.getNombre().equals(this.getNombre())
                        ) {
                    fuerza++;
                } else if (contrapoyo.size() != 1) {
                    int j = 0;
                    while (j < contrapoyo.size()) {
                        contrario = contrapoyo.get(j);
                        if (!contrario.getNombre().equals(jugador.getNombre()) && contrario.getZonaDefensa())
                            break;
                        j++;
                    }
                    if (j == contrapoyo.size()) {
                        fuerza++;
                    }
                }
            }
        }
        return fuerza;
    }

    public ArrayList<Jugador> adyacenteEquipoContrario() {
        Casilla[] adyac = this.casilla.adyacentes();
        ArrayList<Jugador> res = new ArrayList<>();
        Jugador temp;
        for (int i = 0; i < adyac.length; i++)
            if (adyac[i].getJugador() != null) {
                temp = adyac[i].getJugador();
                if (temp.getEquipo()
                        != this.getEquipo()
                        && temp.getZonaDefensa())
                    res.add(temp);
            }

        return res;
    }

    public boolean rivales(Jugador jugador) {
        return this.getEquipo() != jugador.getEquipo();
    }

    public boolean aliados(Jugador jugador) {
        return this.getEquipo() == jugador.getEquipo();
    }

    public int compararFuerza(Jugador placado) {
        int atacante = this.atributos.getFuerza();
        int defensor = placado.atributos.getFuerza();
        if (this.getAccionPenetracion() && this.tieneHabilidad(R.string.hornsSkill))
            atacante++;
        atacante = this.apoyo(placado, atacante);
        defensor = placado.apoyo(this, defensor);
        if (atacante > defensor * 2)
            return 2;
        if (atacante > defensor)
            return 1;
        if (atacante * 2 < defensor)
            return -2;
        if (atacante < defensor)
            return -1;
        return 0;
    }

    //Devuelve false cuando el jugador placado elige donde es empujado
    //Devuelve true cuando el atacante elige
    public boolean quienEmpuja(Jugador placado) {
        return this.tieneHabilidad(R.string.grabSkill) && placado.tieneHabilidad(R.string.sidestepSkill);
    }

    //Devuelve las casillas habilitadas para su proxima deshabilitacion
    public ArrayList<Casilla> habilitarCasillasEmpuje(Jugador placado) {
        Casilla of = this.getCasilla();
        Casilla def = placado.getCasilla();
        if (this.tieneHabilidad(R.string.grabSkill) ^ placado.tieneHabilidad(R.string.sidestepSkill))
            return of.casillasDisponiblesEmpujeExtra(def);
        else
            return of.casillasDisponiblesEmpuje(def);
    }

    public int agallas(Jugador placado, int dado) {
        int fuerza = placado.atributos.getFuerza();
        int res;
        if (this.atributos.getFuerza() + dado > fuerza) {
            int pre = this.atributos.setFuerza(fuerza);
            res = compararFuerza(placado);
            this.atributos.setFuerza(pre);
        } else
            res = compararFuerza(placado);
        return res;
    }

    public void placar(Jugador placado, int dado) {
        switch (dado) {
            case 1:
                this.derribado();
                break;
            case 2:
                int forcejeo = R.string.wrestleSkill;
                int placar = R.string.blockSkill;
                if (this.tieneHabilidad(forcejeo) || placado.tieneHabilidad(forcejeo)) {
                    this.tumbar();
                    placado.tumbar();
                } else {
                    if (!placado.tieneHabilidad(placar))
                        placado.derribado();
                    if (!this.tieneHabilidad(placar))
                        this.derribado();
                }
                break;
            case 3:
            case 4:
                this.empujarPendiente(placado);
                break;
            case 5:
                this.empujarPendiente(placado);
                if (!placado.tieneHabilidad(R.string.dodgeSkill) || this.tieneHabilidad(R.string.tackleSkill))
                    placado.derribado();
                break;
            case 6:
                this.empujarPendiente(placado);
                placado.derribado();
                break;
        }
    }

    public boolean rodeado() {
        Casilla[] adyac = this.casilla.adyacentes();
        int tot = 0;
        for (Casilla anAdyac : adyac)
            if (anAdyac.getJugador() != null)
                tot++;
        return tot == 8;
    }

    //0 Si la casilla objetivo tiene un jugador y hay que empujarlo
    //1 Si termina la accion de empujar porque la casilla esta vacia
    //2 Si termina la accion de empujar por la habilidad Mantenerse Firme
    public int accionEmpujar(Jugador placado, Casilla casilla) {
        Jugador j = casilla.getJugador();
        if (j != null)
            if (j.tieneHabilidad(R.string.standfirmSkill))
                return 2;
            else
                return 0;
        return 1;
    }

    public void juggernaut(Jugador placado, int dado, boolean empujar) {
        if (dado == 2 && empujar)
            this.empujarPendiente(placado);
        else
            this.placar(placado, dado);
    }

    public void empujarPendiente(Jugador placado) {
        if (!placado.tieneHabilidad(R.string.standfirmSkill) || this.tieneHabilidad(R.string.juggernautSkill))
            placado.setEmpujar(true);
    }

    public boolean getAccionPenetracion() {
        return penetracion;
    }

    public boolean getZonaDefensa() {
        return zonadefensa;
    }

    public void setEmpujar(boolean empujar) {
        this.empujado = empujar;
    }
}
