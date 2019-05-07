package domino_project;

import Gui.CardinalGui;
import Gui.HungarianGui;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *This class represents the Cardinal Type of Domino Game.Its a 
 * MultiplayerGame played with a user and Bot(s)(1 or more).The player
 * with the highest double tile starts playing first.The rule is that
 * the touching sides of the tiles put on line have total sum of 7.The
 * double blanks([0,0]) and the tiles with sum=7(e.g. [4,3],[6,1]) 
 * are considered baladers.They can be put anywhere reversed or not.Next to a 0
 * can only be put a balader.The players autommatically draw a tile from stack
 * when they can't put any tile on Line UNTIL THEY CAN.The user can
 * draw as many tiles as they want independently from being able to play or not.
 * The first tile to be put on Line can be anyone.If noone has a double then User
 * plays first.Players' turn ends when they put a tile on Line.If someone
 * can't put a tile and also can't draw a tile from stack then the next one
 * makes a move.If more than 1 players have the same points at the end of the round
 * they all share the same points.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class CardinalGame extends MultiplayerGame {

    
    /**
     * Class Constructor.
     * Creates a BoardCardinal.
     * @param num number of players playing this game(user+Bots)
     */
    public CardinalGame(int num) {
        super(num);
        board = new BoardCardinal();
    }
/**
 * This method represents the main game loop for Cardinal Type
 * of DominoGame.Combines all the methods in a main loop and
 * show the winner at the end.
 */
    public void game() {
        
        int amount;//plh8os tiles pou dinontai stous paiktes
        if (players.size() <= 2) {
            amount = 7;
        } else {
            amount = 5;
        }

        while (players.get(this.getMaxPos()).GetPoints() < 100) {
            fillObjects(amount);

            roundloop();

            handlePointsOfWinner();

            showBoardNewRound();

            ClearObjects();
        }

          ((CardinalGui)gui).showWinner( players.get(this.getMaxPos()).getName());

    }
/**
     * This method represents the main round loop.The players
     * get in an order.The player with the highest
     * double Tile starts putting tiles on Line until they cannot put anymore
     * and then plays the other. If nobody can put any tiles(done=false) on line,
     * we get a new round.
     */
    public void roundloop() {

        order();
        boolean p[] = new boolean[players.size()];
        boolean done;
        for (int i = 0; i < p.length; i++) {
            p[i] = true;
        }
        done = true;
        while (done) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i) instanceof Human) {
                    p[i] = humanMakesMove();
                } else {
                    p[i] = botMakesMove(i);
                }

                if (players.get(i).getHand().isEmpty()) {
                    return;
                }
                done = false;
                for (boolean a : p) {
                    done = done || a;
                }
            }

        }

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
        int pos = getminPos();
        int sum = 0;
        for (int i = 0; i < players.size(); i++) {
            if (i == pos) {
                sum -= players.get(i).getHandpoints();
            } else {
                sum += players.get(i).getHandpoints();
            }

        }
        for (int i = 0; i < players.size(); i++) {
            if (i == pos || players.get(i).getHandpoints() == players.get(pos).getHandpoints()) {
                players.get(i).addPoints(sum);
            }

        }

    }
/**
 * This method represents whether a player can make a move or not
 * and complements the method humanMove().Certain methods are called
 * for the Graphical Display and User Interface.
 * 
 * @return true if player made a move, otherwise false.
 */
    private boolean humanMakesMove() {
        boolean done = false;
        ((CardinalGui)(gui)).setDrawButtonFalse();
        if (board.getLine().isEmpty()) {

            done = true;
            ((CardinalGui) (gui)).showTurn();
            ((CardinalGui) (gui)).showLine(board.getLine().getSetOfTiles());
            ((CardinalGui) (gui)).showCloseSet(board.set.getSize());

            ((CardinalGui) (gui)).showHand(players.get(getHuman()).getHand());
            askForTileFromSet();
            humanMove();

            ((CardinalGui) (gui)).showLine(board.getLine().getSetOfTiles());
        } else {
            ((CardinalGui) (gui)).showTurn();

            ((CardinalGui) (gui)).showLine(board.getLine().getSetOfTiles());
            boolean able = isPlayerAbleToPlay(players.get(getHuman()));
            while (!able && board.set.getSize() > 2) {
                ((CardinalGui) (gui)).showCloseSet(board.set.getSize());

                ((CardinalGui) (gui)).showHand(players.get(getHuman()).getHand());
                ((CardinalGui) (gui)).showDrawCard();
                players.get(getHuman()).getHand().addTile(board.set.getLastTile());
                board.set.removeLastTile();
                able = isPlayerAbleToPlay(players.get(getHuman()));
            }

            if (able) {
                done = true;
                ((CardinalGui) (gui)).showCloseSet(board.set.getSize());
                ((CardinalGui) (gui)).showHand(players.get(getHuman()).getHand());
                askForTileFromSet();
                humanMove();
                ((CardinalGui) (gui)).showLine(board.getLine().getSetOfTiles());
            }

        }

        return done;
    }
/**
     * This method represents a move by a player. The tile they chose is placed
     * on the willing and correct position(reversed or not)
     * and is being removed by its hand.
     */
    private void humanMove() {
        int x = getPosOfTileByPlayer();
        Tile tile = players.get(getHuman()).getHand().getTileByIndex(x);
        if (isBalader(tile)) {
            int choice = ((CardinalGui) (gui)).giveChoice();
            if (tile.getSum() != 0) {//Otan einai to 0,0 den yparxei nohma antistrofhs
                boolean reverse = ((CardinalGui) (gui)).askForReverse();
                if (reverse) {
                    tile.reverseTile();
                }
            }
            board.placeTileToLine(tile, choice, board.line);
            players.get(getHuman()).removeTileByIndex(x);
        } else {
            int fits = board.getLine().fitsOnBeginning(players.get(getHuman()).getTileByIndex(x));
            int fits2 = board.getLine().fitsAtTheEnd(players.get(getHuman()).getTileByIndex(x));
            int choice = 1;
            if (fits > 0 && fits2 > 0) {
                // 8a ginei h 1 h 2
                choice = ((CardinalGui)(gui)).giveChoice();
            }
            board.placeTileToLine(players.get(getHuman()).getTileByIndex(x), choice, board.line);

            players.get(getHuman()).removeTileByIndex(x);
        }
        ((CardinalGui) (gui)).showHand(players.get(getHuman()).getHand());
    }

    private void askForTileFromSet() {
        int ask;
        do {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
            }
            ask = ((CardinalGui) (gui)).wantToDraw();
        } while (ask == -1);//oso einai -1 perimene na se apanthsei 1 h 0

        while (ask == 1) {
            if (board.set.getSize() > 2) {
                players.get(getHuman()).getHand().addTile(board.set.getLastTile());
                board.set.removeLastTile();
               ((CardinalGui) (gui)).showCloseSet(board.set.getSize());
                ((CardinalGui) (gui)).selectFromSet(players.get(getHuman()).getName());
                ((CardinalGui) (gui)).showHand(players.get(getHuman()).getHand());
                // gui.createWhiteSpaces(1);
                do {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                    }
                    ask = ((CardinalGui) (gui)).wantToDraw();
                } while (ask == -1);//oso einai -1 perimene na se apanthsei 1 h 0
            } else {
                break;
            }

        }
    }
/**
 * Returns if this tile is Balader.
 * @param tile tile to be checked if balader
 * @return true if tile is Balader,otherwise false
 */
    private boolean isBalader(Tile tile) {
        return (tile.getSum() == 7 || tile.getSum() == 0);
    }
/**
 * This method represents a move by a bot. Artificial Intelligence is not
 * used. If line is empty, bot puts its 1st Tile automatically. If line isnt
 * empty, finds any tile that can be played.
 * 
 * @param i position of bot that makes move
 * @return true if bot makes a move,otherwise false.
 */
    private boolean botMakesMove(int i) {
        boolean done = false;
        if (board.getLine().isEmpty()) {
            done = true;
  
            int pos = botPickTile((Bot) players.get(i));
            board.placeTileToLine(players.get(i).getTileByIndex(pos), 1, board.line);
            players.get(i).removeTileByIndex(pos);

            showMoveOfBot(i);
        } else {
            boolean able = isPlayerAbleToPlay(players.get(i));
            while (!able && board.set.getSize() > 2) {
                ((CardinalGui) (gui)).selectFromSet(players.get(i).getName());

                players.get(i).getHand().addTile(board.set.getLastTile());
                board.set.removeLastTile();
                able = isPlayerAbleToPlay(players.get(i));
            }

            if (able) {
                ((CardinalGui) (gui)).showAbleToPlay(players.get(i).getName());
                done = true;

                int pos = botPickTile((Bot) players.get(i));
                board.placeTileToLine(players.get(i).getTileByIndex(pos), 1, board.line);
                players.get(i).removeTileByIndex(pos);
                showMoveOfBot(i);

            }
        }

        return done;
    }
/**
 * Returns the position of the tile in Bot's hand that will
 * be picked to put on Line,if fits.
 * @param bot Bot which hand will be cheked
 * @return position of tile in Bot's hand that will
 * be picked to put on Line,if fits.-1 if nothing fits on Line
 */
    private int botPickTile(Bot bot) {
        for (int i = 0; i < bot.getHand().getSize(); i++) {
            if (((BoardCardinal) board).checkIfFits(bot.getTileByIndex(i))) {
                return i;
            }
        }
        return -1;
    }
/**
* Shows the move(puts tile on Line) of the bot.
* @param pos position of the bot.
 */
    private void showMoveOfBot(int pos) {
        ((CardinalGui) (gui)).playerIsPlaying(players.get(pos).getName());
        ((CardinalGui) (gui)).showLine(board.getLine().getSetOfTiles());
        ((CardinalGui) (gui)).showCloseSet(board.set.getSize());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(HungarianGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Shows the move(puts tile on Line) of the user-human.
     * (Helping Method)
     */
    private void showMoveOfHuman() {
        int pos = getHuman();
        ((CardinalGui) (gui)).showLine(board.getLine().getSetOfTiles());
        ((CardinalGui) (gui)).showCloseSet(board.set.getSize());

        ((CardinalGui) (gui)).playerIsPlaying(players.get(pos).getName());
        ((CardinalGui) (gui)).showHand(players.get(pos).getHand());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(HungarianGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Shows new round and the points gained from players.
 */
    private void showBoardNewRound() {
        ((CardinalGui) (gui)).newRound();
        for (int i = 0; i < players.size(); i++) {
            ((CardinalGui) (gui)).showPoints(players);
        }

    }
    /**
     * Returns the position of tile selected by player.
     * Shows invalidInput when input entered is wrong.
     * 
     * @return the position of tile selected by player.
     */
    @Override
    protected int getPosOfTileByPlayer() {
        int pos;
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        pos = ((CardinalGui) (gui)).readFromHand();
        while (pos == -1 || !((BoardCardinal) board).checkIfFits(players.get(getHuman()).getTileByIndex(pos))) {
            if (pos != -1) {
                ((CardinalGui) (gui)).showInvalidInput();
                askForTileFromSet();
            }
            ((CardinalGui) (gui)).setFalseButtonPressed();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            pos = ((CardinalGui) (gui)).readFromHand();
        }
        return pos;
    }
    /**
 * @see MultiplayerGame
 */
    @Override
    protected boolean isPlayerAbleToPlay(Player p) {
        if (p.getHand().isEmpty()) {
            return false;
        }
        for (int i = 0; i < p.getHand().getSize(); i++) {
            if (((BoardCardinal) board).checkIfFits(p.getHand().getTileByIndex(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        game();
    }
}
