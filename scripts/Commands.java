package scripts;

import console.Colors;
import console.Dialogs;

public class Commands {
    public static void Help() {
        System.out.println(Colors.YELLOW + "");
        System.out.println("Commands List");
        System.out.println(" ● index : is a numerical representation of an item's position in a sequence starting from 1");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("/help or /h                          : shows all available commands");
        System.out.println("/all or /show                        : shows all of available cards in your deck.");
        System.out.println("/color --color or /show --color      : colorized version of command /all or /show");
        System.out.println("/auto                                : automatically removes matching cards [98% of the time ahaha.]");
        System.out.println("/hint                                : gives a hint");
        System.out.println("/shuffle                             : shuffles your deck");
        System.out.println("/sp                                  : shows the number of cards of your opponents.");
        System.out.println("/pick index index                    : index searches inside of your deck and checks if the card matches and");
        System.out.println("                                       removes it from your deck.");
        System.out.println("/take or /t cardIndex                : takes a card from a next player");
        System.out.println("" + Colors.RESET);
    }

    public static void Hint() {
        
    }

    public static void ShowPlayerDecks() {
        Dialogs.Game("-----------------------------");
        for(int x = 0; x < Deck.Players.length; x++) {
            if(x == 0) {
                System.out.println("Player " + (x + 1) + " Available Cards : " + Deck.Players[x].length);
            }
            else {
                Dialogs.Game("Player " + (x + 1) + " Available Cards : " + Deck.Players[x].length);
            }
        }
        Dialogs.Game("-----------------------------");
    }

    public static void Auto() {
        boolean match = AutoDeck.Auto_Match("all", 0);
        if(match) {
            Dialogs.Game("matches found and were removed automatically");
        }
        else {
            Dialogs.Game("no matches found");
        }
    }

    public static void Pick(int Player, String Input) {
        boolean typeCheck = TypeSafety.Pick(Player, Input);

        if(typeCheck) {
            boolean match = AutoDeck.Match(Player, Input);
            if(match) {
                Dialogs.Game("You made a match");
                SmartBot.Run(0);
                try {
                    Thread.sleep(2000);
                    Deck.Show(Player, "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else return;
        }
        else {
            Dialogs.System("<TypeCheck> : Invalid Input!");
            Dialogs.System("<TypeCheck> : must be a '/pick number number' type or in range with the number of your cards!");
        }
    }

    public static void Take(int Player, String Input) {
        boolean TypeCheck = TypeSafety.Take(1, Input);

        if(TypeCheck) {
            AutoDeck.FORMAT_TAKE(Input);
            SmartBot.Run(0);
            try {
                Thread.sleep(2000);
                Deck.Show(Player, "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            Dialogs.System("<TypeCheck> : Invalid Input!");
            Dialogs.System("<TypeCheck> : must be in range with Player 2's number of cards!");
        }
    }

}
