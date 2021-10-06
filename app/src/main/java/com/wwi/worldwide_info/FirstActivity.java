package com.wwi.worldwide_info;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Worldwide_info);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        startView = (ConstraintLayout) findViewById(R.id.startView);
        tv_anim = (TextView) findViewById(R.id.TV_anim);
        startMain();
        textAnim();
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
