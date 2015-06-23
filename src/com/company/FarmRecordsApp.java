package com.company;

import com.company.Dialogs.BlockProfileDialog;
import com.company.Models.BlockProfile;
import com.company.Models.FarmProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

@Component (value= "farmRecordsApp")
public class FarmRecordsApp {

    public FarmRecordsApp(){}

    @Autowired
    private FarmProfileDao farmProfileDao;

    private List<FarmProfile> farmProfiles;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        FarmRecordsApp obj = (FarmRecordsApp) context.getBean("farmRecordsApp");
        obj.run();

    }

    private void run(){
        System.out.println("Welcome!");
        System.out.println("Loading Farm Profile window...");

        farmProfiles = farmProfileDao.getFarmProfile();
        for (FarmProfile farmProfile : farmProfiles){
            System.out.format("%s\n", farmProfile.getFarmName());
        }

        List<BlockProfile> blockProfiles = farmProfileDao.getBlockProfile();
        for (BlockProfile blockProfile : blockProfiles){
            System.out.format("%s\n", blockProfile.getBlockName());
        }
        // Call and load farm profile dialog window
        enterFarmProfile();

        // verify profile is saved
        List<FarmProfile> savedFarmProfiles = farmProfileDao.getFarmProfile();
        for (FarmProfile farmProfile : savedFarmProfiles){
            System.out.format("%s\n", farmProfile.getFarmName());
        }

        // Call and load block profile dialog window
        enterBlockProfile();

        List<BlockProfile> savedBlockProfiles = farmProfileDao.getBlockProfile();
        for (BlockProfile blockProfile : savedBlockProfiles){
            System.out.format("%s\n", blockProfile.getBlockName());
        }
        System.exit(0);

    }

    private void enterFarmProfile() {
//        Vector<FarmProfile> profileList = new Vector<FarmProfile>();
//        for(FarmProfile farmProfile : farmProfiles){
//            profileList.add(farmProfile);
//        }
        //TODO: Fine tune data functionality and display on this model
        DefaultListModel<String> profileDefaultListModel = new DefaultListModel<String>();
        for(FarmProfile farmProfile : farmProfiles) {
            profileDefaultListModel.addElement(farmProfile.getFarmName());
        }

        FarmProfileDialog farmProfileDialog = new FarmProfileDialog();
        farmProfileDialog.setFarmProfileList(profileDefaultListModel);
        farmProfileDialog.pack();
        farmProfileDialog.setVisible(true);

        FarmProfile enteredFarmProfile = farmProfileDialog.getFarmProfile();
        farmProfileDao.saveFarmProfile(enteredFarmProfile);
    }

    private void enterBlockProfile(){
        BlockProfileDialog blockProfileDialog = new BlockProfileDialog();
        blockProfileDialog.pack();
        blockProfileDialog.setVisible(true);

        BlockProfile enteredBlockProfile = blockProfileDialog.getBlockProfile();
        farmProfileDao.saveBlockProfile(enteredBlockProfile);
    }

}
