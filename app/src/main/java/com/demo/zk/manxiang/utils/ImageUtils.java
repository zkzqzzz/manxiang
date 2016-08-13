package com.demo.zk.manxiang.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * Created by HG on 2015/10/24.
 */
public class ImageUtils {

    public static void loadImage(Context context, String url,final ImageView imageView,final int resId){

        if (imageView.getTag() == null ||! imageView.getTag().equals(url)) {
            getInstance(context).loadImage(StringUtils.absoluteUrl(url), new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {
                    imageView.setImageResource(resId);
                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {
                    imageView.setImageResource(resId);
                }

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    imageView.setImageBitmap(bitmap);
                }

                @Override
                public void onLoadingCancelled(String s, View view) {

                }
            });
            imageView.setTag(url);
        }
    }

    public static void loadImage(Context context, String url,ImageView imageView){
        getInstance(context).displayImage(StringUtils.absoluteUrl(url),imageView);
    }

    public static void displayImage(Context context, String url,final ImageView imageView){
        Glide.with(context)
                .load(StringUtils.absoluteUrl(url))
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void displayImage(Context context, String url,final ImageView imageView,final int resId){
        Glide.with(context)
                .load(StringUtils.absoluteUrl(url))
                .placeholder(resId)
                .error(resId)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void cropImage(Context context, String url,final ImageView imageView,final int resId){
        Glide.with(context)
                .load(StringUtils.absoluteUrl(url))
                .placeholder(resId)
                .error(resId)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(imageView);
    }

    public static  ImageLoader getInstance(Context context){
        ImageLoader imageLoader =  ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)                               //启用内存缓存
                .cacheOnDisk(true)                                 //启用外存缓存
                .considerExifParams(true)                          //启用EXIF和JPEG图像格式
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(context)
                .defaultDisplayImageOptions(options)
                .memoryCacheExtraOptions(3000, 3000) // maxwidth, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(5)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(1024 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(1024 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .build();//开始构建
        imageLoader.init(config);
        return imageLoader;
    }

    public static void saveImageToGallery(Context context, Bitmap bmp) {
        if(!OSUtils.hasSdcard()){
            Toast.makeText(context, "请插入内存卡", Toast.LENGTH_SHORT).show();
            return;
        }
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "manxiang");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
    }

    public static File saveBitmap(Context context, Bitmap bmp) {
        if(!OSUtils.hasSdcard()){
            Toast.makeText(context, "请插入内存卡", Toast.LENGTH_SHORT).show();
            return null;
        }
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "manxiang");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File saveUri(Activity activity,Uri uri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor actualimagecursor = activity.managedQuery(uri, proj, null, null, null);
        int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        actualimagecursor.moveToFirst();
        String img_path = actualimagecursor.getString(actual_image_column_index);
        return new File(img_path);
    }

    public static  void downloadImage(final Context context,String img){

        final  KProgressHUD hud = KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("图片下载中");

        ImageUtils.getInstance(context).loadImage(StringUtils.absoluteUrl(img), new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {
                hud.show();
            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {
                hud.dismiss();
                Toast.makeText(context, "下载失败，请稍后重试", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                ImageUtils.saveImageToGallery(context, bitmap);
                hud.dismiss();
                Toast.makeText(context, "作品已下载到相册", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoadingCancelled(String s, View view) {
                hud.dismiss();
                Toast.makeText(context, "下载取消", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static  void downloadImage(final Context context,final List<String> imgs){

        final  KProgressHUD hud = KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("图片下载中");

        for(int i=0;i<imgs.size();i++){
            String img = imgs.get(i);
            final int num = i;
            ImageUtils.getInstance(context).loadImage(StringUtils.absoluteUrl(img), new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {
                    hud.show();
                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {
                    hud.dismiss();
                    Toast.makeText(context, "下载失败，请稍后重试", Toast.LENGTH_LONG).show();
                }
                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    ImageUtils.saveImageToGallery(context, bitmap);
                    if(num==imgs.size()-1) {
                        hud.dismiss();
                        Toast.makeText(context,"作品已下载到相册",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onLoadingCancelled(String s, View view) {
                    hud.dismiss();
                    Toast.makeText(context, "下载取消", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
