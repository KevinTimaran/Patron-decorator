package com.gusano.berserk.armors;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class KnightHelmet extends CharacterDecorator {
    public KnightHelmet(Character base) {
        super(base);
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 8;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Casco Caballero";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), helmetLayer());
    }

    private String helmetLayer() {
        return """
                 _________________________
              .-'#########################'-.
             /######### ___   ___ ##########\\
            /######### /###\\ /###\\ ##########\\
            |######### |###| |###| ##########|
            |######### |___|_|___| ##########|
            |#########   /  _  \\   ##########|
            |#########  |  |_|  |  ##########|
            |#########   \\_____/   ##########|
        """;
    }
}

