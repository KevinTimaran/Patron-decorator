package com.gusano.berserk;

public interface Character {
    int getHealth();

    int getAttack();

    int getDefense();

    int getSpeed();

    String getSprite();

    String getDescription();

    String receiveDamage(int amount);
}

