package com.company;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by garrettcoggon on 6/5/15.
 */
public class ArrayListComboBoxModel extends AbstractListModel implements ComboBoxModel {
    private Object selectedItem;
    private ArrayList anArrayList;
    public ArrayListComboBoxModel(ArrayList arrayList){
        anArrayList = arrayList;
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return anArrayList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return anArrayList.get(index);
    }
}
