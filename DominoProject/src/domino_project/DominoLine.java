package domino_project;

/**
 *This interface represents a Line of Tiles on 
 * which the tiles are put by players and bot at a Domino Game.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public interface DominoLine {
    /**
     * Adds a Tile on the beginning of The Dominoline
     *
     * @param tile Tile to be added
     */
    public void addTileOnBeginning(Tile tile);
    /**
     * Adds a Tile at the End of the DominoLine
     * 
     * @param tile , a tile
     */
    public void addTileAtTheEnd(Tile tile);
    /**
     * Checks if the given tile fits on the Beggining of the line.
     * It is supposed that if the line is empty, every
     * tile fits the line.
     *
     * * "matches" depends on the rules of each version of DominoGames
     * 
     * @param tile Tile to be checked
     * @return 1:if 1st  tile matches the  first tile in
     * DominoLine (or line is empty) 2:if 2nd  tile matches the first
     *  tile in DominoLine 3:if the first tile
     * in DominoLine doesn't match any side of the tile
     */
    public short fitsOnBeginning(Tile tile);
    /**
     * Checks if the given tile fits at the End of the line.
     * 
     * "matches" depends on the rules of each version of DominoGames
     * 
     * @param tile Tile to be checked
     * @return 1:if 1st  Tile matches the second tile (or line
     * is empty) 2:if 2nd  Tile matches the second tile 3:if
     * the second  tile doesn't match any side of the Tile
     */
    public short fitsAtTheEnd(Tile tile);
     /**
     * Checks if this DominoLine contains no elements.
     *
     * @return true if this DominoLine contains no elements
     */
    public boolean isEmpty();
    /**
     * Gets the DominoLine returned.
     *
     * @return A SetOfTiles representing the DominoLine.
     */
    public SetOfTiles getSetOfTiles();
    /**
     * Clears(removes all elements) the DominoLine so
     * it can be updated with the next added elements.
     */
    public void Clear();
    
    
}
