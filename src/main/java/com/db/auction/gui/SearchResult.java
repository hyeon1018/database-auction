package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import javax.swing.table.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchResult {

    public SearchResult(String userId, List<String []> result){
        initComponents();
        currentUser = userId;
        resultTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemTableMouseClicked(e);
            }
        });
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for(String[] item : result){
            model.addRow(item);
        }

        resultFrame.setVisible(true);
    }


    private void itemTableMouseClicked(MouseEvent e){
        if(e.getClickCount() == 2){
            String selectedItemId = (String)resultTable.getValueAt(resultTable.getSelectedRow(), 1);
            new itemViewFrame(currentUser, selectedItemId);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kim Dohyeon
        resultFrame = new JDialog();
        resultPanel = new JPanel();
        resultScroll = new JScrollPane();
        resultTable = new JTable();

        //======== resultFrame ========
        {
            resultFrame.setTitle("Search Result");
            resultFrame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            resultFrame.setResizable(false);
            Container resultFrameContentPane = resultFrame.getContentPane();
            resultFrameContentPane.setLayout(new BorderLayout());

            //======== resultPanel ========
            {
                resultPanel.setPreferredSize(new Dimension(675, 495));

                // JFormDesigner evaluation mark
                resultPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), resultPanel.getBorder())); resultPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                resultPanel.setLayout(null);

                //======== resultScroll ========
                {

                    //---- resultTable ----
                    resultTable.setPreferredScrollableViewportSize(new Dimension(630, 420));
                    resultTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    resultTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\uc720\ud615", "\ubb3c\ud488 ID", "\ubd84\ub958", "\uac00\uaca9", "\ubb3c\ud488 \uc815\ubcf4", "\uc0ac\uc6a9\uc790", "\ub9c8\uac10\uc77c"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = resultTable.getColumnModel();
                        cm.getColumn(0).setMaxWidth(40);
                        cm.getColumn(0).setPreferredWidth(40);
                        cm.getColumn(1).setMaxWidth(60);
                        cm.getColumn(1).setPreferredWidth(60);
                        cm.getColumn(2).setMaxWidth(30);
                        cm.getColumn(2).setPreferredWidth(30);
                        cm.getColumn(3).setMaxWidth(70);
                        cm.getColumn(3).setPreferredWidth(70);
                        cm.getColumn(4).setMaxWidth(1000);
                        cm.getColumn(4).setPreferredWidth(100);
                        cm.getColumn(5).setMaxWidth(80);
                        cm.getColumn(5).setPreferredWidth(80);
                        cm.getColumn(6).setMaxWidth(70);
                        cm.getColumn(6).setPreferredWidth(70);
                    }
                    resultScroll.setViewportView(resultTable);
                }
                resultPanel.add(resultScroll);
                resultScroll.setBounds(20, 20, 630, 420);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < resultPanel.getComponentCount(); i++) {
                        Rectangle bounds = resultPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = resultPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    resultPanel.setMinimumSize(preferredSize);
                    resultPanel.setPreferredSize(preferredSize);
                }
            }
            resultFrameContentPane.add(resultPanel, BorderLayout.CENTER);
            resultFrame.setSize(675, 495);
            resultFrame.setLocationRelativeTo(resultFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private String currentUser;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kim Dohyeon
    private JDialog resultFrame;
    private JPanel resultPanel;
    private JScrollPane resultScroll;
    private JTable resultTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
