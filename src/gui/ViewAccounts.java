package gui;

import management.Accounts;
import validate.Validations;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewAccounts extends javax.swing.JFrame {

    public ViewAccounts() {
        initComponents();
        loadData();

        javax.swing.JTextField[] textFields = {searchField};

        for (javax.swing.JTextField textField : textFields) {
            addTextFieldKeyListener(textField);
            addEscKeyListener(textField);
            addEnterKeyListener(textField);
        }

        javax.swing.JComboBox[] comboBoxes = {sortOptions};

        for (javax.swing.JComboBox comboBox : comboBoxes) {
            addEnterKeyListener(comboBox);
            addEscKeyListener(comboBox);
        }

        addEscKeyListener();

    }

    private void addEnterKeyListener(javax.swing.JTextField textField) {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    searchButtonActionPerformed(null);
                }
            }
        });
    }

    private void addEnterKeyListener(javax.swing.JComboBox comboBox) {
        comboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    sortButtonActionPerformed(null);
                }
            }
        });
    }


    private void addTextFieldKeyListener(javax.swing.JTextField textField) {

        textField.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {

                String keyword = textField.getText();
                if (Validations.isLetter(keyword)) {
                    unloadData();

                    ArrayList<String[]> searchResults = Accounts.searchAccounts(keyword);

                    if (!searchResults.isEmpty()) {

                        for (String[] data : searchResults) {

                            ((DefaultTableModel) accountsTable.getModel()).addRow(data);
                        }
                    }
                }
            }
        });
    }

    private void addEscKeyListener(javax.swing.JComboBox comboBox) {
        comboBox.addKeyListener(new java.awt.event.KeyAdapter() {
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
    public void loadData() {
        for (int i = 0; i < Accounts.viewAccounts().size(); i++) {

            ((DefaultTableModel) accountsTable.getModel()).addRow(Accounts.viewAccounts().get(i));
        }
    }

    //Clears the table
    public void unloadData() {

        for (int i = accountsTable.getModel().getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) accountsTable.getModel()).removeRow(i);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        accountsTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sortingPanel = new javax.swing.JPanel();
        sortButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sortOptions = new javax.swing.JComboBox<>();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Accounts");

        ImageIcon frameIcon = new ImageIcon("Imgs\\Accounts.png");

        setIconImage(frameIcon.getImage());
        setFocusable(true);

        accountsTable.setAutoCreateRowSorter(true);
        accountsTable.setFont(new java.awt.Font("Sora Medium", 0, 12)); // NOI18N
        accountsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Serial Number", "Name", "Email", "Balance", "Phone Number", "Creation Date", "Type"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        accountsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(accountsTable);
        if (accountsTable.getColumnModel().getColumnCount() > 0) {
            accountsTable.getColumnModel().getColumn(0).setResizable(false);
            accountsTable.getColumnModel().getColumn(1).setResizable(false);
            accountsTable.getColumnModel().getColumn(2).setResizable(false);
            accountsTable.getColumnModel().getColumn(3).setResizable(false);
            accountsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        backButton.setBackground(new java.awt.Color(0, 0, 112));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });


        searchPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        searchButton.setBackground(new java.awt.Color(0, 102, 0));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchField.setToolTipText("Enter Account Number");

        jLabel2.setFont(new java.awt.Font("Fira Code", 3, 18)); // NOI18N
        jLabel2.setText("Search Panel");

        jLabel5.setText("");

        ImageIcon image = new ImageIcon("Imgs\\Search.png");
        Image resizedImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        jLabel5.setIcon(resizedIcon);

        jLabel5.setHorizontalTextPosition(jLabel5.CENTER);
        jLabel5.setVerticalTextPosition(jLabel5.TOP);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(searchField))
                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 12, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
        );
        searchPanelLayout.setVerticalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)
                                .addContainerGap())
        );

        sortingPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        sortButton.setBackground(new java.awt.Color(243, 143, 0));
        sortButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sortButton.setForeground(new java.awt.Color(255, 255, 255));

        ImageIcon sortImage = new ImageIcon("Imgs\\Sort.png");
        Image resizedSortImage = sortImage.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon resizedSortIcon = new ImageIcon(resizedSortImage);

        sortButton.setIcon(resizedSortIcon); // NOI18N
        sortButton.setText("Sort");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Fira Code", 3, 18)); // NOI18N
        jLabel3.setText("Sorting Panel");

        sortOptions.setMaximumRowCount(3);
        sortOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Name", "Balance", "Creation Date"}));

        javax.swing.GroupLayout sortingPanelLayout = new javax.swing.GroupLayout(sortingPanel);
        sortingPanel.setLayout(sortingPanelLayout);
        sortingPanelLayout.setHorizontalGroup(
                sortingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sortingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(sortingPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(sortingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sortOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        sortingPanelLayout.setVerticalGroup(
                sortingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sortingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(sortOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(sortButton)
                                .addGap(17, 17, 17))
        );

        resetButton.setBackground(new java.awt.Color(255, 51, 51));
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(resetButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sortingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(resetButton))
                                .addGap(18, 18, 18)
                                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(sortingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>


    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = searchField.getText();

        if (Validations.isLetter(keyword)) {

            unloadData();
            var searchResults = Accounts.searchAccounts(keyword);

            if (searchResults.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No accounts found for the search keyword: " + keyword, "Search Results", JOptionPane.WARNING_MESSAGE);
            } else {
                for (String[] data : searchResults) {
                    ((DefaultTableModel) accountsTable.getModel()).addRow(data);
                }

            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a search keyword", "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }


    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String sortOption = sortOptions.getSelectedItem().toString();

        unloadData();

        ArrayList<String[]> sortedAccounts = Accounts.sortAccounts(sortOption);
        for (String[] sortedAccount : sortedAccounts) {
            ((DefaultTableModel) accountsTable.getModel()).addRow(sortedAccount);
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        this.setVisible(false);
        menu.setVisible(true);
    }


    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        unloadData();
        loadData();
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
//            java.util.logging.Logger.getLogger(ViewAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewAccounts().setVisible(true);
//            }
//        });
//    }


    private javax.swing.JTable accountsTable;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton sortButton;
    private javax.swing.JComboBox<String> sortOptions;
    private javax.swing.JPanel sortingPanel;
}
