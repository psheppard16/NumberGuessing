
/**
 * Runs methods in order to run the number guessing game
 * 
 * @author Preston Sheppard 
 * @3.0
 */
import javax.swing.JOptionPane;  //Joptions panes used for input and display
import java.io.FileWriter;      //FileWriter used to store information
import java.io.IOException;
public class Runner
{
    public static void main (String[] args)
    {
        try
        {
            int startingLine = -1;
            while (startingLine < 0)
            {
                String fileName = "StatisticStorage.txt";
                StatStorage statistics = new StatStorage(fileName, true);
                startingLine = statistics.startScreen();
                if (startingLine >=0)
                {
                    String[] dataFile = new String[statistics.numberLines()];
                    dataFile = statistics.readFile(0, statistics.numberLines());

                    String password = dataFile[startingLine + 1];
                    boolean[] hints = new boolean[6];
                    hints[0] = Boolean.parseBoolean(dataFile[startingLine + 6]);
                    hints[1] = Boolean.parseBoolean(dataFile[startingLine + 7]);
                    hints[2] = Boolean.parseBoolean(dataFile[startingLine + 8]);
                    hints[3] = Boolean.parseBoolean(dataFile[startingLine + 9]);
                    hints[4] = Boolean.parseBoolean(dataFile[startingLine + 10]);
                    hints[5] = Boolean.parseBoolean(dataFile[startingLine + 11]);

                    Shop items = new Shop(
                            dataFile[startingLine],
                            hints,
                            Integer.parseInt(dataFile[startingLine + 2]),
                            Integer.parseInt(dataFile[startingLine + 3]),
                            Double.parseDouble(dataFile[startingLine + 4]),
                            Integer.parseInt(dataFile[startingLine + 5]));

                    System.out.println('\u000c');
                    System.out.println("you have " + items.money + " dollars");
                    System.out.println("There is a " + (100 - items.lieRate) + "% chance that a hint will not be a lie");
                    System.out.println("There is a " + (100 - items.hintRate) + "% chance that you will recieve a hint");
                    System.out.println("You recieve " + (100*items.extraMoney) + "% more money");
                    if(hints[0] == true)System.out.println("You own even/odd hints" );
                    if(hints[1] == true)System.out.println("You own prime hints" );
                    if(hints[2] == true)System.out.println("You own perfect hints" );
                    if(hints[3] == true)System.out.println("You own factor hints" );
                    int done = 0;
                    while (done != 1)           
                    {
                        /**
                         * 
                         */
                        int multiplyer = 0;  
                        int lowerBound = 0;
                        int upperBound = 0;
                        multiplyer = Utility.getDifficulty();
                        lowerBound = (int)(Utility.randomNumber(multiplyer/5, multiplyer/10));
                        upperBound = ((int)(Utility.randomNumber(multiplyer-lowerBound, lowerBound)));
                        NumberGuess number = new NumberGuess(Utility.randomNumber(upperBound, lowerBound));
                        System.out.println('\u000c');
                        System.out.println("The lower bound of the random number is: " + lowerBound);
                        System.out.println("The upper bound of the random number is: " + upperBound);
                        System.out.println("The random number is: " + number.number);
                        /**
                         * 
                         */
                        int numberGuess =  0;
                        int tries = 0;
                        p: for (int nmbTries = 1; number.number != numberGuess; nmbTries++)
                        {
                            try 
                            {
                                String number1 = JOptionPane.showInputDialog("please make your guess:");
                                if (number1 == null)
                                {
                                    throw new NullPointerException();
                                }
                                numberGuess = Math.abs(Integer.parseInt(number1));
                                if (numberGuess != -1 && (numberGuess < lowerBound || numberGuess > upperBound))
                                {
                                    throw new NumberFormatException();
                                }

                                number.printFacts(numberGuess, items.lieRate, items.hintRate, items.hints);
                            }
                            catch(NullPointerException e)
                            {
                                break p;
                            }
                            catch(NumberFormatException e)
                            {
                                JOptionPane.showMessageDialog(null, numberGuess + " is not a valid input");
                            }
                            tries = nmbTries;
                        }
                        if (number.number == numberGuess)
                        {
                            items.money += (multiplyer - tries);
                        }
                        System.out.println('\u000c');
                        System.out.println("You found the number in: " + tries + " tries");
                        System.out.println("You recieved: " + (multiplyer - tries) + " dollars");
                        System.out.println("you have " + items.money + " dollars");
                        int done1 = 0;
                        while (done1 != 1)
                        {
                            items.buyItems();
                            System.out.println('\u000c');
                            System.out.println("you have " + items.money + " dollars");
                            System.out.println("There is a " + (100 - items.lieRate) + "% chance that a hint will not be a lie");
                            System.out.println("There is a " + (100 - items.hintRate) + "% chance that you will recieve a hint");
                            System.out.println("You recieve " + (100*items.extraMoney) + "% more money");
                            if(items.hints[0] == true)System.out.println("you own even/odd hints" );
                            if(items.hints[1] == true)System.out.println("you own prime hints" );
                            if(items.hints[2] == true)System.out.println("you own perfect hints" );
                            if(items.hints[3] == true)System.out.println("you own factor hints" );
                            if(items.hints[4] == true)System.out.println("you own sum of factor hints" );
                            if(items.hints[5] == true)System.out.println("you own sum of digits hints" );
                            done1 = JOptionPane.showConfirmDialog(null, "Would you like to buy more items?", "", JOptionPane.YES_NO_OPTION); //if user clicks yes it sets done to 0, no to 1
                        }
                        dataFile[startingLine] = items.name;
                        dataFile[startingLine +1] = password;
                        dataFile[startingLine +2] = Integer.toString(items.lieRate);
                        dataFile[startingLine +3] = Integer.toString(items.hintRate);
                        dataFile[startingLine +4] = Double.toString(items.extraMoney);
                        dataFile[startingLine +5] = Integer.toString(items.money);
                        dataFile[startingLine +6] = Boolean.toString(items.hints[0]);
                        dataFile[startingLine +7] = Boolean.toString(items.hints[1]);
                        dataFile[startingLine +8] = Boolean.toString(items.hints[2]);
                        dataFile[startingLine +9] = Boolean.toString(items.hints[3]);
                        dataFile[startingLine +10] = Boolean.toString(items.hints[4]);
                        dataFile[startingLine +11] = Boolean.toString(items.hints[5]);
                        statistics.writeToFile(dataFile);
                        done = JOptionPane.showConfirmDialog(null, "would you like to play again?", "", JOptionPane.YES_NO_OPTION); //if user clicks yes it sets done to 0, no to 1
                    }      
                }
            }
        }
        catch (IOException e) 
        {
            System.out.print("error");
        }
    }
}

