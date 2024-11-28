package kg.my.game.heroes;

import kg.my.game.template.*;

import java.util.Random;

public class Antman extends Hero {
    private final Random random = new Random();
    private int originalHealth;
    private int originalDamage;

    public Antman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CHANGE_SIZE);
        this.originalHealth = health;
        this.originalDamage = damage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int currentRound) {
        int sizeFactor = random.nextInt(3) - 1;
        if (sizeFactor != 0) {
            setHealth(originalHealth + sizeFactor * 50);
            setDamage(originalDamage + sizeFactor * 10);
            System.out.println(getName() + " изменил размер  " + getHealth() + " урон " + getDamage());
        }
    }
}

