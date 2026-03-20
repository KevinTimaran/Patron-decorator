package com.gusano.berserk.poderes;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class PantalonesFlotantes extends DecoradorBase {
    public PantalonesFlotantes(Personaje base) {
        super(base);
    }

    @Override
    public int getVelocidad() {
        return super.getVelocidad() + 5;
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() - 1;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Pantalones Flotantes (ignora trampas)";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaPantalones());
    }

    private String capaPantalones() {
        return """





                  ____        ________        ____
                 / __ \\______/ ______ \\______/ __ \\
                | |  | | @  @ | #### | @  @ | |  |
                | |__| |______|______|______| |__|
                 \\____/                        \\____/

        """;
    }
}

