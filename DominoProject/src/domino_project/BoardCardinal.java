package domino_project;

/**
 * This class represents the board of a Cardinal type of Domino Game. This
 * board consists of a DominoLine on where the player and bot put their Tiles
 * and of a SetOfTiles from where they get their hand.
 * It also extends MultiplayerBoard.
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class BoardCardinal extends MultiplayerBoard{
    
    /**
     * Class Constructor.
     * Line is initialized.
     */
    public BoardCardinal(){
       
        line=new CardinalDominoLine();
    }
    
/**
 *  This method checks if the specified Tile(tile) given
 * fits on either side of the line of this board.
 * Fitting condition : sum of touching sides of tiles
 * should equal to 7 or balader.
 * @param tile  Tile to be checked if fits on DominoLine of this board
 * @return true if tile fits either on beggining or at the end, otherwise
     * false.
 */
    @Override
    public boolean checkIfFits(Tile tile){
        if(line.isEmpty()){
            return true;
        }
        if(tile.getSum()==7 || tile.getSum()==0){
            return true;
        }
        int fits = ((CardinalDominoLine)line).fitsOnBeginning(tile);
        switch (fits) {
            case 1:
                return true;
            case 2:
                return true;
            default:
                int fits2 = ((CardinalDominoLine)line).fitsAtTheEnd(tile);
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
    
    
     
}
