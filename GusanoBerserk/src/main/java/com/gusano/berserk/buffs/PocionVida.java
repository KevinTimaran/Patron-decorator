package com.gusano.berserk.buffs;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class PocionVida extends DecoradorBase {
    public PocionVida(Personaje base) {
        super(base);
    }

    @Override
    public int getVida() {
        return super.getVida() + 50;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Pocion Vida";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaPocion());
    }

    private String capaPocion() {
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

