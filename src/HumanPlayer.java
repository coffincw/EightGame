/**
 * Created by caleb on 3/6/17.
 */
public class HumanPlayer extends Player {
    @Override
    void choose(int previous) {
        int num = 0;
        boolean error = true;
        while(error) {
            try {
                num = Integer.valueOf(EightMain.readLine("What do you pick for your number?"));

            } catch (NumberFormatException ex) {
                System.out.println("**Invalid Input**");
            }
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
