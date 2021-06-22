/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 *
 * @author Nghi Vo June 19th
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for
 * reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards
{

   //The group of cards, stored in an ArrayList
   private final ArrayList<Card> cards;


   public GroupOfCards ()
   {

      cards = new ArrayList<Card>();
      // populate deck with cards
      for (Suit suit : Suit.values()) {
         for (Face face : Face.values()) {
            cards.add(new Card(face, suit)
            {
            });
         }
      }
   }

   public void shuffle ()
   {
      Collections.shuffle(cards);
   }

   public Card draw ()
   {
      return cards.remove(0);
   }


   @Override
   public String toString ()
   {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < cards.size(); i++) {
         sb.append(i + 1);
         sb.append('/');
         sb.append(cards.size());
         sb.append(' ');
         sb.append(cards.get(i));
         sb.append('\n');
      }
      return sb.toString();
   }

}//end class
