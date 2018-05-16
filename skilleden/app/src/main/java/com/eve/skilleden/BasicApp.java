package com.eve.skilleden;

import android.app.Application;

public class BasicApp extends Application {
    private AppExecutor appExecutor;

    @Override
    public void onCreate() {
        super.onCreate();

        appExecutor = new AppExecutor();
    }

    public SkillListRepository getSkillListRepository() {
        return SkillListRepository.getInstance(); //singleton
    }
}
