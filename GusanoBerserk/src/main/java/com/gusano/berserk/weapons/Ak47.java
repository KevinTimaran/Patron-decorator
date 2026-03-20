package com.gusano.berserk.weapons;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class Ak47 extends CharacterDecorator {
    public Ak47(Character base) {
        super(base);
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 4;
    }

    @Override
    public int getSpeed() {
        return Math.max(1, super.getSpeed() - 2);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + AK47 (requiere Municion Extra)";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), akLayer());
    }

    private String akLayer() {
        return """
                                        ____
                                __====|____|====>
                            ___/_____/____/____
                           /___/___/___/___/ /|
                              /___/      /_/ |
                              \\___\\_____/___/
                                  ||   ||
                                  ||___||
                                   /___\\
        """;
    }
}

