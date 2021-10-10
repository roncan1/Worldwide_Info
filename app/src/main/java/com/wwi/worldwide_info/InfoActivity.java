package com.wwi.worldwide_info;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import tyrantgit.explosionfield.ExplosionField;

public class InfoActivity extends AppCompatActivity {

    ExplosionField explosionField;
    ImageButton btn_end_info;
    ConstraintLayout thisActivity;
    ImageView info_img1, info_img2, info_img3, info_title;
    TextView TV_info_description_kr, TV_info_description_eng;
    String[] info_description_kr, info_description_eng;
    Intent intent;
    int country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.vertical_in, R.anim.none);
        setContentView(R.layout.activity_info);
        init();
        descriptionInit();
        doFullScreen();
        endInfoActivity();
        infoSet(country);

    }

    void infoSet(int country) {
        switch (country) {
            case 0: info_title.setImageResource(R.drawable.info_title_japan);break;
            case 1: info_title.setImageResource(R.drawable.info_title_korea);break;
            case 2: info_title.setImageResource(R.drawable.info_title_china);break;
            case 3: info_title.setImageResource(R.drawable.info_title_india);break;
            case 4: info_title.setImageResource(R.drawable.info_title_russia);break;
            case 5: info_title.setImageResource(R.drawable.info_title_egypt);break;
            case 6: info_title.setImageResource(R.drawable.info_title_itary);break;
            case 7: info_title.setImageResource(R.drawable.info_title_france);break;
            case 8: info_title.setImageResource(R.drawable.info_title_chile);break;
            case 9: info_title.setImageResource(R.drawable.info_title_usa);break;
        }
        TV_info_description_kr.setText(info_description_kr[country]);
        TV_info_description_eng.setText(info_description_eng[country]);
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

        TV_info_description_kr = (TextView) findViewById(R.id.info_text_kr);
        TV_info_description_eng = (TextView) findViewById(R.id.info_text_eng);

        info_description_kr = new String[10];
        info_description_eng = new String[10];

        info_title = (ImageView) findViewById(R.id.info_tltle);
        info_img1 = (ImageView) findViewById(R.id.info_image1);
        info_img2 = (ImageView) findViewById(R.id.info_image2);
        info_img3 = (ImageView) findViewById(R.id.info_image3);

        info_img1.setClipToOutline(true);
        info_img2.setClipToOutline(true);
        info_img3.setClipToOutline(true);

        intent = getIntent();
        country = intent.getIntExtra("country", 0);
    }

    void descriptionInit() {
//        한글 설명
        info_description_kr[0] = "일본국(日本国), 약칭 일본(日本)은 동아시아 태평양에\n있는 일본 열도의 네 개의 큰 섬과 이들 주변에 산재한\n작은 섬들로 구성되어 있는 나라이다.";
        info_description_kr[1] = "대한민국(大韓民國)은 동아시아의 한반도 남단에\n자리한 민주공화국이며\n1960년대부터 세계에서 가장 빠른 경제 성장을 이룬 국가";
        info_description_kr[2] = "중화인민공화국(中华人民共和国) 또는 중국(中国)\n동아시아 한반도 서쪽에 있는 나라로\n중국 공산당이 독재하는일당제 사회주의 국가이다.";
        info_description_kr[3] = "인도 공화국(भारत गणराज्य), 약칭 인도( भारत )는\n남아시아에 있는 나라로, 인도 아대륙의 거의 대부분을\n영토로 소유하고 있는 국가이다.";
        info_description_kr[4] = "러시아 연방(Росси́йская Федера́ция), \n약칭 러시아(Росси́я)는 동유럽과 북아시아에 걸쳐 있는\n연방제 국가이며 세계에서 가장 영토가 넓은 국가이다.";
        info_description_kr[5] = "이집트 아랍 공화국(جمهورية مصر العربية) 줄여서 이집트\n(مصر)는 북아프리카와 서아시아의 시나이 반도에 결쳐있는\n약 5000년의 유구한 역사를 지니고 있는 국가이다.";
        info_description_kr[6] = "이탈리아 공화국(Repubblica Italiana), 약칭 이탈리아(It\nalia)는 이탈리아반도와 지중해의 두 개의 섬으로 이루어진\n시칠리아 및 사르데냐로 이루어진 단일 의회 공화국이다.";
        info_description_kr[7] = "프랑스 공화국(République française) 약칭 프랑스(Fra\nnce)는 서유럽의 본토와 남아메리카의 프랑스령 기아나를\n비롯한 해외 레지옹과 해외 영토로 이루어진 국가이다.";
        info_description_kr[8] = "칠레 공화국(República de Chile), 줄여서 칠레(Chile)는\n태평양과 남아메리카의 안데스 산맥 사이에 남북으로\n긴 영토를 가진 나라이다.";
        info_description_kr[9] = "미합중국(United States of America, USA), 약칭 합중\n국(United States, U.S.) 또는 미국(美國) 은 주 50개와\n특별구 1개로 이루어진 연방제 공화국이다.";

//        영어 설명
        info_description_eng[0] = "Japan is a country made up of four large islands of the Ja\npanese archipelago in the East Asian Pacific Ocean and\nsmall islands scattered around them.";
        info_description_eng[1] = "Korea is a democratic republic located at the southern t\nip of the Korean Peninsula in East Asia.\nCountries with the fastest economic growth in the world\nsince the 1960s";
        info_description_eng[2] = "China is a one-party socialist country autographed by th\ne Chinese Communist Party as a country on the west\nside of the Korean Peninsula in East Asia.";
        info_description_eng[3] = "The Republic of India is a country in South Asia that own\ns most of the Indian subcontinent.";
        info_description_eng[4] = "Russia is a federal country that spans Eastern Europe\nand North Asia and is the largest country in the world.";
        info_description_eng[5] = "Egypt is a country with a long history of about\n5,000 years, spanning the Sinai Peninsula in North Africa\nand Western Asia.";
        info_description_eng[6] = "Italy is a unitary parliamentary republic consisting of Sic\nily and Sardinia, made up of the Italian Peninsula and tw\no islands in the Mediterranean Sea.";
        info_description_eng[7] = "France is a country made up of foreign legions and foreig\nn territories, including mainland Western Europe and Fr\nench Guiana in South America.";
        info_description_eng[8] = "Chile is a country that stretches from north to south bet\nween the Pacific Ocean and the Andes in South America.";
        info_description_eng[9] = "The United States of America, abbreviated to the United\nStates, is a federal republic consisting of 50 states and o\nne special district.";
    }



}
