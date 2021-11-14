public class GameMap {

    GameMechanics gameMechanics = new GameMechanics();
    String[][] game;


    /*public void gameMap(int v, int h){

        gameMechanics.game = game;
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

        game[(v/2)-2][h-1] = "║" + " Your position: " + (v-2) + " " + 1;
    }*/

}
