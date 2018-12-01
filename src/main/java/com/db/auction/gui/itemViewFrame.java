/*
 * Created by JFormDesigner on Sat Dec 01 00:46:52 KST 2018
 */

package com.db.auction.gui;

import java.awt.event.*;
import com.db.auction.Database;
import com.db.auction.ImageFTP;

import java.awt.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kim Dohyeon
 */
public class itemViewFrame extends JFrame {
    public itemViewFrame(String userId, String itemId) {
        initComponents();
        currentItem = itemId;
        currentUser = userId;

        this.updateData();
        this.setVisible(true);
    }

    private void updateData() {
        String [] iteminfo = Database.getItemInfo(currentItem);
        sellerLabel.setText(iteminfo[6]);
        dealTypeLabel.setText(iteminfo[0]);
        priceLabel.setText(iteminfo[3]);
        shippingFeeLabel.setText(iteminfo[4]);
        itemInfoPane.setText(iteminfo[5]);

        List<String> imageDirs = Database.getImageDirs(currentItem);
        imageList = new ArrayList<>();
        for(String imageDir : imageDirs){
            try {
                imageList.add(ImageFTP.downloadImage(imageDir));
            }catch (IOException ioe){

            }
        }
        imageIndex = 0;
        updateImage();
    }

    private void updateImage(){
        if(imageList.size() > 0) {
            imageLabel.setIcon(imageList.get(imageIndex));
        }
        if(imageIndex <= 0){
            prevImageButton.setEnabled(false);
        }else{
            prevImageButton.setEnabled(true);
        }
        if(imageIndex >= imageList.size() -1){
            nextImageButton.setEnabled(false);
        }else{
            nextImageButton.setEnabled(true);
        }
    }

    private void prevImageButtonActionPerformed(ActionEvent e) {
        imageIndex--;
        updateImage();
    }

    private void nextImageButtonActionPerformed(ActionEvent e) {
        imageIndex++;
        updateImage();
    }

    private void submitButtonActionPerformed(ActionEvent e) {
        if(dealTypeLabel.getText().equals("Bid")){
            String bidPrice = JOptionPane.showInputDialog("입찰 금액을 작성해 주세요");
            Database.bidItem(currentUser, currentItem, Integer.parseInt(bidPrice));
            this.dispose();
        }else if(dealTypeLabel.getText().equals("Sell")){
            new Payment(currentUser, currentItem);
            this.dispose();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
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
        imageLabel = new JLabel();
        prevImageButton = new JButton();
        nextImageButton = new JButton();
        submitButton = new JButton();

        //======== this ========
        setResizable(false);
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

        //---- imageLabel ----
        imageLabel.setText("text");
        contentPane.add(imageLabel);
        imageLabel.setBounds(30, 305, 335, 150);

        //---- prevImageButton ----
        prevImageButton.setText("<");
        prevImageButton.addActionListener(e -> prevImageButtonActionPerformed(e));
        contentPane.add(prevImageButton);
        prevImageButton.setBounds(30, 465, 45, 30);

        //---- nextImageButton ----
        nextImageButton.setText(">");
        nextImageButton.addActionListener(e -> nextImageButtonActionPerformed(e));
        contentPane.add(nextImageButton);
        nextImageButton.setBounds(75, 465, 45, 30);

        //---- submitButton ----
        submitButton.setText("action");
        submitButton.addActionListener(e -> submitButtonActionPerformed(e));
        contentPane.add(submitButton);
        submitButton.setBounds(270, 465, 97, 30);

        contentPane.setPreferredSize(new Dimension(400, 550));
        setSize(400, 550);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private String currentUser;
    private String currentItem;
    private int imageIndex;
    private List<ImageIcon> imageList;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JScrollPane scrollPane1;
    private JTextPane itemInfoPane;
    private JLabel sellerLabel;
    private JLabel dealTypeLabel;
    private JLabel priceLabel;
    private JLabel shippingFeeLabel;
    private JLabel imageLabel;
    private JButton prevImageButton;
    private JButton nextImageButton;
    private JButton submitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
