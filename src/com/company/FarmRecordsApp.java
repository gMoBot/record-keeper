package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FarmRecordsApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        FarmRecordsApp farmRecordsApp = (FarmRecordsApp) context.getBean("farmRecordsApp");
        farmRecordsApp.run();

    }

    private void run(){
	// write your code here
        System.out.println("Welcome!");
        System.out.println("Loading Farm Profile window...");
//        BlockProfile blockProfile = new BlockProfile();
        FarmProfileDialog farmProfileDialog = new FarmProfileDialog();
        farmProfileDialog.pack();
        farmProfileDialog.setVisible(true);
        System.exit(0);
    }

    @Autowired
    private FarmProfileDao farmProfileDao;
}
