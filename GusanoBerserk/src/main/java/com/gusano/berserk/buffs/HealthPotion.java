package com.gusano.berserk.buffs;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class HealthPotion extends CharacterDecorator {
    public HealthPotion(Character base) {
        super(base);
    }

    @Override
    public int getHealth() {
        return super.getHealth() + 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Pocion Vida";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), potionLayer());
    }

    private String potionLayer() {
        return """
                          ____
                         / __ \\
                        | |  | |
                        | |++| |
                        | |__| |
                         \\____/
        """;
    }
}

