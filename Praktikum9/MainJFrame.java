package com.mycompany.praktikum9;

public class MainJFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainJFrame.class.getName());

    public MainJFrame() {
        initComponents();
    }

    public void changeMainPanel(javax.swing.JPanel panel) {
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        tambahDataButton = new javax.swing.JButton();
        lihatDataButton = new javax.swing.JButton();
        basePanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 430));
        setPreferredSize(new java.awt.Dimension(500, 430));

        sideBar.setBackground(new java.awt.Color(255, 243, 249));

        tambahDataButton.setText("Tambahkan Data");
        tambahDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahDataButtonActionPerformed(evt);
            }
        });

        lihatDataButton.setText("Lihat Data");
        lihatDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tambahDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lihatDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(tambahDataButton)
                .addGap(18, 18, 18)
                .addComponent(lihatDataButton)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        getContentPane().add(sideBar, java.awt.BorderLayout.LINE_START);

        basePanel.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(500, 430));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(basePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahDataButtonActionPerformed
        changeMainPanel(new TambahDataPanel());
    }//GEN-LAST:event_tambahDataButtonActionPerformed

    private void lihatDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatDataButtonActionPerformed
        changeMainPanel(new LihatDataPanel());
    }//GEN-LAST:event_lihatDataButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainJFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JButton lihatDataButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sideBar;
    private javax.swing.JButton tambahDataButton;
    // End of variables declaration//GEN-END:variables
}
