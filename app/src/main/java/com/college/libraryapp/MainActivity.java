package com.college.libraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.college.libraryapp.databinding.ActivityMainBinding;
import com.college.libraryapp.fragment.AboutFragment;
import com.college.libraryapp.fragment.AttendanceFragment;
import com.college.libraryapp.fragment.FeesFragment;
import com.college.libraryapp.fragment.HomeFragment;
import com.college.libraryapp.fragment.NewsFragment;
import com.college.libraryapp.fragment.NotesFragment;
import com.college.libraryapp.fragment.NotificationFragment;
import com.college.libraryapp.fragment.SupportFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        binding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(MainActivity.this, new NotificationFragment());
            }
        });

        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_home:{
                        replaceFragment(MainActivity.this,new HomeFragment());
                        break;
                    }
                    case R.id.menu_about:{
                        replaceFragment(MainActivity.this,new AboutFragment());
                        break;
                    }
                    case R.id.menu_attendance:{
                        replaceFragment(MainActivity.this,new AttendanceFragment());
                        break;
                    }
                    case R.id.menu_fees:{
                        replaceFragment(MainActivity.this,new FeesFragment());
                        break;
                    }
                    case R.id.menu_news:{
                        replaceFragment(MainActivity.this,new NewsFragment());
                        break;
                    }
                    case R.id.menu_notes:{
                        replaceFragment(MainActivity.this,new NotesFragment());
                        break;
                    }
                    case R.id.notification:{
                        replaceFragment(MainActivity.this,new NotificationFragment());
                        break;
                    }
                    case R.id.menu_support:{
                        replaceFragment(MainActivity.this,new SupportFragment());
                    }
                }
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    public static void replaceFragment(FragmentActivity fragmentActivity, Fragment fragment) {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isOpen()) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}