package com.eve.skilleden.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.eve.skilleden.model.SkillList;
import com.eve.skilleden.model.SkillGroup;

import java.util.List;

//TODO: determine if there is need for live data mediator  -- might be necessary - livedata

public class SkillListViewModel extends AndroidViewModel {

    private List<SkillGroup> skillGroups;

    public SkillListViewModel(@NonNull Application application) {
        super(application);

        SkillList skillList = new SkillList();
        skillList.populateAllSkills(); //TODO: we shouldn't have to worry about this extra step.
        this.skillGroups = skillList.getSkillGroups();
    }


    @Override
    protected void onCleared() {
        LiveData liveData; //TODO: place holder
        super.onCleared();
    }
}
