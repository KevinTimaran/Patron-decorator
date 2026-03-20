package com.gusano.berserk;

public abstract class DecoradorBase implements Personaje {
    protected final Personaje base;

    protected DecoradorBase(Personaje base) {
        this.base = base;
    }

    @Override
    public int getVida() {
        return base.getVida();
    }

    @Override
    public int getAtaque() {
        return base.getAtaque();
    }

    @Override
    public int getDefensa() {
        return base.getDefensa();
    }

    @Override
    public int getVelocidad() {
        return base.getVelocidad();
    }

    @Override
    public String getSprite() {
        return base.getSprite();
    }

    @Override
    public String getDescripcion() {
        return base.getDescripcion();
    }

    @Override
    public String recibirDano(int cantidad) {
        return base.recibirDano(cantidad);
    }
}

