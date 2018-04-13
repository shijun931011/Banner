package com.banner.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * @Description: 文本
 * @author: shijun on 2018/4/12 14:34.
 */

public class TextHintView extends AppCompatTextView implements BaseHintView {
    private int length;
    public TextHintView(Context context){
        super(context);
    }

    public TextHintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initView(int length, int gravity) {
        this.length = length;
        setTextColor(Color.WHITE);
        switch (gravity) {
            case 0:
                setGravity(Gravity.START| Gravity.CENTER_VERTICAL);
                break;
            case 1:
                setGravity(Gravity.CENTER);
                break;
            case 2:
                setGravity(Gravity.END| Gravity.CENTER_VERTICAL);
                break;
            default:
                break;
        }

        setCurrent(0);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setCurrent(int current) {
        setText(current+1+"/"+ length);
    }
}
