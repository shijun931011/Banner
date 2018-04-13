package com.banner;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.banner.adapter.AbsDynamicPagerAdapter;
import com.banner.until.SizeUtil;
import com.banner.view.BannerView;
import com.banner.view.OnBannerClickListener;
import com.banner.view.OnPageListener;

/**
 * Created by shijun on 启动页
 */
public class SplashActivity extends AppCompatActivity {

    private int[] imgs = {
            R.drawable.bg_kites_min,
            R.drawable.bg_autumn_tree_min,
            R.drawable.bg_lake_min,
            R.drawable.bg_leaves_min,
            R.drawable.bg_magnolia_trees_min,
    };
    private BannerView banner;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initBanner();
        initListener();
    }

    private void initListener() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
    }


    private void initBanner() {
        banner = (BannerView) findViewById(R.id.banner);
        banner.setPlayDelay(0);
        banner.setAdapter(new ImageNormalAdapter());
        banner.setHintGravity(1);
        banner.setHintPadding(SizeUtil.dip2px(this,10),0,
                SizeUtil.dip2px(this,10),SizeUtil.dip2px(this,30));
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        banner.setOnPageListener(new OnPageListener() {
            @Override
            public void onPageChange(int position) {
                if(position==imgs.length-1){
                    btn.setVisibility(View.VISIBLE);
                }else {
                    btn.setVisibility(View.GONE);
                }
            }
        });
    }



    private class ImageNormalAdapter extends AbsDynamicPagerAdapter {

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            view.setImageResource(imgs[position]);
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
