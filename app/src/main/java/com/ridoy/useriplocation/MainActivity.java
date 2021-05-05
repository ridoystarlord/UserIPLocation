package com.ridoy.useriplocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.ridoy.useriplocation.API.CoronaAPI;
import com.ridoy.useriplocation.API.UserCountry;
import com.ridoy.useriplocation.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CoronaAPI.getApi().getCountryData().enqueue(new Callback<List<UserCountry>>() {
            @Override
            public void onResponse(Call<List<UserCountry>> call, Response<List<UserCountry>> response) {

                UserCountry country= (UserCountry) response.body();
                binding.country.setText(country.getCountry());
            }

            @Override
            public void onFailure(Call<List<UserCountry>> call, Throwable t) {
                binding.country.setText(t.getMessage());
            }
        });
    }
}