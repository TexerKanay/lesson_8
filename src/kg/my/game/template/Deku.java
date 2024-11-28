package kg.my.game.template;

import java.util.Random;

public class Deku extends Hero {
    private static final Random random = new Random();

    public Deku(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.RANDOM_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int currentRound) {
        if (random.nextBoolean()) {
            double multiplier = getRandomMultiplier();
            int bonusDamage = (int) (getDamage() * multiplier);
            int healthLoss = (int) (bonusDamage * 0.2);

            if (getHealth() - healthLoss <= 0) {
                healthLoss = getHealth();
            }

            int newDamage = getDamage() + bonusDamage;
            setHealth(getHealth() - healthLoss);
            System.out.println(getName() + " усилил атаку на " + bonusDamage + " потерял " + healthLoss + " здоровья");

            boss.setHealth(boss.getHealth() - newDamage);
        }
    }

    private double getRandomMultiplier() {
        int chance = random.nextInt(3);
        if (chance == 0) return 0.2;
        if (chance == 1) return 0.5;
        return 1.0;
    }
}
