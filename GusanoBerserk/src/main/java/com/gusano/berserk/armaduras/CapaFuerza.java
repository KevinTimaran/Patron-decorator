package com.gusano.berserk.armaduras;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class CapaFuerza extends DecoradorBase {
    public CapaFuerza(Personaje base) {
        super(base);
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() + 5;
    }

    @Override
    public int getAtaque() {
        return super.getAtaque() + 7;
    }

    @Override
    public int getVida() {
        return Math.max(1, super.getVida() - 12);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Capa Fuerza";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capa());
    }

    private String capa() {
        return """


             /#####################################\
            /#######################################\\
           /###########______________###############\\
           |##########/              \\##############|
           |#########/                \\#############|
           |########/                  \\############|
            \\______/                    \\__________/


        """;
    }
}

