package com.example.kynasale.API_SERVICE;

import com.example.kynasale.model.KhuyenMai;
import com.example.kynasale.model.NhanVien;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API_SERVICE {
    public static final String BASE_Service = "https://kynalab.com/api/";

    @GET("login_nhanvien")
    Observable<NhanVien> login_nhanvien(@Query("username") String username, @Query("password") String password);

    @GET("getAllKhuyenMai")
    Observable<ArrayList<KhuyenMai>> getAllKhuyenMai();


}
