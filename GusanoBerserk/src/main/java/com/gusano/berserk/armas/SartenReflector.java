package com.gusano.berserk.armas;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class SartenReflector extends DecoradorBase {
    public SartenReflector(Personaje base) {
        super(base);
    }

    @Override
    public int getAtaque() {
        return super.getAtaque() + 2;
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() + 11;
    }

    @Override
    public int getVelocidad() {
        return Math.max(1, super.getVelocidad() - 1);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Sarten Reflector";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaSarten());
    }

    private String capaSarten() {
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

