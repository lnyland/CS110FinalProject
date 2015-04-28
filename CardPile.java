/***********************************************************************************
CardPile class. 
Simulates a subset from 52 card deck.
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/
import java.util.Random;         //for shuffling the pile of cards
import java.util.LinkedList;     //for implementing a linked list
import javax.swing.JOptionPane;  //for dialog boxes

public class CardPile 
{
   //fields ========================================================================
   private LinkedList<Card> pile;      // a subset from the deck of cards
   
   // constructor ==================================================================
      
   /**
   Default constructor - initializes the pile to contain no cards.
   */
   public CardPile()
   {  
      pile = new LinkedList<Card>();
   }
   
   // methods ======================================================================
   
   /**
   Shuffles the pile of cards. Implements the Fisher-Yates shuffle.
   */
   public void shuffle()
   {
      // Implementing Fisher–Yates shuffle
      {
         Random rnd = new Random();
         for (int i=pile.size()-1; i>0; i--)
         {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card c = new Card(pile.get(index).getRank().ordinal(),pile.get(index).getSuit().ordinal());
            pile.set(index,pile.get(i));
            pile.set(i,c);
         }
      }
   }
   
   /**
   Remove top card from pile.
   @return A Card object copy of Card that was first in the pile
   */
   public Card removeTop()
   {
      Card card = new Card();
      
      try
      {  
         card = pile.remove();
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null, "Empty Deck - Cannot remove top card");
      }
      
      return card;
   }
   
   /**
   Return a card to bottom of pile.
   @param card A Card object to be placed at the current last index of the pile
   */
   public void returnToBottom(Card card)
   {
      pile.addLast(card);
   }
   
   /**
   Return a card to top of pile.
   @param card A Card object to be placed at the current first index of the pile
   */
   public void returnToTop(Card card)
   {
      pile.addFirst(card);
   }
   
   /**
   Return a copy of card at top of pile without altering the pile.
   @param card A Card object copy of Card that was first in the pile
   */
   public Card peekTopCard()
   {
      Card newCard = new Card(pile.peek());
      return newCard;
   }
   
   /**
   Get number of cards in pile.
   @return An integer for the number of cards currently in pile.
   */
   public int getSize()
   {
      return pile.size();
   }   
}