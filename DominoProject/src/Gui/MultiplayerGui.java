package Gui;

import domino_project.Player;
import domino_project.SetOfTiles;
import java.util.ArrayList;

/**
 * This interface contains abstract methods
 * needed in Graphical User Interface of a
 * Multiplayer(Player+Bots) game of DominoGame.
 * @author User
 */
public interface MultiplayerGui {
    
    /**
    * Asks the name of the Player playing a Multiplayer game of DominoGame.
    * @return the name of the Player playing a Multiplayer game of DominoGame.
    */
    public String askName();
    /**
     * Reads the tile to be played from Player's hand
     * and returns an integer representing it.
     * @return an integer representing the tile to be played from Player's hand
     */
    public int readFromHand();
    /**
     * Shows InvalidInput when entered input is incorrect.
     */
    public void showInvalidInput();
    /**
     * Shows hand of tiles of the Player playing a Multiplayer game of DominoGame.
     * @param setOfTiles a SetOfTiles representing the hand of player.
     */
   public void showHand(SetOfTiles setOfTiles);
   /**
    * Shows the Winner of the Multiplayer game of DominoGame.
    * @param name String representing the Winner of the Multiplayer game of DominoGame.
    */
   public void showWinner(String name);
   /**
    * Shows the Line of Tiles that are played by Bots and Player.
    * @param setOfTiles SetOfTiles representing the tiles that are put on Line.
    */
   public void showLine(SetOfTiles setOfTiles);
   /**
    * Shows the points collected by  Player-Bots playing the game.
    * @param players  representing 
    * the names of the players.
    */
   public void showPoints(ArrayList<Player> players);
}
