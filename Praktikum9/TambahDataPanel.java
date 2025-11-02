package com.mycompany.praktikum9;

import java.awt.Color;
import javax.swing.JOptionPane;

public class TambahDataPanel extends javax.swing.JPanel {

    public TambahDataPanel() {
        initComponents();
        namaAlert.setText("");
        nimAlert.setText("");
        prodiAlert.setText("");
        jkAlert.setText("");
        statusAlert.setText("");
    }
    
    private void clearForm(){
        namaTextField.setText(" ");
        nimTextField.setText(" ");
        lakiLakiRB.setSelected(false);
        perempuanRB.setSelected(false);
        aktifCheckBox.setSelected(false);
        
        buttonGroup1.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nimTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        prodiComboBox = new javax.swing.JComboBox<>();
        lakiLakiRB = new javax.swing.JRadioButton();
        perempuanRB = new javax.swing.JRadioButton();
        aktifCheckBox = new javax.swing.JCheckBox();
        kirimButton = new javax.swing.JButton();
        namaAlert = new javax.swing.JLabel();
        nimAlert = new javax.swing.JLabel();
        prodiAlert = new javax.swing.JLabel();
        jkAlert = new javax.swing.JLabel();
        statusAlert = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setText("Tambah Data Mahasiswa");

        jLabel1.setText("Nama");

        jLabel2.setText("NIM");

        jLabel3.setText("Prodi");

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Status");

        nimTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextFieldActionPerformed(evt);
            }
        });

        prodiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S1 Teknik Informatika", "S1 Teknik Elektro", "D3 Teknik Elektro" }));

        buttonGroup1.add(lakiLakiRB);
        lakiLakiRB.setText("Laki-laki");

        buttonGroup1.add(perempuanRB);
        perempuanRB.setText("Perempuan");
        perempuanRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanRBActionPerformed(evt);
            }
        });

        aktifCheckBox.setText("Aktif");

        kirimButton.setBackground(new java.awt.Color(255, 243, 249));
        kirimButton.setText("Kirim");
        kirimButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimButtonActionPerformed(evt);
            }
        });

        namaAlert.setText("jLabel7");

        nimAlert.setText("jLabel7");

        prodiAlert.setText("jLabel7");

        jkAlert.setText("jLabel7");

        statusAlert.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67)
                                .addComponent(namaTextField))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(prodiComboBox, 0, 321, Short.MAX_VALUE)
                                        .addComponent(nimTextField))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(aktifCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lakiLakiRB)
                                            .addGap(18, 18, 18)
                                            .addComponent(perempuanRB)))
                                    .addComponent(kirimButton)
                                    .addComponent(namaAlert)
                                    .addComponent(nimAlert)
                                    .addComponent(prodiAlert)
                                    .addComponent(jkAlert)
                                    .addComponent(statusAlert))))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(namaAlert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(nimAlert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prodiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prodiAlert)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lakiLakiRB)
                    .addComponent(perempuanRB))
                .addGap(5, 5, 5)
                .addComponent(jkAlert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(aktifCheckBox))
                .addGap(5, 5, 5)
                .addComponent(statusAlert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kirimButton)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void nimTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nimTextFieldActionPerformed

    private void perempuanRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perempuanRBActionPerformed

    private void kirimButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimButtonActionPerformed
        String nama = namaTextField.getText();
        String nim = nimTextField.getText();
        String prodi = (String) prodiComboBox.getSelectedItem();
        String jk = lakiLakiRB.isSelected() ? "Laki-laki" : "Perempuan";
        boolean isActive = aktifCheckBox.isSelected();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, prodi, nim, isActive);
        Mahasiswa.mahasiswas.add(mahasiswa);

        JOptionPane.showMessageDialog(this, "Sukses menambahkan data mahasiswa " + nama);
        clearForm();

        boolean error = false;
        boolean cekNim = false;
        for (Mahasiswa m : Mahasiswa.mahasiswas) {
            if (m.getNim().equals(nim)) {
                cekNim = true;
                break;
            }
        }

        if (nama.isEmpty()) {
            namaAlert.setText("Nama tidak boleh kosongl");
            namaAlert.setForeground(Color.red);
            error = true;
        } else if (!nama.matches("[a-zA-Z\\s]+")) {
            namaAlert.setText("Nama hanya boleh berisi huruf!");
            namaAlert.setForeground(Color.red);
            error = true;
        }

        if (nim.isEmpty()){
        nimAlert.setText("NIM tidak boleh kosong!");
        nimAlert.setForeground(Color.red);
        error = true;
    }

    else if(!nim.matches("I\\d+")){
        nimAlert.setText("NIM harus berupa angka!");
        nimAlert.setForeground(Color.red);
        error = true;
    }
    else if (cekNim){
        nimAlert.setText("Mahasiswa dengan " + nim + " sudah terdaftar");
            nimAlert.setForeground(Color.red);
            error = true;
        }

        if (prodi == null || prodi.isEmpty()) {
            prodiAlert.setText("Prodi harus dipilih!");
            prodiAlert.setForeground(Color.red);
            error = true;
        }

        if (!lakiLakiRB.isSelected() && !perempuanRB.isSelected()){
        jkAlert.setText("Jenis kelamin harus dipilih!");
        jkAlert.setForeground(Color.red);
        error = true;
        }
        
        if (!aktifCheckBox.isSelected()){
        statusAlert.setText("Status harus dicentang!");
        statusAlert.setForeground(Color.red);
        error = true;
        }
        
        if (error) {
            return;
        }
    }//GEN-LAST:event_kirimButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox aktifCheckBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jkAlert;
    private javax.swing.JButton kirimButton;
    private javax.swing.JRadioButton lakiLakiRB;
    private javax.swing.JLabel namaAlert;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JLabel nimAlert;
    private javax.swing.JTextField nimTextField;
    private javax.swing.JRadioButton perempuanRB;
    private javax.swing.JLabel prodiAlert;
    private javax.swing.JComboBox<String> prodiComboBox;
    private javax.swing.JLabel statusAlert;
    // End of variables declaration//GEN-END:variables
}
