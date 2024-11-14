import java.util.Scanner;

public class SafeInput {


    /**
     * gets a string from the user using the console and
     * it must be at least 1 character long
     *
     * @param pipe   a Scanner used to get the input
     * @param prompt the prompt tells the user what to eneter
     * @return a String of at least one character in length
     */

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retVal = "";

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.isEmpty())
                System.out.println("You must enter at least one character:");

        } while (retVal.isEmpty());

        return retVal;
    }

    /**
     * gets an int value from the user at the console with no constraint
     *
     * @param pipe   ascanner used to get the input
     * @param prompt the prompt that tells the user what to enter
     * @return an int of any value
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {

                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }

        } while (!done);

        return retVal;
    }



    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        boolean done = false;
        double salary = 0;
        String trash = "";
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {

                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }

        } while (!done);

        return retVal;
    }
    /**
     *gets an integer from the user via console within a specified range
     *
     * @param pipe the scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low the low inclusive low bound
     * @param high the inclusive high bound
     * @return an int within the specified bounds
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + "[ " + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("you must enter a value within the range [" + low + " - " + high + " ]");
                }
            }

            else
            {

                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }

        } while (!done);

        return retVal;

    }

    /**
     * gets an integer from the user via console within a specified range
     *
     * @param pipe   the scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low    the low inclusive low bound
     * @param high   the inclusive high bound
     * @return an int within the specified bounds
     */


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + "[ " + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("you must enter a value within the range [" + low + " - " + high + " ]");
                }
            } else {

                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }

        } while (!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String YNResponse = " ";

        boolean retVal = false;
        boolean done = false;

        do
        {
            System.out.print(prompt + ":");
            YNResponse = pipe.nextLine();

            if(!YNResponse.matches("[YyNn]"))
            {
                System.out.println("You must enter [Y/N]: ");
            }
            else
            {
                done = true;
                switch (YNResponse)
                {
                    case "Y":
                    case "y":
                        retVal = true;
                        break;
                        case "N":
                            case "n":
                                retVal = false;
                                break;
                }
            }


        }while(!done);


        return retVal;



    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;
        do{
            System.out.print(prompt + " " + regEx);
            retVal = pipe.nextLine();
            if(retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("You must enter a matching expresssion " + regEx + " not " + retVal);
            }
        }while (!done);
        return retVal;
    }


        public static void prettyHeader(Scanner pipe, String msg) {
            // Length of total line is 60 characters
            int totalWidth = 60;

            // First and third line: 60 asterisks
            for (int i = 0; i < totalWidth; i++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line

            // Second line: "*** message ***" centered
            String border = "***";
            int contentWidth = totalWidth - (border.length() * 2); // Space available for the message
            int padding = (contentWidth - msg.length()) / 2; // Padding on each side of the message

            System.out.print(border); // Print left border
            for (int i = 0; i < padding; i++) {
                System.out.print(" "); // Padding before message
            }
            System.out.print(msg); // Print the message
            for (int i = 0; i < (contentWidth - padding - msg.length()); i++) {
                System.out.print(" "); // Padding after message
            }
            System.out.println(border); // Print right border

            // Third line: 60 asterisks again
            for (int i = 0; i < totalWidth; i++) {
                System.out.print("*");
            }
            System.out.println(); // End with a newline
        }

}







