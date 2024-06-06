public class TwoPlayGame extends ArcadeGame
{
    private int quartersNeeded;
    private double cost;
    private int profit;
    private int profitAvg;

    public TwoPlayGame(String name, int addictiveGameplay, int difficultyLevel, int quartersNeeded, boolean breaksDownOften)
    {
        super(name, addictiveGameplay, difficultyLevel, breaksDownOften);
        this.quartersNeeded = quartersNeeded;
        cost = 5000.0;
        profit =0;
        profitAvg = 0;

    }

    public int getDayProfits(int busyLevel)
    {
        if (busyLevel == 3)
        {
            profit += ((Math.random()*3000) * quartersNeeded)/4 ;
        }
        if(busyLevel == 2)
        {
            profit += ((Math.random()*2000) * quartersNeeded)/4;
        }
        else
        {
            profit += ((Math.random()*1000) * quartersNeeded)/4;
        }
        return profit*2;
    }

}
