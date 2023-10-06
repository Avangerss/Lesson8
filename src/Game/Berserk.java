package Game;

import Game.Boss;
import Game.Hero;
import Game.SuperAbility;

import java.util.Objects;

public class Berserk extends Hero {
    public Berserk(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, ability, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getName().equals(this.getName()) && this.getHealth() > 0) {
                int bossDamage = boss.getDamage() / 2;
                this.setDamage(this.getDamage() + bossDamage);
                System.out.println(this.getName() + " Реверснул урон " + bossDamage);
            }
        }
    }
}
