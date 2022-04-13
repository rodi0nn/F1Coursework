package oop.westminster.f1coursework;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Formula1ChampionshipManager F1Manager = new Formula1ChampionshipManager();
        Scanner input = new Scanner(System.in);

        // The following line of code loads data from the file.
        F1Manager.loadFileAuto();

        System.out.println("Welcome to the F1 Championship Manager - console version.\n\nThis is a list of options that you have available:"); // Title of the project
        System.out.println("1. Add a driver to the championship.\n2. Delete a driver from the championship.\n3. Change the teams of two drivers.\n4. Display the stats of a driver.\n5. Show the current standings of the championship.\n6. Add the results of a past race.\n7. Save all the data to file.\n8. Open the Race Simulator GUI.\n9. Exit the program.\n");
        
        System.out.print("To get started pick the number that's on the left of the option you wish to choose: ");
        String choice = input.nextLine();

        while (choice!=null) {

            if (choice.equals("1")) {
                F1Manager.addDriver();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("2")) {
                F1Manager.deleteDriver();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("3")) {
                F1Manager.changeTeam();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("4")) {
                F1Manager.displayStats();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("5")) {
                F1Manager.displayStandings();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("6")) {
                F1Manager.addRaceResults();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("7")) {
                F1Manager.saveFile();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("8")) {
                new RaceSimulatorGUI();
                System.out.print("Done! Now, please select another option or type MENU to see the list of options: ");
                choice = input.nextLine();
            }
            else if (choice.equals("9")) {
                System.out.println("The program will now exit.");
                input.close();
                System.exit(0);
            }
            else if (choice.equals("MENU") || choice.equals("menu") || choice.equals("Menu")) {
                System.out.println("This is a list of options that you have available:\n1. Add a driver to the championship.\n2. Delete a driver from the championship.\n3. Change the teams of two drivers.\n4. Display the stats of a driver.\n5. Show the current standings of the championship.\n6. Add the results of a past race.\n7. Save all the data to file.\n8. Open the Race Simulator GUI.\n9. Exit the program.\n");
                System.out.print("Now, please select another option: ");
                choice = input.nextLine();
                System.out.println();
            }
            else {
                System.out.print("Please select a valid option: ");
                choice = input.nextLine();
                System.out.println();
            }
        }
    }

}
