package domino_project;

/**
 * This class represents a Specific DominLine used
 * in CardinalGame of DominoGame according to its rules.
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class CardinalDominoLine extends SetOfTiles implements DominoLine{
   
    /**
 * @see DominoLine
 * {@inheritDoc}
 */
    @Override
    public void addTileOnBeginning(Tile tile) {
        addTileByIndex(tile, 0);
    }
        /**
 * @see DominoLine
 * {@inheritDoc}
 */
    @Override
    public void addTileAtTheEnd(Tile tile) {
        addTile(tile);
    }
/**
 * @see DominoLine
 * {@inheritDoc}
 * 
 * "matches" means touching sides' sum equals to 7
 * e.g.[4,4][3,1][6,1] (3+4=7,1+6=7)
 */
    @Override
    public short fitsOnBeginning(Tile tile) {
       if(isEmpty()){
           return 1;
       }
       if(tile.getT1()+this.getFirstTile().getT1()==7  ){
           return 1;
       }
       else if(tile.getT2()+this.getFirstTile().getT1()== 7 || tile.getSum()==7 || tile.getSum()==0){
           return 2;
       }
       else{
           return 0;
       }
    }
/**
 * @see DominoLine
 * {@inheritDoc}
 * 
 * "matches" means touching sides' sum equals to 7
 * e.g.[4,4][3,1][6,1] (3+4=7,1+6=7)
 */
    @Override
    public short fitsAtTheEnd(Tile tile) {
        if(isEmpty()){
            return 1;
        }
       if(tile.getT1()+this.getLastTile().getT2()==7 || tile.getSum()==7 || tile.getSum()==0){
           return 1;
       }
       else if(tile.getT2()+this.getLastTile().getT2()== 7){
           return 2;
       }
       else{
           return 0;
       }
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
    public SetOfTiles getSetOfTiles() {
        return this;
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
