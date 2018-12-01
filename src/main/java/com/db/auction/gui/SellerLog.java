/*
 * Created by JFormDesigner on Sat Dec 01 01:31:00 KST 2018
 */

package com.db.auction.gui;

import com.db.auction.Database;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author kangjungmo
 */
public class SellerLog extends JFrame {
    public SellerLog(String currentUser) {
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
        List <String []> LogList = Database.getLogListbySeller(currentUser);    // getLogListBySeller 로 수정할 것.
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
        getTable();
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
        setTitle("SellerDataLog");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setPreferredSize(new Dimension(600, 330));

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
                        "\ud310\ub9e4 \ub0a0\uc9dc", "\uac70\ub798\ub0b4\uc5ed ID", "\uad6c\ub9e4\uc790 ID", "\uad6c\ub9e4\uc790 \uc774\ub984", "\uad6c\ub9e4\uc790 \uc5f0\ub77d\ucc98", "\ubb3c\ud488 ID", "\uac00\uaca9", "\ubc30\uc1a1\uc9c0", "\uc0c1\ud0dc"
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
            buttonBar.setBounds(10, 250, 580, buttonBar.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialogPane.getComponentCount(); i++) {
                    Rectangle bounds = dialogPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialogPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialogPane.setMinimumSize(preferredSize);
                dialogPane.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(600, 330);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private String currentUser;
    private int deal_id, row_index;
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
