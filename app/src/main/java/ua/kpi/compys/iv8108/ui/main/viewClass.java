package ua.kpi.compys.iv8108.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class viewClass extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    public void setIndex(int index) {
        mIndex.setValue(index);
    }
}
