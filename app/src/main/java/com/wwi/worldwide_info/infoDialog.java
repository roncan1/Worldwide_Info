package com.wwi.worldwide_info;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class infoDialog {
    private Context context;
    LinearLayout container;
    ImageView image;
    TextView description;
    String[][] descriptionText;
    int[][] images;

    public infoDialog(Context context) {
        this.context = context;
    }

    public void callFunction(int country, int img) {
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.dialog_info);
        WindowManager.LayoutParams wm = new WindowManager.LayoutParams();
        wm.copyFrom(dlg.getWindow().getAttributes());
        wm.width = 200;
        wm.height = 200;
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        init(dlg);
        setImage(country, img);
        setDescription(country, img);
        dlg.show();
        doFullScreen(dlg);
        dismissDialog(dlg);
    }

    void init(Dialog dialog) {
        image = (ImageView) dialog.findViewById(R.id.image);
        description = (TextView) dialog.findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());
//        scrollBottom(description);
        container = (LinearLayout) dialog.findViewById(R.id.container_dialog);

        descriptionText = new String[10][3];

        images = new int[10][3];


    }

    void setImage(int country, int img) {
        image.setImageResource(images[country][img]);
    }

    void setDescription(int country, int img) {
        description.setText(descriptionText[country][img]);
    }

//    private void scrollBottom(TextView textView) {
//        int lineTop =  textView.getLayout().getLineTop(textView.getLineCount()) ;
//        int scrollY = lineTop - textView.getHeight();
//        if (scrollY > 0) {
//            textView.scrollTo(0, scrollY);
//        } else {
//            textView.scrollTo(0, 0);
//        }
//    }

    void dismissDialog(Dialog dialog) {
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    void initDescription() {
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";

        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
        descriptionText[0][0] = "";
    }

    void initImg() {

    }

    private void doFullScreen(Dialog dialog) {
        View decorView = dialog.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


}
