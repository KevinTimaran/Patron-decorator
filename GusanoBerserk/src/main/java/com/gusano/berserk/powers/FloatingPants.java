package com.gusano.berserk.powers;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class FloatingPants extends CharacterDecorator {
    public FloatingPants(Character base) {
        super(base);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + 5;
    }

    @Override
    public int getDefense() {
        return super.getDefense() - 1;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Pantalones Flotantes (ignora trampas)";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), pantsLayer());
    }

    private String pantsLayer() {
        return """
              ____        ________        ____
             / __ \\______/ ______ \\______/ __ \\
            | |  | | @  @ | #### | @  @ | |  |
            | |__| |______|______|______| |__|
             \\____/                        \\____/
        """;
    }
}

