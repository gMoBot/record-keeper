package com.company;

import com.company.Dialogs.BlockProfileDialog;
import com.company.Dialogs.FarmOverview;
import com.company.Dialogs.FarmSelectorDialog;
import com.company.FarmSelector.MainFrameApp;
import com.company.Models.ApplicationProfile;
import com.company.Models.BlockProfile;
import com.company.Models.FarmProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component (value= "farmRecordsApp")
public class FarmRecordsApp {

    public FarmRecordsApp(){}

    @Autowired
    private FarmProfileDao farmProfileDao;

    private List<FarmProfile> farmProfiles;

    private String selectedFarmName;
    private List<FarmProfile> selectedFarmProfile;
    private String selectedFarmId;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        FarmRecordsApp obj = (FarmRecordsApp) context.getBean("farmRecordsApp");
        obj.run();

    }

    private void run(){
        System.out.println("Welcome!");
        System.out.println("Loading Farm Profile window...");

        MainFrameApp mainFrameApp = new MainFrameApp();

//        MainFrameFarmSelector mainFrameFarmSelector = new MainFrameFarmSelector();


        farmProfiles = farmProfileDao.getFarmProfile();
        for (FarmProfile farmProfile : farmProfiles){
            System.out.format("%s\n", farmProfile.getFarmName());
        }

//        generateFarmSelector();
//        selectedFarmProfile = farmProfileDao.getSelectedFarmProfile(selectedFarmName);
//        selectedFarmId = String.valueOf(selectedFarmProfile.get(0).getId());

        System.out.format("Selected Farm Name: %s\n", selectedFarmName);

//        generateFarmOverview();

//        generateSelectedBlockProfile();

//        List<BlockProfile> blockProfiles = farmProfileDao.getBlockProfile();
//        for (BlockProfile blockProfile : blockProfiles){
//            System.out.format("%s\n", blockProfile.getBlockName());
//        }
        // Call and load farm profile dialog window
//        enterFarmProfile();

//        // verify profile is saved
//        List<FarmProfile> savedFarmProfiles = farmProfileDao.getFarmProfile();
//        for (FarmProfile farmProfile : savedFarmProfiles){
//            System.out.format("%s\n", farmProfile.getFarmName());
//        }

        // Call and load block profile dialog window
//        enterBlockProfile();

//        List<BlockProfile> savedBlockProfiles = farmProfileDao.getBlockProfile();
//        for (BlockProfile blockProfile : savedBlockProfiles){
//            System.out.format("%s\n", blockProfile.getBlockName());
//        }
        System.exit(0);

    }


    private void generateFarmSelector() {
//        Vector<FarmProfile> profileList = new Vector<FarmProfile>();
//        for(FarmProfile farmProfile : farmProfiles){
//            profileList.add(farmProfile);
//        }
        //TODO: Fine tune data functionality and display on this model
        DefaultListModel<String> profileDefaultListModel = new DefaultListModel<String>();
        farmProfiles = farmProfileDao.getFarmProfile();
//        List<FarmProfile> subListFarmProfiles = farmProfiles.subList(0, 5);
        for (FarmProfile farmProfile : farmProfiles) {
            profileDefaultListModel.addElement(farmProfile.getFarmName());
        }
        FarmSelectorDialog farmSelectorDialog = new FarmSelectorDialog();
        farmSelectorDialog.setFarmProfileList(profileDefaultListModel);
        farmSelectorDialog.pack();
        farmSelectorDialog.setVisible(true);

        if (farmSelectorDialog.getFarmName() != null){
            if (farmSelectorDialog.getFarmName().equals("CreateNew"))
            {
                enterFarmProfile();
                generateFarmSelector();
            }
            else {
                selectedFarmName = farmSelectorDialog.getFarmName();
            }
        }
    }
    public void enterFarmProfile() {
//        Vector<FarmProfile> profileList = new Vector<FarmProfile>();
//        for(FarmProfile farmProfile : farmProfiles){
//            profileList.add(farmProfile);
//        }
        //TODO: Fine tune data functionality and display on this model
//        DefaultListModel<String> profileDefaultListModel = new DefaultListModel<String>();
////        List<FarmProfile> subListFarmProfiles = farmProfiles.subList(0, 5);
//            for (FarmProfile farmProfile : farmProfiles) {
//                profileDefaultListModel.addElement(farmProfile.getFarmName());
//            }
        FarmProfileDialog farmProfileDialog = new FarmProfileDialog();
//        farmProfileDialog.setFarmProfileList(profileDefaultListModel);
        farmProfileDialog.pack();
        farmProfileDialog.setVisible(true);

        if (farmProfileDialog.getFarmProfile() != null) {
            FarmProfile enteredFarmProfile = farmProfileDialog.getFarmProfile();
            farmProfileDao.saveFarmProfile(enteredFarmProfile);
        }
    }

    private void generateFarmOverview() {
            //TODO: Fine tune data functionality and display on this model
            // TODO: change list to table
            DefaultListModel<String> farmOverviewDefaultListModel = new DefaultListModel<String>();
            List<ApplicationProfile> appProfiles = farmProfileDao.getOverviewApplicationProfiles(selectedFarmId);
            if(appProfiles.isEmpty()){
                farmOverviewDefaultListModel.add(0, "ExampleDate");
                farmOverviewDefaultListModel.add(1, "ExampleTime");
                farmOverviewDefaultListModel.add(2, "Example Block Name");
                farmOverviewDefaultListModel.add(3, "Example Target Pest");
                farmOverviewDefaultListModel.add(4, "Example Application Notes");
            }
            else {
                for (ApplicationProfile applicationProfile : appProfiles) {
                    farmOverviewDefaultListModel.addElement(applicationProfile.getAppDate());
                    farmOverviewDefaultListModel.addElement(applicationProfile.getAppTime());
                    farmOverviewDefaultListModel.addElement(applicationProfile.getBlockName());
                    farmOverviewDefaultListModel.addElement(applicationProfile.getTargetPest());
                    farmOverviewDefaultListModel.addElement(applicationProfile.getAppNotes());
                }
            }
        FarmOverview farmOverview = new FarmOverview();
        farmOverview.setFarmApplicationList(farmOverviewDefaultListModel);
        farmOverview.pack();
        farmOverview.setVisible(true);


//            if (farmSelectorDialog.getFarmName() != null) {
//                if (farmSelectorDialog.getFarmName().equals("CreateNew")) {
//                    enterFarmProfile();
//                    generateFarmSelector();
//                } else {
//                    selectedFarmName = farmSelectorDialog.getFarmName();
//                }
//            }
    }


    private void enterBlockProfile(){

        BlockProfileDialog blockProfileDialog = new BlockProfileDialog();
        blockProfileDialog.pack();
        blockProfileDialog.setVisible(true);

        if (blockProfileDialog.getBlockProfile() != null) {
            BlockProfile enteredBlockProfile = blockProfileDialog.getBlockProfile();
            farmProfileDao.saveBlockProfile(enteredBlockProfile);
        }
    }

    private void generateSelectedBlockProfile(){

        List<BlockProfile> selectedBlockProfiles = farmProfileDao.getFarmBlockProfiles(selectedFarmId);

        for (BlockProfile blockProfile : selectedBlockProfiles){
            System.out.format("%s\n", blockProfile.getBlockName());
        }

//        BlockProfileDialog blockProfileDialog = new BlockProfileDialog();
//        blockProfileDialog.pack();
//        blockProfileDialog.setVisible(true);
//
//        if (blockProfileDialog.getBlockProfile() != null) {
//            BlockProfile enteredBlockProfile = blockProfileDialog.getBlockProfile();
//            farmProfileDao.saveBlockProfile(enteredBlockProfile);
//        }
    }

}
