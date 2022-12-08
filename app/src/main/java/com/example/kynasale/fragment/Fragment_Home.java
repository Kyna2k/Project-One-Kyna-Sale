package com.example.kynasale.fragment;

import static com.example.kynasale.API_SERVICE.API_SERVICE.BASE_Service;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.kynasale.API_SERVICE.API_SERVICE;
import com.example.kynasale.Interfaces.Click_ChiTietHoaDon;
import com.example.kynasale.R;
import com.example.kynasale.adapter.Recycle_List_HoaDon;
import com.example.kynasale.adapter.adapter_viewpager;
import com.example.kynasale.model.HoaDon;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Home extends Fragment {
    private TabLayout tablayout;
    private ViewPager2 viewpager2;
    private Recycle_List_HoaDon adapter1;
    private adapter_viewpager apdater;
    private RecyclerView recyclerView;
    public Fragment_Home()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tablayout = view.findViewById(R.id.tablayout);
        viewpager2 = view.findViewById(R.id.viewpager2);
        apdater = new adapter_viewpager((FragmentActivity) getActivity(),getActivity().getSharedPreferences("NHANVIEN", Context.MODE_PRIVATE).getInt("MANV",-1));
        viewpager2.setAdapter(apdater);

        new TabLayoutMediator(tablayout, viewpager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Chờ xác nhận");
                        break;
                    case 1:
                        tab.setText("Xử lý");
                        break;
                    case 2:
                        tab.setText("Giao nhận thành công");
                        break;
                }
            }
        }).attach();
    }
    private void CallAPI(int maNhanVien, int trangThai) {

        API_SERVICE requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API_SERVICE.class);

        new CompositeDisposable().add(requestInterface.getHoaDonXuLy(maNhanVien, trangThai)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::thanhcong, this::thatbai)
        );
    }
    public void setData(ArrayList<HoaDon> ds) {
        adapter1 = new Recycle_List_HoaDon(getContext(), ds, (Click_ChiTietHoaDon) this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter1);

    }

    private void thatbai(Throwable throwable) {
        Log.e("getValue", "getHoaDonNo: "+ throwable.getMessage() );
    }

    private void thanhcong(ArrayList<HoaDon> hoaDons) {
        if(hoaDons != null){
            setData(hoaDons);
        } else{

        }
    }

}
