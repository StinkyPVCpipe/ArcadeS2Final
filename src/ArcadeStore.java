import java.util.Scanner;
import java.util.ArrayList;
public class ArcadeStore
{
    private double money;

    Scanner Scan = new Scanner(System.in);
    public ArcadeStore(double money)
    {
        this.money = money;
    }

    public String addMoney(int newCash)
    {
        money += newCash;
        return "You now have " + money + " dollars!";
    }

    public ArcadeGame buyStuff(Arcade myArcade, ArrayList<ArcadeGame> games)
    {
        int gameSelect, input;
       gameSelect = Balls(myArcade, games);
       input = gameSelect;
        while (input != 0) {
            System.out.println(games.get(gameSelect-1).toString());
            System.out.println("Press 5 if you'd like to purchase this game, and any other number if you'd like to see the other options again.");
            input = Scan.nextInt();
            if (input == 5 && money <= games.get(gameSelect).getCost()) {
                System.out.println("Excellent choice! The game will be added to your arcade shortly :D");
                money -= games.get(gameSelect).getCost();
                return games.get(gameSelect-1);
            } else if (input == 5 && money > games.get(gameSelect).getCost()) {
                System.out.println("I'm sorry, you don't currently have enough to purchase that one :(! " +
                        "\n you will now be returned to look at the other options ^___^");
                        input = Balls(myArcade, games);
            } else {
                System.out.println("No problem! Taking you back to look at the other options now!");
                input = Balls(myArcade, games);
            }
        }
        return null;
    }

    public int Balls (Arcade myArcade, ArrayList<ArcadeGame> games)
    {
        System.out.println("Welcome to the staure");
        System.out.println("You currently have " + money + " dollars");
        System.out.println("What would you like to buy? Enter the number of the game you want to buy/view more info. \nPress 0 to exit!");
        for (int i = 0; i<4; i++)
        {
            System.out.println((i+1) + " " + games.get(i).getName());
        }
        return Scan.nextInt();

    }

}
