
import java.util.Arrays;
import java.util.Scanner;

public class GameMechanics {

    Scanner scan = new Scanner(System.in);
    String[][] game = new String[9][9];
    Enemy enemy = new Enemy();


    public void gameMap(){
        for(int i = 0; i < game.length; i++){
            game[0][i] = "═";
            game[8][i] = "═";
            game[i][0] = "║";
            game[i][8] = "║";
            game[0][0] = "╔";
            game[0][8] = "╗";
            game[8][8] = "╝";
            game[8][1] = "╔";
            game[0][7] = "╝";
            game[0][8] = "║";

        }

        for(int i = 0; i < game.length; i++){
            for (int j = 0; j < game[i].length; j++){
                if(game[i][j] == null){
                    game[i][j] = " ";
                }
            }
        }
    }


    public void updateGame(){
        gameMap();

        String position = "*";
        String enemyChar = "#";

        int vertical = 7;
        int horizontal = 1;

        game[vertical][horizontal] = position;

        for (String[] strings : game) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string);
            }
        }



        boolean stillPlaying = true;

        while (stillPlaying){

            game[enemy.enemyVertical][enemy.enemyHorizontal] = " ";
            enemy.enemyMove(vertical, horizontal);

            System.out.println("Your position: " + vertical + " " + horizontal);
            System.out.println("Enemy position: " + enemy.enemyVertical + " " + enemy.enemyHorizontal);



            game[enemy.enemyVertical][enemy.enemyHorizontal] = enemyChar;

            String move = scan.nextLine().toLowerCase();


            switch (move) {
                case "w" -> {
                    game[vertical][horizontal] = " ";
                    --vertical;
                    if (winner(vertical, horizontal)) {
                        stillPlaying = false;
                        break;
                    }
                    if (vertical == 8 || horizontal == 0 || vertical == 0 || horizontal == 8) {
                        System.out.println("That's a wall");
                        ++vertical;
                    }
                    game[vertical][horizontal] = position;
                    movePlayer();
                    game[vertical][horizontal] = " ";
                }

                case "s" -> {
                    game[vertical][horizontal] = " ";
                    ++vertical;
                    if (vertical == 8 || horizontal == 0 || vertical == 0 || horizontal == 8) {
                        System.out.println("That's a wall");
                        --vertical;
                    }
                    game[vertical][horizontal] = position;
                    movePlayer();
                }

                case "a" -> {
                    game[vertical][horizontal] = " ";
                    --horizontal;
                    if (vertical == 8 || horizontal == 0 || vertical == 0 || horizontal == 8) {
                        System.out.println("That's a wall");
                        ++horizontal;
                    }
                    game[vertical][horizontal] = position;
                    movePlayer();
                }

                case "d" -> {
                    game[vertical][horizontal] = " ";
                    ++horizontal;
                    if (vertical == 8 || horizontal == 0 || vertical == 0 || horizontal == 8) {
                        System.out.println("That's a wall");
                        --horizontal;
                    }
                    game[vertical][horizontal] = position;
                    movePlayer();
                }

                case "x" -> stillPlaying = false;

                default -> {
                    System.out.println("only use 'WASD' to move");
                    movePlayer();
                }
            }
        }
    }

    public boolean winner(int vertical, int horizontal){
        if(vertical == 0 && horizontal == 7){
            System.out.println("You win!");
            return true;
        }
        return false;
    }

    public void movePlayer(){
        for (String[] strings : game) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string);
            }
        }
    }
}
