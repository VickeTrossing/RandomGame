import java.util.Random;

public class Player {

   private int playerHealth = 100;
    private String weaponName = "Hands";
    int playerAttack;
   private final Random random = new Random();

    public Player(){}

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
         this.playerHealth = playerHealth;
     }

    public int getPlayerAttack() {
        return random.nextInt(19)+1;
    }

    public void setPlayerAttack(int playerAttack) {
        this.playerAttack = playerAttack;
    }
}
