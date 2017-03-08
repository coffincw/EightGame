/**
 * Created by caleb on 3/6/17.
 */
import java.io.*;
public class EightMain {
    private static int N_Games = 0;
    static int currentTotal = 0;
    static int previous = 0;
    static int playerPick = 0;
    private static boolean winner;

    public static void main (String args[]) {
        winner = false;
        playerFirst();
        if (winner) {
            System.out.println("Congrats you win! Rounds: " + N_Games);
        } else{
            System.out.println("Better luck next time! Rounds: " + N_Games);
        }

    }
    static String readLine(String prompt) {
        String line = null;
        Console c = System.console();
        if (c != null) {
            line = c.readLine(prompt);
        } else {
            System.out.print(prompt);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                //Ignore
            }
        }
        return line;
    }

    public static void playerFirst () {
        HumanPlayer p = new HumanPlayer();
        ComputerPlayer cp = new ComputerPlayer();
        while (currentTotal < 8) {
            N_Games++;
            p.choose(previous);
            playerPick++;
            if (currentTotal == 8) {
                winner = true;
            } else if (currentTotal > 8) {
                System.out.println("You went over 8!");
                winner = false;
            }
            if (currentTotal < 8) {
                cp.choose(previous);
                if (currentTotal > 8) {
                    System.out.println("The computer was forced to go over 8!");
                    winner = true;
                } else if (currentTotal == 8){
                    System.out.println("The computer reached 8!");
                    winner = false;
                }
            }
        }
    }
}
