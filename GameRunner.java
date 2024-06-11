import bridges.games.*;
import bridges.base.*;
import java.util.Random;

public class GameRunner extends NonBlockingGame
{
    // 2d arraylist for the Map 
    private static int[][] map;
    // variables for the character 
    public static int charR; // row location of the character
    public static int charC; // column location of the character
    public static int lastCharR; // last row location of the character
    public static int lastCharC; // last column location of the character
    // variables for the fruit 
    public static int fruitR; // row location of the fruit
    public static int fruitC; // column location of the fruit
    public static int lastFruitR; // last row location of the fruit
    public static int lastFruitC; // last column location of the fruit 
    // wait time until the fruit's position changes 
    static int fruitLife = 100; 
    // represents the current score 
    private int score;
    // amount of score needed to win
    static final int WIN_NUM = 10;
    // creates a random object of the Random class
    Random randomGenerator = new Random();
    // creates a monster of the Monster class
    public static Monster monster;
    // slows the rate at which the player moves 
    int framePerMove = 12;
    int frameSinceMove = 0;
    
    NamedColor backgroundColor = NamedColor.black;
    // YOUR CHANGE HERE: chose a symbol for your character
    NamedSymbol character = NamedSymbol.bug3;

    // YOUR CHANGE HERE: chose color for your character
    NamedColor charColor = NamedColor.blue;

    // YOUR CHANGE HERE: chose a symbol for your monster
    NamedSymbol monChar = NamedSymbol.bug2;

    // YOUR CHANGE HERE: chose a color for your monster
    NamedColor monColor = NamedColor.gray;

    // YOUR CHANGE HERE: chose a symbol for your fruit
    NamedSymbol fruitChar = NamedSymbol.apple;

    // YOUR CHANGE HERE: chose a color for your fruit
    NamedColor fruitColor = NamedColor.red;

    public GameRunner (int assignmentNumber, String username, String apiKey, int numRows, int numCols) 
    {
        super (assignmentNumber, username,  apiKey, numRows, numCols);
        // set game title and description
        // YOUR CODE HERE:
        setTitle("Monster Adventure");
        setDescription("Caleb Alexandre");

        // sets map to the 'map' from the Map class
        map = Map.map;
    }
    public  static void main(String[] args) 
    {
        // create GameRunner object
        // remember to fill in your own assignment number, username, and api key
        GameRunner  adventure  = new GameRunner(100, "calexandre1", "419249051969", 32, 32);
        // create a Monster object named 'monster' 
        // monster should be located somewhere near the top right corner 
        // YOUR CODE HERE:
        Monster bugMonster = monster;

        // start game
        adventure.start();
    }
    // this method is called every time the game restarts
    public void initialize() 
    {
        // draws the character in the middle initially with 'character' and 'charColor'
        // don't hard code the coordinates for the middle of the map
        // use map.length and your understanding of math to determine the middle coordinates
        // YOUR CODE HERE:
        charR = getBoardHeight()/2;
        charC = getBoardWidth()/2;

        // sets the character column location and row location to the middle of the map 
        // YOUR CODE HERE:
        drawSymbol(charR, charC, character, charColor);

        // draws the monster at the monster location using 
        // the getX() and getY() methods from the Monster class
        // YOUR CODE HERE:
        monster = new Monster(2, 30);
        drawSymbol(monster.getX(), monster.getY(), monChar, monColor);

        // sets the row and column location of the fruit randomly 
        fruitR = randomGenerator.nextInt(map.length);
        fruitC = randomGenerator.nextInt(map.length -1);
        // continues to set the locations of the fruit until the locations
        // of the fruit is on a 0
        while (map[fruitR][fruitC] >= 1)
        {
            fruitR = randomGenerator.nextInt(map.length);
            fruitC = randomGenerator.nextInt(map.length -1);
        }
        // sets each square on the map to a specific color based on the number 
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map.length; j++)
            {
                if(map[i][j] == 0)
                {
                   setBGColor(i, j, NamedColor.greenyellow); 
                }
                if(map[i][j] == 1)
                {
                   setBGColor(i, j, NamedColor.green); 
                }
                if(map[i][j] == 10)
                {
                   setBGColor(i, j, NamedColor.limegreen); 
                }
                if(map[i][j] == 11)
                {
                   setBGColor(i, j, NamedColor.lime); 
                }
                if(map[i][j] == 4)
                {
                   setBGColor(i, j, NamedColor.saddlebrown); 
                }
                if(map[i][j] == 5)
                {
                   setBGColor(i, j, NamedColor.sienna); 
                }
                if(map[i][j] == 6)
                {
                   setBGColor(i, j, NamedColor.tan); 
                }
                if(map[i][j] == 7)
                {
                   setBGColor(i, j, NamedColor.darkgrey); 
                }
                if(map[i][j] == 8)
                {
                   setBGColor(i, j, NamedColor.white); 
                }
                if(map[i][j] == 9)
                {
                   setBGColor(i, j, NamedColor.blue); 
                }
                if(map[i][j] == 3)
                {
                   setBGColor(i, j, NamedColor.royalblue); 
                }
                if(map[i][j] == 2)
                {
                   setBGColor(i, j, NamedColor.lightskyblue); 
                }
            }
            
        }
    }
    /**
    * gameLoop() method runs once per each frame of the game 
    */
    public void gameLoop() 
    {
        // lowers the players speed based on frames
        if(frameSinceMove % framePerMove == 0)
        {
            // sets the current row and column of the character 
            // to lastCharR and lastCharC
            // YOUR CODE HERE:
            

            // if the up key is pressed
            if(keyUp())
            {
                //Making sure that the player is still in the grid
                if(inGrid())
                {
                    //checks to see if the next square which the character will move is walkable
                    if(walkable(charR-1,charC))
                    {
                        // if the square which the character moves on is under the tree except the middle of the tree
                        // the character will be invisible but is still moving
                        if(map[charR-1][charC] == 10 || map[charR-1][charC] == 11)
                        {
                            // draws the character when going up to not be seen
                            // (use none for symbol and 'backgroundColor' for the color)
                            //YOUR CODE HERE:
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);
                            
                            // sets the current location to the last location
                            // and draws over where the player used to be 
                            // (erase last location using NamedSymbol.none)
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;
                            charR--;
                            drawSymbol(lastCharR, lastCharC, NamedSymbol.none, backgroundColor);
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);
                        }
                        else {
                            // sets the current location to the last location
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;
                            charR--;
                            // calls the handleFruit() and paintScreen() method to make sure 
                            // that when the fruit is touched it will disappear and when the 
                            // character moves to new location it will be drawn and the previous location is cleared.
                            handleFruit();
                            paintScreen();
                            // makes sure that the monster is not on the tree and uses 
                            // the follow method to follow the character
                            if(map[monster.getX()][monster.getY()] != 10 || map[monster.getX()][monster.getY()] != 11)
                            {
                                follow();
                            }
                            // constantly checks if the player is dead for every time the up key was pressed
                            dead();
                        } 
                    }
                }
                else {
                    // if it was not inside the grid, the row location of the character stays the same
                    // YOUR CODE HERE:
                    charR = charR;
                    charC = charC;

                }
                // constantly checks if the player is dead for every time the up key was pressed
                dead();
            }
            // if the down key was pressed 
            if(keyDown())
            {
                // making sure that the red cell is still in the grid
                if(inGrid())
                {
                    // checks to see if the next square which the character will move is walkable
                    if(walkable(charR+1,charC))
                    {
                        // if the square which the character moves on is under the tree except the middle of the tree
                        // the character will be invisible but is still moving
                        if(map[charR+1][charC] == 10 || map[charR+1][charC] == 11)
                        {
                            // draws the character when going up to not be seen
                            // (use none for symbol and 'backgroundColor' for the color)
                            // YOUR CODE HERE:
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);

                            // sets the current location to the last location
                            // and draws over where the player used to be 
                            // (erase last location using NamedSymbol.none)
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;
                            charR++;
                            drawSymbol(lastCharR, lastCharC, NamedSymbol.none, backgroundColor);
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);
                        }
                        else {
                            // sets the current location to the last location
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;

                            /// calls the handleFruit() and paintScreen() method to make sure 
                            // that when the fruit is touched it will disappear and when the 
                            // character moves to new location it will be drawn and the previous location is cleared.
                            handleFruit();
                            paintScreen();
                            // makes sure that the monster is not on the tree and uses 
                            // the follow() method to follow the character
                            if(map[monster.getX()][monster.getY()] != 10 || map[monster.getX()][monster.getY()] != 11)
                            {
                                follow();
                            }
                            // constantly checks if the player is dead for every time the up key was pressed
                            dead();
                            
                        }
                    }
                }
                else {
                    // if it was not inside the grid, the row location of the character stays the same
                    // YOUR CODE HERE:
                    charR = charR;
                    charC = charC;

                }
                // constantly checks if the player is dead for every time the up key was pressed
                dead();
            }
            // if the right key was pressed
            if(keyRight())
            {
                // making sure that the player is still in the grid
                if(inGrid())
                {
                    // checks to see if the next square which the character will move is walkable
                    if(walkable(charR,charC+1))
                    {
                        // if the square which the character moves on is under the tree except the middle of the tree
                        // the character will be invisible but is still moving
                        if(map[charR][charC+1] == 10 || map[charR][charC+1] == 11)
                        {
                            // draws the character when going right to not be seen
                            // (use none for symbol and the 'backgroundColor' for the color)
                            // YOUR CODE HERE:
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);
                            
                            // sets the current location to the last location
                            // and draw over where the player used to be 
                            // (erase last locations using NamedSymbol.none)
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;
                            charC++;
                            drawSymbol(lastCharR, lastCharC, NamedSymbol.none, backgroundColor);
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);
                            

                        }
                        else {
                            // sets the current location to the last location
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;

                            // calls the handleFruit() and paintScreen() method to make sure 
                            // that when the fruit is touched it will disappear and when the 
                            // character moves to new location it will be drawn and the previous location is cleared.
                            handleFruit();
                            paintScreen();
                            // makes sure that the monster is not on the tree and uses 
                            // the follow() method to follow the character
                            if(map[monster.getX()][monster.getY()] != 10 || map[monster.getX()][monster.getY()] != 11)
                            {
                                follow();
                            }
                            // constantly checks if the player is dead for every time the up key was pressed
                            dead();
                        }
                    }
                }
                else {
                    // if it was not inside the grid, the column location of the character stays the same
                    // YOUR CODE HERE:
                    charR = charR;
                    charC = charC;

                }
                // constantly checks if the player is dead for every time the up key was pressed
                dead();
            }
            // if the Left key was pressed
            if(keyLeft())
            {
                // making sure that the player is still in the grid
                if(inGrid())
                {
                    //checks to see if the next square which the character will move is walkable
                    if(walkable(charR,charC-1))
                    {
                        // if the square which the character moves on is under the tree except the middle of the tree
                        // the character will be invisible but is still moving
                        if(map[charR][charC-1] == 10 || map[charR][charC-1] == 11)
                        {
                            // draws the character when going left to not be seen
                            // (use none for symbol and the 'backgroundColor' for the color)
                            // YOUR CODE HERE:
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);
                            
                            // sets the current location to the last location
                            // and draw over where the player used to be 
                            // (erase last locations using NamedSymbol.none)
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;
                            charC--;
                            drawSymbol(lastCharR, lastCharC, NamedSymbol.none, backgroundColor);
                            drawSymbol(charR, charC, NamedSymbol.none, backgroundColor);
                            

                        }
                        else {
                            // sets the current location to the last location
                            // YOUR CODE HERE:
                            lastCharC = charC;
                            lastCharR = charR;
                            
                            // calls the handleFruit() and paintScreen() method to make sure 
                            // that when the fruit is touched it will disappear and when the 
                            // character moves to new location it will be drawn and the previous location is cleared.
                            handleFruit();
                            paintScreen();
                            // makes sure that the monster is not on the tree and uses 
                            // the follow() method to follow the character
                            if(map[monster.getX()][monster.getY()] != 10 || map[monster.getX()][monster.getY()] != 11)
                            {
                                follow();
                            }
                            // constantly checks if the player is dead for every time the up key was pressed
                            dead(); 
                        }
                    }
                }
                else {
                    // if it was not inside the grid, the column location of the character stays the same
                    // YOUR CODE HERE:
                    charR = charR;
                    charC = charC;
                   
                }
                // constantly checks if the player is dead for every time the up key was pressed
                dead();
            }
        }

        // increase the frameSinceMove
        frameSinceMove++;
    }
    /**
    * making sure that the player is still in the grid
    */
    public boolean inGrid()
    {
        // checks if the row of the player is inside the map and returns false if not 
       if(charR < 0 || charR > map.length-1)
        {
            return false;
        }
        // checks if the column of the player is inside the map and returns false if not
       if(charC < 0 || charC > map.length-1 )
        {
            return false;
        }
        // else returns true
        return true;
    }
    /**
    * The paintScreen method redraws the screen with updated positions of
    * the player and the fruit, if a the win condition is met, then paint the
    * win message on the screen.
    */
   public void paintScreen()
    {
        // draw over where the fruit and player used to be (erase last locations using NamedSymbol.none)
        // YOUR CODE HERE:
        drawSymbol(lastFruitR, lastFruitC, NamedSymbol.none, backgroundColor);
        drawSymbol(lastCharR, lastCharC, NamedSymbol.none, backgroundColor);
        
        // constantly sets the map to none symbol when the character moves 
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map.length; j++)
            {
                drawSymbol(i, j, NamedSymbol.none, backgroundColor);
            }
        }
        // draw the current positions of the fruit and the player
        // YOUR CODE HERE:
        drawSymbol(fruitR, fruitC, fruitChar, fruitColor);
        drawSymbol(charR, charC, character, charColor);
        // call paintScore (a method that will be completed below)
        // YOUR CODE HERE:
        paintScore(score);

         // if ending score is met, run the displayWin() method
        if(score >= WIN_NUM) {
            displayWin();
        }
    }
    /**
    * The walkable methods checks to make sure the square which the player will 
    * move to, can be moved( all numbers associated with the mountain or 
    * lake or the middle of the tree cannot be moved to)
    */
    public static boolean walkable(int row, int col)
    {
        // if the location of where the player will move is off the map, return false
        if(row < 0 || row > map.length - 1 || col < 0 || col > map[1].length - 1)
        {
            return false;
        }
        // if the location of where the player will move to is less than or greater than 0, returns false 
        if(map[row][col] < 10 && map[row][col] > 0)
        {
            return false;
        }
        // if not, return true
        return true;
    }
    /**
    * This method allows the Monster object to follow the player 
    */
    public void follow()
    {
        // calls the move() method inside the Monster class, 
        // which changes the row and column according to the distance between the player and monster
        monster.move(charR, charC);
        // draws the new coordinates of the monster after the move() method 
        // (use the getLastX(), getLastY(), getX(), and getY() method inside 
        // the Monster class to clear the monster and draw the monster's new coordinates)
        // YOUR CODE HERE:
        drawSymbol(monster.getLastX(), monster.getLastY(), NamedSymbol.none, backgroundColor);
        drawSymbol(monster.getX(), monster.getY(), monChar, monColor);
    }
    /**
    * The handleFruit() method moves the fruit after a set interval (number of frames) if it has
    * not been collected, checks if it has been collected, moves the fruit,
    * and adds to score if it has been collected
    */
    public void handleFruit(){
        // subtract from fruit lifetime
        fruitLife--;
        // if collected (overlapped), increment score, record current fruit location as 'lastFruitR' and 'lastFruitC',
        // move fruit to a new random position on map, and reset 'fruitLife'
        // use the previous fruit setting from the initialization to complete part of the coding
        // YOUR CODE HERE:
        if(overlap()) {
            score++;
            lastFruitR = fruitR;
            lastFruitC = fruitC;
            fruitR = randomGenerator.nextInt(map.length);
            fruitC = randomGenerator.nextInt(map.length -1); 
            fruitLife = 100;
        }
        
        // if the 'fruitLife' number of frames has passed, record current fruit location as lastFruitR and lastFruitC,
        // move fruit to a new random position, reset fruitLife
        // use the previous fruit setting from the initialization to complete part of the coding
        // YOUR CODE HERE:
        if(fruitLife == 0) {
            lastFruitR = fruitR;
            lastFruitC = fruitC;
            fruitR = randomGenerator.nextInt(map.length);
            fruitC = randomGenerator.nextInt(map.length -1); 
            fruitLife = 100;
        }
    }
    /**
    * The overlap() method checks if the fruit is collected (if the player and the
    * fruit are on the same spot on the board).
    * returns a boolean 
    */
    public boolean overlap()
    {
        // if the fruit is in the same spot as the player, return true, else return false
        // YOUR CODE HERE:
        if(charR == fruitR && charC == fruitC) {
            return true;
        }
        return false;
    }
    /**
     * The displayWin() method paints a win message
     * using the setBGColor() method 
    */
    public void displayWin() {
        // create a white board
        // YOUR CODE HERE:
        for(int i = 0; i < getBoardHeight(); i++) {
            for(int j = 0; j < getBoardWidth(); j++) {
             setBGColor(i,j,NamedColor.white);
            }
        }
    
        // Letter W
        setBGColor(10, 3, NamedColor.gold);
        setBGColor(11, 3, NamedColor.gold);
        setBGColor(12, 4, NamedColor.gold);
        setBGColor(13, 4, NamedColor.gold);
        setBGColor(14, 5, NamedColor.gold);
        setBGColor(15, 5, NamedColor.gold);
        setBGColor(16, 6, NamedColor.gold);
        setBGColor(15, 7, NamedColor.gold);
        setBGColor(14, 7, NamedColor.gold);
        setBGColor(13, 8, NamedColor.gold);
        setBGColor(14, 9, NamedColor.gold);
        setBGColor(15, 9, NamedColor.gold);
        setBGColor(16, 10, NamedColor.gold);
        setBGColor(15, 11, NamedColor.gold);
        setBGColor(14, 11, NamedColor.gold);
        setBGColor(13, 12, NamedColor.gold);
        setBGColor(12, 12, NamedColor.gold);
        setBGColor(11, 13, NamedColor.gold);
        setBGColor(10, 13, NamedColor.gold);

        //Letter I
        setBGColor(10, 15, NamedColor.gold);
        setBGColor(10, 16, NamedColor.gold);
        setBGColor(10, 17, NamedColor.gold);
        setBGColor(11, 16, NamedColor.gold);
        setBGColor(12, 16, NamedColor.gold);
        setBGColor(13, 16, NamedColor.gold);
        setBGColor(14, 16, NamedColor.gold);
        setBGColor(15, 16, NamedColor.gold);
        setBGColor(16, 16, NamedColor.gold);
        setBGColor(16, 15, NamedColor.gold);
        setBGColor(16, 17, NamedColor.gold);

        //Letter N
        setBGColor(10, 19, NamedColor.gold);
        setBGColor(11, 19, NamedColor.gold);
        setBGColor(12, 19, NamedColor.gold);
        setBGColor(13, 19, NamedColor.gold);
        setBGColor(14, 19, NamedColor.gold);
        setBGColor(15, 19, NamedColor.gold);
        setBGColor(16, 19, NamedColor.gold);
        setBGColor(11, 20, NamedColor.gold);
        setBGColor(12, 21, NamedColor.gold);
        setBGColor(13, 21, NamedColor.gold);
        setBGColor(14, 22, NamedColor.gold);
        setBGColor(15, 23, NamedColor.gold);
        setBGColor(16, 24, NamedColor.gold);
        setBGColor(15, 24, NamedColor.gold);
        setBGColor(14, 24, NamedColor.gold);
        setBGColor(13, 24, NamedColor.gold);
        setBGColor(12, 24, NamedColor.gold);
        setBGColor(11, 24, NamedColor.gold);
        setBGColor(10, 24, NamedColor.gold);
    }
    /**
     * the paintScore() method paints the score
     * using the alphabetic and numeric symbols
     */
    public void paintScore(int score){
        // use drawSymbol() to display the word, "score"
        // YOUR CODE HERE:
        
        drawSymbol(map.length - 1, 0, NamedSymbol.S, NamedColor.purple);
        drawSymbol(map.length - 1, 1, NamedSymbol.C, NamedColor.purple);
        drawSymbol(map.length - 1, 2, NamedSymbol.O, NamedColor.purple);
        drawSymbol(map.length - 1, 3, NamedSymbol.R, NamedColor.purple);
        drawSymbol(map.length - 1, 4, NamedSymbol.E, NamedColor.purple);
        // if-else statements to draw current score
        // for example:  drawSymbol(map.length - 1, 6, NamedSymbol.one, NamedColor.purple););
        // YOUR CODE HERE:
        if(score == 0)
            drawSymbol(map.length - 1, 6, NamedSymbol.zero, NamedColor.purple);
        else if(score == 1)
            drawSymbol(map.length - 1, 6, NamedSymbol.one, NamedColor.purple);
        else if(score == 2)
            drawSymbol(map.length - 1, 6, NamedSymbol.two, NamedColor.purple);
        else if(score == 3)
            drawSymbol(map.length - 1, 6, NamedSymbol.three, NamedColor.purple);
        else if(score == 4)
            drawSymbol(map.length - 1, 6, NamedSymbol.four, NamedColor.purple);
        else if(score == 5)
            drawSymbol(map.length - 1, 6, NamedSymbol.five, NamedColor.purple);
        else if(score == 6)
            drawSymbol(map.length - 1, 6, NamedSymbol.six, NamedColor.purple);
        else if(score == 7)
            drawSymbol(map.length - 1, 6, NamedSymbol.seven, NamedColor.purple);
        else if(score == 8)
            drawSymbol(map.length - 1, 6, NamedSymbol.eight, NamedColor.purple);
        else if(score == 9)
            drawSymbol(map.length - 1, 6, NamedSymbol.nine, NamedColor.purple);
    }
    /**
     * the dead() method determines if the monster is overlapping the player
    */
    public void dead()
    {
        // if the monster's row and col num equals the player's row and col num
        if(monster.getX() == charR && monster.getY() == charC)
        {
            // paints the whole background 
            for(int k = 0; k < map.length; k++)
            {
                for(int j = 0; j < map.length; j++)
                {
                    setBGColor(k, j, NamedColor.black);
                    
                }
            }
            // letter G
            setBGColor(7, 6, NamedColor.yellow);
            setBGColor(7, 5, NamedColor.yellow);
            setBGColor(7, 4, NamedColor.yellow);
            setBGColor(8, 3, NamedColor.yellow);
            setBGColor(9, 2, NamedColor.yellow);
            setBGColor(10, 2, NamedColor.yellow);
            setBGColor(11, 2, NamedColor.yellow);
            setBGColor(12, 3, NamedColor.yellow);
            setBGColor(13, 4, NamedColor.yellow);
            setBGColor(13, 5, NamedColor.yellow);
            setBGColor(13, 6, NamedColor.yellow);
            setBGColor(12, 6, NamedColor.yellow);
            setBGColor(11, 6, NamedColor.yellow);
            setBGColor(11, 5, NamedColor.yellow);
            // letter A
            setBGColor(13, 8, NamedColor.yellow);
            setBGColor(12, 8, NamedColor.yellow);
            setBGColor(11, 9, NamedColor.yellow);
            setBGColor(10, 9, NamedColor.yellow);
            setBGColor(9, 10, NamedColor.yellow);
            setBGColor(8, 10, NamedColor.yellow);
            setBGColor(7, 11, NamedColor.yellow);
            setBGColor(8, 12, NamedColor.yellow);
            setBGColor(9, 12, NamedColor.yellow);
            setBGColor(10, 13, NamedColor.yellow);
            setBGColor(11, 13, NamedColor.yellow);
            setBGColor(12, 14, NamedColor.yellow);
            setBGColor(13, 14, NamedColor.yellow);
            setBGColor(10, 10, NamedColor.yellow);
            setBGColor(10, 11, NamedColor.yellow);
            setBGColor(10, 12, NamedColor.yellow);
            // letter M
            setBGColor(13, 16, NamedColor.yellow);
            setBGColor(12, 16, NamedColor.yellow);
            setBGColor(11, 16, NamedColor.yellow);
            setBGColor(10, 16, NamedColor.yellow);
            setBGColor(9, 16, NamedColor.yellow);
            setBGColor(8, 16, NamedColor.yellow);
            setBGColor(7, 16, NamedColor.yellow);
            setBGColor(8, 17, NamedColor.yellow);
            setBGColor(9, 18, NamedColor.yellow);
            setBGColor(10, 19, NamedColor.yellow);
            setBGColor(9, 20, NamedColor.yellow);
            setBGColor(8, 21, NamedColor.yellow);
            setBGColor(7, 22, NamedColor.yellow);
            setBGColor(8, 22, NamedColor.yellow);
            setBGColor(9, 22, NamedColor.yellow);
            setBGColor(10, 22, NamedColor.yellow);
            setBGColor(11, 22, NamedColor.yellow);
            setBGColor(12, 22, NamedColor.yellow);
            setBGColor(13, 22, NamedColor.yellow);
            //letter E
            setBGColor(13, 24, NamedColor.yellow);
            setBGColor(12, 24, NamedColor.yellow);
            setBGColor(11, 24, NamedColor.yellow);
            setBGColor(10, 24, NamedColor.yellow);
            setBGColor(9, 24, NamedColor.yellow);
            setBGColor(8, 24, NamedColor.yellow);
            setBGColor(7, 24, NamedColor.yellow);
            setBGColor(13, 25, NamedColor.yellow);
            setBGColor(13, 26, NamedColor.yellow);
            setBGColor(13, 27, NamedColor.yellow);
            setBGColor(7, 25, NamedColor.yellow);
            setBGColor(7, 26, NamedColor.yellow);
            setBGColor(7, 26, NamedColor.yellow);
            setBGColor(10, 25, NamedColor.yellow);
            setBGColor(10, 26, NamedColor.yellow);
            setBGColor(7, 27, NamedColor.yellow);
            //letter O
            setBGColor(15, 4, NamedColor.yellow);
            setBGColor(15, 5, NamedColor.yellow);
            setBGColor(15, 6, NamedColor.yellow);
            setBGColor(16, 3, NamedColor.yellow);
            setBGColor(17, 2, NamedColor.yellow);
            setBGColor(18, 2, NamedColor.yellow);
            setBGColor(19, 2, NamedColor.yellow);
            setBGColor(20, 3, NamedColor.yellow);
            setBGColor(21, 4, NamedColor.yellow);
            setBGColor(21, 5, NamedColor.yellow);
            setBGColor(21, 6, NamedColor.yellow);
            setBGColor(18, 8, NamedColor.yellow);
            setBGColor(19, 8, NamedColor.yellow);
            setBGColor(20, 7, NamedColor.yellow);
            setBGColor(17, 8, NamedColor.yellow);
            setBGColor(16, 7, NamedColor.yellow);

            //letter V
            setBGColor(15, 10, NamedColor.yellow);
            setBGColor(16, 10, NamedColor.yellow);
            setBGColor(17, 10, NamedColor.yellow);
            setBGColor(18, 11, NamedColor.yellow);
            setBGColor(19, 11, NamedColor.yellow);
            setBGColor(20, 11, NamedColor.yellow);
            setBGColor(21, 12, NamedColor.yellow);
            setBGColor(20, 13, NamedColor.yellow);
            setBGColor(19, 13, NamedColor.yellow);
            setBGColor(18, 13, NamedColor.yellow);
            setBGColor(17, 14, NamedColor.yellow);
            setBGColor(16, 14, NamedColor.yellow);
            setBGColor(15, 14, NamedColor.yellow);
            setBGColor(16, 21, NamedColor.yellow);

            //letter E
            setBGColor(15, 16, NamedColor.yellow);
            setBGColor(16, 16, NamedColor.yellow);
            setBGColor(17, 16, NamedColor.yellow);
            setBGColor(18, 16, NamedColor.yellow);
            setBGColor(19, 16, NamedColor.yellow);
            setBGColor(20, 16, NamedColor.yellow);
            setBGColor(21, 16, NamedColor.yellow);
            setBGColor(15, 17, NamedColor.yellow);
            setBGColor(15, 18, NamedColor.yellow);
            setBGColor(15, 19, NamedColor.yellow);
            setBGColor(18, 17, NamedColor.yellow);
            setBGColor(18, 18, NamedColor.yellow);
            setBGColor(21, 17, NamedColor.yellow);
            setBGColor(21, 18, NamedColor.yellow);
            setBGColor(21, 19, NamedColor.yellow);
            //letter R
            setBGColor(15, 21, NamedColor.yellow);
            setBGColor(16, 21, NamedColor.yellow);
            setBGColor(17, 21, NamedColor.yellow);
            setBGColor(18, 21, NamedColor.yellow);
            setBGColor(19, 21, NamedColor.yellow);
            setBGColor(20, 21, NamedColor.yellow);
            setBGColor(21, 21, NamedColor.yellow);
            setBGColor(15, 22, NamedColor.yellow);
            setBGColor(15, 23, NamedColor.yellow);
            setBGColor(16, 24, NamedColor.yellow);
            setBGColor(17, 24, NamedColor.yellow);
            setBGColor(18, 22, NamedColor.yellow);
            setBGColor(18, 23, NamedColor.yellow);
            setBGColor(19, 24, NamedColor.yellow);
            setBGColor(20, 24, NamedColor.yellow);
            setBGColor(21, 24, NamedColor.yellow);
        }
    }
}