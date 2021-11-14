
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
    Player player = new Player();
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

        System.out.println("Random: " + (randVertical-1) + " " + randHorizontal);


        if(randVertical == v-1){
            randVertical = randVertical-1;
        }else if(randHorizontal == 0){
            randHorizontal = randVertical +1;
        }else if(randVertical == 0 ){
            randVertical = randVertical + 1;
        }else if(randHorizontal == h-1){
            randVertical = randVertical - 1;
        }

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

        outerloop:
        while (stillPlaying){

            game[enemy.enemyVertical][enemy.enemyHorizontal] = " ";
            enemy.enemyMove(vertical, horizontal);

            game[enemy.enemyVertical][enemy.enemyHorizontal] = enemyChar;

            String move = scan.nextLine().toLowerCase();


            switch (move) {
                case "w" -> {
                    game[vertical][horizontal] = " ";
                    --vertical;
                    if (winner(vertical, horizontal)) {
                        stillPlaying = false;
                        break outerloop;
                    }
                    if (vertical == v-1 || horizontal == 0 || vertical == 0 || horizontal == h-1) {
                        System.out.println("That's a wall");
                        ++vertical;
                    }
                    game[vertical][horizontal] = position;
                }

                case "s" -> {
                    game[vertical][horizontal] = " ";
                    ++vertical;
                    if (vertical == v - 1 || horizontal == 0 || horizontal == h - 1) {
                        System.out.println("That's a wall");
                        --vertical;
                    }
                    game[vertical][horizontal] = position;
                }

                case "a" -> {
                    game[vertical][horizontal] = " ";
                    --horizontal;
                    if (vertical == v-1 || horizontal == 0 || vertical == 0 || horizontal == h-1) {
                        System.out.println("That's a wall");
                        ++horizontal;
                    }
                    game[vertical][horizontal] = position;
                }

                case "d" -> {
                    game[vertical][horizontal] = " ";
                    ++horizontal;
                    if (vertical == v - 1 || vertical == 0 || horizontal == h - 1) {
                        System.out.println("That's a wall");
                        --horizontal;
                    }
                    game[vertical][horizontal] = position;
                }

                case "x" -> stillPlaying = false;

                default -> System.out.println("only use 'WASD' to move");
            }

            if(Objects.equals(game[vertical][horizontal], game[randVertical][randHorizontal])){
                loot.loot();
            }

            if(Objects.equals(game[vertical][horizontal], game[enemy.enemyVertical][enemy.enemyHorizontal])){
                fight.fightLogic();
                enemy.enemyVertical = v-2;
                enemy.enemyHorizontal = 1;
                game[vertical][horizontal] = position;
            }

            game[(v/2)-2][h-1] = "║" + " Your position: ";
            game[(v/2)-1][h-1] = "║" + " Vertical: "+ (vertical);
            game[(v/2)][h-1] = "║" + " Horizontal: " + horizontal;
            movePlayer();
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

        for(int i = 0; i < game.length; i++){
            for (int j = 0; j < game[i].length; j++){
                if(game[i][j] == null){
                    game[i][j] = " ";
                }
            }
        }

        game[(v/2)-2][h-1] = "║" + " Your position: ";
        game[(v/2)-1][h-1] = "║" + " Vertical: "+ (v-2);
        game[(v/2)][h-1] = "║" + " Horizontal: " + 1;
    }
}
