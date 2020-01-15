package com.ppsi.latihan_ujian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    final HomeFragment homeFragment = new HomeFragment();
    final ProfileFragment profileFragment = new ProfileFragment();
    final  AkunFragment akunFragment = new AkunFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.menu_bottom);

        loadFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        loadFragment(homeFragment);
                        Toast.makeText(getApplicationContext(),"Fragment Home Behasil di Load!",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_profile:
                        loadFragment(profileFragment);
                        Toast.makeText(getApplicationContext(),"Fragment Profile Behasil di Load!",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_akun:
                        loadFragment(akunFragment);
                        Toast.makeText(getApplicationContext(),"Fragment Akun Behasil di Load!",Toast.LENGTH_LONG).show();
                        break;

                }
                return true;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.isi_content, fragment);
        fragmentTransaction.commit();
    }


}
