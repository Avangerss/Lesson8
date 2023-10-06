package Game;

public class Magic extends Hero {

    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int Mag = 1;
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0){
                heroes [i].setDamage(heroes[i].getDamage() + Mag);
                System.out.println(this.getName() + " Испльзововал супер способность " + Mag + " на " + heroes[i].getName());

            }
        }
    }

}
