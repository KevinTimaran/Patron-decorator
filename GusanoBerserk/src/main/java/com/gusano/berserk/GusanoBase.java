package com.gusano.berserk;

public class GusanoBase implements Personaje {
    private int vidaActual = 120;

    @Override
    public int getVida() {
        return vidaActual;
    }

    @Override
    public int getAtaque() {
        return 16;
    }

    @Override
    public int getDefensa() {
        return 10;
    }

    @Override
    public int getVelocidad() {
        return 8;
    }

    @Override
    public String getSprite() {
        return """
                      ______________________________
                 _.-'______________________________'-._
               .'     _   _                 _   _      '.
              /      (@) (@)               (@) (@)       \\
             /      /  _---_\\             /_---_  \\       \\
            |      |  /  _  \\   _____    /  _  \\  |       |
            |      | |  |_|  | / ___ \\  |  |_|  | |       |
            |      |  \\_____/ / /___\\ \\  \\_____/  |       |
            |       \\        /_/|___|\\_\\        /        |
             \\       '.___.'   / ___ \\   '.___.'        /
              \\___________ ___/ /   \\ \\___ ____________/
               /_________\\_____/_____/_____\\/_________\\
        """;
    }

    @Override
    public String getDescripcion() {
        return "Gusano Base";
    }

    @Override
    public String recibirDano(int cantidad) {
        int danoReal = Math.max(0, cantidad - getDefensa());
        vidaActual = Math.max(0, vidaActual - danoReal);
        return "Gusano recibe " + danoReal + " de dano.";
    }
}

