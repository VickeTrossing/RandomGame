import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    GameMechanics gameMechanics = new GameMechanics();
    int vertical = 8;
    int horizontal = 17;

    public void menu(){

        System.out.println("Welcome to [game name]!\n");
        System.out.println("Menu: ");
        System.out.println("1. Start game\n2. Set map size\nInstructions\n ");
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
        }
    }
}
