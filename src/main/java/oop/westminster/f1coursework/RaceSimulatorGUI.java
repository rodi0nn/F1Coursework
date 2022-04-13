package oop.westminster.f1coursework;

import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.*;
import java.io.*;





public class RaceSimulatorGUI extends JFrame implements ActionListener{
    // Panel that displays the app's logo and title.
    JPanel headerPanel = new JPanel();
    JLabel headerLabel = new JLabel();
    ImageIcon f1Logo = new ImageIcon("index.png"); 
    // Panel that displays the my name :).
    JPanel footerPanel = new JPanel();
    JLabel footerLabel = new JLabel();
    // Panel with the buttons for the 3 tasks of Part III.
    JPanel buttonPanel = new JPanel(); // Panel with all the buttons.
    JButton simRaceButton = new JButton("RACE"); // This is a button that when pressed will simulate a race which has the driver place in random positions.
    JButton simRacePoleButton = new JButton("RACE WITH POLE POSITIONS"); // This is a button that when pressed will simulate a race which has the drivers place in probable positions (the probability of getting a cetain position is estimated based on the driver's starting spot).
    JButton allRacesButton = new JButton("ALL RACES"); // This is a button that displays all the completed races (including those inputed by the user in the console).
    JButton driversRacesButton = new JButton("DRIVER'S RACES"); // This is a button that displays all the completed races of a certain driver.
    // Panel with the standings (the first 3 points of Part III.)
    JPanel standingsPanel = new JPanel(); // Displays the current standings of the championship. It also includes the different buttons that order the standings.
    JPanel stButtonsPanel = new JPanel();
    BasicArrowButton ptsButton = new BasicArrowButton(SwingConstants.SOUTH);
    Boolean ptsDesc = true;
    BasicArrowButton pos1stButton = new BasicArrowButton(SwingConstants.SOUTH);
    Boolean winDesc = true;
    JScrollPane scrollPane = new JScrollPane();
    // The layout of the standings.
    JLabel posLabel = new JLabel("POS");
    JLabel nameLabel = new JLabel("NAME");
    JLabel natLabel = new JLabel("NAT");
    JLabel ptsLabel = new JLabel("PTS");
    JLabel pos1stLabel = new JLabel("1ST");
    // The fonts used in the program.
    Font f1Bold;
    Font f1Regular;
    Font f1Wide;

    // Displaying the standings. (descending order of points)
    public void displayDescStandings() {
        int y=0;
        for (int i=0; i<Formula1ChampionshipManager.drivers.size(); i++) {
            JPanel driverRow = new JPanel();
            standingsPanel.add(driverRow);
            driverRow.setBounds(0, y, 1000, 25);
            driverRow.setLayout(null);
            JLabel posElem = new JLabel();
            posElem.setText(String.valueOf(i+1));
            posElem.setBounds(0, 0, 50, 25);
            driverRow.add(posElem);
            JLabel nameElem = new JLabel();
            nameElem.setText(Formula1ChampionshipManager.drivers.get(i).fullName);
            nameElem.setBounds(50, 0, 500, 25);
            driverRow.add(nameElem);
            JLabel natElem = new JLabel();
            natElem.setText(Formula1ChampionshipManager.drivers.get(i).countryOfBirth);
            natElem.setBounds(550, 0, 50, 25);
            driverRow.add(natElem);
            JLabel ptsElem = new JLabel();
            ptsElem.setText(String.valueOf(Formula1ChampionshipManager.drivers.get(i).totalPoints));
            ptsElem.setBounds(600, 0, 50, 25);
            driverRow.add(ptsElem);
            JLabel pos1stElem = new JLabel();
            pos1stElem.setText(String.valueOf(Formula1ChampionshipManager.drivers.get(i).pos1st));
            pos1stElem.setBounds(650, 0, 50, 25);
            driverRow.add(pos1stElem);
            y=y+25;
        }
    }
    // Displaying the standings. (ascending order of points)
    public void displayAscStandings() {
        int y=0;
        for (int i=Formula1ChampionshipManager.drivers.size()-1; i>=0; i--) {
            JPanel driverRow = new JPanel();
            standingsPanel.add(driverRow);
            driverRow.setBounds(0, y, 1000, 25);
            driverRow.setLayout(null);
            JLabel posElem = new JLabel();
            posElem.setText(String.valueOf(Formula1ChampionshipManager.drivers.size()-i));
            posElem.setBounds(0, 0, 50, 25);
            driverRow.add(posElem);
            JLabel nameElem = new JLabel();
            nameElem.setText(Formula1ChampionshipManager.drivers.get(i).fullName);
            nameElem.setBounds(50, 0, 500, 25);
            driverRow.add(nameElem);
            JLabel natElem = new JLabel();
            natElem.setText(Formula1ChampionshipManager.drivers.get(i).countryOfBirth);
            natElem.setBounds(550, 0, 50, 25);
            driverRow.add(natElem);
            JLabel ptsElem = new JLabel();
            ptsElem.setText(String.valueOf(Formula1ChampionshipManager.drivers.get(i).totalPoints));
            ptsElem.setBounds(600, 0, 50, 25);
            driverRow.add(ptsElem);
            JLabel pos1stElem = new JLabel();
            pos1stElem.setText(String.valueOf(Formula1ChampionshipManager.drivers.get(i).pos1st));
            pos1stElem.setBounds(650, 0, 50, 25);
            driverRow.add(pos1stElem);
            y=y+25;
        }
    }
    // Displaying the standings. (ascending order of wins)
    public void displayLeastWStandings() {
        ArrayList<Formula1Driver> leastWinsTable = new ArrayList<>();
        leastWinsTable = Formula1ChampionshipManager.drivers;
        leastWinsTable.sort(Comparator.comparing(Formula1Driver::get1stPos));
        int y=0;
        for (int i=0; i<leastWinsTable.size(); i++) {
            JPanel driverRow = new JPanel();
            standingsPanel.add(driverRow);
            driverRow.setBounds(0, y, 1000, 25);
            driverRow.setLayout(null);
            JLabel posElem = new JLabel();
            posElem.setText(String.valueOf(i+1));
            posElem.setBounds(0, 0, 50, 25);
            driverRow.add(posElem);
            JLabel nameElem = new JLabel();
            nameElem.setText(leastWinsTable.get(i).fullName);
            nameElem.setBounds(50, 0, 500, 25);
            driverRow.add(nameElem);
            JLabel natElem = new JLabel();
            natElem.setText(leastWinsTable.get(i).countryOfBirth);
            natElem.setBounds(550, 0, 50, 25);
            driverRow.add(natElem);
            JLabel ptsElem = new JLabel();
            ptsElem.setText(String.valueOf(leastWinsTable.get(i).totalPoints));
            ptsElem.setBounds(600, 0, 50, 25);
            driverRow.add(ptsElem);
            JLabel pos1stElem = new JLabel();
            pos1stElem.setText(String.valueOf(leastWinsTable.get(i).pos1st));
            pos1stElem.setBounds(650, 0, 50, 25);
            driverRow.add(pos1stElem);
            y=y+25;
        }
    } 
    // Displaying the standings. (descending order of wins)
    public void displayMostWStandings() {
        ArrayList<Formula1Driver> mostWinsTable = new ArrayList<>();
        mostWinsTable = Formula1ChampionshipManager.drivers;
        mostWinsTable.sort(Comparator.comparing(Formula1Driver::get1stPos).reversed());
        int y=0;
        for (int i=0; i<mostWinsTable.size(); i++) {
            JPanel driverRow = new JPanel();
            standingsPanel.add(driverRow);
            driverRow.setBounds(0, y, 1000, 25);
            driverRow.setLayout(null);
            JLabel posElem = new JLabel();
            posElem.setText(String.valueOf(i+1));
            posElem.setBounds(0, 0, 50, 25);
            driverRow.add(posElem);
            JLabel nameElem = new JLabel();
            nameElem.setText(mostWinsTable.get(i).fullName);
            nameElem.setBounds(50, 0, 500, 25);
            driverRow.add(nameElem);
            JLabel natElem = new JLabel();
            natElem.setText(mostWinsTable.get(i).countryOfBirth);
            natElem.setBounds(550, 0, 50, 25);
            driverRow.add(natElem);
            JLabel ptsElem = new JLabel();
            ptsElem.setText(String.valueOf(mostWinsTable.get(i).totalPoints));
            ptsElem.setBounds(600, 0, 50, 25);
            driverRow.add(ptsElem);
            JLabel pos1stElem = new JLabel();
            pos1stElem.setText(String.valueOf(mostWinsTable.get(i).pos1st));
            pos1stElem.setBounds(650, 0, 50, 25);
            driverRow.add(pos1stElem);
            y=y+25;
        }
    }
    // Generate a race.
    Random rand = new Random();
    public void simRace() {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i=0; i<Formula1ChampionshipManager.drivers.size(); i++) results.add(0);
        for (int i=0; i<Formula1ChampionshipManager.drivers.size(); i++) {
            int place = rand.nextInt(results.size()) + 1;
            while (results.get(place-1)==1) place = rand.nextInt(results.size()) + 1;
            results.set(place-1, 1);
            Formula1ChampionshipManager.drivers.get(i).lastRacePosition = place;
            if (place==1) {
                Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 25;
                Formula1ChampionshipManager.drivers.get(i).pos1st++;
            }
            if (place==2) {
                Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 18;
                Formula1ChampionshipManager.drivers.get(i).pos2nd++;
            }
            if (place==3) {
                Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 15;
                Formula1ChampionshipManager.drivers.get(i).pos3rd++;
            }
            if (place==4) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 12;
            if (place==5) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 10;
            if (place==6) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 8;
            if (place==7) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 6;
            if (place==8) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 4;
            if (place==9) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 2;
            if (place==10) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 1;
        }
        ArrayList<Formula1Driver> lastRace = new ArrayList<>();
        lastRace = Formula1ChampionshipManager.drivers;
        lastRace.sort(Comparator.comparing(Formula1Driver::getLastRacePosition).reversed());
        int y=0;
        for (int i=0; i<lastRace.size(); i++) {
            JPanel driverRow = new JPanel();
            standingsPanel.add(driverRow);
            driverRow.setBounds(0, y, 1000, 25);
            driverRow.setLayout(null);
            JLabel posElem = new JLabel();
            posElem.setText(String.valueOf(i+1));
            posElem.setBounds(0, 0, 50, 25);
            driverRow.add(posElem);
            JLabel nameElem = new JLabel();
            nameElem.setText(lastRace.get(i).fullName);
            nameElem.setBounds(50, 0, 500, 25);
            driverRow.add(nameElem);
            JLabel natElem = new JLabel();
            natElem.setText(lastRace.get(i).countryOfBirth);
            natElem.setBounds(550, 0, 50, 25);
            driverRow.add(natElem);
            JLabel ptsElem = new JLabel();
            ptsElem.setText(String.valueOf(lastRace.get(i).totalPoints));
            ptsElem.setBounds(600, 0, 50, 25);
            driverRow.add(ptsElem);
            JLabel pos1stElem = new JLabel();
            pos1stElem.setText(String.valueOf(lastRace.get(i).pos1st));
            pos1stElem.setBounds(650, 0, 50, 25);
            driverRow.add(pos1stElem);
            y=y+25;
        }
    }
    // Generates a race with pole positions/
    public void simRaceWithPole() {
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<Integer> pole = new ArrayList<>();
        for (int i=0; i<Formula1ChampionshipManager.drivers.size(); i++) pole.add(0);
        for (int i=0; i<Formula1ChampionshipManager.drivers.size(); i++) results.add(0);

        for (int i=0; i<Formula1ChampionshipManager.drivers.size(); i++) {
            int place = rand.nextInt(results.size()) + 1;
            while (results.get(place-1)==1) place = rand.nextInt(pole.size()) + 1;
            pole.set(place-1, 1);
            
            if (place==1) {
                if (results.get(0)!=1 && rand.nextInt(100)+1<=40) {
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = 1;
                }
                else {
                    int res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                    while (results.get(res-1)==1)  res = rand.nextInt(Formula1ChampionshipManager.drivers.size()) +1;
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = res;
                }
                results.set(Formula1ChampionshipManager.drivers.get(i).lastRacePosition-1, 1);
            }
            if (place==2) {
                if (results.get(0)!=1 && rand.nextInt(100)+1<=30) {
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = 1;
                }
                else {
                    int res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                    while (results.get(res-1)==1)  res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = res;
                }
                results.set(Formula1ChampionshipManager.drivers.get(i).lastRacePosition-1, 1);
            }
            if (place==3 || place==4) {
                if (results.get(0)!=1 && rand.nextInt(100)+1<=10) {
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = 1;
                }
                else {
                    int res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                    while (results.get(res-1)==1)  res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = res;
                }
                results.set(Formula1ChampionshipManager.drivers.get(i).lastRacePosition-1, 1);
            }
            if (place==5 || place==6 || place==7 || place==8 || place==9) {
                if (results.get(0)!=1 && rand.nextInt(100)+1<=2) {
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = 1;
                }
                else {
                    int res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                    while (results.get(res-1)==1)  res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                    Formula1ChampionshipManager.drivers.get(i).lastRacePosition = res;
                }
                results.set(Formula1ChampionshipManager.drivers.get(i).lastRacePosition-1, 1);
            }
            if (place>9) {
                int res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                while (results.get(res-1)==1)  res = rand.nextInt(Formula1ChampionshipManager.drivers.size())+1;
                Formula1ChampionshipManager.drivers.get(i).lastRacePosition = res;        
                results.set(Formula1ChampionshipManager.drivers.get(i).lastRacePosition-1, 1);
            }

            if (place==1) {
                Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 25;
                Formula1ChampionshipManager.drivers.get(i).pos1st++;
            }
            if (place==2) {
                Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 18;
                Formula1ChampionshipManager.drivers.get(i).pos2nd++;
            }
            if (place==3) {
                Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 15;
                Formula1ChampionshipManager.drivers.get(i).pos3rd++;
            }
            if (place==4) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 12;
            if (place==5) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 10;
            if (place==6) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 8;
            if (place==7) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 6;
            if (place==8) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 4;
            if (place==9) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 2;
            if (place==10) Formula1ChampionshipManager.drivers.get(i).totalPoints = Formula1ChampionshipManager.drivers.get(i).totalPoints + 1;
        }
        ArrayList<Formula1Driver> lastRace = new ArrayList<>();
        lastRace = Formula1ChampionshipManager.drivers;
        lastRace.sort(Comparator.comparing(Formula1Driver::getLastRacePosition).reversed());
        int y=0;
        for (int i=0; i<lastRace.size(); i++) {
            JPanel driverRow = new JPanel();
            standingsPanel.add(driverRow);
            driverRow.setBounds(0, y, 1000, 25);
            driverRow.setLayout(null);
            JLabel posElem = new JLabel();
            posElem.setText(String.valueOf(i+1));
            posElem.setBounds(0, 0, 50, 25);
            driverRow.add(posElem);
            JLabel nameElem = new JLabel();
            nameElem.setText(lastRace.get(i).fullName);
            nameElem.setBounds(50, 0, 500, 25);
            driverRow.add(nameElem);
            JLabel natElem = new JLabel();
            natElem.setText(lastRace.get(i).countryOfBirth);
            natElem.setBounds(550, 0, 50, 25);
            driverRow.add(natElem);
            JLabel ptsElem = new JLabel();
            ptsElem.setText(String.valueOf(lastRace.get(i).totalPoints));
            ptsElem.setBounds(600, 0, 50, 25);
            driverRow.add(ptsElem);
            JLabel pos1stElem = new JLabel();
            pos1stElem.setText(String.valueOf(lastRace.get(i).pos1st));
            pos1stElem.setBounds(650, 0, 50, 25);
            driverRow.add(pos1stElem);
            y=y+25;
        }
    }

    // Creating the frame.
    RaceSimulatorGUI() {
        // Implementing three F1-like fonts.
        try {
            f1Bold = Font.createFont(Font.TRUETYPE_FONT, new File("Formula1-Bold.otf")).deriveFont(40f);
            f1Regular = Font.createFont(Font.TRUETYPE_FONT, new File("Formula1-Regular.otf")).deriveFont(12f);
            f1Wide = Font.createFont(Font.TRUETYPE_FONT, new File("Formula1-Wide.otf")).deriveFont(16f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(f1Bold);
            ge.registerFont(f1Regular);
            ge.registerFont(f1Wide);
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }
        // The initialisation of the header.
        headerLabel.setText("F1 - Racing Simulator");
        headerLabel.setFont(f1Bold);
        headerLabel.setIcon(f1Logo);
        headerPanel.setBackground(new Color(244, 244, 244));
        headerPanel.setBounds(0, 0, 1250, 100);
        headerPanel.add(headerLabel);
        this.add(headerPanel);
        // The initialisation of the footer.
        footerLabel.setText("Developed and designed by Catalin-Iulian Toderascu-Buia.");
        footerLabel.setFont(f1Wide);
        footerLabel.setForeground(Color.white);
        footerPanel.setBackground(Color.darkGray);
        footerPanel.setBounds(0, 675, 1250, 75);
        footerPanel.add(footerLabel);
        this.add(footerPanel);
        // The initialisation of the button panel.
        buttonPanel.setBounds(1000, 100, 250, 575);
        buttonPanel.setBackground(Color.red);
        simRaceButton.addActionListener(this);
        buttonPanel.add(simRaceButton);
        simRacePoleButton.addActionListener(this);
        buttonPanel.add(simRacePoleButton);
        allRacesButton.addActionListener(this);
        buttonPanel.add(allRacesButton);
        driversRacesButton.addActionListener(this);
        buttonPanel.add(driversRacesButton);
        this.add(buttonPanel);
        // The initialisation of the standings panel (layout + buttons).
        stButtonsPanel.setBounds(0, 100, 1000, 25);
        stButtonsPanel.setBackground(Color.red);
        stButtonsPanel.setLayout(null);
        posLabel.setBounds(0, 0, 50, 25);
        stButtonsPanel.add(posLabel);
        nameLabel.setBounds(50, 0, 500, 25);
        stButtonsPanel.add(nameLabel);
        natLabel.setBounds(550, 0, 50, 25);
        stButtonsPanel.add(natLabel);
        ptsLabel.setBounds(600, 0, 30, 25);
        stButtonsPanel.add(ptsLabel);
        ptsButton.setBounds(630, 0, 20, 25);
        ptsButton.addActionListener(this);
        stButtonsPanel.add(ptsButton);
        pos1stButton.addActionListener(this);
        pos1stLabel.setBounds(650, 0, 30, 25);
        stButtonsPanel.add(pos1stLabel);
        pos1stButton.setBounds(680, 0, 20,25);
        stButtonsPanel.add(pos1stButton);
        this.add(stButtonsPanel);
        // The initialisation of the standings panel.
        standingsPanel.setBounds(0, 125, 1000, 550);
        standingsPanel.setLayout(null);
        standingsPanel.setBackground(Color.pink);
        this.add(standingsPanel);
        // Displaying the standings. (descending order of points - initially)
        displayDescStandings();
        
        
        
        
        
        
        // The initialisation of the frame.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1250, 750);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.toFront();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ptsButton) {
            if (Boolean.TRUE.equals(ptsDesc)){
                displayAscStandings();
                ptsDesc=false;
                ptsButton.setDirection(SwingConstants.NORTH);
            }
            else {
                displayDescStandings();
                ptsDesc=true;
                ptsButton.setDirection(SwingConstants.SOUTH);
            }
        }
        if (e.getSource()==pos1stButton) {
            if (Boolean.TRUE.equals(winDesc)) {
                displayLeastWStandings();
                winDesc=false;
                pos1stButton.setDirection(SwingConstants.NORTH);
            }
            else {
                displayMostWStandings();
                winDesc=true;
                pos1stButton.setDirection(SwingConstants.SOUTH);
            }
        }
        if (e.getSource()==simRaceButton) {
            simRace();
            displayDescStandings();
            ptsDesc=true;
            ptsButton.setDirection(SwingConstants.SOUTH);
        }
        if (e.getSource()==simRacePoleButton) {
            simRaceWithPole();
            displayDescStandings();
            ptsDesc=true;
            ptsButton.setDirection(SwingConstants.SOUTH);
        }
    }
}


