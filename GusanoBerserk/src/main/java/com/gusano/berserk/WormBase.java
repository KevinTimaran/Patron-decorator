package com.gusano.berserk;

public class WormBase implements Character {
    private int health = 120;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return 16;
    }

    @Override
    public int getDefense() {
        return 10;
    }

    @Override
    public int getSpeed() {
        return 8;
    }

    @Override
    public String getSprite() {
        return """
                  ______________________________
             _.-'______________________________'-._
           .'     _   _                 _   _      '.
          /      (@) (@)               (@) (@)       \\
         /      /  _---_\\             /_---_  \\       \\
        |      |  /  _  \\   _____    /  _  \\  |       |
        |      | |  |_|  | / ___ \\  |  |_|  | |       |
        |      |  \\_____/ / /___\\ \\  \\_____/  |       |
        |       \\        /_/|___|\\_\\        /        |
         \\       '.___.'   / ___ \\   '.___.'        /
          \\___________ ___/ /   \\ \\___ ____________/
           /_________\\_____/_____/_____\\/_________\\
        """;
    }

    @Override
    public String getDescription() {
        return "Gusano Base";
    }

    @Override
    public String receiveDamage(int amount) {
        int realDamage = Math.max(0, amount - getDefense());
        health = Math.max(0, health - realDamage);
        return "Gusano recibe " + realDamage + " de dano.";
    }
}

