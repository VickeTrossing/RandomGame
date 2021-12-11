import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    GameMechanics gameMechanics = new GameMechanics();
    MapGenerator mapGenerator = new MapGenerator();
    int vertical = 8;
    int horizontal = 17;
    Player player = new Player();

    public void menu(){

        System.out.println("Welcome to [game name]!\n");
        System.out.println("Menu: ");
        System.out.println("1. Start game\n2. Set map size\n3. Random maps\n4. Instructions ");
        System.out.print("Choose: ");

        int choice = scan.nextInt();

        switch (choice){

            case 1 -> {
                gameMechanics.updateGame(vertical, horizontal);
            }
            case 2 -> {

                System.out.println("Set the size of the map.");
                System.out.print("Vertical: ");
                vertical = scan.nextInt();
                System.out.print("Horizontal: ");
                horizontal = scan.nextInt();

                scan.nextLine();
                System.out.println("Press enter to start the game.");

                scan.nextLine();
                gameMechanics.updateGame(vertical, horizontal);
            }

            case 3 -> {
                gameMechanics.updateGame(mapGenerator.generateMapVertical(), mapGenerator.generateMapHorizontal());
            }

            case 4 -> {
                System.out.println("Instructions: \n\nUse the keys WASD to move. W = up, A = left, S = down, D = right.\nPress the key you want and then press enter.");
                System.out.println("* = Your position\n# = Enemy position\nm = Chest full of loot\n\nPress enter to return to main menu");
                scan.nextLine();
                scan.nextLine();
                menu();
            }

            default -> {
                System.out.println("Only use the numbers on the menu"); menu();
            }
        }
    }
}
