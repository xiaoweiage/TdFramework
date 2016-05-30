package com.cysion.tdframework.img;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public class ImgExecutor {
    private static volatile ImgExecutor instance;

    private ImgExecutor() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized ImgExecutor getInstance() {
        if (instance == null) {
            instance = new ImgExecutor();
        }
        return instance;
    }

    /**
     * 初始化图片加载请求管理者
     *
     * @param aContext 上下文
     * @return request manager
     */
    public RequestManager init(Context aContext) {
        return Glide.with(aContext);
    }

    /**
     * 初始化图片加载请求管理者
     *
     * @param aFragment 图片依托的view附属的页面
     * @return request manager
     */
    public RequestManager init(Fragment aFragment) {
        return Glide.with(aFragment);
    }

    /**
     * 清除内存缓存，需要在主线程中才能执行
     *
     * @param aContext the a context
     */
    public void clearCache(Context aContext) {
        if (Thread.currentThread().getName().equals("main")) {
            Glide.get(aContext).clearMemory();
        }else{
            Toast.makeText(aContext, "需要在主线程中执行", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 清除磁盘缓存，需要在工作线程中.
     *
     * @param aContext the a context
     */
    public void clearDiskCache(final Context aContext) {
        if (!Thread.currentThread().getName().equals("main")) {
            Glide.get(aContext).clearDiskCache();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Glide.get(aContext).clearDiskCache();
                }
            }).start();
        }
    }
}

//Introduction for simple use of glide

/*    thumbnail(float sizeMultiplier). 请求给定系数的缩略图。如果缩略图比全尺寸图先加载完，就显示缩略图，否则就不显示。系数sizeMultiplier必须在(0,1)之间，可以递归调用该方法。
sizeMultiplier(float sizeMultiplier). 在加载资源之前给Target大小设置系数。
    diskCacheStrategy(DiskCacheStrategy strategy).设置缓存策略。DiskCacheStrategy.SOURCE：缓存原始数据，DiskCacheStrategy.RESULT：缓存变换后的资源数据，DiskCacheStrategy.NONE：什么都不缓存，DiskCacheStrategy.ALL：缓存SOURC和RESULT。默认采用DiskCacheStrategy.RESULT策略，对于download only操作要使用DiskCacheStrategy.SOURCE。
    priority(Priority priority). 指定加载的优先级，优先级越高越优先加载，但不保证所有图片都按序加载。枚举Priority.IMMEDIATE，Priority.HIGH，Priority.NORMAL，Priority.LOW。默认为Priority.NORMAL。
    dontAnimate(). 移除所有的动画。
    animate(int animationId). 在异步加载资源完成时会执行该动画。
    animate(ViewPropertyAnimation.Animator animator). 在异步加载资源完成时会执行该动画。
    placeholder(int resourceId). 设置资源加载过程中的占位Drawable。
    placeholder(Drawable drawable). 设置资源加载过程中的占位Drawable。
    fallback(int resourceId). 设置model为空时要显示的Drawable。如果没设置fallback，model为空时将显示error的Drawable，如果error的Drawable也没设置，就显示placeholder的Drawable。
    fallback(Drawable drawable).设置model为空时显示的Drawable。
    error(int resourceId).设置load失败时显示的Drawable。
    error(Drawable drawable).设置load失败时显示的Drawable。
    listener(RequestListener<? super ModelType, TranscodeType> requestListener). 监听资源加载的请求状态，可以使用两个回调：onResourceReady(R resource, T model, Target<R> target, boolean isFromMemoryCache, boolean isFirstResource)和onException(Exception e, T model, Target&lt;R&gt; target, boolean isFirstResource)，但不要每次请求都使用新的监听器，要避免不必要的内存申请，可以使用单例进行统一的异常监听和处理。
    skipMemoryCache(boolean skip). 设置是否跳过内存缓存，但不保证一定不被缓存（比如请求已经在加载资源且没设置跳过内存缓存，这个资源就会被缓存在内存中）。
    override(int width, int height). 重新设置Target的宽高值（单位为pixel）。
    into(Y target).设置资源将被加载到的Target。
    into(ImageView view). 设置资源将被加载到的ImageView。取消该ImageView之前所有的加载并释放资源。
    into(int width, int height). 后台线程加载时要加载资源的宽高值（单位为pixel）。
    preload(int width, int height). 预加载resource到缓存中（单位为pixel）。
    asBitmap(). 无论资源是不是gif动画，都作为Bitmap对待。如果是gif动画会停在第一帧。
    asGif().把资源作为GifDrawable对待。如果资源不是gif动画将会失败，会回调.error()。*/
