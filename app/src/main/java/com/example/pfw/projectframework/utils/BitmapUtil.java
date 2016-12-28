package com.example.pfw.projectframework.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.pfw.projectframework.manager.FolderManager;
import rx.Observable;

/**
 * Created by wangfangqi on 16/8/13.
 */
public class BitmapUtil {

    private static final String TAG = BitmapUtil.class.getCanonicalName();

    public static int getBitmapDegree(String path) {
        short degree = 0;

        try {
            ExifInterface e = new ExifInterface(path);
            int orientation = e.getAttributeInt("Orientation", 1);
            switch(orientation) {
                case 3:
                    degree = 180;
                    break;
                case 6:
                    degree = 90;
                    break;
                case 8:
                    degree = 270;
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return degree;
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float)degree);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if(bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }

        return newBitmap;
    }

    public static Bitmap decodeBitmapFromFile(File imageFile, int requestWidth, int requestHeight) {
        return imageFile != null?decodeBitmapFromFile(imageFile.getAbsolutePath(), requestWidth, requestHeight):null;
    }

    public static Bitmap decodeBitmapFromFile(String imagePath, int requestWidth, int requestHeight) {
        if(TextUtils.isEmpty(imagePath)) {
            return null;
        } else {
            Log.i(TAG, "requestWidth: " + requestWidth);
            Log.i(TAG, "requestHeight: " + requestHeight);
            if(requestWidth > 0 && requestHeight > 0) {
                BitmapFactory.Options options1 = new BitmapFactory.Options();
                options1.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(imagePath, options1);
                Log.i(TAG, "original height: " + options1.outHeight);
                Log.i(TAG, "original width: " + options1.outWidth);
                if(options1.outHeight == -1 || options1.outWidth == -1) {
                    try {
                        ExifInterface e = new ExifInterface(imagePath);
                        int height = e.getAttributeInt("ImageLength", 1);
                        int width = e.getAttributeInt("ImageWidth", 1);
                        Log.i(TAG, "exif height: " + height);
                        Log.i(TAG, "exif width: " + width);
                        options1.outWidth = width;
                        options1.outHeight = height;
                    } catch (IOException var7) {
                        var7.printStackTrace();
                    }
                }

                options1.inSampleSize = calculateInSampleSize(options1, requestWidth, requestHeight);
                Log.i(TAG, "inSampleSize: " + options1.inSampleSize);
                options1.inJustDecodeBounds = false;
                return BitmapFactory.decodeFile(imagePath, options1);
            } else {
                Bitmap options = BitmapFactory.decodeFile(imagePath);
                return options;
            }
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;

            for(int halfWidth = width / 2; halfHeight / inSampleSize > reqHeight && halfWidth / inSampleSize > reqWidth; inSampleSize *= 2) {

            }

            long totalPixels = (long)(width * height / inSampleSize);

            for(long totalReqPixelsCap = (long)(reqWidth * reqHeight * 2); totalPixels > totalReqPixelsCap; totalPixels /= 2L) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Observable<File> saveImageBitmap(Bitmap bitmap, String fileName) {
        return Observable.just(bitmap)
                .flatMap(bitmap1 -> {
                    String name;
                    if (TextUtils.isEmpty(fileName)) {
                        name = System.currentTimeMillis() + ".jpg";
                    } else {
                        name = fileName;
                    }
                    File file = new File(FolderManager.getPhotoFolder(), name);
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return Observable.just(file);
                });
    }

    public static Bitmap getBitmap(Activity context, View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        // 获取windows中最顶层的view
        View v = context.getWindow().getDecorView();
        v.buildDrawingCache();

        // 获取状态栏高度
        Rect rect = new Rect();
        v.getWindowVisibleDisplayFrame(rect);

        // 去掉状态栏
        Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache(), location[0],
                location[1], view.getWidth(), view.getHeight());
        // 销毁缓存信息
        view.destroyDrawingCache();
        return bmp;
    }
}
