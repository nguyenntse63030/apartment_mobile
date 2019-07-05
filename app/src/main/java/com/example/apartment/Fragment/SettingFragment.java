package com.example.apartment.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apartment.Activity.LoginActivity;
import com.example.apartment.R;

import static android.content.Context.MODE_PRIVATE;


public class SettingFragment extends Fragment {
    Button btnProfile,btnDeposit,btnLogout;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        btnProfile = view.findViewById(R.id.btnProfile);
        btnDeposit = view.findViewById(R.id.btnDeposit);
        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getApplicationContext().getSharedPreferences("User", MODE_PRIVATE).edit();

                //remove profile user
                editor.remove("token");
                editor.remove("name");
                editor.remove("id");
                editor.remove("gender");
                editor.remove("mail");
                editor.remove("phone");
                editor.remove("birthDay");
                editor.remove("address");
                editor.remove("code");
                editor.remove("createTime");
                editor.remove("photoURL");
                editor.apply();

                //Back to login page
                Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
