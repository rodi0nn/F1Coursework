package oop.westminster.f1coursework;

public interface ChampionshipManager {
    
        public void addDriver(); // Method which allows the user to add a new driver to the championship.
        public void deleteDriver(); // Method which allows the user to delete a specific driver from the championship (and his team).
        public void changeTeam(); // Method which allows the user to swap two drivers' teams between each other.
        public void displayStats(); // Method which allows the user to see the stats of a specific driver.
        public void displayStandings(); // Method which allows the user to see the current standings of the championship.
        public void addRaceResults(); // Method which allows the user to manually add the results of a race.
        public void saveFile(); // Method which allows the user to save all the data in a file.
        public void loadFileAuto(); // Method which automatically loads data from the save file (if it exists).
        
}
