package bbsrc.extra;

import com.example.ja2brador.bloodbowl.R;

import java.io.Serializable;

public abstract class Habilidad implements Serializable {

    private static final long serialVersionUID = -869201954518527491L;

    private final int nombre;
    private boolean activo;
    private final boolean preguntar;

    public final static AbrirsePaso abrirsepaso = new AbrirsePaso();
    public final static Agallas agallas = new Agallas();
    public final static AgilidadFelina agilidadfelina = new AgilidadFelina();
    public final static AnimalSalvaje animalsalvaje = new AnimalSalvaje();
    public final static Animosidad animosidad = new Animosidad();
    public final static Anticiparse anticiparse = new Anticiparse();
    public final static AparienciaAsquerosa aparienciaasquerosa = new AparienciaAsquerosa();
    public final static Apartar apartar = new Apartar();
    public final static Aplastar aplastar = new Aplastar();
    public final static ArmaSecreta armasecreta = new ArmaSecreta();
    public final static Atrapar atrapar = new Atrapar();
    public final static BloquearPase bloquearpase = new BloquearPase();
    public final static BolaConCadena bolaconcadena = new BolaConCadena();
    public final static Bombardero bombardero = new Bombardero();
    public final static BrazoFuerte brazofuerte = new BrazoFuerte();
    public final static BrazosAdicionales brazosadicionales = new BrazosAdicionales();
    public final static CabezaDura cabezadura = new CabezaDura();
    public final static CabezaHueca cabezahueca = new CabezaHueca();
    public final static Canijo canijo = new Canijo();
    public final static Carrera carrera = new Carrera();
    public final static ColaPrensil colaprensil = new ColaPrensil();
    public final static Cuernos cuernos = new Cuernos();
    public final static Defensa defensa = new Defensa();
    public final static Degenerar degenerar = new Degenerar();
    public final static DosCabezas doscabezas = new DosCabezas();
    public final static EcharRaices echarraices = new EcharRaices();
    public final static EcharseAUnLado echarseaunlado = new EcharseAUnLado();
    public final static EnPieDeUnSalto enpiedeunsalto = new EnPieDeUnSalto();
    public final static Escurridizo escurridizo = new Escurridizo();
    public final static Esquivar esquivar = new Esquivar();
    public final static Estacas estacas = new Estacas();
    public final static FavoritoDelPublico favoritodelpublico = new FavoritoDelPublico();
    public final static Forcejeo forcejeo = new Forcejeo();
    public final static Furia furia = new Furia();
    public final static Garras garras = new Garras();
    public final static GolpeMortifero golpemortifero = new GolpeMortifero();
    public final static JuegoSucio juegosucio = new JuegoSucio();
    public final static Juggernaut juggernaut = new Juggernaut();
    public final static LanzarCompaneroDeEquipo lanzarcompanerodeequipo = new LanzarCompaneroDeEquipo();
    public final static Lider lider = new Lider();
    public final static ManoGrande manogrande = new ManoGrande();
    public final static ManosSeguras manosseguras = new ManosSeguras();
    public final static MantenerseFirme mantenersefirme = new MantenerseFirme();
    public final static MiradaHipnotica miradahipnotica = new MiradaHipnotica();
    public final static NerviosDeAcero nerviosdeacero = new NerviosDeAcero();
    public final static Pasar pasar = new Pasar();
    public final static PaseALoLoco pasealoloco = new PaseALoLoco();
    public final static PasePrecipitado paseprecipitado = new PasePrecipitado();
    public final static PaseSeguro paseseguro = new PaseSeguro();
    public final static Patada patada = new Patada();
    public final static Perseguir perseguir = new Perseguir();
    public final static PiesFirmes piesfirmes = new PiesFirmes();
    public final static PiernasMuyLargas piernasmuylargas = new PiernasMuyLargas();
    public final static PlacajeDefensivo placajedefensivo = new PlacajeDefensivo();
    public final static PlacajeHeroico placajeheroico = new PlacajeHeroico();
    public final static PlacajeMultiple placajemultiple = new PlacajeMultiple();
    public final static Placar placar = new Placar();
    public final static Precision precision = new Precision();
    public final static PresenciaPerturbadora presenciaperturbadora = new PresenciaPerturbadora();
    public final static Profesional profesional = new Profesional();
    public final static Punal punal = new Punal();
    public final static PutrefaccionDeNurgle putrefacciondenurgle = new PutrefaccionDeNurgle();
    public final static Rastrero rastrero = new Rastrero();
    public final static RealmenteEstupido realmenteestupido = new RealmenteEstupido();
    public final static RecepcionHeroica recepcionheroica = new RecepcionHeroica();
    public final static Regenerar regenerar = new Regenerar();
    public final static RobarBalon robarbalon = new RobarBalon();
    public final static Saltar saltar = new Saltar();
    public final static SedDeSangre seddesangre = new SedDeSangre();
    public final static SiempreHambriento siemprehambriento = new SiempreHambriento();
    public final static SierraMecanica sierramecanica = new SierraMecanica();
    public final static SinManos sinmanos = new SinManos();
    public final static Solitario solitario = new Solitario();
    public final static Tentaculos tentaculos = new Tentaculos();
    public final static Zafarse zafarse = new Zafarse();

    private Habilidad(int nombre, boolean preguntar) {
        this.nombre = nombre;
        this.preguntar = preguntar;
    }

    public int getNombre() {
        return nombre;
    }

    public boolean necesitaConfirmacion() {
        return preguntar;
    }

    public boolean estaActivo() {
        return activo;
    }

    public void desactivar() {
        this.activo = false;
    }

    public void activar() {
        this.activo = true;
    }

    private static class Atrapar extends Habilidad {

        private static final long serialVersionUID = 3964366216774435457L;

        private Atrapar() {
            super(R.string.catchSkill, false);
        }

    }

    private static class Carrera extends Habilidad {

        private static final long serialVersionUID = 5322289746148167497L;

        private Carrera() {
            super(R.string.sprintSkill, true);
        }

    }

    private static class EcharseAUnLado extends Habilidad {

        private static final long serialVersionUID = -3116565567730293335L;

        private EcharseAUnLado() {
            super(R.string.sidestepSkill, false);
        }

    }

    private static class EnPieDeUnSalto extends Habilidad {

        private static final long serialVersionUID = -4559339877709840021L;

        private EnPieDeUnSalto() {
            super(R.string.jumpupSkill, false);
        }

    }

    private static class Esquivar extends Habilidad {

        private static final long serialVersionUID = -2442640771771985652L;

        private Esquivar() {
            super(R.string.dodgeSkill, false);
        }

    }

    private static class PiesFirmes extends Habilidad {

        private static final long serialVersionUID = -7753848514219573785L;

        private PiesFirmes() {
            super(R.string.surefeetSkill, false);
        }

    }

    private static class PlacajeHeroico extends Habilidad {

        private static final long serialVersionUID = 1068740600406015126L;

        private PlacajeHeroico() {
            super(R.string.divingtackleSkill, true);
        }

    }

    private static class Rastrero extends Habilidad {

        private static final long serialVersionUID = -1085707945760659063L;

        private Rastrero() {
            super(R.string.sneakygitSkill, false);
        }

    }

    private static class RecepcionHeroica extends Habilidad {

        private static final long serialVersionUID = -1808125428395822358L;

        private RecepcionHeroica() {
            super(R.string.divingcatchSkill, false);
        }

    }

    private static class Saltar extends Habilidad {

        private static final long serialVersionUID = -5800534849880791365L;

        private Saltar() {
            super(R.string.leapSkill, false);
        }

    }

    private static class AbrirsePaso extends Habilidad {

        private static final long serialVersionUID = 2283025501342070436L;

        private AbrirsePaso() {
            super(R.string.breaktackleSkill, false);
        }

    }

    private static class Apartar extends Habilidad {

        private static final long serialVersionUID = 5124101240382381142L;

        private Apartar() {
            super(R.string.grabSkill, false);
        }

    }

    private static class Aplastar extends Habilidad {

        private static final long serialVersionUID = -7795644145563093756L;

        private Aplastar() {
            super(R.string.pilingonSkill, true);
        }

    }

    private static class BrazoFuerte extends Habilidad {

        private static final long serialVersionUID = 3621223293378260787L;

        private BrazoFuerte() {
            super(R.string.strongarmSkill, false);
        }

    }

    private static class CabezaDura extends Habilidad {

        private static final long serialVersionUID = -3892021700251166133L;

        private CabezaDura() {
            super(R.string.thickskullSkill, false);
        }

    }

    private static class Defensa extends Habilidad {

        private static final long serialVersionUID = 7137776833410295471L;

        private Defensa() {
            super(R.string.guardSkill, false);
        }

    }

    private static class Juggernaut extends Habilidad {

        private static final long serialVersionUID = 2515429892735719613L;

        private Juggernaut() {
            super(R.string.juggernautSkill, true);
        }

    }

    private static class GolpeMortifero extends Habilidad {

        private static final long serialVersionUID = -3304731228516812718L;

        private GolpeMortifero() {
            super(R.string.mightyblowSkill, false);
        }

    }

    private static class MantenerseFirme extends Habilidad {

        private static final long serialVersionUID = 4621602286323362531L;

        private MantenerseFirme() {
            super(R.string.standfirmSkill, false);
        }

    }

    private static class PlacajeMultiple extends Habilidad {

        private static final long serialVersionUID = 5453519338092094873L;

        private PlacajeMultiple() {
            super(R.string.multipleblockSkill, true);
        }

    }

    private static class Agallas extends Habilidad {

        private static final long serialVersionUID = -7342605657039874770L;

        private Agallas() {
            super(R.string.dauntlessSkill, false);
        }

    }

    private static class Anticiparse extends Habilidad {

        private static final long serialVersionUID = -5228020832429572972L;

        private Anticiparse() {
            super(R.string.kickoffreturnSkill, false);
        }

    }

    private static class BloquearPase extends Habilidad {

        private static final long serialVersionUID = 7860192502766025109L;

        private BloquearPase() {
            super(R.string.passblockSkill, false);
        }

    }

    private static class Forcejeo extends Habilidad {

        private static final long serialVersionUID = 6097586115213303068L;

        private Forcejeo() {
            super(R.string.wrestleSkill, true);
        }

    }

    private static class Furia extends Habilidad {

        private static final long serialVersionUID = -2333966524096737206L;

        private Furia() {
            super(R.string.frenzySkill, false);
        }

    }

    private static class JuegoSucio extends Habilidad {

        private static final long serialVersionUID = 690417600462693387L;

        private JuegoSucio() {
            super(R.string.dirtyplayerSkill, false);
        }
    }

    private static class ManosSeguras extends Habilidad {

        private static final long serialVersionUID = 23906884606650757L;

        private ManosSeguras() {
            super(R.string.surehandsSkill, false);
        }

    }

    private static class Patada extends Habilidad {

        private static final long serialVersionUID = -7759935283882369486L;

        private Patada() {
            super(R.string.kickSkill, false);
        }

    }

    private static class Perseguir extends Habilidad {

        private static final long serialVersionUID = -1776462156709644336L;

        private Perseguir() {
            super(R.string.shadowingSkill, true);
        }

    }

    private static class PlacajeDefensivo extends Habilidad {

        private static final long serialVersionUID = -2606789061528897550L;

        private PlacajeDefensivo() {
            super(R.string.tackleSkill, false);
        }

    }

    private static class Placar extends Habilidad {

        private static final long serialVersionUID = -154447959876660927L;

        private Placar() {
            super(R.string.blockSkill, false);
        }

    }

    private static class Profesional extends Habilidad {

        private static final long serialVersionUID = 3871653340260641631L;

        private Profesional() {
            super(R.string.proSkill, true);
        }

    }

    private static class RobarBalon extends Habilidad {

        private static final long serialVersionUID = 3591826416703149565L;

        private RobarBalon() {
            super(R.string.stripballSkill, false);
        }

    }

    private static class Zafarse extends Habilidad {

        private static final long serialVersionUID = 3020036191000085812L;

        private Zafarse() {
            super(R.string.fendSkill, false);
        }

    }

    private static class AparienciaAsquerosa extends Habilidad {

        private static final long serialVersionUID = -8211811407737158880L;

        private AparienciaAsquerosa() {
            super(R.string.foulappearanceSkill, false);
        }

    }

    private static class BrazosAdicionales extends Habilidad {

        private static final long serialVersionUID = -2036216946742076421L;

        private BrazosAdicionales() {
            super(R.string.extraarmsSkill, false);
        }

    }

    private static class ColaPrensil extends Habilidad {

        private static final long serialVersionUID = 8328842228812178886L;

        private ColaPrensil() {
            super(R.string.prehensiletailSkill, false);
        }

    }

    private static class Cuernos extends Habilidad {

        private static final long serialVersionUID = -450225877592011419L;

        private Cuernos() {
            super(R.string.hornsSkill, false);
        }

    }

    private static class DosCabezas extends Habilidad {

        private static final long serialVersionUID = -5780943652088975034L;

        private DosCabezas() {
            super(R.string.twoheadsSkill, false);
        }

    }

    private static class Garras extends Habilidad {

        private static final long serialVersionUID = -3946882298158910511L;

        private Garras() {
            super(R.string.clawSkill, false);
        }

    }

    private static class ManoGrande extends Habilidad {

        private static final long serialVersionUID = 8696771193640797159L;

        private ManoGrande() {
            super(R.string.bighandSkill, false);
        }

    }

    private static class PiernasMuyLargas extends Habilidad {

        private static final long serialVersionUID = 8189158887796779856L;

        private PiernasMuyLargas() {
            super(R.string.verylonglegsSkill, false);
        }

    }

    private static class PresenciaPerturbadora extends Habilidad {

        private static final long serialVersionUID = -6189161552379794162L;

        private PresenciaPerturbadora() {
            super(R.string.disturbingpresenceSkill, false);
        }

    }

    private static class Tentaculos extends Habilidad {

        private static final long serialVersionUID = -6947867735035763136L;

        private Tentaculos() {
            super(R.string.tentaclesSkill, false);
        }

    }

    private static class Lider extends Habilidad {

        private static final long serialVersionUID = -8095449963708127782L;

        private Lider() {
            super(R.string.leaderSkill, false);
        }

    }

    private static class NerviosDeAcero extends Habilidad {

        private static final long serialVersionUID = -8439225321837530665L;

        private NerviosDeAcero() {
            super(R.string.nervesofsteelSkill, false);
        }

    }

    private static class Pasar extends Habilidad {

        private static final long serialVersionUID = 3983224323452244258L;

        private Pasar() {
            super(R.string.passSkill, false);
        }

    }

    private static class PaseALoLoco extends Habilidad {

        private static final long serialVersionUID = -8957653643468984423L;

        private PaseALoLoco() {
            super(R.string.hailmarypassSkill, false);
        }

    }

    private static class PasePrecipitado extends Habilidad {

        private static final long serialVersionUID = 8907132297426382475L;

        private PasePrecipitado() {
            super(R.string.dumpoffSkill, true);
        }

    }

    private static class PaseSeguro extends Habilidad {

        private static final long serialVersionUID = -5861337533594034915L;

        private PaseSeguro() {
            super(R.string.safethrowSkill, false);
        }

    }

    private static class Precision extends Habilidad {

        private static final long serialVersionUID = -8926097494806076820L;

        private Precision() {
            super(R.string.accurateSkill, false);
        }

    }

    private static class AgilidadFelina extends Habilidad {

        private static final long serialVersionUID = 1636950373728486596L;

        private AgilidadFelina() {
            super(R.string.rightstuffSkill, false);
        }

    }

    private static class AnimalSalvaje extends Habilidad {

        private static final long serialVersionUID = -3621494191508152495L;

        private AnimalSalvaje() {
            super(R.string.wildanimalSkill, false);
        }

    }

    private static class Animosidad extends Habilidad {

        private static final long serialVersionUID = -2882892021859846893L;

        private Animosidad() {
            super(R.string.animositySkill, false);
        }

    }

    private static class ArmaSecreta extends Habilidad {

        private static final long serialVersionUID = 7429845126510358253L;

        private ArmaSecreta() {
            super(R.string.secretweaponSkill, false);
        }

    }

    private static class BolaConCadena extends Habilidad {

        private static final long serialVersionUID = -436080199327548080L;

        private BolaConCadena() {
            super(R.string.ballchainSkill, false);
        }

    }

    private static class Bombardero extends Habilidad {

        private static final long serialVersionUID = -7988724598710289187L;

        private Bombardero() {
            super(R.string.bombardierSkill, false);
        }

    }

    private static class CabezaHueca extends Habilidad {

        private static final long serialVersionUID = 1389929555337539533L;

        private CabezaHueca() {
            super(R.string.boneheadSkill, false);
        }

    }

    private static class Canijo extends Habilidad {

        private static final long serialVersionUID = 2280927354858992067L;

        private Canijo() {
            super(R.string.titchySkill, false);
        }

    }

    private static class Degenerar extends Habilidad {

        private static final long serialVersionUID = 8674767329097485435L;

        private Degenerar() {
            super(R.string.decaySkill, false);
        }

    }

    private static class EcharRaices extends Habilidad {

        private static final long serialVersionUID = -7650116727337425608L;

        private EcharRaices() {
            super(R.string.takerootSkill, false);
        }

    }

    private static class Escurridizo extends Habilidad {

        private static final long serialVersionUID = -4228010531697310939L;

        private Escurridizo() {
            super(R.string.stuntySkill, false);
        }

    }

    private static class Estacas extends Habilidad {

        private static final long serialVersionUID = -1971502657578587278L;

        private Estacas() {
            super(R.string.stakesSkill, false);
        }

    }

    private static class FavoritoDelPublico extends Habilidad {

        private static final long serialVersionUID = -4710659268595266018L;

        private FavoritoDelPublico() {
            super(R.string.fanfavoriteSkill, false);
        }

    }

    private static class LanzarCompaneroDeEquipo extends Habilidad {

        private static final long serialVersionUID = -3912992031309528392L;

        private LanzarCompaneroDeEquipo() {
            super(R.string.throwteammateSkill, false);
        }

    }

    private static class MiradaHipnotica extends Habilidad {

        private static final long serialVersionUID = 2589752874914870786L;

        private MiradaHipnotica() {
            super(R.string.hypnoticgazeSkill, false);
        }

    }

    private static class Punal extends Habilidad {

        private static final long serialVersionUID = 6931831826735825994L;

        private Punal() {
            super(R.string.stabSkill, false);
        }

    }

    private static class PutrefaccionDeNurgle extends Habilidad {

        private static final long serialVersionUID = 5847236807650704288L;

        private PutrefaccionDeNurgle() {
            super(R.string.nurglesrotSkill, false);
        }

    }

    private static class RealmenteEstupido extends Habilidad {

        private static final long serialVersionUID = -7614896207083582741L;

        private RealmenteEstupido() {
            super(R.string.reallystupidSkill, false);
        }

    }

    private static class Regenerar extends Habilidad {

        private static final long serialVersionUID = -3287263398880005330L;

        private Regenerar() {
            super(R.string.regenerationSkill, false);
        }

    }

    private static class SedDeSangre extends Habilidad {

        private static final long serialVersionUID = 8207470266240179879L;

        private SedDeSangre() {
            super(R.string.bloodlustSkill, false);
        }

    }

    private static class SiempreHambriento extends Habilidad {

        private static final long serialVersionUID = 5733744882765700635L;

        private SiempreHambriento() {
            super(R.string.alwayshungrySkill, false);
        }

    }

    private static class SierraMecanica extends Habilidad {

        private static final long serialVersionUID = -7176966534995844276L;

        private SierraMecanica() {
            super(R.string.chainsawSkill, false);
        }

    }

    private static class SinManos extends Habilidad {

        private static final long serialVersionUID = 8282871448991812998L;

        private SinManos() {
            super(R.string.nohandsSkill, false);
        }

    }

    private static class Solitario extends Habilidad {

        private static final long serialVersionUID = 1935632216665452211L;

        private Solitario() {
            super(R.string.lonerSkill, false);
        }

    }

}
