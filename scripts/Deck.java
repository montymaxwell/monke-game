package scripts;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

import console.Colors;

import java.util.ArrayList;

/** 
 * Creates a randomly sorted deck of cards and
 * distributes it to the number of players accordingly
 * with one player having 1 more card than the rest of players
 */
public class Deck {
    private static String[] SUITS = {
        "♠️ Spades ♠️", "♣️ Clubs ♣️", "♥ Hearts ♥", "♦️ Diamonds ♦️"
    };
    private static String[] VALUES = {
        "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
    };
    public static String[] Cards = new String[VALUES.length * SUITS.length];

    public static String monke;
    public static String[][] Players;

    public static void Show(int Player, String Type) {
        System.out.println(Colors.CYAN + "Number of Cards : " + Players[Player].length);
        System.out.println("--------------------" + Colors.RESET);
        for(int x = 0; x < Players[Player].length; x++) {
            int display = x + 1;

            if(Type.matches("colorized")) { 
                if(Players[Player][x].contains("♠️ Spades ♠️")) {
                    System.out.println(Colors.BRIGHT_PURPLE + display + " : " + Players[Player][x] + Colors.RESET);
                }
                else if(Players[Player][x].contains("♣️ Clubs ♣️")) {
                    System.out.println(Colors.GREEN + display + " : " + Players[Player][x] + Colors.RESET);
                }
                else if(Players[Player][x].contains("♥ Hearts ♥")) {
                    System.out.println(Colors.BRIGHT_RED + display + " : " + Players[Player][x] + Colors.RESET);
                }
                else if(Players[Player][x].contains("♦️ Diamonds ♦️")) {
                    System.out.println(Colors.BLUE + display + " : " + Players[Player][x] + Colors.RESET);
                }
            }
            else {
                System.out.println(display  + " : " + Players[Player][x]);
            }
        }
    }

    public static void PlayerDecks(int PlayerCount) {
        Random r = new Random();

        int n = 0;
        for(String Suit : SUITS) {
            for(String Value : VALUES) {
                Cards[n] = Value + " of " + Suit;
                n += 1;
            }
        }

        ShuffleDeck(Cards);

        int getMonke = r.nextInt(Cards.length);
        monke = Cards[getMonke];
        List<String> $monkefy = new ArrayList<String>(Arrays.asList(Cards));
        $monkefy.remove(Cards[getMonke]);
        Cards = $monkefy.toArray(new String[Cards.length - 1]);

        Distro(PlayerCount);
    }

    public static void ShuffleDeck(String[] Deck) {
        for(int x = Deck.length - 1; x > 0; x--) {
            int $new = (int) Math.floor(Math.random() * (x + 1));
            String $old = Deck[$new];

            Deck[$new] = Deck[x];
            Deck[x] = $old;
        }
    }

    private static void Distro(int PlayerCount) {
        Random r = new Random();
        Players = new String[PlayerCount][Cards.length / PlayerCount];

        int n = 0;
        for(int x = 0; x < Players.length; x++) {
            for(int xx = 0; xx < Players[x].length; xx++) {
                if(n < (Cards.length / PlayerCount)) {
                    Players[x][xx] = Cards[n];
                }
                else {
                    Players[x][xx] = Cards[n];
                }
                n += 1;
            }
        }

        int pick = r.nextInt(PlayerCount - 1);
        List<String> $appendLast = new ArrayList<String>(Arrays.asList(Players[pick]));
        $appendLast.add(Cards[Cards.length - 1]);
        Players[pick] = $appendLast.toArray(new String[Players [pick].length + 1]);
    }

}
