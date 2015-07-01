//package com.company;
//
//import apple.laf.JRSUIConstants;
//import com.company.Models.ApplicationProfile;
//import org.hibernate.mapping.Column;
//import sun.jvm.hotspot.oops.Instance;
//
//import javax.swing.table.AbstractTableModel;
//import java.lang.reflect.Field;
//import java.util.List;
//
///**
// * Created by garrettcoggon on 6/25/15.
// */
//public class ApplicationOverviewTable extends AbstractTableModel {
//
//    private int rowCount;
//    private int columnCount;
//    private ApplicationProfile applicationProfile;
//
//    public int getRowCount() {
//        return rowCount;
//    }
//
//    public int getColumnCount() {
//        return 6;
//    }
//
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch (columnIndex) {
//            case 0:
//                return applicationProfile.getAppDate();
//            case 1:
//                return applicationProfile.getAppTime();
//            case 2:
//                return applicationProfile.getBlockName();
//            case 3:
//                return applicationProfile.getTargetPest();
//            case 4:
//                return applicationProfile.getProductName();
//            case 5:
//                return applicationProfile.getAppNumber();
//            case 6:
//                return applicationProfile.getAppNotes();
//            default:
//            return null;
//        }
//    }
//
//    public AbstractTableModel buildApplicationOverviewTable(List<ApplicationProfile> applicationProfiles){
//        this.rowCount = applicationProfiles.size();
//        int rowIndex = 0;
//        for (ApplicationProfile applicationProfile : applicationProfiles) {
//            this.applicationProfile = applicationProfile;
//            for (int i = 0; i < columnCount; i++) {
//                getValueAt(rowIndex, i);
//            }
//            rowIndex++;
//        }
//    }
//}
