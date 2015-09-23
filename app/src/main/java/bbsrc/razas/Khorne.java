package bbsrc.razas;

import com.example.ja2brador.bloodbowl.R;

import bbsrc.equipos.Equipo;
import bbsrc.jugadores.AtributosEstandar;
import bbsrc.jugadores.Crecimiento;
import bbsrc.jugadores.Habilidades;

public class Khorne extends Equipo {

    private static final long serialVersionUID = 5355695060743143671L;

    private final static boolean medico = true;
    private final static int preciost = 70;
    private final static int maxj = R.array.khorneMax;
    private final static int preciosj = R.array.khorneCost;
    private final static int nombrej = R.array.khorneRoles;

    private final static Crecimiento[] crecimientoj = new Crecimiento[]{
            Crecimiento.gp_as,
            Crecimiento.gas_p,
            Crecimiento.gs_ap,
            Crecimiento.s_gap
    };

    private final static AtributosEstandar[] atributosj = new AtributosEstandar[]{
            AtributosEstandar.at6_3_3_8,
            AtributosEstandar.at6_3_3_7,
            AtributosEstandar.at6_3_3_8,
            AtributosEstandar.at6_5_1_9
    };

    private final static Habilidades[] habilidadesj = new Habilidades[]{
            new Habilidades(R.array.khorneRolPitSkills, new int[]{
                    R.string.frenzySkill
            }),
            new Habilidades(R.array.khorneRolLetterSkills, new int[]{
                    R.string.hornsSkill,
                    R.string.juggernautSkill,
                    R.string.regenerationSkill
            }),
            new Habilidades(R.array.khorneRolHeraldSkills, new int[]{
                    R.string.hornsSkill,
                    R.string.frenzySkill,
                    R.string.juggernautSkill
            }),
            new Habilidades(R.array.khorneRolBloodSkills, new int[]{
                    R.string.wildanimalSkill,
                    R.string.hornsSkill,
                    R.string.frenzySkill,
                    R.string.clawSkill,
                    R.string.juggernautSkill,
                    R.string.regenerationSkill,
                    R.string.lonerSkill
            })
    };

    public Khorne(String nombre, int sobrante, int factorhinchas, int animadoras, int asistentes, boolean medicocomprado, int st) {
        super(nombre, sobrante, factorhinchas, animadoras, asistentes, preciost, maxj, preciosj, atributosj, crecimientoj,
                nombrej, habilidadesj, medico, medicocomprado, st, 4);
    }

    public int getRaza() {
        return R.string.khorneRace;
    }

}
