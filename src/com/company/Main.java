package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome!");
        System.out.println("Loading Farm Profile window...");
//        BlockProfile blockProfile = new BlockProfile();
        FarmProfileDialog farmProfileDialog = new FarmProfileDialog();
        farmProfileDialog.pack();
        farmProfileDialog.setVisible(true);
        System.exit(0);
    }
}
