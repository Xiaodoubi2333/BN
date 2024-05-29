package com.example.sadmanbn.ui.call;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CallViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CallViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is call fragment\n\nfragment 内部输出, 是在 fragment.java 里面. ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}