package edu.scse.nehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.*;
import android.widget.ImageView;

/**
 * Created by 曹远招 on 2017/5/18.
 */

public class StartActivity extends Activity {
    private ImageView welcomeImg=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_start);
        welcomeImg = (ImageView) findViewById(R.id.welcome_img);
        AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
        anima.setDuration(5000);
        welcomeImg.startAnimation(anima);
        anima.setAnimationListener(new AnimationImpl());
    }
    private class AnimationImpl implements Animation.AnimationListener
    {
        @Override
        public void onAnimationStart(Animation animation) {
            welcomeImg.setBackgroundResource(R.drawable.welcome);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            skip();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
    private void skip()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
