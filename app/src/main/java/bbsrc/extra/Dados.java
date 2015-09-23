package bbsrc.extra;

import java.util.Random;


public final class Dados {

    private static final Random random = new Random();

    public static boolean tirarUnaMoneda() {
        return random.nextBoolean();
    }

    public static int tirarUnDadoD3() {
        return random.nextInt(3) + 1;
    }

    public static int tirarUnDadoD6() {
        return random.nextInt(6) + 1;
    }

    public static int tirarUnDadoD8() {
        return random.nextInt(8) + 1;
    }

    public static int seleccionarJugador(int jugadores) {
        return random.nextInt(jugadores) + 1;
    }

    public static int tiradaD6D8() {
        return tirarUnDadoD6() * 10 + tirarUnDadoD8();
    }

    public static int sumarDosDadosD6() {
        return tirarUnDadoD6() + tirarUnDadoD6();
    }

    public static int sumarTresDadosD6() {
        return tirarUnDadoD6() + tirarUnDadoD6() + tirarUnDadoD6();
    }

    public static int[] tirarDosDadosD6() {
        return new int[]{tirarUnDadoD6(), tirarUnDadoD6()};
    }

    public static int[] tirarTresDadosD6() {
        return new int[]{tirarUnDadoD6(), tirarUnDadoD6(), tirarUnDadoD6()};
    }

    public static boolean dosDadosD6doble(int dado1, int dado2) {
        if (dado1 == dado2)
            return true;
        return false;
    }

    public static int sumarDosDadosD6doble(boolean doble) {
        int[] dados = tirarDosDadosD6();
        doble = dosDadosD6doble(dados[0], dados[1]);
        return dados[0] + dados[1];
    }

    public static int[] tirarDosDadosD6doble(boolean doble) {
        int[] dados = tirarDosDadosD6();
        doble = dosDadosD6doble(dados[0], dados[1]);
        return dados;
    }

    public static String resultadoPlacar(int dado) {
        switch (dado) {
            case 1:
                return "Atacante Derribado";
            case 2:
                return "Ambos Derribados";
            case 3:
            case 4:
                return "Empujado";
            case 5:
                return "Defensor Cede";
            case 6:
                return "Defensor Derribado";
        }
        return "";
    }

}
