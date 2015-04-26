/***********************************************************************************
GUI for War class. 
A GUI for playing War.
------------------------------------------------------------------------------------
Lori Nyland
CS 110
Homework 10
***********************************************************************************/
import javax.swing.*;      //needed for Swing classes  
import java.awt.*;         //needed for layout managers
import java.awt.event.*;   //needed for event listener interfaces

public class WarGUI extends JFrame
{
   //fields ========================================================================
   private JPanel panel1;              // holds components in panel 1
   private JPanel panel2;              // holds components in panel 2
   private JPanel panel3;              // holds components in panel 3
   private JPanel panel4;              // holds components in panel 4
   private JPanel panel5;              // holds components in panel 5
   private JPanel panel6;              // holds components in panel 6
   private JPanel panel7;              // holds components in panel 7
   private JPanel panel8;              // holds components in panel 8
   private JPanel panel9;              // holds components in panel 9
   private JPanel panel10;             // holds components in panel 10
   private JPanel panel11;             // holds components in panel 11
   private JPanel panel12;             // holds components in panel 12
   
   private JButton button1;            // holds a button object for dealing cards
   private JButton button2;            // holds a button object for flipping cards
   private JButton button3;            // holds a button object for auto flipping cards
   
   private JLabel player1;             // holds text for "Player 1"
   private JLabel player2;             // holds text for "Player 2"         
   
   private JLabel downCards1;          // holds text for player 1, # cards in down pile
   private JLabel downCards2;          // holds text for player 2, # cards in down pile
   private JLabel upCards1;            // holds text for player 1, # cards in up pile
   private JLabel upCards2;            // holds text for player 2, # cards in up pile
   
   private JLabel player1Status;       // holds the status of a play for player 1
   private JLabel player2Status;       // holds the status of a play for player 2
   
   private ImageIcon downCardPic;      // holds the downCard icon
   private ImageIcon upCardPic1;       // holds the upCard icon for player 1 
   private ImageIcon upCardPic2;       // holds the upCard icon for player 2 
    
   private int numDownCards1 = 0;      // holds number of down cards for player 1
   private int numDownCards2 = 0;      // holds number of down cards for player 2
   private int numUpCards1 = 0;        // holds number of up cards for player 1
   private int numUpCards2 = 0;        // holds number of up cards for player 2
      
   private CardPile d1;                // the down cards pile for player 1
   private CardPile d2;                // the down cards pile for player 2
   private CardPile u1;                // the up cards pile for player 1
   private CardPile u2;                // the up cards pile for player 2
            
   private final String TTL = "The game of WAR";      // what title bar text says
   
   private final String DEAL = "DEAL";                // title for DEAL button
   private final String FLIP = "FLIP";                // title for FLIP button
   private final String AUTOFLIP = "AUTO FLIP";       // title for AUTOFLIP button
   
   private final String UPCARDS = "Up Cards: ";       // text before number of up cards displayed
   private final String DOWNCARDS = "Down Cards: ";   // text before number of down cards displayed
   
   private final String P1 = "                   Player 1";    // player 1 label
   private final String P2 = "                   Player 2";    // player 2 label
   
   private final String HWIN = "             HAND: WINNER";    // hand winner indicator message
   private final String GWIN = "             GAME: WINNER";    // game winner indicator message
   private final String LOSE = "                  ";           // hand loser indicator message
   private final String HTIE = "                  HAND: TIE";  // hand tie indicator message
   
   private final int WINDOW_WIDTH = 700;     // window width
   private final int WINDOW_HEIGHT = 720;    // window height
   
   private final int NUM_CARDS = 52;         // # cards in a deck of std playing cards

   // constructor ==================================================================
   /**
   Constructor - builds the GUI
   */
   public WarGUI()
   {
      // set the title bar text.
      this.setTitle(TTL);
           
      // set the size of the window
      this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      // specify action for the close button
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // add layout manager to content pane
      this.setLayout(new GridLayout(3,4));
      
      // add panels to GridLayout content pane
      this.buildPanel1();    // r1, c1
      this.buildPanel2();    // r1, c2
      this.buildPanel3();    // r1, c3
      this.buildPanel4();    // r1, c4
      this.buildPanel5();    // r2, c1
      this.buildPanel6();    // r2, c2
      this.buildPanel7();    // r2, c3
      this.buildPanel8();    // r2, c4
      this.buildPanel9();    // r3, c1
      this.buildPanel10();   // r3, c2
      this.buildPanel11();   // r3, c3
      this.buildPanel12();   // r3, c4
      
      //display the window
      this.setVisible(true);
      }
        
      // methods ===================================================================   
      /*****************************************************************************
         The buildPanel1 method adds its components
      **/
      private void buildPanel1()
      {
         // create a panel
         panel1 = new JPanel();
         
         // create a message
         upCards1 = new JLabel(UPCARDS + " " + numUpCards1);
         
         // add player 1 # cards up message to panel
         panel1.add(upCards1);
      
         // add panel to content pane
         add(panel1); 
      }
      
      /*****************************************************************************
         The buildPanel2 method adds its components
      **/
      private void buildPanel2()
      {
         // create a panel
         panel2 = new JPanel();
         
         // instantiate the up card pile for player 1
         u1 = new CardPile();
            
         // add panel to content pane
         add(panel2); 
      }
      
      /*****************************************************************************
         The buildPanel3 method adds its components
      **/
      private void buildPanel3()
      {
         // create a panel
         panel3 = new JPanel();
         
         // instantiate the up card pile for player 2
         u2 = new CardPile();
         
         // add panel to content pane
         add(panel3); 
      }
      
      /*****************************************************************************
         The buildPanel4 method adds its components
      **/
      private void buildPanel4()
      {
         // create a panel
         panel4 = new JPanel();
         
         // create a message
         upCards2 = new JLabel(UPCARDS + " " + numUpCards2);
         
         // add player 2 # cards up message to pane4
         panel4.add(upCards2);
      
         // add panel to content pane
         add(panel4); 
      }
      
      /*****************************************************************************
         The buildPanel5 method adds its components
      **/
      private void buildPanel5()
      {
         // create a panel
         panel5 = new JPanel();
         
         // create a message
         downCards1 = new JLabel(DOWNCARDS + " " + numDownCards1);
         
         // add player 1 # cards down message to panel
         panel5.add(downCards1);
      
         // add panel to content pane
         add(panel5); 
      }
      
      /*****************************************************************************
         The buildPanel6 method adds its components
      **/
      private void buildPanel6()
      {
         // create a panel
         panel6 = new JPanel();
         
         // the down card pile for player 1
         d1 = new CardPile();
         
         // add panel to content pane
         add(panel6); 
      }
      
      /*****************************************************************************
      The buildPanel7 method adds its components
      **/
      private void buildPanel7()
      {
         // create a panel
         panel7 = new JPanel();
         
         // the down card pile for player 2
         d2 = new CardPile();
         
         // add panel to content pane
         add(panel7); 
      }
      
      /*****************************************************************************
         The buildPanel8 method adds its components
      **/
      private void buildPanel8()
      {
         // create a panel
         panel8 = new JPanel();
         
         // create a message
         downCards2 = new JLabel(DOWNCARDS + " " + numDownCards2);
         
         // add player 1 # cards down message to panel
         panel8.add(downCards2);
      
         // add panel to content pane
         add(panel8); 
      }
      
      /*****************************************************************************
         The buildPanel9 method adds its components
      **/
      private void buildPanel9()
      {
         // create a panel
         panel9 = new JPanel();
         
         // add layout manager to content pane
         panel9.setLayout(new GridLayout(2,1));
         
         // create a button
         button1 = new JButton(DEAL);
         
         // register the action listener for the DEAL button
         button1.addActionListener(new DealButtonListener());
         
         // add button to panel
         panel9.add(button1);
      
         // add panel to content pane
         add(panel9);    
      }

      /*****************************************************************************
      The buildPanel10 method adds its components
      **/
      private void buildPanel10()
      {
         // create a panel
         panel10 = new JPanel();
         
         // add layout manager to content pane
         panel10.setLayout(new GridLayout(7,1));
      
         // create a message
         player1 = new JLabel(P1);
         
         // add player 1 # message to panel
         panel10.add(player1);

         // initialize player status
         player1Status = new JLabel(LOSE);
         panel10.add(player1Status);
         
         // add panel to content pane
         add(panel10); 
      }
      
      /*****************************************************************************
      The buildPanel11 method adds its components
      **/
      private void buildPanel11()
      {
         // create a panel
         panel11 = new JPanel();
         
         // add layout manager to content pane
         panel11.setLayout(new GridLayout(7,1));
         
         // create a message
         player2 = new JLabel(P2);
         
         // add player 1 # message to panel
         panel11.add(player2);

         // initialize player status
         player2Status = new JLabel(LOSE);
         panel11.add(player2Status);
                     
         // add panel to content pane
         add(panel11); 
      }
      
      /*****************************************************************************
         The buildPanel12 method adds its components
      **/
      private void buildPanel12()
      {
         // create a panel
         panel12 = new JPanel();
         
         // add layout manager to content pane
         panel12.setLayout(new GridLayout(2,1));
         
         // create buttons
         button2 = new JButton(FLIP);
         //button3 = new JButton(AUTOFLIP);
         
         // register the action listener for the FLIP button
         button2.addActionListener(new FlipButtonListener());
         //button3.addActionListener(new FlipButtonListener());
         
         // add button to panel
         panel12.add(button2);
         //panel12.add(button3); 
      }
      
      /*****************************************************************************
         Private inner class that handles the event when the user clicks
         the DEAL button
      **/
      private class DealButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            // a deck of cards to be used to play war
            Deck deck1 = new Deck();
            deck1.shuffle();
      
            // deal the cards to the players
            for (int i=0; i<(NUM_CARDS/2); i++)
            {
               d1.returnToBottom(deck1.removeTop());
               d2.returnToBottom(deck1.removeTop());
            }
      
            // get the down card pile sizes
            numDownCards1 = d1.getSize();
            numDownCards2 = d2.getSize();
            
            // put down facing card piles out
            downCardPic = new ImageIcon("cardFacades/back.jpg");
            panel6.add(new JLabel(downCardPic));
            panel7.add(new JLabel(downCardPic));
            
            // put down facing card pile counts out
            downCards1.setText(DOWNCARDS + " " + numDownCards1);
            downCards2.setText(DOWNCARDS + " " + numDownCards2);
            panel5.removeAll();
            panel5.add(downCards1);
            panel8.removeAll();
            panel8.add(downCards2);
            
            // remove the DEAL button
            panel9.removeAll();
            
            // add FLIP buttons panel to content pane
            add(panel12);
            pack();
         } 
      }
      
      /*****************************************************************************
         Private inner class that handles the event when the user clicks
         the FLIP or AUTOFLIP button
      **/
      private class FlipButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            String actionCommand = e.getActionCommand();
            
            do
            {
               if(d1.getSize() == 0)
               {
                  player1Status.setText(LOSE);
                  player2Status.setText(GWIN);
                  
                  // remove the FLIP button
                  panel12.removeAll();
               }
               else if(d2.getSize() == 0)
               {
                  player1Status.setText(GWIN);
                  player2Status.setText(LOSE);
                  
                  // remove the FLIP button
                  panel12.removeAll();
               }
               else
               {           
                  //put top down card as up card in a new pile
                  u1.returnToTop(d1.removeTop());
                  u2.returnToTop(d2.removeTop());
                  
                  // put top card of up card piles out
                  panel2.removeAll();
                  String theTopUpCard1 = u1.peekTopCard().toString();
                  upCardPic1 = new ImageIcon("cardFacades/" + theTopUpCard1 + ".jpg");
                  panel2.add(new JLabel(upCardPic1));
                  String theTopUpCard2 = u2.peekTopCard().toString();
                  upCardPic2 = new ImageIcon("cardFacades/" + theTopUpCard2 + ".jpg");
                  panel3.removeAll();
                  panel3.add(new JLabel(upCardPic2));
                  
                  // get the card pile sizes
                  numDownCards1 = d1.getSize();
                  numDownCards2 = d2.getSize();
                  numUpCards1 = u1.getSize();
                  numUpCards2 = u2.getSize();
                  
                  // put card pile counts out
                  downCards1.setText(DOWNCARDS + " " + numDownCards1);
                  downCards2.setText(DOWNCARDS + " " + numDownCards2);
                  upCards1.setText(UPCARDS + " " + numUpCards1);
                  upCards2.setText(UPCARDS + " " + numUpCards2);
                  
                  // compare cards in up piles
                  if(u1.peekTopCard().equals(u2.peekTopCard()))
                  {  
                     // establish the status message for each player
                     player1Status.setText(HTIE);
                     player2Status.setText(HTIE);
                  }
                  else if(u1.peekTopCard().greaterThan(u2.peekTopCard()))
                  {
                     // establish the status message for each player
                     player1Status.setText(HWIN);
                     player2Status.setText(LOSE);
                     
                     //put the cards to their proper piles
                     int sz = u1.getSize();
                     for(int i=0; i<sz; i++)
                     {
                        d1.returnToBottom(u1.removeTop());
                        d1.returnToBottom(u2.removeTop());
                     }
                  }
                  else
                  {
                     // establish the status message for each player
                     player2Status.setText(HWIN);
                     player1Status.setText(LOSE);
                     
                     //put the cards to their proper piles
                     int sz = u2.getSize();
                     for(int i=0; i<sz; i++)
                     {
                        d2.returnToBottom(u1.removeTop());
                        d2.returnToBottom(u2.removeTop());
                     }
                  }
                  
                  // set the status message for each player
                  panel10.remove(player1Status);
                  panel10.add(player1Status);
                  panel11.remove(player2Status);
                  panel11.add(player2Status);
               }
            }while(!actionCommand.equals("FLIP"));
         }
      }
      
      /**
         The main method creates an instance of the WAR game window, 
         causing it to display - ready to play
      */
      public static void main(String[] args)
      {
         new WarGUI();
      }
      
}