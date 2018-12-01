/*
 * Created by JFormDesigner on Sun Dec 02 02:50:34 KST 2018
 */

package com.db.auction.gui;

import java.awt.event.*;
import com.db.auction.Database;

import java.awt.*;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.ButtonGroup;

/**
 * @author kangjungmo
 */
public class GradePoint extends JFrame {
    public GradePoint(int deal_id) {

        dealID = deal_id;
        initComponents();
        this.setVisible(true);

    }

  private void getButtonPoint (){

        if(radioButton1.isSelected())
            resultPoint = 1;
        else if(radioButton2.isSelected())
            resultPoint = 2;
        else if(radioButton3.isSelected())
            resultPoint = 3;
        else if(radioButton4.isSelected())
            resultPoint = 4;
        else
            resultPoint = 5;
    }

    private void commitButtonActionPerformed(ActionEvent e) {
        getButtonPoint();
        Database.UpdatePoint(dealID, resultPoint);
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - kangjungmo
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        radioButton5 = new JRadioButton();
        buttonBar = new JPanel();
        commitButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Grade");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\uad6c\ub9e4\ud558\uc2e0 \uc0c1\ud488\uc5d0 \ub300\ud55c \ud3c9\uc810\uc744 \uacb0\uc815\ud574\uc8fc\uc138\uc694.");

                //---- radioButton1 ----
                radioButton1.setText("1");

                //---- radioButton2 ----
                radioButton2.setText("2");

                //---- radioButton3 ----
                radioButton3.setText("3");

                //---- radioButton4 ----
                radioButton4.setText("4");

                //---- radioButton5 ----
                radioButton5.setText("5");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(radioButton1)
                            .addGap(45, 45, 45)
                            .addComponent(radioButton2)
                            .addGap(45, 45, 45)
                            .addComponent(radioButton3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addComponent(radioButton4)
                            .addGap(42, 42, 42)
                            .addComponent(radioButton5)
                            .addGap(30, 30, 30))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(65, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioButton1)
                                .addComponent(radioButton2)
                                .addComponent(radioButton3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioButton4)
                                .addComponent(radioButton5))
                            .addGap(15, 15, 15))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- commitButton ----
                commitButton.setText("\ucc38\uc5ec");
                commitButton.addActionListener(e -> commitButtonActionPerformed(e));
                buttonBar.add(commitButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\uac70\uc808");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);
        buttonGroup1.add(radioButton5);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    int resultPoint;
    int dealID;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - kangjungmo
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JPanel buttonBar;
    private JButton commitButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
