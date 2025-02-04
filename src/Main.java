import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        System.out.println(tutorial());
    }//gurl what

    public static String tutorial()
    {
        CoinOp Polybius = new CoinOp("Polybius", 14, 2, 2, true);
        ArcadeGame PacMan = new CoinOp("PacMan", 8, 1, 1, false);
        CoinOp SpaceInvaders = new CoinOp("Space Invaders", 10, 3, 1, false);
        CoinOp DigDug = new CoinOp("Dig Dug", 8, 4, 2, true);
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
        while (size > 4) {
            System.out.println("Please enter a size for your arcade that is 4 or less!");
            size = Scan.nextInt();
        }

        Arcade myArcade = new Arcade(size);
        System.out.println("Here is your arcade: \n" + myArcade.printArcade());
        System.out.println("As you can see, its rather empty !! :(!");
        System.out.println("Lets go to the store and see what we can buy!");
        input = Scan.nextLine();
        while (!input.equals("S")) {
            System.out.println("Press S to go to the store.");
            input = Scan.nextLine();
        }
        myArcade.addGame(staure.buyStuff(myArcade, games));
        System.out.println("Welcome back! Hopefully it wasn't too harsh on your budget..." +
                "\nLets see what your arcade looks like now!");
        System.out.println("Press A to view your arcade");
        input = Scan.nextLine();
        while (!input.equals("A")) {
            System.out.println("Press A to view your arcade.");
            input = Scan.nextLine();
        }
        System.out.println(myArcade.printArcade());
        System.out.println("Isn't she beautiful? Why don't you go ahead and press 'R' to run through a day to make some more money?");
        input = Scan.nextLine();
        while (!input.equals("R")) {
            System.out.println("Press 'R' to run through a day~!");
            input = Scan.nextLine();
        }
        System.out.println(myArcade.RunDayArcade());
        return(playGame(Scan, myArcade, staure, games));
    }

    public static String playGame(Scanner scan, Arcade myArcade, ArcadeStore staure, ArrayList<ArcadeGame> games) {
        String input = "0";
        boolean playing = true;
        int days = 1;
        double money = 0;
        System.out.println("You are now free to go through the week! try to make as much money as possible!");
        while (playing) {
            if (input.equals("0")) {
                System.out.println("Press S to go to the Store and buy a new game \npress A to view your arcade \npress R to run through a day!");
            }
            input = scan.nextLine();
            if (input.equals("S")) {
                myArcade.addGame(staure.buyStuff(myArcade, games));
                input = "0";
            }
            if (input.equals("A")) {
                System.out.println(myArcade.printArcade());
                input = "0";
            }
            if (input.equals("R")) {
                System.out.println(myArcade.RunDayArcade());
                days++;
                money = myArcade.getMoney();
                staure.addMoney((int)money);
                input = "0";
            }
            if (days == 7) {
                playing = false;
            }
        }
        return "Your seven days is up! Here is the final version of your arcade:" +
                "\n" + myArcade.printArcade() + "\nAnd your final amount of money made is:" +
                "" + myArcade.getMoney() ;
    }

}


//        //ArcadeGame Polybius = new ArcadeGame("Polybius", 14, 2, 2, true);
//        //ArcadeGame PacMan = new ArcadeGame("PacMan", 11, 1, 1, false);
//        System.out.println(Polybius.toString());
//        myArcade.addGame(Polybius);
//        myArcade.addGame(PacMan);
//
//        System.out.println(myArcade.printArcade());