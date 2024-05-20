import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

import bridges.base.*;
import bridges.connect.Bridges;
import bridges.validation.InvalidValueException;
import bridges.validation.RateLimitException;

public class Interpreter {
    public static void main(String[] args) throws IOException, RateLimitException {
        try {
            //get the first command-line argument and use it to create an Interpreter object called 'interpreter'
            //YOUR CODE HERE:

            //remember to fill in your own assignment number, username, and API key
            Bridges bridges = new Bridges(0, "calexandre1", "419249051969");
            bridges.setTitle(interpreter.getTitle());
            bridges.setDescription(interpreter.getDescription());
            bridges.setDataStructure(interpreter.getPicture());
            bridges.visualize();
        }

        //if there are no command-line arguments, the program will throw an ArrayIndexOutOfBoundsException
        //create a 'catch' block that prints an error message
        //YOUR CODE HERE:
    }

    //the title and description of the picture are 'Title' and 'Description' by default
    //you can change these values with the 'title' and 'description' commands
    private String imageTitle = "Title";
    private String imageDescription = "Description";

    //list of shapes to draw
    //you can add new shapes with the 'rectangle', 'square', 'circle', 'triangle', and 'line' commands
    private ArrayList<Symbol> shapes = new ArrayList<>();

    //the color of the shapes is black by default
    //you can change this value with the 'color' command
    private String fillColor = "black";

    //the program in our mini-language, split by whitespace
    private String[] words;

    private Interpreter(String path) {
        //read the file and interpret the first command
        readFile(path);
        interpretCommand(0);
    }

    private void readFile(String path) {
        try(Scanner reader = new Scanner(new FileReader(path))) {
            //create a StringBuilder object
            //YOUR CODE HERE:

            while(reader.hasNext()) {
                //get the next line of the file and figure out if it is a comment
                String line = reader.nextLine();
                boolean isComment = line.trim().startsWith("//");

                //if the line is not a comment, append it to the StringBuilder, followed by a newline character
                //YOUR CODE HERE:
            }

            //convert the StringBuilder into a string, trim it, and split it by whitespace
            //assign the result to the instance variable 'words'
            //YOUR CODE HERE:
        }

        //if the argument to this method isn't a real file, a FileNotFoundException will be thrown
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:
    }

    private void interpretCommand(int index) {
        //if the index is out of bounds for the 'words' array, the interpreter has finished
        //stop the execution of the method with a 'return' statement if this is the case
        //YOUR CODE HERE:

        //figure out what command it is and call the associated method
        switch(words[index]) {
            case "rectangle": rectangleCommand(index); return;
            case "square": squareCommand(index); return;
            case "circle": circleCommand(index); return;

            //add cases for the other five commands
            //YOUR CODE HERE:
        }

        //at this point in the method, we know that the command is not valid
        //if it were a valid command, the execution of the method would have ended by now
        //print an error message and stop the program
        //YOUR CODE HERE:
    }

    private void rectangleCommand(int index) {
        try {
            //parse the next four values into numbers
            float x = Float.parseFloat(words[index + 1]);
            float y = Float.parseFloat(words[index + 2]);
            float width = Float.parseFloat(words[index + 3]);
            float height = Float.parseFloat(words[index + 4]);

            //create a Rectangle object with the appropriate dimensions
            //use 'x - width / 2' and 'y - height / 2' instead of 'x' and 'y' so that the rectangle is centered
            //set its color to 'fillColor'
            //add it to the list of shapes
            shapes.add(new Rectangle(x - width / 2, y - height / 2, width, height).setFillColor(fillColor));

            //interpret the next command
            //it should be located at 'index + 5' because the 'rectangle' command takes four arguments
            interpretCommand(index + 5);
        }

        //if the 'rectangle' commmand is not given enough arguments, an ArrayIndexOutOfBounds exception will be thrown
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:

        //the 'parseFloat' method throws a NumberFormatException if it fails to convert a string into a number
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:

        //the 'setFillColor' method throws an InvalidValueException if the argument is not a valid color
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:
    }

    private void squareCommand(int index) {
        try {
            //parse the next three values into numbers
            float x = Float.parseFloat(words[index + 1]);
            float y = Float.parseFloat(words[index + 2]);
            float size = Float.parseFloat(words[index + 3]);

            //use 'x - size / 2' and 'y - size / 2' instead of 'x' and 'y' so that the square is centered
            //set its color to 'fillColor'
            //add it to the list of shapes
            shapes.add(new Rectangle(x - size / 2, y - size / 2, size, size).setFillColor(fillColor));

            //interpret the next command
            //it should be located at 'index + 4' because the 'square' command takes three arguments
            interpretCommand(index + 4);
        }

        //if the 'square' commmand is not given enough arguments, an ArrayIndexOutOfBounds exception will be thrown
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:

        //the 'parseFloat' method throws a NumberFormatException if it fails to convert a string into a number
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:

        //the 'setFillColor' method throws an InvalidValueException if the argument is not a valid color
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:
    }

    //create a method called 'circleCommand'
    //remember that the 'circle' command in our mini-language takes three arguments: x, y, and radius
    //also, you don't need to worry about centering the shape, because BRIDGES already centers circles
    //YOUR CODE HERE:

    //create a method called 'triangleCommand'
    //remember that the 'triangle' command in our mini-language takes six arguments: x1, y1, x2, y2, x3, and y3
    //you can make an ArrayList of vertices in one line with the Arrays.asList method
    //YOUR CODE HERE:

    //create a method called 'lineCommand'
    //remember that the 'line' command in our mini-language takes five arguments: x1, y1, x2, y2, and width
    //you can create an ArrayList of endpoints in one line with the Arrays.asList method
    //YOUR CODE HERE:

    private void colorCommand(int index) {
        try {
            //set the instance variable 'fillColor' to the next word in the file (located at index + 1)
            //YOUR CODE HERE:

            //interpret the next command in the file (located at index + 2)
            //YOUR CODE HERE:
        }

        //if the 'color' commmand is not given enough arguments, an ArrayIndexOutOfBounds exception will be thrown
        //create a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:
    }

    private void titleCommand(int index) {
        //create a new StringBuilder object called 'title'
        //YOUR CODE HERE:

        //use the 'buildText' method (defined below) to get all of the text enclosed in brackets
        int i = buildText(title, index + 1, "title");

        //convert the StringBuilder into a String and store the result in the instance variable 'imageTitle'
        //YOUR CODE HERE:

        //interpret the next command
        interpretCommand(i + 1);
    }

    //create a method called 'descriptionCommand' similar to the 'titleCommand' method above
    //YOUR CODE HERE:

    //this method parses a series of words enclosed in square brackets starting at the index 'i'
    //it adds the words to the StringBuilder, and returns the index of the last word
    private int buildText(StringBuilder text, int i, String commandName) {
        try {
            //if the word at index 'i' starts with '[' and ends with ']', add the interior of the word to the StringBuilder
            //fill in the missing condition
            if(CONDITION) {
                text.append(words[i], 1, words[i].length() - 1);
            }

            //if the word at index 'i' starts with '[' but doesn't end with ']', continue to add words via a while loop
            //fill in the missing condition
            else if(CONDITION) {
                text.append(words[i], 1, words[i].length());
                while(true) {
                    i++;
                    text.append(" ");

                    //if the word at index 'i' ends with ']', break out of the loop
                    //fill in the missing condition
                    if(CONDITION) {
                        text.append(words[i], 0, words[i].length() - 1);
                        break;
                    }
                    else {
                        text.append(words[i]);
                    }
                }
            }

            //if the first word doesn't begin with a square bracket, the user has committed a syntax error
            //create an 'else' block that prints an error message and stops the program
            //you can use the variable 'commandName' to make the error message more descriptive
            //YOUR CODE HERE:
        }

        //if there is no closing bracket, the interpreter will throw an ArrayIndexOutOfBoundsException
        //write a 'catch' block that prints an error message and stops the program
        //YOUR CODE HERE:

        return i;
    }

    //make two getter methods called 'getTitle' and 'getDescription'
    //YOUR CODE HERE:

    private SymbolCollection getPicture() {
        //create a SymbolCollection object
        //loop through each element of 'shapes' and add it to the SymbolCollection
        //return the SymbolCollection
        //YOUR CODE HERE:
    }
}