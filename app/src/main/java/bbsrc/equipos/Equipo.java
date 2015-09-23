package bbsrc.equipos;

import java.io.Serializable;
import java.util.ArrayList;

import bbsrc.jugadores.AtributosEstandar;
import bbsrc.jugadores.Crecimiento;
import bbsrc.jugadores.Habilidades;
import bbsrc.jugadores.Jugador;

public abstract class Equipo implements Serializable {

    private static final long serialVersionUID = 5001709958405764491L;

    private final int id, roles;
    private ArrayList<Jugador> plantilla;
    private String nombre;
    private int segundastiradas, tesoro, banco, asistentes, animadoras, factorhinchas, valor;
    private boolean medico;
    private boolean[] numerosdisp;

    private final boolean medicodisponible;
    private final int preciost, maxj, nombrej, precioj;
    private final AtributosEstandar[] atributosj;
    private final Crecimiento[] crecimientoj;
    private final Habilidades[] habilidadesj;

    public Equipo(String nombre, int sobrante, int factorhinchas, int animadoras, int asistentes,
                  int preciost, int maxj, int precioj, AtributosEstandar[] atributosj, Crecimiento[] crecimientoj, int nombrej,
                  Habilidades[] habilidadesj, boolean medicodisponible, boolean medico, int segundatirada, int roles) {
        this.roles = roles;
        this.medico = medico;
        this.medicodisponible = medicodisponible;
        this.id = ContadorEquipos.getId();
        this.plantilla = new ArrayList<>();
        this.numerosdisp = new boolean[16];
        this.segundastiradas = segundatirada;
        this.banco = 0;
        this.asistentes = asistentes;
        this.animadoras = animadoras;
        this.factorhinchas = factorhinchas;
        this.nombre = nombre;
        this.valor = 1000;
        this.tesoro = sobrante;
        this.maxj = maxj;
        this.habilidadesj = habilidadesj;
        this.preciost = preciost;
        this.precioj = precioj;
        this.atributosj = atributosj;
        this.crecimientoj = crecimientoj;
        this.nombrej = nombrej;

    }

    public int getId() {
        return id;
    }

    public ArrayList<Jugador> getPlantilla() {
        return plantilla;
    }

    public Jugador getJugador(int index) {
        return plantilla.get(index);
    }

    public int getCantidadPlantilla() {
        return plantilla.size();
    }

    public Jugador anadirJugador(int jug, String nombre, String posicion, int precio) {
        Jugador nuevo = new Jugador(this, posicion, nombre, habilidadesj[jug], numeroDisponible(), precio, crecimientoj[jug],
                atributosj[jug]);
        plantilla.add(nuevo);
        return nuevo;
    }

    public int numeroDisponible() {
        int res = 0;
        while (numerosdisp[res])
            res++;
        numerosdisp[res] = true;
        return res + 1;
    }

    public boolean medicoDisponible() {
        return medicodisponible;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecioSegundaTirada() {
        return preciost;
    }

    public int getAnimadoras() {
        return animadoras;
    }

    public void setAnimadoras(int animadoras) {
        this.animadoras = animadoras;
    }

    public int getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(int asistentes) {
        this.asistentes = asistentes;
    }

    public int getFactorHinchas() {
        return factorhinchas;
    }

    public void setFactorHinchas(int factorhinchas) {
        this.factorhinchas = factorhinchas;
    }

    public int getTesoro() {
        return tesoro;
    }

    public void setTesoro(int tesoro) {
        this.tesoro = tesoro;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getSegundasTiradas() {
        return segundastiradas;
    }

    public void setSegundasTiradas(int segundastiradas) {
        this.segundastiradas = segundastiradas;
    }

    public int getMaxj() {
        return maxj;
    }

    public AtributosEstandar[] getAtributosEstandar() {
        return atributosj;
    }

    public abstract int getRaza();

    public boolean getMedico() {
        return medico;
    }

    public void setMedico(boolean medico) {
        this.medico = medico;
    }

}
