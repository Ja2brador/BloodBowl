package bbsrc.jugadores;

import com.example.ja2brador.bloodbowl.R;

import java.io.Serializable;

public abstract class Crecimiento implements Serializable {

    private static final long serialVersionUID = -1656672308157266594L;

    public final static CrecA_GSP a_gsp = new CrecA_GSP();
    public final static CrecAM_GSP am_gsp = new CrecAM_GSP();
    public final static CrecG_ASP g_asp = new CrecG_ASP();
    public final static CrecG_ASPM g_aspm = new CrecG_ASPM();
    public final static CrecGA_SP ga_sp = new CrecGA_SP();
    public final static CrecGA_SPM ga_spm = new CrecGA_SPM();
    public final static CrecGAM_SP gam_sp = new CrecGAM_SP();
    public final static CrecGAP_S gap_s = new CrecGAP_S();
    public final static CrecGAS_P gas_p = new CrecGAS_P();
    public final static CrecGM_ASP gm_asp = new CrecGM_ASP();
    public final static CrecGP_AS gp_as = new CrecGP_AS();
    public final static CrecGP_ASM gp_asm = new CrecGP_ASM();
    public final static CrecGPM_AS gpm_as = new CrecGPM_AS();
    public final static CrecGS_AP gs_ap = new CrecGS_AP();
    public final static CrecGS_APM gs_apm = new CrecGS_APM();
    public final static CrecGSM_AP gsm_ap = new CrecGSM_AP();
    public final static CrecGSPM_A gspm_a = new CrecGSPM_A();
    public final static CrecS_GAP s_gap = new CrecS_GAP();
    public final static CrecS_GAPM s_gapm = new CrecS_GAPM();
    public final static CrecSM_GAP sm_gap = new CrecSM_GAP();

    private final int nombre;

    private final int general;
    private final int agilidad;
    private final int fuerza;
    private final int pase;
    private final int mutacion;

    private Crecimiento(int g, int a, int f, int p, int m, int n) {
        nombre = n;
        general = g;
        agilidad = a;
        fuerza = f;
        pase = p;
        mutacion = m;
    }

    public int getNombre() {
        return nombre;
    }

    public boolean normalGeneral() {
        return general == 0;
    }

    public boolean normalAgilidad() {
        return agilidad == 0;
    }

    public boolean normalFuerza() {
        return fuerza == 0;
    }

    public boolean normalPase() {
        return pase == 0;
    }

    public boolean normalMutacion() {
        return mutacion == 0;
    }

    public boolean disponibleMutacion() {
        return mutacion != 2;
    }

    private static class CrecA_GSP extends Crecimiento {

        private static final long serialVersionUID = 7311765222814421088L;

        private CrecA_GSP() {
            super(1, 0, 1, 1, 2, R.string.g_aspGrow);
        }

    }

    private static class CrecAM_GSP extends Crecimiento {

        private static final long serialVersionUID = 4427206045760628780L;

        private CrecAM_GSP() {
            super(1, 0, 1, 1, 0, R.string.am_gspGrow);
        }

    }

    private static class CrecG_ASP extends Crecimiento {

        private static final long serialVersionUID = 1088277615309320187L;

        private CrecG_ASP() {
            super(0, 1, 1, 1, 2, R.string.g_aspGrow);
        }

    }

    private static class CrecG_ASPM extends Crecimiento {

        private static final long serialVersionUID = -8542204520905398674L;

        private CrecG_ASPM() {
            super(0, 1, 1, 1, 1, R.string.g_aspmGrow);
        }

    }

    private static class CrecGA_SP extends Crecimiento {

        private static final long serialVersionUID = 6891695241668838902L;

        private CrecGA_SP() {
            super(0, 0, 1, 1, 2, R.string.ga_spGrow);
        }

    }

    private static class CrecGA_SPM extends Crecimiento {

        private static final long serialVersionUID = -6822405242014790041L;

        private CrecGA_SPM() {
            super(0, 0, 1, 1, 1, R.string.ga_spmGrow);
        }

    }

    private static class CrecGAM_SP extends Crecimiento {

        private static final long serialVersionUID = 2811450591418723497L;

        private CrecGAM_SP() {
            super(0, 0, 1, 1, 0, R.string.gam_spGrow);
        }

    }

    private static class CrecGAP_S extends Crecimiento {

        private static final long serialVersionUID = 6674495644505859252L;

        private CrecGAP_S() {
            super(0, 0, 1, 0, 2, R.string.gap_sGrow);
        }

    }

    private static class CrecGAS_P extends Crecimiento {

        private static final long serialVersionUID = 5279385153597058100L;

        private CrecGAS_P() {
            super(0, 0, 0, 1, 2, R.string.gas_pGrow);
        }

    }

    private static class CrecGM_ASP extends Crecimiento {

        private static final long serialVersionUID = 2178507599753271070L;

        private CrecGM_ASP() {
            super(0, 1, 1, 1, 0, R.string.gm_aspGrow);
        }

    }

    private static class CrecGP_AS extends Crecimiento {

        private static final long serialVersionUID = -693253534841880510L;

        private CrecGP_AS() {
            super(0, 1, 1, 0, 2, R.string.gp_asGrow);
        }

    }

    private static class CrecGPM_AS extends Crecimiento {

        private static final long serialVersionUID = 7033918609403225189L;

        private CrecGPM_AS() {
            super(0, 1, 1, 0, 0, R.string.gpm_asGrow);
        }

    }

    private static class CrecGP_ASM extends Crecimiento {

        private static final long serialVersionUID = -5850333717887320251L;

        private CrecGP_ASM() {
            super(0, 1, 1, 0, 1, R.string.gp_asmGrow);
        }

    }

    private static class CrecGS_AP extends Crecimiento {

        private static final long serialVersionUID = 8938653209776162613L;

        private CrecGS_AP() {
            super(0, 1, 0, 1, 2, R.string.gs_apGrow);
        }

    }

    private static class CrecGS_APM extends Crecimiento {

        private static final long serialVersionUID = -7917082745693850443L;

        private CrecGS_APM() {
            super(0, 1, 0, 1, 1, R.string.gs_apmGrow);
        }

    }

    private static class CrecGSM_AP extends Crecimiento {

        private static final long serialVersionUID = -1610176931727448496L;

        private CrecGSM_AP() {
            super(0, 1, 0, 1, 0, R.string.gsm_apGrow);
        }

    }

    private static class CrecGSPM_A extends Crecimiento {

        private static final long serialVersionUID = -4472067683359295037L;

        private CrecGSPM_A() {
            super(0, 1, 0, 0, 0, R.string.gspm_aGrow);
        }

    }

    private static class CrecS_GAP extends Crecimiento {

        private static final long serialVersionUID = -9064289645924747867L;

        private CrecS_GAP() {
            super(1, 1, 0, 1, 2, R.string.s_gapGrow);
        }

    }

    private static class CrecS_GAPM extends Crecimiento {

        private static final long serialVersionUID = -3496834175117578033L;

        private CrecS_GAPM() {
            super(1, 1, 0, 1, 1, R.string.s_gapmGrow);
        }

    }


    private static class CrecSM_GAP extends Crecimiento {

        private static final long serialVersionUID = -1441790159942891328L;

        private CrecSM_GAP() {
            super(1, 1, 0, 1, 0, R.string.sm_gapGrow);
        }

    }

}
