import java.util.Random;

public class Player {

    int playerHealth = 100;
    int playerAttack;

    public Player(int playerHealth, int playerAttack) {
        this.playerHealth = playerHealth;
        this.playerAttack = playerAttack;
    }

    public Player(){}

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerAttack() {
        return playerAttack;
    }

    public void setPlayerAttack(int playerAttack) {
        this.playerAttack = playerAttack;
    }
}
