package com.gusano.berserk.buffs;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class ExtraAmmo extends CharacterDecorator {
    public ExtraAmmo(Character base) {
        super(base);
    }

    @Override
    public int getAttack() {
        if (super.getDescription().contains("AK47")) {
            return super.getAttack() + 16;
        }
        return super.getAttack();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Municion Extra";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), ammoLayer());
    }

    private String ammoLayer() {
        return """
                      [====] [====] [====]
                      |####| |####| |####|
                      [====] [====] [====]
                        ||     ||     ||
                        ||_____||_____||
        """;
    }
}

