
package gui;

import management.Accounts;

import javax.swing.*;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        addAccountButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        depositButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        withdrawButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();
        interestButton = new javax.swing.JButton();
        viewAccountsButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        transactionsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        setTitle("Menu");

        ImageIcon icon = new ImageIcon("Imgs\\Menu.png");

        setIconImage(icon.getImage());

        addAccountButton.setBackground(new java.awt.Color(0, 102, 51));
        addAccountButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        addAccountButton.setForeground(new java.awt.Color(255, 255, 255));
        addAccountButton.setText("Add New Account");
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountButtonActionPerformed(evt);
            }
        });

        modifyButton.setBackground(new java.awt.Color(0, 102, 51));
        modifyButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        modifyButton.setForeground(new java.awt.Color(255, 255, 255));
        modifyButton.setText("Modify Account");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(0, 0, 0));
        closeButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("Close Account");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        depositButton.setBackground(new java.awt.Color(66, 104, 91));
        depositButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        depositButton.setForeground(new java.awt.Color(255, 255, 255));
        depositButton.setText("deposit");
        depositButton.setMaximumSize(new java.awt.Dimension(140, 24));
        depositButton.setMinimumSize(new java.awt.Dimension(78, 24));
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(62, 203, 196));
        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("MENU");

        withdrawButton.setBackground(new java.awt.Color(204, 102, 0));
        withdrawButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        withdrawButton.setForeground(new java.awt.Color(255, 255, 255));
        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        transferButton.setBackground(new java.awt.Color(0, 0, 122));
        transferButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        transferButton.setForeground(new java.awt.Color(255, 255, 255));
        transferButton.setText("Transfer");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        interestButton.setBackground(new java.awt.Color(0, 0, 122));
        interestButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        interestButton.setForeground(new java.awt.Color(255, 255, 255));
        interestButton.setText("Apply Interest");
        interestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interestButtonActionPerformed(evt);
            }
        });

        viewAccountsButton.setBackground(new java.awt.Color(0, 0, 122));
        viewAccountsButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        viewAccountsButton.setForeground(new java.awt.Color(255, 255, 255));
        viewAccountsButton.setText("View Accounts");
        viewAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAccountButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 0, 122));
        searchButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search Account");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        transactionsButton.setBackground(new java.awt.Color(0, 0, 122));
        transactionsButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        transactionsButton.setForeground(new java.awt.Color(255, 255, 255));
        transactionsButton.setText("Transactions History");
        transactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(255, 51, 51));
        logoutButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(logoutButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(transactionsButton, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(viewAccountsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(modifyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addAccountButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(82, 82, 82)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(depositButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(withdrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                        .addComponent(transferButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(interestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(183, 183, 183)
                                                .addComponent(jLabel1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addAccountButton)
                                        .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(modifyButton)
                                        .addComponent(withdrawButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(viewAccountsButton)
                                        .addComponent(transferButton))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchButton)
                                        .addComponent(interestButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(transactionsButton)
                                        .addComponent(closeButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(logoutButton)
                                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void addAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {
        AddAccount add = new AddAccount();
        this.setVisible(false);
        add.setVisible(true);
    }

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Modify_1 modify = new Modify_1();
        this.setVisible(false);
        modify.setVisible(true);
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CloseAccount close = new CloseAccount();
        this.setVisible(false);
        close.setVisible(true);
    }

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Deposit deposit = new Deposit();
        this.setVisible(false);
        deposit.setVisible(true);
    }

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Withdraw withdraw = new Withdraw();
        this.setVisible(false);
        withdraw.setVisible(true);
    }

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Transfer transfer = new Transfer();
        this.setVisible(false);
        transfer.setVisible(true);
    }

    private void interestButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Accounts.applyInterest();
    }

    private void viewAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ViewAccounts view = new ViewAccounts();
        this.setVisible(false);
        view.setVisible(true);
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ViewAccounts view = new ViewAccounts();
        this.setVisible(false);
        view.setVisible(true);
    }

    private void transactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {
       TransactionEntry entry = new TransactionEntry();
       this.setVisible(false);
       entry.setVisible(true);
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
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
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//            }
//        });
//    }

    private javax.swing.JButton addAccountButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton depositButton;
    private javax.swing.JButton interestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton transactionsButton;
    private javax.swing.JButton transferButton;
    private javax.swing.JButton viewAccountsButton;
    private javax.swing.JButton withdrawButton;
}
