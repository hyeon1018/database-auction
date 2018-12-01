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
        getTable();
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

    private void deleteLogButtonActionPerformed(ActionEvent e) {
        DefaultTableModel logModel = (DefaultTableModel) LogTable.getModel();
        row_index = LogTable.getSelectedRow();
        if(row_index > -1) {
            deal_id = Integer.parseInt((logModel.getValueAt(row_index, 1)).toString());
            Database.DeleteLogList((deal_id));
            logModel.removeRow(row_index);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
        dialogPane = new JPanel();
        scrollPane1 = new JScrollPane();
        LogTable = new JTable();
        buttonBar = new JPanel();
        getLogButton = new JButton();
        deleteLogButton = new JButton();

        //======== this ========
        setTitle("Buyer Data Log");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setPreferredSize(new Dimension(370, 298));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- LogTable ----
                LogTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\uad6c\ub9e4 \ub0a0\uc9dc", "\uad6c\ub9e4\uae00 \ubc88\ud638", "\ud310\ub9e4\uc790 ID", "\ud310\ub9e4\uc790 \uc774\ub984", "\ud310\ub9e4\uc790 \uc5f0\ub77d\ucc98", "\ud310\ub9e4\uae00 \ubc88\ud638", "\uac00\uaca9", "\ubc30\uc1a1\uc9c0", "\uc0c1\ud0dc"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false, false, false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = LogTable.getColumnModel();
                    cm.getColumn(0).setMaxWidth(130);
                    cm.getColumn(0).setPreferredWidth(130);
                    cm.getColumn(1).setPreferredWidth(100);
                    cm.getColumn(2).setMaxWidth(150);
                    cm.getColumn(2).setPreferredWidth(100);
                    cm.getColumn(3).setMaxWidth(150);
                    cm.getColumn(3).setPreferredWidth(100);
                    cm.getColumn(4).setMaxWidth(110);
                    cm.getColumn(4).setPreferredWidth(110);
                    cm.getColumn(5).setPreferredWidth(100);
                    cm.getColumn(6).setMaxWidth(100);
                    cm.getColumn(6).setPreferredWidth(80);
                    cm.getColumn(7).setMaxWidth(500);
                    cm.getColumn(7).setPreferredWidth(350);
                    cm.getColumn(8).setMaxWidth(80);
                    cm.getColumn(8).setPreferredWidth(80);
                }
                LogTable.setEnabled(false);
                LogTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                scrollPane1.setViewportView(LogTable);
            }
            dialogPane.add(scrollPane1);
            scrollPane1.setBounds(10, 10, 580, 240);

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
                deleteLogButton.addActionListener(e -> deleteLogButtonActionPerformed(e));
                buttonBar.add(deleteLogButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar);
            buttonBar.setBounds(12, 251, 344, buttonBar.getPreferredSize().height);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private String currentUser;
    private int row_index, deal_id;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JPanel dialogPane;
    private JScrollPane scrollPane1;
    private JTable LogTable;
    private JPanel buttonBar;
    private JButton getLogButton;
    private JButton deleteLogButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
