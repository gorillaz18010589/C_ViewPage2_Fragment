package android.rockchip.c_viewpage2_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPage2 = findViewById(R.id.viewPage2);
        initViewPage();
    }

    private void initViewPage() {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), getLifecycle());
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f + r *0.15f );
//                Log.v("hank","transformPage(View page, float position):" + "postition:" + position);
            }
        });
        viewPage2.setPageTransformer(compositePageTransformer);
        viewPage2.setOffscreenPageLimit(1);
        viewPage2.setAdapter(viewPageAdapter);


    }
}