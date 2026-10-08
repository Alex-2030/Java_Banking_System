package gui;

import management.Transactions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransactionHistory extends javax.swing.JFrame {


    public TransactionHistory(String serialNumber) {
        initComponents();
        loadData(serialNumber);
        addEscKeyListener();


        System.out.println(serialNumber);
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


    //Loads Data into the table
    public void loadData(String serialNumber) {
        for (int i = 0; i < Transactions.viewTransactionHistory(serialNumber).size(); i++) {

            ((DefaultTableModel) transactionTable.getModel()).addRow(Transactions.viewTransactionHistory(serialNumber).get(i));
        }
    }

    //Clears the table
    public void unloadData() {

        for (int i = transactionTable.getModel().getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) transactionTable.getModel()).removeRow(i);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        setTitle("Transaction History");


        ImageIcon frameIcon = new ImageIcon("Imgs\\History.png");

        setIconImage(frameIcon.getImage());


        backButton.setBackground(new java.awt.Color(0, 0, 112));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        transactionTable.setAutoCreateRowSorter(true);
        transactionTable.setFont(new java.awt.Font("Sora Medium", 0, 12)); // NOI18N
        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Serial Number", "Transaction Type", "Amount", "Date", "Description"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        transactionTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(transactionTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backButton))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        this.setVisible(false);
        unloadData();
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
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TransactionHistory().setVisible(true);
//            }
//        });
//    }

    private javax.swing.JTable transactionTable;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
}
