package com.example.kynasale.model;

public class KhachHangAddSanPhamVaoGioHang {
    private int MaKhachHang;
    private int MaSanPham;
    private int SoLuong;
    private Double TriGia;

    public KhachHangAddSanPhamVaoGioHang(int maKhachHang, int maSanPham, int soLuong, Double triGia) {
        MaKhachHang = maKhachHang;
        MaSanPham = maSanPham;
        SoLuong = soLuong;
        TriGia = triGia;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        MaKhachHang = maKhachHang;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        MaSanPham = maSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public Double getTriGia() {
        return TriGia;
    }

    public void setTriGia(Double triGia) {
        TriGia = triGia;
    }
}
