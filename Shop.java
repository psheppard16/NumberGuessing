
/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;  //Joptions panes used for input and display
public class Shop
{
    String name;
    boolean[] hints = new boolean[6];
    int lieRate;
    int hintRate;
    double extraMoney;
    int money;
    /**
     * Constructor for objects of class Shop
     */
    public Shop(String acountName, boolean[] numHints, int truth, int rateHint, double extMoney, int currentMoney)
    {
        name = acountName;
        hints = numHints;
        lieRate = truth;
        hintRate = rateHint;
        extraMoney = extMoney;
        money = currentMoney;
    }

    public void buyItems()
    {
        String item1;
        String item2;
        String item3;
        if (lieRate >= 10)
        {
            item1 = "higher chance of truthfull hints";
        }
        else item1 = "Already bought";
        if (hintRate >= 10)
        {
            item2 = "higher chance of hints";
        }
        else item2 = "Already bought";
        if (extraMoney <= 1.8)
        {
            item3 = "extra money earned";
        }
        else item3 = "Already bought";
        String[] possibilities = {"Buy more hints", item1, item2, item3};
        String item = (String)JOptionPane.showInputDialog(
                null,
                "What would you like to buy?",
                "Items:",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                possibilities[0]);
        if(item == "Buy more hints")
        {
            if (money >= 100)
            {
                buyHints();
            }
            else JOptionPane.showMessageDialog(null, "You do not have enough money");
        }
        if(item == "higher chance of truthful hints" && money >= 100) 
        {
            if (money >= 100)
            {
                lieRate -= 10;
                money -= 100;
            }
            else JOptionPane.showMessageDialog(null, "You do not have enough money");
        }
        if(item == "higher chance of hints" && money >= 100)
        {
            if (money >= 100)
            {
                hintRate -= 10;
                money -= 100;
            }
            else JOptionPane.showMessageDialog(null, "You do not have enough money");
        }
        if(item == "extra money earned" && money >= 100)
        {
            if (money >= 100)
            {
                extraMoney += .2;
                money -= 100;
            }
            else JOptionPane.showMessageDialog(null, "You do not have enough money");
        }
    }

    public void buyHints()
    {
        String item0;
        String item1;
        String item2;
        String item3;
        String item4;
        String item5;
        if (hints[0] == false)
        {
            item0 = "even/odd hints";
        }
        else item0 = "Already bought";
        if (hints[1] == false)
        {
            item1 = "prime hints";
        }
        else item1 = "Already bought";
        if (hints[2] == false)
        {
            item2 = "perfect square hints";
        }
        else item2 = "Already bought";
        if (hints[3] == false)
        {
            item3 = "factor hints";
        }
        else item3 = "Already bought";
        if (hints[4] == false)
        {
            item4 = "sum of factors hint";
        }
        else item4 = "Already bought";
        if (hints[5] == false)
        {
            item5 = "sum of digits hint";
        }
        else item5 = "Already bought";

        String[] possibilities = {item0, item1, item2, item3, item4, item5};
        String item = (String)JOptionPane.showInputDialog(
                null,
                "What hints would you like to buy?",
                "Possible hints:",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                possibilities[0]);
        if(item == "even/odd hints" && money >= 100) 
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy even/odd hints?" + "\n" + "Costs: 100" + "\n" + "Periodically displays whether the random number is even or odd");
            if (confirm == 0)
            {
                if (money >= 100)
                {
                    hints[0] = true;
                    money -= 100;
                }
                else JOptionPane.showMessageDialog(null, "You do not have enough money");
            }
        }
        if(item == "prime hints" && money >= 100) 
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy prime hints?" + "\n" + "Costs: 100" + "\n" + "Periodically displays whether the number is prime");
            if (confirm == 0)
            {
                if (money >= 100)
                {
                    hints[1] = true;
                    money -= 100;
                }
                else JOptionPane.showMessageDialog(null, "You do not have enough money");
            }
        }
        if(item == "perfect square hints" && money >= 100) 
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy perfect root hints?" + "\n" + "Costs: 100" + "\n" + "Periodically displays whether the random number is a perfect square");
            if (confirm == 0)
            {
                if (money >= 100)
                {
                    hints[2] = true;
                    money -= 100;
                }
                else JOptionPane.showMessageDialog(null, "You do not have enough money");
            }
        }
        if(item == "factor hints" && money >= 100) 
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy factor hintst?" + "\n" + "Costs: 100" + "\n" + "Periodically displays a factor of the random number");
            if (confirm == 0)
            {
                if (money >= 100)
                {
                    hints[3] = true;
                    money -= 100;
                }
                else JOptionPane.showMessageDialog(null, "You do not have enough money");
            }
        }
        if(item == "sum of factors hint" && money >= 100) 
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy sum of factors hint?" + "\n" + "Costs: 100" + "\n" + "Periodically displays the sum of factors of the random number");
            if (confirm == 0)
            { 
                if (money >= 100)
                {
                    hints[4] = true;
                    money -= 100;
                }
                else JOptionPane.showMessageDialog(null, "You do not have enough money");
            }
        }
        if(item == "sum of digits hint" && money >= 100) 
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like to buy sum of digits hint?" + "\n" + "Costs: 100" + "\n" + "Periodically displays the sum of the digits of the random number");
            if (confirm == 0)
            {
                if (money >= 100)
                {
                    hints[5] = true;
                    money -= 100;
                }
                else JOptionPane.showMessageDialog(null, "You do not have enough money");
            }
        }
    }
}
