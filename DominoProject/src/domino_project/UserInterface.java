
package domino_project;

import java.util.Scanner;

/**
 * This class represents the interaction between 
 * the user and the console.(Its not used for the GUI
 * edition in the second part of the project).
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class UserInterface {

   private static Scanner input = new Scanner(System.in);

   /**
    * Class Constructor.
    */
     public UserInterface() {
        //input=new Scanner(System.in);
    }
     /**
      * Asks for reverse of tile.
      * @return true if tile to be reversed, otherwise false.
      */
    static public boolean askForReverse() {
        System.out.println(" Reversed? (YES=1/NO=0)");
        
        int choice = input.nextInt();
        while (choice != 1 && choice != 0) {
            System.out.println("Wrong input");
            System.out.println(" Reversed? (YES=1/NO=0)");
            choice = input.nextInt();
        }
        return choice==1;
        
    }

   
/**
 * Shows tile.(e.g. [4|4])
 * @param tile , a tile
 */
    public void showTile(Tile tile) {
        System.out.print("[" + tile.getT1() + "|" + tile.getT2() + "]");
    }
    /**
     * Shows the tiles of a specified SetOfTiles.(set)
     *
     * @param set a SetOfTiles to be shown.
     */
    public void showSetOfTiles(SetOfTiles set) {
        for (int i = 0; i < set.getSize(); i++) {
            showTile(set.getTileByIndex(i));
        }
    }
 /**
     * Shows the tiles of a specified PanelOfTiles.(panel)
     *
     * @param panel a PanelOfTiles to be shown.
     */
    public void showPanel(PanelOfTiles panel) {
        for (int i = 0; i < panel.getNumberOfRows(); i++) {
            System.out.print((i + 1) + ". ");
            showSetOfTiles(panel.getSetOfRow(i));
            System.out.println();
        }
    }
/**
     * Creates n empty lines.
     *
     * @param n number of empty lines
     */
    public void createWhiteSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }
/**
     * Reads an integer representing the row that a player wants to pick a Tile
     * from. This carries on till valid input.
     *
     * @return the row of which the tile that the user chose will be played.
     */
    public int readTileFromPanel() {
        System.out.println("You can pick a Tile.Give the number of its row (1-4)");

        int choice = input.nextInt();
        while (!(choice > 0 && choice < 5)) {

            showInvalidInput();
            System.out.println("You can pick a Tile.Give the number of its row (1-4)");
            choice = input.nextInt();
        }
        return choice - 1;
    }
/**
     * Shows invalidInput to User.
     */
    public void showInvalidInput() {
        System.out.println("Invalid input , please try again ");
    }
/**
     * This is a static method. Reads from user an integer representing the
     * position(beggining or end) that they want to put the tile at(tile fits on
     * beggining and at the end of this DominoLine).
     *
     * @return 1 put tile ot the beggining of this DominoLine 2 put tile at the
     * end of this DominoLine
     */
    public static int giveChoice() {

        System.out.println("Pick the side you want to place your Tile(1 or 2).");
        System.out.println("1.On the beggining ");
        System.out.println("2.On the end ");
        int choice = input.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Pick the side you want to place your Tile(1 or 2).");
            System.out.println("1.On the beggining ");
            System.out.println("2.On the end ");
            choice = input.nextInt();
        }
        return choice;

    }
/**
     * * Selects the Tile that the player wants to play.
     * 
     * @return an integer representing the Tile that the player wants to play
     */
    public int readFromHand() {
        System.out.println();
        System.out.println("Pick the Tile you want to play");
        int pos = input.nextInt();
        return pos;
    }
 /**
     * Shows the current tiles that the player has on their hand.
     *
     * @param hand a SetOfTiles representing the player's tiles that has to
     * play.
     */
    public void showHand(SetOfTiles hand) {
        for (int i = 0; i < hand.getSize(); i++) {
            System.out.print(" " + i + ")");
            this.showTile(hand.getTileByIndex(i));
        }
    }
/**
     * Shows which player is playing.
     * Bot is called Player 0.
     *
     * @param p an intenger representing a player e.g Player 1
     */
    public void playerIsPlaying(String p) {
        System.out.println("Player " + p + " is playing:");
    }
/**
     * Shows the tiles of a specified DominoLine.(line)
     *
     * @param line DominoLine to be shown
     */
    public void showLine(DominoLine line) {
        createWhiteSpaces(1);
        System.out.println("Line:");
        this.showSetOfTiles(line.getSetOfTiles());
    }
    /**
     * Shows the amount of tiles left in stack.
     * @param ammount the amount of tiles left in stack.
     */
    public void showCloseSet(int ammount){
        createWhiteSpaces(1);
        System.out.println("Stack : |"+ammount+"|");
    }
    /**
     * Shows who took tile from set.
     * @param name who took tile from set.
     */
     public void selectFromSet(String name){
        System.out.println(name+" : took tile from set");
    }
    /**
     * Shows "NEW ROUND".
     */
    public void newRound() {
        System.out.println("NEW ROUND");
    }
/**
     * Shows the points that a player has collected.
     *
     * @param player an integer representing a player
     * @param points the points he has
     */
    public void showPoints(String player, int points) {
        System.out.println("Player " + player + " : " + points + " points");
    }
    /**
     * Welcome users to a Multiplayer type of DominoGame.
     * @param game a Multiplayer type of DominoGame.
     */
    public void welcome(MultiplayerGame game){
        if(game instanceof HungarianGame){
            welcomeToHungarianGame();
        }
        if(game instanceof CardinalGame){
            welcomeToCardinalGame();
        }
    }
    /**
     * Welcomes users to Solo1 type of DominoGame.
     */
    public void welcomeToSolo1() {
        System.out.println("Welcome to SOLO1 type of DominoGame.");
        System.out.println("Enjoy the game and have fun!!");
        this.createWhiteSpaces(2);
    }
/**
     * Welcomes users to Hungarian type of DominoGame.
     */
    private void welcomeToHungarianGame() {
        System.out.println("Welcome to HUNGARIAN type of DominoGame.");
        System.out.println("Enjoy the game and have fun!!");
        this.createWhiteSpaces(1);
    }
    /**
     * Welcomes users to Cardinal type of DominoGame.
     */
    private void welcomeToCardinalGame(){
        System.out.println("Welcome to CARDINAL type of DominoGame.");
        System.out.println("Enjoy the game and have fun!!");
        this.createWhiteSpaces(1);
    }
/**
     * Shows main menu and returns the type of DominoGame 
     * user wants to play(as an integer).
     *
     * @return 1 for Solo1,2 for Hungarian,3 for Cardinal
     */
    public static int pickDominoTypeToPlay() {
        System.out.println("Choose a type of DominoGame to play.");
        System.out.println("1.Solo1");
        System.out.println("2.Hungarian");
        System.out.println("3.Cardinal");
        int choice = input.nextInt();

        return choice;
    }
    /**
     * Asks name of User.
     * @return String representing name of User.
     */
    public String askName() {
        createWhiteSpaces(1);
        System.out.println("Name : ");
        input.nextLine();
        String name = input.nextLine();
        return name;
    }
    /**
     * Ask if wants to draw tile.
     * @return true if wants to draw tile,otherwise false.
     */
    public boolean wantToDraw(){
        createWhiteSpaces(1);
        System.out.println("Draw Tile? (YES:1/NO:0)");
        int choice=input.nextInt();
        while (choice != 1 && choice != 0) {
            System.out.println("Wrong input");
            System.out.println(" Draw Tile? (YES=1/NO=0)");
            choice = input.nextInt();
        }
        return choice==1;
    }
    /**
     * Asks for number of players(1 User +Bot(s)).
     * @return number of players(1 User +Bot(s)).
     */
    public int chooseNumberOfPlayers(){
        createWhiteSpaces(1);
        System.out.println("How many Players?(2,3,4)");
        int choice=input.nextInt();
        while(choice<2 || choice>4){
            showInvalidInput();                                                                            
            System.out.println("Choose number of players in [2,4]");
            choice=input.nextInt();
        }
        return choice;
    }
    

}
