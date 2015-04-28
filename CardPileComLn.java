/***********************************************************************************
CardPile class Demo. 
Simulates a subset from a standard 52 card deck.
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/
import java.util.Random;         //for shuffling the deck of cards
import java.util.LinkedList;     //for implementing a linked list
import javax.swing.JOptionPane;  //for dialog boxes

public class CardPileComLn
{
   public static void main(String[] args)
   {
      // number of cards in a deck of std playing cards
      final int NUM_CARDS = 52;
      int sz;
      
      // a deck of cards to be used to play war
      Deck d1 = new Deck();
      d1.shuffle();
      
      // the down card piles for the 2 players
      CardPile p1 = new CardPile();
      CardPile p2 = new CardPile();
      
      // deal the cards to the players
      for (int i=0; i<(NUM_CARDS/2); i++)
      {
         p1.returnToBottom(d1.removeTop());
         p2.returnToBottom(d1.removeTop());
      }
      
      // display the card piles
      sz = p1.getSize();
      System.out.println("Pile 1");
      for (int i=0; i<sz; i++)
      {
         System.out.println(p1.peekTopCard().toString());
         p1.removeTop();
      }
      System.out.println("Pile 1 size: " + sz);
      sz = p2.getSize();
      System.out.println("\nPile 2");
      for (int i=0; i<sz; i++)
      {
         System.out.println(p2.peekTopCard().toString());
         p2.removeTop();
      }
      System.out.println("Pile 2 size: " + sz);
      
      //display deck size
      System.out.println("\nDeck size: " + d1.getSize());
   }
}
