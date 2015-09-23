package bbsrc.jugadores;

import com.example.ja2brador.bloodbowl.R;

import java.io.Serializable;

public abstract class MejoraRealizada implements Serializable {

    public final static Movimiento1p movimiento1p = new Movimiento1p();
    public final static Armadura1p armadura1p = new Armadura1p();
    public final static Agilidad1p agilidad1p = new Agilidad1p();
    public final static Fuerza1p fuerza1p = new Fuerza1p();

    private final static int coste30 = 30;
    private final int mejora, coste;

    private MejoraRealizada(int mejora, int coste) {
        this.mejora = mejora;
        this.coste = coste;
    }

    public int getMejora() {
        return mejora;
    }

    public int getCoste() {
        return coste;
    }

    public abstract class HabilidadAprendida extends MejoraRealizada {

        private static final long serialVersionUID = 3415782853029005193L;

        private HabilidadAprendida(int skill, int coste) {
            super(skill, coste);
        }

    }

    private class HabNormal extends HabilidadAprendida {

        private static final long serialVersionUID = 8726443012378369569L;

        public HabNormal(int skill) {
            super(skill, 20);
        }

    }

    private class HabDoble extends HabilidadAprendida {

        private static final long serialVersionUID = 4834982078914744690L;

        public HabDoble(int skill) {
            super(skill, coste30);
        }

    }

    private static class Movimiento1p extends MejoraRealizada {

        private static final long serialVersionUID = 1278299297939282810L;

        private Movimiento1p() {
            super(R.string.movement1p, coste30);
        }

    }

    private static class Armadura1p extends MejoraRealizada {

        private static final long serialVersionUID = -6035220212037680608L;

        private Armadura1p() {
            super(R.string.armorvalue1p, coste30);
        }

    }

    private static class Agilidad1p extends MejoraRealizada {

        private static final long serialVersionUID = 5881697427585858101L;

        private Agilidad1p() {
            super(R.string.agility1p, 40);
        }

    }

    private static class Fuerza1p extends MejoraRealizada {

        private static final long serialVersionUID = 9120249538211551831L;

        private Fuerza1p() {
            super(R.string.strength1p, 50);
        }

    }

}
