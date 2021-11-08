import java.util.Arrays;

public class Enemy {

    int enemyVertical = 1;
    int enemyHorizontal = 7;


    public Enemy(int enemyVertical, int enemyHorizontal) {
        this.enemyVertical = enemyVertical;
        this.enemyHorizontal = enemyHorizontal;
    }

    public Enemy(){}

    public String[][] enemyMove(int vertical, int horizontal){

        GameMechanics gm = new GameMechanics();


        String[][] enemyPosition = new String[9][9];

        System.out.println(vertical + " " + horizontal);


        if(enemyHorizontal > horizontal){
            --enemyHorizontal;
            //--enemyVertical;
        }else if(enemyVertical > vertical){
            --enemyVertical;
        }else if(enemyHorizontal < horizontal){
            ++enemyHorizontal;
        }else if(enemyVertical < vertical){
            ++enemyVertical;
        }

        System.out.println("enemy: " + enemyVertical + " " + enemyHorizontal);

        setEnemyHorizontal(enemyHorizontal);
        setEnemyVertical(enemyVertical);

        return enemyPosition;

    }




    public void setEnemyVertical(int enemyVertical) {
        this.enemyVertical = enemyVertical;
    }

    public void setEnemyHorizontal(int enemyHorizontal) {
        this.enemyHorizontal = enemyHorizontal;
    }

    public int getEnemyVertical() {
        return enemyVertical;
    }

    public int getEnemyHorizontal() {
        return enemyHorizontal;
    }
}
