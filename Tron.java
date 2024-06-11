//Caleb alexandre 
//AP CSA Final Project
import bridges.base.NamedColor;
import bridges.games.NonBlockingGame;

public class Tron extends NonBlockingGame {
    public static void main(String[] args) {
        //create Tron object
        //remember to fill in your own assignment number, username, and api key
        Tron game = new Tron(0, "calexandre1", "419249051969", 32, 32);

        //start game
        game.start();
    }

    private Tron(int assignmentNumber, String username, String apiKey, int numRows, int numCols) {
        super(assignmentNumber, username, apiKey, numRows, numCols);

        //set game title and description
        //YOUR CODE HERE:
        setTitle("Tron");
        setDescription("AP CSA Caleb Alexandre 2024");
    }

    //Snake objects representing the two players
    private Snake snake1;
    private Snake snake2;

    //color of first and second snake respectively
    private NamedColor color1;
    private NamedColor color2;

    //starts at 0 and increments by 1 each frame
    private int frame;

    //is the game currently running?
    private boolean game;

    //this method is called every time the game restarts
    public void initialize() {
        //assign 'snake1' and 'snake2' to new Snake objects
        //snake1 should be in the top left corner moving right
        //snake2 should be in the bottom right corner moving left
        //YOUR CODE HERE:
        snake1 = new Snake("right", 0, 0);
        snake2 = new Snake("left", 31, 31);

        //assign 'color1' and 'color2' to whatever you want
        //YOUR CODE HERE:
        color1 = NamedColor.red;
        color2 = NamedColor.aquamarine;

        frame = 0;
        game = true;

        //draw the background by setting the color of every square on the board
        //YOUR CODE HERE:
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < 32; j++) {
                setBGColor(i, j, NamedColor.black);
            }
        }
    }

    //this method is called once per frame
    public void gameLoop() {
        //check if the game is currently running and the frame number is even
        //having this code only run every two frames keeps the snakes from moving too fast
        if(game && frame % 2 == 0) {
            //set the direction of 'snake1' to "up" if the W key is pressed
            //repeat for the S, A, and D keys
            //YOUR CODE HERE:
            if (keyW()) snake1.setDirection("up");
            if (keyS()) snake1.setDirection("down");
            if (keyA()) snake1.setDirection("left");
            if (keyD()) snake1.setDirection("right");

            if (keyUp()) snake2.setDirection("up");
            if (keyDown()) snake2.setDirection("down");
            if (keyLeft()) snake2.setDirection("left");
            if (keyRight()) snake2.setDirection("right");
            //what is the type of these variables?
            boolean dead1 = snake1.move(snake2, getBoardHeight(), getBoardWidth());
            boolean dead2 = snake2.move(snake1, getBoardHeight(), getBoardWidth());

            if(dead1) {
                //stop the game and change 'color2' to the winning color
                //YOUR CODE HERE:
                color2 = NamedColor.yellow;
                color1 = NamedColor.gray;
                game = false;
                for(int i = 0; i < snake1.getSize(); i++) {
                    setBGColor(snake1.getRow(i), snake1.getCol(i), color1);
                }
                for(int i = 0; i < snake2.getSize(); i++) {
                    setBGColor(snake2.getRow(i), snake2.getCol(i), color2);
                }
            }
            if(dead2) {
                //stop the game and change 'color1' to the winning color
                //YOUR CODE HERE:
                color1 = NamedColor.yellow;
                color2 = NamedColor.gray;
                game = false;
                for(int i = 0; i < snake1.getSize(); i++) {
                    setBGColor(snake1.getRow(i), snake1.getCol(i), color1);
                }
                for(int i = 0; i < snake2.getSize(); i++) {
                    setBGColor(snake2.getRow(i), snake2.getCol(i), color2);
                }

            }
        }

        //if the game is not running and the space key is pressed, restart the game
        else if(keySpaceJustPressed()) {
            initialize();
        }

        //set every square in 'snake1' to 'color1'
        //YOUR CODE HERE:
        setBGColor(snake1.getRow(snake1.getSize()-1), snake1.getCol(snake1.getSize()-1), color1);

        //set every square in 'snake2' to 'color2'
        //YOUR CODE HERE:
        setBGColor(snake2.getRow(snake2.getSize()-1), snake2.getCol(snake2.getSize()-1), color2);


        //increment the frame number
        frame += 1;
    }
}