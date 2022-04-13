package oop.westminster.f1coursework;

public class Formula1Driver extends Driver {

    int pos1st=0;
    int pos2nd=0;
    int pos3rd=0;
    int totalPoints=0;
    int numberOfRaces=0;
    int lastRacePosition;

    public int getTotalPoints() {
        return totalPoints;
    }

    public int get1stPos() {
        return pos1st;
    }

    public int getLastRacePosition() {
        return lastRacePosition;
    }
    
}
