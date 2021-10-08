package com.wwi.worldwide_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout background;
    ImageButton[] btn_country;
    ImageButton btn_open_info;
    ImageView map;
    int infoNum = 0;
    Boolean[] checkCountry;
    Animation info_open_anim;

    //    0 = 일본 | 1 = 한국 | 2 = 중국 | 3 = 인도 | 4 = 러시아
//    5 = 이집트 | 6 = 이탈리아 | 7 = 프랑스 | 8 = 칠레 | 9 = 미국
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doFullScreen();
        setContentView(R.layout.activity_main);
        init();
        selectCountry();
        openInfo(infoNum);

    }


    private void doFullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    public void selectCountry() {
        for (int i = 0; i < 10; i++) {
            int nowNum = i;
            btn_country[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    infoNum = nowNum;
                    if (checkCountry[nowNum] == false) {
                        checkCountry[nowNum] = true;
                        changeIcon(infoNum);
                        btn_open_info.setVisibility(View.VISIBLE);
                    } else {
                        checkCountry[nowNum] = false;
                        resetIcon();
                        btn_open_info.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    public void changeIcon(int infoNum) {
        for (int i = 0; i < 10; i++) {
            if (i == infoNum) {
                switch (infoNum) {
                    case 0:
                        btn_country[i].setImageResource(R.drawable.ic_col_japan);
                        break;
                    case 1:
                        btn_country[i].setImageResource(R.drawable.ic_col_korea);
                        break;
                    case 2:
                        btn_country[i].setImageResource(R.drawable.ic_col_china);
                        break;
                    case 3:
                        btn_country[i].setImageResource(R.drawable.ic_col_india);
                        break;
                    case 4:
                        btn_country[i].setImageResource(R.drawable.ic_col_russia);
                        break;
                    case 5:
                        btn_country[i].setImageResource(R.drawable.ic_col_egypt);
                        break;
                    case 6:
                        btn_country[i].setImageResource(R.drawable.ic_col_italia);
                        break;
                    case 7:
                        btn_country[i].setImageResource(R.drawable.ic_col_france);
                        break;
                    case 8:
                        btn_country[i].setImageResource(R.drawable.ic_col_chile);
                        break;
                    case 9:
                        btn_country[i].setImageResource(R.drawable.ic_col_usa);
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        btn_country[i].setImageResource(R.drawable.ic_blur_japan);
                        break;
                    case 1:
                        btn_country[i].setImageResource(R.drawable.ic_blur_korea);
                        break;
                    case 2:
                        btn_country[i].setImageResource(R.drawable.ic_blur_china);
                        break;
                    case 3:
                        btn_country[i].setImageResource(R.drawable.ic_blur_india);
                        break;
                    case 4:
                        btn_country[i].setImageResource(R.drawable.ic_blur_russia);
                        break;
                    case 5:
                        btn_country[i].setImageResource(R.drawable.ic_blur_egypt);
                        break;
                    case 6:
                        btn_country[i].setImageResource(R.drawable.ic_blur_italia);
                        break;
                    case 7:
                        btn_country[i].setImageResource(R.drawable.ic_blur_france);
                        break;
                    case 8:
                        btn_country[i].setImageResource(R.drawable.ic_blur_chile);
                        break;
                    case 9:
                        btn_country[i].setImageResource(R.drawable.ic_blur_usa);
                        break;
                }
            }
        }
        background.setBackgroundColor(Color.parseColor("#005151"));
        map.setImageResource(R.drawable.map_demo_dark);
    }

    public void openInfo(int country) {
        btn_open_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    btn_open_info.startAnimation(info_open_anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_open_info.setImageResource(R.drawable.open_info2);
                    }
                }, 300);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                        intent.putExtra("country", country);
                        startActivity(intent);
                    }
                }, 700);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_open_info.setImageResource(R.drawable.open_info);
                    }
                }, 2000);
            }
        });
    }

    public void resetIcon() {
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    btn_country[i].setImageResource(R.drawable.ic_def_japan);
                    break;
                case 1:
                    btn_country[i].setImageResource(R.drawable.ic_def_korea);
                    break;
                case 2:
                    btn_country[i].setImageResource(R.drawable.ic_def_china);
                    break;
                case 3:
                    btn_country[i].setImageResource(R.drawable.ic_def_india);
                    break;
                case 4:
                    btn_country[i].setImageResource(R.drawable.ic_def_russia);
                    break;
                case 5:
                    btn_country[i].setImageResource(R.drawable.ic_def_egypt);
                    break;
                case 6:
                    btn_country[i].setImageResource(R.drawable.ic_def_italia);
                    break;
                case 7:
                    btn_country[i].setImageResource(R.drawable.ic_def_france);
                    break;
                case 8:
                    btn_country[i].setImageResource(R.drawable.ic_def_chile);
                    break;
                case 9:
                    btn_country[i].setImageResource(R.drawable.ic_def_usa);
                    break;
            }
        }
        map.setImageResource(R.drawable.map_demo);
        background.setBackgroundColor(Color.parseColor("#008080"));
    }

    public void init() {
        btn_country = new ImageButton[10];
        checkCountry = new Boolean[]{false, false, false, false, false, false, false, false, false, false};
        background = (ConstraintLayout) findViewById(R.id.background);
        map = (ImageView) findViewById(R.id.map);
        info_open_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_info);
        btn_open_info = (ImageButton) findViewById(R.id.open_info);
        btn_country[0] = (ImageButton) findViewById(R.id.btn_japan);
        btn_country[1] = (ImageButton) findViewById(R.id.btn_korea);
        btn_country[2] = (ImageButton) findViewById(R.id.btn_china);
        btn_country[3] = (ImageButton) findViewById(R.id.btn_india);
        btn_country[4] = (ImageButton) findViewById(R.id.btn_russia);
        btn_country[5] = (ImageButton) findViewById(R.id.btn_egypt);
        btn_country[6] = (ImageButton) findViewById(R.id.btn_Italia);
        btn_country[7] = (ImageButton) findViewById(R.id.btn_france);
        btn_country[8] = (ImageButton) findViewById(R.id.btn_chile);
        btn_country[9] = (ImageButton) findViewById(R.id.btn_usa);
    }


}
