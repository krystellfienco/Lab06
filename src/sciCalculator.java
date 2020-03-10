import java.util.Scanner;

public class sciCalculator {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        //all the variables used are below

        int optChoice = 0, rounds;
        double exp, log, intVal, totalVal, avg, add, sub, div, mult;
        double firstNum = 0, secNum = 0;
        intVal = 0.0;
        totalVal = 0.0;
        rounds = 0;
        boolean newgame = true;
        boolean exitCalc = false;
        String secNumWord;


        while (exitCalc == false) {

            //this if statement makes sure the "current results" and calculator menu show up for menu options 1-6 and not 0 or 7.

            if (newgame) {
                System.out.println("Current Result: " + intVal + "\n");

                //This is the calculator menu
                System.out.println("Calculator Menu");
                System.out.println("---------------");
                System.out.println("0. Exit Program");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exponentiation");
                System.out.println("6. Logarithm");
                System.out.println("7. Display Average\n");
            }


            //optChoice is the option choice (integer)
            System.out.print("Enter Menu Selection: ");
            optChoice = scnr.nextInt();


            //the following is for options 1 through 6

            if (optChoice >= 1 && optChoice <= 6) {
                System.out.print("Enter first operand: ");
                firstNum = scnr.nextDouble();
                System.out.print("Enter second operand: ");
                secNumWord = scnr.next();  //.next because the extra credit needs it to be a scanner

                //the following is the extra credit!!

                if (!secNumWord.equals("RESULT")) {
                    secNum = Double.parseDouble(secNumWord);
                } else {
                    secNum = intVal;
                }

            }

            System.out.print("\n"); //this is for a spacing issue

            intVal = 0; //this resets intVal to 0 so it can accurately display the "current result"


            //the following is the calculations:

            switch (optChoice) {
                case 0:
                    System.out.println("\nThanks for using this calculator. Goodbye!");
                    exitCalc = true; //every time user clicks 0 it will exit the calculator
                    break;
                case 1:
                    add = firstNum + secNum; //this is done for personal clarity
                    intVal = intVal + add; //intVal is the value that shows up for current results.
                    newgame = true; //this makes sure that it starts at the beginning again
                    rounds++; // this adds 1 to every round so it can keep count of #of calculations. I placed it here to solve an issue (could've placed it under new-game)
                    break;
                case 2:
                    sub = firstNum - secNum;
                    intVal = intVal + sub;
                    newgame = true;
                    rounds++;
                    break;
                case 3:
                    mult = firstNum * secNum;
                    intVal = intVal + mult;
                    newgame = true;
                    rounds++;
                    break;
                case 4:
                    div = firstNum / secNum;
                    intVal = intVal + div;
                    newgame = true;
                    break;
                case 5:
                    exp = Math.pow(firstNum, secNum);
                    intVal = exp;
                    newgame = true;
                    rounds++;
                    break;
                case 6:
                    log = Math.round(Math.log(secNum)/Math.log(firstNum));
                    intVal = intVal + log;
                    newgame = true;
                    rounds++;
                    break;
                case 7:
                    newgame = false; //this makes sure that the "current result" and calculator menu do not print
                    if (rounds == 0) { //if the calculator hasn't made any calculations yet
                        System.out.println("\nError: No calculations yet to average!\n");
                    }
                    else { //if the calculator HAS made calculations
                        System.out.println("Sum of calculations: " + totalVal);
                        System.out.println("Number of calculations: " + rounds);
                        avg = totalVal / rounds;
                        System.out.print("Average of calculations: ");
                        System.out.format("%.2f", avg);
                        //options for above: System.out.format("%.2f", avg); || (double)(Math.round(avg*100))/100
                        System.out.println("\n");
                    }
                    break;

                default: //for when no valid calculator menu selection is chosen
                    System.out.println("\nError: Invalid selection!\n");
                    newgame = false;
                    break;
            }

            //the following keeps track of the calculations made and adds them up so we can use it to find the average
            totalVal += intVal;

        }

    }
}
