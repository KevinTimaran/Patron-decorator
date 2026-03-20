package com.gusano.berserk;

public abstract class CharacterDecorator implements Character {
    protected final Character base;

    protected CharacterDecorator(Character base) {
        this.base = base;
    }

    @Override
    public int getHealth() {
        return base.getHealth();
    }

    @Override
    public int getAttack() {
        return base.getAttack();
    }

    @Override
    public int getDefense() {
        return base.getDefense();
    }

    @Override
    public int getSpeed() {
        return base.getSpeed();
    }

    @Override
    public String getSprite() {
        return base.getSprite();
    }

    @Override
    public String getDescription() {
        return base.getDescription();
    }

    @Override
    public String receiveDamage(int amount) {
        return base.receiveDamage(amount);
    }
}

