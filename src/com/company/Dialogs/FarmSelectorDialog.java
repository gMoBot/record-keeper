package com.company.Dialogs;

import com.company.FarmRecordsApp;

import javax.swing.*;
import java.awt.event.*;

public class FarmSelectorDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton newFarmProfile;

    private JList<String> farmProfileJList;

    private String farmName;


    public FarmSelectorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        //TODO: Move over to FarmRecordsApp?
        newFarmProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNewFarmProfile();
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
        farmName = String.valueOf(farmProfileJList.getSelectedValue());
        setVisible(false);
//        dispose();
    }

    private void onNewFarmProfile(){
        //TODO: call enterFarmProfile from within FarmRecordsApp
        // Add listener in new function in FarmRecordsApp?

//        FarmRecordsApp farmRecordsApp = new FarmRecordsApp();
//        farmRecordsApp.enterFarmProfile();
        //TODO: add farm list update function
        farmName = "CreateNew";
        setVisible(false);
    }
    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FarmSelectorDialog dialog = new FarmSelectorDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public void setFarmProfileList(DefaultListModel<String> profileDefaultListModel){
        farmProfileJList = new JList<String>(profileDefaultListModel);
//        farmProfileJList.setFixedCellHeight(40);
//        farmProfileJList.setSelectedIndex(-1);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.add(farmProfileJList);
    }
    public String getFarmName() {
        return farmName;
    }
}
