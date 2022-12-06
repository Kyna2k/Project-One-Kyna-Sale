package com.example.kynasale.model;

import java.io.Serializable;
import java.util.ArrayList;

public class KhuyenMai implements Serializable {
    private int maKhuyenMai;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String hinh;
    private int phanTramKhuyenMai;
    private ArrayList<SanPhams> sanPhams;

    public KhuyenMai(int maKhuyenMai, String ngayBatDau, String ngayKetThuc, String hinh, int phanTramKhuyenMai, ArrayList<SanPhams> sanPhams) {
        this.maKhuyenMai = maKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hinh = hinh;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
        this.sanPhams = sanPhams;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(int phanTramKhuyenMai) {
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }

    public ArrayList<SanPhams> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(ArrayList<SanPhams> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
