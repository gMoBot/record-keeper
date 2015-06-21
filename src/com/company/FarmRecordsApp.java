package com.company;

import com.company.Models.FarmProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component (value= "farmRecordsApp")
public class FarmRecordsApp {

    public FarmRecordsApp(){}

    @Autowired
    private FarmProfileDao farmProfileDao;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        FarmRecordsApp obj = (FarmRecordsApp) context.getBean("farmRecordsApp");
        obj.run();
//        FarmRecordsApp farmRecordsApp = new FarmRecordsApp();
//        farmRecordsApp.run();

    }

    private void run(){
	// write your code here
        System.out.println("Welcome!");
        System.out.println("Loading Farm Profile window...");

        List<FarmProfile> farmProfiles = farmProfileDao.getFarmProfile();
        for (FarmProfile farmProfile : farmProfiles){
            System.out.format("%s", farmProfile.getFarmName());
        }

//        DICLass dicLass = new DICLass();
//        dicLass.diClassTest();

//        List<FarmProfile> startingFarmProfiles = new ArrayList<FarmProfile>();
//        startingFarmProfiles = farmProfileDao.getFarmProfile();
//        if (! startingFarmProfiles.isEmpty()) {
////          startingFarmProfiles = farmProfileDao.getFarmProfile();
//            for (FarmProfile farmProfile : startingFarmProfiles){
//                System.out.format("%s", farmProfile.getFarmName());
//            }
//        }
//        else {
//            System.out.println("No farm profiles found, please create a new farm profile");
//        }

//        //TODO: this is correct
        FarmProfileDialog farmProfileDialog = new FarmProfileDialog();
        farmProfileDialog.pack();
        farmProfileDialog.setVisible(true);

        FarmProfile enteredFarmProfile = farmProfileDialog.getFarmProfile();
        farmProfileDao.saveFarmProfile(enteredFarmProfile);
//        saveFarmProfile(farmProfileDialog.getFarmProfile());

//        FarmProfileDialog farmProfileDialog = new FarmProfileDialog();
//        farmProfileDialog.pack();
//        farmProfileDialog.setVisible(true);

        List<FarmProfile> savedFarmProfiles = farmProfileDao.getFarmProfile();
        for (FarmProfile farmProfile : savedFarmProfiles){
            System.out.format("%s", farmProfile.getFarmName());
        }

        System.exit(0);

    }

//    public void saveFarmProfile(FarmProfile farmProfile){
//        farmProfileDao.saveFarmProfile(farmProfile);
//    }
}
