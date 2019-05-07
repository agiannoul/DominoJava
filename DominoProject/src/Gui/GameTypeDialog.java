package Gui;

import domino_project.*;
import java.util.Locale;

/**
 *  This class represents a Menu for the player to choose
 * which game to play(Solo1,Hungarian,Cardinal) and the 
 * number of players at it.
 * 
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class GameTypeDialog extends javax.swing.JDialog {

    
    private i18n bundleObject;
    
    /**
     * Class Constructor.
     * Does all the generated code made in Design by us
     * and some changes for internationalization reasons.
     * @param parent Frame representing the "parent" of this jDialog
     * @param modal boolean representing if this JDialog is modal
     */
    public GameTypeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        bundleObject=new i18n();
        jButton2.setText(bundleObject.getBundle().getString("solo1"));
        jButton1.setText(bundleObject.getBundle().getString("cardinal"));
        jButton3.setText(bundleObject.getBundle().getString("hungarian"));
        jComboBox6.removeAllItems();
        jComboBox6.addItem("2 "+bundleObject.getBundle().getString("player"));
        jComboBox6.addItem("3 "+bundleObject.getBundle().getString("player"));
        jComboBox6.addItem("4 "+bundleObject.getBundle().getString("player"));
        jComboBox5.removeAllItems();
        jComboBox5.addItem("2 "+bundleObject.getBundle().getString("player"));
        jComboBox5.addItem("3 "+bundleObject.getBundle().getString("player"));
        jComboBox5.addItem("4 "+bundleObject.getBundle().getString("player"));
        jComboBox4.removeAllItems();
        jComboBox4.addItem("1 "+bundleObject.getBundle().getString("1player"));
        jLabel1.setText(bundleObject.getBundle().getString("chooseMenu"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * Code Generated automatticaly when design was made.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GameTypeMenu");
        setMaximumSize(new java.awt.Dimension(554, 378));
        setMinimumSize(new java.awt.Dimension(554, 378));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(null
        );
        jPanel1.setForeground(null);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setText("SOLO1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton1.setText("CARDINAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton3.setBackground(new java.awt.Color(255, 102, 0));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setText("HUNGARIAN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 130, 220, 210);

        jPanel2.setBackground(null

        );
        jPanel2.setForeground(null);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(3, 1));

        jComboBox4.setBackground(new java.awt.Color(255, 153, 0));
        jComboBox4.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Player" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox4);

        jComboBox5.setBackground(new java.awt.Color(255, 153, 0));
        jComboBox5.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Players", "3 Players", "4 Players" }));
        jPanel2.add(jComboBox5);

        jComboBox6.setBackground(new java.awt.Color(255, 153, 0));
        jComboBox6.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Players", "3 Players", "4 Players" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox6);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(270, 130, 120, 210);

        jLabel1.setBackground(null
        );
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Choose a Game!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 30, 210, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/players.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 80, 80, 40);

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackGround.jpg"))); // NOI18N
        getContentPane().add(jLabelBackground);
        jLabelBackground.setBounds(0, 0, 554, 378);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Opens a JFrame of Solo1Gui,creating-starting a Thread for a Solo1Game variable.
     * @param evt ActionEvent Of Button
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Solo1Gui a=new Solo1Gui();
        a.setVisible(true);
        //a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Solo1Game solo1=new Solo1Game(a);
        Thread game=new Thread(solo1);
        try{
            game.start();
        }catch(Exception e){
            
        };
        
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 * Creates-Starts a Thread of CardinalGame variable.
 * @param evt ActionEvent Of Button
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // System.out.print(jComboBox5.getSelectedIndex());
        CardinalGame cardinal=new CardinalGame(jComboBox5.getSelectedIndex()+2);
        
        Thread game=new Thread(cardinal);
        try{
            game.start();
        }catch(Exception e){
            
        };
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * Creates-Starts a Thread of HungarianGame variable.
 * @param evt ActionEvent Of Button
 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          
        //a.setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;
       // System.out.print(jComboBox6.getSelectedIndex());
        HungarianGame hungarian=new HungarianGame(jComboBox6.getSelectedIndex()+2);
        
        Thread game=new Thread(hungarian);
        try{
            game.start();
        }catch(Exception e){
            
        };
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /**
     * Does nothing because there is only 1 given item to select.
     * @param evt ActionEvent of Button
     */
    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
