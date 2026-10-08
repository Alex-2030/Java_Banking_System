package gui;

import management.Transactions;
import validate.Validations;

import javax.swing.*;
import java.awt.Image;

public class Deposit extends javax.swing.JFrame {

    public Deposit() {
        initComponents();


        javax.swing.JTextField[] textFields = {accountNum, depositAmount};

        for (javax.swing.JTextField textField : textFields) {
            addEnterKeyListener(textField);
            addEscKeyListener(textField);
        }

        addEscKeyListener();
    }

    private void addEnterKeyListener(javax.swing.JTextField textField) {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    depositButtonActionPerformed(null);
                }
            }
        });
    }

    private void addEscKeyListener(javax.swing.JTextField textField) {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                    backButtonActionPerformed(null);
                }
            }
        });
    }

    private void addEscKeyListener() {
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                    backButtonActionPerformed(null);
                }
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        accountNum = new javax.swing.JTextField();
        depositButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        depositAmount = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("deposit");
        setFocusable(true);


        ImageIcon frameIcon = new ImageIcon("Imgs\\deposit.png");

        setIconImage(frameIcon.getImage());

        jLabel5.setText("");
        ImageIcon icon = new ImageIcon("Imgs\\deposit.png");
        Image originalImage = icon.getImage();
        Image resizedImage = originalImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        jLabel5.setIcon(resizedIcon);
        jLabel5.setHorizontalTextPosition(jLabel5.CENTER);
        jLabel5.setVerticalTextPosition(jLabel5.TOP);

        jLabel1.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jLabel1.setText("Account Number :");

        accountNum.setFont(new java.awt.Font("Sora Medium", 0, 14)); // NOI18N
        accountNum.setToolTipText("Enter The Account Number");
        accountNum.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        depositButton.setBackground(new java.awt.Color(66, 104, 91));
        depositButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        depositButton.setForeground(new java.awt.Color(255, 255, 255));
        depositButton.setText("deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jLabel2.setText("Deposited Amount:");

        depositAmount.setFont(new java.awt.Font("Sora Medium", 0, 14)); // NOI18N
        depositAmount.setToolTipText("Enter The deposit Amount");
        depositAmount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        backButton.setBackground(new java.awt.Color(0, 0, 122));
        backButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(52, 52, 52)
                                                                .addComponent(jLabel1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(46, 46, 46)
                                                                .addComponent(jLabel2)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(accountNum, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                                        .addComponent(depositAmount)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(backButton))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(accountNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(depositAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addComponent(depositButton)
                                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String serialNumber = accountNum.getText();
        String depositedAmount = depositAmount.getText();

        if (Validations.isDoubleDigit(depositedAmount)) {
            if (Validations.isDigit(serialNumber)) {
                int warning = Transactions.deposit(serialNumber, depositedAmount, 0);
                if (warning == 0) {
                    JOptionPane.showMessageDialog(null, "Account Not Found!", "Warning", JOptionPane.WARNING_MESSAGE);


                } else if (warning == -1) {
                    JOptionPane.showMessageDialog(null, "No Balance To Add!", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (warning == -2) {
                    JOptionPane.showMessageDialog(null, "Limit Exceeded!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Balance Added Successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Serial Number!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Amount!", "Warning", JOptionPane.WARNING_MESSAGE);

        }


    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        this.setVisible(false);
        menu.setVisible(true);
    }


//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new deposit().setVisible(true);
//            }
//        });
//    }


    private javax.swing.JTextField depositAmount;
    private javax.swing.JTextField accountNum;
    private javax.swing.JButton backButton;
    private javax.swing.JButton depositButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;

}
