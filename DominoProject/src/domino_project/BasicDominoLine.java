package domino_project;

/**
 * This class represents the 'basic' DominoLine according to
 * the idea: matching side of tiles means adding to Line.(used
 * in games such as Hungarian,Solo1)
 * e.g.[3,4] [4,1] [1,0]
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class BasicDominoLine extends SetOfTiles implements DominoLine {


    /**
     *@see DominoLine
 * {@inheritDoc} 
 */
    @Override
    public void addTileOnBeginning(Tile tile) {
        addTileByIndex(tile, 0);
    }
/**
 *@see DominoLine
 * {@inheritDoc}
 */
    @Override
    public void addTileAtTheEnd(Tile tile) {
        addTile(tile);
    }

    

    
/**
 *@see DominoLine
 * {@inheritDoc}
 * 
 * "matches" means that tiles have the same touching side
 * e.g. [3,4][4,5] (4=4)
 */
    @Override
    public short fitsOnBeginning(Tile tile) {
        if (isEmpty()) {
            return 1;
        }
        return tile.matchSideOfTile(this.getFirstTile().getT1());
    }
/**
 * @see DominoLine
 * {@inheritDoc}
 * 
 * * "matches" means that tiles have the same touching side
 * e.g. [3,4][4,5] (4=4)
 */
    @Override
    public short fitsAtTheEnd(Tile tile) {
        if (isEmpty()) {
            return 0;
        }
        return tile.matchSideOfTile(this.getLastTile().getT2());
    }
/**
 * @see DominoLine
 * {@inheritDoc}
 */
    @Override
    public SetOfTiles getSetOfTiles() {
        return this;
    }
/**
 * @see DominoLine
 * {@inheritDoc}
 */
    @Override
    public boolean isEmpty(){
        return super.isEmpty();
    }
/**
 * @see DominoLine
 * {@inheritDoc}
 */
    @Override
    public void Clear() {
        for(int i=this.getSize()-1;i>=0;i--){
            this.removeByIndex(i);
        }
    }

}
