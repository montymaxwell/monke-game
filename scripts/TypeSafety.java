package scripts;

public class TypeSafety extends Deck {
    public static boolean Pick(int Player, String Input) {
        int TypeLength = Input.split(" ").length;

        if(TypeLength == 3) {
            int length = Players[Player].length;
            int index1 = Integer.parseInt(Input.split(" ")[1]) - 1;
            int index2 = Integer.parseInt(Input.split(" ")[2]) - 1;
            
            if(index1 < length && index2 < length) {
                return true;
            }
            else return false;
        }
        else return false;
    }

    public static boolean Take(int Player, String Input) {
        int length = Players[Player].length;
        int index = (Integer.parseInt(Input.split(" ")[1])) - 1;

        if(index < length) {
            return true;
        }
        else return false;
    }
}