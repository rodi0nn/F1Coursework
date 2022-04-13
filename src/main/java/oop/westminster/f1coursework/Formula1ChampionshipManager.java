package oop.westminster.f1coursework;

import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Formula1ChampionshipManager implements ChampionshipManager {
    
    @Override
    public void addDriver() {
        System.out.println();

        // A new Formula1Driver object is created.
        Formula1Driver driver = new Formula1Driver();
        
        System.out.println("To add a new driver follow the instructions!");
        
        // The following lines of code allow the user to complete the fields of the object which were inherited from the parent class Driver (fullName, age, coutrnyOfBirth, carManufacturer).
        System.out.print("Enter the name of the driver: ");
        driver.fullName = input.nextLine();
        
        // This while loop allows the user to input only correct values for the age field. Note that the F1 regulations state that a driver must be 18 or older to compete.
        // This while loop does not allow the user to input values greater than 100, in order to prevent unrealistic number such as a driver who is 1000 years old.
        while (true) {
            try {
                System.out.print("Enter the age of the driver (years only): ");
                driver.age = Integer.parseInt(input.nextLine());
                if (driver.age<18) {
                    System.out.println("The minimum age for a driver to compete in the F1 championship is 18.");
                    throw new IllegalArgumentException("The minimum age for a driver to compete in the F1 championship is 18.");
                }
                if (driver.age>100) {
                    System.out.println("The driver might be too old to compete.");
                    throw new IllegalArgumentException("The driver might be too old to compete.");
                }
                break;
            }
            catch (Exception e) {
                System.out.println("The inputed value is not valid!");
            }
        }
        
        System.out.print("Enter the country of brith of the driver (Abbreviated to maximum 3 letters): ");
        driver.countryOfBirth = input.nextLine();
        
        System.out.print("Enter the team for which the driver will compete: ");
        driver.carManufacturer = input.nextLine();
        
        // This while loop will make sure that the value of the field carManufacturer is unique for each Formula1Driver object.
        int i=0;
        while (i<drivers.size()) {
            if (driver.carManufacturer.equals(drivers.get(i).carManufacturer)) {
                System.out.print("The team " + driver.carManufacturer + " already has a driver. Please enter another team: ");
                driver.carManufacturer = input.nextLine();
                i=0;
            }
            else i++;    
        }
        
        drivers.add(driver);
        System.out.println("The driver was succesfully added!");
        System.out.println();
    }

    @Override
    public void deleteDriver() {
        System.out.println();
        if (drivers.isEmpty()) {
            System.out.println("There are no drivers in the championship just yet!");
        }
        else {
            System.out.println("To delete a certain driver form the data, follow the instructions!");
        
            // This while loop will display a list of all the objects of the class Formula1Driver to find the driver the user wants to remove from the championship.
            System.out.print("To see a full list of the drivers that compete in the championship, press 1 now or press 2 to proceed: ");
            String choice = input.nextLine();
            while (choice!=null) {
                if (choice.equals("1")) {
                    for (int i=0; i<drivers.size(); i++)
                        System.out.println(i+1 + ". " + drivers.get(i).fullName + " - " + drivers.get(i).carManufacturer);
                    break;
                }
                if (choice.equals("2")) break;
                System.out.print("Invalid choice! Please press 1 or press 2 to continue: ");
                choice = input.nextLine();
            }
                
            // This while loop will make sure that the option that the user choose is part of the championship (i.e. the input is not a larger number than the size of the ArrayList drivers).
            while (true) {
                try {
                    System.out.print("Please enter the number of the driver you wish to remove from the championship: ");
                    int driver = Integer.parseInt(input.nextLine());
                    if (driver<0 || driver>drivers.size()) {
                        throw new IllegalArgumentException("You must pick a number associated with a driver who is currently in the championship.");
                    }
                    // The following lines remove the driver associated with the number driver-1 from the ArrayList drivers.
                    drivers.remove(driver-1);
                    System.lineSeparator();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Please enter a valid number.\n\n");
                }
            }
            
            // This for loop displays a list of the drivers that still compete in the championship.
            System.out.println("A list of the remaining competitors: ");
            for (int i=0; i<drivers.size(); i++)
                System.out.println(i+1 + ". " + drivers.get(i).fullName + " ");
            
            System.lineSeparator();
                
            System.out.println("Succesfully removed the driver from the championship!");
        }
        System.out.println();  
    }

    @Override
    public void changeTeam() {
        System.out.println();
        if (drivers.isEmpty()) System.out.println("Thereare no drivers in the championship just yet.");
        else {
            System.out.print("Press 1 to swap the teams of two drivers or press 2 to change the team of a driver: ");
            String choice = input.nextLine();
            while (choice!=null) {
                if (choice.equals("1")) break;
                if (choice.equals("2")) break;
                System.out.print("Invalid choice! Please press 1 or press 2 in order to continue: ");
                choice = input.nextLine();
            }
            if (choice.equals("1")) {
                if (drivers.size()<2) {
                    System.out.println("There are not enough drivers in the championship to perform the swap.");
                }
                else {
                    System.out.println("To swap the teams of two drivers please follow the instructions!");
                    
                    // This while loop will display a list of all the objects of the class Formula1Driver to find the drivers whose teams the user wants to swap.
                    System.out.print("To see a full list of the drivers that compete in the championship, press 1 now or press 2 to proceed: ");
                    choice = input.nextLine();
                    while (choice!=null) {
                        if (choice.equals("1")) {
                            for (int i=0; i<drivers.size(); i++)
                                System.out.println(i+1 + ". " + drivers.get(i).fullName + " - " + drivers.get(i).carManufacturer);
                            break;
                        }
                        if (choice.equals("2")) break;
                        System.out.print("Invalid choice! Please press 1 or press 2 to continue: ");
                        choice = input.nextLine();
                    }
                    
                    System.lineSeparator();
                    // The following lines allow the user to input only valid values (for the numbers associated with the two drivers whose teams the user wants to swap).
                    int driver1, driver2;
                    while (true) {
                        try {
                            System.out.print("Please enter the number of the first driver whose team you want to change: ");
                            driver1 = Integer.parseInt(input.nextLine());
                            if (driver1<0 || driver1>drivers.size()) {
                                System.out.println("You must pick a number associated with a driver who is currently in the championship.");
                                throw new IllegalArgumentException("You must pick a number associated with a driver who is currently in the championship.");
                            }
                            break;
                        }
                        catch (Exception e) {
                            System.out.println("Please enter a valid number.\n\n");
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Please enter the number of the first driver whose team you want to change: ");
                            driver2 = Integer.parseInt(input.nextLine());
                            if (driver2<0 || driver2>drivers.size()) {
                                System.out.println("You must pick a number associated with a driver who is currently in the championship.");
                                throw new IllegalArgumentException("You must pick a number associated with a driver who is currently in the championship.");
                            }
                            break;
                        }
                        catch (Exception e) {
                            System.out.println("Please enter a valid number.\n\n");
                        }
                    }
        
                    // The following 3 lines of code are moment of the change in values of the field carManufacturer of the two objects - driver that the suer choose.
                    String aux = drivers.get(driver1-1).carManufacturer;
                    drivers.get(driver1-1).carManufacturer = drivers.get(driver2-1).carManufacturer;
                    drivers.get(driver2-1).carManufacturer = aux;
                    
                    System.out.println("The following data has been updated succesfully!");
                    System.out.println("The driver " + drivers.get(driver1-1).fullName + " is now part of the team " + drivers.get(driver1-1).carManufacturer + ".");
                    System.out.println("The driver " + drivers.get(driver2-1).fullName + " is now part of the team " + drivers.get(driver2-1).carManufacturer + ".");
                }
            }
            else {
                System.out.println("To change the team of a driver please follow the instructions!");
                    
                // This while loop will display a list of all the objects of the class Formula1Driver to find the drivers whose teams the user wants to swap.
                System.out.print("To see a full list of the drivers that compete in the championship, press 1 now or press 2 to proceed: ");
                choice = input.nextLine();
                while (choice!=null) {
                    if (choice.equals("1")) {
                        for (int i=0; i<drivers.size(); i++)
                            System.out.println(i+1 + ". " + drivers.get(i).fullName + " - " + drivers.get(i).carManufacturer);
                            break;
                        }
                    if (choice.equals("2")) break;
                    System.out.print("Invalid choice! Please press 1 or press 2 to continue: ");
                    choice = input.nextLine();
                }

                // This while loop will allow the user to choose a valid number associated with the driver.
                int driver1;
                while (true) {
                    try {
                        System.out.print("Please enter the number of the driver whose team you want to change: ");
                        driver1 = Integer.parseInt(input.nextLine());
                        if (driver1<0 || driver1>drivers.size()) {
                            System.out.println("You must pick a number associated with a driver who is currently in the championship.");
                            throw new IllegalArgumentException("You must pick a number associated with a driver who is currently in the championship.");
                        }
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Please enter a valid number.\n\n");
                    }
                }
                
                // The following lines of code will let the user input a valid value for the driver's new car manufacturer.
                System.out.print("Enter the new team of the driver " + drivers.get(driver1-1));
                drivers.get(driver1-1).carManufacturer = input.nextLine();
                int i=0;
                while (i<drivers.size()) {
                    if (driver1-1==i) i++;
                    else {
                        if (drivers.get(driver1-1).carManufacturer.equals(drivers.get(i).carManufacturer)) {
                            System.out.print("The team " + drivers.get(driver1-1).carManufacturer + " already has a driver. Please enter another team: ");
                            drivers.get(driver1-1).carManufacturer = input.nextLine();
                            i=0;
                        }
                        else i++;  
                    } 
                }

                System.out.println("The following data has been updated succesfully!");
                System.out.println("The driver " + drivers.get(driver1-1).fullName + " is now part of the team " + drivers.get(driver1-1).carManufacturer + ".");
            }
        }
        
        System.out.println();
    }

    @Override
    public void displayStats() {
        System.out.println();
        if (drivers.isEmpty()) {
            System.out.println("There are no drivers in the championship just yet.");
        }
        else {
            System.out.println("To display the stats of a driver please follow the instructions!");
        
            // This while loop will display a list of all the objects of the class Formula1Driver to find the driver whose stats the user wants displayed.
            System.out.print("To see a full list of the drivers that compete in the championship, press 1 now or press 2 to proceed: ");
            String choice = input.nextLine();
            while (choice!=null) {
                if (choice.equals("1")) {
                    for (int i=0; i<drivers.size(); i++)
                        System.out.println(i+1 + ". " + drivers.get(i).fullName + " - " + drivers.get(i).carManufacturer);
                    break;
                }
                if (choice.equals("2")) break;
                else {
                    System.out.print("Invalid choice! Please press 1 or press 2 to continue: ");
                    choice = input.nextLine();
                }
            }

            // The following lines of code will display the statistics obtained by the driver. 
            int driver;
            System.out.print("Please enter the number of the driver whose stats should be displayed: ");
            while (true) {
                try {
                    System.out.print("Please enter the number of the driver whose stats should be displayed: ");
                    driver = Integer.parseInt(input.nextLine());
                    if (driver<1) {
                        System.out.println("This is not a valid number.");
                        throw new IllegalArgumentException("The input is out of range.");
                    }
                    if (driver>drivers.size()) {
                        System.out.println("This is not a valid number.");
                        throw new IllegalArgumentException("The input is out of range.");
                    }
                    break;
                }
                catch (Exception e) {
                    System.out.println("The inputed value is not valid!");
                }
            }

            System.out.println("The stats of the driver " + choice + " are:");
            System.out.println("No. of 1st place finishes: " + drivers.get(driver-1).pos1st);
            System.out.println("No. of 2nd place finishes: " + drivers.get(driver-1).pos2nd);
            System.out.println("No. of 3rd place finishes: " + drivers.get(driver-1).pos3rd);
            System.out.println("Total points accumulated: " + drivers.get(driver-1).totalPoints);
            System.out.println("No. of races: " + drivers.get(driver-1).numberOfRaces);
        }
        System.out.println();
    }

    @Override
    public void displayStandings() {
        System.out.println();
        if (drivers.isEmpty()) System.out.println("There are no drivers in the championship just yet.");
        else {
            List<Formula1Driver> standings = new ArrayList<>();
            standings = drivers;

            Comparator<Formula1Driver> comparator = (driver1, driver2) -> {
                if (driver1.getTotalPoints()!=driver2.getTotalPoints()) return Integer.compare(driver2.getTotalPoints(), driver1.getTotalPoints());
                else  return Integer.compare(driver2.get1stPos(), driver1.get1stPos());
            };

            Collections.sort(standings, comparator);
                

            System.out.println("POS" + " " + "DRIVER" + " " + "NATIONALITY" + " " + "CAR" + " " + "PTS" + " " + "1ST");
            for (int i=0; i<standings.size(); i++) {
                System.out.println(i + 1 + ". " + standings.get(i).fullName + " " + standings.get(i).countryOfBirth + " " + standings.get(i).carManufacturer + " " + standings.get(i).totalPoints + " " + standings.get(i).pos1st);
            }
        }
        System.out.println();
    }

    @Override
    public void addRaceResults() {
        System.out.println();
        Race race = new Race();

        System.out.println("To enter a completed race follow the instructions!");

        // The following lines of code will convert the inputed string into a date that represents the date of the race.
        while(true) {
            try {
                System.out.print("Enter the date of the race (The date format should be: dd-MM-yyyy): ");
                String date = input.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                race.raceDate = dateFormat.parse(date);
                break;
            }
            catch (ParseException e) {
                System.out.println("Invalid date!");
            }
        }

        // The following lines of code will let the user input the location of the race.
        System.out.print("Enter the country where the race took place: ");
        race.raceCountry = input.nextLine();
        System.out.print("Enter the city where the race will take place: ");
        race.raceCity = input.nextLine();

        // Completing the ArrayList potentialPositions with all the positions a driver can obtain.
        race.positions = drivers;
        ArrayList<Integer> potentialPositions = new ArrayList<>();

        // Tying the drivers stored in the array positions to the position the user wants.
        System.out.println("Please specify the position obtained by each driver.");
        for ( int i=0; i<race.positions.size(); i++) {
            while (true) {
                try {
                    System.out.print(race.positions.get(i).fullName + " took the place no. : ");
                    race.positions.get(i).lastRacePosition = Integer.parseInt(input.nextLine());
                    
                    
                    // The for loop checks whether or not the position is taken.
                    for (int j=0; j<potentialPositions.size(); j++)
                        if (race.positions.get(i).lastRacePosition==potentialPositions.get(j)) {
                            System.out.println("There is already someone occupying this position.");
                            throw new IllegalArgumentException("Position is already taken.");
                        }

                    potentialPositions.add(race.positions.get(i).lastRacePosition);

                    // Incrementing the number of races with one after each race.
                    drivers.get(i).numberOfRaces = drivers.get(i).numberOfRaces + 1;

                    // Completing the stats of the driver.
                    if (race.positions.get(i).lastRacePosition==1) drivers.get(i).pos1st = drivers.get(i).pos1st + 1; 
                    if (race.positions.get(i).lastRacePosition==2) drivers.get(i).pos2nd = drivers.get(i).pos2nd + 1;
                    if (race.positions.get(i).lastRacePosition==3) drivers.get(i).pos3rd = drivers.get(i).pos3rd + 1;

                    if (race.positions.get(i).lastRacePosition<1) {
                        System.out.println("This is not a valid number.");
                        throw new IllegalArgumentException("The input is out of range.");
                    }
                    if (race.positions.get(i).lastRacePosition>race.positions.size()) {
                        System.out.println("This is not a valid number.");
                        throw new IllegalArgumentException("The input is out of range.");
                    }
                    break;
                }
                catch (Exception e) {
                    System.out.println("The inputed value is not valid!");
                }
            }

            
        }

        // Incrementing the points count for each driver in accordance with the system offered in the coursework specifications.
        for (int i=0; i<race.positions.size(); i++) {
            if (race.positions.get(i).lastRacePosition == 1) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 25;
            if (race.positions.get(i).lastRacePosition == 2) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 18;
            if (race.positions.get(i).lastRacePosition == 3) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 15;
            if (race.positions.get(i).lastRacePosition == 4) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 12;
            if (race.positions.get(i).lastRacePosition == 5) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 10;
            if (race.positions.get(i).lastRacePosition == 6) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 8;
            if (race.positions.get(i).lastRacePosition == 7) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 6;
            if (race.positions.get(i).lastRacePosition == 8) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 4;
            if (race.positions.get(i).lastRacePosition == 9) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 2;
            if (race.positions.get(i).lastRacePosition == 10) drivers.get(i).totalPoints = drivers.get(i).totalPoints + 1; 
        }
        

        // Comparator that orders the drivers by the obtaines position.
        Comparator<Formula1Driver> comparator = (driver1, driver2) -> {
            return Integer.compare(driver1.getLastRacePosition(), driver2.getLastRacePosition());
        };
        Collections.sort(race.positions, comparator);

        races.add(race);

        System.out.println();
        System.out.println("The race results are: ");
        for ( int i=0; i<race.positions.size(); i++) {
            System.out.println(i+1 + ". " + race.positions.get(i).fullName + " | " + race.positions.get(i).countryOfBirth + " | " + race.positions.get(i).carManufacturer);
        }
 
        System.out.println();
    }

    @Override
    public void saveFile() {
        System.out.println();
        // The following lines of code create the file "savedf1data.txt". 
        File SavedData;
        try {
            SavedData = new File("savedf1data.txt");
            if (SavedData.createNewFile()) {
                System.out.println("All the data was saved to " + SavedData.getName() + "."); 
            } else System.out.println("File already exists. The data from the file has been updated.");
        }
        catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
        }
        try {
            FileWriter typer = new FileWriter("savedf1data.txt");
            for (int i=0; i<drivers.size(); i++) {
                typer.write(drivers.get(i).fullName + " | " + drivers.get(i).age + " | " + drivers.get(i).countryOfBirth + " | " + drivers.get(i).carManufacturer + " | " + drivers.get(i).numberOfRaces + " | " + drivers.get(i).pos1st + " | " + drivers.get(i).pos2nd + " | " + drivers.get(i).pos3rd + " | " + drivers.get(i).totalPoints + "\n");
            }
            typer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred while completing the file.");
        }

        // The following lines of code create the file "races.txt". 
        try {
            File RaceSavedData = new File("races.txt");
            if (RaceSavedData.createNewFile()) {
                System.out.println("All the data was saved to " + RaceSavedData.getName() + "."); 
            } else System.out.println("File already exists. The results of the races have been updated.");
        }
        catch (IOException e) {
            System.out.println("An error occurred when creating the file.");
            e.printStackTrace();
        }
        try {
            FileWriter typer = new FileWriter("races.txt");
            // The following nested for loops will complete the file with the results of every race recorded.
            for (int j=0; j<races.size(); j++) {
                typer.write(races.get(j).raceDate + " | " + races.get(j).raceCity + " - " + races.get(j).raceCountry + " | " + races.get(j).positions.size() + "\n");
                typer.write("----------------------------------------------------------------------------------------------------------------\n");
                for (int i=0; i<races.get(j).positions.size(); i++) {
                    typer.write(i+1 + " | " + races.get(j).positions.get(i).fullName + " | " + races.get(j).positions.get(i).countryOfBirth + " | " + races.get(j).positions.get(i).carManufacturer + " | " + "\n");
                }
                typer.write("****************************************************************************************************************\n");
            }
           
            typer.close();

        }
        catch (IOException e) {
            System.out.println("An error occurred when completing the data file.");
        }
        System.out.println();
    }

    @Override
    public void loadFileAuto() {
        System.out.println();

        // The following file will contains the infortmation and stats of the drivers who participated in a race/ or have been added to the championship.
        try {
            File SavedData = new File("savedf1data.txt");
            Scanner reader = new Scanner(SavedData);

            if (SavedData.length()!=0){

                while (reader.hasNext()) {
                    Formula1Driver driver = new Formula1Driver();

                    driver.fullName = reader.next();
                    String garbage = reader.next();
                    while (!garbage.equals("|")) {
                        driver.fullName = driver.fullName + " " + garbage;
                        garbage = reader.next();
                    }
        
                    driver.age = reader.nextInt();
                    reader.next();
        
                    driver.countryOfBirth = reader.next();
                    garbage = reader.next();
                    while (!garbage.equals("|")) {
                        driver.countryOfBirth = driver.countryOfBirth + " " + garbage;
                        garbage = reader.next();
                    }
        
                    driver.carManufacturer = reader.next();
                    garbage = reader.next();
                    while (!garbage.equals("|")) {
                        driver.carManufacturer = driver.carManufacturer + " " + garbage;
                        garbage = reader.next();
                    }
        
                    driver.numberOfRaces = reader.nextInt();
                    reader.next();
        
                    driver.pos1st = reader.nextInt();
                    reader.next();
        
                    driver.pos2nd = reader.nextInt();
                    reader.next();
        
                    driver.pos3rd = reader.nextInt();
                    reader.next();
        
                    driver.totalPoints = reader.nextInt();
        
                    drivers.add(driver);
                }
                reader.close();
            }
            else System.out.println("The file is empty.");
        }
        catch (FileNotFoundException e) {
            System.out.println("The file savedf1data.txt was not found.");
        }

        // The following contain information about the races and their results.
        try {
            File RaceSavedData = new File("races.txt");
            Scanner reader = new Scanner(RaceSavedData);

            if (RaceSavedData.length()!=0) {
                // The following while loop will go through the data in the races.txt file.
                while (reader.hasNext()) {
                    Race race = new Race();
                    String garbage;
                    reader.next();
                    // Reading the date of the race. Converting the abbreviation of the month into a number.
                    String month = reader.next();
                    if (month.equals("Jan")) month = "01";
                    if (month.equals("Feb")) month = "02";
                    if (month.equals("Mar")) month = "03";
                    if (month.equals("Apr")) month = "04";
                    if (month.equals("May")) month = "05";
                    if (month.equals("Jun")) month = "06";
                    if (month.equals("Jul")) month = "07";
                    if (month.equals("Aug")) month = "08";
                    if (month.equals("Sep")) month = "09";
                    if (month.equals("Oct")) month = "10";
                    if (month.equals("Nov")) month = "11";
                    if (month.equals("Dec")) month = "12";

                    // Reading the day of the race.
                    String day = reader.next();
                    reader.next();
                    reader.next();

                    // Reading the year of the race.
                    String year = reader.next();

                    // Creating the string date, which will later be converted into into the type date.
                    try {
                        String date = day + "-" + month + "-" + year;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        race.raceDate = dateFormat.parse(date);
                    }
                    catch (ParseException e) {
                        System.out.println("Invalid date!");
                    }
                    reader.next();

                    // Reading the city of the race.
                    race.raceCity = reader.next();
                    garbage = reader.next();
                    while (!garbage.equals("-")) {
                        race.raceCity = race.raceCity + " " + garbage;
                        garbage = reader.next();
                    }

                    // Reading the country of the race.
                    race.raceCountry = reader.next();
                    garbage = reader.next();
                    while (!garbage.equals("|")) {
                        race.raceCountry = race.raceCountry + " " + garbage;
                        garbage = reader.next();
                    }

                    // Number of participants at the race.
                    int contenderNumber = reader.nextInt();
                    reader.next();

                    for (int i=0; i<contenderNumber; i++) {
                        Formula1Driver driver = new Formula1Driver();
                        reader.next();
                        reader.next();
                        
                        // Reading the name of the driver.
                        driver.fullName = reader.next();
                        garbage = reader.next();
                        while (!garbage.equals("|")) {
                            driver.fullName = driver.fullName + " " + garbage;
                            garbage = reader.next();
                        }

                        // Reading the nationality of the driver.
                        driver.countryOfBirth = reader.next();
                        reader.next();

                        // Reading the car manufacturer of the driver.
                        driver.carManufacturer = reader.next();
                        garbage = reader.next();
                        while (!garbage.equals("|")) {
                            driver.carManufacturer = driver.carManufacturer + " " + garbage;
                            garbage = reader.next();
                        }
                        
                        race.positions.add(driver);
                    }
                    reader.next();
                    races.add(race);
                }
                reader.close();
            }
            else System.out.println("The file is empty.");
        }
        catch (FileNotFoundException e) {
            System.out.println("The file races.txt was not found.");
        }

        System.err.println();
    }
    
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Formula1Driver> drivers = new ArrayList<>();
    public static ArrayList<Race> races = new ArrayList<>();

}
