
/**
 * StatStorage adds acounts, verifies logins, stores data, and retrieves data.
 * 
 * @author Preston Sheppard
 * @version 3.2
 */
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class StatStorage
{
    String path;
    boolean append = true;
    public StatStorage(String filePath, boolean appendVal)
    {
        path = filePath;
        append = appendVal;
    }

    public int startScreen()
    {
        int startLine = -1;
        String[] possibilities = {"Login", "Create Acount", "Instructions", "Credits"};
        String option = (String)JOptionPane.showInputDialog(
                null,
                "Number Guessing: MADNESS",
                "",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                possibilities[0]);

        if (option == "Login")
        {
            try 
            {
                startLine = loginValidation();
            }
            catch(IOException e) {}
        }
        if (option == "Create Acount") 
        {
            try 
            {
                addAcount();
                startLine = -2;
            }
            catch(IOException e) {}
        }
        if (option == "Instructions")
        {
            JOptionPane.showMessageDialog(null, "Create an acount and then log in. All your progress is stored for your convenience" + "\n" + "Select a difficulty; the difficulty determines the lower and upper bounds of a random number." + "\n" + "Try to guess the number. Occasionally it will give you hints, but dont be fooled the game can lie to you!" + "\n" + "Collect your reward and head to the shop! There are all sorts of helpful upgrades" + "\n" + "Once you're decked out in cool upgrades try some harder difficulties, and eventally WIN! (whatever that means)");
            startLine = -2;
        }
        if (option == "Credits")
        {
            JOptionPane.showMessageDialog(null, "Number Guessing: MADNESS" + "\n" + "Version 3.2" + "\n" + "Created by: Preston Sheppard" + "\n" + "Produced: by Preston Sheppard" + "\n" + "Concieved by: Preston Sheppard" + "\n" + "Developed by: Preston Sheppard" + "\n" + "Edited by: Preston Sheppard" + "\n" + "Commented by: Preston Sheppard" + "\n" + "Reviewed by: Preston Sheppard 12/12 stars" + "\n" + "Updated by: Preston Sheppard" + "\n" + "Given a 120 by: Anthony Beckwith");
            startLine = -2;
        }
        return startLine;
    }

    public void addAcount()
    throws IOException
    {
        try
        {
            String acountName = JOptionPane.showInputDialog("Please type your new username:");
            String password = JOptionPane.showInputDialog("Please type your new password:");
            if (!password.equals(null) && !acountName.equals(null))
            {
                if (nameCheck(acountName))
                {
                    FileWriter statistics = new FileWriter(path, append);
                    PrintWriter stats = new PrintWriter(statistics);
                    writeToFile(acountName);
                    writeToFile(password);
                    writeToFile("50");
                    writeToFile("50");
                    writeToFile("1.0");
                    writeToFile("0");
                    writeToFile("false");
                    writeToFile("false");
                    writeToFile("false");
                    writeToFile("false");
                    writeToFile("false");
                    writeToFile("false");
                    stats.close();
                }
                else JOptionPane.showMessageDialog(null, "An acount with that username already exists");
            }
            else JOptionPane.showMessageDialog(null, "You must input both a username and password");
        }
        catch (NullPointerException e) {}
    }

    public boolean nameCheck(String username)
    throws IOException
    {
        boolean valid = true;
        String[] nameCheck = new String[numberLines()];
        nameCheck = readFile(0, numberLines());
        for (int i = 0; i < numberLines(); i += 12)
        {            
            if (nameCheck[i].equals(username))
            {
                valid = false;
            }
            else valid = true;
        }      
        return valid;
    }

    public int loginValidation()
    throws IOException
    {
        String acountName = JOptionPane.showInputDialog("Acount Name:");
        String password = JOptionPane.showInputDialog("Password:");
        FileReader statistics = new FileReader(path);
        BufferedReader statsReader = new BufferedReader(statistics);
        String[] fileContent = new String[numberLines()]; 
        fileContent = readFile(0, numberLines());
        int startingLine = -1;
        p:for (int i = 0; i < numberLines(); i += 12)
        {
            if (acountName.equals(fileContent[i]) && password.equals(fileContent[(i + 1)]))
            {
                startingLine = i;
                break p;
            }
            else startingLine = -1;
        }
        statsReader.close();
        if (startingLine == -1)
        {
            JOptionPane.showMessageDialog(null, "Incorrect username or password");
        }
        return startingLine;
    }

    int numberLines() throws IOException
    {
        FileReader statistics = new FileReader(path);
        BufferedReader statsReader = new BufferedReader(statistics);
        String line;
        int NumberOfLines = 0;
        while (statsReader.readLine() != null)
        {   
            NumberOfLines++;
        }
        statsReader.close();
        return NumberOfLines;
    }

    public String[] readFile(int startingLine, int linesToRead) throws IOException
    {
        FileReader statistics = new FileReader(path);
        BufferedReader statsReader = new BufferedReader(statistics);
        String[] fileContent = new String[linesToRead];
        for (int i = startingLine; i < linesToRead; i++)
        {            
            fileContent[i] = statsReader.readLine();
        }
        statsReader.close();
        return fileContent;
    }

    public void writeToFile(String text)
    throws IOException
    {
        FileWriter statistics = new FileWriter(path, append);
        PrintWriter stats = new PrintWriter(statistics);
        stats.printf("%s" + "%n", text);
        stats.close();
    }

    public void writeToFile(String[] file)
    throws IOException
    {
        FileWriter statistics = new FileWriter(path, false);
        PrintWriter stats = new PrintWriter(statistics);
        for (int i = 0; i < file.length; i++)
        {
            stats.printf("%s" + "%n", file[i]);
        }
        stats.close();
    }
}