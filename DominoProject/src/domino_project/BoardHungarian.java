package domino_project;

/**
 * This class represents the board of a Hungarian type of Domino Game. This
 * board consists of a DominoLine on where the player and bot put their Tiles
 * and of a SetOfTiles from where they get their hand.
 * It also extends MultiplayerBoard.
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class BoardHungarian extends MultiplayerBoard{
    
    
    /**
     * Class Constructor.
     * Line is initialized.
     */
    public BoardHungarian(){
    
        line=new BasicDominoLine();
    }
    
    
    
}
