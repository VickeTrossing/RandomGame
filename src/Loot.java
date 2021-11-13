import java.util.Random;

public class Loot {

    Random random = new Random();
    Player player = new Player();

    public void loot(){
        int extraAttack = random.nextInt(19)+1;
        player.setPlayerAttack(player.getPlayerAttack()+extraAttack);
        System.out.println("You found loot! You're attack grows by: " + extraAttack + " points!");

    }
}
