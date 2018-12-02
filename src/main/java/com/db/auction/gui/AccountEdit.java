package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import javax.swing.border.*;
import javax.xml.crypto.Data;

public class AccountEdit {

    public AccountEdit(String userId){
        initComponents();
        currentUser = userId;
        initData();
        editDialog.setVisible(true);
    }

    private void initData(){
        String[] currentInfo = Database.getUserInfo(currentUser);
        idLabel.setText(currentInfo[0]);
        nameLabel.setText(currentInfo[1]);
        eInputAge.setText(currentInfo[2]);
        genderLabel.setText(currentInfo[3]);
        eInputPhone.setText(currentInfo[4]);
        updateComboBox();
    }

    private void updateComboBox(){
        addrComboBox.removeAllItems();
        cardComboBox.removeAllItems();

        List<String> addresses = Database.getAddresses(currentUser);
        for(String address : addresses){
            addrComboBox.addItem(address);
        }

        List<String> payments = Database.getPayments(currentUser);
        for(String payment : payments){
            cardComboBox.addItem(payment);
        }
    }

    private void editButtonActionPerformed(ActionEvent e) {
        Database.updateUserInfo(currentUser, Integer.parseInt(eInputAge.getText()), eInputPhone.getText(), String.valueOf(eInputPw.getPassword()));
        editDialog.dispose();
    }

    private void addAddrBtnActionPerformed(ActionEvent e) {
        String alias = JOptionPane.showInputDialog("배송지를 관리할 이름을 입력해주세요");
        if(alias != null) {
            String address = JOptionPane.showInputDialog("배송지의 주소를 입력해주세요");
            if(address != null){
                Database.addAddress(currentUser, alias, address);
            }
        }
        updateComboBox();
    }

    private void editAddrBtnActionPerformed(ActionEvent e) {
        String addr[] = addrComboBox.getSelectedItem().toString().split("-", 2);
        String newAddr = JOptionPane.showInputDialog("변경 할 주소를 입력해 주세요.", addr[1]);
        if(newAddr != null && !newAddr.equals("")){
            Database.updateAddress(currentUser, addr[0], newAddr);
        }
    }

    private void addCardBtnActionPerformed(ActionEvent e) {
        Object[] options = {"카드", "통장", "취소"};
        int selection = JOptionPane.showOptionDialog(editDialog,
                                    "결재 수단을 선택해주세요",
                                    "",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[2]);

        if(selection == 0){
            String cardCompany = JOptionPane.showInputDialog("카드 회사를 입력해주세요.");
            if(cardCompany != null){
                String cardNo = JOptionPane.showInputDialog("카드 번호를 입력해주세요.");
                if(cardNo != null){
                    Database.addCard(currentUser, cardCompany, cardNo);
                }
            }
        }else if(selection == 1){
            String bank = JOptionPane.showInputDialog("은행을 입력해주세요.");
            if(bank != null){
                String accountNo = JOptionPane.showInputDialog("계좌 번호를 입력해주세요.");
                if(accountNo != null){
                    Database.addAccount(currentUser, bank, accountNo);
                }
            }
        }

        updateComboBox();
    }

    private void delCardBtnActionPerformed(ActionEvent e) {
        String payments[] = cardComboBox.getSelectedItem().toString().split("-", 2);
        Database.deletePayment(currentUser, payments[0], payments[1]);
        updateComboBox();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kim Dohyeon
        editDialog = new JDialog();
        JPanel editPanel = new JPanel();
        JLabel eIdLabel = new JLabel();
        idLabel = new JLabel();
        JLabel ePwLabel = new JLabel();
        eInputPw = new JPasswordField();
        JLabel eNameLabel = new JLabel();
        nameLabel = new JLabel();
        JLabel cAgeLabel = new JLabel();
        eInputAge = new JTextField();
        JLabel eGenderLabel = new JLabel();
        genderLabel = new JLabel();
        JLabel cPhoneLabel = new JLabel();
        eInputPhone = new JTextField();
        JLabel eAddrLabel = new JLabel();
        addrComboBox = new JComboBox();
        editButton = new JButton();
        editAddrBtn = new JButton();
        JLabel eCardLabel = new JLabel();
        cardComboBox = new JComboBox();
        delCardBtn = new JButton();
        addAddrBtn = new JButton();
        addCardBtn = new JButton();

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
                idLabel.setBounds(95, 30, 105, idLabel.getPreferredSize().height);

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
                nameLabel.setBounds(95, 75, 105, nameLabel.getPreferredSize().height);

                //---- cAgeLabel ----
                cAgeLabel.setText("\ub098\uc774");
                cAgeLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(cAgeLabel);
                cAgeLabel.setBounds(new Rectangle(new Point(245, 75), cAgeLabel.getPreferredSize()));

                //---- eInputAge ----
                eInputAge.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                editPanel.add(eInputAge);
                eInputAge.setBounds(300, 75, 120, 30);

                //---- eGenderLabel ----
                eGenderLabel.setText("\uc131\ubcc4");
                eGenderLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editPanel.add(eGenderLabel);
                eGenderLabel.setBounds(new Rectangle(new Point(40, 120), eGenderLabel.getPreferredSize()));

                //---- genderLabel ----
                genderLabel.setText("gender");
                genderLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
                editPanel.add(genderLabel);
                genderLabel.setBounds(95, 120, 110, genderLabel.getPreferredSize().height);

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

                //---- editButton ----
                editButton.setText("\uc218\uc815");
                editButton.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                editButton.addActionListener(e -> editButtonActionPerformed(e));
                editPanel.add(editButton);
                editButton.setBounds(200, 385, 100, editButton.getPreferredSize().height);

                //---- editAddrBtn ----
                editAddrBtn.setText("\uc218\uc815");
                editAddrBtn.addActionListener(e -> editAddrBtnActionPerformed(e));
                editPanel.add(editAddrBtn);
                editAddrBtn.setBounds(400, 170, 60, 25);

                //---- eCardLabel ----
                eCardLabel.setText("\uacb0\uc81c \uc218\ub2e8");
                eCardLabel.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 18));
                editPanel.add(eCardLabel);
                eCardLabel.setBounds(new Rectangle(new Point(40, 245), eCardLabel.getPreferredSize()));
                editPanel.add(cardComboBox);
                cardComboBox.setBounds(40, 275, 420, 25);

                //---- delCardBtn ----
                delCardBtn.setText("\uc0ad\uc81c");
                delCardBtn.addActionListener(e -> delCardBtnActionPerformed(e));
                editPanel.add(delCardBtn);
                delCardBtn.setBounds(405, 245, 60, 25);

                //---- addAddrBtn ----
                addAddrBtn.setText("\ucd94\uac00");
                addAddrBtn.addActionListener(e -> addAddrBtnActionPerformed(e));
                editPanel.add(addAddrBtn);
                addAddrBtn.setBounds(340, 170, 60, 25);

                //---- addCardBtn ----
                addCardBtn.setText("\ucd94\uac00");
                addCardBtn.addActionListener(e -> addCardBtnActionPerformed(e));
                editPanel.add(addCardBtn);
                addCardBtn.setBounds(345, 245, 60, 25);
            }
            editDialogContentPane.add(editPanel, BorderLayout.CENTER);
            editDialog.setSize(500, 480);
            editDialog.setLocationRelativeTo(editDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private String currentUser;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kim Dohyeon
    private JDialog editDialog;
    private JLabel idLabel;
    private JPasswordField eInputPw;
    private JLabel nameLabel;
    private JTextField eInputAge;
    private JLabel genderLabel;
    private JTextField eInputPhone;
    private JComboBox addrComboBox;
    private JButton editButton;
    private JButton editAddrBtn;
    private JComboBox cardComboBox;
    private JButton delCardBtn;
    private JButton addAddrBtn;
    private JButton addCardBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
