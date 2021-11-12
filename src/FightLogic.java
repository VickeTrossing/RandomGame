import java.util.Random;
import java.util.Scanner;

public class FightLogic {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    Player player = new Player();
     Enemy enemy = new Enemy();

    public void fightLogic() {

        GameMechanics gm = new GameMechanics();
        System.out.println();
        System.out.println("Oh no, the monster caught you! Fight for your life!");
        System.out.println("Press any key to start the fight!");
        scan.nextLine();
        int enemyHealth = enemy.getEnemyHealth();
        int playerHealth = player.getPlayerHealth();

        while(true){

            enemy.setEnemyAttack(random.nextInt(9));
            player.setPlayerAttack(random.nextInt(19));
            int enemyAttack = enemy.getEnemyAttack();
            int playerAttack = player.getPlayerAttack();


            enemyHealth = enemyHealth - playerAttack;
            System.out.println("You attack! The monsters health is " + enemyHealth);


            playerHealth = playerHealth - enemyAttack;
            System.out.println("The monster attacks you! Your health is " + playerHealth);


            if(enemyHealth <= 0){
                System.out.println("You win!");
                break;
            }else if(playerHealth <= 0){
                System.out.println("Oh no, you died! Try again");
                gm.stillPlaying = false;
                break;
            }

        }
    }
}


