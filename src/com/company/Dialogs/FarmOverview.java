package com.company.Dialogs;

import javax.swing.*;
import java.awt.event.*;

public class FarmOverview extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton newApplication;
    private JButton showBlocks;
    private JButton showAllApplications;
    private JButton showApplicators;
    private JButton generateRpt;
    private JComboBox reportType;
    private JButton showProducts;

    private JList<String> farmApplicationList;

    public FarmOverview() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        newApplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FarmOverview dialog = new FarmOverview();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void setFarmApplicationList(DefaultListModel<String> profileDefaultListModel){
        farmApplicationList = new JList<String>(profileDefaultListModel);
//        farmProfileJList.setFixedCellHeight(40);
//        farmProfileJList.setSelectedIndex(-1);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.add(farmApplicationList);
    }
}
