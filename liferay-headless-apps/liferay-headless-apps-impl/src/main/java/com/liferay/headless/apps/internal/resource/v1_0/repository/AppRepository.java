package com.liferay.headless.apps.internal.resource.v1_0.repository;

import com.liferay.headless.apps.dto.v1_0.App;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppRepository implements Serializable {

    private List<App> apps = new ArrayList<>();

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }
}
