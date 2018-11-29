package com.db.auction.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import javax.swing.table.TableColumn;

public class Home {
    public Home(){
        initComponents();
        setTable();
        accountLabel.setText(/*사용자 id + "( "+ 사용자 name + " )"*/"");
    }

    private void setTable(){
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
        //deal_type item_id category price item_info user_id expire_time
        //TODO 테이블 row 추가

        itemTable.getSelectionModel().addListSelectionListener((new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(itemTable.getSelectedRow() > -1 ){
                    //TODO row에 대한 상품 정보 창으로 연결
                }
            }
        }));
    }

    private void accountLabelMouseClicked(MouseEvent e) {
        // TODO 정보 수정 창으로 연결
    }

    private void searchBtnActionPerformed(ActionEvent e) {
        // TODO 검색 창으로 연결
    }

    private void sellListBtnActionPerformed(ActionEvent e) {
        // TODO 판매 목록 창으로 연결
    }

    private void buyListBtnActionPerformed(ActionEvent e) {
        // TODO 구매 목록 창으로 연결
    }

    private void regItemBtnActionPerformed(ActionEvent e) {
        // TODO 물품 등록 창으로 연결
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
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

        //======== mainMenu ========
        {
            mainMenu.setTitle("Auction System");
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
                        },
                        new String[] {
                            "\uc720\ud615", "\ubb3c\ud488 ID", "\ubd84\ub958", "\uac00\uaca9", "\ubb3c\ud488 \uc815\ubcf4", "\uc0ac\uc6a9\uc790", "\ub9c8\uac10\uc77c"
                        }
                    ));
                    listScroll.setViewportView(itemTable);
                }
                mainPanel.add(listScroll);
                listScroll.setBounds(35, 140, 630, 420);

                //---- titleLabel ----
                titleLabel.setText("Auction DB System");
                titleLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 24));
                mainPanel.add(titleLabel);
                titleLabel.setBounds(new Rectangle(new Point(35, 25), titleLabel.getPreferredSize()));

                //---- accountLabel ----
                accountLabel.setText("ID (Name)");
                accountLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                accountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                accountLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        accountLabelMouseClicked(e);
                    }
                });
                mainPanel.add(accountLabel);
                accountLabel.setBounds(505, 30, 159, 25);

                //---- searchBtn ----
                searchBtn.setText("\uac80\uc0c9");
                searchBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                searchBtn.addActionListener(e -> searchBtnActionPerformed(e));
                mainPanel.add(searchBtn);
                searchBtn.setBounds(65, 80, 120, 40);

                //---- sellListBtn ----
                sellListBtn.setText("\ud310\ub9e4 \ubaa9\ub85d");
                sellListBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                sellListBtn.addActionListener(e -> sellListBtnActionPerformed(e));
                mainPanel.add(sellListBtn);
                sellListBtn.setBounds(215, 80, 120, 40);

                //---- buyListBtn ----
                buyListBtn.setText("\uad6c\ub9e4 \uc774\ub825");
                buyListBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                buyListBtn.addActionListener(e -> buyListBtnActionPerformed(e));
                mainPanel.add(buyListBtn);
                buyListBtn.setBounds(365, 80, 120, 40);

                //---- regItemBtn ----
                regItemBtn.setText("\ubb3c\ud488 \ub4f1\ub85d");
                regItemBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                regItemBtn.addActionListener(e -> regItemBtnActionPerformed(e));
                mainPanel.add(regItemBtn);
                regItemBtn.setBounds(515, 80, 120, 40);

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
            mainMenu.pack();
            mainMenu.setLocationRelativeTo(mainMenu.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
