import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    GameMechanics gameMechanics = new GameMechanics();

    public void menu(){

        System.out.println("Welcome to [game name]!\n");
        System.out.println("Menu: ");

        int choice = scan.nextInt();

        switch (choice){

            case 1 -> {
                System.out.println("1. Start game");
                //gameMechanics.updateGame();
            }
        }

    }
}
