package com.gusano.berserk;

public class PajaroEnemigo implements Personaje {
    private int vidaActual = 100;

    @Override
    public int getVida() {
        return vidaActual;
    }

    @Override
    public int getAtaque() {
        return 15;
    }

    @Override
    public int getDefensa() {
        return 6;
    }

    @Override
    public int getVelocidad() {
        return 12;
    }

    @Override
    public String getSprite() {
        return """
                     ________________
                _.-'  _  _  _  _   '-._
             .-'   .-` \\/ \\/ \\/ `-.    '-.
           .'    .'    / /\\ /\\    '.      '.
          /    .'  _.-'_/  V  \\_'-._'.      \\
         /    / .-'  .-\\  /\\  /-.  '-.\\      \\
        |    | /    /   \\/  \\/   \\    \\ |     |
        |    | |   |   @    @    |   | |     |
        |    | |   |      /\\      |   | |     |
         \\    \\ \\   \\   .----.   /   / /     /
          \\    '. '-._'-.____.-'_.-' .'     /
           '.    '-._  /| /\\ |\\  _.-'     .'
             '-._    '-\\|/  \\|/-'     _.-'
                  '--..__\\__/__..--'
        """;
    }

    @Override
    public String getDescripcion() {
        return "Pajaro Enemigo";
    }

    @Override
    public String recibirDano(int cantidad) {
        int danoReal = Math.max(0, cantidad - getDefensa());
        vidaActual = Math.max(0, vidaActual - danoReal);
        return "Pajaro recibe " + danoReal + " de dano.";
    }
}

