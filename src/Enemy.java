
public class Enemy {

    int enemyVertical = 1;
    int enemyHorizontal = 1;

    int enemyHealth = 100;
    int enemyAttack;

    public Enemy(){}

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

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }
}
