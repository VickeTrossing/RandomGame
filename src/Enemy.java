import java.util.Arrays;

public class Enemy {

    int enemyVertical = 1;
    int enemyHorizontal = 7;

    int enemyHealth = 100;


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
}
