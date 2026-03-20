package com.gusano.berserk.armas;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class AK47 extends DecoradorBase {
    public AK47(Personaje base) {
        super(base);
    }

    @Override
    public int getAtaque() {
        return super.getAtaque() + 4;
    }

    @Override
    public int getVelocidad() {
        return Math.max(1, super.getVelocidad() - 2);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + AK47 (requiere Municion Extra)";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaAK47());
    }

    private String capaAK47() {
        return """



                                            ____
                                    __====|____|====>
                                ___/_____/____/____
                               /___/___/___/___/ /|
                                  /___/      /_/ |
                                  \\___\\_____/___/
                                      ||   ||
                                      ||___||
                                       /___\\

        """;
    }
}

