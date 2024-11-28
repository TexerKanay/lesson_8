package kg.my.game.template;

public abstract class Hero extends GameEntity {
    private final SuperAbility ability;

    public Hero(String name, int health, int damage, SuperAbility ability) {
        super(name, health, damage);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void attack(Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }

    public abstract void applySuperPower(Boss boss, Hero[] heroes);

    public abstract void applySuperPower(Boss boss, Hero[] heroes, int thatRound);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + getName() +
                " health: " + getHealth() +
                " damage: " + getDamage();
    }
}
