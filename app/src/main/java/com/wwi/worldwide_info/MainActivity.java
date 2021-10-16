package com.wwi.worldwide_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
    int infoNum = 10;
    int[] back_img = null;
    Boolean[] checkCountry;
    Boolean selectCountry = false;
    Animation info_open_anim, ic_on_anim, ic_off_anim, ic_none_anim, none_anim, fadeIn_anim, fadeOut_anim;

    //    0 = 일본 | 1 = 한국 | 2 = 중국 | 3 = 인도 | 4 = 러시아 | 5 = 이집트 | 6 = 이탈리아 | 7 = 프랑스 | 8 = 칠레 | 9 = 미국
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doFullScreen(); //전체화면
        setContentView(R.layout.activity_main);
        init();
        selectCountry(); // 국가 선택
        openInfo(); // 인포화면 전환
    }

    @Override
    protected void onResume() {
        super.onResume();
        doFullScreen();
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
            int nowNum = i; // 현재 선택된 국가
            btn_country[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int beforeNum = infoNum; // 이전에 선택된 국가
                    infoNum = nowNum; //현재 선택된 국가를 인포넘에 넣어줌
                    if (checkCountry[nowNum] == false) { // 현재 선택된 국가가 비활성화일때
                        checkCountry[nowNum] = true; // 현재 국가가 활성화되어있다고 설정
                        changeIcon(infoNum); // 국가 아이콘 변경
                        changeMap(infoNum);  // 맵 이미지 변경
                        btn_open_info.setVisibility(View.VISIBLE); // 인포화면 전환 버튼 보이게 표시
                        checkCountry[beforeNum] = false; // 이전에 선택되었던 버튼 비활성화로 변경
                        selectCountry = true;
                        Log.d("before", "현재 : " + beforeNum);
                    } else { // 현재 선택된 국가가 활성화일때
                        checkCountry[nowNum] = false; // 현재 국가가 활성화되어있지 않다고 설정
                        resetIcon(); // 아이콘과 맵 초기화
                        infoNum = 10; // beforeNum이 이상한 값을 잡지 않도록 infoNum을 10으로 설정
                        btn_open_info.setVisibility(View.GONE); // 인포화면 버튼을 비활성화
                        selectCountry = false;
                        Log.d("before", "현재 : " + beforeNum);
                    }
                }
            });
        }
    }

    public void changeIcon(int infoNum) { // 선택된 국가의 이미지를 컬러로 바꾸고 나머지 국가를 블러처리
        for (int i = 0; i < 10; i++) {
            if (i == infoNum) {
                btn_country[infoNum].startAnimation(ic_on_anim);
                switch (infoNum) {
                    case 0: btn_country[i].setImageResource(R.drawable.ic_col_japan);break;
                    case 1: btn_country[i].setImageResource(R.drawable.ic_col_korea);break;
                    case 2: btn_country[i].setImageResource(R.drawable.ic_col_china);break;
                    case 3: btn_country[i].setImageResource(R.drawable.ic_col_india);break;
                    case 4: btn_country[i].setImageResource(R.drawable.ic_col_russia);break;
                    case 5: btn_country[i].setImageResource(R.drawable.ic_col_egypt);break;
                    case 6: btn_country[i].setImageResource(R.drawable.ic_col_italia);break;
                    case 7: btn_country[i].setImageResource(R.drawable.ic_col_france);break;
                    case 8: btn_country[i].setImageResource(R.drawable.ic_col_chile);break;
                    case 9: btn_country[i].setImageResource(R.drawable.ic_col_usa);break;
                }
            } else {
                if (selectCountry == true) btn_country[i].startAnimation(ic_none_anim);
                if (selectCountry == false) btn_country[i].startAnimation(ic_off_anim);
                switch (i) {
                    case 0: btn_country[i].setImageResource(R.drawable.ic_blur_japan);break;
                    case 1: btn_country[i].setImageResource(R.drawable.ic_blur_korea);break;
                    case 2: btn_country[i].setImageResource(R.drawable.ic_blur_china);break;
                    case 3: btn_country[i].setImageResource(R.drawable.ic_blur_india);break;
                    case 4: btn_country[i].setImageResource(R.drawable.ic_blur_russia);break;
                    case 5: btn_country[i].setImageResource(R.drawable.ic_blur_egypt);break;
                    case 6: btn_country[i].setImageResource(R.drawable.ic_blur_italia);break;
                    case 7: btn_country[i].setImageResource(R.drawable.ic_blur_france);break;
                    case 8: btn_country[i].setImageResource(R.drawable.ic_blur_chile);break;
                    case 9: btn_country[i].setImageResource(R.drawable.ic_blur_usa);break;
                }
            }
        }
    }

    public void changeMap(int infoNum) { // 맵 이미지를 변경 (다크테마)
        background.setBackgroundColor(Color.parseColor("#195555"));
        map.startAnimation(fadeOut_anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                map.setImageResource(back_img[infoNum]);
                map.startAnimation(fadeIn_anim);
            }
        }, 150);
    }

    public void openInfo() { // 현재 선택된 국가가 어디인지를 담아서 화면전환
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
                        intent.putExtra("country", infoNum);
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

    public void resetIcon() { // 아이콘과 맵을 초기화
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0: btn_country[i].setImageResource(R.drawable.ic_def_japan);break;
                case 1: btn_country[i].setImageResource(R.drawable.ic_def_korea);break;
                case 2: btn_country[i].setImageResource(R.drawable.ic_def_china);break;
                case 3: btn_country[i].setImageResource(R.drawable.ic_def_india);break;
                case 4: btn_country[i].setImageResource(R.drawable.ic_def_russia);break;
                case 5: btn_country[i].setImageResource(R.drawable.ic_def_egypt);break;
                case 6: btn_country[i].setImageResource(R.drawable.ic_def_italia);break;
                case 7: btn_country[i].setImageResource(R.drawable.ic_def_france);break;
                case 8: btn_country[i].setImageResource(R.drawable.ic_def_chile);break;
                case 9: btn_country[i].setImageResource(R.drawable.ic_def_usa);break;
            }
            btn_country[i].startAnimation(none_anim);
        }
        map.setImageResource(R.drawable.map);
        background.setBackgroundColor(Color.parseColor("#008080"));
    }

    public void init() {
        btn_country = new ImageButton[10];
        checkCountry = new Boolean[]{false, false, false, false, false, false, false, false, false, false, false};
        background = (ConstraintLayout) findViewById(R.id.background);
        map = (ImageView) findViewById(R.id.map);
        info_open_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_info);
        ic_on_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ic_on);
        ic_off_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ic_off);
        ic_none_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ic_none);
        none_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.none);
        fadeIn_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeOut_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
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

        back_img = new int[] {
                R.drawable.map_japan,
                R.drawable.map_korea,
                R.drawable.map_china,
                R.drawable.map_india,
                R.drawable.map_russia,
                R.drawable.map_egypt,
                R.drawable.map_italy,
                R.drawable.map_frence,
                R.drawable.map_chile,
                R.drawable.map_usa,
        };
    }


}
