package com.wwi.worldwide_info;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class FirstActivity extends AppCompatActivity {

    ConstraintLayout startView;
    TextView tv_anim;
    Animation anim;
    Boolean isPhone = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Worldwide_info);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setOrientation();
        startView = (ConstraintLayout) findViewById(R.id.startView);
        tv_anim = (TextView) findViewById(R.id.TV_anim);
        startMain();
        textAnim();
    }

    //폰인지 여부
    public void IsPhone() {
        //화면 사이즈 종류 구하기
        int screenSizeType = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        if(screenSizeType== Configuration.SCREENLAYOUT_SIZE_NORMAL || screenSizeType==Configuration.SCREENLAYOUT_SIZE_SMALL){
            isPhone = true;
        }
        isPhone = false;
    }

    void setOrientation() {
        IsPhone();
        if (isPhone){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    void startMain() {
        startView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                tv_anim.clearAnimation();
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
    }

    void textAnim() {
        anim = new AlphaAnimation(0.2f,1.0f);
        anim.setDuration(600);
        anim.setStartOffset(50);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        tv_anim.startAnimation(anim);
    }
}
