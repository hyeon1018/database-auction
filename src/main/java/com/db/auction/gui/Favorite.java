package com.db.auction.gui;

import com.db.auction.Database;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.DefaultListModel;

public class Favorite {

    public Favorite(String userId) {
        currentUser = userId;
        initComponents();
        setList();
        favorFrame.setVisible(true);
    }

    private void setList(){
        List<String> favorites = Database.getFavorite(currentUser);
        DefaultListModel model = new DefaultListModel();

        while(model.getSize() > 0){
            model.removeElementAt(0);
        }

        for(String favor : favorites){
            model.addElement(favor);
        }
        favorList.setModel(model);
    }

    private void addFavorBtnActionPerformed(ActionEvent e) {
        // TODO 즐찾 유저 추가
    }

    private void delFavorBtnActionPerformed(ActionEvent e) {
        //favorList.getSelectedValue().toString();
        // TODO 즐찾 유저 삭제
    }

    private void favorListMouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            //TODO 검색 기능으로
        }
    }

    String currentUser;

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
        favorFrame = new JDialog();
        favorPanel = new JPanel();
        favorScroll = new JScrollPane();
        favorList = new JList();
        addFavorBtn = new JButton();
        delFavorBtn = new JButton();

        //======== favorFrame ========
        {
            favorFrame.setTitle("Favorite");
            favorFrame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            favorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            favorFrame.setResizable(false);
            Container favorFrameContentPane = favorFrame.getContentPane();
            favorFrameContentPane.setLayout(new BorderLayout());

            //======== favorPanel ========
            {
                favorPanel.setPreferredSize(new Dimension(225, 275));

                // JFormDesigner evaluation mark
                favorPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), favorPanel.getBorder())); favorPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                favorPanel.setLayout(null);

                //======== favorScroll ========
                {

                    //---- favorList ----
                    favorList.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.BOLD, 14));
                    favorList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            favorListMouseClicked(e);
                        }
                    });
                    favorScroll.setViewportView(favorList);
                }
                favorPanel.add(favorScroll);
                favorScroll.setBounds(15, 15, 195, 175);

                //---- addFavorBtn ----
                addFavorBtn.setText("\ucd94\uac00");
                addFavorBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 12));
                addFavorBtn.addActionListener(e -> addFavorBtnActionPerformed(e));
                favorPanel.add(addFavorBtn);
                addFavorBtn.setBounds(50, 200, 60, 25);

                //---- delFavorBtn ----
                delFavorBtn.setText("\uc0ad\uc81c");
                delFavorBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 12));
                delFavorBtn.addActionListener(e -> delFavorBtnActionPerformed(e));
                favorPanel.add(delFavorBtn);
                delFavorBtn.setBounds(115, 200, 60, 25);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < favorPanel.getComponentCount(); i++) {
                        Rectangle bounds = favorPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = favorPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    favorPanel.setMinimumSize(preferredSize);
                    favorPanel.setPreferredSize(preferredSize);
                }
            }
            favorFrameContentPane.add(favorPanel, BorderLayout.CENTER);
            favorFrame.setSize(225, 275);
            favorFrame.setLocationRelativeTo(favorFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yu Hwan Jung
    private JDialog favorFrame;
    private JPanel favorPanel;
    private JScrollPane favorScroll;
    private JList favorList;
    private JButton addFavorBtn;
    private JButton delFavorBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
