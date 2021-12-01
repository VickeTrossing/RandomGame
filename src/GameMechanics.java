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
    MapGenerator mapGenerator = new MapGenerator();
    Player player1 = new Player();
    Weapon ref = Weapon.getInstance();

    int v;
    int h;
    int statsFrame = 18;
    String position = "*";
    String enemyChar = "#";
    String lootChar = "m";
    boolean stillPlaying = true;

    public void updateGame(int verticalInput, int horizontalInput) {
        v = verticalInput;
        h = horizontalInput+ statsFrame;
        game = new String[v][h];
        Menu menu = new Menu();
        ref.weaponArray();

        game = mapGenerator.generateMap(game, v, h, statsFrame);

        //Random ints for the loot chest, based on the height and width of the map
        int randVertical = random.nextInt(v);
        int randHorizontal = random.nextInt(h- statsFrame -2);

        randVertical = randVertical + checkWallsForLoot(randVertical, randHorizontal);
        randHorizontal = randHorizontal + checkWallsForLoot(randVertical, randHorizontal);


        int vertical = verticalInput - 2;
        int horizontal = 1;

        playerStats(vertical, horizontal);

        game[vertical][horizontal] = position;

        movePlayer();

        while (stillPlaying) {

            game[randVertical][randHorizontal] = lootChar;

            game[enemy.enemyVertical][enemy.enemyHorizontal] = " ";
            enemy.enemyMove(vertical, horizontal);

            game[enemy.enemyVertical][enemy.enemyHorizontal] = enemyChar;
            System.out.println();
            System.out.print("Your move: ");

            if (Objects.equals(game[vertical][horizontal], game[enemy.enemyVertical][enemy.enemyHorizontal])) {
                fight.fightLogic();
                enemy.enemyVertical = v - 2;
                enemy.enemyHorizontal = 1;
                game[vertical][horizontal] = position;
                movePlayer();
            }

            String move = scan.nextLine().toLowerCase();

            switch (move) {
                case "w" -> {
                    game[vertical][horizontal] = " ";
                    --vertical;
                    if (winner(vertical, horizontal)) {
                        menu.menu();
                    }
                    winner(vertical, horizontal);

                    if(vertical == 0 && horizontal == h- statsFrame -2){
                        game[vertical][horizontal] = position;
                    } else if (vertical == v - 1 || horizontal == 0 || vertical == 0 || horizontal == h - statsFrame -1) {
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
                    if (vertical == v - 1 || horizontal == 0 || vertical == 0 || horizontal == h - 1) {
                        System.out.println("That's a wall");
                        ++horizontal;
                    }
                    game[vertical][horizontal] = position;
                }

                case "d" -> {
                    game[vertical][horizontal] = " ";
                    ++horizontal;
                    if (vertical == v - 1 || vertical == 0 || horizontal == h - statsFrame -2) {
                        System.out.println("That's a wall");
                        --horizontal;
                    }
                    game[vertical][horizontal] = position;
                }

                case "x" -> stillPlaying = false;
                default -> System.out.println("only use 'WASD' to move");
            }

            if (Objects.equals(game[vertical][horizontal], game[randVertical][randHorizontal])) {

                System.out.println();
                loot.loot(player1);
                playerStats(vertical, horizontal);
            }
            movePlayer();

            playerStats(vertical, horizontal);
        }
    }


    public void playerStats(int vertical, int horizontal){
        game[1][h - statsFrame] = " Your position: " + " ║";

        if(vertical >= 10){
            game[3][h - statsFrame] = " Vertical: " + vertical + "    ║";
        }else{
            game[3][h - statsFrame] = " Vertical: " + vertical + "     ║";
        }

        if(horizontal >= 10){
            game[4][h - statsFrame] = " Horizontal: " + horizontal + "  ║";
        }else{
            game[4][h - statsFrame] = " Horizontal: " + horizontal + "   ║";
        }
        game[5][h - statsFrame] = " Weapon: " + player1.getWeaponName();





        //game[5][h - player1.getWeaponName().length() - 9] = "║"; //the first one must get removed before it changes

    }


    public boolean winner(int vertical, int horizontal) {
        if (vertical == 0 && horizontal == 0) {
            System.out.println("You win!");
            return true;
        }
        return false;
    }

    public void movePlayer() {
        for (String[] strings : game) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string);
            }
        }
    }

    public int checkWallsForLoot(int randVertical, int randHorizontal) {
        if (randVertical == v - 1 || randHorizontal == h - 1) {
            return -1;
        } else if (randHorizontal == 0 || randVertical == 0) {
            return 1;
        }
        return 0;
    }
}