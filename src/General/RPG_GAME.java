package General;

import Game.*;

public class RPG_GAME {
    public static void start(){
        Boss boss= new Boss(900, 50);
        Magic magic = new Magic( 250,25, "MAG");
        Golem golem = new Golem(250,20 ,"Golem");
        Warrior warrior= new Warrior(250, 25,"VOIN");
        Berserk berserk = new Game.Berserk(250, 10,SuperAbility.REVERS,"Berserk");
        Medic medic = new Medic(300, 20,SuperAbility.HEAL,"Estes");

        Hero[] heroes = {medic ,magic,berserk,golem, warrior};
        printStatistics( boss,heroes);

        while ( ! isGameFinish(boss, heroes)){
            round( boss, heroes);
        }

    }




    private static boolean isGameFinish(Boss boss, Hero[] heroes) {
        if ( boss.getHealth() <= 0){
            System.out.println("Heroes won !!! ");
            return  true;
        }

        boolean allHeroeDad =true;
        for(int i =0; i<heroes.length;i ++){
            if (heroes[i].getHealth()>0){
                allHeroeDad= false;
                break;
            }
        }
        if (allHeroeDad){
            System.out.println("Boss won!!!");
        }
        return allHeroeDad;
    }


    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("____________");
        System.out.println("Boss health " + boss.getHealth() +"(" + boss .getDamage() + ")");

        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() +" health " + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]" );

        }
    }

    private static void round(Boss boss, Hero[] heroes){
        if ( boss.getHealth()> 0){
            bossHits(boss, heroes);
        }
        heroesHits(boss, heroes);
        printStatistics(boss, heroes);
    }
    private static void bossHits(Boss boss, Hero[] heroes){
        for( int i= 0; i<heroes.length; i++){
            if (heroes[i].getHealth() > 0){
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }
    private static void heroesHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length ; i++) {
            if (boss.getHealth() > 0  &&  heroes[i].getHealth()>0){
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                heroes[i].applySuperAbility(boss, heroes);
            }

        }
    }
}
