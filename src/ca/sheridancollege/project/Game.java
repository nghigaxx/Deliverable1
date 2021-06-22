/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 *
 * @author Nghi Vo June 20th
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods
 * given.
 *
 * @author Nghi Vo June 18th 2021
 */
public class Game
{


   public static void main (String[] args)
   {

      Scanner scanner = new Scanner(System.in);
      String name;
      String input;

      // ask for nickname
      System.out.println("What nickname would you like to have?");
      input = scanner.nextLine();
      name = input;

      // mainloop
      do {

         // new game message
         System.out.println();
         System.out.println("A new game has begun.");
         System.out.println();

         // init
         Player player = new Player(name)
         {
            @Override
            public void play ()
            {
               throw new UnsupportedOperationException("Not supported yet.");
            }
         };
         Player dealer = new Player("Dealer")
         {
            @Override
            public void play ()
            {
               throw new UnsupportedOperationException("Not supported yet.");
            }
         };
         GroupOfCards deck = new GroupOfCards();
         deck.shuffle();
         boolean gameOver = false;

         // give cards to the player
         player.addCard(deck.draw());
         player.addCard(deck.draw());
         System.out.println(player.getHandAsString(false));

         // give cards to the dealer
         dealer.addCard(deck.draw());
         dealer.addCard(deck.draw());
         System.out.println(dealer.getHandAsString(true));

         // player's turn
         do {
            System.out.println("Would you like to bust or stay? 'Bust/Stay'");
            do {
               input = scanner.nextLine();
            }
            while (!input.equalsIgnoreCase("Bust") && !input.equalsIgnoreCase("Stay"));

            // BUST
            if (input.equalsIgnoreCase("Bust")) {
               player.addCard(deck.draw());
               System.out.println(player.getName() + " drew a card.");
               System.out.println();
               System.out.println(player.getHandAsString(false));
               if (player.getHandSum() > 21) {
                  System.out.println(
                      "You busted and got a total of " + player.getHandSum() + ". Dealer wins this time!");
                  gameOver = true;
               }
            }
            // STAY
            if (input.equalsIgnoreCase("stay")) {
               System.out.println("You have chosen to stay. Your hand: " + player.getHandSum());
            }

         }
         while (input.equalsIgnoreCase("Bust") && !gameOver);

         // dealer's turn
         if (!gameOver) {
            System.out.println();
            System.out.println("- Dealers turn -");
            System.out.println();
            System.out.println(dealer.getHandAsString(false));
         }

         while (!gameOver) {

            if (dealer.getHandSum() <= 15) {
               // DRAW CARD
               dealer.addCard(deck.draw());
               System.out.println(dealer.getName() + " drew another card");
               System.out.println();
               System.out.println(dealer.getHandAsString(false));
               if (dealer.getHandSum() == 15) {
                  System.out.println("Blackjack! Dealer won.");
                  gameOver = true;
               }
               if (dealer.getHandSum() > 21) {
                  System.out.println("Dealer busted and got a total of " + dealer.getHandSum() + ". "
                      + player.getName() + " wins this time!");
                  gameOver = true;
               }

            }
            else {
               // STAY
               System.out.println("Dealer has chosen to stay!");
               System.out.println();
               int totalDealerSum = dealer.getHandSum();
               int totalPlayerSum = player.getHandSum();

               if (totalDealerSum > totalPlayerSum) {
                  System.out.println("Both players has decided to stay. The winner is " + dealer.getName()
                      + " with a total of " + totalDealerSum + ".");
               }
               else {
                  System.out.println("Both players has decided to stay. The winner is " + player.getName()
                      + " with a total of " + totalPlayerSum + ".");
               }
               gameOver = true;
            }

         }

         // ask for new game
         System.out.println();
         System.out.println("Would you like to start a new game?  'Yes/No' :");
         do {
            input = scanner.nextLine();
         }
         while (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));

      }
      while (input.equalsIgnoreCase("Yes"));

      // tidy up
      scanner.close();
   }

}
