package com.gusano.berserk.poderes;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class RodillerasRebote extends DecoradorBase {
    public RodillerasRebote(Personaje base) {
        super(base);
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() + 3;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Rodilleras Rebote";
    }

    @Override
    public String recibirDano(int cantidad) {
        int reducido = Math.max(0, cantidad - 3);
        return base.recibirDano(reducido) + " Rebote parcial activado: dano reflejado.";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaRodilleras());
    }

    private String capaRodilleras() {
        return """






                    ((====))               ((====))
                   ((  @@  ))             ((  @@  ))
                    ((====))               ((====))
                      ||||                   ||||
        """;
    }
}

