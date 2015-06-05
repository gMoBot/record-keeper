package com.company;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.text.StringContent;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

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
//        createUIComponents();
        $$$setupUI$$$();
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

        // TODO: Generate Time List
        ArrayList arrayList = appTimeList();
        ArrayListComboBoxModel model = new ArrayListComboBoxModel(arrayList);
        JComboBox applicationTime = new JComboBox(model);

//        Vector<String> timeArray = appTimeList();

//        applicationTime = new JComboBox(timeArray);
//        DefaultComboBoxModel<String> timeModel = new DefaultComboBoxModel<>(timeArray);

//         applicationTime = new JComboBox<String>(timeArray);

//        applicationTime = new JComboBox<String>(timeModel) .setModel(timeModel);
//        applicationTime.setModel(new DefaultComboBoxModel<>(timeArray));
//        timeApplied.setModel(timeModel);
//        applicationTime.setModel(timeModel);
//        ArrayList arrayList = appTimeList();

        }
        // TODO: Generate Product List

    private void $$$setupUI$$$() {
        createUIComponents();
    }

    private ArrayList appTimeList(){
        String ampm = "am";
//        String pm = "pm";
//        String[] appTimeList = new String[100];
        int k = 0;
        ArrayList<String> appTimeList = new ArrayList<String>(100);
        for (int x = 0; x < 1; x++){
            for (int i = 0; i < 12; i++){
                int timeUnit = 0;
                for (int j = 0; j < 4; j++){
                    String listItem = i + timeUnit + ampm;
                    timeUnit = timeUnit + 15;
                    appTimeList.add(k, listItem);
                    k++;
                }
//                k++;
                ampm = "pm";
            }
        }
        appTimeList.trimToSize();
        return appTimeList;
    }

}
