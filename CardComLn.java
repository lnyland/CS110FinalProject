/***********************************************************************************
Card class Demo. 
Simulates a single playing card from a standard 52 card deck.
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/

public class CardComLn
{
   public static void main(String[] args)
   {
      //empty Card
      System.out.println("Card1: Create an empty card using default constructor");
      Card c1 = new Card();
      System.out.println(c1);
      
      //assign a Card
      System.out.println("\nCard2: Assign a card using integer representation");
      Card c2 = new Card(1,4);
      System.out.println(c2);
      
      //assign a Card
      System.out.println("\nCard3: Assign a card using integer representation");
      Card c3 = new Card(12,2);
      System.out.println(c3);
      
      //assign a Card
      System.out.println("\nCard4: Use copy constructor, Card4=Card3");
      Card c4 = new Card(c3);
      System.out.println(c4);
      
      //assign a Card
      System.out.println("\nCard5: Assign a card using integer representation");
      Card c5 = new Card(12,1);
      System.out.println(c5);
      
      //compare Cards
      System.out.println("\nCompare Cards");
      if(c2.equals(c3))
         System.out.println(c2 + " equals " + c3);
      else
         System.out.println(c2 + " is not equal to " + c3);
         
      //compare Cards
      if(c4.equals(c3))
         System.out.println(c4 + " equals " + c3);
      else
         System.out.println(c4 + " is not equal to " + c3);
         
      //compare Cards
      if(c5.equals(c3))
         System.out.println(c5 + " equals " + c3);
      else
         System.out.println(c5 + " is not equal to " + c3);
         
      //compare Cards
      if(c5.greaterThan(c3))
         System.out.println(c5 + " is greater than " + c3);
      else
         System.out.println(c5 + " is not greater than " + c3);

      //compare Cards
      if(c5.greaterThan(c2))
         System.out.println(c5 + " is greater than " + c2);
      else
         System.out.println(c5 + " is not greater than " + c2);
      
   }
}