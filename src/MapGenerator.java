import java.util.Random;

public class MapGenerator {
    Random random = new Random();

    public String[][] generateMap(String[][] mapArray, int v, int h, int hStats) {
        for (int i = 0; i < mapArray.length; i++) {
            mapArray[i][0] = "║";
            mapArray[i][(h-hStats)-2] = "║";
        }

        for (int i = 0; i < (h-hStats)-1; i++) {
            mapArray[0][i] = "═";
            mapArray[v - 1][i] = "═";
            mapArray[0][0] = "╔";
            mapArray[v - 1][0] = "╚";
        }

        for(int i = 0; i < mapArray.length; i++){
            mapArray[i][h-hStats-1] = "║";
            if(i == 1 || i == 3 || i == 4 || i == 5 || i == 6){
                continue;
            }
            mapArray[i][h-1] = "║";
        }

        for (int i =  h-hStats-1; i < h; i++) {
            mapArray[0][i] = "═";
            mapArray[v-1][i] = "═";
            mapArray[v-1][h-hStats-1] = "╚";
            mapArray[0][h-hStats-1] = "╔";
            mapArray[v-1][h-1] = "╝";
            mapArray[0][h-1] = "╗";
            mapArray[0][h-hStats-2] = "║";
            mapArray[0][h-hStats-3] = "╝";
            mapArray[v - 1][h-hStats-2] = "╝";
            mapArray[2][h-hStats-1] = "╠";
            mapArray[2][i] = "═";
            mapArray[2][h-1] = "╣";
        }

        for(int i = 0; i < mapArray.length; i++){
            for (int j = 0; j < mapArray[i].length; j++){
                if(mapArray[i][j] == null){
                    mapArray[i][j] = " ";
                }
            }
        }
        return mapArray;
    }

    public int generateMapVertical(){
        return random.nextInt(21)+9;
    }

    public int generateMapHorizontal(){
        return random.nextInt(31)+9;
    }
}
