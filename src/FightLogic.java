import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class FightLogic {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);
     Enemy enemy = new Enemy();

    public void fightLogic(Player player) {
        System.out.println();
        System.out.println("Oh no, the monster caught you! Fight for your life!");
        System.out.println("Press ENTER to start the fight!");
        scan.nextLine();
        int enemyHealth = enemy.getEnemyHealth();
        int playerHealth = player.getPlayerHealth();

        while(true){
            enemy.setEnemyAttack(random.nextInt(9));
            int enemyAttack = enemy.getEnemyAttack();
            int playerAttack = player.getPlayerAttack();

            System.out.println("Press A to strike, press S to get the chance to do a special attack!");
            String attack = scan.nextLine();

            if(Objects.equals(attack.toLowerCase(), "s")){
                int specialAttack = random.nextInt(10);

                if(specialAttack >= 5){

                    if(enemyHealth > 50){
                        playerAttack = enemyHealth/2;
                    }else{
                        playerAttack = 20;
                    }

                    enemyHealth = enemyHealth - playerAttack;
                    System.out.println("You do a special attack! The monsters health is " + enemyHealth);
                }else{
                    System.out.println("Your attack missed!");
                }
            }else{
                enemyHealth = enemyHealth - playerAttack;
                System.out.println("You attack! The monsters health is " + enemyHealth);
            }

            if(enemyHealth <= 0){
                break;
            }

            playerHealth = playerHealth - enemyAttack;
            player.setPlayerHealth(playerHealth);
            System.out.println("The monster attacks you! Your health is " + playerHealth);

            if(playerHealth <= 0){
                System.out.println("Oh no, you died! Try again");
                break;
            }
        }
    }
}


