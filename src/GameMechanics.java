
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GameMechanics {

    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    String[][] game;
    Enemy enemy = new Enemy();
    Loot loot = new Loot();
    FightLogic fight = new FightLogic();
    boolean stillPlaying = true;

    int v;
    int h;
    String position = "*";
    String enemyChar = "#";
    String lootChar = "m";


    public void updateGame( int vert, int hori){
        v = vert;
        h = hori;
        game = new String[v][h];

        gameMap();

        loot.loot();

        int randVertical = random.nextInt(v);
        int randHorizontal = random.nextInt(h);

        game[randVertical][randHorizontal] = lootChar;



        int vertical = vert-2;
        int horizontal = 1;

        game[vertical][horizontal] = position;

        for (String[] strings : game) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string);
            }
        }

        while (stillPlaying){

            System.out.println("enemy check: " + enemy.enemyVertical +  " " + enemy.enemyHorizontal);

            game[enemy.enemyVertical][enemy.enemyHorizontal] = " ";
            enemy.enemyMove(vertical, horizontal);

            //System.out.println("Your position: " + vertical + " " + horizontal);

            System.out.println("Enemy position: " + enemy.enemyVertical + " " + enemy.enemyHorizontal);
            System.out.println("Player position: " + vertical + " " + horizontal);

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
                    if (vertical == v-1 || horizontal == 0 || vertical == 0 || horizontal == h-1) {
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
                    if (vertical == v - 1 || horizontal == 0 || horizontal == h - 1) {
                        System.out.println("That's a wall");
                        --vertical;
                    }
                    game[vertical][horizontal] = position;
                    movePlayer();
                }

                case "a" -> {
                    game[vertical][horizontal] = " ";
                    --horizontal;
                    if (vertical == v-1 || horizontal == 0 || vertical == 0 || horizontal == h-1) {
                        System.out.println("That's a wall");
                        ++horizontal;
                    }
                    game[vertical][horizontal] = position;
                    movePlayer();
                }

                case "d" -> {
                    game[vertical][horizontal] = " ";
                    ++horizontal;
                    if (vertical == v - 1 || vertical == 0 || horizontal == h - 1) {
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

            if(Objects.equals(game[vertical][horizontal], game[randVertical][randHorizontal])){
                loot.loot();
            }

            if(Objects.equals(game[vertical][horizontal], game[enemy.enemyVertical][enemy.enemyHorizontal])){
                fight.fightLogic();
                enemy.enemyVertical = v-2;
                enemy.enemyHorizontal = 1;
                game[vertical][horizontal] = position;
                movePlayer();
            }
        }
    }


    public boolean winner(int vertical, int horizontal){
        if(vertical == 0 && horizontal == h-2){
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


    public void gameMap(){

        System.out.println("Vertical: " + v);
        System.out.println("Horizontal: " + h);

        for(int i = 0; i < game.length; i++){
            game[i][0] = "║";
            game[i][h-1] = "║";
            game[0][h-1] = "║";
            game[v-1][h-1] = "╝";
            game[0][h-2] = "╝";
        }


        for(int i = 0; i < h; i++){
            game[0][i] = "═";
            game[v-1][i] = "═";
            game[0][0] = "╔";
            game[0][h-2] = "╝";
            game[v-1][h-1] = "╝";
            game[v-1][1] = "╔";
            game[v-1][0] = "║";
            game[0][h-1] = "║";
        }



        System.out.println("Vertical: " + v);
        System.out.println("Horizontal: " + h);

        for(int i = 0; i < game.length; i++){
            for (int j = 0; j < game[i].length; j++){
                if(game[i][j] == null){
                    game[i][j] = " ";
                }
            }
        }
    }
}
