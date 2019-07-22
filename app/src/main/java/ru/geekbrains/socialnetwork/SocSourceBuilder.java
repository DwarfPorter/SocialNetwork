package ru.geekbrains.socialnetwork;

import android.content.res.Resources;

public class SocSourceBuilder {
    private Resources resources;

    public SocSourceData build(){
        SocSource socSource = new SocSource(resources);
        socSource.init();
        return socSource;
    }

    public SocSourceBuilder setResources(Resources resources) {
        this.resources = resources;
        return this;
    }
}
