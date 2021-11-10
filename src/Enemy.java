import java.util.Arrays;
import java.util.Random;

public class Enemy {

    int enemyVertical = 1;
    int enemyHorizontal = 7;

    int enemyHealth = 100;
    int enemyAttack;

    public Enemy(){}

    public Enemy(int enemyHealth, int enemyAttack) {
        this.enemyHealth = 100;
        this.enemyAttack = enemyAttack;
    }


    public void enemyMove(int vertical, int horizontal) {

        if (enemyHorizontal > horizontal) {
            --enemyHorizontal;
        } else if (enemyVertical > vertical) {
            --enemyVertical;
        } else if (enemyHorizontal < horizontal) {
            ++enemyHorizontal;
        } else if (enemyVertical < vertical) {
            ++enemyVertical;
        }
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }
}
