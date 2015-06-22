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

    }

    private void run(){
        System.out.println("Welcome!");
        System.out.println("Loading Farm Profile window...");

        List<FarmProfile> farmProfiles = farmProfileDao.getFarmProfile();
        for (FarmProfile farmProfile : farmProfiles){
            System.out.format("%s\n", farmProfile.getFarmName());
        }

        // Call and load farm profile dialog window
        FarmProfileDialog farmProfileDialog = new FarmProfileDialog();
        farmProfileDialog.pack();
        farmProfileDialog.setVisible(true);

        FarmProfile enteredFarmProfile = farmProfileDialog.getFarmProfile();
        farmProfileDao.saveFarmProfile(enteredFarmProfile);

        // verify profile is saved
        List<FarmProfile> savedFarmProfiles = farmProfileDao.getFarmProfile();
        for (FarmProfile farmProfile : savedFarmProfiles){
            System.out.format("%s\n", farmProfile.getFarmName());
        }

        System.exit(0);

    }

}
