package com.gusano.berserk.armaduras;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class CascoCaballero extends DecoradorBase {
    public CascoCaballero(Personaje base) {
        super(base);
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() + 8;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Casco Caballero";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaCasco());
    }

    private String capaCasco() {
        return """
                     _________________________
                  .-'#########################'-.
                 /######### ___   ___ ##########\\
                /######### /###\\ /###\\ ##########\\
                |######### |###| |###| ##########|
                |######### |___|_|___| ##########|
                |#########   /  _  \\   ##########|
                |#########  |  |_|  |  ##########|
                |#########   \\_____/   ##########|



        """;
    }
}

