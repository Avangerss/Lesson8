package Game;

public class Medic extends Hero {

    public Medic(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, ability, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int heal = 10;
        for (int i = 0; i < heroes.length; i++) {
            if (!heroes[i].getName().equals(this.getName()) && this.getHealth() > 0 && heroes[i].getHealth() < 100) {
                heroes[i].setHealth(heroes[i].getHealth() + heal);
                System.out.println(this.getName() + " Вылечил " + heroes[i].getName() + " на " + heal);
                break;
            }
        }
    }
}
