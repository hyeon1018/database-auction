/*
 * Created by JFormDesigner on Wed Nov 28 22:51:54 KST 2018
 */

package com.db.auction.gui;

import com.db.auction.Database;
import com.db.auction.ImageFTP;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Kim Dohyeon
 */
public class RegisterItemFrame extends JFrame {
    public RegisterItemFrame(String currentUser) {
        this.currentUser = currentUser;
        initComponents();
        initData();
        this.setVisible(true);
    }

    private void initData(){
        //set Combobox data with query result.
        String cate [] = Database.getCategorys();
        for(int i = 0; i < cate.length; i++){
            categoryComboBox.addItem(cate[i]);

        }
        imageList.setModel(imageListModel);
    }

    private void submitButtonListener(MouseEvent e) {
        Database.insertItem(currentUser, categoryComboBox.getSelectedItem().toString(), Integer.parseInt(priceField.getText()),
                dealTypeGroup.getSelection().getActionCommand(), Integer.parseInt(shippingPriceField.getText()), itemInfoText.getText());
        int lastId = Database.getLastInsertId();

        for(int i = 0 ; i < imageListModel.getSize(); i++){
            try {
                File image = new File(imageListModel.get(i));
                ImageFTP.UploadImage(image.getAbsolutePath(), image.getName());
                Database.insertImage(String.valueOf(lastId), String.valueOf(lastId) + "_" + image.getName());
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        //Close this Frame
        this.dispose();
    }

    private void registerImageButtonListener(MouseEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        int rtn = jFileChooser.showOpenDialog(this);
        if(rtn == JFileChooser.APPROVE_OPTION){
            imageListModel.addElement(jFileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void deleteImageButtonListener(MouseEvent e) {
        if(imageList.getSelectedIndex() != -1) {
            imageListModel.remove(imageList.getSelectedIndex());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
        categoryComboBox = new JComboBox();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        priceField = new JTextField();
        JLabel label5 = new JLabel();
        shippingPriceField = new JTextField();
        JLabel label6 = new JLabel();
        JRadioButton radioButton1 = new JRadioButton();
        JRadioButton radioButton2 = new JRadioButton();
        JLabel label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        imageList = new JList<>();
        registerImageButton = new JButton();
        deleteImageGroup = new JButton();
        JLabel label8 = new JLabel();
        scrollPane2 = new JScrollPane();
        itemInfoText = new JEditorPane();
        submitButton = new JButton();
        dealTypeGroup = new ButtonGroup();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(categoryComboBox);
        categoryComboBox.setBounds(80, 30, 100, 30);

        //---- label3 ----
        label3.setText("\ubd84\ub958");
        contentPane.add(label3);
        label3.setBounds(30, 30, 50, 30);

        //---- label4 ----
        label4.setText("\uac00\uaca9");
        contentPane.add(label4);
        label4.setBounds(30, 70, 50, 25);
        contentPane.add(priceField);
        priceField.setBounds(80, 70, 120, 25);

        //---- label5 ----
        label5.setText("\ubc30\uc1a1\ube44");
        contentPane.add(label5);
        label5.setBounds(220, 70, 50, 25);
        contentPane.add(shippingPriceField);
        shippingPriceField.setBounds(270, 70, 90, 25);

        //---- label6 ----
        label6.setText("\uc720\ud615");
        contentPane.add(label6);
        label6.setBounds(30, 100, 50, 30);

        //---- radioButton1 ----
        radioButton1.setText("\ud310\ub9e4");
        radioButton1.setActionCommand("Sell");
        contentPane.add(radioButton1);
        radioButton1.setBounds(80, 100, 75, 30);

        //---- radioButton2 ----
        radioButton2.setText("\uacbd\ub9e4");
        radioButton2.setActionCommand("Bid");
        contentPane.add(radioButton2);
        radioButton2.setBounds(155, 100, 70, 30);

        //---- label7 ----
        label7.setText("\uc774\ubbf8\uc9c0");
        contentPane.add(label7);
        label7.setBounds(30, 130, 50, 30);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(imageList);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 160, 330, 70);

        //---- registerImageButton ----
        registerImageButton.setText("\ub4f1\ub85d");
        registerImageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerImageButtonListener(e);
            }
        });
        contentPane.add(registerImageButton);
        registerImageButton.setBounds(240, 135, 60, 25);

        //---- deleteImageGroup ----
        deleteImageGroup.setText("\uc0ad\uc81c");
        deleteImageGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteImageButtonListener(e);
            }
        });
        contentPane.add(deleteImageGroup);
        deleteImageGroup.setBounds(300, 135, 60, 25);

        //---- label8 ----
        label8.setText("\uc81c\ud488 \uc124\uba85");
        contentPane.add(label8);
        label8.setBounds(30, 235, 65, 30);

        //======== scrollPane2 ========
        {

            //---- itemInfoText ----
            itemInfoText.setText("[\uc81c\ud488\uc124\uba85]");
            scrollPane2.setViewportView(itemInfoText);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(30, 265, 325, 140);

        //---- submitButton ----
        submitButton.setText("\uc81c\ud488 \ub4f1\ub85d");
        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submitButtonListener(e);
            }
        });
        contentPane.add(submitButton);
        submitButton.setBounds(265, 415, 90, 30);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(400, 500);
        setLocationRelativeTo(getOwner());

        //---- dealTypeGroup ----
        dealTypeGroup.add(radioButton1);
        dealTypeGroup.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private String currentUser;
    private DefaultListModel<String> imageListModel = new DefaultListModel<>();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JComboBox categoryComboBox;
    private JTextField priceField;
    private JTextField shippingPriceField;
    private JScrollPane scrollPane1;
    private JList<String> imageList;
    private JButton registerImageButton;
    private JButton deleteImageGroup;
    private JScrollPane scrollPane2;
    private JEditorPane itemInfoText;
    private JButton submitButton;
    private ButtonGroup dealTypeGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
