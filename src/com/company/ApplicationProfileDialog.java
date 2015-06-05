package com.company;

import javax.swing.*;
import java.awt.event.*;

public class ApplicationProfileDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonSubmit;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTable dateTable;
    private JComboBox product;
    private JTextField targetPest;
    private JTextArea notes;
    private JCheckBox ownerCheckBox;
    private JComboBox applicator;
    private JComboBox applicationTime;
    private JComboBox blockName;

    public ApplicationProfileDialog() {
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
        ApplicationProfileDialog dialog = new ApplicationProfileDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        
        // TODO: Pull from Block DB

        // TODO: Generate Applicator List

        // TODO: Generate Date Table
        //        String[] timeArray = appTimeList();
////        applicationTime = new JComboBox(timeArray);
//        JComboBox<String> timeApplied = new JComboBox<String>();
//        DefaultComboBoxModel<String> timeModel = new DefaultComboBoxModel<>(timeArray);
////        applicationTime.setModel(new DefaultComboBoxModel<>(timeArray));
//        timeApplied.setModel(timeModel);

        // TODO: Generate Product List

    }
//    private String[] appTimeList(){
//        String ampm = "am";
////        String pm = "pm";
//        String[] appTimeList = new String[100];
//        for (int x = 0; x < 1; x++){
//            int k = 0;
//            for (int i = 0; i < 12; i++){
//                int timeUnit = 0;
//                for (int j = 0; j < 4; j++){
//                    String listItem = i + timeUnit + ampm;
//                    timeUnit = timeUnit + 15;
//                    appTimeList[k] = listItem;
//                    k++;
//                }
//                k++;
//                ampm = "pm";
//            }
//        }
//        return appTimeList;
//    }

}
