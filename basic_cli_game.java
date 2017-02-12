
import java.util.Scanner;

/*
 * This Class moves a sprite around a "map", using user input
 * For the controls and a command line style interface.
 */

/*
 * @author Christopher Muench
 */
public class basic_cli_game 
{
    //Initialize row and column constant
    private final static int ROW = 10;
    private final static int COLUMN = 20; 
    
    //Main function containing main loop
    public static void main(String[] args)
    {
        //initialization of necessary variables
        Scanner userInput = new Scanner(System.in);
        char[][] dotMap; 
        char[][] displayBuffer = new char[ROW][COLUMN];
        int[] playerCoords = {0,0};
        char inputChar = '*';
        
        //function call to map filling method
        //only called once in program to populate map matrix
        dotMap = fillMap();
        
        //main loop - executes while user still playing
        do
        {
         //copy map into display buffer
         displayBuffer = mapToBuffer(dotMap,displayBuffer);
         
         //place player character at new Player Coordinates(playerCoords)
         displayBuffer[playerCoords[0]][playerCoords[1]] = '@';
         
         //render display to the player
         renderDisplay(displayBuffer);
         
         //get next input from the player
         inputChar = getInput(inputChar,userInput);
         
         //determine new coords or next action from input
         playerCoords = getCoords(playerCoords,inputChar);
            
        //condition to break out of main game loop    
        }while(inputChar != 'q');
    }
    
    //function definition of fillMap()
    public static char[][] fillMap()
    {   
        //initialize dotMap and fill it with dots
        char[][] dotMap = new char[ROW][COLUMN];
        for(int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COLUMN; j++)
            {
                dotMap[i][j] = '.';
            }
        }
        return dotMap;
    }
    
    //function definition of mapToBuffer(2d char array, 2d char array)
    public static char[][] mapToBuffer(char[][] dotMap,char[][] displayBuffer)
    {
        //manually copy values from dotMap to displayBuffer
        for(int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COLUMN; j++)
            {
                displayBuffer[i][j] = dotMap[i][j];
            }
        }
        return displayBuffer;
    }
    
    //function definition of renderDisplay(2d char array)
    public static void renderDisplay(char[][] displayBuffer)
    {
        //nested loops to print out the map with the players sprite on it
        //at the approprite coordinates
        for (int i = 0; i < ROW; i++)
        {
            System.out.println();
            for (int j = 0; j < COLUMN; j++)
            {
                System.out.print(displayBuffer[i][j]);
            }
        }
    }
    
    //function definition of getInput(char, scanner)
    public static char getInput(char inputChar,Scanner userInput)
    {
        //get input of next move user would like to make
        System.out.println("\nPlease enter your move (or enter 'q' to quit): ");
        inputChar = userInput.next().charAt(0);
        return inputChar;
    }
    
    //function definition of getCoords(int array, char)
    public static int[] getCoords(int[] playerCoords, char inputChar)
    {   
        //switch statement to determine what should be done based on users input
        switch (inputChar)
        {
            //if 'w' check boundaries and move sprite if able
            case 'w':
                if (playerCoords[0] > 0)
                {
                    playerCoords[0] = playerCoords[0] - 1;
                    break;
                }
                else
                {
                    break;
                }
              
            //if 'a' check boundaries and move sprite if able   
            case 'a':
                if (playerCoords[1] > 0)
                {
                    playerCoords[1] = playerCoords[1] - 1;
                    break;
                }
                else
                {
                    break;
                }
              
            //if 's' check boundaries and move sprite if able    
            case 's':
                if (playerCoords[0] < ROW - 1)
                {
                    playerCoords[0] = playerCoords[0] + 1;
                    break;
                }
                else
                {
                    break;
                }
            
            //if 'd' check boundaries and move sprite if able    
            case 'd':
                if (playerCoords[1] < COLUMN - 1)
                {
                    playerCoords[1] = playerCoords[1] + 1;
                    break;
                }
                else
                {
                    break;
                }
              
            //if 'q' thank user for playing and break out of selection phase    
            case 'q':
                System.out.println("\nThanks for playing!");
                break;
                
            // if any other input, inform user of 
            //invalid input and abort execution    
            default:
                System.out.println("NOT A VALID MOVE. EXITING GAME.");
                System.exit(1);
        }
        //return new coordinates
        return playerCoords;
    }  
}