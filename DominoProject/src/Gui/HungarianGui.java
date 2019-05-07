package Gui;

import domino_project.Player;
import domino_project.SetOfTiles;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class represents the Graphical User Interface of
 * the Hungarian type of DominoGame.
 * It's a JFrame made with code and design that implements
 * the class MultiplayerGui.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class HungarianGui extends javax.swing.JFrame implements MultiplayerGui{
    
    private boolean buttonPressed;
    private int numberOfButton;
    int choice_YN;
    
     private i18n bundleObject;
    
     /**
     * Class Constructor.
     * Does all the generated code made in Design by us 
     * and some changes for internationalization reasons
     *  and adjusts the design to be better-looking(adding layouts,gaps,colors..).
     */
    public HungarianGui() {
        initComponents();
        
        bundleObject=new i18n();
        this.setTitle(bundleObject.getBundle().getString("hungarian"));
        jLabel3.setText(bundleObject.getBundle().getString("line"));
        jLabel2.setText(bundleObject.getBundle().getString("points"));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
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
    }
    /**
     * Shows hand of tiles of the Player playing Hungarian.
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
               // System.out.println(numberOfButton);
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
     * Shows "New Round" when the previous round is over.
     */
   public void newRound(){
       jLabel1.setText(bundleObject.getBundle().getString("newRound"));
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
    * @param players representing 
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
    * Shows who is currently playing.
    * @param name String representing the name of
    * Player-Bot who is currrently playing.
    */
   public void playerIsPlaying(String name){
       jLabel1.setText(name+" "+bundleObject.getBundle().getString("isPlaying")+".");
   }
   /**
    * Asks the name of the Player playing Hungarian.
    * @return the name of the Player playing Hungarian.
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

        jLabelName.setText("jLabel5");

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
                        .addGap(205, 205, 205)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(303, 303, 303))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelName))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    
}
