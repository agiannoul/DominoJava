package domino_project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a Set Of Tiles(a number of Tiles) by using an
 * ArrayList.
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class SetOfTiles {

    private ArrayList<Tile> tileSet;

    /**
     * Class Constructor. Initializes the ArrayList ,representing the
     * SetOfTiles, with 0 elements.
     */
    public SetOfTiles() {
        tileSet = new ArrayList<>();
    }

    /**
     * This method adds a Tile to the end of this Set Of Tiles.
     *
     * @param tile Tile to be added.
     * @return true: if it was added,otherwise false
     */
    public boolean addTile(Tile tile) {
        return tileSet.add(tile);

    }

    /**
     * This method inserts the specified Tile at the specified position in this
     * Set Of Tiles
     *
     * @param tile Tile to be added
     * @param i position to be added in
     */
    public void addTileByIndex(Tile tile, int i) {
        tileSet.add(i, tile);
    }

    /**
     * Checks if this Set Of Tiles contains no elements.
     *
     * @return true if this Set Of Tiles contains no elements
     */
    public boolean isEmpty() {
        return tileSet.isEmpty();
    }

    /**
     * This method removes the last Tile of this Set Of Tiles if it isn't empty.
     *
     * @return true if the Set Of Tiles has more than one element,otherwise
     * false
     */
    public boolean removeLastTile() {
        if (tileSet.size() >= 1) {

            tileSet.remove(tileSet.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method removes the Tile at the specified position in this Set Of
     * Tiles.
     *
     * @param i position to be removed off
     * @return true if theres an element to be removed at the position given,
     * otherwise false
     */
    public boolean removeByIndex(int i) {
        if (tileSet.size() >= i) {

            tileSet.remove(i);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the Tile at the last position of this Set Of Tiles.
     *
     * @return the Tile at the last position of this Set Of Tiles.
     */
    public Tile getLastTile() {

        return tileSet.get(tileSet.size() - 1);

    }

    /**
     * Gets the Tile at the first position of this Set Of Tiles.
     *
     * @return the Tile at the first position of this Set Of Tiles.
     */
    public Tile getFirstTile() {

        return tileSet.get(0);

    }

    /**
     * Returns the tile in the given position of the Set Of Tiles.
     *
     * @param i position of the Tile to be returned
     * @return Tile at this position(i),null if it doesnt exist.
     */
    public Tile getTileByIndex(int i) {
        return tileSet.get(i);
    }

    /**
     * This method randomly permutes the Tiles in the Set Of Tiles shuffling all
     * of them using a method called shuffle(List<?>).
     */
    private void shuffleAll() {
        Collections.shuffle(tileSet);
    }

    /**
     * Fills the Set Of Tiles with 28 different Tiles with numbers in [0,6].
     * Every Tile exists only once.([0,0] [0,1] ...[6,5] [6,6]). Then calls the
     * shuffleAll() private method.
     */
    public void fillSet28() {

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                tileSet.add(new Tile(i, j));
            }
        }
        this.shuffleAll();
    }

    /**
     * Returns the number of Elements in this Set Of Tiles
     *
     * @return the number of elements in this Set Of Tiles
     */
    public int getSize() {
        return tileSet.size();
    }

}
