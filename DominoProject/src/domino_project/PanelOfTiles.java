package domino_project;

import java.util.ArrayList;

/**
 * This class represents a Panel(matrix) Of 28 different Tiles with values in
 * [0,6] in which every Tile exists only once, using an ArrayList.It is an
 * ArrayList Of SetOfTiles(4 rows,7 columns).Imagine as a 2d Matrix which
 * contains the 28 tiles described above.
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class PanelOfTiles {

    private ArrayList<SetOfTiles> panel;

    /**
     * Class Constructor. Creates a panel of Tiles as described in the class
     * javadoc.
     */
    public PanelOfTiles() {
        SetOfTiles A = new SetOfTiles();
        A.fillSet28();
        panel = new ArrayList();
        for (int i = 0; i < 4; i++) {
            panel.add(new SetOfTiles());
            for (int j = 0; j < 7; j++) {
                panel.get(i).addTile(A.getTileByIndex(i * 7 + j));
            }

        }

    }

    /**
     * Gets the number of rows of this PanelOfTiles
     *
     * @return number of rows of this PanelOfTiles
     */
    public int getNumberOfRows() {
        return panel.size();
    }

    /**
     * Gets the Last Tile of a specified row of this Panel Of Tiles. If empty
     * returns null.
     *
     * @param row the row in which the Tile belongs to
     * @return returns the Last Tile of a specified row of this Panel Of Tiles
     * if it exists,else returns null.
     */
    public Tile getLastOfRow(int row) {
        if (panel.get(row).isEmpty()) {
            return null;
        }
        return panel.get(row).getLastTile();
    }

    /**
     * Checks if a specified row in this Panel Of Lines has no elements.
     *
     * @param row the row that this method checks if is empty
     * @return true if row has no elements,otherwise false
     */
    public boolean isRowEmpty(int row) {
        return panel.get(row).isEmpty();
    }

    /**
     * Removes last Tile of a specified row in Panel Of Tiles if this row
     * contains elements.
     *
     * @param row the specified row that the Tile will be removed from
     */
    public void removeLastOfRow(int row) {
        if (!panel.get(row).isEmpty()) {
            panel.get(row).removeLastTile();
        }

    }

    /**
     * Returns the Set Of Tiles of a Specified row. e.g. ( [3,3],[4,1] )
     *
     * @param row the specified row
     * @return Set Of Tiles of a Specified row
     */
    public SetOfTiles getSetOfRow(int row) {
        return panel.get(row);
    }

    /**
     * Checks if all rows of this Panel Of Tiles have no elements.
     *
     * @return true if all rows of this Panel Of Tiles have no elements,
     * otherwise false
     */
    public boolean panelIsEmpty() {
        boolean empty = true;
        for (int i = 0; i < 4 && empty == true; i++) {
            empty = this.isRowEmpty(i);
        }
        return empty;
    }

}
