package com.example.kynasale.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kynasale.R;

public class Fragment_nhanvien extends Fragment {
    private int maNhanVien;
    private int trangThai;
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
}
