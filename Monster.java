import bridges.games.*;
import bridges.base.*;

public class Monster
{
    public static int row; // row location of the monster
    public static int col; // column location of the monster
    public static int lastRow; // the last row location of the monster 
    public static int lastCol; // the last column location of the monster
    // 2d arraylist for the Map 
    private static int[][] map;
    // slows the rate at which the monster moves 
    static int framePerMove = 2;
    static int frameSinceMove = 0;
    // direction which the monster will be moving towards 
    private static String direction;
    // constructor
    public Monster(int row, int col)
    {
        // setting row to row, col to col
        this.row = row; 
        this.col = col;
        // sets map to the map from the Map clas
        map = Map.map;
    }
    /**
    * the move() method sets the direction, calculates the 
    * distance and moves if less than 10
    */
    public static void move(int charR, int charC)
    {
        // if the row of the monster is less than the player,
        // direction is set to "down"
        if(row < GameRunner.charR)
        {
            direction = "down";
        }
        // if the row of the monster is greater than the player, 
        // direction is set to "up"
        if(row > GameRunner.charR)
        {
            direction = "up";
        }
        // if the col of the monster is less than the player,
        // direction is set to "right"
        if(col < GameRunner.charC)
        {
            direction = "right";
        }
        // if the col of the monster is greater than the player, 
        // direction is set to "left"
        if(col > GameRunner.charC)
        {
            direction = "left";
        }
        // Use the distance formula to determine the distance between the monster and player
        // see worksheet to remind yourself of the distance formula 
        // assign the distance to a variable of type double named 'distance'
        // YOUR CODE HERE:
        double distance = Math.sqrt(Math.pow(row-charR,2) + Math.pow(col-charC,2));
        
        // if the distance between player and monster is less than 10,
        // the monster moves closer to the player by one
        if(distance < 10)
        {
            // lowers the players speed based on frames
            if(frameSinceMove % framePerMove == 0)
            {
                // if direction equals "right"
                if(direction.equals("right"))
                {
                    // calls the walkbale() method to check if the 
                    // new location of the monster is walkable based on the walkable() method 
                    if(GameRunner.walkable(row,col+1))
                    {
                        // if moving into a coordinate with the numbers 10 or 11
                        // moves the location of the monster back to where it was 
                        if(map[row][col+1] == 10 || map[row][col+1] == 11)
                        {
                            col = col;
                            row = row;
                        }
                        // else sets the new coordinate to the current location
                        else {
                            lastCol = col;
                            col = col+1;
                        }
                    }
                }
                // if direction equals "left"
                if(direction.equals("left"))
                {
                    // calls the walkbale() method to check if the 
                    // new location of the monster is walkable based on the walkable() method 
                    if(GameRunner.walkable(row, col-1))
                    {
                        // if moving into a coordinate with the numbers 10 or 11
                        // moves the location of the monster back to where it was 
                        if(map[row][col-1] == 10 || map[row][col-1] == 11)
                        {
                           col = col;
                           row = row;
                        }
                        // else sets the new coordinate to the current location
                        else {
                            lastCol = col;
                            col = col-1;
                        }
                    }
                }
                // if direction equals "up"
                if(direction.equals("up"))
                {
                    // calls the walkbale() method to check if the 
                    // new location of the monster is walkable based on the walkable() method 
                    if(GameRunner.walkable(row-1, col))
                    {
                        if(map[row-1][col] == 10 || map[row-1][col] == 11)
                        {
                            row = row;
                            col = col;
                        }
                        // else sets the new coordinate to the current location
                        else {
                            lastRow = row;
                            row = row-1;
                        }
                    }
                }
                // if direction equals "down"
                if(direction.equals("down"))
                {
                    // calls the walkbale() method to check if the 
                    // new location of the monster is walkable based on the walkable() method 
                    if(GameRunner.walkable(row+1, col))
                    {
                        if(map[row+1][col] == 10 || map[row+1][col] == 11)
                        {
                            row = row;
                            col = col;
                        }
                        // else sets the new coordinate to the current location
                        else {
                            lastRow = row;
                            row = row+1;
                        }
                    }
                }
            }
            // increases the 'frameSinceMove'
            frameSinceMove++;
        }

    }
    // get method for the row 
    public int getX()
    {
        // returns the 'row' num
        return row;
    }
    // get method for the column
    public int getY()
    {
        // returns the 'col' num
        return col;
    }    
    // get method for the last row 
    public int getLastX()
    {
        // returns the 'lastRow' num
        return lastRow;
    }
    // get method for the last column
    public int getLastY()
    {
        // returns the 'lastCol' num
        return lastCol;
    }

}