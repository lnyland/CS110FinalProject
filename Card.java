/***********************************************************************************
Card class. 
Simulates a single playing card from a standard 52 card deck.
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/

public class Card
{
   //fields ========================================================================
   
   //holds card attributes
   public static enum Rank {EMPTY, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,  JACK, QUEEN, KING, ACE}
   public static enum Suit {EMPTY, CLUBS, DIAMONDS, HEARTS, SPADES}
   
   //holds the rank of the card
   private Rank rank;
   
   //holds the suit of the card
   private Suit suit;
   
   // constructor ==================================================================
      
  /**
   Default constructor - initialize rank and suit fields to empty.
   */
   public Card()
   {     
      this.rank = Rank.EMPTY;
      this.suit = Suit.EMPTY;
   }
   
   /**
   Constructor - initialize rank and suit fields according to ordinal values of enumerated Rank and Suit.
   @param rank An integer that holds the Rank ordinal value.
   @param suit An integer that holds the Suit ordinal value.
   */
   public Card(int rank, int suit)
   {     
      switch (rank)
      {
         case 0:
            this.rank = Rank.EMPTY;
            break;
         case 1:
            this.rank = Rank.TWO;
            break;
         case 2:
            this.rank = Rank.THREE;
            break;
         case 3:
            this.rank = Rank.FOUR;
            break;
         case 4:
            this.rank = Rank.FIVE;
            break;
         case 5:
            this.rank = Rank.SIX;
            break;
         case 6:
            this.rank = Rank.SEVEN;
            break;
         case 7:
            this.rank = Rank.EIGHT;
            break;
         case 8:
            this.rank = Rank.NINE;
            break;
         case 9:
            this.rank = Rank.TEN;
            break;
         case 10:
            this.rank = Rank.JACK;
            break;
         case 11:
            this.rank = Rank.QUEEN;
            break;
         case 12:
            this.rank = Rank.KING;
            break;
         case 13:
            this.rank = Rank.ACE;
            break;
         default:
            System.out.println("Invalid rank assignment. Cannot create Card object.");
      }
      switch (suit)
      {
         case 0:
            this.suit = Suit.EMPTY;
            break;
         case 1:
            this.suit = Suit.CLUBS;
            break;
         case 2:
            this.suit = Suit.DIAMONDS;
            break;
         case 3:
            this.suit = Suit.HEARTS;
            break;
         case 4:
            this.suit = Suit.SPADES;
            break;
         default:
            System.out.println("Invalid suit assignment. Cannot create Card Object.");
      }
   }
   
   /**
   Copy constructor - initialize rank and suit fields of this Card according to those of another Card.
   @param card2 A Card object 
   */
   public Card(Card card2)
   {     
      this.rank = card2.getRank();
      this.suit = card2.getSuit();
   }
   
   // methods ======================================================================
  
   /**
   Retrieve the Card's suit.
   @return A Suit enumerated type that holds the Card's Suit.
   */
   public Suit getSuit()
   {     
      return suit;
   }
   
   /**
   Retrieve the Card's rank.
   @return A Rank enumerated type that holds the Card's Rank.
   */
   public Rank getRank()
   {     
      return rank;
   }
   
   /**
   Shows the Card's rank and suit in string format.
   @return A String that shows the Card's rank and suit.
   */
   public String toString()
   {     
      return (rank + " of " + suit);
   }
   
   /**
   Compares the rank fields of 2 Card objects for equality.
   @param card2 A Card object. 
   @return A boolean that is true if the objects' rank fields are equal, and false otherwise.
   */
   public boolean equals(Card card2)
   {     
      boolean test;     //holds the result of the equality comparison
      
      if(this.rank == card2.getRank())
         test = true;
      else
         test = false;
         
      return test;
   }
   
   /**
   Determines the greater rank field between 2 Card objects. 
   @param card2 A Card object. 
   @return A boolean that is true if this object's rank field is greater than the rank field of card2, and false otherwise.
   */
   public boolean greaterThan(Card card2)
   {     
      boolean test;     //holds the result of the equality comparison
      
      if(this.rank.compareTo(card2.getRank()) > 0)
         test = true;
      else
         test = false;
         
      return test;
   }
   
//    //tester
//    public static void main(String[] args)
//    {
//       //empty Card
//       Card c1 = new Card();
//       System.out.println(c1);
//       
//       //assign a Card
//       Card c2 = new Card(1,4);
//       System.out.println(c2);
//       
//       //assign a Card
//       Card c3 = new Card(12,2);
//       System.out.println(c3);
//       
//       //assign a Card
//       Card c4 = new Card(c3);
//       System.out.println(c4);
//       
//       //assign a Card
//       Card c5 = new Card(12,1);
//       System.out.println(c5);
//       
//       //compare Cards
//       if(c2.equals(c3))
//          System.out.println(c2 + " equals " + c3);
//       else
//          System.out.println(c2 + " is not equal to " + c3);
//          
//       //compare Cards
//       if(c4.equals(c3))
//          System.out.println(c4 + " equals " + c3);
//       else
//          System.out.println(c4 + " is not equal to " + c3);
//          
//       //compare Cards
//       if(c5.equals(c3))
//          System.out.println(c5 + " equals " + c3);
//       else
//          System.out.println(c5 + " is not equal to " + c3);
//          
//       //compare Cards
//       if(c5.greaterThan(c3))
//          System.out.println(c5 + " is greater than " + c3);
//       else
//          System.out.println(c5 + " is not greater than " + c3);
// 
//       //compare Cards
//       if(c5.greaterThan(c2))
//          System.out.println(c5 + " is greater than " + c2);
//       else
//          System.out.println(c5 + " is not greater than " + c2);
//       
//    }
  
}





