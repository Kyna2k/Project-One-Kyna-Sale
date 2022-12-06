package com.example.kynasale.model;

import java.io.Serializable;

public class MuaSanPham implements Serializable {
    private int maKhachHang;
    private int maSanPham;
    private int trangThai;
    private int soLuong;
    private Double triGia;
    private String ngayXuatHoaDon;

    public MuaSanPham(int maKhachHang, int maSanPham, int trangThai, int soLuong, Double triGia, String ngayXuatHoaDon) {
        this.maKhachHang = maKhachHang;
        this.maSanPham = maSanPham;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.triGia = triGia;
        this.ngayXuatHoaDon = ngayXuatHoaDon;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getTriGia() {
        return triGia;
    }

    public void setTriGia(Double triGia) {
        this.triGia = triGia;
    }

    public String getNgayXuatHoaDon() {
        return ngayXuatHoaDon;
    }

    public void setNgayXuatHoaDon(String ngayXuatHoaDon) {
        this.ngayXuatHoaDon = ngayXuatHoaDon;
    }
}
