package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

public class Search {

    public Search(String userId){
        currentUser = userId;
        initComponents();
        initData();
        searchFrame.setVisible(true);
    }

    private void initData(){
        //set ComboBox data with query result.
        String cate [] = Database.getCategorys();
        for(int i = 0; i < cate.length; i++){
            categoryComboBox.addItem(cate[i]);
        }
    }

    private void searchBtnActionPerformed(ActionEvent e) {
        //Check Input.
        String deal_tyep = typeComboBox.getSelectedItem().toString();
        String category = categoryComboBox.getSelectedItem().toString();
        int minPrice = inputMin.getText().length() > 0 ? Integer.parseInt(inputMin.getText()) : 0;
        int maxPrice = inputMax.getText().length() > 0 ? Integer.parseInt(inputMax.getText()) : 0;
        String keyword = inputInfo.getText();
        String user = inputUser.getText();
        Date expireDate = inputDate.getText().length() > 0 ? Date.valueOf(inputDate.getText()) : null;

        List<String []> result = Database.searchItemList(deal_tyep, category, minPrice, maxPrice, keyword, user, expireDate);
        new SearchResult(currentUser, result);
        searchFrame.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kim Dohyeon
        searchFrame = new JFrame();
        searchPanel = new JPanel();
        typeLabel = new JLabel();
        typeComboBox = new JComboBox<>();
        categoryLabel = new JLabel();
        priceLabel = new JLabel();
        inputMin = new JTextField();
        rangeLabel = new JLabel();
        inputMax = new JTextField();
        infoLabel = new JLabel();
        inputInfo = new JTextField();
        userLabel = new JLabel();
        inputUser = new JTextField();
        expirationLabel = new JLabel();
        inputDate = new JTextField();
        searchBtn = new JButton();
        dateExLabel = new JLabel();
        categoryComboBox = new JComboBox();

        //======== searchFrame ========
        {
            searchFrame.setTitle("Search");
            searchFrame.setResizable(false);
            searchFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            Container searchFrameContentPane = searchFrame.getContentPane();
            searchFrameContentPane.setLayout(new BorderLayout());

            //======== searchPanel ========
            {
                searchPanel.setPreferredSize(new Dimension(510, 270));

                // JFormDesigner evaluation mark
                searchPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), searchPanel.getBorder())); searchPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                searchPanel.setLayout(null);

                //---- typeLabel ----
                typeLabel.setText("\ud310\ub9e4 \uc720\ud615");
                typeLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                searchPanel.add(typeLabel);
                typeLabel.setBounds(new Rectangle(new Point(30, 20), typeLabel.getPreferredSize()));

                //---- typeComboBox ----
                typeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Sell",
                    "Bid"
                }));
                searchPanel.add(typeComboBox);
                typeComboBox.setBounds(120, 20, 50, 25);

                //---- categoryLabel ----
                categoryLabel.setText("\ubd84\ub958");
                categoryLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 16));
                searchPanel.add(categoryLabel);
                categoryLabel.setBounds(new Rectangle(new Point(260, 20), categoryLabel.getPreferredSize()));

                //---- priceLabel ----
                priceLabel.setText("\uac00\uaca9");
                priceLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                searchPanel.add(priceLabel);
                priceLabel.setBounds(new Rectangle(new Point(30, 60), priceLabel.getPreferredSize()));
                searchPanel.add(inputMin);
                inputMin.setBounds(85, 60, 100, 25);

                //---- rangeLabel ----
                rangeLabel.setText("~");
                rangeLabel.setFont(new Font("\uad74\ub9bc", Font.BOLD, 16));
                searchPanel.add(rangeLabel);
                rangeLabel.setBounds(new Rectangle(new Point(205, 65), rangeLabel.getPreferredSize()));
                searchPanel.add(inputMax);
                inputMax.setBounds(240, 60, 100, 25);

                //---- infoLabel ----
                infoLabel.setText("\ubb3c\ud488 \uc815\ubcf4");
                infoLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                searchPanel.add(infoLabel);
                infoLabel.setBounds(new Rectangle(new Point(30, 105), infoLabel.getPreferredSize()));
                searchPanel.add(inputInfo);
                inputInfo.setBounds(120, 105, 355, 25);

                //---- userLabel ----
                userLabel.setText("\uc0ac\uc6a9\uc790");
                userLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                searchPanel.add(userLabel);
                userLabel.setBounds(new Rectangle(new Point(30, 145), userLabel.getPreferredSize()));
                searchPanel.add(inputUser);
                inputUser.setBounds(100, 145, 90, 25);

                //---- expirationLabel ----
                expirationLabel.setText("\ub9c8\uac10\uc77c");
                expirationLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                searchPanel.add(expirationLabel);
                expirationLabel.setBounds(new Rectangle(new Point(220, 145), expirationLabel.getPreferredSize()));
                searchPanel.add(inputDate);
                inputDate.setBounds(290, 145, 90, 25);

                //---- searchBtn ----
                searchBtn.setText("\uac80\uc0c9");
                searchBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 16));
                searchBtn.addActionListener(e -> searchBtnActionPerformed(e));
                searchPanel.add(searchBtn);
                searchBtn.setBounds(205, 185, 100, searchBtn.getPreferredSize().height);

                //---- dateExLabel ----
                dateExLabel.setText("YYYY-MM-DD");
                dateExLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 14));
                searchPanel.add(dateExLabel);
                dateExLabel.setBounds(new Rectangle(new Point(385, 145), dateExLabel.getPreferredSize()));
                searchPanel.add(categoryComboBox);
                categoryComboBox.setBounds(310, 20, 80, 25);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < searchPanel.getComponentCount(); i++) {
                        Rectangle bounds = searchPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = searchPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    searchPanel.setMinimumSize(preferredSize);
                    searchPanel.setPreferredSize(preferredSize);
                }
            }
            searchFrameContentPane.add(searchPanel, BorderLayout.CENTER);
            searchFrame.setSize(510, 270);
            searchFrame.setLocationRelativeTo(searchFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    String currentUser;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kim Dohyeon
    private JFrame searchFrame;
    private JPanel searchPanel;
    private JLabel typeLabel;
    private JComboBox<String> typeComboBox;
    private JLabel categoryLabel;
    private JLabel priceLabel;
    private JTextField inputMin;
    private JLabel rangeLabel;
    private JTextField inputMax;
    private JLabel infoLabel;
    private JTextField inputInfo;
    private JLabel userLabel;
    private JTextField inputUser;
    private JLabel expirationLabel;
    private JTextField inputDate;
    private JButton searchBtn;
    private JLabel dateExLabel;
    private JComboBox categoryComboBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
