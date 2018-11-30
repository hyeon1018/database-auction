/*
 * Created by JFormDesigner on Fri Nov 30 01:56:19 KST 2018
 */

package com.db.auction.gui;

import java.awt.event.*;
import com.db.auction.Database;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author kangjungmo
 */
public class BuyerLog extends JFrame {
    public BuyerLog(String currentUser) {
        this.currentUser = currentUser;
        initComponents();
        this.setVisible(true);
    }

    private void getLogButtonActionPerformed(ActionEvent e) {
        getTable();;
    }

    private void getTable(){
        DefaultTableModel logModel = (DefaultTableModel) LogTable.getModel();
        while (logModel.getRowCount() > 0) {
           logModel.removeRow(0);
        }
        List <String []> LogList = Database.getLogListbyBuyer(currentUser);
        for(String[] log : LogList){
            logModel.addRow(log);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - kangjungmo
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        LogTable = new JTable();
        buttonBar = new JPanel();
        getLogButton = new JButton();
        deleteLogButton = new JButton();

        //======== this ========
        setTitle("DataLog");
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

                //======== scrollPane1 ========
                {

                    //---- LogTable ----
                    LogTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\ub0a0\uc9dc", "\uc0ac\uc6a9\uc790 ID", "\uc774\ub984", "\uc5f0\ub77d\ucc98", "\ud310\ub9e4\uae00 \ubc88\ud638", "\uac00\uaca9", "\ubc30\uc1a1\uc9c0", "\uc0c1\ud0dc"
                        }
                    ));
                    scrollPane1.setViewportView(LogTable);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- getLogButton ----
                getLogButton.setText("\ubcf4\uae30");
                getLogButton.addActionListener(e -> getLogButtonActionPerformed(e));
                buttonBar.add(getLogButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- deleteLogButton ----
                deleteLogButton.setText("\uc0ad\uc81c");
                buttonBar.add(deleteLogButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private String currentUser;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - kangjungmo
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable LogTable;
    private JPanel buttonBar;
    private JButton getLogButton;
    private JButton deleteLogButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
