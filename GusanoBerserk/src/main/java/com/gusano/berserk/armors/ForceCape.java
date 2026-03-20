package com.gusano.berserk.armors;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class ForceCape extends CharacterDecorator {
    public ForceCape(Character base) {
        super(base);
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 7;
    }

    @Override
    public int getHealth() {
        return Math.max(1, super.getHealth() - 12);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Capa Fuerza";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), capeLayer());
    }

    private String capeLayer() {
        return """
         /#####################################\\
        /#######################################\\
       /###########______________###############\\
       |##########/              \\##############|
       |#########/                \\#############|
       |########/                  \\############|
        \\______/                    \\__________/
        """;
    }
}

