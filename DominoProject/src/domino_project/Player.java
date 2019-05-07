
package domino_project;

/**
 *This interface represents a Player(Bot or Human) in a DominoGame.
 * 
* @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public interface Player {
    
    /**
     * Fills their hand with a SetOfTiles.
     * 
     * @param set setOfTiles representing their hand.
     */
    public void fillhand(SetOfTiles set); 
    /**
     * Their current hand gets cleared and a new one is created.
     */
    public void ClearHand();
    /**
     * Gets the total points from every Tile(sum) on their hand.
     *
     * @return an integer representing the sum of every value of every Tile on
     * their hand.
     */
    public int  getHandpoints();
    /**
     * Gets the value of the highest double Tile on their hand. Returns -1 if
     * doesnt exist. e.g. [6,6] -- 6
     *
     * @return the value of the highest double Tile on their hand.
     */
     public int getHighiestDoubleTile();
     /**
     * Gets their collected points
     *
     * @return points it has collected
     */
     public int GetPoints();
     /**
      *  Removes a Tile from their hand.
      * 
      * @param x an integer representing a Tile on their hand e.g. the 1st one
      * @return true if it was removed,otherwise false
      */
     public boolean removeTileByIndex(int x);
     /**
     * Gets the Tile in a specified position of their hand
     *
     * @param x an integer representing a Tile on their hand e.g. the 1st one
     * @return true if Tile was found in their hand,otherwise false.
     */
     public Tile getTileByIndex(int x);
     /**
     * Checks if has no more tiles on their hand.
     *
     * @return true if has no more tiles on their hand,otherwise false.
     */
     public boolean handIsEmpty();
     /**
      * * Adds a specified number of points(x) to their points.
      * 
      * @param x an integer representing the points to be added.
      */
      public void addPoints(int x);
      /**
       * Returns their hand.
       * 
       * @return a SetOfTiles representing their hand.
       */
      public SetOfTiles getHand();
      /**
       * Returns their name(e.g. Kostas,Bot 1,Bot 3)
       * 
       * @return a String representing Player's name.
       */
      public String getName();
}
