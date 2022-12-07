package com.example.kynasale.model;

public class XuLyHoaDonModel {
    private int maHoaDon;
    private byte trangThai;

    public XuLyHoaDonModel(int maHoaDon, byte trangThai) {
        this.maHoaDon = maHoaDon;
        this.trangThai = trangThai;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public byte getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(byte trangThai) {
        this.trangThai = trangThai;
    }
}
