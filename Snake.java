import java.util.ArrayList;

public class Snake {
    //direction the snake is moving in
    //either "up", "down", "left", or "right"
    private String direction;

    //row and column numbers of the snake
    private ArrayList<Integer> rows;
    private ArrayList<Integer> cols;

    //Snake constructor
    //takes three arguments: a starting direction, and a starting row and column
    public Snake(String startingDirection, int startingRow, int startingCol) {
        direction = startingDirection;
        
        //set the variables 'rows' and 'cols' to empty arraylists
        //YOUR CODE HERE:
        rows = new ArrayList<Integer>();
        cols = new ArrayList<Integer>();
        //add starting row and column to 'rows' and 'cols' respectively
        //YOUR CODE HERE:
        rows.add(0);
        cols.add(0);
    }

    //set the snake's direction
    public void setDirection(String newDirection) {
        //calculate the direction opposite the one the snake is moving in
        //store it in a String variable
        //YOUR CODE HERE:
        String opposite;
        if(newDirection.equals("up"))
            opposite = "down";
        else if(newDirection.equals("down"))
            opposite = "up";
        else if(newDirection.equals("right"))
            opposite = "left";
        else if(newDirection.equals("left"))
            opposite = "right";
        //set 'direction' to 'newDirection', unless the opposite of 'direction' is equal to 'newDirection'
        //this condition keeps the snake from turning back on itself
        //YOUR CODE HERE:
        if(!newDirection.equals(opposite))
            direction = newDirection;
    }

    //create a method called getSize, which returns the size of the snake
    //you can use either 'rows' or 'cols' to calculate the size, it doesn't matter
    //YOUR CODE HERE:

    //create a method called getRow, which takes an integer 'i'
    //and returns the row number at position 'i' along the snake
    //YOUR CODE HERE:

    //create a method called getCol, which takes an integer 'i'
    //and returns the column number at position 'i' along the snake
    //YOUR CODE HERE:

    //if the snake is about to crash into the other snake or go off the game board, return 'true'
    //otherwise, move the snake forward and return 'false'
    public boolean move(Snake otherSnake, int height, int width) {
        //create two variables called 'rowChange' and 'colChange' based on the snake's direction
        //for example, if the snake is moving up, 'rowChange' should be -1 and 'colChange' should be 0
        //YOUR CODE HERE:

        //create a variable called 'newRow' which equals the last row number plus 'rowChange'
        //create a variable called 'newCol' which equals the last column number plus 'colChange'
        //YOUR CODE HERE:

        //if the point [newRow, newCol] is already in the snake, return 'true'
        //moving forward would cause the snake to crash into itself!
        //YOUR CODE HERE:

        //if the point [newRow, newCol] is in the other snake, return 'true'
        //moving forward would cause the snake to crash into its opponent!
        //YOUR CODE HERE:

        //if the point [newRow, newCol] is out of bounds, return 'true'
        //moving forward would cause the snake to go off the screen!
        //YOUR CODE HERE:

        //add 'newRow' and 'newCol' to 'rows' and 'cols' respectively
        //YOUR CODE HERE:

        return false;
    }
}