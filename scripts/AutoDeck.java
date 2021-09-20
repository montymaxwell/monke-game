package scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import console.Dialogs;

public class AutoDeck extends Deck {
    public static boolean Auto_Match(String Type, int Player) {
        boolean foundMatches = false;
        List<String> PlayerDeck = new ArrayList<String>(Arrays.asList(Players[Player]));

        for(int x = 0; x < Players[Player].length; x++) {
            for(int xx = x + 1; xx < Players[Player].length; xx++) {
                String str1 = Players[Player][x].split(" ")[0];
                String str2 = Players[Player][xx].split(" ")[0];

                if(str1.matches(str2)) {
                    PlayerDeck.remove(Players[Player][xx]);
                    Players[Player] = PlayerDeck.toArray(new String[PlayerDeck.size()]);

                    foundMatches = true;

                    if(Type.matches("first")) {
                        return foundMatches;
                    }
                    else {

                    }
                }
            }
        }

        return foundMatches;
    }

    public static boolean Match(int Player, String Input) {
        List<String> List = new ArrayList<String>(Arrays.asList(Players[Player]));
        int index1 = Integer.parseInt(Input.split(" ")[1]) - 1;
        int index2 = Integer.parseInt(Input.split(" ")[2]) - 1;
        String str1 = List.get(index1).split(" ")[0];
        String str2 = List.get(index2).split(" ")[0];

        if(index1 != index2) {
            if(str1.matches(str2)) {
                List.remove(Players[Player][index1]);
                List.remove(Players[Player][index2]);
                Players[Player] = List.toArray(new String[List.size()]);
    
                return true;
            }
            else {
                Dialogs.Game("not a match");
                return false;
            }
        }
        else {
            Dialogs.System("must be two different indexes");
            return false;
        }
    }

    public static void FORMAT_TAKE(String Input) {
        int index = (Integer.parseInt(Input.split(" ")[1])) - 1;
        Dialogs.action_UsertakeCard(Players[1][index], 1);
        TakeCard(0, 1, index);
    }

    public static void TakeCard(int Player1, int Player2, int Index) {
        List<String> Player1Cards = new ArrayList<String>(Arrays.asList(Players[Player1]));
        List<String> Player2Cards = new ArrayList<String>(Arrays.asList(Players[Player2]));

        Player1Cards.add(Players[Player2][Index]);
        Player2Cards.remove(Index);

        Players[Player2] = Player2Cards.toArray(new String[Player2Cards.size()]);
        Players[Player1] = Player1Cards.toArray(new String[Player1Cards.size()]);
    }
}