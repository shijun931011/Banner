package com.banner;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.banner.adapter.AbsStaticPagerAdapter;
import com.banner.until.SizeUtil;
import com.banner.view.BannerView;
import com.banner.view.OnBannerClickListener;

/**
 * Created by shijun on ${date}
 */
public class SecondActivity extends AppCompatActivity {
    private int[] imgs = {
            R.drawable.bg_kites_min,
            R.drawable.bg_autumn_tree_min,
            R.drawable.bg_lake_min,
            R.drawable.bg_leaves_min,
            R.drawable.bg_magnolia_trees_min,
    };
    private BannerView banner;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(banner!=null){
            banner.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(banner!=null){
            banner.resume();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initBanner();
    }

    private void initBanner() {
        banner = (BannerView) findViewById(R.id.banner);
        banner.setAdapter(new ImageNormalAdapter());
        banner.setHintGravity(1);
        banner.setHintPadding(SizeUtil.dip2px(this,10),0,
                SizeUtil.dip2px(this,10),SizeUtil.dip2px(this,10));
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(SecondActivity.this,position+"被点击呢",Toast.LENGTH_SHORT).show();
            }
        });
    }


    private class ImageNormalAdapter extends AbsStaticPagerAdapter {
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setImageResource(imgs[position]);
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
