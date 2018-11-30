/*
 * Created by JFormDesigner on Sat Dec 01 00:46:52 KST 2018
 */

package com.db.auction.gui;

import java.awt.*;
import javax.swing.*;

/**
 * @author Kim Dohyeon
 */
public class itemViewFrame extends JFrame {
    public itemViewFrame() {
        initComponents();

        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kim Dohyeon
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        itemInfoPane = new JTextPane();
        sellerLabel = new JLabel();
        dealTypeLabel = new JLabel();
        priceLabel = new JLabel();
        shippingFeeLabel = new JLabel();
        label9 = new JLabel();
        prevImagaButton = new JButton();
        nextImageButton = new JButton();
        submitButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\ud310\ub9e4\uc790");
        contentPane.add(label1);
        label1.setBounds(30, 30, 70, 30);

        //---- label2 ----
        label2.setText("\uac00\uaca9");
        contentPane.add(label2);
        label2.setBounds(30, 90, 70, 30);

        //---- label3 ----
        label3.setText("\ubc30\uc1a1\ube44");
        contentPane.add(label3);
        label3.setBounds(30, 120, 70, 30);

        //---- label4 ----
        label4.setText("\uac70\ub798\ubc29\uc2dd");
        contentPane.add(label4);
        label4.setBounds(30, 60, 70, 30);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(itemInfoPane);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 155, 335, 150);

        //---- sellerLabel ----
        sellerLabel.setText("text");
        contentPane.add(sellerLabel);
        sellerLabel.setBounds(100, 30, 245, 30);

        //---- dealTypeLabel ----
        dealTypeLabel.setText("text");
        contentPane.add(dealTypeLabel);
        dealTypeLabel.setBounds(100, 60, 245, 30);

        //---- priceLabel ----
        priceLabel.setText("text");
        contentPane.add(priceLabel);
        priceLabel.setBounds(100, 90, 245, 30);

        //---- shippingFeeLabel ----
        shippingFeeLabel.setText("text");
        contentPane.add(shippingFeeLabel);
        shippingFeeLabel.setBounds(100, 120, 245, 30);

        //---- label9 ----
        label9.setText("text");
        contentPane.add(label9);
        label9.setBounds(30, 305, 335, 150);

        //---- prevImagaButton ----
        prevImagaButton.setText("<");
        contentPane.add(prevImagaButton);
        prevImagaButton.setBounds(30, 465, 45, 30);

        //---- nextImageButton ----
        nextImageButton.setText(">");
        contentPane.add(nextImageButton);
        nextImageButton.setBounds(75, 465, 45, 30);

        //---- submitButton ----
        submitButton.setText("action");
        contentPane.add(submitButton);
        submitButton.setBounds(270, 465, 97, 30);

        contentPane.setPreferredSize(new Dimension(400, 550));
        setSize(400, 550);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kim Dohyeon
    private JScrollPane scrollPane1;
    private JTextPane itemInfoPane;
    private JLabel sellerLabel;
    private JLabel dealTypeLabel;
    private JLabel priceLabel;
    private JLabel shippingFeeLabel;
    private JLabel label9;
    private JButton prevImagaButton;
    private JButton nextImageButton;
    private JButton submitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
