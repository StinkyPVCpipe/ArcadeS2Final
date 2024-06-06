public class Arcade {
    private ArcadeGame[][] arcadeGrid;
    private double totalMoney=0;
    public Arcade(int size)
    {
        arcadeGrid = new ArcadeGame[size][size];
    }

    public double getMoney()
    {
        return totalMoney;
    }
    public void addGame(ArcadeGame newGame)
    {
        for(int row = 0; row < arcadeGrid.length; row++) {
            for (int col = 0; col < arcadeGrid[row].length; col++) {
                if (arcadeGrid[row][col] == null) {
                    arcadeGrid[row][col] = newGame;
                    return;
                }
            }
        }
    }

    public String RunDayArcade()
    {
        String output = "";
        for(int row = 0; row<arcadeGrid.length; row++)
        {
            for(int col = 0; col<arcadeGrid[row].length; col++)
            {
                if(arcadeGrid[row][col] != null) {
                    output += "\n" + arcadeGrid[row][col].getName() + "'s profits of the day were " + arcadeGrid[row][col].getDayProfits((int) Math.random() * 3);
                }
            }
        }
        return output;
    }
    public String printArcade()
    {
        String output = "";
        for(int row = 0; row<arcadeGrid.length; row++)
        {
            for(int col = 0; col<arcadeGrid[row].length; col++)
            {
                if(arcadeGrid[row][col] != null) {
                    output += ("[" + arcadeGrid[row][col].getName().substring(0, 4) + "] ");
                }
                else{
                    output += ("[____] ");
                }
            }
            output+= ("\n");
        }
        return output;
    }
}

