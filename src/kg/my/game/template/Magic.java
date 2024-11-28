package kg.my.game.template;

public class Magic extends Hero {
    private final int boost;
    private final int rounds;  // Кол-во активных раундов

    public Magic(String name, int health, int damage, int boost, int rounds) {
        super(name, health, damage, SuperAbility.BOOST);
        this.boost = boost;
        this.rounds = rounds;
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int currentRound) {
        if (currentRound <= rounds) {
            System.out.println("Magic " + this.getName() + " BOOST");
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && hero != this) {
                    hero.setDamage(hero.getDamage() + boost);
                    System.out.println(this.getName() + " увеличил атаку героя " + hero.getName() + " на " + boost + " единиц");
                }
            }
        } else {
            System.out.println(this.getName());
        }
    }


}
