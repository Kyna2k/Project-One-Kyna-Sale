package com.example.kynasale.view;

import static com.example.kynasale.API_SERVICE.API_SERVICE.BASE_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kynasale.API_SERVICE.API_SERVICE;
import com.example.kynasale.LoadingSreen.LoadingScreen;
import com.example.kynasale.R;
import com.example.kynasale.model.NhanVien;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private API_SERVICE requestInterface;
    private EditText username, password;
    private Button btn_dangnhap;
    private CheckBox checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().getDecorView().setSystemUiVisibility(0);
        requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API_SERVICE.class);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
        checkBox2 = findViewById(R.id.checkBox2);

        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingScreen.LoadingShow(LoginActivity.this,"Đang đăng nhập");
                login(username.getText().toString(),password.getText().toString());
            }
        });
    }

    private void login(String _username, String _password)
    {
        new CompositeDisposable().add(requestInterface.login_nhanvien(_username,_password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(this, "Mật khẩu hoặc tài khoảng không đúng", Toast.LENGTH_SHORT).show();
        LoadingScreen.LoadingDismi();
    }

    private void handleResponse(NhanVien nhanVien) {
        if(nhanVien != null)
        {
            SharedPreferences sharedPreferences = getSharedPreferences("NHANVIEN",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("MANV",nhanVien.getMaNhanVien());
            editor.apply();

            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("NV",nhanVien);
            intent.putExtras(bundle);
            if(checkBox2.isChecked())
            {
                finish();
                startActivity(intent);
                editor.putBoolean("FlashLogin",true);
                editor.apply();
            }else {
                startActivity(intent);
            }
        }
        LoadingScreen.LoadingDismi();

    }
}