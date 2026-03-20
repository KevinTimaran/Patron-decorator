package com.gusano.berserk.weapons;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class HeavySword extends CharacterDecorator {
    public HeavySword(Character base) {
        super(base);
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 14;
    }

    @Override
    public int getSpeed() {
        return Math.max(1, super.getSpeed() - 2);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Espada Pesada";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), swordLayer());
    }

    private String swordLayer() {
        return """
                       /\\
                      /  \\
                     / /\\ \\
                    / /  \\ \\
                   /_/____\\_\\
                     ||  ||
                     ||  ||
                     ||==||
                   __||__||__
                  /___/__\\___\\
        """;
    }
}

