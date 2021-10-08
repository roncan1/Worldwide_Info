package com.wwi.worldwide_info;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import tyrantgit.explosionfield.ExplosionField;

public class InfoActivity extends AppCompatActivity {

    ExplosionField explosionField;
    ImageButton btn_end_info;
    ConstraintLayout thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.vertical_in, R.anim.none);
        setContentView(R.layout.activity_info);
        init();
        doFullScreen();
        endInfoActivity();


    }


    void endInfoActivity() {
        btn_end_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explosionField.explode(btn_end_info);
                explosionField.explode(thisActivity);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    }
                }, 400);
            }
        });
    }

    private void doFullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                        View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION );
    }


    public void init() {
        btn_end_info = (ImageButton) findViewById(R.id.btn_end_info);
        explosionField = ExplosionField.attach2Window(this);
        thisActivity = (ConstraintLayout) findViewById(R.id.infoActivity);
    }
}
