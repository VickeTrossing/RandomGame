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
    StatFrame statFrame = new StatFrame();
    MovementInput movementInput = new MovementInput();

    int v;
    int h;
    int statsFrame = 18;
    String position = "*";
    String enemyChar = "#";
    String lootChar = "m";
    boolean stillPlaying = true;

    public void updateGame(int verticalInput, int horizontalInput) {
        v = verticalInput;
        h = horizontalInput + statsFrame;
        game = new String[v][h];
        ref.weaponArray();

        game = mapGenerator.generateMap(game, v, h, statsFrame);

        //Random ints for the loot chest, based on the height and width of the map
        int randVertical = random.nextInt(v);
        int randHorizontal = random.nextInt(h - statsFrame - 2);

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

            if (Objects.equals(game[vertical][horizontal], game[enemy.enemyVertical][enemy.enemyHorizontal])) {
                fight.fightLogic();
                enemy.enemyVertical = v - 2;
                enemy.enemyHorizontal = 1;
                game[vertical][horizontal] = position;
                movePlayer();
            }

            String move = scan.nextLine().toLowerCase();


            //Fix winner, add it to the if statement "if move equals w" 


            if (move.equals("w") || move.equals("s")) {
                game[vertical][horizontal] = " ";
                vertical = movementInput.movementInput(move, vertical, horizontal, h, v, statsFrame, game, position);
            } else if (move.equals("a") || move.equals("d")) {
                game[vertical][horizontal] = " ";
                horizontal = movementInput.movementInput(move, vertical, horizontal, h, v, statsFrame, game, position);
            }

            game[vertical][horizontal] = position;

            if (Objects.equals(game[vertical][horizontal], game[randVertical][randHorizontal])) {
                System.out.println();
                loot.loot(player1);
                playerStats(vertical, horizontal);
            }
            playerStats(vertical, horizontal);
            movePlayer();
            System.out.println("Vertical: " + vertical + "Horizontal: " + horizontal);
        }
    }

    public void playerStats(int vertical, int horizontal) {
        statFrame.playerStats(player1.getWeaponName().length(), horizontal, game, h, statsFrame, vertical, player1);
    }

    public boolean winner(int vertical, int horizontal) {
        if (vertical == 0 && horizontal == h - statsFrame - 3) {
            game[vertical][h - statsFrame - 3] = position;
            movePlayer();
            System.out.println("\nYou win!");
            System.out.println("Press enter to go to main menu");
            scan.nextLine();
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
        System.out.print("\nYour move: ");
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