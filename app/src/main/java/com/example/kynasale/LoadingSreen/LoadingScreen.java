package com.example.kynasale.LoadingSreen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kynasale.R;


public class LoadingScreen {
    private static AlertDialog alertDialog_loading;
    public static void LoadingShow(Context context, String noidung)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.loading_screen,null);
        builder.setView(view);
        ImageView icon = view.findViewById(R.id.load_toktok);
        TextView noidung_ne = view.findViewById(R.id.noidung);
        noidung_ne.setText(noidung);
        Glide.with(context).load(R.mipmap.ic_loading_2).into(icon);
        alertDialog_loading= builder.create();
        alertDialog_loading.setCancelable(false);
        alertDialog_loading.setCanceledOnTouchOutside(false);
        alertDialog_loading.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog_loading.show();
    }
    public static void LoadingDismi()
    {
        alertDialog_loading.dismiss();
    }
}
