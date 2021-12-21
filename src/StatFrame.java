import java.util.Objects;

public class StatFrame {
    public void playerStats(int nameLength, int horizontalLength, String[][] mapArray, int totalHorizontal, int statFrameSize, int verticalLength, Player player){
        mapArray[1][totalHorizontal - statFrameSize] = " Your position: " + " ║";

        if(verticalLength >= 10){
            mapArray[3][totalHorizontal - statFrameSize] = " Vertical: " + verticalLength + "    ║";
        } else{
            mapArray[3][totalHorizontal - statFrameSize] = " Vertical: " + verticalLength + "     ║";
        }

        if (horizontalLength >= 10) {
            mapArray[4][totalHorizontal - statFrameSize] = " Horizontal: " + horizontalLength + "  ║";
        } else {
            mapArray[4][totalHorizontal - statFrameSize] = " Horizontal: " + horizontalLength + "   ║";
        }
        mapArray[5][totalHorizontal - statFrameSize] = " Weapon: " + player.getWeaponName();

        mapArray[6][totalHorizontal - statFrameSize] = " Health: " + player.getPlayerHealth();
       // mapArray[6][totalHorizontal-6] = "║";

        int x;
        if(nameLength == 5){
            for (int i = 19; i < totalHorizontal - 1; i++) {
               if(Objects.equals(mapArray[5][i], "║") || Objects.equals(mapArray[5][i], "")){
                   mapArray[5][i] = " ";
               }
            }
            mapArray[5][21] = "║";


        } else if(nameLength > 5){

            for(int i = 20; i < totalHorizontal - 1; i++){
                if(Objects.equals(mapArray[5][i], "║") || Objects.equals(mapArray[6][i], "║")){
                    mapArray[5][i] = "";
                }
            }


            x = nameLength - 5;
            mapArray[5][21 - x] = "║";
            mapArray[6][21 - x] = "║";
        }


        for(int i = 19; i < totalHorizontal - 1; i++){
            if(Objects.equals(mapArray[6][i], "║") || Objects.equals(mapArray[6][i], "")){
                mapArray[6][i] = " ";
            }
        }

        if(player.getPlayerHealth() == 100){
            mapArray[6][23] = "║";
        }else if(player.getPlayerHealth() < 10){
            mapArray[6][24] = " ";
            mapArray[6][25] = "║";
        }else{
            mapArray[6][23] = " ";
            mapArray[6][24] = "║";
        }


    }
}
