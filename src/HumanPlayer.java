/**
 * Created by caleb on 3/6/17.
 */
import java.util.Scanner;
public class HumanPlayer extends Player {
    @Override
    void choose(int previous) {
        int num = 0;
        boolean error = true;
        while(error) {
            System.out.println("What do you pick for your number?");
            Scanner in = new Scanner(System.in);
            num = in.nextInt();
            if (num != previous && num < 4 && num > 0) {
                error = false;
            }
            if (error) {
                System.out.println("Please pick a different number");
            }

        }
        EightMain.previous = num;
        EightMain.currentTotal += num;
    }
}
