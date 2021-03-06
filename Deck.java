/***********************************************************************************
Deck class. 
Simulates a standard 52 card deck.
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/
import java.util.Random;         //for shuffling the deck of cards
import java.util.LinkedList;     //for implementing a linked list
import javax.swing.JOptionPane;  //for dialog boxes

public class Deck
{
   //fields ========================================================================
   private LinkedList<Card> deck;      // the deck of cards
   
   // constructor ==================================================================
      
   /**
   Constructor - initialize the deck as unshuffled.
   */
   public Deck()
   {  
      int ct = 0;                      // card counter
      deck = new LinkedList<Card>();   // create an empty deck of cards array
      
      // fill the deck of cards array with the standard cards
      for (int i=Card.Suit.CLUBS.ordinal(); i<=Card.Suit.SPADES.ordinal(); i++)
      {
         for (int j=Card.Rank.TWO.ordinal(); j<=Card.Rank.ACE.ordinal(); j++)
         {  
            Card card = new Card(j, i);   // create a card
            deck.add(card);               // add it to the deck
            ct++;                         // increment the card counter
         }
      }
   }
   
   // methods ======================================================================
  
   /**
   Shuffles the deck of cards. Implements Fisher-Yates shuffle.
   */
   public void shuffle()
   {
      // Implementing Fisher�Yates shuffle
      {
         Random rnd = new Random();
         for (int i=deck.size()-1; i>0; i--)
         {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card c = new Card(deck.get(index).getRank().ordinal(),deck.get(index).getSuit().ordinal());
            deck.set(index,deck.get(i));
            deck.set(i,c);
         }
      }
   }
   
   /**
   Remove top card from deck.
   @return A Card object that was first in the deck
   */
   public Card removeTop()
   {
      Card card = new Card();
      
      try
      {  
         card = deck.remove();
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null, "Empty Deck - Cannot remove top card");
      }
      
      return card;
   }

   /**
   Return a card to bottom of deck.
   @param card A Card object to be placed at the current last index of the deck
   */
   public void returnToBottom(Card card)
   {
      deck.add(card);
   }
   
   /**
   Return a copy of card at top of deck without altering the deck.
   @return A Card object - copy of first card in deck.
   */
   public Card peekTopCard()
   {
      Card newCard = new Card(deck.peek());
      return newCard;
   }

   /**
   Get number of cards in deck.
   @return An integer for the number of cards currently in deck.
   */
   public int getSize()
   {
      return deck.size();
   }
}
