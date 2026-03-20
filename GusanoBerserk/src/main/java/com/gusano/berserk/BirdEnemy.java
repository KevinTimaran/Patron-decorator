package com.gusano.berserk;

public class BirdEnemy implements Character {
    private int health = 100;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return 15;
    }

    @Override
    public int getDefense() {
        return 6;
    }

    @Override
    public int getSpeed() {
        return 12;
    }

    @Override
    public String getSprite() {
        return """
                 ________________
            _.-'  _  _  _  _   '-._
         .-'   .-` \\/ \\/ \\/ `-.    '-.
       .'    .'    / /\\ /\\    '.      '.
      /    .'  _.-'_/  V  \\_'-._'.      \\
     /    / .-'  .-\\  /\\  /-.  '-.\\      \\
    |    | /    /   \\/  \\/   \\    \\ |     |
    |    | |   |   @    @    |   | |     |
    |    | |   |      /\\      |   | |     |
     \\    \\ \\   \\   .----.   /   / /     /
      \\    '. '-._'-.____.-'_.-' .'     /
       '.    '-._  /| /\\ |\\  _.-'     .'
         '-._    '-\\|/  \\|/-'     _.-'
              '--..__\\__/__..--'
        """;
    }

    @Override
    public String getDescription() {
        return "Pajaro Enemigo";
    }

    @Override
    public String receiveDamage(int amount) {
        int realDamage = Math.max(0, amount - getDefense());
        health = Math.max(0, health - realDamage);
        return "Pajaro recibe " + realDamage + " de dano.";
    }
}

