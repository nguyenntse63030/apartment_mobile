package com.example.apartment.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.apartment.Fragment.ListBillFragment;
import com.example.apartment.Fragment.ListNewsFragment;
import com.example.apartment.Fragment.ListRoomFragment;
import com.example.apartment.Fragment.SettingFragment;
import com.example.apartment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.iid.FirebaseInstanceId;

public class HomeActivity extends AppCompatActivity{
    private BottomNavigationView taskBarItem;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String token = FirebaseInstanceId.getInstance().getToken();
        System.out.println(token);
        fm = getSupportFragmentManager();

        taskBarItem = findViewById(R.id.taskBarItem);

        ListNewsFragment listNewsFragment = new ListNewsFragment();
        loadFragment(listNewsFragment, "news");

//        ListRoomFragment listRoomFragment = new ListRoomFragment();
//        loadFragment(listRoomFragment,"rooms");
//
//        ListBillFragment listBillFragment = new ListBillFragment();
//        loadFragment(listBillFragment,"bills");
//
//        SettingFragment settingFragment = new SettingFragment();
//        loadFragment(settingFragment,"setting");
    }

    @Override
    protected void onStart() {
        super.onStart();

//        loadFragmentExited("news");

        taskBarItem.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if(item.getItemId() == R.id.ic_news){

//                 if(fm.findFragmentByTag("news") != null) {
//
//                     loadFragmentExited("news");
//                     hideFragment("bills");
//                     hideFragment("rooms");
//                     hideFragment("setting");
//
//                 }

                    ListNewsFragment listNewsFragment = new ListNewsFragment();
                    loadFragment(listNewsFragment,"news");
                }

                if(item.getItemId() == R.id.ic_unpay_bill){

//                    if(fm.findFragmentByTag("bills") != null){
//
//                        loadFragmentExited("bills");
//                        hideFragment("news");
//                        hideFragment("rooms");
//                        hideFragment("setting");
//                    }

                    ListBillFragment listBillFragment = new ListBillFragment();
                    loadFragment(listBillFragment,"bills");
                }

                if(item.getItemId() == R.id.ic_room){

//                    if(fm.findFragmentByTag("rooms") != null){
//
//                        loadFragmentExited("rooms");
//                        hideFragment("bills");
//                        hideFragment("news");
//                        hideFragment("setting");
//                    }

                    ListRoomFragment listRoomFragment = new ListRoomFragment();
                    loadFragment(listRoomFragment,"rooms");
                }

                if(item.getItemId() == R.id.ic_setting){

//                    if(fm.findFragmentByTag("setting") != null){
//
//                        loadFragmentExited("setting");
//                        hideFragment("bills");
//                        hideFragment("rooms");
//                        hideFragment("news");
//                    }

                    SettingFragment settingFragment = new SettingFragment();
                    loadFragment(settingFragment,"setting");

                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment, String fragmentTag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment, fragmentTag);
//        fragmentTransaction.add(R.id.fragmentLayout, fragment, fragmentTag);
//        fragmentTransaction.hide(fragment);
        fragmentTransaction.commit();
    }

//    private void loadFragmentExited(String fragmentTag){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//
//        Fragment fragmentExited = fm.findFragmentByTag(fragmentTag);
//        fragmentTransaction.show(fragmentExited);
//        fragmentTransaction.commit();
//    }
//
//    private void hideFragment(String fragmentTag){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//
//        Fragment fragmentExited = fm.findFragmentByTag(fragmentTag);
//        if(fragmentExited != null){
//            fragmentTransaction.hide(fragmentExited);
//            fragmentTransaction.commit();
//        }
//    }
}
