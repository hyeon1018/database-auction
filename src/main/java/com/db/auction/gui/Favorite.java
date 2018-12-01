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

    private void delFavorBtnActionPerformed(ActionEvent e) {
        String target_user_id = (String) favorList.getSelectedValue();
        Database.deleteFavorite(currentUser, target_user_id);
        setList();
    }

    private void favorListMouseClicked(MouseEvent e) {
        String target_user_id = (String) favorList.getSelectedValue();
        if(e.getClickCount() == 2) {
            List <String []> favoriteResult = Database.FavoriteResultList(target_user_id);
            new SearchResult(currentUser, favoriteResult);
            favorFrame.dispose();

        }
    }

    String currentUser;

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - kangjungmo
        favorFrame = new JDialog();
        favorPanel = new JPanel();
        favorScroll = new JScrollPane();
        favorList = new JList();
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
                favorPanel.setPreferredSize(new Dimension(245, 290));

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
                favorScroll.setBounds(25, 20, 190, 175);

                //---- delFavorBtn ----
                delFavorBtn.setText("\uc0ad\uc81c");
                delFavorBtn.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 12));
                delFavorBtn.addActionListener(e -> delFavorBtnActionPerformed(e));
                favorPanel.add(delFavorBtn);
                delFavorBtn.setBounds(155, 215, 60, 25);
            }
            favorFrameContentPane.add(favorPanel, BorderLayout.CENTER);
            favorFrame.setSize(245, 300);
            favorFrame.setLocationRelativeTo(favorFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - kangjungmo
    private JDialog favorFrame;
    private JPanel favorPanel;
    private JScrollPane favorScroll;
    private JList favorList;
    private JButton delFavorBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
