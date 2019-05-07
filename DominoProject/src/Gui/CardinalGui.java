package Gui;

import domino_project.Player;
import domino_project.SetOfTiles;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class represents the Graphical User Interface
 * reffering to the Cardinal Domino Type Of Game.
 * It's a JFrame made with code and design that implements
 * the class MultiplayerGui.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class CardinalGui extends javax.swing.JFrame implements MultiplayerGui{
    
    private boolean buttonPressed;
    private int numberOfButton;
    private int choice_YN;
    private ArrayList<Color> colors;
    private int colorcount;
    private boolean drawButton;
    private i18n bundleObject;
    
    /**
     * Class Constructor.
     * Does all the generated code made in Design by us 
     * and some changes for internationalization reasons,
     * initializes the variables used  and adjusts the
     * design to be better-looking(adding layouts,gaps,colors..).
     */
    public CardinalGui() {
        initComponents();
        
        bundleObject=new i18n();
        jLabel3.setText(bundleObject.getBundle().getString("line"));
        jLabel2.setText(bundleObject.getBundle().getString("points"));
        this.setTitle(bundleObject.getBundle().getString("cardinal"));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        drawButton=false;
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
             .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                 .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
                
        );
        
         layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE)
            )
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addContainerGap(400, Short.MAX_VALUE)
          
                 .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
        );
         
         colors= new ArrayList<>();
         colors.add(Color.CYAN);
         colors.add(Color.GREEN);
         colors.add(Color.MAGENTA);
         colorcount=0;
         jLabel1.setOpaque(true);
    }

    /**
     * Shows hand of tiles of the Player playing Cardinal.
     * @param setOfTiles a SetOfTiles representing the hand of player.
     */
    @Override
    public void showHand(SetOfTiles setOfTiles){
        jPanel2.removeAll();
        int i;
        for( i=0;i<setOfTiles.getSize();i++){
            JPanel mainpanel = new JPanel( new java.awt.GridLayout(2,1));
            JPanel linePanel = new JPanel( new java.awt.GridLayout(1,2));
            JLabel labelLine = new JLabel();
            JLabel labelLine2 = new JLabel();
            labelLine.setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(setOfTiles.getTileByIndex(i).getT1())+".png"));
            linePanel.add(labelLine);
            labelLine2.setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(setOfTiles.getTileByIndex(i).getT2())+".png"));
            linePanel.add(labelLine2);
            mainpanel.add(linePanel);
       
        
            JButton button= new JButton();
            button.setText(Integer.toString(i+1));
            button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
             
                buttonPressed=true;
                setNumberOfButton( Integer.parseInt(e.getActionCommand()) );
                System.out.println(numberOfButton);
            }
        });
            mainpanel.add(button);
            
            jPanel2.add(mainpanel);
        }
        for(int j=i;j<12;j++){
            jPanel2.add(new JPanel());
        }
        pack();
    }
   /**
    * Returns the number-"name" of Button representing the Tile chosen 
    * from the hand of Player.
    * @return the number-"name" of Button representing the Tile chosen 
    * from the hand of Player.(-1 represents that noone of the Buttons
    * where pressed)
    */ 
    @Override
   public int readFromHand(){
        
        if(buttonPressed){
            buttonPressed=false;
            return numberOfButton;
            
        }else{
            return -1;
        }
        
    }
   /**
    * Shows a message to the Player-Bot giving them the choice to
    * choose where to put the chosen tile that fits both on beggining and
    * in the end.
    * @return 1 for "YES",2 for "NO
    */
    public int giveChoice(){
        
        JDialog choice=new JDialog(this,true);
        choice.setTitle(bundleObject.getBundle().getString("chooseSide"));
        choice.setSize(250, 80);
        choice.setLocationRelativeTo(this);
        JButton button1=new JButton();
        JButton button2=new JButton();
        button1.setText(bundleObject.getBundle().getString("beggining"));
        button2.setText(bundleObject.getBundle().getString("ending"));
        choice.setLayout(new java.awt.GridLayout(1,2));
        choice.add(button1);
        choice.add(button2);
        button1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
             
            actionY();
            choice.dispose();
                
            }
        });
        
        button2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
             
            actionN();
              choice.dispose();   
            }
        });
        
        choice.setVisible(true);
        pack();
        
        return choice_YN;
        
    }
    /**
     * Sets "choice_YN" to 1,representing YES(TRUE).
     */
    private void actionY(){
        this.choice_YN=1;
    }
    /**
     * Sets "choice_YN" to 2,representing NO(FALSE).
     */
    private void actionN(){
        this.choice_YN=2;
    }
    
   /**
    * Sets the amount of tiles left in the drawing-tile stack. 
    * @param amount  the amount of tiles left in the drawing-tile stack. 
    */
    public void showCloseSet(int amount){
        jButtonDrawCard.setText(Integer.toString(amount));
        
    }
    /**
     * Shows message about necessarily drawing a tile from stack.
     */
    public void showDrawCard(){
        jLabel1.setText(bundleObject.getBundle().getString("drawMessage"));
        
        jLabel1.setBackground(colors.get((colorcount++)%3));
        
    }
    /**
     * Shows "New Round" when the previous round is over.
     */
   public void newRound(){
       jLabel1.setText(bundleObject.getBundle().getString("newRound"));
       jLabel1.setBackground(colors.get((colorcount++)%3));
   }
   /**
    * Shows the Winner of the Game.
    * @param name String representing the Winner of the Game
    */
    @Override
   public void showWinner(String name){
       JOptionPane.showMessageDialog(this,bundleObject.getBundle().getString("winner")+" "+name+"!!",bundleObject.getBundle().getString("gameWinner"),JOptionPane.INFORMATION_MESSAGE);
       this.dispose();
   }
   /**
    * Shows the points collected by  Player-Bots playing the game.
    * @param players ArrayList representing 
    * the names of the players.
    */
    @Override
   public void showPoints(ArrayList<Player> players){
       jPanel3.removeAll();
       for(int i=0;i<players.size();i++){
           jPanel3.add(new JLabel(players.get(i).getName()));
           jPanel3.add(new JLabel(Integer.toString(players.get(i).GetPoints())));
       }
   }
   /**
    * Sets variable "drawButton" to false.
    */
   public void setDrawButtonFalse(){
       drawButton=false;
   }
   /**
    * Shows who is currently playing.
    * @param name String representing the name of
    * Player-Bot who is currrently playing.
    */
   public void playerIsPlaying(String name){
       jLabel1.setText(name+" "+bundleObject.getBundle().getString("isPlaying")+".");
       jLabel1.setBackground(colors.get((colorcount++)%3));
   }
   /**
    * Asks if the Player-Bot wants their tile to be reversed.
    * @return true if tile to be reversed
    *         false if tile not to be reversed.
    */
   public boolean askForReverse(){
        JDialog reverse=new JDialog(this,true);
        reverse.setTitle(bundleObject.getBundle().getString("reverse"));
        reverse.setSize(250, 80);
         reverse.setLocationRelativeTo(this);
        JButton button1=new JButton();
        JButton button2=new JButton();
        button1.setText(bundleObject.getBundle().getString("yes"));
        button2.setText(bundleObject.getBundle().getString("no"));
        reverse.setLayout(new java.awt.GridLayout(1,2));
        reverse.add(button1);
        reverse.add(button2);
        button1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
             
            actionY();
            reverse.dispose();
                
            }
        });
        
        button2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
             
            actionN();
              reverse.dispose();   
            }
        });
        
        reverse.setVisible(true);
        pack();
          return choice_YN==1;
   }
   /**
    * Represents if Player playing this game want to draw a Tile.
    * @return 1 if wants to draw Tile,0 if pressed a button to put a Tile,
    * otherwise -1.
    */
   public int wantToDraw(){
       if(drawButton==true){
           drawButton = false;
           return 1;
       }else if(buttonPressed==true){
           return 0;
       }else{
           return -1;
       }
           
   }
   /**
    * Asks the name of the Player playing Cardinal.
    * @return the name of the Player playing Cardinal.
    */
    @Override
    public String askName(){
        String name;
        name =  JOptionPane.showInputDialog(this,bundleObject.getBundle().getString("name"), bundleObject.getBundle().getString("userName"), JOptionPane.QUESTION_MESSAGE);
        jLabelName.setText(name);
        return name;
    }
    /**
     * Sets the number-"name" of the Button.(used for Player's hand)
     * @param i an int representing the number-"name" of the Button minus one.
     */
    private void setNumberOfButton(int i){
        numberOfButton=i-1;
    }
    /**
     * Shows who is drawing a domino from the stack.
     * @param name String representing the name of the player-bot
     * who's drawing a domino from the stack.
     */
    public void selectFromSet(String name){
       jLabel1.setText(name+" "+bundleObject.getBundle().getString("drawDomino"));
       jLabel1.setBackground(colors.get((colorcount+1)%3));
    }
    /**
     * Sets variable buttonPressed as false.
     */
    public void setFalseButtonPressed(){
        buttonPressed=false;
    }
    /**
     * Shows InvalidInput when entered input is incorrect.
     */
    @Override
    public void showInvalidInput() {
        JOptionPane.showMessageDialog(this,bundleObject.getBundle().getString("invalidInput"), "",JOptionPane.ERROR_MESSAGE);
        buttonPressed=false;
    }
    /**
     * Shows "Your Turn" when player is playing.
     */
    public void showTurn(){
        jLabel1.setText(bundleObject.getBundle().getString("yourTurn"));
        jLabel1.setBackground(colors.get((colorcount+1)%3));
    }
    /**
     * Shows who is able to play a tile.
     * @param name name of Player-Bot who's able to play
     */
    public void showAbleToPlay(String name){
        jLabel1.setText(" "+name+" "+bundleObject.getBundle().getString("ablePlaying"));
        jLabel1.setBackground(colors.get((colorcount+1)%3));
    }
    /**
     * Shows the Line of Tiles that are played by Bots and Player.
     * @param setOfTiles SetOfTiles representing the tiles that are put on Line.
     */
    @Override
     public void showLine(SetOfTiles setOfTiles) {
        jPanel1.removeAll();
        for(int i=0;i<setOfTiles.getSize();i++){
            JPanel linePanel = new JPanel( new java.awt.GridLayout(1,2));
            JLabel labelLine = new JLabel();
            JLabel labelLine2 = new JLabel();
            labelLine.setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(setOfTiles.getTileByIndex(i).getT1())+".png"));
            linePanel.add(labelLine);
            labelLine2.setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(setOfTiles.getTileByIndex(i).getT2())+".png"));
            linePanel.add(labelLine2);
            jPanel1.add(linePanel);
        }
        
        pack();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * Code Generated automatticaly when design was made.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jButtonDrawCard = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hungarian");
        setMaximumSize(new java.awt.Dimension(1112, 507));
        setMinimumSize(new java.awt.Dimension(1112, 507));

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(new java.awt.GridLayout(0, 7, 3, 5));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(new java.awt.GridLayout(0, 6, 3, 3));

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setLayout(new java.awt.GridLayout(4, 2, 5, 5));

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/points.png"))); // NOI18N
        jLabel2.setText("Points");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LINE");
        jLabel3.setOpaque(true);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        jLabelName.setBackground(new java.awt.Color(255, 102, 0));
        jLabelName.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jLabelName.setOpaque(true);

        jButtonDrawCard.setBackground(new java.awt.Color(255, 102, 0));
        jButtonDrawCard.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButtonDrawCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDrawCardActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stack.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(127, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jButtonDrawCard, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(303, 303, 303))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDrawCard, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sets "drawButton" as true.Represents that they want to draw a tile.
     * @param evt ActionEvent of Button
     */
    private void jButtonDrawCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDrawCardActionPerformed
       drawButton = true;
    }//GEN-LAST:event_jButtonDrawCardActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDrawCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    
}
