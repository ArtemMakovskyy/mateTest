package main.java_basic;

public class FighterService {
    public boolean willFighterWin(Fighter firstFighter, Fighter secondFighter, int hits) {
        int damage = hits * firstFighter.getDamagePerHit();
        return damage >= secondFighter.getHealth() ? true : false;
    }
}