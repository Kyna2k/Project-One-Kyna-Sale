package com.example.kynasale.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kynasale.API_SERVICE.API_SERVICE;
import com.example.kynasale.LoadingSreen.LoadingScreen;
import com.example.kynasale.R;
import com.example.kynasale.adapter.Recycle_KhuyenMai;
import com.example.kynasale.model.KhuyenMai;
import com.example.kynasale.view.MainActivity;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class Fragment_TrangChu extends Fragment {
    private RecyclerView list_khuyenmai;
    private API_SERVICE requestInterface;
    private Recycle_KhuyenMai adapter;
    public Fragment_TrangChu()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trangchu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestInterface = ((MainActivity)getActivity()).getAPI();
        list_khuyenmai = view.findViewById(R.id.list_khuyenmai);
        getKhuyenMai();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            LoadingScreen.LoadingDismi();
        }catch (Exception E){}
        getKhuyenMai();
    }

    public void setDate(ArrayList<KhuyenMai> ds)
    {
        adapter = new Recycle_KhuyenMai(getActivity(),ds);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        list_khuyenmai.setLayoutManager(linearLayoutManager);
        list_khuyenmai.setAdapter(adapter);
    }
    public void getKhuyenMai()
    {
        LoadingScreen.LoadingShow(getActivity(),"Đang lấy khuyến mãi");
        new CompositeDisposable().add(requestInterface.getAllKhuyenMai()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::getKhuyenMaiOk, this::getKhuyenMaiNoOk)
        );
    }

    private void getKhuyenMaiNoOk(Throwable throwable) {
        LoadingScreen.LoadingDismi();
    }

    private void getKhuyenMaiOk(ArrayList<KhuyenMai> khuyenMais) {
        if(khuyenMais != null)
        {
            setDate(khuyenMais);
        }
        LoadingScreen.LoadingDismi();
    }
}
