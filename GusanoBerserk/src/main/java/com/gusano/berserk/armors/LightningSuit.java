package com.gusano.berserk.armors;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class LightningSuit extends CharacterDecorator {
    public LightningSuit(Character base) {
        super(base);
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 12;
    }

    @Override
    public int getSpeed() {
        return Math.max(1, super.getSpeed() - 3);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Traje AntiRayos";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), suitLayer());
    }

    private String suitLayer() {
        return """
            |   /\\   /\\   /\\   /\\   /\\   /\\   |
            |  /__\\ /__\\ /__\\ /__\\ /__\\ /__\\  |
            |   \\/   \\/   \\/   \\/   \\/   \\/   |
            |   /\\   /\\   /\\   /\\   /\\   /\\   |
            |  /__\\ /__\\ /__\\ /__\\ /__\\ /__\\  |
            |_________________________________|
        """;
    }
}

