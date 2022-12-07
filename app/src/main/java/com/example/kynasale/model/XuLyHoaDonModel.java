package com.example.kynasale.model;

public class XuLyHoaDonModel {
    private int maHoaDon;
    private int trangThai;

    public XuLyHoaDonModel(int maHoaDon, int trangThai) {
        this.maHoaDon = maHoaDon;
        this.trangThai = trangThai;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
