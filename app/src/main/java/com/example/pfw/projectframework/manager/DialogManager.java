package com.example.pfw.projectframework.manager;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.pfw.projectframework.R;


/**
 * Created by liulinkai on 16/9/7.
 */
public class DialogManager {
    public interface OnClickListener {
        void confirm();

        void cancel();
    }

//    public static Dialog chooseDialog(Context context, final OnChooseClick onChooseClick) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.dialog_choose, null);
//        TextView btTop = (TextView) view.findViewById(R.id.bttop);
//        TextView btBottom = (TextView) view.findViewById(R.id.btbottom);
//        Button cancel = (Button) view.findViewById(R.id.cancel);
//        // dialog配置
//        final Dialog dialog = new Dialog(context, R.style.transparentFrameWindowStyle);//dialog样式
//        dialog.setContentView(view, new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//        Window window = dialog.getWindow();
//        window.setWindowAnimations(R.style.timepopwindow_anim_style);//时间选择器popwidnow 显示消失动画
//        WindowManager.LayoutParams wl = window.getAttributes();
//        wl.x = 0;
//        wl.y = window.getWindowManager().getDefaultDisplay().getHeight();
//        // 以下这两句是为了保证按钮可以水平满屏
//        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
//        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        // 设置显示位置
//        dialog.onWindowAttributesChanged(wl);
//        // 设置点击外围解散
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                dialog.dismiss();
//            }
//        });
//        btTop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onChooseClick.takePhoto();
//                dialog.dismiss();
//            }
//        });
//        btBottom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onChooseClick.choosePhoto();
//                dialog.dismiss();
//            }
//        });
//        return dialog;
//    }

    public interface OnChooseClick {
        void takePhoto();

        void choosePhoto();
    }
}
