package com.example.kynasale.model;

import java.io.Serializable;
import java.util.ArrayList;

public class KhachHang implements Serializable {
    private int maKhachHang;
    private String soDienThoai;
    private String facebook;
    private String google;
    private String avatar;
    private String tenKhachHang;
    private String diaChi;
    private String email;
    private ArrayList<Comment> comments;
    private ArrayList<HoaDon> hoaDons;

    public KhachHang(int maKhachHang, String soDienThoai, String facebook, String google, String avatar, String tenKhachHang, String diaChi, String email, ArrayList<Comment> comments, ArrayList<HoaDon> hoaDons) {
        this.maKhachHang = maKhachHang;
        this.soDienThoai = soDienThoai;
        this.facebook = facebook;
        this.google = google;
        this.avatar = avatar;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.email = email;
        this.comments = comments;
        this.hoaDons = hoaDons;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(ArrayList<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }
}
