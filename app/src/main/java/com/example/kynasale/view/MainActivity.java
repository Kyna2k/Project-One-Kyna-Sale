package com.example.kynasale.view;

import static com.example.kynasale.API_SERVICE.API_SERVICE.BASE_Service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kynasale.API_SERVICE.API_SERVICE;
import com.example.kynasale.R;
import com.example.kynasale.fragment.Fragment_Home;
import com.example.kynasale.fragment.Fragment_TrangChu;
import com.example.kynasale.model.NhanVien;
import com.google.android.material.navigation.NavigationView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private View headerView;
    private ActionBarDrawerToggle drawerToggle;
    private NhanVien nhanVien;
    private API_SERVICE requestInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API_SERVICE.class);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Kyna Sale");
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawelayout);
        navigationView = (NavigationView) findViewById(R.id.menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        nhanVien = (NhanVien) getIntent().getExtras().getSerializable("NV");
        headerView = navigationView.getHeaderView(0);
        ImageView avatar_header = headerView.findViewById(R.id.avatar_user);
        TextView name = headerView.findViewById(R.id.name);
        TextView email = headerView.findViewById(R.id.email);

        if(nhanVien.getAvatar() != null)
        {
            Glide.with(this).load(nhanVien.getAvatar()).circleCrop().into(avatar_header);
        }else
        {
            Glide.with(this).load(R.mipmap.avatar_def).circleCrop().into(avatar_header);

        }
        name.setText("Tên nv: " +nhanVien.getUsername());
        email.setText("SĐT: "+nhanVien.getSoDienThoai());
        getSupportFragmentManager().beginTransaction().replace(R.id.main,new Fragment_TrangChu(),null).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case R.id.TrangChu:
                        fragment = new Fragment_TrangChu();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.hoadon:
                        fragment = new Fragment_Home();
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.thongtin:
                        drawerLayout.closeDrawers();

                        break;

                    case R.id.thoat:
                        finish();
                        break;
                    default:
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main,fragment,null).commit();

                return true;
            }
        });
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }
    public API_SERVICE getAPI()
    {
        return requestInterface;
    }
}