package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.xml.crypto.Data;

public class Payment {

    public Payment(String userId, String itemId){
        initComponents();
        currentUser = userId;
        currentItem = itemId;
        initData();
        payFrame.setVisible(true);
    }

    private void initData(){
        DefaultTableModel model = (DefaultTableModel) itemSelected.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        String [] info = Database.getItemInfo(currentItem);
        String [] infoRow = {info[0], info[1], info[2], info[5], info[6], info[7]};
        model.addRow(infoRow);
        totalPrice.setText("\\ " + (Integer.parseInt(info[3]) + Integer.parseInt(info[4])));

        List<String> addresses = Database.getAddresses(currentUser);
        for(String address : addresses){
            addrComboBox.addItem(address);
        }

        List<String> payments = Database.getPayments(currentUser);
        for(String payment : payments){
            cardComboBox.addItem(payment);
        }
    }

    private void proceedBtnActionPerformed(ActionEvent e) {
        Database.dealItem(currentUser, addrComboBox.getSelectedItem().toString().split("-")[0], currentItem);
        payFrame.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
        payFrame = new JDialog();
        payPanel = new JPanel();
        itemLabel = new JLabel();
        payScroll = new JScrollPane();
        itemSelected = new JTable();
        priceLabel = new JLabel();
        totalPrice = new JLabel();
        addrLabel = new JLabel();
        addrComboBox = new JComboBox();
        proceedBtn = new JButton();
        methodLabel = new JLabel();
        cardComboBox = new JComboBox();

        //======== payFrame ========
        {
            payFrame.setTitle("Payment");
            payFrame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            payFrame.setResizable(false);
            Container payFrameContentPane = payFrame.getContentPane();
            payFrameContentPane.setLayout(new BorderLayout());

            //======== payPanel ========
            {

                // JFormDesigner evaluation mark
                payPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), payPanel.getBorder())); payPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                payPanel.setLayout(null);

                //---- itemLabel ----
                itemLabel.setText("\uad6c\ub9e4 \ubb3c\ud488");
                itemLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                payPanel.add(itemLabel);
                itemLabel.setBounds(new Rectangle(new Point(25, 25), itemLabel.getPreferredSize()));

                //======== payScroll ========
                {

                    //---- itemSelected ----
                    itemSelected.setPreferredScrollableViewportSize(new Dimension(630, 420));
                    itemSelected.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    itemSelected.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\uc720\ud615", "\ubb3c\ud488 ID", "\ubd84\ub958", "\ubb3c\ud488 \uc815\ubcf4", "\uc0ac\uc6a9\uc790", "\ub9c8\uac10\uc77c"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, true, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = itemSelected.getColumnModel();
                        cm.getColumn(0).setMaxWidth(40);
                        cm.getColumn(0).setPreferredWidth(40);
                        cm.getColumn(1).setMaxWidth(60);
                        cm.getColumn(1).setPreferredWidth(60);
                        cm.getColumn(2).setMaxWidth(40);
                        cm.getColumn(2).setPreferredWidth(40);
                        cm.getColumn(3).setMaxWidth(1000);
                        cm.getColumn(3).setPreferredWidth(100);
                        cm.getColumn(4).setMaxWidth(80);
                        cm.getColumn(4).setPreferredWidth(80);
                        cm.getColumn(5).setMaxWidth(70);
                        cm.getColumn(5).setPreferredWidth(70);
                    }
                    itemSelected.setRowSelectionAllowed(false);
                    payScroll.setViewportView(itemSelected);
                }
                payPanel.add(payScroll);
                payScroll.setBounds(25, 55, 495, 45);

                //---- priceLabel ----
                priceLabel.setText("\uac00\uaca9:");
                priceLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                payPanel.add(priceLabel);
                priceLabel.setBounds(new Rectangle(new Point(385, 110), priceLabel.getPreferredSize()));

                //---- totalPrice ----
                totalPrice.setText("\\0");
                totalPrice.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
                payPanel.add(totalPrice);
                totalPrice.setBounds(415, 110, 105, totalPrice.getPreferredSize().height);

                //---- addrLabel ----
                addrLabel.setText("\uc8fc\uc18c");
                addrLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                payPanel.add(addrLabel);
                addrLabel.setBounds(new Rectangle(new Point(25, 125), addrLabel.getPreferredSize()));
                payPanel.add(addrComboBox);
                addrComboBox.setBounds(25, 155, 495, 25);

                //---- proceedBtn ----
                proceedBtn.setText("\uad6c\ub9e4 \uc9c4\ud589");
                proceedBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 12));
                proceedBtn.addActionListener(e -> proceedBtnActionPerformed(e));
                payPanel.add(proceedBtn);
                proceedBtn.setBounds(420, 260, 100, 30);

                //---- methodLabel ----
                methodLabel.setText("\uacb0\uc81c \uc218\ub2e8");
                methodLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                payPanel.add(methodLabel);
                methodLabel.setBounds(new Rectangle(new Point(25, 195), methodLabel.getPreferredSize()));
                payPanel.add(cardComboBox);
                cardComboBox.setBounds(25, 220, 495, 25);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < payPanel.getComponentCount(); i++) {
                        Rectangle bounds = payPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = payPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    payPanel.setMinimumSize(preferredSize);
                    payPanel.setPreferredSize(preferredSize);
                }
            }
            payFrameContentPane.add(payPanel, BorderLayout.CENTER);
            payFrame.setSize(550, 345);
            payFrame.setLocationRelativeTo(payFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    String currentUser;
    String currentItem;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JDialog payFrame;
    private JPanel payPanel;
    private JLabel itemLabel;
    private JScrollPane payScroll;
    private JTable itemSelected;
    private JLabel priceLabel;
    private JLabel totalPrice;
    private JLabel addrLabel;
    private JComboBox addrComboBox;
    private JButton proceedBtn;
    private JLabel methodLabel;
    private JComboBox cardComboBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
