/***********************************************************************************
Command Line play of card game WAR
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/
import java.util.Random;         //for shuffling the deck of cards
import java.util.LinkedList;     //for implementing a linked list
import javax.swing.JOptionPane;  //for dialog boxes (error checking)

public class WarComLn 
{   
   public static void main(String[] args)
   {
      int numDownCards1 = 0;      // holds number of down cards for player 1
      int numDownCards2 = 0;      // holds number of down cards for player 2
      int numUpCards1 = 0;        // holds number of up cards for player 1
      int numUpCards2 = 0;        // holds number of up cards for player 2
      
      final int NUM_CARDS = 52;           // # cards in a deck of std playing cards
      final String HWIN = "HAND: WINNER"; // hand winner indicator message
      final String GWIN = "GAME: WINNER"; // game winner indicator message
      final String LOSE = "";             // hand loser indicator message
      final String HTIE = "HAND: TIE";    // hand tie indicator message
   
      String player1Status = LOSE;       // holds the status of a play for player 1
      String player2Status = LOSE;       // holds the status of a play for player 2

      // a deck of cards to be used to play war
      Deck deck1 = new Deck();
      deck1.shuffle();
      
      // display card count for deck 
      System.out.println("Deck size after shuffle: " + deck1.getSize());

      // instantiate the up and down card piles for player 1 & 2
      CardPile u1 = new CardPile();
      CardPile u2 = new CardPile();
      CardPile d1 = new CardPile();
      CardPile d2 = new CardPile();

      // deal the cards down to the players
      for (int i=0; i<(NUM_CARDS/2); i++)
      {
         d1.returnToBottom(deck1.removeTop());
         d2.returnToBottom(deck1.removeTop());
      }
      
      // get the card pile sizes
      numDownCards1 = d1.getSize();
      numDownCards2 = d2.getSize();
      numUpCards1 = u1.getSize();
      numUpCards2 = u2.getSize();
          
      // display card count for card piles and deck 
      System.out.println("Player 1:");
      System.out.println("# down cards: " + numDownCards1);
      System.out.println("# up cards: " + numUpCards1);
      System.out.println("Player 2:");
      System.out.println("# down cards: " + numDownCards2);
      System.out.println("# up cards: " + numUpCards2);
      System.out.println("Deck size after dealing to player piles: " + deck1.getSize());  
      
      
      do
      {
         if(d1.getSize() == 0) // player 1 loses game
         {
            System.out.println("Player 2 is the Game Winner!");
            player2Status = GWIN;
         }
         else if(d2.getSize() == 0) // player 2 loses game
         {
            System.out.println("Player 1 is the Game Winner!");
            player1Status = GWIN;
         }
         else // a player has yet to win
         {           
            //put top down card as up card in a new pile for each player
            u1.returnToTop(d1.removeTop());
            u2.returnToTop(d2.removeTop());
                  
            // put top card of up card piles out
            String theTopUpCard1 = u1.peekTopCard().toString();
            String theTopUpCard2 = u2.peekTopCard().toString();
                  
            // update the card pile sizes
            numDownCards1 = d1.getSize();
            numDownCards2 = d2.getSize();
            numUpCards1 = u1.getSize();
            numUpCards2 = u2.getSize();
                  
            // display card count for card piles 
            System.out.println("Player 1:");
            System.out.println("# down cards: " + numDownCards1);
            System.out.println("# up cards: " + numUpCards1);
            System.out.println("Player 2:");
            System.out.println("# down cards: " + numDownCards2);
            System.out.println("# up cards: " + numUpCards2);
                  
            // compare cards in up piles
            if(u1.peekTopCard().equals(u2.peekTopCard())) // a tie
            {  
               // establish the status message for each player
               player1Status = HTIE;
               player2Status = HTIE;
               System.out.println(u1.peekTopCard().toString() + " equals " + u2.peekTopCard().toString());
                     
               // each player burns a card to bottom of up pile before next flip
               u1.returnToBottom(d1.removeTop());
               u1.returnToBottom(d1.removeTop());
               //u1.returnToBottom(d1.removeTop());
               u2.returnToBottom(d2.removeTop()); 
               u2.returnToBottom(d2.removeTop());
               //u2.returnToBottom(d2.removeTop());                    
            }
            else if(u1.peekTopCard().greaterThan(u2.peekTopCard())) // player 1 won hand
            {
               // establish the status message for each player
               player1Status = HWIN;
               player2Status = LOSE;
               System.out.println(u1.peekTopCard().toString() + " greater than " + u2.peekTopCard().toString());
               
               //put the cards to their proper piles
               int sz = u1.getSize();
               for(int i=0; i<sz; i++)
               {
                  d1.returnToBottom(u1.removeTop());
                  d1.returnToBottom(u2.removeTop());
               }
            }
            else //player 2 won hand
            {
               // establish the status message for each player
               player1Status = LOSE;
               player2Status = HWIN;
               System.out.println(u1.peekTopCard().toString() + " less than " + u2.peekTopCard().toString());
               
               //put the cards to their proper piles
               int sz = u2.getSize();
               for(int i=0; i<sz; i++)
               {
                  d2.returnToBottom(u1.removeTop());
                  d2.returnToBottom(u2.removeTop());
               }
            }
                  
            // set the status message for each player 
            System.out.println("Player 1 status: " + player1Status);
            System.out.println("Player 2 status: " + player2Status);
         }
      }while(!(player1Status == GWIN) && !(player2Status == GWIN));      
   }
}