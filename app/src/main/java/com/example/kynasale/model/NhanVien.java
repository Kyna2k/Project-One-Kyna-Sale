package com.example.kynasale.model;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien implements Serializable {
    private int maNhanVien;
    private String username;
    private String password;
    private String avatar;
    private String ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private ArrayList<HoaDon> hoaDons;

    public NhanVien(int maNhanVien, String username, String password, String avatar, String ngaySinh, String diaChi, String soDienThoai, ArrayList<HoaDon> hoaDons) {
        this.maNhanVien = maNhanVien;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.hoaDons = hoaDons;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public ArrayList<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(ArrayList<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }
}
