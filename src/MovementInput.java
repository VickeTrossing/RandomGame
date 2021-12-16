public class MovementInput {

    public int movementInput(String input, int vertical, int horizontal, int totalHorizontal, int totalVertical, int statFrameSize, String[][] mapArray, String position){
        switch (input.toLowerCase()) {
            case "w" -> {
                mapArray[vertical][horizontal] = " ";
                --vertical;

                if (vertical == 0 && horizontal == horizontal - statFrameSize - 2) {
                    mapArray[vertical][horizontal] = position;
                }
                else if(vertical == totalVertical - 1 || horizontal == 0 || vertical == 0 || horizontal == horizontal - statFrameSize - 1){
                    System.out.println("That's a wall");
                    ++vertical;
                }
                return vertical;

            }

            case "s" -> {
                mapArray[vertical][horizontal] = " ";
                ++vertical;

                if(vertical == totalVertical - 1 || horizontal == 0 || horizontal == totalHorizontal - 1){
                    System.out.println("That's a wall");
                    --vertical;
                }
                return vertical;

            }

            case "a" -> {
                mapArray[vertical][horizontal] = " ";
                --horizontal;

                if(vertical == totalVertical - 1 || horizontal == 0 || vertical == 0 || horizontal == totalHorizontal - 1){
                    System.out.println("That's a wall");
                    ++horizontal;
                }
                return horizontal;

            }

            case "d" -> {
                mapArray[vertical][horizontal] = " ";
                ++horizontal;

                if(vertical == totalVertical - 1 || vertical == 0 || horizontal == totalHorizontal - 1){
                    System.out.println("That's a wall");
                    --horizontal;
                }
                return horizontal;

            }

            default -> System.out.println("only use 'WASD' to move");
        }
        return 0;
    }
}
