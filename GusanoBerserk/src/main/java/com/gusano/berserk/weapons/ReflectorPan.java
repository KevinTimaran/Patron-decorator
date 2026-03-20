package com.gusano.berserk.weapons;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class ReflectorPan extends CharacterDecorator {
    public ReflectorPan(Character base) {
        super(base);
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 2;
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 11;
    }

    @Override
    public int getSpeed() {
        return Math.max(1, super.getSpeed() - 1);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Sarten Reflector";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), panLayer());
    }

    private String panLayer() {
        return """
                              .-########-.
                            .'##########'.
                           /##############\\
                           |##############|=========
                           \\##############/
                            '.__######__.'
                                 ||
                                 ||
        """;
    }
}

