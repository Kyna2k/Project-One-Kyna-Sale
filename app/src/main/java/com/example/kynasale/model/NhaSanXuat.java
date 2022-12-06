package com.example.kynasale.model;

import java.io.Serializable;
import java.util.ArrayList;

public class NhaSanXuat implements Serializable {
    private int maNhaSanXuat;
    private String tenNhaSanXuat;
    private String hinh;
    private ArrayList<SanPhams> sanPhams;

    public NhaSanXuat(int maNhaSanXuat, String tenNhaSanXuat, String hinh, ArrayList<SanPhams> sanPhams) {
        this.maNhaSanXuat = maNhaSanXuat;
        this.tenNhaSanXuat = tenNhaSanXuat;
        this.hinh = hinh;
        this.sanPhams = sanPhams;
    }

    public int getMaNhaSanXuat() {
        return maNhaSanXuat;
    }

    public void setMaNhaSanXuat(int maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public ArrayList<SanPhams> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(ArrayList<SanPhams> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
