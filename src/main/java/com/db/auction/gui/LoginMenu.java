package com.db.auction.gui;

import com.db.auction.Database;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Nov 27 11:04:30 KST 2018
 */

/**
 * @author Yu Hwan Jung
 */
public class LoginMenu {
    public LoginMenu() {
        initComponents();
        try{
            Database.initConnection();
        }catch (SQLException se){
            // TODO - Exception Hadling
        }
        mainFrame.setVisible(true);
        // inputId.setTransferHandler(null) <- 복붙 방지
    }

    private void mainFrameWindowClosing(WindowEvent e) {
        mainFrame.setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }

    private void registerLabelMouseClicked(MouseEvent e) {
        new AccountInfo();
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        if(Database.isValidUser(inputId.getText(), String.valueOf(inputPw.getPassword()))){
            new Home(inputId.getText());
        }else{
            JOptionPane.showMessageDialog(mainFrame, "Wrong User", "Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inputIdKeyTyped(KeyEvent e) {
        if(inputId.getText().length() >= 12){
            e.consume();
        }
    }

    private void inputPwKeyTyped(KeyEvent e) {
        if(inputPw.getPassword().length >= 25){
            e.consume();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        idLabel = new JLabel();
        pwLabel = new JLabel();
        inputId = new JTextField();
        inputPw = new JPasswordField();
        loginButton = new JButton();
        registerLabel = new JLabel();

        //======== mainFrame ========
        {
            mainFrame.setTitle("Login");
            mainFrame.setResizable(false);
            mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            mainFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    mainFrameWindowClosing(e);
                }
            });
            Container mainFrameContentPane = mainFrame.getContentPane();
            mainFrameContentPane.setLayout(new BorderLayout());

            //======== mainPanel ========
            {
                mainPanel.setPreferredSize(new Dimension(400, 150));
                mainPanel.setMinimumSize(new Dimension(350, 120));

                // JFormDesigner evaluation mark
                mainPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), mainPanel.getBorder())); mainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                mainPanel.setLayout(null);

                //---- idLabel ----
                idLabel.setText("ID");
                idLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                mainPanel.add(idLabel);
                idLabel.setBounds(60, 30, 35, 25);

                //---- pwLabel ----
                pwLabel.setText("PW");
                pwLabel.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                mainPanel.add(pwLabel);
                pwLabel.setBounds(60, 70, 35, 25);

                //---- inputId ----
                inputId.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        inputIdKeyTyped(e);
                    }
                });
                mainPanel.add(inputId);
                inputId.setBounds(110, 30, 120, 30);

                //---- inputPw ----
                inputPw.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 18));
                inputPw.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        inputPwKeyTyped(e);
                    }
                });
                mainPanel.add(inputPw);
                inputPw.setBounds(110, 70, 120, 30);

                //---- loginButton ----
                loginButton.setText("\ub85c\uadf8\uc778");
                loginButton.setFont(new Font("\ub098\ub214\uace0\ub515", Font.BOLD, 20));
                loginButton.addActionListener(e -> loginButtonActionPerformed(e));
                mainPanel.add(loginButton);
                loginButton.setBounds(250, 30, 95, 50);

                //---- registerLabel ----
                registerLabel.setText("register");
                registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                registerLabel.setForeground(Color.blue);
                registerLabel.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 14));
                registerLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        registerLabelMouseClicked(e);
                    }
                });
                mainPanel.add(registerLabel);
                registerLabel.setBounds(250, 85, 95, registerLabel.getPreferredSize().height);
            }
            mainFrameContentPane.add(mainPanel, BorderLayout.CENTER);
            mainFrame.setSize(400, 160);
            mainFrame.setLocationRelativeTo(mainFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JTextField inputId;
    private JPasswordField inputPw;
    private JButton loginButton;
    private JLabel registerLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
