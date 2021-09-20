import java.util.Scanner;

import console.Colors;
import console.Dialogs;

import scripts.Deck;
import scripts.Game;
import scripts.SmartBot;
import scripts.Commands;


public class Monke {
    public static int Player;
    public static String Name;
    public static int Bots;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean gameStateRun = false;

        Game_Introduction();
        System.out.println(Dialogs.AskToPlay);
        System.out.print("Answer : ");
        String answer = s.next().toUpperCase();

        if(answer.matches("YES") || answer.matches("Y")) {
            Player = 1;
            System.out.println(Dialogs.AskBotCount);
            System.out.print("Answer : ");
            Bots = s.nextInt();
            System.out.print(Dialogs.AskPlayerName);
            Name = s.next();
            Dialogs.AnnouncePlayers(Player + Bots);

            try {
                Thread.sleep(370);
                Dialogs.Preparing();
                Deck.PlayerDecks(Player + Bots);
                Commands.Help();
    
                System.out.println(Dialogs.AskIfReady);
                System.out.print("Answer : ");
                boolean isAnswering = true;
                boolean isPlaying = false;

                do {
                    String askPlayer = s.next().toUpperCase();
                    if(askPlayer.matches("YES") || askPlayer.matches("Y")) {
                        isPlaying = true;
                        isAnswering = false;
                    }
                    else if(askPlayer.matches("NO") || askPlayer.matches("N")) {
                        isAnswering = false;
                    }
                    else {
                        isAnswering = true;
                    }
                }
                while(isAnswering);

                if(isPlaying) {
                    gameStateRun = true;
                    Commands.ShowPlayerDecks();
    
                    try {
                        Thread.sleep(2000);
                        Deck.Show(0, "");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    gameStateRun = false;
                    Dialogs.Terminate();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(answer.matches("NO") || answer.matches("N")) {
            gameStateRun = false;
            s.close();
            return;
        }
        else {
            gameStateRun = false;
            s.close();
            return;
        }
        
        // Main Game Loop
        do {
            boolean gameState = Game.Conditions();

            if(gameState) {
                Dialogs.System("Player 1 won the game!");
                Dialogs.System("Congratulations " + Name + ", You've won the game!");
                Dialogs.Terminate();
                gameStateRun = false;
            }
            else {
                String UserInput = s.nextLine();
                switch(UserInput) {
                    case "/help":
                    case "/h":
                        Commands.Help();
                    break;
    
                    case "/auto":
                        Commands.Auto();
                    break;
    
                    case "/all":
                    case "/show":
                        Deck.Show(0, "");
                    break;
    
                    case "/all --color":
                    case "/show --color":
                        Deck.Show(0, "colorized");
                    break;
    
                    case "/shuffle":
                        Deck.ShuffleDeck(Deck.Players[0]);
                        Dialogs.Game("You shuffled your deck");
                    break;
    
                    case "/sp":
                        Commands.ShowPlayerDecks();
                    break;
    
                    case "/end":
                        Dialogs.Terminate();
                        gameStateRun = false;
                    break;
    
                    case "/bot":
                        SmartBot.Run(0);
                    break;
    
                    default :
                        if(UserInput.startsWith("/pick") || UserInput.startsWith("/pick")) {
                            Commands.Pick(0, UserInput);
                        }
                        else if(UserInput.startsWith("/take") || UserInput.startsWith("/t")) {
                            Commands.Take(0, UserInput);
                        }
                        else if(UserInput.matches("/dev_show \\d{1}") || UserInput.matches("/dev_show \\d{2}")) {
                            int player = Integer.parseInt(UserInput.split(" ")[1]) - 1;
                            Deck.Show(player, "colorized");
                        }
                    break;
                }
            }
        }
        while(gameStateRun);
        s.close();
    }

    private static void Game_Introduction() {
        System.out.println(Colors.YELLOW + Colors.BOLD + "-----------------------------------");
        System.out.println("       JAVA CONSOLE MONKE GAME      ");
        System.out.println("-----------------------------------" + Colors.RESET);
    }
}
