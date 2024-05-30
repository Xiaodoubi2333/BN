package com.example.sadmanbn.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NotificationsViewModel extends ViewModel {

    //private MutableLiveData<String> mText;            //被替代
    private MutableLiveData<List<Entity>> mutableLiveEntityList; //可观察的数据容器
    private SimpleDateFormat dateFormat;            //日期格式

    public NotificationsViewModel() {   //构造方法
        mutableLiveEntityList= new MutableLiveData<>();  //实例化字段（对象）
        //设置日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        List<Entity> entityList= new ArrayList<>();   //实体列表
        //提供模拟数据
        try{
            entityList.add(new Entity("Math", dateFormat.parse("2024-06-10"),"时间 9:00-11:00, 实验楼504"));
            entityList.add(new Entity("Physics",dateFormat.parse("2024-06-12"), "时间 14:00-16:00, 实验楼220"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //将模拟数据添加到可观察的数据容器
        mutableLiveEntityList.setValue(entityList);
    }

        public LiveData<List<Entity>> getMutableLiveEntityList() {   //getter
            return mutableLiveEntityList;
        }
}