package com.gusano.berserk.armaduras;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class TrajeAntiRayos extends DecoradorBase {
    public TrajeAntiRayos(Personaje base) {
        super(base);
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() + 12;
    }

    @Override
    public int getVelocidad() {
        return Math.max(1, super.getVelocidad() - 3);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Traje AntiRayos";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaTraje());
    }

    private String capaTraje() {
        return """



                |   /\\   /\\   /\\   /\\   /\\   /\\   |
                |  /__\\ /__\\ /__\\ /__\\ /__\\ /__\\  |
                |   \\/   \\/   \\/   \\/   \\/   \\/   |
                |   /\\   /\\   /\\   /\\   /\\   /\\   |
                |  /__\\ /__\\ /__\\ /__\\ /__\\ /__\\  |
                |_________________________________|


        """;
    }
}

