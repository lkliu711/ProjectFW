package com.example.pfw.projectframework.config;

/**
 * Created by wangfangqi on 16/8/13.
 * 6.0需请求权限
 */
public class Permission {

    public static final int WRITE_EXTERNAL_STORAGE = 101;



    //施工单排单
    public static final String ISSUED = "wx_co_issued";
    //施工单排期
    public static final String SCHEDULE = "wx_co_schedule";
    //施工单待退库
    public static final String WAIT_CANCEL_STOCKS = "wx_co_wait_cancel_stocks";
    //施工单售后
    public static final String AFTER_SALES = "wx_co_after_sales";
    //施工单审核
    public static final String CHECK = "wx_co_check";
    //施工单巡查
    public static final String INSPECT = "wx_co_inspect";
    //上传施工单图片
    public static final String TAKE_PHOTO = "wx_co_takephoto";
    //下单
    public static final String TAKE = "wx_co_take";


    //待排单查看
    public static final String WAIT_ISSUED_VIEW = "wx_co_wait_issued_view";
    //施工单待排期查看
    public static final String WAIT_SCHEDULE_VIEW = "wx_co_wait_schedule_view";
    //施工单已排期查看
    public static final String SCHEDULED_VIEW = "wx_co_scheduled_view";
    //施工单待审核查看
    public static final String WAIT_CHECK_VIEW = "wx_co_wait_check_view";
    //施工单待退库查看
    public static final String WAIT_CANCEL_STOCKS_VIEW = "wx_co_wait_cancel_stocks_view";
    //施工单已完成查看
    public static final String FINISHED_VIEW = "wx_co_finished_view";


    //我的施工
    public static final String MY_CO = "wx_my_co";
    //我的考核
    public static final String MY_CHECK = "wx_my_check";
    //我的收入
    public static final String MY_INCOME = "wx_my_income";
    //快速排单
    public static final String MY_DIPATCH = "wx_my_dipatch";
    //更多设置
    public static final String MY_SETTING = "wx_my_setting";

}
