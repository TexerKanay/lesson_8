package kg.my.game.template;

import kg.my.game.template.Boss;
import kg.my.game.template.Hero;
import kg.my.game.template.SuperAbility;

public class Reaper extends Hero {
    private final int maxHealth;

    public Reaper(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BUM);
        this.maxHealth = health;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int multiplier = 1;

        if (this.getHealth() < 0.15 * this.maxHealth) {
            multiplier = 3;
        } else if (this.getHealth() < 0.30 * this.maxHealth) {
            multiplier = 2;
        }

        boss.setHealth(boss.getHealth() - multiplier * this.getDamage());
        System.out.println("Reaper " + this.getName() + " нанес урон с множителем " + multiplier);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int thatRound) {
    }
}
