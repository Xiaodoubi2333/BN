package com.example.sadmanbn.ui.notifications;
/**
 * 视图模型类和Fragment类都使用本实体类
 * 当实体类字段较多时，可考虑使用Lombok注解，以简化代码。
 */
import java.util.Date;

public class Entity {  //考试通知实体类
    private String courseName;  //课程名
    private Date examDate;  //考试日期
    private String examDetails;  //考试详情

    public Entity(String courseName, Date examDate, String examDetails){  //构造方法
        this.courseName=courseName;
        this.examDate=examDate;
        this.examDetails=examDetails;
    }

    public String getCourseName(){    //getter
        return courseName;
    }

    public Date getExamDate(){    //getter
        return examDate;
    }

    public String getExamDetails(){   //getter
        return examDetails;
    }
}