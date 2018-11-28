/*
 * Created by JFormDesigner on Wed Nov 28 22:51:54 KST 2018
 */

package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Kim Dohyeon
 */
public class registerItemFrame extends JFrame {
    public registerItemFrame(String currentUser) {
        this.currentUser = currentUser;
        initComponents();
        initData();
        this.setVisible(true);
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO Query.
    }

    private void initData(){
        //set Combobox data with query result.
        String cate [] = Database.getCategorys();
        for(int i = 0; i < cate.length; i++){
            categoryComboBox.addItem(cate[i]);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kim Dohyeon
        categoryComboBox = new JComboBox();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        priceField = new JTextField();
        JLabel label5 = new JLabel();
        shippingPriceField = new JTextField();
        JLabel label6 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        JLabel label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        button1 = new JButton();
        button2 = new JButton();
        JLabel label8 = new JLabel();
        scrollPane2 = new JScrollPane();
        editorPane1 = new JEditorPane();
        button3 = new JButton();

        //======== this ========
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
        contentPane.add(radioButton1);
        radioButton1.setBounds(80, 100, 75, 30);

        //---- radioButton2 ----
        radioButton2.setText("\uacbd\ub9e4");
        contentPane.add(radioButton2);
        radioButton2.setBounds(155, 100, 70, 30);

        //---- label7 ----
        label7.setText("\uc774\ubbf8\uc9c0");
        contentPane.add(label7);
        label7.setBounds(30, 130, 50, 30);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 160, 330, 70);

        //---- button1 ----
        button1.setText("\ub4f1\ub85d");
        contentPane.add(button1);
        button1.setBounds(240, 135, 60, 25);

        //---- button2 ----
        button2.setText("\uc0ad\uc81c");
        contentPane.add(button2);
        button2.setBounds(300, 135, 60, 25);

        //---- label8 ----
        label8.setText("\uc81c\ud488 \uc124\uba85");
        contentPane.add(label8);
        label8.setBounds(30, 235, 65, 30);

        //======== scrollPane2 ========
        {

            //---- editorPane1 ----
            editorPane1.setText("[\uc81c\ud488\uc124\uba85]");
            scrollPane2.setViewportView(editorPane1);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(30, 265, 325, 140);

        //---- button3 ----
        button3.setText("\uc81c\ud488 \ub4f1\ub85d");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(265, 415, 90, 30);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    private String currentUser;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kim Dohyeon
    private JComboBox categoryComboBox;
    private JTextField priceField;
    private JTextField shippingPriceField;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane2;
    private JEditorPane editorPane1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
