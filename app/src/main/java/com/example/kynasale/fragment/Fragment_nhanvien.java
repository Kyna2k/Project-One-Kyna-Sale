package com.example.kynasale.fragment;

import static com.example.kynasale.API_SERVICE.API_SERVICE.BASE_Service;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kynasale.API_SERVICE.API_SERVICE;
import com.example.kynasale.Interfaces.Click_ChiTietHoaDon;
import com.example.kynasale.LoadingSreen.LoadingScreen;
import com.example.kynasale.R;
import com.example.kynasale.adapter.Recycle_List_HoaDon;
import com.example.kynasale.model.HoaDon;
import com.example.kynasale.model.XuLyHoaDonModel;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_nhanvien extends Fragment implements Click_ChiTietHoaDon{
    private int maNhanVien;
    private int trangThai;
    private RecyclerView recycle;
    private Recycle_List_HoaDon adapter1;
    private API_SERVICE requestInterface;
    public Fragment_nhanvien(int maNhanVien, int trangThai){
        this.maNhanVien = maNhanVien;
        this.trangThai = trangThai;
    }
    public Fragment_nhanvien(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_nhanvien, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycle = view.findViewById(R.id.recycle);
        requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API_SERVICE.class);
        CallAPI(maNhanVien,trangThai);
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            LoadingScreen.LoadingDismi();
        }catch (Exception e)
        {

        }
        CallAPI(maNhanVien,trangThai);
    }

    private void CallAPI(int maNhanVien, int trangThai) {

        new CompositeDisposable().add(requestInterface.getHoaDonXuLy(maNhanVien, trangThai)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::thanhcong, this::thatbai)
        );
    }
    public void setData(ArrayList<HoaDon> ds) {
        try {
            LoadingScreen.LoadingDismi();
        }catch (Exception e)
        {

        }
        adapter1 = new Recycle_List_HoaDon(getContext(), ds, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(adapter1);
    }

    private void thatbai(Throwable throwable) {
        Log.e("getValue", "getHoaDonNo: "+ throwable.getMessage() );
        LoadingScreen.LoadingDismi();
    }

    private void thanhcong(ArrayList<HoaDon> hoaDons) {
        if(hoaDons != null){
            setData(hoaDons);
        } else{

        }
        LoadingScreen.LoadingDismi();

    }

    @Override
    public void click_me(HoaDon hoaDon) {
        updatetrangthai(new XuLyHoaDonModel(hoaDon.getMaHoaDon(),trangThai+1 ,getActivity().getSharedPreferences("NHANVIEN", Context.MODE_PRIVATE).getInt("MANV",-1)));

    }

    @Override
    public void Huy(int MaHoaDOn) {
        huydonhang(MaHoaDOn,getActivity().getSharedPreferences("NHANVIEN", Context.MODE_PRIVATE).getInt("MANV",-1));
    }
    private void huydonhang(int mahoadon, int manhanvien) {


        new CompositeDisposable().add(requestInterface.HuyDonHang(mahoadon,manhanvien)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::xoathanhcong, this::xoathatbai)
        );
    }

    private void xoathatbai(Throwable throwable) {
    }

    private void xoathanhcong(Integer integer) {
        if(integer > 0)
        {
            onResume();
            Toast.makeText(getContext(), "THành công", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatetrangthai(XuLyHoaDonModel xuLyHoaDonModel) {


        new CompositeDisposable().add(requestInterface.updateHoaDonXuLy(xuLyHoaDonModel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::thanhcong_update, this::thatbai_update)
        );
    }

    private void thatbai_update(Throwable throwable) {
        Log.e("getValue", "getHoaDonNo: "+ throwable.getMessage() );
        LoadingScreen.LoadingDismi();
    }

    private void thanhcong_update(Integer integer) {
        if(integer > 0)
        {
            onResume();
        }
        LoadingScreen.LoadingDismi();
    }
}
