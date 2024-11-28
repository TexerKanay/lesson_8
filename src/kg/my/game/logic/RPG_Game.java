package kg.my.game.logic;
import kg.my.game.template.Antman;
import kg.my.game.template.Deku;
import kg.my.game.template.*;
import java.util.Random;


public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber = 0;

    public static void startGame() {
        Boss boss = new Boss("Skelet", 1000, 50);

        Warrior warrior1 = new Warrior("Ahiles", 290, 10);
        Warrior warrior2 = new Warrior("Hercules", 280, 15);
        Magic magic = new MyMagic();
        Berserk berserk = new Berserk("Appolon", 240, 10);
        Medic doc = new Medic("Haus", 250, 5, 15);
        Medic assistant = new Medic("Connor", 300, 5, 5);
        Deku deku = new Deku("Moskov", 240, 20);
        Antman antman = new Antman("Pekka", 100, 10);
        Reaper reaper = new Reaper("Dracula", 300, 10);


        int thatRound = 1;
        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, deku, antman, reaper};
        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes, thatRound);
            thatRound++;
        }
    }

    private static void playRound(Boss boss, Hero[] heroes, int thatRound) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
            }
            hero.applySuperPower(boss, heroes, thatRound); // Передаём текущий раунд
        }
        printStatistics(boss, heroes);
    }


    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static class MyMagic extends Magic {
        public MyMagic() {
            super("Golliaf", 280, 10, 5, 4);
        }
    }
}
