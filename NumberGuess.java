
/**
 * Write a description of class NumberGuess here.
 * 
 * @author Preston Sheppard
 * @version 3.2
 */
import javax.swing.JOptionPane;  //Joptions panes used for input and display
import java.util.ArrayList;
public class NumberGuess
{
    int number;
    /**
     * Constructor for objects of class NumberGuess
     */
    public NumberGuess(int ranNumber)
    {
        number= ranNumber;
    }

    /**
     *Tests if number is prime
     *@return True if the number is prime, and false if the number is not
     */
    public boolean primeTest()
    {
        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Tests if number is even
     * @return True if it is even, and false if it is odd
     */

    public boolean evenTest()
    {
        if (number % 2 == 0)
            return true;
        else return false;
    }

    /**
     * Tests if number is a perfect power of the index user entered
     * @return True if the number is a perfect power, and false if it is not
     */
    public boolean perfectTest()    //tests if the number is a perfect square
    {
        if((int)(Math.pow(number, 1.0/2)) == Math.pow(number, 1.0/2))
            return true;
        else return false;
    }

    public int factors()
    {
        boolean primeDone = false;
        int newNumber = number;
        ArrayList<String> factors =  new ArrayList<String>();
        for (int factor = 1; factor <= (number); factor++)
        {                                                                               
            if (number % factor == 0)                                               
            {
                factors.add(Integer.toString(factor));               
                newNumber = number/factor;
            }            
        }    
        int factor = Integer.parseInt(factors.get(Utility.randomNumber(0, factors.size())));
        return factor;
    }

    public int sumOfFactors()
    {
        int sum = 0;
        ArrayList<String> factors =  new ArrayList<String>();
        for (int factor = 1; factor <= (number); factor++)
        {                                                                               
            if (number % factor == 0)                                               
            {
                sum += factor;
            }            
        }
        return sum;
    }

    public int sumOfDigits()
    {
        String number1 = Integer.toString(number);
        int sum = 0;
        for (int i=0; i < number1.length(); i++)
        {
            sum += number1.indexOf(i);
        }
        return sum;
    }

    public void printFacts(int numberGuess, int lieRate, int hintRate, boolean[] hints)
    {
        int infoNumber = Utility.randomNumber(1,5);
        if ((Utility.randomNumber(1, 100) > lieRate))
        {
            if (numberGuess > number)
                JOptionPane.showMessageDialog(null, numberGuess + "? get your head out of the clouds");
            if (numberGuess < number)
                JOptionPane.showMessageDialog(null, numberGuess + "? thats a low blow bro");
            if (Utility.randomNumber(1, 100) > hintRate)
            {
                if (infoNumber == 0 && evenTest() == true && hints[0] == true) 
                    JOptionPane.showMessageDialog(null, "The mystery number is even");
                if (infoNumber == 0 && evenTest() == false && hints[0] == true) 
                    JOptionPane.showMessageDialog(null, "The mystery number is odd");
                if (infoNumber == 1 && primeTest() == true && hints[1] == true)
                    JOptionPane.showMessageDialog(null, "The mystery number is prime");
                if (infoNumber == 2 && perfectTest() == false && hints[2] == true)
                    JOptionPane.showMessageDialog(null, "The mystery number is a perfect square");
                if (infoNumber == 3 && hints[3] == true)
                    JOptionPane.showMessageDialog(null, "A factor of the random number is: " + factors());
                if (infoNumber == 4 && hints[4] == true)
                    JOptionPane.showMessageDialog(null, "The sum of the factors is: " + sumOfFactors());
                if (infoNumber == 5 && hints[5] == true)
                    JOptionPane.showMessageDialog(null, "The sum of the digits of the number is: " + sumOfDigits());
            }
        }
        else
        {
            if (numberGuess < number)
                JOptionPane.showMessageDialog(null, numberGuess + " is too high");
            if (numberGuess > number)
                JOptionPane.showMessageDialog(null, numberGuess + " is too low");

            if (Utility.randomNumber(1, 100) > hintRate)
            {    
                if (infoNumber == 0 && evenTest() == true && hints[0] == true) 
                    JOptionPane.showMessageDialog(null, "The mystery number is odd");
                if (infoNumber == 0 && evenTest() == false && hints[0] == true) 
                    JOptionPane.showMessageDialog(null, "The mystery number is even");
                if (infoNumber == 1 && primeTest() == false && hints[1] == true)
                    JOptionPane.showMessageDialog(null, "The mystery number is prime");
                if (infoNumber == 2 && perfectTest() == false && hints[2] == true)
                    JOptionPane.showMessageDialog(null, "The mystery number is perfect");
                if (infoNumber == 3 && hints[3] == true) 
                    JOptionPane.showMessageDialog(null, "A factor of the random number is: " + Utility.randomNumber(1, number/2));
                if (infoNumber == 4 && hints[4] == true) 
                    JOptionPane.showMessageDialog(null, "The sum of the factors is: " + Utility.randomNumber(number/20, number/2));
                if (infoNumber == 5 && hints[5] == true)
                {
                    int upper = 1;
                    for(int i = 1; i < Integer.toString(number).length(); i *= 10)
                    {
                        upper += i*9;
                    }
                    JOptionPane.showMessageDialog(null, "The sum of the digits of the number is: " + Utility.randomNumber(((Integer.toString(number)).length()), upper));
                }
            }   
        }  
    }
}
