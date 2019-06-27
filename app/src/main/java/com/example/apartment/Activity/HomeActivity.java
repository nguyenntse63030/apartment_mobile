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
        loadFragment(listNewsFragment, "news");
    }

    @Override
    protected void onStart() {
        super.onStart();

        taskBarItem.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getSupportFragmentManager();

                if(item.getItemId() == R.id.ic_news){
                    txtHomeTitle.setText("News");

                 if(fm.findFragmentByTag("news") == null){
                       ListNewsFragment listNewsFragment = new ListNewsFragment();
                        loadFragment(listNewsFragment,"news");
                  }else {
                      loadFragmentExited("news");
                  }

                }

                if(item.getItemId() == R.id.ic_unpay_bill){
                    txtHomeTitle.setText("Bill");

                    if(fm.findFragmentByTag("bills") == null){
                        ListBillFragment listBillFragment = new ListBillFragment();
                        loadFragment(listBillFragment,"bills");
                    }else {
                        loadFragmentExited("bills");
                    }
                }

                if(item.getItemId() == R.id.ic_room){
                    txtHomeTitle.setText("Room");

                    if(fm.findFragmentByTag("rooms") == null){
                        ListRoomFragment listRoomFragment = new ListRoomFragment();
                        loadFragment(listRoomFragment,"rooms");
                    }else {
                        loadFragmentExited("rooms");
                    }

                }

                if(item.getItemId() == R.id.ic_setting){
                    txtHomeTitle.setText("Setting");

                    if(fm.findFragmentByTag("setting") == null){
                        SettingFragment settingFragment = new SettingFragment();
                        loadFragment(settingFragment,"setting");
                    }else {
                        loadFragmentExited("setting");
                    }

                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment, String fragmentTag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment, fragmentTag);
        fragmentTransaction.addToBackStack(fragmentTag);
        fragmentTransaction.commit();
    }

    private void loadFragmentExited(String fragmentTag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        Fragment fragmentExited = fm.findFragmentByTag(fragmentTag);
        fragmentTransaction.replace(R.id.fragmentLayout, fragmentExited, fragmentTag);
        fragmentTransaction.addToBackStack(fragmentTag);
        fragmentTransaction.commit();
    }
}
