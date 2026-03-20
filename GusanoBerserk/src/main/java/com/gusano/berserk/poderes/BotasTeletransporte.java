package com.gusano.berserk.poderes;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class BotasTeletransporte extends DecoradorBase {
    public BotasTeletransporte(Personaje base) {
        super(base);
    }

    @Override
    public int getVelocidad() {
        return 99;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Botas Teletransporte";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaBotas());
    }

    private String capaBotas() {
        return """






                    _/\\_                         _/\\_
                 __/ @@ \\__                   __/ @@ \\__
               _/  /##\\  \\_                 _/  /##\\  \\_
              /___/____\\___\\               /___/____\\___\\
        """;
    }
}

