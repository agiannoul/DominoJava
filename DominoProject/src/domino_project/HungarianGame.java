package domino_project;

import Gui.HungarianGui;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents the Hungarian Type of Domino Game. It has 1 user and
 *Bot(s)(1 or more)(MultiplayerGame). The player with 
 * the highest double Tile starts putting tiles on Line
 * until they cannot put anymore and then plays the other.If NOBODY can put any
 * tiles on line, the round stops.The one with the less points on their hand
 * collects their opponent's points. Winner is called the one who gets 100
 * points.If Bot plays first and the Line is empty, they place
 * their first Tile automatticaly.
 * p.s. If for example player plays first and puts all of their tiles on Line,
 * then the bot can play as well after them and put as many as it can.Then the 
 * points are given as described before.
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class HungarianGame extends MultiplayerGame{

   
    /**
     * Class Constructor.
     * Creates a BoardHungarian.
     * @param num number of players playing this game(user+Bots)
     */
   public HungarianGame(int num) {
        super(num);
        
        board = new BoardHungarian();
        
        }
       
   /**
     * This method represents the main round loop.The players
     * get in an order.The player with the highest
     * double Tile starts putting tiles on Line until they cannot put anymore
     * and then plays the other. If nobody can put any tiles(done=false) on line,
     * we get a new round.
     */
     
    private void roundloop() {
            order();
            boolean p[]= new boolean[players.size()];
            boolean done;
            for(int i=0 ;i<p.length;i++){
                p[i]=true;
             }
            done=true;
            while (done) {
                for(int i=0;i<players.size();i++){
                    if( players.get(i) instanceof Human ){
                        p[i] = humanMakesMove();
                        ((HungarianGui)(gui)).showHand(players.get(getHuman()).getHand());
                    }else{
                        p[i]= botMakesMove(i);
                    }
                    done=false;
                    
                }
                for(boolean a : p){
                        done = done || a;
                    }
            }
        

    }

   
/**
 * Shows new round and the points gained from players.
 */
    private void showBoardNewRound() {
        
       ((HungarianGui)(gui)).newRound();
       ((HungarianGui)(gui)).showHand(players.get(getHuman()).getHand());
        ((HungarianGui)(gui)).showPoints(players);
       
       
    }
    
   
    /**
     * Points are handled to the winner of the round.
     * The one with the less points on their hand
     * collects their opponents' points. If for example,
     * 2 players have the same points each of them gets the same
     * points from their opponents.
     */

    @Override
    protected void handlePointsOfWinner() {
        int pos=getminPos();
        int sum=0;
        for(int i=0;i<players.size();i++){
            if(i==pos)continue;
            sum+=players.get(i).getHandpoints();
       }
       for(int i=0;i<players.size();i++){
           if(i==pos || players.get(i).getHandpoints() == players.get(pos).getHandpoints() ){
               players.get(i).addPoints(sum);
           }
                
         }
    
    }
    
   /**
    * This method represents the main game loop for Hungarian
    * Type of DominoGame.Combines all the methods in a main loop
    * and shows the winner at the end.
    */
    public void game() {

        while (players.get(this.getMaxPos()).GetPoints() < 100 ) {
            fillObjects(24/players.size());

            roundloop();

            handlePointsOfWinner();

            showBoardNewRound();

            ClearObjects();
        }

        ((HungarianGui)gui).showWinner( players.get(this.getMaxPos()).getName());
    }

    /**
     * Shows the move(puts tile on Line) of the bot.
     * @param pos position of the bot.
     */
    private void showMoveOfBot(int pos) {
        ((HungarianGui)(gui)).showLine((BasicDominoLine) board.getLine());
        ((HungarianGui)(gui)).playerIsPlaying(players.get(pos).getName());
         try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(HungarianGame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /**
     * Shows the move(puts tile on Line) of the user-human.
     */
    private void showMoveOfPlayer() {

        ((HungarianGui)(gui)).showLine((BasicDominoLine) board.getLine());
        ((HungarianGui)(gui)).playerIsPlaying(players.get(getHuman()).getName());
        ((HungarianGui)(gui)).showHand(players.get(getHuman()).getHand());
    }
/**
     * This method represents a move by a player. The tile they chose is placed
     * on the willing and correct position and is being removed by its hand.
     */
    private void humanMove() {

        int x = this.getPosOfTileByPlayer();

        int fits = board.getLine().fitsOnBeginning(players.get(getHuman()).getTileByIndex(x));
        int fits2 = board.getLine().fitsAtTheEnd(players.get(getHuman()).getTileByIndex(x));
        int choice = 1;
        if (fits > 0 && fits2 > 0) {
            // 8a ginei h 1 h 2
            choice = ((HungarianGui)(gui)).giveChoice();
        }
        board.placeTileToLine(players.get(getHuman()).getTileByIndex(x), choice, board.line);
        players.get(getHuman()).removeTileByIndex(x);
    }
/**
 * This method represents a move by a bot. Artificial Intelligence is not
 * used. If line is empty, bot puts its 1st Tile automatically. If line isnt
 * empty, finds any tile that can be played.
 *
 * @param bot position of bot that makes move
 * @return  true if bot makes a move,otherwise false.
 */
    private boolean botMakesMove(int bot){
        boolean done = false;
        if (board.getLine().isEmpty()) {
            done = true;
            showMoveOfBot(bot);
            //vazei aytomata to prwto tou
            board.placeTileToLine(players.get(bot).getTileByIndex(0), 1, board.line);
            players.get(bot).removeTileByIndex(0);

            
           
        }
        // prwta prepei na ginei cast alliws den vriskei tis me8odous ths setoftile pou kanoume extend
        BasicDominoLine l=(BasicDominoLine) board.getLine();
        boolean ableToMove=isPlayerAbleToPlay(players.get(bot));
        while (ableToMove) {
             showMoveOfBot(bot);
            done = true;
            int pos = ((Bot)players.get(bot)).pickTileToPlay(l.getFirstTile().getT1(), l.getLastTile().getT2());
            Tile tile = players.get(bot).getTileByIndex(pos);
            board.placeTileToLine(tile, 1, board.line);
            players.get(bot).removeTileByIndex(pos);
            ableToMove=isPlayerAbleToPlay(players.get(bot));
                     
        }
        return done;
    }
/**
 * This method represents whether a player can make a move or not
 * and complements the method humanMove().
 * 
 * @return true if player made a move, otherwise false.
 */
    private boolean humanMakesMove() {
        boolean done = false;
        if (board.getLine().isEmpty()) {
            done = true;
                showMoveOfPlayer();
            humanMove();

            
        }
        boolean ableToMove=isPlayerAbleToPlay(players.get(getHuman()));
        while (ableToMove) {
            showMoveOfPlayer();
            done = true;
            humanMove();
            ableToMove=isPlayerAbleToPlay(players.get(getHuman()));
        }
        return done;
    }

    @Override
    public void run() {
        game();
    }

    
}
