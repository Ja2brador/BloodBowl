package bbsrc.razas;

import com.example.ja2brador.bloodbowl.R;

import bbsrc.equipos.Equipo;
import bbsrc.jugadores.AtributosEstandar;
import bbsrc.jugadores.Crecimiento;
import bbsrc.jugadores.Habilidades;

public class Orco extends Equipo {

    private static final long serialVersionUID = 3016649183433937549L;

    private final static boolean medico = true;
    private final static int preciost = 60;
    private final static int maxj = R.array.orcMax;
    private final static int preciosj = R.array.orcCost;
    private final static int nombrej = R.array.orcRoles;

    private final static Crecimiento[] crecimientoj = new Crecimiento[]{
            Crecimiento.g_asp,
            Crecimiento.a_gsp,
            Crecimiento.gp_as,
            Crecimiento.gs_ap,
            Crecimiento.gs_ap,
            Crecimiento.s_gap
    };

    private final static AtributosEstandar[] atributosj = new AtributosEstandar[]{
            AtributosEstandar.at5_3_3_9,
            AtributosEstandar.at6_2_3_7,
            AtributosEstandar.at5_3_3_8,
            AtributosEstandar.at4_4_2_9,
            AtributosEstandar.at6_3_3_9,
            AtributosEstandar.at4_5_1_9
    };

    private final static Habilidades[] habilidadesj = new Habilidades[]{
            new Habilidades(R.array.orcRolLineSkills,
                    null),
            new Habilidades(R.array.orcRolGobSkills, new int[]{
                    R.string.rightstuffSkill,
                    R.string.stuntySkill,
                    R.string.dodgeSkill}),
            new Habilidades(R.array.orcRolThrowSkills, new int[]{
                    R.string.surehandsSkill,
                    R.string.passSkill}),
            new Habilidades(R.array.orcRolBlackSkills,
                    null),
            new Habilidades(R.array.orcRolBlitzSkills, new int[]{
                    R.string.blockSkill}),
            new Habilidades(R.array.orcRolTrollSkills, new int[]{
                    R.string.mightyblowSkill,
                    R.string.throwteammateSkill,
                    R.string.reallystupidSkill,
                    R.string.regenerationSkill,
                    R.string.alwayshungrySkill,
                    R.string.lonerSkill})
    };

    public Orco(String nombre, int sobrante, int factorhinchas, int animadoras, int asistentes, boolean medicocomprado, int st) {
        super(nombre, sobrante, factorhinchas, animadoras, asistentes, preciost, maxj, preciosj, atributosj, crecimientoj,
                nombrej, habilidadesj, medico, medicocomprado, st, 6);
    }

    public int getRaza() {
        return R.string.orcRace;
    }

}
