
package gui;


import management.Accounts;
import validate.Validations;

import javax.swing.*;
import java.awt.Image;

public class Modify extends javax.swing.JFrame {

    private String serialNumber;

    public Modify(String serialNumber) {
        initComponents();
        javax.swing.JTextField[] textFields = {name, phone, email};

        this.serialNumber = serialNumber;

        for (javax.swing.JTextField textField : textFields) {
            addEnterKeyListener(textField);
            addEscKeyListener(textField);
        }
        addEscKeyListener();
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        modifyAccountButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modify Account");
        setFocusable(true);

        jLabel1.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jLabel1.setText("Name :");

        jLabel2.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jLabel2.setText("Email :");

        jLabel3.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jLabel3.setText("Phone: ");

        modifyAccountButton.setBackground(new java.awt.Color(0, 102, 51));
        modifyAccountButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        modifyAccountButton.setForeground(new java.awt.Color(255, 255, 255));
        modifyAccountButton.setText("Modify");
        modifyAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAccountButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("");
        ImageIcon icon = new ImageIcon("Imgs\\Modify.png");
        Image originalImage = icon.getImage();
        Image resizedImage = originalImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        setIconImage(resizedIcon.getImage());

        jLabel5.setIcon(resizedIcon);
        jLabel5.setHorizontalTextPosition(jLabel5.CENTER);
        jLabel5.setVerticalTextPosition(jLabel5.TOP);

        email.setFont(new java.awt.Font("Sora Medium", 0, 14)); // NOI18N
        email.setToolTipText("Enter Your New Email");
        email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        phone.setFont(new java.awt.Font("Sora Medium", 0, 14)); // NOI18N
        phone.setToolTipText("Enter Your New Phone Number");
        phone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));


        name.setFont(new java.awt.Font("Sora Medium", 0, 14)); // NOI18N
        name.setToolTipText("Enter Your New Name");
        name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));


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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(name)
                                        .addComponent(email)
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(modifyAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(backButton))
                                .addGap(0, 90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))

                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(57, 57, 57)
                                .addComponent(modifyAccountButton)
                                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>


    private void addEnterKeyListener(javax.swing.JTextField textField) {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    modifyAccountButtonActionPerformed(null);
                }
            }
        });
    }


    private void modifyAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {
        StringBuilder errorMessage = new StringBuilder();


        String newName = name.getText();
        String newEmail = email.getText();
        String newPhone = phone.getText();


        if (!Validations.isFullName(newName)) {
            errorMessage.append("Invalid Name!\n");
        }

        if (Validations.isEmail(newEmail) == 0) {
            errorMessage.append("Invalid Email Address!\n");
        }

        if (Validations.isEmail(newEmail) == -1) {
            errorMessage.append("Email Address already exists!\n");
        }

        if (Validations.isPhone(newPhone) == 0) {
            errorMessage.append("Invalid Phone Number!\n");
        }

        if (Validations.isPhone(newPhone) == -1) {
            errorMessage.append("Phone Number already exists!\n");
        }

        if (!errorMessage.isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Accounts.modifyAccount(this.serialNumber, newName, newEmail, newPhone);
            JOptionPane.showMessageDialog(null, "Modification successful", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        this.setVisible(false);
        menu.setVisible(true);
    }


    private javax.swing.JButton backButton;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton modifyAccountButton;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;

}
