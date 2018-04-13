package com.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.banner.adapter.AbsDynamicPagerAdapter;
import com.banner.view.BannerView;
import com.banner.view.OnBannerClickListener;
import com.banner.view.OnPageListener;

/**
 * Created by shijun on ${date}
 */
public class FirstActivity extends AppCompatActivity {

    private int[] imgs={
            R.drawable.bg_kites_min,
            R.drawable.bg_autumn_tree_min,
            R.drawable.bg_lake_min,
            R.drawable.bg_leaves_min,
            R.drawable.bg_magnolia_trees_min,
    };


    private BannerView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initBanner();
    }

    private void initBanner(){
        banner = (BannerView) findViewById(R.id.banner);
        banner.setPlayDelay(2000);
        banner.setAdapter(new ImageNormalAdapter());
        banner.setHintGravity(1);
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(FirstActivity.this,position+"被点击呢", Toast.LENGTH_SHORT).show();
            }
        });

        banner.setOnPageListener(new OnPageListener() {
            @Override
            public void onPageChange(int position) {

            }
        });
    }

    private class ImageNormalAdapter extends AbsDynamicPagerAdapter {

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



}
