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
    ImgDescription imgD;
    LinearLayout container;
    ImageView image;
    TextView description, title;


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
        doFullScreen(dlg);
        setImage(country, img);
        setDescription(country, img);
        setTitle(country, img);
        dlg.show();
        dismissDialog(dlg);
    }

    void init(Dialog dialog) {
        imgD = new ImgDescription();
        image = (ImageView) dialog.findViewById(R.id.image);
        title = (TextView) dialog.findViewById(R.id.title);
        description = (TextView) dialog.findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());
        container = (LinearLayout) dialog.findViewById(R.id.container_dialog);
    }

    void setImage(int country, int img) {
        image.setImageResource(imgD.getImages(country, img));
    }

    void setTitle(int country, int img) {
        title.setText(imgD.getTitle(country, img));
    }

    void setDescription(int country, int img) {
        description.setText(imgD.getDescriptionText(country, img));
    }



    void dismissDialog(Dialog dialog) {
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


    private void doFullScreen(Dialog dialog) {
        View decorView = dialog.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


}
