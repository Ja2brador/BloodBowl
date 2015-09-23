package bbsrc.razas;

import com.example.ja2brador.bloodbowl.R;

import bbsrc.equipos.Equipo;
import bbsrc.jugadores.AtributosEstandar;
import bbsrc.jugadores.Crecimiento;
import bbsrc.jugadores.Habilidades;

public class Humano extends Equipo {

    private static final long serialVersionUID = 2587393440477578151L;

    private final static boolean medico = true;
    private final static int preciost = 50;
    private final static int maxj = R.array.humanMax;
    private final static int preciosj = R.array.humanCost;
    private final static int nombrej = R.array.humanRoles;

    private final static Crecimiento[] crecimientoj = new Crecimiento[]{
            Crecimiento.g_asp,
            Crecimiento.ga_sp,
            Crecimiento.gp_as,
            Crecimiento.gs_ap,
            Crecimiento.s_gap
    };

    private final static AtributosEstandar[] atributosj = new AtributosEstandar[]{
            AtributosEstandar.at6_3_3_8,
            AtributosEstandar.at8_2_3_7,
            AtributosEstandar.at6_3_3_8,
            AtributosEstandar.at7_3_3_8,
            AtributosEstandar.at5_5_2_9
    };

    private final static Habilidades[] habilidadesj = new Habilidades[]{
            new Habilidades(R.array.humanRolLineSkills, new int[]{
                    R.string.noneSkill}),
            new Habilidades(R.array.humanRolCatchSkills, new int[]{
                    R.string.catchSkill,
                    R.string.dodgeSkill}),
            new Habilidades(R.array.humanRolThrowSkills, new int[]{
                    R.string.surehandsSkill,
                    R.string.passSkill
            }),
            new Habilidades(R.array.humanRolBlitzSkills, new int[]{
                    R.string.blockSkill
            }),
            new Habilidades(R.array.humanRolOgreSkills, new int[]{
                    R.string.thickskullSkill,
                    R.string.boneheadSkill,
                    R.string.mightyblowSkill,
                    R.string.throwteammateSkill,
                    R.string.lonerSkill
            })
    };

    public Humano(String nombre, int sobrante, int factorhinchas, int animadoras, int asistentes, boolean medicocomprado, int st) {
        super(nombre, sobrante, factorhinchas, animadoras, asistentes, preciost, maxj, preciosj, atributosj, crecimientoj,
                nombrej, habilidadesj, medico, medicocomprado, st, 5);
    }

    public int getRaza() {
        return R.string.humanRace;
    }

}
