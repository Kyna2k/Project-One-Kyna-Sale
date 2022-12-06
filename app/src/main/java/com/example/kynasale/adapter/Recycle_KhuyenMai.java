package com.example.kynasale.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kynasale.R;
import com.example.kynasale.model.KhuyenMai;

import java.util.ArrayList;

public class Recycle_KhuyenMai extends RecyclerView.Adapter<Recycle_KhuyenMai.ViewHolder>{

    private Context context;
    private ArrayList<KhuyenMai> ds;

    public Recycle_KhuyenMai(Context context, ArrayList<KhuyenMai> ds)
    {
        this.context = context;
        this.ds = ds;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_khuyenmai,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(ds.get(position).getHinh()).into(holder.hinh);

        holder.makhuyenmai.setText("Mã khuyến mãi: " + ds.get(position).getMaKhuyenMai());
        holder.ngaybatdau.setText("Ngày bắt đầu: " +getDate(ds.get(position).getNgayBatDau()));
        holder.ngayketthu.setText("Ngày kết thúc: " +getDate(ds.get(position).getNgayKetThuc()));
        holder.phantramkhuyenmai.setText(ds.get(position).getPhanTramKhuyenMai()+"%");
    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hinh;
        TextView makhuyenmai,ngaybatdau,ngayketthu,phantramkhuyenmai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hinh = itemView.findViewById(R.id.hinh);
            makhuyenmai = itemView.findViewById(R.id.makhuyenmai);
            ngaybatdau = itemView.findViewById(R.id.ngaybatdau);
            ngayketthu = itemView.findViewById(R.id.ngayketthu);
            phantramkhuyenmai = itemView.findViewById(R.id.phantramkhuyenmai);
        }
    }
    private String getDate(String value)
    {
        return value.split("T")[0];
    }
}
