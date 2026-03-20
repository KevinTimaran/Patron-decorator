package com.gusano.berserk;

public interface Personaje {
    int getVida();

    int getAtaque();

    int getDefensa();

    int getVelocidad();

    String getSprite();

    String getDescripcion();

    String recibirDano(int cantidad);
}

