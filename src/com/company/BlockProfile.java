package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by garrettcoggon on 6/4/15.
 */
public class BlockProfile {
    private JPanel panel1;
    private JTextField blockName;
    private JLabel BlockName;
    private JLabel blockSize;
//    jModel = javax.swing.SpinnerNumberModel(24,20,35,1);
    private JSpinner BlockSize;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        JSpinner jspinner = new JSpinner();
        SpinnerModel jModel = new SpinnerNumberModel(0, 0, 1000, .5);
        jspinner.setModel(jModel);

    }
}
