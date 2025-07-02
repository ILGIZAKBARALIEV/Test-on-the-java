package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Ludoman extends Hero {

    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.THROW_DICE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = RPG_Game.random.nextInt(1, 7);
        int dice2 = RPG_Game.random.nextInt(1, 7);
        System.out.println("Ludoman " + this.getName() + " rolled the dice: " + dice1 + ", " + dice2);

        if (dice1 == dice2) {
            int damageDealt = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damageDealt);
            System.out.println("Ludoman " + this.getName() + " deals " + damageDealt + " damage to the Boss!");
        } else {
            int damageTaken = dice1 + dice2;
            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            if (randomHero.getHealth() > 0 && randomHero != this) {
                randomHero.setHealth(randomHero.getHealth() - damageTaken);
                System.out.println("Ludoman " + this.getName() + " accidentally deals " + damageTaken + " damage to " + randomHero.getName());
            }
        }
    }
}