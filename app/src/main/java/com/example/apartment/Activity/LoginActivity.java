package com.example.apartment.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apartment.Contract.LoginActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.Presenter.LoginActivityPresenterImpl;
import com.example.apartment.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract.LoginActivityView {
    private TextInputEditText editPhone,editPassword;
    private ScrollView scrollViewLogin;
    private LoginActivityContract.LoginActivityPresenter presenter;
    private Button btnSignIn;
    private SignInButton btnSignInGoogle;
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN=1;
    private String TAG="LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignInGoogle = findViewById(R.id.btnSignInGoogle);
        TextView textView = (TextView) btnSignInGoogle.getChildAt(0);
        textView.setText("Sign in with Google");
        scrollViewLogin = findViewById(R.id.scrollViewLogin);
        editPhone = findViewById(R.id.editPhone);
        editPassword = findViewById(R.id.editPassword);
        presenter = new LoginActivityPresenterImpl(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GlobalValue.mAuth = FirebaseAuth.getInstance();

    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onStart() {
        super.onStart();


        try {
            SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
            String token = sharedPreferences.getString("token","");
            if(!token.isEmpty()){
                Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       // SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    presenter.login(editPhone,editPassword,getApplicationContext());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        btnSignInGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        scrollViewLogin.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }


    @Override
    public void changePage() {
        Intent intentOnclick= new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intentOnclick);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        presenter.onActivityResult(requestCode, resultCode, data);
    }
}

