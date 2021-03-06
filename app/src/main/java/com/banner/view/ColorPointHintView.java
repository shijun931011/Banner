package com.banner.view;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import com.banner.until.SizeUtil;

/**
 * @Description: color
 * @author: shijun on 2018/4/12 14:32.
 */

public class ColorPointHintView extends ShapeHintView {
    private int focusColor;
    private int normalColor;

    public ColorPointHintView(Context context, int focusColor, int normalColor) {
        super(context);
        this.focusColor = focusColor;
        this.normalColor = normalColor;
    }

    @Override
    public Drawable makeFocusDrawable() {
        GradientDrawable dotFocus = new GradientDrawable();
        dotFocus.setColor(focusColor);
        dotFocus.setCornerRadius(SizeUtil.dip2px(getContext(), 4));
        dotFocus.setSize(SizeUtil.dip2px(getContext(), 8), SizeUtil.dip2px(getContext(), 8));
        return dotFocus;
    }

    @Override
    public Drawable makeNormalDrawable() {
        GradientDrawable dotNormal = new GradientDrawable();
        dotNormal.setColor(normalColor);
        dotNormal.setCornerRadius(SizeUtil.dip2px(getContext(), 4));
        dotNormal.setSize(SizeUtil.dip2px(getContext(), 8), SizeUtil.dip2px(getContext(), 8));
        return dotNormal;
    }

}
