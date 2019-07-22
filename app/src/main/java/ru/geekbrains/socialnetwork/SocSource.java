package ru.geekbrains.socialnetwork;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class SocSource {
    private List<Soc> dataSource;
    private Resources resources;

    public SocSource(Resources resources) {
        this.resources = resources;
        dataSource = new ArrayList<Soc>(7);
    }

    public SocSource build() {
        String[] description = resources.getStringArray(R.array.descriptions);
        int[] pictures = getImageArray();
        for (int i = 0; i < description.length; i++){
            dataSource.add(new Soc(description[i], pictures[i], false));
        }
        return this;
    }

    public Soc getSoc(int position){
        return dataSource.get(position);
    }

    public int size(){
        return dataSource.size();
    }

    private int[] getImageArray() {
        TypedArray pics = resources.obtainTypedArray(R.array.pictures);
        int length = pics.length();
        int[] pictures = new int[length];
        for (int i = 0; i < length; i++) {
            pictures[i] = pics.getResourceId(i, 0);
        }
        return pictures;
    }


}
