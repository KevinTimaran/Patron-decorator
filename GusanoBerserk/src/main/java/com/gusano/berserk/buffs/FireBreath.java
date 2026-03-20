package com.gusano.berserk.buffs;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class FireBreath extends CharacterDecorator {
    public FireBreath(Character base) {
        super(base);
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 9;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Aliento Fuego";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), fireLayer());
    }

    private String fireLayer() {
        return """
            + + + + + + + + + + + + + + + + + + + + +
            +   .  .   .   .   .   .   .   .   .   . +
            +    \\ | /     \\ | /    \\ | /     \\ | /  +
            +   -- @ --   -- @ --  -- @ --   -- @ -- +
            +    / | \\     / | \\    / | \\     / | \\  +
            + + + + + + + + + + + + + + + + + + + + +
        """;
    }
}

