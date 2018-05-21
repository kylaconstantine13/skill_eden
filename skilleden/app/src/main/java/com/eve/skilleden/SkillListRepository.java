package com.eve.skilleden;


// Source: https://github.com/googlesamples/android-architecture-components/blob/master/BasicSample/app/src/main/java/com/example/android/persistence/DataRepository.java

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.eve.skilleden.model.SkillGroup;
import com.eve.skilleden.model.SkillList;

import java.util.Optional;

public class SkillListRepository {
    private static SkillListRepository sInstance; //singleton
//    private MediatorLiveData<SkillList> mObservableSkillList;  //Prob don't need to make mediator --
    private MediatorLiveData<SkillList> mObservableSkillList;  //Prob don't need to make mediator --

    //atm. we don't need to worry about adding or updating skills now. Setting groundworks for live
    // character skill data

    private SkillListRepository() {
        mObservableSkillList = new MediatorLiveData<>();
        SkillList skillList = new SkillList();
        skillList.populateAllSkills();
        mObservableSkillList.setValue(skillList);

    }

    public static SkillListRepository getInstance() {
        if (sInstance == null) {
            synchronized (SkillListRepository.class) {
                if (sInstance == null) {
                    sInstance = new SkillListRepository();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the list of products from the database and get notified when the data changes.
     */
    public LiveData<SkillList> getSkillList() {
        return mObservableSkillList;
    }
    public Optional<SkillGroup> loadSkillGroup(final int skillGroupID) {
        return mObservableSkillList.getValue().getSkillGroup(skillGroupID);
    }
}