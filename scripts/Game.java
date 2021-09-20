package scripts;

import java.util.Arrays;

import console.Dialogs;

public class Game extends Deck {
    // not used ._.
    public static boolean WinLoseConditions() {
        for(int x = 0; x < Players.length; x++) {
            if(Players[x].length < 2 || Players[x].length < 3) {
                Dialogs.System("Final Game Stages!");
            }
            else if(Players[x].length < 1) {
                int PlayerWithLastCard = Arrays.asList(Players).indexOf(Players[x]);
                if(Arrays.asList(Players).indexOf(Players[x]) != PlayerWithLastCard && Players[x].length == 0) {
                    System.out.println(monke);
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }

    public static boolean Conditions() {
        for(int x = 0; x < Players.length; x++) {
            if(Players[0].length == 0) {
                return true;
            }
        }
        
        return false;
    }
}
