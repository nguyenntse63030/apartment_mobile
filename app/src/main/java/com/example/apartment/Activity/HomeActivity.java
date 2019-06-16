package com.example.apartment.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.apartment.Fragment.ListBillFragment;
import com.example.apartment.Fragment.ListNewsFragment;
import com.example.apartment.Fragment.ListRoomFragment;
import com.example.apartment.Fragment.SettingFragment;
import com.example.apartment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{
    BottomNavigationView taskBarItem;
    TextView txtHomeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        taskBarItem = findViewById(R.id.taskBarItem);
        txtHomeTitle = findViewById(R.id.txtHomeTitle);

        ListNewsFragment listNewsFragment = new ListNewsFragment();
        loadFragment(listNewsFragment);
    }

    @Override
    protected void onStart() {
        super.onStart();

        taskBarItem.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ic_news){
                    txtHomeTitle.setText("News");
                    ListNewsFragment listNewsFragment = new ListNewsFragment();
                    loadFragment(listNewsFragment);
                }

                if(item.getItemId() == R.id.ic_unpay_bill){
                    txtHomeTitle.setText("Bill");
                    ListBillFragment listBillFragment = new ListBillFragment();
                    loadFragment(listBillFragment);
                }

                if(item.getItemId() == R.id.ic_room){
                    txtHomeTitle.setText("Room");
                    ListRoomFragment listRoomFragment = new ListRoomFragment();
                    loadFragment(listRoomFragment);
                }

                if(item.getItemId() == R.id.ic_setting){
                    txtHomeTitle.setText("Setting");
                    SettingFragment settingFragment = new SettingFragment();
                    loadFragment(settingFragment);
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
