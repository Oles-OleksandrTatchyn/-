package droidgame.droids;

import droidgame.Droid;

public class BattleDroid extends Droid {
    public BattleDroid(String name, int health, int damage, int regenerationRate, int poisonDamage, int currentPoisonLevel) {
        super(name, health, damage, regenerationRate, poisonDamage, currentPoisonLevel);
    }

    @Override
    public void specialAbility(Droid enemy) {

    }
}