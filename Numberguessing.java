package numberguessinggame;

import java.util.*;

public class Numberguessing {
    private static int win = 0;
    private static int round = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Do you want to play ?? Press 1 for play   press 2 for exit");
        int round = sc.nextInt();
        switch (round) {
            case 1:
                Random random = new Random();
                int rnd = random.nextInt(101);
                game(rnd);
                break;
            case 2:
                System.out.println("Exiting....");
                break;
            default:
                System.out.println("Wrong choice choose Between them only!!!");
        }
        sc.close();
    }

    private static void game(int rnd) {
        System.out.println("Rule is that you will get 5 chances to guess a number");
        int chances = 0;
        Scanner sc = new Scanner(System.in);
        int user;

        do {
            do {
                System.out.println("Enter your Guessed Number");
                user = sc.nextInt();
                if (rnd == user) {
                    System.out.println("Equal numbers are generated by user and computer " + rnd + " = " + user);
                    System.out.println("You win \nnext choice for you....");
                win();
                newround();
                } else if (rnd < user) {
                    System.out.println("Number generated by computer is less than user " + rnd + " < " + user);
                    System.out.println("Wrong guess");
                } else {
                    System.out.println("Number generated by computer is more than user " + rnd + " > " + user);
                    System.out.println("Wrong guess");
                }
                chances++;

            } while (user == rnd);

        } while (chances != 5);
        if (chances == 5) {
            System.out.println("-----------------------------------------");
            System.out.println("You Looose Game Finished");
            System.out.println("-----------------------------------------");
            System.out.println("Want to play next round types True otherwise false");
            Boolean ans = sc.nextBoolean();
            if (ans) {
                newround();
            }
        }
        sc.close();
    }

    private static void newround() {

        System.out.println("Computer generated new number.....");
        Random random = new Random();
        int rnd = random.nextInt(101);
        System.out.println("Round:" + ++round);

        System.out.println("Pass to next round :" + round);
        game(rnd);

    }

    static void win() {
        win++;
        System.out.println("Wins :  " + win);
    }

}
