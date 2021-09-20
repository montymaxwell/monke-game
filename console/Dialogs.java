package console;

import java.io.IOException;

public class Dialogs {
    public static String AskToPlay = Colors.CYAN + "Do you want to play? " + Colors.GREEN + "YES/Y" + Colors.RESET + " : " + Colors.RED + "NO/N" + Colors.RESET;
    public static String AskBotCount = Colors.CYAN + "How many bots would you like to play againts?" + Colors.BRIGHT_YELLOW + " Number " + Colors.RESET;
    public static String AskIfReady = Colors.CYAN + "Are you ready to play? " + Colors.GREEN + "YES/Y" + Colors.RESET + " : " + Colors.RED + "NO/N" + Colors.RESET;
    public static String AskPlayerName = Colors.CYAN + "What is your name? " + Colors.RESET;

    public static void AnnouncePlayers(int Players) {
        System.out.println(Colors.YELLOW + "------------------");
        System.out.println("      Players     ");
        System.out.println("------------------" + Colors.RESET);
        for(int x = 1; x <= Players; x++) {
            if(x == 1) {
                System.out.println("Player : " + x + " ( YOU )");
            }
            else {
                System.out.println(Colors.YELLOW + "Player : " + x + " ( BOT )" + Colors.RESET);
            }
        }
    }

    public static void Terminate() {
        System.out.println(Colors.CYAN + "<System> : Terminating Program" + Colors.RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Preparing() {
        String[] FakeLoadingText = {"Preparing Deck", "Shuffling Deck", "Finalization"};

        for(String Fake : FakeLoadingText) {
            System.out.print(Colors.CYAN + "\n");
            for(int x = 0; x <= 100; x++) {
                String data = "\r" + "<System> : " + x + "% " + Fake;

                try {
                    System.out.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(18);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.print("\n");
        System.out.println("<System> : Game is Ready!");
        System.out.println(Colors.RESET);
    }

    public static void System(String Text) {
        System.out.println(Colors.CYAN + Text + Colors.RESET);
    }

    public static void Game(String Text) {
        System.out.println(Colors.BRIGHT_YELLOW + Text + Colors.RESET);
    }
    
    public static void action_UsertakeCard(String Card, int Player) {
        System.out.println(Colors.BRIGHT_YELLOW + Colors.BOLD + "You have taken " + Card + " from Player " + (Player + 1) + Colors.RESET);
    }
    public static void action_TakeCard(int Player1, int Player2) {
        System.out.println(Colors.YELLOW + Colors.BOLD + "Player " + (Player1 + 1) + " has taken from Player " + (Player2 + 1) + Colors.RESET);
    }

}
