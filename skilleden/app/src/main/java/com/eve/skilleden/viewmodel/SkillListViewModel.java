package com.eve.skilleden.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.eve.skilleden.SkillListRepository;
import com.eve.skilleden.model.SkillList;

//TODO:live data mediator might be necessary in future
//source: https://github.com/googlesamples/android-architecture-components/blob/master/BasicSample/app/src/main/java/com/example/android/persistence/viewmodel/ProductViewModel.java
public class SkillListViewModel extends AndroidViewModel {
    private final MediatorLiveData<SkillList> mObservableSkillList;


    public SkillListViewModel(@NonNull Application application, SkillListRepository repository) {
        super(application);
        mObservableSkillList = null;
        LiveData<SkillList> skillListLiveData = repository.getSkillLists();
        mObservableSkillList.addSource(skillListLiveData, mObservableSkillList::setValue);
    }

    public LiveData<SkillList> getSkillList() {
        return mObservableSkillList;
    }
}

