package com.example.pfw.projectframework.config;

/**
 * Created by wangfangqi on 16/8/17.
 * 常量
 */
public class Constant {

    /**
     * 待排单
     */
    public static final int ARRANGE_ORDER = 0;
    /**
     * 待排期
     */
    public static final int ARRANGE_TIME = 1;
    /**
     * 已排期
     */
    public static final int SCHEDULED = 2;
    /**
     * 安装中
     */
    public static final int INSTALLING = 3;
    /**
     * 待复核
     */
    public static final int TO_REVIEW = 4;
    /**
     * 已完成
     */
    public static final int COMPLETED = 5;

    /**
     * 施工
     */
    public static final int CONSTRUCTION = 1;
    /**
     * 考核
     */
    public static final int ASSESSMENT = 2;
    /**
     * 收入
     */
    public static final int INCOME = 3;
    /**
     * 积分
     */
    public static final int POINT = 4;
    /**
     * 商城
     */
    public static final int SHOPMALL = 5;

    /**
     * 设置
     */
    public static final int SETTING = 6;

    /**
     * 快速排单
     */
    public static final int SINGLEROW = 7;

    /**
     * 查看考核
     */
    public static final int VIEWEXAMINATION = 8;


    //SharedPreferences表单key
    //登录状态
    public static final String LOGIN = "logged-in";
    //登录实体类
    public static final String LOGIN_INFO = "loginInfo";
    //用户积分
    public static final String USER_POINT = "userpoint";
    //登录手机号
    public static final String MOBILE = "mobile";

    //RxBus-key
    public static final String ORDER_DETAIL = "orderDetail";
    public static final String SCHEDULE_REFRESH = "scheduleRefresh";
}
