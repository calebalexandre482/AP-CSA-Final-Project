import bridges.games.*;
import bridges.base.*;

/**
 * Write a description of class GameBasics2Sol here.
 *
 * @author Caleb Alexandre
 * @version Final Project
 */
class GameBasics2 extends NonBlockingGame {

   // static (class) variables
   
   // HINT: You will use redR and redC when creating the starting red "player" cell in the initialize() method)
   static int redR; // current row num of red player 
   static int redC; // current col num of red player  
   
   static int height; // board height (number of rows)
   static int width; // board width (number of columns)
  
   
   /**
    * Constructor for objects of class GameBasics2Sol
    * @param assignmentNumber your Bridges assignment number
    * @param username   your Bridges username
    * @param apiKey  your Bridges apiKey
    * @param numRows number of rows in the game grid (height)
    * @param numCols number of columns in the game grid (width)
    */
   public GameBasics2 (int assignmentNumber, String username, String apiKey, int numRows, int numCols) {
       //create a game board of numRows x numCols within a new Bridges object
       super (assignmentNumber, username,  apiKey, numRows, numCols);
       setTitle("Game Basics 2");
       setDescription("Create a \"player\" (a red cell that can be moved around the game board with the " +
                        "upArrow, downArrow, rightArrow, and leftArrow keys. ");
   }
   
   public static void main (String args[]) {
       
       // initialize board height (number of rows)
       height = 20;
       // initialize board width (number of columns))
       width = 25;
       
       // create the GameBasics2 object
       // Make sure to use your own assignment number,  userid, and API key as arguments 
       GameBasics2  game  = new GameBasics2(521, "calexandre1", "419249051969", height, width);
       // start the game
       game.start();
   }
   
   
   /**
    * initialize() method runs exactly once 
    */
   public void initialize() {
       // create a single color or multicolored background to your grid (leaving borders not set yet)
       // STUDENT CODE HERE:
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 25; j++) {
                if(i == 0 || j == 0 || i == 19 || j == 24)
                {
                    setBGColor(i,j,NamedColor.blue);
                }
                else {
                    setBGColor(i,j,NamedColor.khaki);
                }
            }
        }
       
       // create a blue border (top, bottom, left, right) for the grid
       // STUDENT CODE HERE:
       
       //Done above
       
       // create a red background color in the cell that is the player's starting location (use your variables redR, redC)
       // STUDENT CODE HERE:

       //setBGColor(redR,redC,NamedColor.red);
       
       
   }

   /**
     * gameLoop() method runs once per each frame of the game 
     */
   public void gameLoop() {
        // Enable the user to control the movement of the "player" (up, down, left, right) represented by 
        // the red background color, checking to see if the "player" has gone into the blue border.
        // HINT: For each type of movement, you need to turn the current cell back to 
        // yellow and figure out which cell to turn red.
        // STUDENT CODE HERE:
        redC = 1;
        redR = 9;
        int lastR = redR;
        int lastC = redC;
        
        if(super.keyLeft()) {
            if(redC > 1) {
                lastC = redC;
                redC--;
                setBGColor(redR,redC,NamedColor.red);
                setBGColor(lastR,lastC,NamedColor.khaki);

            }
        }
        if(super.keyRight()) {
            if(redC < getBoardWidth() - 2) {
                lastC = redC;
                redC++;
                setBGColor(redR,redC,NamedColor.red);
                setBGColor(lastR,lastC,NamedColor.khaki);

            }
        }
        if(super.keyUp()) {
            if(redR > 1) {
                lastR = redR;
                redR--;
                setBGColor(redR,redC,NamedColor.red);
                setBGColor(lastR,lastC,NamedColor.khaki);

            }
        }
        if(super.keyDown()) {
            if(redC > getBoardHeight() - 2) {
                lastR = redR;
                redC--;
                setBGColor(redR,redC,NamedColor.red);
                setBGColor(lastR,lastC,NamedColor.khaki);

            }
        }
        
        
   }
 
   // When your gameLoop() method gets undweildy and needs to be decomposed, create methods below
   // YOUR new methods HERE:
   
   
   
} // end class GameBasics2