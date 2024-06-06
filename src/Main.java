import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        CoinOp Polybius = new CoinOp("Polybius", 14, 2, 2, true);
        ArcadeGame PacMan = new CoinOp("PacMan", 8, 1, 1, false);
        CoinOp SpaceInvaders = new CoinOp("Space Invaders", 10, 3,1, false);
        CoinOp DigDug = new CoinOp("Dig Dug", 8, 4, 2,true);
        CoinOp Aub = new CoinOp("Aub", 10, 2, 2, false);
        ClawGame RAWR = new ClawGame("RAWR", 10, 3, 50, true);
        TwoPlayGame Boyf = new TwoPlayGame("Boyf", 8, 1, 2, false);

        ArrayList<ArcadeGame> games = new ArrayList<ArcadeGame>();
        games.add(Polybius);
        games.add(Aub);
        games.add(RAWR);
        games.add(Boyf);
        games.add(PacMan);
        games.add(SpaceInvaders);
        games.add(DigDug);

        ArcadeStore staure = new ArcadeStore(1000.0);

        Scanner Scan = new Scanner(System.in);
        int size;
        String input;
        System.out.println("Hello! You are the owner of an arcade! Your goal is to get the highest amount of money over " +
                "\nthe course of a week!" +
                "\nTo start off, please enter how big you want your arcade to be(max is 4x4):");
        size = Scan.nextInt();
        while(size > 4)
        {
            System.out.println("Please enter a size for your arcade that is 4 or less!");
            size = Scan.nextInt();
        }

        Arcade myArcade = new Arcade(size);
        System.out.println("Here is your arcade: \n" + myArcade.printArcade());
        System.out.println("As you can see, its rather empty !! :(!");
        System.out.println("Lets go to the store and see what we can buy!");
        input = Scan.nextLine();
        while (!input.equals("S"))
        {
            System.out.println("Press S to go to the store.");
            input = Scan.nextLine();
        }
       myArcade.addGame(staure.buyStuff(myArcade, games));
        System.out.println("Welcome back! Hopefully it wasn't too harsh on your budget..." +
                "\nLets see what your arcade looks like now!");
        System.out.println("Press A to view your arcade");
        input = Scan.nextLine();
        while(!input.equals("A"))
        {
            System.out.println("Press A to view your arcade.");
            input = Scan.nextLine();
        }
        System.out.println(myArcade.printArcade());
        System.out.println("Isn't she beautiful? Why don't you go ahead and press 'R' to run through a day to make some more money?");
        input = Scan.nextLine();
        while(!input.equals("R"))
        {
            System.out.println("Press 'R' to run through a day~!");
            input = Scan.nextLine();
        }
    System.out.println(myArcade.RunDayArcade());


//        //ArcadeGame Polybius = new ArcadeGame("Polybius", 14, 2, 2, true);
//        //ArcadeGame PacMan = new ArcadeGame("PacMan", 11, 1, 1, false);
//        System.out.println(Polybius.toString());
//        myArcade.addGame(Polybius);
//        myArcade.addGame(PacMan);
//
//        System.out.println(myArcade.printArcade());


    }
}