package scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import console.Dialogs;

public class SmartBot extends AutoDeck {
    public static void Run(int Player) {
        boolean gameState = Game.Conditions();

        if(gameState) {
            return;
        }
        else {
            int nextPlayer = 0;
            for(int bot = 0; bot < Players.length; bot++) {
                if(bot > Player || bot != Player) {
                    if(bot == (Players.length - 1)) {
                        Delay(bot, Player);
                    }
                    else {
                        nextPlayer = bot + 1;
                        Delay(bot, nextPlayer);
                    }
                }
            }
        }
    }

    public static void Delay(int bot, int Player) {
        try {
            Thread.sleep(1000);
            Take(bot, Player);

            try {
                Thread.sleep(1400);
                Analyze(bot);
    
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Take(int bot, int nextBot) {
        int random = (int) Math.floor(Math.random() * (Players[nextBot].length - 1));
        TakeCard(bot, nextBot, random);
        Dialogs.System("Player " + (bot + 1) + " has taken from Player " + (nextBot + 1));
    }

    public static void Analyze(int bot) {
        for(int f = 0; f < Players[bot].length; f++) {
            for(int s = f + 1; s < Players[bot].length; s++) {
                List<String> List = new ArrayList<String>(Arrays.asList(Players[bot]));
                String Turtle = Players[bot][f].split(" ")[0];
                String Hare = Players[bot][s].split(" ")[0];

                if(Hare.matches(Turtle)) {
                    String $Turtle = Integer.toString(List.indexOf(Players[bot][f]) + 1);
                    String $Hare = Integer.toString(List.indexOf(Players[bot][s]) + 1);

                    String Format = "/pick "+ $Turtle + " " + $Hare;
                    boolean match = Match(bot, Format);
                    if(match) {
                        Dialogs.Game("Player " + (bot + 1) + " made a match!");
                    }
                    else {
                        Dialogs.Game("Player " + (bot + 1) + " did not found a match.");
                    }

                    return;
                }
            }
        }
    }
}