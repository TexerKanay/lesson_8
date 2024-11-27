package kg.my.game.template;

public class Medic extends Hero {
    private int healPoints;

    public Medic(String name, int health, int damage, int healPoints) {
        super(name, health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero != this && hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() + healPoints);
            }
        }
    }
}
