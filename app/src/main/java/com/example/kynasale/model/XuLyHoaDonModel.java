package com.example.kynasale.model;

public class XuLyHoaDonModel {
    private int maHoaDon;
    private int trangThai;
    private int maNhanVien;

    public XuLyHoaDonModel(int maHoaDon, int trangThai, int maNhanVien) {
        this.maHoaDon = maHoaDon;
        this.trangThai = trangThai;
        this.maNhanVien = maNhanVien;
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

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}
