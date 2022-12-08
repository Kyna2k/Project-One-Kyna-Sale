package com.example.kynasale.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.kynasale.fragment.Fragment_nhanvien;

public class adapter_viewpager extends FragmentStateAdapter {
    private int maNhanVien;
    public adapter_viewpager(@NonNull FragmentActivity fragmentActivity, int maNhanVien) {

        super(fragmentActivity);
        this.maNhanVien = maNhanVien;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Fragment_nhanvien(0, 1);
            case 1:
                return new Fragment_nhanvien(maNhanVien, 2);
            case 2:
                return new Fragment_nhanvien(maNhanVien, 3);
            default:
                return new Fragment_nhanvien(0, 1);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
