package com.wwi.worldwide_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout background;
    ImageButton[] country;
    ImageButton openInfo;
    ImageView map;
    int infoNum = 0;
    Boolean[] checkCountry;

//    0 = 일본 | 1 = 한국 | 2 = 중국 | 3 = 인도 | 4 = 러시아
//    5 = 이집트 | 6 = 이탈리아 | 7 = 프랑스 | 8 = 칠레 | 9 = 미국
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doFullScreen();
        setContentView(R.layout.activity_main);
        init();
        selectCountry();

    }


    private void doFullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                        View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION );
    }

    public void selectCountry() {
        for (int i = 0; i < 10; i ++) {
            int nowNum = i;
            country[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    infoNum = nowNum;
                    if (checkCountry[nowNum] == false) {
                        checkCountry[nowNum] = true;
                        changeIcon(infoNum);
                    } else {
                        checkCountry[nowNum] = false;
                        resetIcon();
                    }
                }
            });
        }
    }

    public void changeIcon(int infoNum) {
        for (int i = 0; i < 10; i++) {
            if (i == infoNum) {
                switch (infoNum) {
                    case 0: country[i].setImageResource(R.drawable.ic_col_japan);break;
                    case 1: country[i].setImageResource(R.drawable.ic_col_korea);break;
                    case 2: country[i].setImageResource(R.drawable.ic_col_china);break;
                    case 3: country[i].setImageResource(R.drawable.ic_col_india);break;
                    case 4: country[i].setImageResource(R.drawable.ic_col_russia);break;
                    case 5: country[i].setImageResource(R.drawable.ic_col_egypt);break;
                    case 6: country[i].setImageResource(R.drawable.ic_col_italia);break;
                    case 7: country[i].setImageResource(R.drawable.ic_col_france);break;
                    case 8: country[i].setImageResource(R.drawable.ic_col_chile);break;
                    case 9: country[i].setImageResource(R.drawable.ic_col_usa);break;
                }
            } else {
                switch (i) {
                    case 0: country[i].setImageResource(R.drawable.ic_blur_japan);break;
                    case 1: country[i].setImageResource(R.drawable.ic_blur_korea);break;
                    case 2: country[i].setImageResource(R.drawable.ic_blur_china);break;
                    case 3: country[i].setImageResource(R.drawable.ic_blur_india);break;
                    case 4: country[i].setImageResource(R.drawable.ic_blur_russia);break;
                    case 5: country[i].setImageResource(R.drawable.ic_blur_egypt);break;
                    case 6: country[i].setImageResource(R.drawable.ic_blur_italia);break;
                    case 7: country[i].setImageResource(R.drawable.ic_blur_france);break;
                    case 8: country[i].setImageResource(R.drawable.ic_blur_chile);break;
                    case 9: country[i].setImageResource(R.drawable.ic_blur_usa);break;
                }
            }
        }
        background.setBackgroundColor(Color.parseColor("#005151"));
        map.setImageResource(R.drawable.map_demo_dark);
    }

    public void resetIcon() {
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0: country[i].setImageResource(R.drawable.ic_def_japan);break;
                case 1: country[i].setImageResource(R.drawable.ic_def_korea);break;
                case 2: country[i].setImageResource(R.drawable.ic_def_china);break;
                case 3: country[i].setImageResource(R.drawable.ic_def_india);break;
                case 4: country[i].setImageResource(R.drawable.ic_def_russia);break;
                case 5: country[i].setImageResource(R.drawable.ic_def_egypt);break;
                case 6: country[i].setImageResource(R.drawable.ic_def_italia);break;
                case 7: country[i].setImageResource(R.drawable.ic_def_france);break;
                case 8: country[i].setImageResource(R.drawable.ic_def_chile);break;
                case 9: country[i].setImageResource(R.drawable.ic_def_usa);break;
            }
        }
        map.setImageResource(R.drawable.map_demo);
        background.setBackgroundColor(Color.parseColor("#008080"));
    }

    public void init() {
        country = new ImageButton[10];
        checkCountry = new Boolean[] {false, false, false, false, false, false, false, false, false, false};
        background = (ConstraintLayout) findViewById(R.id.background);
        map = (ImageView) findViewById(R.id.map);
        openInfo = (ImageButton) findViewById(R.id.open_info);
        country[0] = (ImageButton) findViewById(R.id.btn_japan);
        country[1] = (ImageButton) findViewById(R.id.btn_korea);
        country[2] = (ImageButton) findViewById(R.id.btn_china);
        country[3] = (ImageButton) findViewById(R.id.btn_india);
        country[4] = (ImageButton) findViewById(R.id.btn_russia);
        country[5] = (ImageButton) findViewById(R.id.btn_egypt);
        country[6] = (ImageButton) findViewById(R.id.btn_Italia);
        country[7] = (ImageButton) findViewById(R.id.btn_france);
        country[8] = (ImageButton) findViewById(R.id.btn_chile);
        country[9] = (ImageButton) findViewById(R.id.btn_usa);
    }


}
