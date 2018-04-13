package com.banner.until;

import android.content.Context;

/**
 * @Description: 工具类
 * @author: shijun on 2018/4/12 14:28.
 */

public class SizeUtil {
    public static int dip2px(Context ctx, float dpValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context ctx, float pxValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
