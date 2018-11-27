import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Tue Nov 27 11:04:30 KST 2018
 */

/**
 * @author Yu Hwan Jung
 */
public class LoginMenu {
    public LoginMenu() {
        initComponents();
        mainFrame.setVisible(true);
        // inputId.setTransferHandler(null) <- 복붙 방지
    }

    private void mainFrameWindowClosing(WindowEvent e) {
        // TODO 로그인 창 X를 눌러서 프로그램 끝나기 전에 수행할 코드 입력
        mainFrame.setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }

    private void registerLabelMouseClicked(MouseEvent e) {
        loginButton.setEnabled(false);
        regDialog.setVisible(true);
        // TODO 사용자 등록 버튼 대용 / 클릭 시 수행
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        // TODO 로그인 버튼 입력
        // TODO JTextField는 .getText(), JPasswordField는 String.Valueof(inputPw.getPassword())
        msgLabel.setText("login pressed");
        msgDialog.setVisible(true);
    }

    private void inputIdKeyTyped(KeyEvent e) {
        if(inputId.getText().length() >= 12){
            e.consume();
        }
    } // TODO 12자 이상 입력 못하도록 함

    private void inputPwKeyTyped(KeyEvent e) {
        if(inputPw.getPassword().length >= 25){
            e.consume();
        }
    } // TODO 25자 이상 입력 못하도록 함

    private void createButtonActionPerformed(ActionEvent e) {
        msgLabel.setText("create pressed");
        msgDialog.setVisible(true);
        // TODO 계정 생성 시 수행해야 하는 것
    } //button 값은 genderBtnGroup.getSelection().getActionCommand() // Male, Female 출력

    private void regDialogWindowClosing(WindowEvent e) {
        loginButton.setEnabled(true);
        regDialog.setVisible(false);
        e.getWindow().dispose();
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
        msgDialog = new JDialog();
        msgPanel = new JPanel();
        msgLabel = new JLabel();

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
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(mainFrame.getOwner());
        }

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

        //======== msgDialog ========
        {
            msgDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            msgDialog.setTitle("Message");
            msgDialog.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
            Container msgDialogContentPane = msgDialog.getContentPane();
            msgDialogContentPane.setLayout(new BorderLayout());

            //======== msgPanel ========
            {
                msgPanel.setPreferredSize(new Dimension(300, 150));

                // JFormDesigner evaluation mark
                msgPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), msgPanel.getBorder())); msgPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                msgPanel.setLayout(null);

                //---- msgLabel ----
                msgLabel.setText("message");
                msgLabel.setFont(new Font("\uad74\ub9bc", Font.PLAIN, 16));
                msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                msgPanel.add(msgLabel);
                msgLabel.setBounds(0, 20, 300, 70);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < msgPanel.getComponentCount(); i++) {
                        Rectangle bounds = msgPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = msgPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    msgPanel.setMinimumSize(preferredSize);
                    msgPanel.setPreferredSize(preferredSize);
                }
            }
            msgDialogContentPane.add(msgPanel, BorderLayout.CENTER);
            msgDialog.pack();
            msgDialog.setLocationRelativeTo(msgDialog.getOwner());
        }

        //---- genderBtnGroup ----
        ButtonGroup genderBtnGroup = new ButtonGroup();
        genderBtnGroup.add(cSelectMale);
        genderBtnGroup.add(cSelectFemale);
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
    private JDialog msgDialog;
    private JPanel msgPanel;
    private JLabel msgLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
