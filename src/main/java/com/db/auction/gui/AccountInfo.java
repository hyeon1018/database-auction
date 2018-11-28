package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AccountInfo {

    public AccountInfo(){
        initComponents();
        regDialog.setVisible(true);
    }

    private void createButtonActionPerformed(ActionEvent e) {
        String userId = cInputId.getText();
        String userPw = String.valueOf(cInputPw.getPassword());
        String name = cInputName.getText();
        int age = Integer.parseInt(cInputAge.getText());
        String gender = genderBtnGroup.getSelection().getActionCommand();
        String phoneNumber = cInputPhone.getText();
        String address = cInputAddr.getText();

        if(userId.length() > 0 && userPw.length() > 0 && name.length() > 0 && phoneNumber.length() > 0 && address.length() > 0) {
            Database.regiesterUser(userId, userPw, name, age, gender, phoneNumber);
            Database.addAddress(userId, "기본배송지", address);

            JOptionPane.showMessageDialog(regDialog, "User created", "Complete", JOptionPane.INFORMATION_MESSAGE);

            regDialog.dispose();
        }else{
            JOptionPane.showMessageDialog(regDialog, "Please check input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void regDialogWindowClosing(WindowEvent e) {
        regDialog.dispose();
        e.getWindow().dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
        regDialog = new JDialog();
        regPanel = new JPanel();
        cIdLabel = new JLabel();
        cInputId = new JTextField();
        cPwLabel = new JLabel();
        cInputPw = new JPasswordField();
        cNameLabel = new JLabel();
        cInputName = new JTextField();
        cAgeLabel = new JLabel();
        cInputAge = new JTextField();
        cGenderLabel = new JLabel();
        cSelectMale = new JRadioButton();
        cSelectFemale = new JRadioButton();
        cPhoneLabel = new JLabel();
        cInputPhone = new JTextField();
        cAddrLabel = new JLabel();
        createButton = new JButton();
        AddrScroll = new JScrollPane();
        cInputAddr = new JTextArea();
        genderBtnGroup = new ButtonGroup();

        //======== regDialog ========
        {
            regDialog.setTitle("Register");
            regDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            regDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    regDialogWindowClosing(e);
                }
            });
            Container regDialogContentPane = regDialog.getContentPane();
            regDialogContentPane.setLayout(new BorderLayout());

            //======== regPanel ========
            {
                regPanel.setPreferredSize(new Dimension(500, 320));

                // JFormDesigner evaluation mark
                regPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), regPanel.getBorder())); regPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                regPanel.setLayout(null);

                //---- cIdLabel ----
                cIdLabel.setText("ID");
                cIdLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                regPanel.add(cIdLabel);
                cIdLabel.setBounds(new Rectangle(new Point(40, 30), cIdLabel.getPreferredSize()));

                //---- cInputId ----
                cInputId.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                regPanel.add(cInputId);
                cInputId.setBounds(95, 30, 120, 30);

                //---- cPwLabel ----
                cPwLabel.setText("PW");
                cPwLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                regPanel.add(cPwLabel);
                cPwLabel.setBounds(new Rectangle(new Point(245, 30), cPwLabel.getPreferredSize()));

                //---- cInputPw ----
                cInputPw.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                regPanel.add(cInputPw);
                cInputPw.setBounds(300, 30, 120, 30);

                //---- cNameLabel ----
                cNameLabel.setText("\uc774\ub984");
                cNameLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                regPanel.add(cNameLabel);
                cNameLabel.setBounds(new Rectangle(new Point(40, 75), cNameLabel.getPreferredSize()));

                //---- cInputName ----
                cInputName.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                regPanel.add(cInputName);
                cInputName.setBounds(95, 75, 120, 30);

                //---- cAgeLabel ----
                cAgeLabel.setText("\ub098\uc774");
                cAgeLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                regPanel.add(cAgeLabel);
                cAgeLabel.setBounds(new Rectangle(new Point(245, 75), cAgeLabel.getPreferredSize()));

                //---- cInputAge ----
                cInputAge.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                regPanel.add(cInputAge);
                cInputAge.setBounds(300, 75, 50, 30);

                //---- cGenderLabel ----
                cGenderLabel.setText("\uc131\ubcc4");
                cGenderLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                regPanel.add(cGenderLabel);
                cGenderLabel.setBounds(new Rectangle(new Point(40, 120), cGenderLabel.getPreferredSize()));

                //---- cSelectMale ----
                cSelectMale.setText("\ub0a8\uc131");
                cSelectMale.setActionCommand("Male");
                cSelectMale.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 14));
                regPanel.add(cSelectMale);
                cSelectMale.setBounds(new Rectangle(new Point(90, 120), cSelectMale.getPreferredSize()));

                //---- cSelectFemale ----
                cSelectFemale.setText("\uc5ec\uc131");
                cSelectFemale.setActionCommand("Female");
                cSelectFemale.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 14));
                regPanel.add(cSelectFemale);
                cSelectFemale.setBounds(new Rectangle(new Point(145, 120), cSelectFemale.getPreferredSize()));

                //---- cPhoneLabel ----
                cPhoneLabel.setText("\uc804\ud654\ubc88\ud638");
                cPhoneLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                regPanel.add(cPhoneLabel);
                cPhoneLabel.setBounds(new Rectangle(new Point(210, 120), cPhoneLabel.getPreferredSize()));

                //---- cInputPhone ----
                cInputPhone.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                regPanel.add(cInputPhone);
                cInputPhone.setBounds(300, 120, 160, 30);

                //---- cAddrLabel ----
                cAddrLabel.setText("\uc8fc\uc18c");
                cAddrLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                regPanel.add(cAddrLabel);
                cAddrLabel.setBounds(new Rectangle(new Point(40, 165), cAddrLabel.getPreferredSize()));

                //---- createButton ----
                createButton.setText("\ub4f1\ub85d");
                createButton.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                createButton.addActionListener(e -> createButtonActionPerformed(e));
                regPanel.add(createButton);
                createButton.setBounds(new Rectangle(new Point(220, 235), createButton.getPreferredSize()));

                //======== AddrScroll ========
                {

                    //---- cInputAddr ----
                    cInputAddr.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                    AddrScroll.setViewportView(cInputAddr);
                }
                regPanel.add(AddrScroll);
                AddrScroll.setBounds(95, 170, 365, 50);
            }
            regDialogContentPane.add(regPanel, BorderLayout.CENTER);
            regDialog.pack();
            regDialog.setLocationRelativeTo(regDialog.getOwner());
        }

        //---- genderBtnGroup ----
        genderBtnGroup.add(cSelectMale);
        genderBtnGroup.add(cSelectFemale);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JDialog regDialog;
    private JPanel regPanel;
    private JLabel cIdLabel;
    private JTextField cInputId;
    private JLabel cPwLabel;
    private JPasswordField cInputPw;
    private JLabel cNameLabel;
    private JTextField cInputName;
    private JLabel cAgeLabel;
    private JTextField cInputAge;
    private JLabel cGenderLabel;
    private JRadioButton cSelectMale;
    private JRadioButton cSelectFemale;
    private JLabel cPhoneLabel;
    private JTextField cInputPhone;
    private JLabel cAddrLabel;
    private JButton createButton;
    private JScrollPane AddrScroll;
    private JTextArea cInputAddr;
    private ButtonGroup genderBtnGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
