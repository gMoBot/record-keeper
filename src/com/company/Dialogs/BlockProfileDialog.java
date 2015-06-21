package com.company.Dialogs;

import javax.swing.*;
import java.awt.event.*;

public class BlockProfileDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonSubmit;
    private JButton buttonCancel;
    private JTextField blockName;
    private JCheckBox useFarmAddressCheckBox;
    private JTextField blockStreetAddress;
    private JTextField blockZipCode;
    private JComboBox blockState;
    private JCheckBox useFarmStateCheckBox;
    private JTextField blockSize;
    private JTextField blockCrop;
    private JSpinner blockSizeSpinner;

    public BlockProfileDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonSubmit);

        buttonSubmit.addActionListener(new ActionListener() {
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
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        BlockProfileDialog dialog = new BlockProfileDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//        SpinnerModel jModel = new SpinnerNumberModel(0, 0, 1000, .5);
//        blockSizeSpinner.setModel(jModel);
//    }
}
