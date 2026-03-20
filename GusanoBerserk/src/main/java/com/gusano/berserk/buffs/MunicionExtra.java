package com.gusano.berserk.buffs;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class MunicionExtra extends DecoradorBase {
    public MunicionExtra(Personaje base) {
        super(base);
    }

    @Override
    public int getAtaque() {
        return super.getAtaque();
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Municion Extra";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaMunicion());
    }

    private String capaMunicion() {
        return """




                          [====] [====] [====]
                          |####| |####| |####|
                          [====] [====] [====]
                            ||     ||     ||
                            ||_____||_____||
        """;
    }
}

