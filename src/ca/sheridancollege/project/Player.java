/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 * <p>
 */
import java.util.ArrayList;

/**
 *
 * @author Nghi Vo June 19th
 */
public abstract class Player
{

   private String name; //the unique name for this player
   private ArrayList<Card> hand;

   /**
    * A constructor that allows you to set the player's unique ID
    *
    * @param name the unique ID to assign to this player.
    */
   public Player (String name)
   {
      this.name = name;
      this.hand = new ArrayList<Card>();
   }

   /**
    * @return the player name
    */
   public String getName ()
   {
      return name;
   }

   /**
    * Ensure that the playerID is unique
    *
    * @param name the player name to set
    */
   public void setName (String name)
   {
      this.name = name;
   }

   /**
    * The method to be overridden when you subclass the Player class with your
    * specific type of Player and filled in
    * with logic to play your game.
    */
   public void addCard (Card card)
   {
      hand.add(card);
   }

   public int getHandSum ()
   {
      int handSum = 0;
      for (Card card : hand) {
         handSum += card.getFace().getValue();
      }
      return handSum;
   }

   public String getHandAsString (boolean hideCard)
   {
      StringBuilder sb = new StringBuilder();
      sb.append(name + "\'s current hand:");
      sb.append('\n');
      for (int i = 0; i < hand.size(); i++) {
         if (i == 0 && hideCard) {
            sb.append("[Hidden card]");
            sb.append('\n');
         }
         else {
            sb.append(hand.get(i));
            sb.append('\n');
         }
      }
      return sb.toString();
   }


   public abstract void play ();

}
