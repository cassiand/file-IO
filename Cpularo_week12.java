package cpularo_week12;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Cassian Pularo
 * @Assignment Name: cpularo_week12
 * @Date: Dec 3, 2022
 * @Description: main class to implement methods for file IO
 */
//Imports
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

//Begin Class Cpularo_week12
public class Cpularo_week12 {
//Begin Main Method

    public static void main(String[] args) {
        /* string to hold response to run program again */
        String choice;
        Validate val = new Validate();

        do {
            /* declare new scanner object */
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to My Statistics Calculator");
            String userFile;
            System.out.print("Enter the name of your text file\nThe file extension "
                    + "will be added after entry.");
            userFile = sc.next();
            /* add extension */
            String fileName = "C:/W12Assignment/" + userFile + ".txt";
            File file = new File(fileName);
            /* create string for default directory name */
            String fileDirName = "C:/W12Assignment";
            File fileDir = new File(fileDirName);

            /* create directory if it doesnt exist */
            if (!fileDir.exists()) {
                fileDir.mkdirs();
                System.out.println("The directory does not exist.\nCreating "
                        + "directory...");
                System.out.printf("Directory created at this location ->: "
                        + "\n%s\n", fileDir.getAbsolutePath());
            } else {
                System.out.printf("The directory does exist at this location: "
                        + "\n%s\n", fileDir.getAbsolutePath());
            }
            /* create file if it doesnt exist */
            if (!file.exists()) {
                System.out.println("The file does not exist.\nCreating file...");
                try {
                    file.createNewFile();
                    /* try catch block to catch exception */
                } catch (IOException ex) {
                    System.out.println("The file could not be created");
                }
                System.out.printf("File created at this location ->: \n%s\n",
                        file.getAbsolutePath());
            } else {
                System.out.printf("The file already exists at this location: "
                        + "\n%s\n", file.getAbsolutePath());
            }

            /* ask user what they want to do */
 /* try catch block to catch non-number responses */
            try {

                System.out.print("Please select from the following menu of options:"
                        + "\n1.Enter data\n2.Read data\n3.Exit\n");

                int menuChoice = sc.nextInt();


                /* check if they chose a valid menu option */
                switch (menuChoice) {
                    /* enter data */
                    case 1:
                        WriteData write = new WriteData();

                        System.out.print("How many numbers would you like to send "
                                + "to the file?->: ");

                        int userNums = sc.nextInt();
                        /* add each user number to array list */
                        for (int i = 0; i < userNums; i++) {
                            System.out.printf("Enter number %d\n", i + 1);

                            double num = sc.nextDouble();

                            /* add number to array list */
                            write.addNum(num);
                        }

                        /* call method to add nums to file */
                        write.setUserData(file);

                        String userReply;
                        System.out.print("Would you like to see the results? ->:");
                        int x = 1;
                        /* loop until user says yes or no */
                        while (x > 0) {
                            userReply = sc.next();

                            /* validate reply */
                            if (val.checkYesNo(userReply) && userReply.equalsIgnoreCase("y")) {
                                System.out.println("The numbers in this file are:");
                                write.getUserData();
                            } else {
                                System.out.print("You must enter yes or no. Would you like to see the results?: ");

                            }
                        }

                        break;

                    /* read data */
                    case 2:
            
                        try {
                        ReadData read = new ReadData(); 
                        Scanner input = new Scanner(file);
                        /* call setData to add elems to arraylist */
                        try {
                            
                                read.setData(input);
                                System.out.println("The numbers in this file are: ");

                                read.getData();

                                /* assign vars */
                                double AVG = read.getAvg();
                                double MIN = read.getMin();
                                double MAX = read.getMax();
                                double STD_DEV = read.getStdDev();
                                System.out.printf("The average of the numbers in the file "
                                        + "is: %.4f\n", AVG);
                                System.out.printf("The smallest number in the file is: %.4f\n",
                                        MIN);
                                System.out.printf("The largest number in the file is: %.4f\n",
                                        MAX);
                                System.out.printf("The standard deviation for the numbers "
                                        + "in this file is: %.4f", STD_DEV);
                            } catch (NoSuchElementException e) {
                                System.out.println("The file is either empty or corrupt");
                            }
                        

                        } catch (FileNotFoundException ex) {
                        System.out.println("The file does not exist");
                        }

                        break;

                    /* exit */
                    case 3:
                        System.out.println("Thank you for using the program! "
                                + "Goodbye!");
                        System.exit(0);
                        break;

                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number.");
                System.exit(0);

            }

            /* ask user if program should repeat */
            System.out.print("\nWould you like to run another calculation? Y "
                    + "for Yes, N for No: ");

            choice = sc.next();
            /* call method to validate */
            if (val.checkYesNo(choice) == false) {
                System.out.println("You must enter Y or N");
            }
        } while (choice.equalsIgnoreCase("y"));
        System.out.println("Thank you for using the program! "
                + "Goodbye!");
        System.exit(0);

    } //End Main Method
} //End Class Cpularo_week12
