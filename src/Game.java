/**
 * Author mostly Trevor
 * Author a little google
 * Author Jason Carr
 * Date 02/24/2023
 */

import java.util.Scanner;


public class Game {
    private Player p1;
    private Player p2;
    private Dice die;
    public Game(Player p1, Player p2, Dice die) {
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }
    public void play() {
        //Method play needs to declare a local Player
        // variable named current that gets assigned
        // this.p1 and calls methods takeTurn, nextPlayer,
        // and takeTurn again before printing method announceWinner
        Player current = p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        System.out.println(announceWinner());
    }
    public Player nextPlayer(Player current) {
        //Method nextPlayer needs to use conditions to
        // check the current Player parameter,
        // and switch to the other Player (i.e.
        // Either instance variable this.p1 or this.p2).
        if (current == this.p1) {
            return this.p2;
        } else {
            return this.p1;
        }
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        //Method announceWinner needs to display each
        // Player's name and score, then using conditions
        // needs to determine which Player's score is highest,
        // and finally return the winning Player's name.
        System.out.printf("Player1: %s %n Score: %d%n Player2: %s %n Score: %d%n", p1.getName() , p1.getScore(), p2.getName() , p2.getScore());
        if (this.p1.getScore() > this.p2.getScore()) {
            System.out.println(p1.getName() + " Wins!");
            //return String.format("%s wins!", p1.getName());
        } else if (this.p2.getScore() > this.p1.getScore()) {
                System.out.println(p2.getName() + " Wins!");
            //return String.format("%s wins!", p2.getName());
            } else {
                //System.out.println("Its a tie!");
            return String.format("%s and %s tied!", p1.getName(), p2.getName());
            }
        return String.format("%n");
        }


    public static void main(String[] args) {//Last, Implement the Java main method to:
        //Create a Scanner object.
        //Request and store in an int variable the number of sides you Dice should have.
        //Create a new Game object and pass its constructor two new Player objects, and a new Dice object.
        //        Finally, use the Game object to call the play method and play the game.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter p1's name: ");
        String playerName = scanner.nextLine();
        Player p1 = new Player(playerName);
        System.out.print("Enter p2's name: ");
        playerName = scanner.nextLine();
        Player p2 = new Player(playerName);

        System.out.print("What die do you want to use, 6 sides or 20 sides? ");
        int sides = scanner.nextInt(); //the number from scanner

        Game run = new Game(p1, p2, new Dice(sides));
        run.play();
    }
}
