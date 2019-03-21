package com.example.rpereira.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager.OnPageChangeListener listener = null;

    private CustomPagerAdapter customPagerAdapter = null;

    private ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.idviewPagerMain);

        listener = new ViewPager.OnPageChangeListener() {

            private int jumpPosition = -1;

            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels) {
                //We do nothing here.
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    //prepare to jump to the last page
                    jumpPosition = customPagerAdapter.getRealCount();

                    //TODO: indicator.setActive(adapter.getRealCount() - 1)
                } else if (position == customPagerAdapter.getRealCount() + 1) {
                    //prepare to jump to the first page
                    jumpPosition = 1;

                    //TODO: indicator.setActive(0)
                } else {
                    //TODO: indicator.setActive(position - 1)
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Let's wait for the animation to be completed then do the jump (if we do this in
                //onPageSelected(int position) scroll animation will be canceled).
                if (state == ViewPager.SCROLL_STATE_IDLE && jumpPosition >= 0) {
                    //Jump without animation so the user is not aware what happened.
                    viewPager.setCurrentItem(jumpPosition, false);
                    //Reset jump position.
                    jumpPosition = -1;
                }
            }
        };

        viewPager.addOnPageChangeListener(listener);
        customPagerAdapter = new CustomPagerAdapter(this);
        viewPager.setAdapter(customPagerAdapter);
        viewPager.setCurrentItem(1, false);

    }
}
