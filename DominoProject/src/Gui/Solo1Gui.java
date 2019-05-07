package Gui;

import domino_project.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class represents the Graphical User Interface
 * reffering to the Solo1 Domino Type Of Game.
 * It's a JFrame made with code and design.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class Solo1Gui extends javax.swing.JFrame {

    private JPanel[] panel;
    private JLabel[] label;
    private int buttonNumber;
    private boolean buttonPressed;
    int choice_YN;
    private i18n bundleObject;
    
    /**
     * Class Constructor.
     * Does all the generated code made in Design by us 
     * and some changes for internationalization reasons,
     * initializes the variables used  and adjusts the
     * design to be better-looking(adding layouts,gaps,colors..).
     */
    public Solo1Gui() {
        initComponents();
        
        //i18n
        bundleObject=new i18n();
        jLabel5.setText(bundleObject.getBundle().getString("line"));
        this.setTitle(bundleObject.getBundle().getString("solo1"));
        
        
         panel=new JPanel[28];
         label=new JLabel[56];
         
        //initialization
        for(int i=0;i<panel.length;i++){
            panel[i]=new JPanel();
        }
        for(int j=0;j<label.length;j++){
            label[j]=new JLabel();
        }
        for(JPanel p:panel){
            p.setLayout(new java.awt.GridLayout(1,2));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE)
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
                
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE)
            )
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addContainerGap(400, Short.MAX_VALUE)

                 .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
        );
        
        
        pack();
    }
    /**
     * Forms this Frame with the main components
     * for the user to be "welcomed" to this Game.
     * @param panelOfTiles he Panel of Tiles that the player 
     * will choose from to place on Line.
     */
    public void welcomeToSolo1(PanelOfTiles panelOfTiles){
        int count=0;
        for(int i = 0; i < panelOfTiles.getNumberOfRows(); i++){
            int j;
            
            for(j=0;j<panelOfTiles.getSetOfRow(i).getSize();j++){
                label[count].setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(panelOfTiles.getSetOfRow(i).getTileByIndex(j).getT1())+".png"));
                label[count+1].setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(panelOfTiles.getSetOfRow(i).getTileByIndex(j).getT2())+".png"));
                panel[i*7+j].add(label[count]);
                panel[i*7+j].add(label[count+1]);
                jPanel1.add(panel[i*7+j]);
                count+=2;
            }
            for(int q=j;q<7;q++){
                panel[i*7+q]=new JPanel();
                jPanel1.add(panel[i*7+q]);
            }
             
        }
        pack();
    }
    /**
     * Shows the Panel of Tiles that the player 
     * will choose from to place on Line.
     * @param panelOfTiles the Panel of Tiles that the player 
     * will choose from to place on Line.
     */
    public void showPanel(PanelOfTiles panelOfTiles){
        jPanel1.removeAll();
       
        
        for(int i = 0; i < panelOfTiles.getNumberOfRows(); i++){
            int j;
            
            for(j=0;j<panelOfTiles.getSetOfRow(i).getSize();j++){
                
                jPanel1.add(panel[i*7+j]);
                
            }
            for(int q=j;q<7;q++){
                panel[i*7+q]=new JPanel();
                jPanel1.add(panel[i*7+q]);
            }
             
        }
        pack();
       
    }
    /**
     * Sets variable buttonPressed as false.
     */
    public void setFalseButtonPressed(){
        buttonPressed=false;
    }
    /**
     * Returns the number-"name" of Button representing the Tile chosen 
     * from the Panel by Player.
     * @return the number-"name" of Button representing the Tile chosen 
     * from the Panel by Player.(-1 represents that noone of the Buttons
     * where pressed)
     */
    public int readTileFromPanel(){
        jLabel6.setText(bundleObject.getBundle().getString("chooseRow"));
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 11));
        if(buttonPressed){
            buttonPressed=false;
            return buttonNumber;
            
        }else{
            return -1;
        }
        
    }
    /**
     * Shows the result of the Game(victory/defeat).
     * @param win 1 for victory,otherwise means defeat
     */
    public void showResult(boolean win){
        if(win){
            JOptionPane.showMessageDialog(this," "+bundleObject.getBundle().getString("victory"),bundleObject.getBundle().getString("winner"),JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this," "+bundleObject.getBundle().getString("defeat"),bundleObject.getBundle().getString("looser"),JOptionPane.PLAIN_MESSAGE);
        }
    }
    /**
     * Shows InvalidInput when entered input is incorrect.
     */
    public void showInvalidInput(){
        
        JOptionPane.showMessageDialog(this,bundleObject.getBundle().getString("invalidInput"), "",JOptionPane.ERROR_MESSAGE);
    }
    /**
    * Shows a message to the Player-Bot giving them the choice to
    * choose where to put the chosen tile that fits both on beggining and
    * in the end.
    * @return 1 for "YES",2 for "NO
    */
    public int giveChoice(){
        
        JDialog choice=new JDialog(this,true);
        choice.setLocationRelativeTo(this);
        choice.setTitle(bundleObject.getBundle().getString("chooseSide"));
        choice.setSize(250, 80);

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
     * Shows the Line of Tiles that are played by Player.
     * @param setOfTiles SetOfTiles representing the tiles that are put on Line.
     */
    public void showSetOfTiles(SetOfTiles setOfTiles) {
        jPanel2.removeAll();
        for(int i=0;i<setOfTiles.getSize();i++){
            JPanel linePanel = new JPanel( new java.awt.GridLayout(1,2));
            JLabel labelLine = new JLabel();
            JLabel labelLine2 = new JLabel();
            labelLine.setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(setOfTiles.getTileByIndex(i).getT1())+".png"));
            linePanel.add(labelLine);
            labelLine2.setIcon(new javax.swing.ImageIcon("src/images/"+Integer.toString(setOfTiles.getTileByIndex(i).getT2())+".png"));
            linePanel.add(labelLine2);
            jPanel2.add(linePanel);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solo1");

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(new java.awt.GridLayout(4, 7, 5, 10));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(new java.awt.GridLayout(0, 8, 3, 5));

        jPanel3.setMinimumSize(new java.awt.Dimension(40, 250));
        jPanel3.setPreferredSize(new java.awt.Dimension(40, 250));
        jPanel3.setLayout(new java.awt.GridLayout(4, 1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("1.");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("2.");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setText("3.");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setText("4.");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel4);

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        jButton1.setText(" 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(255, 102, 0));
        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LINE");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Sets buttonPressed to "true" and buttonNumber to "0".
 * (Button is Pressed and it's the first one).
 * @param evt ActionEvent of Button
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.buttonNumber=0;
        buttonPressed=true;
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * Sets buttonPressed to "true" and buttonNumber to "1".
 * (Button is Pressed and it's the second one).
 * @param evt ActionEvent of Button
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.buttonNumber=1;
       buttonPressed=true;
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 * Sets buttonPressed to "true" and buttonNumber to "2".
 * (Button is Pressed and it's the third one).
 * @param evt ActionEvent of Button
 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.buttonNumber=2;
        buttonPressed=true;
    }//GEN-LAST:event_jButton3ActionPerformed
/**
 * Sets buttonPressed to "true" and buttonNumber to "3".
 * (Button is Pressed and it's the fourth one).
 * @param evt ActionEvent of Button
 */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.buttonNumber=3;
        buttonPressed=true;
    }//GEN-LAST:event_jButton4ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    
}
