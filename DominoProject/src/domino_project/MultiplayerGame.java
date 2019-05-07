package domino_project;

import Gui.CardinalGui;
import Gui.HungarianGui;
import Gui.MultiplayerGui;
import java.util.ArrayList;

/**
 * This class represents a Multiplayer DominoGame.Multiplayer means
 * Player(user) + Bots(1 or more).For example, Cardinal and Hungarian
 * belong to MultiplayerGame(Solo1 does NOT).It consists of
 * players(ArrayList),board(MultiplayerBoard
 * and a MultiplayerGui for GUI.MultiplayerGame implements
 * runnable(Thread).
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public abstract class MultiplayerGame implements Runnable {
   
    /**
     *MultiplayerGui for Graphical User Interface.
     */
    protected MultiplayerGui gui;

    /**
     * ArrayList of Player consisting all the players
     * of the MultiplayerGame.
     */
    protected ArrayList<Player> players;

    /**
     *The board of the MultiplayerGame.
     */
    protected MultiplayerBoard board;

    /**
     * Class Constructor.
     * Fills the ArrayList of Player(first human
     * and then the Bot(s))and initializes
     * the rest variables.
     * 
     * @param num number of players playing this game(user+Bots)
     */
    public MultiplayerGame(int num) {
         int numberOfPlayers;
         
        
        numberOfPlayers=num;
        players = new ArrayList<>();
        if(this instanceof HungarianGame){
            gui=new HungarianGui();
            ((HungarianGui)gui).setVisible(true);
        }else{
           gui=new CardinalGui();
            ((CardinalGui)gui).setVisible(true);
        }
        String name;
        if(this instanceof HungarianGame){
            name = ((HungarianGui)(gui)).askName();
        }else{
           name = ((CardinalGui)(gui)).askName();
           
        }
        
        players.add(new Human(name));
        for (int i = 1; i < numberOfPlayers; i++) {
            players.add(new Bot("Bot " + i));
        }

    }
/**
 * Determines the order of player playing this game 
 * according to the Highest Double Tile of their hand
 * and cycling order.
 * For example if we have 2 Bots and Bot 1 has
 * the Highest Double Tile the order of playing is like this:
 * Bot 1,Bot 2,Human(previously: Human,Bot 1,Bot 2).
 */
    protected void order() {
        int pos = 0;
        int max = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHighiestDoubleTile() > max) {
                max = players.get(i).getHighiestDoubleTile();
                pos = i;
                
            }
        }
        ArrayList<Player> a=new ArrayList<>();
        for (int i = 0; i < pos; i++) {
            a.add(players.get(i));
        }
        for(int i=0;i<pos;i++){
            players.remove(a.get(i));
        }
        for(int i=0;i<pos;i++){
            players.add(a.get(i));
        }
       
    }
/**
 * The board is filled and players get their hand.
 * @param amount integer representing the amount of
 * tiles that player have at thei hand.
 */
    protected void fillObjects(int amount) {
        board.fillBoard();

        for (int i = 0; i < players.size(); i++) {
            players.get(i).fillhand(board.giveLastTiles(amount));
        }

    }
    /**
     * Clears the board and the players' hand,creating new ones.
     */
      protected void ClearObjects() {
        board.clearBoard();
        for(int i=0;i<players.size();i++){
           players.get(i).ClearHand();
       }
    }
    /**
     * Returns the position of Human in players.
     * @return the position of Human in players.
     */
     protected int getHuman(){
        for(int i=0;i<players.size();i++){
            if(players.get(i) instanceof Human) return i;
        }
        return 0;
    }
     /**
      * Returns the position of player in players with
      * the minimum amount of total points on thei hand.
      * @return the position of player in players with
      * the minimum amount of total points on thei hand.
      */
     protected int getminPos(){
        int pos=0;
        int min=300;
         for(int i=0;i<players.size();i++){
           if(players.get(i).getHandpoints()<min){
               min = players.get(i).getHandpoints();
               pos=i;
           }
       }
         return pos;
    }
     /**
      * Returns the position of player in players with
      * the maximun amount of total points on thei hand.
      * @return the position of player in players with
      * the maximum amount of total points on thei hand.
      */
      protected int getMaxPos(){
        int pos=0;
        int max=0;
         for(int i=0;i<players.size();i++){
           if(players.get(i).GetPoints()>max){
               max = players.get(i).GetPoints();
               pos=i;
           }
       }
         return pos;
    }
      /**
       * Checks if Player p is able to put a tile on Line.
       * If they have no tiles on hand returns false.
       * 
       * @param p player to be checked
       * @return true if p is able to put a tile on Line,
       * otherwise false.
       */
      protected boolean isPlayerAbleToPlay(Player p){
          if(p.getHand().isEmpty()){
              return false;
          }
          for(int i=0;i<p.getHand().getSize();i++){
              if(board.checkIfFits(p.getHand().getTileByIndex(i))){
                  return true;
              }
          }
          return false;
      }
      /**
       * Returns the position of tile selected by player.
       * @return the position of tile selected by player.
       */
      protected int getPosOfTileByPlayer() {
        if(this instanceof HungarianGame){
            ((HungarianGui)(gui)).setFalseButtonPressed();
        }else{
           ((CardinalGui)(gui)).setFalseButtonPressed();
           //CARDINAL KANTO
        }
          
        try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                
            }
        int pos;
        if(this instanceof HungarianGame){
                 pos = ((HungarianGui)(gui)).readFromHand();
            }else{
                 pos = ((CardinalGui)(gui)).readFromHand();
                //CARDINAL KANTO
            }
        
        
        while (pos==-1 || !board.checkIfFits( players.get(getHuman()).getTileByIndex(pos))) {
           
            if(pos!=-1){
                gui.showInvalidInput();
            }
            if(this instanceof HungarianGame){
                ((HungarianGui)(gui)).setFalseButtonPressed();
            }else{
                ((CardinalGui)(gui)).setFalseButtonPressed();
                //CARDINAL KANTO
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            if(this instanceof HungarianGame){
                 pos = ((HungarianGui)(gui)).readFromHand();
            }else{
                 pos = ((CardinalGui)(gui)).readFromHand();
                //CARDINAL KANTO
            }
        }
        return pos;
    }
     /**
      * Shares the points to the winner of the round-game
      * according to the rules of each Multiplayer Game.
      */
     protected abstract void handlePointsOfWinner();
     
}
