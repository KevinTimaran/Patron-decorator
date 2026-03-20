package com.gusano.berserk.buffs;

import com.gusano.berserk.DecoradorBase;
import com.gusano.berserk.Personaje;
import com.gusano.berserk.SpriteBuilder;

public class AlientoFuego extends DecoradorBase {
    public AlientoFuego(Personaje base) {
        super(base);
    }

    @Override
    public int getAtaque() {
        return super.getAtaque() + 9;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Aliento Fuego";
    }

    @Override
    public String getSprite() {
        return SpriteBuilder.fusionar(super.getSprite(), capaFuego());
    }

    private String capaFuego() {
        return """




+ + + + + + + + + + + + + + + + + + + + +
+   .  .   .   .   .   .   .   .   .   . +
+    \\ | /     \\ | /    \\ | /     \\ | /  +
+   -- @ --   -- @ --  -- @ --   -- @ -- +
+    / | \\     / | \\    / | \\     / | \\  +
+ + + + + + + + + + + + + + + + + + + + +
        """;
    }
}

