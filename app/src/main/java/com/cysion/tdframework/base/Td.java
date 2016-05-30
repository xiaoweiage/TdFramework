package com.cysion.tdframework.base;

import android.content.Context;

import com.cysion.tdframework.img.ImgExecutor;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public class Td {
    /**
     * Td is short of this;
     */
    private static final String TASK_DISPATCHER = "name";


    /**
     * Init.
     *
     * @param aContext the a context
     */
    public static void init(Context aContext){
        CrashHandler.getInstance().init(aContext);
    }

    public static ImgExecutor getImgExecutor(){
        return ImgExecutor.getInstance();
    }
}
