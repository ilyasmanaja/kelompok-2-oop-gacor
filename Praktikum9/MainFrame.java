package com.mycompany.hm;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    public MainFrame() {
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

        jPanel2 = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();
        tambahData = new javax.swing.JButton();
        lihatData = new javax.swing.JButton();
        basePanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        sidebarPanel.setBackground(new java.awt.Color(255, 245, 245));

        tambahData.setText("Tambah Data");
        tambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahDataActionPerformed(evt);
            }
        });

        lihatData.setText("Lihat Data");
        lihatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lihatData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambahData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(tambahData)
                .addGap(41, 41, 41)
                .addComponent(lihatData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        basePanel.setBackground(new java.awt.Color(255, 255, 255));
        basePanel.setPreferredSize(new java.awt.Dimension(530, 400));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(530, 400));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(basePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lihatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatDataActionPerformed
        changeMainPanel(new LihatDataPanel());
    }//GEN-LAST:event_lihatDataActionPerformed

    private void tambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahDataActionPerformed
        changeMainPanel(new TambahDataPanel());
    }//GEN-LAST:event_tambahDataActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lihatData;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JButton tambahData;
    // End of variables declaration//GEN-END:variables
}
