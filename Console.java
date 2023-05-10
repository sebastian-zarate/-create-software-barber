
/**
 * Write a description of class Console here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Console
{
     /**
     * Print a prompt on the console but don't print a newline
     * @param prompt the prompt string to display
     */

    public static void printPrompt(String prompt)
    {
        System.out.println(prompt + " ");
        System.out.flush();
    }

    /**
     * Read a string from console. The string is terminated by a newline
     * @return the input string (without the newline)
     */

    public static String readLine() // INTRODUCIR UN TEXTO
    {
        int ch;
        String r = "";
        boolean done = false;
        while (!done)
        {
            try
            {
                ch = System.in.read();
                if (ch == 0 || (char)ch == '\n')
                    done = true;
                else if ((char)ch != '\r')
                    r = r + (char) ch;
            }
            catch(java.io.IOException e)
            {
                done = true;
            }
        }
            return r;
    }

    /**
     * Read a string from the console. The string is terminated by a newline
     * @param prompt the prompt string to display
     * @return the input string (without the newline)
     */
    public static String readLine(String prompt)
    {
        printPrompt(prompt);
        return readLine();
    }


      /**
     * Read a char from the console. The char is terminated by a newline
     * @return The input char (without the newline)
     */
    public static char readChar(String prompt)
    {
        while(true)
        {
            printPrompt(prompt);
            try
            {
                return readLine().trim().toCharArray()[0];
             }
            catch(NumberFormatException e)
            {
                System.out.println("Not an integer. Please try again!");
            }
           }
    }

    /**
     * Read an integer from the console. The input is terminated by a newline
     * @param prompt the prompt string to display
     * @return the input value as an int
     * @exception NumberFormatException if bad input
     */
       public static int readInt(String prompt)
    {
         while (true)
         {
            printPrompt(prompt);
            try
            {
                return Integer.valueOf
                   (readLine().trim()).intValue();
            }
            catch(NumberFormatException e)
            {
                System.out.println("Not an integer. Please try again!");
            }
        }
    }

    /**
     * Read a floating point number from the console. The input is terminated by a newline
     * @param prompt the prompt string to display
     * @return the input value as a double
     * @exception NumberFormatException if bad input
     */
    public static double  readDouble(String prompt)
    {
        while (true)
        {
            printPrompt(prompt);
            try
            {
                return Double.parseDouble(readLine().trim());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Not a floating point number. Please try again!");
            }
        }
    }
}
