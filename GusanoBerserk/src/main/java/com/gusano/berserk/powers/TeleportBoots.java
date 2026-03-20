package com.gusano.berserk.powers;

import com.gusano.berserk.Character;
import com.gusano.berserk.CharacterDecorator;
import com.gusano.berserk.SpriteBuilder;

public class TeleportBoots extends CharacterDecorator {
    public TeleportBoots(Character base) {
        super(base);
    }

    @Override
    public int getSpeed() {
        return 99;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Botas Teletransporte";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fuse(super.getSprite(), bootsLayer());
    }

    private String bootsLayer() {
        return """
                _/\\_                         _/\\_
             __/ @@ \\__                   __/ @@ \\__
           _/  /##\\  \\_                 _/  /##\\  \\_
          /___/____\\___\\               /___/____\\___\\
        """;
    }
}

