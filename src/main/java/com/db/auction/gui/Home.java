package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class Home {
    public Home(String userId){
        initComponents();
        setTable();
        itemTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemTableMouseClicked(e);
            }
        });

        mainMenu.setVisible(true);
        currentUser = userId;
        accountLabel.setText(currentUser);

    }

    private void setTable(){
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        List<String []> itemList = Database.searchItemList("", "", 0, 0, "", "", null);
        for(String[] item : itemList){
            String [] row = {item[0], item[1], item[2], item[3], item[5], item[6], item[7], item[8]};
            model.addRow(row);
        }
    }

    private void accountLabelMouseClicked(MouseEvent e) {
        new AccountEdit(currentUser);
    }

    private void searchBtnActionPerformed(ActionEvent e) {
        new Search(currentUser);
    }

    private void sellListBtnActionPerformed(ActionEvent e) { new SellerLog(currentUser); }

    private void buyListBtnActionPerformed(ActionEvent e) { new BuyerLog(currentUser); }

    private void regItemBtnActionPerformed(ActionEvent e) {
        new RegisterItemFrame(currentUser);
    }

    private void refreshBtnActionPerformed(ActionEvent e) {
        setTable();
    }

    private void itemTableMouseClicked(MouseEvent e){
        if(e.getClickCount() == 2){
            String selectedItemId = (String)itemTable.getValueAt(itemTable.getSelectedRow(), 1);
            new itemViewFrame(currentUser, selectedItemId);
        }
    }

    private void favorBtnActionPerformed(ActionEvent e) {
        new Favorite(currentUser);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kim Dohyeon
        mainMenu = new JFrame();
        mainPanel = new JPanel();
        listScroll = new JScrollPane();
        itemTable = new JTable();
        titleLabel = new JLabel();
        accountLabel = new JLabel();
        searchBtn = new JButton();
        sellListBtn = new JButton();
        buyListBtn = new JButton();
        regItemBtn = new JButton();
        refreshBtn = new JButton();
        favorBtn = new JButton();

        //======== mainMenu ========
        {
            mainMenu.setTitle("Auction System");
            mainMenu.setResizable(false);
            mainMenu.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            Container mainMenuContentPane = mainMenu.getContentPane();
            mainMenuContentPane.setLayout(new BorderLayout());

            //======== mainPanel ========
            {
                mainPanel.setPreferredSize(new Dimension(700, 620));

                // JFormDesigner evaluation mark
                mainPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), mainPanel.getBorder())); mainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                mainPanel.setLayout(null);

                //======== listScroll ========
                {

                    //---- itemTable ----
                    itemTable.setPreferredScrollableViewportSize(new Dimension(630, 420));
                    itemTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    itemTable.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "\uc720\ud615", "\ubb3c\ud488 ID", "\ubd84\ub958", "\uac00\uaca9", "\ubb3c\ud488 \uc815\ubcf4", "\uc0ac\uc6a9\uc790", "\ub9c8\uac10\uc77c", "\ud3c9\uc810"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = itemTable.getColumnModel();
                        cm.getColumn(0).setMaxWidth(40);
                        cm.getColumn(0).setPreferredWidth(40);
                        cm.getColumn(1).setMaxWidth(80);
                        cm.getColumn(1).setPreferredWidth(80);
                        cm.getColumn(2).setMaxWidth(50);
                        cm.getColumn(2).setPreferredWidth(50);
                        cm.getColumn(3).setMaxWidth(80);
                        cm.getColumn(3).setPreferredWidth(80);
                        cm.getColumn(4).setMaxWidth(500);
                        cm.getColumn(4).setPreferredWidth(300);
                        cm.getColumn(5).setMaxWidth(100);
                        cm.getColumn(5).setPreferredWidth(100);
                        cm.getColumn(6).setMaxWidth(130);
                        cm.getColumn(6).setPreferredWidth(130);
                        cm.getColumn(7).setMaxWidth(60);
                        cm.getColumn(7).setPreferredWidth(60);
                    }
                    itemTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    listScroll.setViewportView(itemTable);
                }
                mainPanel.add(listScroll);
                listScroll.setBounds(35, 140, 630, 420);

                //---- titleLabel ----
                titleLabel.setText("Auction DB System");
                titleLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 24));
                mainPanel.add(titleLabel);
                titleLabel.setBounds(35, 25, 335, titleLabel.getPreferredSize().height);

                //---- accountLabel ----
                accountLabel.setText("ID");
                accountLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                accountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                accountLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        accountLabelMouseClicked(e);
                    }
                });
                mainPanel.add(accountLabel);
                accountLabel.setBounds(495, 30, 114, 25);

                //---- searchBtn ----
                searchBtn.setText("\uac80\uc0c9");
                searchBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 15));
                searchBtn.addActionListener(e -> searchBtnActionPerformed(e));
                mainPanel.add(searchBtn);
                searchBtn.setBounds(35, 80, 100, 40);

                //---- sellListBtn ----
                sellListBtn.setText("\ud310\ub9e4 \uc774\ub825");
                sellListBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 15));
                sellListBtn.addActionListener(e -> sellListBtnActionPerformed(e));
                mainPanel.add(sellListBtn);
                sellListBtn.setBounds(165, 80, 100, 40);

                //---- buyListBtn ----
                buyListBtn.setText("\uad6c\ub9e4 \uc774\ub825");
                buyListBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 15));
                buyListBtn.addActionListener(e -> buyListBtnActionPerformed(e));
                mainPanel.add(buyListBtn);
                buyListBtn.setBounds(300, 80, 100, 40);

                //---- regItemBtn ----
                regItemBtn.setText("\ubb3c\ud488 \ub4f1\ub85d");
                regItemBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 15));
                regItemBtn.addActionListener(e -> regItemBtnActionPerformed(e));
                mainPanel.add(regItemBtn);
                regItemBtn.setBounds(435, 80, 100, 40);

                //---- refreshBtn ----
                refreshBtn.setText("\uc0c8\ub85c\uace0\uce68");
                refreshBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 15));
                refreshBtn.addActionListener(e -> refreshBtnActionPerformed(e));
                mainPanel.add(refreshBtn);
                refreshBtn.setBounds(565, 80, 100, 40);

                //---- favorBtn ----
                favorBtn.setText("\u2606");
                favorBtn.addActionListener(e -> favorBtnActionPerformed(e));
                mainPanel.add(favorBtn);
                favorBtn.setBounds(615, 30, 50, 25);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < mainPanel.getComponentCount(); i++) {
                        Rectangle bounds = mainPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = mainPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    mainPanel.setMinimumSize(preferredSize);
                    mainPanel.setPreferredSize(preferredSize);
                }
            }
            mainMenuContentPane.add(mainPanel, BorderLayout.CENTER);
            mainMenu.setSize(700, 620);
            mainMenu.setLocationRelativeTo(mainMenu.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    String currentUser;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kim Dohyeon
    private JFrame mainMenu;
    private JPanel mainPanel;
    private JScrollPane listScroll;
    private JTable itemTable;
    private JLabel titleLabel;
    private JLabel accountLabel;
    private JButton searchBtn;
    private JButton sellListBtn;
    private JButton buyListBtn;
    private JButton regItemBtn;
    private JButton refreshBtn;
    private JButton favorBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
