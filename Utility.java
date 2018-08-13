
/**
 * Write a description of class Static here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;  //Joptions panes used for input and display
public class Utility
{
    public static int randomNumber(int upperBound, int lowerBound)
    {
        int difference = upperBound - lowerBound;
        int randomNumber = ((int)((difference-1)*Math.random() + lowerBound+ 1));  
        return randomNumber;
    }  

    public static int getDifficulty()
    {
        int multiplyer = 0;
        String[] possibilities = {"Easy", "Medium", "Hard", "Impossible"};
        String difficulty = (String)JOptionPane.showInputDialog(
                null,
                "What difficulty would you like?",
                "Difficulty",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                possibilities[1]);
        if(difficulty == "Easy") multiplyer = 100;
        if(difficulty == "Medium") multiplyer = 1000;
        if(difficulty == "Hard") multiplyer = 10000;
        if(difficulty == "Impossible") multiplyer = 100000;
        return multiplyer;
    }
}
