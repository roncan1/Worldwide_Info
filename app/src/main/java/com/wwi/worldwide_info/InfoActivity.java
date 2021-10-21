package com.wwi.worldwide_info;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shashank.sony.fancytoastlib.FancyToast;

import tyrantgit.explosionfield.ExplosionField;

public class InfoActivity extends AppCompatActivity {

    InfoActivity infoActivity;
    ImgDescription imgD;
    infoDialog infoDialog;

    ExplosionField explosionField;
    ConstraintLayout thisActivity;

    TextView TV_info_description_kr, TV_info_description_eng, TV_covid;
    WebView web_covid;
    WebSettings webSettings;
    ImageView info_img1, info_img2, info_img3, info_title;
    FloatingActionButton fab_main, fab_back, fab_covid;
    Intent intent;
    Animation fab_open, fab_close, fab_main_open, fab_main_close, fade_out, fade_in;

    String[] info_description_kr, info_description_eng, web_url;
    int country;
    Boolean isFabOpen = false, isInfoOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.vertical_in, R.anim.none);
        doFullScreen();
        setContentView(R.layout.activity_info);
        init();
        descriptionInit();
        infoSet(country);
        imageOpen(country);
        setPab();
        setCovidWeb(country);
        showToast();
    }

    void showToast() {
        FancyToast.makeText(this,"사진을 터치하여 추가 정보를 확인",FancyToast.LENGTH_SHORT, FancyToast.INFO,false).show();
    }

    void setPab() {
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFab();
            }
        });

        fab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFab();
                endInfoActivity();
            }
        });

        fab_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleInfoCovid();
                toggleFab();
                toggleFabIcon();
            }
        });
    }

    void toggleInfoCovid() {
        if (isInfoOpen) {
            TV_info_description_kr.startAnimation(fade_out);
            TV_info_description_eng.startAnimation(fade_out);
            info_img1.startAnimation(fade_out);
            info_img2.startAnimation(fade_out);
            info_img3.startAnimation(fade_out);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    TV_info_description_kr.setVisibility(View.GONE);
                    TV_info_description_eng.setVisibility(View.GONE);
                    info_img1.setVisibility(View.GONE);
                    info_img2.setVisibility(View.GONE);
                    info_img3.setVisibility(View.GONE);

                    TV_covid.startAnimation(fade_in);
                    web_covid.startAnimation(fade_in);
                    TV_covid.setVisibility(View.VISIBLE);
                    web_covid.setVisibility(View.VISIBLE);
                }
            }, 150);

        } else {
            TV_covid.startAnimation(fade_out);
            web_covid.startAnimation(fade_out);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    TV_covid.setVisibility(View.GONE);
                    web_covid.setVisibility(View.GONE);
                    TV_info_description_kr.startAnimation(fade_in);
                    TV_info_description_eng.startAnimation(fade_in);
                    info_img1.startAnimation(fade_in);
                    info_img2.startAnimation(fade_in);
                    info_img3.startAnimation(fade_in);

                    TV_info_description_kr.setVisibility(View.VISIBLE);
                    TV_info_description_eng.setVisibility(View.VISIBLE);
                    info_img1.setVisibility(View.VISIBLE);
                    info_img2.setVisibility(View.VISIBLE);
                    info_img3.setVisibility(View.VISIBLE);
                }
            }, 150);
        }
    }

    void setCovidWeb(int country) {
        web_covid.setWebViewClient(new WebViewClient());
        webSettings = web_covid.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportMultipleWindows(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        web_covid.loadUrl(web_url[country]);
    }

    void toggleFab() {
        if (isFabOpen) {
            fab_main.startAnimation(fab_main_close);
            fab_back.startAnimation(fab_close);
            fab_covid.startAnimation(fab_close);
            fab_back.setClickable(false);
            fab_covid.setClickable(false);
            isFabOpen = false;
            Log.d("fab", "toggleFab: 1");
        } else {
            fab_main.startAnimation(fab_main_open);
            fab_back.startAnimation(fab_open);
            fab_covid.startAnimation(fab_open);
            fab_back.setClickable(true);
            fab_covid.setClickable(true);
            isFabOpen = true;
            Log.d("fab", "toggleFab: 0");
        }
    }

    void toggleFabIcon() {
        if (isInfoOpen) {
            fab_covid.setImageResource(R.drawable.ic_virus);
            isInfoOpen = false;
        } else {
            fab_covid.setImageResource(R.drawable.ic_info);
            isInfoOpen = true;
        }
    }

    void imageOpen(int country) {
        info_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoDialog.callFunction(country, 0);
            }
        });
        info_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoDialog.callFunction(country, 1);
            }
        });
        info_img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoDialog.callFunction(country, 2);
            }
        });
    }

    void infoSet(int country) {
//       나라 타이틀 이미지
        switch (country) {
            case 0:
                info_title.setImageResource(R.drawable.info_title_japan);
                break;
            case 1:
                info_title.setImageResource(R.drawable.info_title_korea);
                break;
            case 2:
                info_title.setImageResource(R.drawable.info_title_china);
                break;
            case 3:
                info_title.setImageResource(R.drawable.info_title_india);
                break;
            case 4:
                info_title.setImageResource(R.drawable.info_title_russia);
                break;
            case 5:
                info_title.setImageResource(R.drawable.info_title_egypt);
                break;
            case 6:
                info_title.setImageResource(R.drawable.info_title_itary);
                break;
            case 7:
                info_title.setImageResource(R.drawable.info_title_france);
                break;
            case 8:
                info_title.setImageResource(R.drawable.info_title_chile);
                break;
            case 9:
                info_title.setImageResource(R.drawable.info_title_usa);
                break;
        }
//        나라 설명 세팅
        TV_info_description_kr.setText(info_description_kr[country]);
        TV_info_description_eng.setText(info_description_eng[country]);

//        하위 이미지 세팅
        infoImgSet(country);
    }

    void infoImgSet(int country) {
        info_img1.setImageResource(imgD.images[country][0]);
        info_img2.setImageResource(imgD.images[country][1]);
        info_img3.setImageResource(imgD.images[country][2]);
    }

    void endInfoActivity() {
        if (isInfoOpen) {
            explosionField.explode(thisActivity);
            explosionField.explode(info_title);
            explosionField.explode(info_img1);
            explosionField.explode(info_img2);
            explosionField.explode(info_img3);
        } else {
            explosionField.explode(web_covid);
            explosionField.explode(TV_covid);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, 400);
    }

    private void doFullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void init() {
        infoActivity = new InfoActivity();
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_main_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_main_open);
        fab_main_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_main_close);
        fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        fab_main = (FloatingActionButton) findViewById(R.id.fab_main);
        fab_back = (FloatingActionButton) findViewById(R.id.fab_sub1);
        fab_covid = (FloatingActionButton) findViewById(R.id.fab_sub2);

        TV_covid = (TextView) findViewById(R.id.covid_text);
        web_covid = (WebView) findViewById(R.id.covid_web);
        web_covid.setClipToOutline(true);
        web_url = new String[]{
                "https://www.worldometers.info/coronavirus/country/japan/",
                "https://www.worldometers.info/coronavirus/country/south-korea/",
                "https://www.worldometers.info/coronavirus/country/china/",
                "https://www.worldometers.info/coronavirus/country/india/",
                "https://www.worldometers.info/coronavirus/country/russia/",
                "https://www.worldometers.info/coronavirus/country/egypt/",
                "https://www.worldometers.info/coronavirus/country/italy/",
                "https://www.worldometers.info/coronavirus/country/france/",
                "https://www.worldometers.info/coronavirus/country/chile/",
                "https://www.worldometers.info/coronavirus/country/us/"
        };

        imgD = new ImgDescription();
        infoDialog = new infoDialog(InfoActivity.this);

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
        info_description_kr[0] = "일본국(日本国), 약칭 일본(日本)은 동아시아 태평양에 있는 일본 열도의 네 개의 큰 섬과 이들 주변에 산재한 작은 섬들로 구성되어 있는 나라이다.";
        info_description_kr[1] = "대한민국(大韓民國)은 동아시아의 한반도 남단에 자리한 민주공화국이며 1960년대부터 세계에서 가장 빠른 경제 성장을 이룬 국가";
        info_description_kr[2] = "중화인민공화국(中华人民共和国) 또는 중국(中国) 동아시아 한반도 서쪽에 있는 나라로 중국 공산당이 독재하는일당제 사회주의 국가이다.";
        info_description_kr[3] = "인도 공화국(भारत गणराज्य), 약칭 인도( भारत )는 남아시아에 있는 나라로, 인도 아대륙의 거의 대부분을 영토로 소유하고 있는 국가이다.";
        info_description_kr[4] = "러시아 연방(Росси́йская Федера́ция), 약칭 러시아(Росси́я)는 동유럽과 북아시아에 걸쳐 있는 연방제 국가이며 세계에서 가장 영토가 넓은 국가이다.";
        info_description_kr[5] = "이집트 아랍 공화국(جمهورية مصر العربية) 줄여서 이집트는 북아프리카와 서아시아의 시나이 반도에 결쳐있는 약 5000년의 유구한 역사를 지니고 있는 국가이다.";
        info_description_kr[6] = "이탈리아 공화국(Repubblica Italiana), 약칭 이탈리아(Italia)는 이탈리아반도와 지중해의 두 개의 섬으로 이루어진 시칠리아 및 사르데냐로 이루어진 단일 의회 공화국이다.";
        info_description_kr[7] = "프랑스 공화국(République française) 약칭 프랑스(France)는 서유럽의 본토와 남아메리카의 프랑스령 기아나를 비롯한 해외 레지옹과 해외 영토로 이루어진 국가이다.";
        info_description_kr[8] = "칠레 공화국(República de Chile), 줄여서 칠레(Chile)는 태평양과 남아메리카의 안데스 산맥 사이에 남북으로 긴 영토를 가진 나라이다.";
        info_description_kr[9] = "미합중국(United States of America, USA), 약칭 합중국(United States, U.S.) 또는 미국(美國) 은 주 50개와 특별구 1개로 이루어진 연방제 공화국이다.";

//        영어 설명
        info_description_eng[0] = "Japan is a country made up of four large islands of the Japanese archipelago in the East Asian Pacific Ocean and small islands scattered around them.";
        info_description_eng[1] = "Korea is a democratic republic located at the southern tip of the Korean Peninsula in East Asia. Countries with the fastest economic growth in the world since the 1960s";
        info_description_eng[2] = "China is a one-party socialist country autographed by the Chinese Communist Party as a country on the westside of the Korean Peninsula in East Asia.";
        info_description_eng[3] = "The Republic of India is a country in South Asia that owns most of the Indian subcontinent.";
        info_description_eng[4] = "Russia is a federal country that spans Eastern Europe and North Asia and is the largest country in the world.";
        info_description_eng[5] = "Egypt is a country with a long history of about 5,000 years, spanning the Sinai Peninsula in North Africa and Western Asia.";
        info_description_eng[6] = "Italy is a unitary parliamentary republic consisting of Sicily and Sardinia, made up of the Italian Peninsula and two islands in the Mediterranean Sea.";
        info_description_eng[7] = "France is a country made up of foreign legions and foreign territories, including mainland Western Europe and French Guiana in South America.";
        info_description_eng[8] = "Chile is a country that stretches from north to south between the Pacific Ocean and the Andes in South America.";
        info_description_eng[9] = "The United States of America, abbreviated to the United States, is a federal republic consisting of 50 states and one special district.";
    }


}
