package com.example.kynasale.model;

public class XoaHoaDonGioHang {
    private int MaHoaDon;
    private int MaSanPham;

    public XoaHoaDonGioHang(int maHoaDon, int maSanPham) {
        MaHoaDon = maHoaDon;
        MaSanPham = maSanPham;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        MaSanPham = maSanPham;
    }
}
