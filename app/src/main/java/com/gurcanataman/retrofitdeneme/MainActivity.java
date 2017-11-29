package com.gurcanataman.retrofitdeneme;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText kullaniciAdi, sifre;
    private ProgressDialog progressDialog;
    RetrofitLoginService retrofitLoginService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kullaniciAdi = findViewById(R.id.kullaniciAdi);
        sifre = findViewById(R.id.sifre);


    }

    public void uyeGiris(View view) {
        postRequestMethod();
    }


    private boolean isEmpty(EditText edittext) {
        if (edittext.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    private void postRequestMethod() {

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Lütfen Bekleyiniz");
        progressDialog.show();



        retrofitLoginService = ApiClient.getApiClient().create(RetrofitLoginService.class);
        Call<UserResponse> call = retrofitLoginService.login(kullaniciAdi.getText().toString(),sifre.getText().toString(),"UTF-8");
        Log.w("request", call.request().toString());
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                progressDialog.dismiss();

                Log.e("MESAJ",""+response.code());
                Toast.makeText(MainActivity.this, "KOD:"+response.code(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }


}
