package kg.my.game.template;

import kg.my.game.logic.RPG_Game;

public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(5) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() * coeff);
        System.out.println("Warrior " + this.getName() + " attacked critically "
                + this.getDamage() * coeff + " damage");
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int thatRound) {

    }
}
