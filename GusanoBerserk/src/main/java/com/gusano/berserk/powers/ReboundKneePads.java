package com.gusano.berserk.powers;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class ReboundKneePads extends CharacterDecorator {
    public ReboundKneePads(Character base) {
        super(base);
    }

    @Override
    public int getDefense() {
        return super.getDefense() + 3;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Rodilleras Rebote";
    }

    @Override
    public String receiveDamage(int amount) {
        int reduced = Math.max(0, amount - 3);
        return base.receiveDamage(reduced) + " Rebote parcial activado: dano reflejado.";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), kneePadLayer());
    }

    private String kneePadLayer() {
        return """
                ((====))               ((====))
               ((  @@  ))             ((  @@  ))
                ((====))               ((====))
                  ||||                   ||||
        """;
    }
}

