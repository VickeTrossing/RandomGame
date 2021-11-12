import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        GameMechanics gameMap = new GameMechanics();

        System.out.print("Size of map. Vertical: ");
        int v = scan.nextInt();
        System.out.print("Horizontal: ");
        int h = scan.nextInt();

        gameMap.updateGame(v, h);
    }
}
