package Gui;

/**
 * This class represents an information Dialog that consists
 * of a photo of this game's designers.
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class InformationDialog extends javax.swing.JDialog {

    
    private i18n bundleObject;
    /**
     * Class Constructor.
     *  Does all the generated code made in Design by us
     * and some changes for internationalization reasons.
     * @param parent Frame representing the "parent" of this jDialog
     * @param modal boolean representing if this JDialog is modal
     */
    public InformationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        bundleObject=new i18n();
        initComponents();
        jLabel1.setText(bundleObject.getBundle().getString("gameDesigners"));
        this.setTitle(bundleObject.getBundle().getString("information"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * Code Generated automatticaly when design was made.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Designers.jpg"))); // NOI18N
        getContentPane().add(jLabel2, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GAME DESIGNERS");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
