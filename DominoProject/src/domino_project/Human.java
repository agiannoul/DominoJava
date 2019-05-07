package domino_project;

/**
 * This class represents a human-user 
 * playing a DominoGame implementing Player.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class Human implements Player{
    private SetOfTiles hand;
    private int points;
    private String name;
    
   /**
    * Class Constructor.
    * Points start from 0,hand gets initialized and Human
    * gets their name.
    * @param name a String representing the name Of Human
    */
   public Human(String name){
        hand=new SetOfTiles();
        points=0;
        this.name=name;
    }
    
        /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public void fillhand(SetOfTiles set){
        hand=set;
    }
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public String getName(){
        return name;
    }
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public void ClearHand(){
        hand=new SetOfTiles();
    }
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public int  getHandpoints(){
        int sum=0;
        for(int i=0;i<hand.getSize();i++){
                sum += hand.getTileByIndex(i).getSum();
        }
        return sum;
    }
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public int getHighiestDoubleTile(){
        int maxDouble=-1;
        for(int i=0;i<hand.getSize();i++){
            if(hand.getTileByIndex(i).isDouble()){
                if(maxDouble<hand.getTileByIndex(i).getDouble()){
                    maxDouble=hand.getTileByIndex(i).getDouble();
                }
            }
        }
        return maxDouble;
    }
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
     public void addPoints(int x){
       this.points+=x;
    }
    
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public int GetPoints(){
        return points;
    }
    
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public boolean removeTileByIndex(int x){
        return hand.removeByIndex(x);
    }
    
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public Tile getTileByIndex(int x){
        return hand.getTileByIndex(x);
    }
    
    
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public boolean handIsEmpty(){
        return hand.isEmpty();
    }
            /**
 * @see Player
 * {@inheritDoc}
 */
    @Override
    public SetOfTiles getHand(){
        return hand;
    }
      
    
}
