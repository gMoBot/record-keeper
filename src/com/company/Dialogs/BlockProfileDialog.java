package com.company.Dialogs;

import com.company.DAO.SQLiteDAO;
import com.company.FarmProfileDao;
import com.company.FarmRecordsApp;
import com.company.Models.BlockProfile;
import com.company.Models.FarmProfile;
import jdk.nashorn.internal.ir.BlockLexicalContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

@Component
public class BlockProfileDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonSubmit;
    private JButton buttonCancel;
    private JTextField blockName;
    private JTextField blockStreetAddress;
    private JTextField blockZipCode;
    private JComboBox blockState;
    private JTextField blockSize;
    private JTextField blockCrop;
    private JList<BlockProfile> blockProfileJList;
//    private JSpinner blockSizeSpinner;

    private BlockProfile blockProfile;


    public BlockProfile getBlockProfile() {
        return blockProfile;
    }


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
//        blockProfile.setFarmId();
        blockProfile = new BlockProfile();
        blockProfile.setBlockName(String.valueOf(blockName.getText()));
        blockProfile.setBlockStreetAddress(String.valueOf(blockStreetAddress.getText()));
        blockProfile.setBlockStateCode(String.valueOf(blockState.getSelectedItem()));
        blockProfile.setBlockZipcode(String.valueOf(blockZipCode.getText()));
        blockProfile.setBlockSize(Float.parseFloat(blockSize.getText()));
        blockProfile.setBlockCrop(String.valueOf(blockCrop.getText()));
        setVisible(false);

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
    //        JSpinner jspinner = new JSpinner();
//
//    }
//    }
}
