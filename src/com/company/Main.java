package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome!");
        System.out.println("Loading home window...");
//        BlockProfile blockProfile = new BlockProfile();
        BlockProfileDialog blockProfileDialog = new BlockProfileDialog();
        blockProfileDialog.pack();
        blockProfileDialog.setVisible(true);
        System.exit(0);
    }
}
