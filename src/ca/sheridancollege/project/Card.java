/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 *
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves
 * as a modifier.
 *
 * @author Nghi Vo June 18th
 */
public abstract class Card
{
   //default modifier for child classes

   /**
    * Students should implement this method for their specific children classes
    *
    * @return a String representation of a card. Could be an UNO card, a regular
    * playing card etc.
    */
   private final Face face;

   private final Suit suit;

   public Card (Face face, Suit suit)
   {
      this.face = face;
      this.suit = suit;
   }

   public Face getFace ()
   {
      return face;
   }

   public Suit getSuit ()
   {
      return suit;
   }

   @Override
   public String toString ()
   {
      return face + " of " + suit;
   }

}
