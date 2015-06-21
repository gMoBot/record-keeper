package com.company;

import com.company.Models.FarmProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

//@Component
public class FarmProfileDialog extends JDialog {

//    @Autowired
//    private FarmProfileDao farmProfileDao1;
//    @Autowired
//    private FarmRecordsApp farmRecordsApp;

    private JPanel contentPane;
    private JButton submit;
    private JButton buttonCancel;
    private JTextField farmName;
    private JTextField ownerName;
    private JTextField streetAddress;
    private JComboBox state;
    private JTextField zipCode;

    public FarmProfile farmProfile = new FarmProfile();
//    public void setFarmProfile(FarmProfile farmProfile){
//        this.farmProfile = farmProfile;
//    }

    public FarmProfileDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(submit);
//        setFarmProfile(farmProfile);

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
// add your code here
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        FarmProfileDao obj = (FarmProfileDao) context.getBean("farmProfileDao");

//        fp.setOwnerName(ownerName.getText());
//        fp.setStreetAddress(streetAddress.getText());
//        fp.setStateCode(String.valueOf(state));
//        fp.setZipcode(zipCode.getText());

        // Create new Farm Profile Object
        //TODO COrrect
//        FarmProfile fp = new FarmProfile();
//        farmProfile.setId(0);
        farmProfile.setFarmName(String.valueOf(farmName.getText()));
        farmProfile.setOwnerName(String.valueOf(ownerName.getText()));
        farmProfile.setStreetAddress(String.valueOf(streetAddress.getText()));
        farmProfile.setStateCode(String.valueOf(state.getSelectedItem()));
        farmProfile.setZipcode(String.valueOf(zipCode.getText()));

        setVisible(false);
//        farmRecordsApp.saveFarmProfile(fp);
        // Add FarmProfile to database
//        obj.saveFarmProfile(fp);
//        farmProfileDao1.saveFarmProfile(fp);
//        List<FarmProfile> farmProfilelist = farmProfileDao1.getFarmProfile();
//        fpd.saveFarmProfile(fp);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    //
//    @PostConstruct
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        FarmProfileDao obj = (FarmProfileDao) context.getBean("farmProfileDao");
        FarmProfileDialog dialog = new FarmProfileDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


//    private FarmProfileDao farmProfileDao;
//    public void setFarmProfileDao(FarmProfileDao farmProfileDao){
//        this.farmProfileDao = farmProfileDao;
//    }
//    private FarmProfileDao fpd;
//
//    public void setFarmProfileDao(FarmProfileDao fpd){
//        this.fpd = fpd;
//    }
    public FarmProfile getFarmProfile(){
        return farmProfile;
    }
}
