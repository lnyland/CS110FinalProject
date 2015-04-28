/***********************************************************************************
Deck class Demo. 
Simulates a standard 52 card deck.
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/
import java.util.Random;         //for shuffling the deck of cards
import java.util.LinkedList;     //for implementing a linked list
import javax.swing.JOptionPane;  //for dialog boxes

public class DeckComLn
{
   public static void main(String[] args)
   {
      Deck d1 = new Deck();
      Deck d2 = new Deck();
      int sz;
      
      //display the unshuffled deck
      sz = d1.getSize();
      System.out.println("Unshuffled Deck");
      for (int i=0; i<sz; i++)
      {
         System.out.println(d1.peekTopCard().toString());
         d1.removeTop();
      }
      
      d2.shuffle();
      
      //display the shuffled deck
      sz = d2.getSize();
      System.out.println("\nShuffled Deck");
      for (int i=0; i<sz; i++)
      {
         System.out.println(d2.peekTopCard().toString());
         d1.returnToBottom(d2.removeTop());
      }
      //display its size
      System.out.println("\nThe current deck size is: " + d1.getSize());
      
      //remove top cards from deck
      d1.removeTop();
      d1.removeTop();
      d1.removeTop();
      d1.removeTop();
      d1.removeTop();
      d1.removeTop();
      d1.removeTop();
      
      //display the deck
      sz = d1.getSize();
      System.out.println("\nCurrent deck after removing 7 cards from it top");
      for (int i=0; i<sz; i++)
      {
         System.out.println(d1.peekTopCard().toString());
         d2.returnToBottom(d1.removeTop());
      }
      //display its size
      System.out.println("\nThe current deck size is: " + d2.getSize());

      //move cards from top to bottom
      d2.returnToBottom(d2.removeTop());
      d2.returnToBottom(d2.removeTop());
      d2.returnToBottom(d2.removeTop());
      d2.returnToBottom(d2.removeTop());
      d2.returnToBottom(d2.removeTop());
      
      //display the deck
      sz = d2.getSize();
      System.out.println("\nCurrent deck after moving 5 cards from top to bottom of deck");
      for (int i=0; i<sz; i++)
      {
         System.out.println(d2.peekTopCard().toString());
         d1.returnToBottom(d2.removeTop());
      }
      //display its size
      System.out.println("\nThe current deck size is: " + d1.getSize());   
   }
}
