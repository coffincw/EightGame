import java.util.Scanner;

/**
 * Created by caleb on 3/6/17.
 */
public class ComputerPlayer extends Player {
    boolean error;
    int num;
    @Override
    void choose(int previous) {
        num = 0;
        error = true;
        while(error) {
            firstMove(previous);

            if (error) {
                if (EightMain.currentTotal + 1 == 8) {
                    num = 1;
                } else if (EightMain.currentTotal + 2 == 8) {
                    num = 2;
                } else if (EightMain.currentTotal + 3 == 8) {
                    num = 3;
                } else {
                    num = (int) (Math.random() * 3) + 1;
                }
                if (num != previous && (EightMain.currentTotal + num) <= 8) {
                    error = false;
                } else {
                    num = (int) (Math.random() * 3) + 1;
                    if (num != previous && (EightMain.currentTotal + num) <= 8) {
                        error = false;
                    }
                }
            }
        }
        System.out.println("The computer picks: " + num);
        EightMain.previous = num;
        EightMain.currentTotal += num;
        System.out.println("Total: " + EightMain.currentTotal);
    }
    public void firstMove(int previous) {
        num = 0;
        if (EightMain.playerPick == 1) {
            if (previous == 1) {
                num = 3;
            } else if (previous == 2) {
                num = 1;
            } else {
                num = 1;
            }
            error = false;
        }
    }
}
