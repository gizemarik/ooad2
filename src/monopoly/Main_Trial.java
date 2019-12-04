package monopoly;
import monopoly.model.Monopoly;
import monopoly.gui.MonopolyWindow;
import monopoly.model.UserInputDice;


public class Main_Trial {

    public static void main(String[] args)
    {
        int roll=0;
        UserInputDice input = new UserInputDice();
        roll=input.getRoll();
        System.out.println(roll);
    }
}
