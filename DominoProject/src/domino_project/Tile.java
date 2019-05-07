package domino_project;

/**
 * This class represents a Tile of a Domino Game using 2 integers for the values
 * written on it. This Tile is used in many types of Domino Game.
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class Tile {

    private int t1;
    private int t2;

    /**
     * Class Constructor. Creates a Tile with given values(both positive
     * integers in [0,6]).
     *
     * @param t1 1st value (on one side) of Tile
     * @param t2 2nd value (on the other side) of Tile
     */
    public Tile(int t1, int t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    /**
     * Return 1st value passed to the constructor
     *
     * @return t1
     */
    public int getT1() {
        return t1;
    }

    /**
     * Return 2nd value passed to the constructor
     *
     * @return t2
     */
    public int getT2() {
        return t2;
    }

    /**
     * This method reverses the values of a Tile. e.g. [3,1] to S [1,3]
     */
    public void reverseTile() {
        int temp = t1;
        t1 = t2;
        t2 = temp;
    }

    /**
     * This method checks if the given integer(tile_num) matches any of the
     * sides of this Tile.
     *
     * @param tileNum a Tile Number to be checked if matches
     * @return 1:if 1st value of Tile matches tileNum 2:if 2nd value of Tile
     * matches tileNum 3:if tileNum doesn't match any side of the Tile
     */
    public short matchSideOfTile(int tileNum) {
        if (t1 == tileNum) {
            return 1;
        } else if (t2 == tileNum) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * This method checks if both of the values of the given Tile equal to the
     * values of the Tile of this class(not necessary in the same order).
     *
     * @param tile a Tile to be compared with
     * @return true: if the given tile equals to the one of the class,otherwise
     * false
     */
    public boolean equalTile(Tile tile) {
        int tile1 = tile.getT1();
        int tile2 = tile.getT2();
        return (tile1 == t1 && tile2 == t2) || (tile1 == t2 && tile2 == t1);
    }

    /**
     * This method checks if both values of a Tile are the same.
     *
     * @return true if both values are the same,otherwise false
     */
    public boolean isDouble() {
        return (t1 == t2);
    }

    /**
     * Gets the value of any side of a Double Tile.
     *
     * @return t1 if Tile is Double,otherwise -1
     */

    public int getDouble() {
        if (this.isDouble()) {
            return t1;
        } else {
            return -1;
        }
    }

    /**
     * Gets the sum of the 2 values of a Tile
     *
     * @return sum An integer containing the sum of the 2 values of a Tile.
     */
    public int getSum() {
        int sum = t1 + t2;
        return sum;
    }

    /**
     * This method creates a String Object representing a Tile like this :
     * [t1|t2]
     *
     * @return a string representing the digital visualization of a Tile
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("[").append(t1).append("|").append(t2).append("]").toString();
    }

}
