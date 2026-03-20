package com.gusano.berserk.armas;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class EspadaPesada extends DecoradorBase {
    public EspadaPesada(Personaje base) {
        super(base);
    }

    @Override
    public int getAtaque() {
        return super.getAtaque() + 14;
    }

    @Override
    public int getVelocidad() {
        return Math.max(1, super.getVelocidad() - 2);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Espada Pesada";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaEspada());
    }

    private String capaEspada() {
        return """
                           /\\
                          /  \\
                         / /\\ \\
                        / /  \\ \\
                       /_/____\\_\\
                         ||  ||
                         ||  ||
                         ||==||
                       __||__||__
                      /___/__\\___\\


        """;
    }
}

