package com.example.kynasale.model;

import java.io.Serializable;
import java.util.ArrayList;

public class HoaDon implements Serializable {
    private int maHoaDon;
    private int maNhanVien;
    private int maKhachHang;
    private String ngayXuatHoaDon;
    private int trangThai;
    private ArrayList<ChiTietHoaDon> chiTietHoaDons;

    public HoaDon(int maHoaDon, int maNhanVien, int maKhachHang, String ngayXuatHoaDon, int trangThai, ArrayList<ChiTietHoaDon> chiTietHoaDons) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.ngayXuatHoaDon = ngayXuatHoaDon;
        this.trangThai = trangThai;
        this.chiTietHoaDons = chiTietHoaDons;
    }
    public HoaDon() {
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayXuatHoaDon() {
        return ngayXuatHoaDon;
    }

    public void setNgayXuatHoaDon(String ngayXuatHoaDon) {
        this.ngayXuatHoaDon = ngayXuatHoaDon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public ArrayList<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }
}
