package com.example.kynasale.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kynasale.R;
import com.example.kynasale.model.ChiTietHoaDon;
import com.example.kynasale.model.Convent_Money;
import com.example.kynasale.model.SanPhams;

import java.util.ArrayList;

public class Recycle_List_DonHang extends RecyclerView.Adapter<Recycle_List_DonHang.ViewHolder> {
    private Context context;
    private ArrayList<ChiTietHoaDon> ds;
    public Recycle_List_DonHang(Context context, ArrayList<ChiTietHoaDon> ds)
    {
        this.context = context;
        this.ds = ds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_donhang,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(ds.get(position).getSanPham().getHinhs().size() > 0)
        {
            Glide.with(context).load(ds.get(position).getSanPham().getHinhs().get(0).getUrl()).into(holder.hinh_laptop);
        }else
        {
            Glide.with(context).load(context.getResources().getIdentifier("laptop","mipmap",context.getPackageName())).into(holder.hinh_laptop);
        }
        holder.khuyenMai.setVisibility(View.GONE);
        SanPhams sanPhams = ds.get(position).getSanPham();
        if(ds.get(position).getTriGia() < sanPhams.getGiaGoc())
        {
            holder.gia.setText(Convent_Money.money(ds.get(position).getTriGia()));
            holder.gia_goc.setText(Convent_Money.money(sanPhams.getGiaGoc()));
            holder.gia_goc.setPaintFlags(holder.gia_goc.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            holder.khuyenMai.setVisibility(View.VISIBLE);
        }else {
            holder.gia.setText(Convent_Money.money(ds.get(position).getTriGia()));
            holder.gia_goc.setText(Convent_Money.money(sanPhams.getGiaGoc()));
            holder.khuyenMai.setVisibility(View.GONE);
        }

        holder.ten_sp.setText(ds.get(position).getSanPham().getTenSanPham());
        holder.soluong.setText( "X"+String.valueOf(ds.get(position).getSoLuong()));

    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hinh_laptop;
        TextView ten_sp,gia,gia_goc,khuyenMai,soluong;
        CardView list_car;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hinh_laptop = itemView.findViewById(R.id.hinh_laptop);
            ten_sp = itemView.findViewById(R.id.ten_sp);
            gia = itemView.findViewById(R.id.gia);
            soluong = itemView.findViewById(R.id.soluong);
            gia_goc = itemView.findViewById(R.id.gia_goc);
            khuyenMai = itemView.findViewById(R.id.khuyenMai);
            list_car = itemView.findViewById(R.id.list_car);

        }

    }
}
