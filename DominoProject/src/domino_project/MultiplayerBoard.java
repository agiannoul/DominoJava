package domino_project;

/**
 *This class represents a Multiplayer Board,a board for
 * Multiplayer Type of Domino Games.
 * It also extends Board.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class MultiplayerBoard extends Board{
    /**
     * SetOfTiles from where players get their hand.
     */
    protected SetOfTiles set;
    /**
     * Class Constructor.
     * Creates a new SetOfTiles.
     */
    public MultiplayerBoard(){
        set=new SetOfTiles();
        
    }
    /**
     * Fills the Set Of Tiles with 28 different Tiles with numbers in [0,6].
     * Every Tile exists only once.([0,0] [0,1] ...[6,5] [6,6]).
     */
    public void fillBoard(){
        set=new SetOfTiles();
        set.fillSet28();
    }
    /**
     * Clears the board creating a new one.
     */
    public void clearBoard(){
         set=new SetOfTiles();
         line.Clear();
    }
    /**
     * Returns a SetOfTiles consisting of the x last Tiles of this SetOfTiles
     * (represents the x Tiles from this SetOfTiles that are given to a player
     * to play.(hand))
     *
     * @param x the number of Tiles that will be removed from this SetOfTiles
     * and be added to the returned set.
     * @return a SetOfTiles with x Tiles from this SetOfTiles.
     */
    public SetOfTiles giveLastTiles(int x){
        SetOfTiles m=new SetOfTiles();
        for(int i=0;i<x && !set.isEmpty();i++){
            m.addTile(set.getLastTile());
            set.removeLastTile();
        }
        return m;
    }
    /**
     * Adds a specified Tile(tile1) on the Beggining of this DominoLine.
     *
     * @param tile1 Tile to be added
     */
    public void addTileOnBeggining(Tile tile1){
        line.addTileOnBeginning(tile1);
    }
     /**
     * Adds a specified Tile(tile1) at the end of the DominoLine.
     *
     * @param tile1 Tile to be added
     */
    public void addTileAtTheEnd(Tile tile1){
        line.addTileAtTheEnd(tile1);
    }
   
}
