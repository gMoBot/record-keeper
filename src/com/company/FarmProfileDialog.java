package com.company;

import com.company.Models.FarmProfile;

import javax.swing.*;
import javax.xml.bind.util.ValidationEventCollector;
import java.awt.event.*;
import java.util.Vector;

public class FarmProfileDialog extends JDialog {

    private JPanel contentPane;
    private JButton submit;
    private JButton buttonCancel;
    private JTextField farmName;
    private JTextField ownerName;
    private JTextField streetAddress;
    private JComboBox state;
    private JTextField zipCode;

    private JList<String> farmProfileJList;

    private FarmProfile farmProfile = new FarmProfile();

    public FarmProfileDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSubmit();
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

    private void onSubmit() {
        // Create new Farm Profile Object
        farmProfile.setFarmName(String.valueOf(farmName.getText()));
        farmProfile.setOwnerName(String.valueOf(ownerName.getText()));
        farmProfile.setStreetAddress(String.valueOf(streetAddress.getText()));
        farmProfile.setStateCode(String.valueOf(state.getSelectedItem()));
        farmProfile.setZipcode(String.valueOf(zipCode.getText()));

        setVisible(false);
    }

    private void onCancel() {
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        FarmProfileDialog dialog = new FarmProfileDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public FarmProfile getFarmProfile(){
        return farmProfile;
    }

    public void setFarmProfileList(DefaultListModel<String> profileDefaultListModel){
        farmProfileJList = new JList<String>(profileDefaultListModel);
//        farmProfileJList.setFixedCellHeight(40);
//        farmProfileJList.setSelectedIndex(-1);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.add(farmProfileJList);
    }
}
