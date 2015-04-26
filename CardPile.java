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
   Shuffles the pile of cards.
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
   @return A Card object that was first in the pile
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
   Return a copy of card at top of pile.
   @param card A Card object to be placed at the current first index of the pile
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


   // // tester
//    public static void main(String[] args)
//    {
//       //number of cards in a deck of std playing cards
//       final int NUM_CARDS = 52;
//       
//       // a deck of cards to be used to play war
//       Deck d1 = new Deck();
//       d1.shuffle();
//       
//       // the down card piles for the 2 players
//       CardPile p1 = new CardPile();
//       CardPile p2 = new CardPile();
//       
//       //deal the cards to the players
//       for (int i=0; i<(NUM_CARDS/2); i++)
//       {
//          p1.returnToBottom(d1.removeTop());
//          p2.returnToBottom(d1.removeTop());
//       }
//       
//       //display the card piles
//       System.out.println("Pile 1");
//       for (int i=0; i<p1.getSize(); i++)
//       {
//          System.out.println(p1.pile.get(i).toString());
//       }
//       System.out.println("Pile 1 size: " + p1.getSize());
//       System.out.println("Pile 2");
//       for (int i=0; i<p2.getSize(); i++)
//       {
//          System.out.println(p2.pile.get(i).toString());
//       }
//       System.out.println("Pile 2 size: " + p2.getSize());
//       
//       //display deck size
//       System.out.println("Deck size: " + d1.getSize());
//       
//       // the up card piles for the 2 players
//       CardPile p3 = new CardPile();
//       CardPile p4 = new CardPile();
//       
//       //flip cards from 2 piles and compare
//       System.out.println("Pile 1: \t\tPile 2: ");
//       do
//       {
//          //put top down card as up card in a new pile
//          p3.returnToBottom(p1.removeTop());
//          p4.returnToBottom(p2.removeTop());
//          
//          if(p3.pile.peek().equals(p4.pile.peek()))
//          {
//             System.out.println(p3.pile.peek() + "\t=\t" + p4.pile.peek());
//             p3.returnToBottom(p1.removeTop());
//             p4.returnToBottom(p2.removeTop()); 
//             
//             while(p3.pile.peekLast().equals(p4.pile.peekLast()));
//             {
//                p3.returnToBottom(p1.removeTop());
//                p4.returnToBottom(p2.removeTop()); 
//                System.out.println(p3.pile.peek() + "\t=\t" + p4.pile.peek()); 
//             }
//             
//             if(p3.pile.peekLast().greaterThan(p4.pile.peekLast()))
//             {
//                System.out.println(p3.pile.peekLast() + "\t>\t" + p4.pile.peekLast());
//                int sz = p3.getSize();
//                for (int i=0; i<sz; i++)
//                {
//                   p3.returnToBottom(p4.removeTop());
//                }
//                p3.shuffle();
//                for (int i=0; i<sz; i++)
//                {
//                   p1.returnToBottom(p3.removeTop());
//                }
//             }
//             else 
//             {
//                System.out.println(p4.pile.peekLast() + "\t<\t" + p3.pile.peekLast());
//                int sz = p4.getSize();
//                for (int i=0; i<sz; i++)
//                {
//                   p4.returnToBottom(p3.removeTop());
//                }
//                p4.shuffle();
//                for (int i=0; i<sz; i++)
//                {
//                   p2.returnToBottom(p4.removeTop());
//                }
//             }
//          }
//          else if(p3.pile.peek().greaterThan(p4.pile.peek()))
//          {
//             System.out.println(p3.pile.peek() + "\t>\t" + p4.pile.peek());
//             p3.returnToBottom(p4.removeTop());
//             p3.shuffle();
//             p1.returnToBottom(p3.removeTop());
//             p1.returnToBottom(p3.removeTop());
//          }
//          else
//          {
//             System.out.println(p3.pile.peek() + "\t<\t" + p4.pile.peek());
//             p4.returnToBottom(p3.removeTop());
//             p4.shuffle();
//             p2.returnToBottom(p4.removeTop());
//             p2.returnToBottom(p4.removeTop());            
//          }
//          
//          //display pile sizes
//          System.out.println("Pile 1 size: " + p1.getSize());
//          System.out.println("Pile 2 size: " + p2.getSize());   
//       }while((p1.getSize() > 0) && (p2.getSize() > 0));
// 
//       
//    }

   
}