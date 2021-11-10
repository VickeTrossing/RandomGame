import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameMechanics gameMap = new GameMechanics();
        FightLogic fight = new FightLogic();
        Enemy enemy = new Enemy();


        System.out.println(enemy.getEnemyHealth());



        gameMap.updateGame();

    }
}
