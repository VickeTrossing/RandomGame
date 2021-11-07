import java.util.Objects;
import java.util.Scanner;

public class GameMap {

    Scanner scan = new Scanner(System.in);
    String[][] game = new String[9][9];

    public void gameMap(){


       /* game[0][0] = "╔";
        game[0][1] = "═";
        game[0][2] = "═";
        game[0][3] = "═";
        game[0][4] = "═";
        game[0][5] = "═";
        game[0][6] = "═";
        game[0][7] = "═";
        game[0][8] = "╗";

        game[1][0] = "║";
        game[2][0] = "║";
        game[3][0] = "║";
        game[4][0] = "║";
        game[5][0] = "║";
        game[6][0] = "║";
        game[7][0] = "║";

        game[1][8] = "║";
        game[2][8] = "║";
        game[3][8] = "║";
        game[4][8] = "║";
        game[5][8] = "║";
        game[6][8] = "║";
        game[7][8] = "║";

        game[8][0] = "╚";
        game[8][1] = "═";
        game[8][2] = "═";
        game[8][3] = "═";
        game[8][4] = "═";
        game[8][5] = "═";
        game[8][6] = "═";
        game[8][7] = "═";
        game[8][8] = "╝";*/

        for(int i = 0; i < game.length; i++){
            game[0][i] = "═";
            game[8][i] = "═";
            game[i][0] = "║";
            game[i][8] = "║";
            game[0][0] = "╔";
            game[0][8] = "╗";
            //game[8][0] = "╚";
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
        String currentPosition = game[7][1];

        int vertical = 7;
        int horizontal = 1;

        game[vertical][horizontal] = position;

        System.out.println("Current: " + game[vertical][horizontal]);


        for (String[] strings : game) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string);
            }
        }



        boolean stillPlaying = true;

        while (stillPlaying){

            String move = scan.nextLine().toLowerCase();


            for(int i = 0; i < game.length; i++){
                for (int j = 0; j < game[i].length; j++){
                    if(game[i][j] == null){
                        game[i][j] = " ";
                    }
                }
            }




            switch(move){
                case "w":

                    game[vertical][horizontal] = " ";

                   --vertical;



                    game[vertical][horizontal] = position;

                    for (String[] strings : game) {
                        System.out.println();
                        for (String string : strings) {
                            System.out.print(string);
                        }
                    }

                    break;

                case "s":

                    game[vertical][horizontal] = " ";
                    ++vertical;
                    game[vertical][horizontal] = position;

                    for (String[] strings : game) {
                        System.out.println();
                        for (String string : strings) {
                            System.out.print(string);
                        }
                    }

                    break;



            }
        }
    }
}
