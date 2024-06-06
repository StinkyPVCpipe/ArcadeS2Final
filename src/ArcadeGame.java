import java.util.*;
public class ArcadeGame
{
    private String name;
    private int addictiveGameplay, difficultyLevel, profit, profitAvg;
    //addict
    private double cost = 0;
    private boolean breaksDownOften;

    public ArcadeGame()
    {
        name = "";
        addictiveGameplay = 0;
        difficultyLevel = 0;
        cost = 0;
        breaksDownOften = false;
    }

    public ArcadeGame(String name, int addictiveGameplay, int difficultyLevel, boolean breaksDownOften)
    {
        this.name = name;
        this.addictiveGameplay = addictiveGameplay;
        this.difficultyLevel = difficultyLevel;
        this.breaksDownOften = breaksDownOften;
        this.cost = calculateCost();
        profit = 0;
        profitAvg = 0;

    }

    private double calculateCost() {
        int breakDown = 1;
        if (breaksDownOften)
        {
            breakDown = 20;
        }
        cost = (double)(addictiveGameplay * 1000)/(breakDown);
        cost = cost - 0.01;
        return cost;
    }

    //getter methods
   public String getName()
    {
        return name;
    }
    public int getAddictiveGameplay()
    {
        return addictiveGameplay;
    }
    public int getDifficultyLevel()
    {
        return difficultyLevel;
    }
    public double getCost()
    {
        return cost;
    }
    public boolean getBreaksDownOften() {
        return breaksDownOften;
    }


    //brain methods lolsies
    public int getDayProfits(int busyLevel)
    {
        if (busyLevel == 3)
        {
            profit += (Math.random()*3000);
        }
        if(busyLevel == 2)
        {
            profit += (Math.random()*2000);
        }
        else
        {
            profit += (Math.random()*1000);
        }
        return profit;
    }

    public int getProfitAverage(int totalDays)
    {
        return profit/totalDays;
    }

    //to string :3
    public String toString()
    {
        String output = "Game name: " + name +"" +
                "\nHow addictive the game is (0-14): " + addictiveGameplay +"" +
                "\nHow difficult the game is (0-5): " + difficultyLevel +"" +
                "\nThis machine breaks down often: " + breaksDownOften+"" +
                "\nCost of machine: " + cost +"" +
                "\nTotal money made: " + profit +"" +
                "\nAverage money made per day: " + profitAvg;
        return output;
    }
}
