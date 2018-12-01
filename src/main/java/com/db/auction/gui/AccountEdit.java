package com.db.auction.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AccountEdit {

    public AccountEdit(){
        initComponents();
        idLabel.setText("기존 계정");
        eInputPw.setText("기존 비밀번호");
        nameLabel.setText("기존 이름");
        eInputAge.setText("기존 나이");
        genderLabel.setText("기존 성별");
        eInputPhone.setText("기존 전화번호");
        addrComboBox.addItem("등록된 주소들");
        eInputAddr.setText("등록된 주소들 선택한 내용 가져오거나 신규 입력");
    }

    private void editButtonActionPerformed(ActionEvent e) {
        // TODO 수정 진행
    }

    private void addAddrBtnActionPerformed(ActionEvent e) {
        // TODO 주소 추가 버튼
    }

    private void delAddrBtnActionPerformed(ActionEvent e) {
        // TODO 주소 제거 버튼
    }

    private void addCardBtnActionPerformed(ActionEvent e) {
        // TODO 결제 수단 추가 버튼
    }

    private void delCardBtnActionPerformed(ActionEvent e) {
        // TODO 결제 수단 제거 버튼
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
        editDialog = new JDialog();
        editPanel = new JPanel();
        eIdLabel = new JLabel();
        idLabel = new JLabel();
        ePwLabel = new JLabel();
        eInputPw = new JPasswordField();
        eNameLabel = new JLabel();
        nameLabel = new JLabel();
        cAgeLabel = new JLabel();
        eInputAge = new JTextField();
        eGenderLabel = new JLabel();
        genderLabel = new JLabel();
        cPhoneLabel = new JLabel();
        eInputPhone = new JTextField();
        eAddrLabel = new JLabel();
        addrComboBox = new JComboBox();
        eInputAddr = new JTextField();
        editButton = new JButton();
        addAddrBtn = new JButton();
        delAddrBtn = new JButton();
        eCardLabel = new JLabel();
        cardComboBox = new JComboBox();
        eInputCard = new JTextField();
        addCardBtn = new JButton();
        delCardBtn = new JButton();

        //======== editDialog ========
        {
            editDialog.setTitle("Edit Account Info");
            editDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            editDialog.setResizable(false);
            editDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            Container editDialogContentPane = editDialog.getContentPane();
            editDialogContentPane.setLayout(new BorderLayout());

            //======== editPanel ========
            {
                editPanel.setPreferredSize(new Dimension(500, 480));
                editPanel.setRequestFocusEnabled(false);

                // JFormDesigner evaluation mark
                editPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), editPanel.getBorder())); editPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                editPanel.setLayout(null);

                //---- eIdLabel ----
                eIdLabel.setText("ID");
                eIdLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(eIdLabel);
                eIdLabel.setBounds(new Rectangle(new Point(40, 30), eIdLabel.getPreferredSize()));

                //---- idLabel ----
                idLabel.setText("id");
                idLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
                editPanel.add(idLabel);
                idLabel.setBounds(new Rectangle(new Point(95, 30), idLabel.getPreferredSize()));

                //---- ePwLabel ----
                ePwLabel.setText("PW");
                ePwLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(ePwLabel);
                ePwLabel.setBounds(new Rectangle(new Point(245, 30), ePwLabel.getPreferredSize()));

                //---- eInputPw ----
                eInputPw.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                editPanel.add(eInputPw);
                eInputPw.setBounds(300, 30, 120, 30);

                //---- eNameLabel ----
                eNameLabel.setText("\uc774\ub984");
                eNameLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(eNameLabel);
                eNameLabel.setBounds(new Rectangle(new Point(40, 75), eNameLabel.getPreferredSize()));

                //---- nameLabel ----
                nameLabel.setText("name");
                nameLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
                editPanel.add(nameLabel);
                nameLabel.setBounds(new Rectangle(new Point(95, 75), nameLabel.getPreferredSize()));

                //---- cAgeLabel ----
                cAgeLabel.setText("\ub098\uc774");
                cAgeLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(cAgeLabel);
                cAgeLabel.setBounds(new Rectangle(new Point(245, 75), cAgeLabel.getPreferredSize()));

                //---- eInputAge ----
                eInputAge.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                editPanel.add(eInputAge);
                eInputAge.setBounds(300, 75, 50, 30);

                //---- eGenderLabel ----
                eGenderLabel.setText("\uc131\ubcc4");
                eGenderLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(eGenderLabel);
                eGenderLabel.setBounds(new Rectangle(new Point(40, 120), eGenderLabel.getPreferredSize()));

                //---- genderLabel ----
                genderLabel.setText("gender");
                genderLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
                editPanel.add(genderLabel);
                genderLabel.setBounds(new Rectangle(new Point(95, 120), genderLabel.getPreferredSize()));

                //---- cPhoneLabel ----
                cPhoneLabel.setText("\uc804\ud654\ubc88\ud638");
                cPhoneLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(cPhoneLabel);
                cPhoneLabel.setBounds(new Rectangle(new Point(210, 120), cPhoneLabel.getPreferredSize()));

                //---- eInputPhone ----
                eInputPhone.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                editPanel.add(eInputPhone);
                eInputPhone.setBounds(300, 120, 160, 30);

                //---- eAddrLabel ----
                eAddrLabel.setText("\uc8fc\uc18c");
                eAddrLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(eAddrLabel);
                eAddrLabel.setBounds(new Rectangle(new Point(40, 165), eAddrLabel.getPreferredSize()));
                editPanel.add(addrComboBox);
                addrComboBox.setBounds(40, 200, 420, 25);
                editPanel.add(eInputAddr);
                eInputAddr.setBounds(40, 230, 420, 25);

                //---- editButton ----
                editButton.setText("\uc218\uc815");
                editButton.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editButton.addActionListener(e -> editButtonActionPerformed(e));
                editPanel.add(editButton);
                editButton.setBounds(200, 385, 100, editButton.getPreferredSize().height);

                //---- addAddrBtn ----
                addAddrBtn.setText("\ucd94\uac00");
                addAddrBtn.addActionListener(e -> addAddrBtnActionPerformed(e));
                editPanel.add(addAddrBtn);
                addAddrBtn.setBounds(new Rectangle(new Point(345, 170), addAddrBtn.getPreferredSize()));

                //---- delAddrBtn ----
                delAddrBtn.setText("\uc0ad\uc81c");
                delAddrBtn.addActionListener(e -> delAddrBtnActionPerformed(e));
                editPanel.add(delAddrBtn);
                delAddrBtn.setBounds(new Rectangle(new Point(405, 170), delAddrBtn.getPreferredSize()));

                //---- eCardLabel ----
                eCardLabel.setText("\uacb0\uc81c \uc218\ub2e8");
                eCardLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 18));
                editPanel.add(eCardLabel);
                eCardLabel.setBounds(new Rectangle(new Point(40, 275), eCardLabel.getPreferredSize()));
                editPanel.add(cardComboBox);
                cardComboBox.setBounds(40, 310, 420, 25);
                editPanel.add(eInputCard);
                eInputCard.setBounds(40, 340, 420, 25);

                //---- addCardBtn ----
                addCardBtn.setText("\ucd94\uac00");
                addCardBtn.addActionListener(e -> addCardBtnActionPerformed(e));
                editPanel.add(addCardBtn);
                addCardBtn.setBounds(345, 285, 57, 23);

                //---- delCardBtn ----
                delCardBtn.setText("\uc0ad\uc81c");
                delCardBtn.addActionListener(e -> delCardBtnActionPerformed(e));
                editPanel.add(delCardBtn);
                delCardBtn.setBounds(405, 285, 57, 23);
            }
            editDialogContentPane.add(editPanel, BorderLayout.CENTER);
            editDialog.setSize(500, 480);
            editDialog.setLocationRelativeTo(editDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JDialog editDialog;
    private JPanel editPanel;
    private JLabel eIdLabel;
    private JLabel idLabel;
    private JLabel ePwLabel;
    private JPasswordField eInputPw;
    private JLabel eNameLabel;
    private JLabel nameLabel;
    private JLabel cAgeLabel;
    private JTextField eInputAge;
    private JLabel eGenderLabel;
    private JLabel genderLabel;
    private JLabel cPhoneLabel;
    private JTextField eInputPhone;
    private JLabel eAddrLabel;
    private JComboBox addrComboBox;
    private JTextField eInputAddr;
    private JButton editButton;
    private JButton addAddrBtn;
    private JButton delAddrBtn;
    private JLabel eCardLabel;
    private JComboBox cardComboBox;
    private JTextField eInputCard;
    private JButton addCardBtn;
    private JButton delCardBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
