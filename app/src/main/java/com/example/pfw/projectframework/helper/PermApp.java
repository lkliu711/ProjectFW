package com.example.pfw.projectframework.helper;

/**
 * Created by wangfangqi on 16/9/7.
 * 权限
 */
public enum PermApp {

    SHOW_ARRANGE_ORDER("查看待排单列表","wx_co_wait_issued_list"),
    SHOW_ARRANGE_TIME("查看待排期列表","wx_co_wait_schedule_list"),
    SHOW_SCHEDULED("查看已排期列表","wx_co_scheduled_list"),
    SHOW_INSTALLING("查看安装中列表","wx_co_installing_list"),
    SHOW_TO_REVIEW("查看待复核列表","wx_co_wait_check_list"),
    SHOW_FINISHED("查看已完成列表","wx_co_finished_list"),


    TAKE_ORDER("下单", "wx_co_take"),
    ARRANGE_ORDER("排单", "wx_co_issued"),
    ARRANGE_TIME("排期", "wx_co_schedule"),
    OUT_STOCK("出库", "wx_co_pickstocks"),
    START_OFF("出发", "wx_co_startoff"),
    ARRIVED("到达", "wx_co_arrived"),
    CONFIRM_COINFO("填写施工情况", "wx_co_confirm_coinfo"),
    LIVE_BEHALF_CHARGE("现场代收费", "wx_co_live_behalf_charge"),
    TAKE_PICTURE("水路图拍照", "wx_co_take_picture"),
    CHECK_PICTURE("审核照片", "wx_co_check_picture"),
    INSPECT("生成巡查单", "wx_co_inspect"),
    TO_REFUND("退库", "wx_co_return_warehouse"),


    MINE_SETTING("更多设置", "wx_my_setting"),
    MINE_ORDER("我的施工", "wx_my_co"),
    MINE_CHECK("我的考核", "wx_my_check"),
    MINE_INCOME("我的收入", "wx_my_income"),
    MINE_DIPATCH("快速排单", "wx_my_dipatch"),
    MINE_POINT("我的积分", "wx_my_point"),
    MINE_MALL("积分商城", "wx_my_point_mall"),

    TODO_LIST("待办事项", "wx_todo_list");


    private String name;
    private String menuCode;

    public String getName() {
        return name;
    }

    public String getMenuCode() {
        return menuCode;
    }

    PermApp(String name, String menuCode) {
        this.name = name;
        this.menuCode = menuCode;
    }
}
