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
    int rounds = 2;
    String position = "*";
    String enemyChar = "#";
    String lootChar = "m";
    String healLoot = "♥";
    boolean stillPlaying = true;
    boolean isChestTrue = true;
    boolean isEnemyTrue = true;
    boolean isHealthLootTrue = true;
    boolean firstGame = true;

    public void updateGame(int verticalInput, int horizontalInput) {
        Menu menu = new Menu();
        v = verticalInput;
        h = horizontalInput + statsFrame;
        game = new String[v][h];
        ref.weaponArray();

        game = mapGenerator.generateMap(game, v, h, statsFrame, firstGame);

        int randVertical = random.nextInt(v);
        int randHorizontal = random.nextInt(h - statsFrame - 2);

        int randVerticalForHealth = random.nextInt(v);
        int randHorizontalForHealth = random.nextInt(h - statsFrame - 2);

        player1.setPlayerHealth(player1.getPlayerHealth());

        int vertical = verticalInput - 2;
        int horizontal = 1;

        playerStats(vertical, horizontal);
        game[vertical][horizontal] = position;

        if(firstGame){
            System.out.print("""

                    You find yourself in a cave, you need to find the way out!
                    Press ENTER to start the game.""");
        }

        firstGame = false;

        while (stillPlaying) {
            if(isChestTrue){
                //Random ints for the loot chest, based on the height and width of the map
                randVertical = randVertical + checkWallsForLoot(randVertical, randHorizontal);
                randHorizontal = randHorizontal + checkWallsForLoot(randVertical, randHorizontal);
                game[randVertical][randHorizontal] = lootChar;
            }

            if(isEnemyTrue){
                game[enemy.enemyVertical][enemy.enemyHorizontal] = " ";
                enemy.enemyMove(vertical, horizontal);
                game[enemy.enemyVertical][enemy.enemyHorizontal] = enemyChar;
            }

            if(isHealthLootTrue){
                randVerticalForHealth = randVerticalForHealth + checkWallsForLoot(randVerticalForHealth, randHorizontalForHealth);
                randHorizontalForHealth = randHorizontalForHealth + checkWallsForLoot(randVerticalForHealth, randHorizontalForHealth);
                game[randVerticalForHealth][randHorizontalForHealth] = healLoot;
            }

            if (Objects.equals(game[vertical][horizontal], game[enemy.enemyVertical][enemy.enemyHorizontal]) && isEnemyTrue) {
                fight.fightLogic(player1);
                game[vertical][horizontal] = position;
                System.out.print("\nPress ENTER to continue");
                scan.nextLine();

                if(player1.getPlayerHealth() <= 0){
                    stillPlaying = false;
                    menu.menu();
                }else{
                    playerStats(vertical, horizontal);
                    movePlayer();
                    isEnemyTrue = false;
                    System.out.println("\nYou slayed the monster!");
                    System.out.print("\nYour move: ");
                }
            }

            String move = scan.nextLine().toLowerCase();

            if (move.equals("w") || move.equals("s")) {
                game[vertical][horizontal] = " ";
                vertical = movementInput.movementInput(move, vertical, horizontal, h, v, statsFrame, game);

                if(winner(vertical, horizontal)) menu.menu();

            } else if (move.equals("a") || move.equals("d")) {
                game[vertical][horizontal] = " ";
                horizontal = movementInput.movementInput(move, vertical, horizontal, h, v, statsFrame, game);
            }

            game[vertical][horizontal] = position;

            if(Objects.equals(game[randVerticalForHealth][randHorizontalForHealth], game[vertical][horizontal]) && isHealthLootTrue){
                System.out.println();
                playerStats(vertical, horizontal);
                movePlayer();
                statFrame.messageFromGame(loot.healLoot(player1));
                System.out.print("\nYou move: ");
                isHealthLootTrue = false;
            }

            if (Objects.equals(game[vertical][horizontal], game[randVertical][randHorizontal]) && isChestTrue) {
                System.out.println();
                playerStats(vertical, horizontal);
                movePlayer();
                String message = "Game says: " + loot.loot(player1);
                statFrame.messageFromGame(message);
                System.out.print("\nYour move: ");
                isChestTrue = false;
            }else{
                playerStats(vertical, horizontal);
                movePlayer();
                System.out.print("\nYour move: ");
            }
        }
    }

    public void playerStats(int vertical, int horizontal) {
        statFrame.playerStats(player1.getWeaponName().length(), horizontal, game, h, statsFrame, vertical, player1);
    }

    public boolean winner(int vertical, int horizontal) {
        if (vertical == 0 && horizontal == h - statsFrame - 3) {
            game[vertical][h - statsFrame - 3] = position;
            movePlayer();

            for(int i = 0; i < rounds; ++i){
                String message = " You survived the room! Press ENTER to go into the next room";
                statFrame.messageFromGame(message);
                isChestTrue = true;
                isEnemyTrue = true;
                updateGame(8, 17);
            }

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