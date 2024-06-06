import java.util.Scanner;
import java.util.ArrayList;
public class ArcadeStore
{
    private double money;
    /*
    //finna store all the arcade games period ah period uh
    ArcadeGame Polybius = new ArcadeGame("Polybius", 14, 2, 2, true);
    ArcadeGame PacMan = new ArcadeGame("PacMan", 8, 1, 1, false);
    ArcadeGame SpaceInvaders = new ArcadeGame("Space Invaders", 10, 3,1, false);
    ArcadeGame DigDug = new ArcadeGame("Dig Dug", 8, 4, 2,true);
    // ArcadeGame

//    private ArcadeGame[] games = new ArcadeGame[16];
//    games[0] = Polybius;
//    games[1] = PacMan;
//    games[2] = SpaceInvaders;
//    games[3] = DigDug;

    ArrayList<ArcadeGame> games = new ArrayList<ArcadeGame>();
    games.add(Polybius);
    games.add(PacMan);
    games.add(SpaceInvaders);
    games.add(DigDug);
*/
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
