package domino_project;

/**
 * This class represents the Board on which any type of
 * DominoGame happens.It consists of the line on where the
 * tiles are put on.
 * 
  * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class Board {
    /**
     * Line on where tiles are put on by players.
     */
    protected DominoLine line;
   
    
    
    
        /**
     * This method puts the given tile to the line checking where it fits. Tile
     * gets reversed if needed. If it fits both on beggining and at the end, the
     * parameter choice determines where to be put.
     *
     * @param tile Tile to be put to Line
     * @param choice an integer which represents the choice of the player to put
     * the line either on the beggining(choice=1) either at the end(choice=2),
     * when it fits on both.
     */
    public void placeTileToLine(Tile tile, int choice ) {
        int fits = line.fitsOnBeginning(tile);
        int fits2 = line.fitsAtTheEnd(tile);

        if (fits > 0 && choice == 1) {
            switch (fits) {
                case 1:
                    tile.reverseTile();
                    line.addTileOnBeginning(tile);
                    break;
                case 2:
                    line.addTileOnBeginning(tile);

                    break;
            }
        } else {
            switch (fits2) {
                case 1:

                    line.addTileAtTheEnd(tile);

                    break;
                case 2:
                    tile.reverseTile();
                    line.addTileAtTheEnd(tile);

                    break;

            }
        }
    }
    /**
     * This method does the same as the upper method but gets
     * on more parameter to do the required type casting.
     * 
     * @param tile Tile to be put to Line
     * @param choice an integer which represents the choice of the player to put
     * the line either on the beggining(choice=1) either at the end(choice=2),
     * when it fits on both.
     * @param l DominoLine for the required type casting
     */
    public void placeTileToLine(Tile tile, int choice , DominoLine l) {
        int fits,fits2;
        if(l instanceof CardinalDominoLine ){
            fits = ((CardinalDominoLine)line).fitsOnBeginning(tile);
            fits2 =((CardinalDominoLine)line).fitsAtTheEnd(tile);
        }else {
             fits = ((BasicDominoLine)line).fitsOnBeginning(tile);
             fits2 =((BasicDominoLine)line).fitsAtTheEnd(tile);
        }
        
        if (fits > 0 && choice == 1) {
            switch (fits) {
                case 1:
                    tile.reverseTile();
                    line.addTileOnBeginning(tile);
                    break;
                case 2:
                    line.addTileOnBeginning(tile);

                    break;
            }
        } else {
            switch (fits2) {
                case 1:

                    line.addTileAtTheEnd(tile);

                    break;
                case 2:
                    tile.reverseTile();
                    line.addTileAtTheEnd(tile);

                    break;

            }
        }
    }
    
    /**
     * This method checks if the specified Tile(tile) given
     * fits on either side of the line of this board.It is supposed
     * that if the Line is empty then every tile fits in it.
     * 
     * @param tile Tile to be checked if fits on DominoLine of this board
     * @return true if tile fits either on beggining or at the end, otherwise
     * false.
     */
    public boolean checkIfFits(Tile tile) {
        if (line.isEmpty()) {
            return true;
        }
        int fits = line.fitsOnBeginning(tile);
        switch (fits) {
            case 1:
                return true;
            case 2:
                return true;
            default:
                int fits2 = line.fitsAtTheEnd(tile);
                switch (fits2) {
                    case 1:
                        return true;
                    case 2:
                        return true;
                    default:
                        return false;
                }
        }
    }
    /**
     * Returns the DominoLine
     * @return DominoLine where the tiles are put on
     */
    public DominoLine getLine() {
        return line;
    }
    
}
