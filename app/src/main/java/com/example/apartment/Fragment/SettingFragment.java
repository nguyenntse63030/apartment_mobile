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

import com.example.apartment.Activity.DepositAccountActivity;
import com.example.apartment.Activity.DepositAccountViewMoneyActivity;
import com.example.apartment.Activity.LoginActivity;
import com.example.apartment.Activity.MapsActivity;
import com.example.apartment.Activity.ProfileActivity;
import com.example.apartment.Contract.MapActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.R;

import static android.content.Context.MODE_PRIVATE;


public class SettingFragment extends Fragment {
    private Button btnProfile,btnDeposit,btnLogout,btnMap;
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
        btnMap = view.findViewById(R.id.btnMap);

        btnLogout = view.findViewById(R.id.btnLogout);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DepositAccountViewMoneyActivity.class);
                startActivity(intent);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
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
                GlobalValue.mAuth.signOut();
                //Back to login page
                Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
