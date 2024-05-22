/**
 * Write your description of class GameBasics1 here.
 *
 * @author Caleb Alexandre
 * @version Final Project
 */

import bridges.games.*;
import bridges.base.*;


class GameBasics1 extends NonBlockingGame {

   /**
    * Constructor for objects of class GameBasics1
    * @param assignmentNumber your Bridges assignment number
    * @param username   your Bridges username
    * @param apiKey  your Bridges apiKey
    * @param numRows number of rows in the game grid (height)
    * @param numCols number of columns in the game grid (width)
    */
   public GameBasics1 (int assignmentNumber, String username, String apiKey, int numRows, int numCols) {
       //create a game board of numRows x numCols within a new Bridges object
       super (assignmentNumber, username,  apiKey, numRows, numCols);
       setTitle("Game Basics 1");
       setDescription("Create messages to display on the game board.");
   }

   
   public static void main (String args[]) {
       // declare and initialize a height variable (number of rows)
       int height = 12;
       // declare and initialize a width variable (number of columns))
       int width = 18;
       // create the GameBasics1 object. Make sure to use your own assignment number,  username, and API key as arguments 
       GameBasics1  game  = new GameBasics1(520, "calexandre1", "419249051969", height, width);
       // start the game
       game.start();
   }
   
   
   /**
    * initialize() method runs exactly once 
    */
   public void initialize() {
       // create a single color or multicolored background to your grid
       // YOUR CODE HERE:
       
       for(int i = 0; i < 12; i++) {
           for(int j = 0; j < 18; j++) {
            setBGColor(i,j,NamedColor.khaki);
           }
       }

       
   }

   /**
     * gameLoop() method runs once per each frame of the game 
     */
   public void gameLoop() {
        // use the drawSymbol() method to put symbols in the board
        // put up a message  "CS Rocks" or something interesting
        //
        // Extra: Use the input key methods to make so the user can make the message appear and disappear
        //     for instance, keyLeft(), keyRight(), etc
        // Another Extra: Use the input key methods to make it so the user can make it display different messages
        //     
        // YOUR CODE HERE:
        
        drawSymbol(2, 8, NamedSymbol.C, NamedColor.blue);
        drawSymbol(2, 9, NamedSymbol.S, NamedColor.blue);
        drawSymbol(3, 3, NamedSymbol.R, NamedColor.blue);
        drawSymbol(3, 4, NamedSymbol.o, NamedColor.blue);
        drawSymbol(3, 5, NamedSymbol.c, NamedColor.blue);
        drawSymbol(3, 6, NamedSymbol.k, NamedColor.blue);
        drawSymbol(3, 7, NamedSymbol.s, NamedColor.blue);
        
   }
 
   // When your gameLoop() method gets undweildy and needs to be decomposed, create methods below
   // YOUR new methods HERE:
   
   
}

