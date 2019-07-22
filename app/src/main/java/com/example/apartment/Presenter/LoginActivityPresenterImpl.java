package com.example.apartment.Presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.apartment.Activity.LoginActivity;
import com.example.apartment.Api.UserApi;
import com.example.apartment.Contract.LoginActivityContract;
import com.example.apartment.Global.GlobalValue;
import com.example.apartment.Model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class LoginActivityPresenterImpl implements LoginActivityContract.LoginActivityPresenter {
    private UserApi userApi;
    //    private LoginActivityContract.LoginActivityView view;
    private LoginActivity view;
    private int RC_SIGN_IN = 1;
    private String TAG = "LoginActivity";



    public LoginActivityPresenterImpl(LoginActivity view) {
        this.view = view;
    }

    @Override
    public void login(final TextInputEditText editPhone, final TextInputEditText editPassword, final Context context) {
        try {
            String phone = editPhone.getText().toString();
            String password = editPassword.getText().toString();
            String tokenFirebase = FirebaseInstanceId.getInstance().getToken();
            boolean checkValid = checkValid(editPhone, editPassword, phone, password);
            if (checkValid) {
                view.showDialog();
                userApi = GlobalValue.retrofit.create(UserApi.class);
                Map<String, String> data = new HashMap<>();
                data.put("phone", phone);
                data.put("password", password);
                data.put("androidToken", tokenFirebase);
                Call<JsonElement> call = userApi.verify(data);
                call.enqueue(new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        if (response.code() == 200) {
                            JsonElement responseData = response.body();
                            JsonParser parser = new JsonParser();
                            JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                            JsonObject user = responseObj.get("user").getAsJsonObject();
                            String token = responseObj.get("token").getAsString();

                            Gson gsonSP = new Gson();

                            User userObj = gsonSP.fromJson(user.toString(), User.class);
                            SharedPreferences.Editor editor = context.getSharedPreferences("User", MODE_PRIVATE).edit();
                            //add token
                            editor.putString("token", token);
                            //add profile user
                            editor.putString("name", userObj.getName());
                            editor.putString("id", userObj.getId());
                            editor.putString("gender", userObj.getGender());
                            editor.putString("mail", userObj.getEmail());
                            editor.putString("phone", userObj.getPhone());
                            editor.putString("birthDay", userObj.getDateOfBirth());
                            editor.putString("address", userObj.getAddress());
                            editor.putString("code", userObj.getCode());
                            editor.putString("createTime", userObj.getCreatedTime());
                            editor.putString("photoURL", userObj.getPhotoURL());
                            editor.putInt("account", userObj.getAccount());

                            editor.apply();

                            view.closeDialog();
                            view.changePage();


                        } else {

                            view.loginFailed();
                            view.closeDialog();

                            try {
                                JSONObject errorBody = new JSONObject(response.errorBody().string());
                                String errorMess = errorBody.getString("errorMessage");
                                view.showMessErr(errorMess);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            editPassword.setText("");
                            // editPhone.setText("");

                        }
                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
            } else {
                view.loginFailed();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        GlobalValue.mAuth.signInWithCredential(credential)
                .addOnCompleteListener(view, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = GlobalValue.mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            Toast.makeText(view, "Sign in with google failed", Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(view);
        if (acct != null) {
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String tokenFirebase = FirebaseInstanceId.getInstance().getToken();
            Uri personPhoto = acct.getPhotoUrl();
            userApi = GlobalValue.retrofit.create(UserApi.class);
            Map<String, String> data = new HashMap<>();
            data.put("email", personEmail);
            data.put("personFamilyName", personFamilyName);
            data.put("personGivenName", personGivenName);
            data.put("personPhoto", personPhoto.toString());
            data.put("androidToken", tokenFirebase);

            Call<JsonElement> call = userApi.verifyGoogle(data);
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    if (response.code() == 200) {
                        JsonElement responseData = response.body();
                        JsonParser parser = new JsonParser();
                        JsonObject responseObj = parser.parse(responseData.toString()).getAsJsonObject();
                        JsonObject user = responseObj.get("user").getAsJsonObject();
                        String token = responseObj.get("token").getAsString();

                        Gson gsonSP = new Gson();

                        User userObj = gsonSP.fromJson(user.toString(), User.class);
                        SharedPreferences.Editor editor = view.getSharedPreferences("User", MODE_PRIVATE).edit();
                        //add token
                        editor.putString("token", token);
                        //add profile user
                        editor.putString("name", userObj.getName());
                        editor.putString("id", userObj.getId());
                        editor.putInt("account", userObj.getAccount());
                        editor.putString("gender", userObj.getGender());
                        editor.putString("mail", userObj.getEmail());
                        editor.putString("phone", userObj.getPhone());
                        editor.putString("birthDay", userObj.getDateOfBirth());
                        editor.putString("address", userObj.getAddress());
                        editor.putString("code", userObj.getCode());
                        editor.putString("createTime", userObj.getCreatedTime());
                        editor.putString("photoURL", userObj.getPhotoURL());

                        editor.apply();
                        view.changePage();


                    } else {
                        try {
                            JSONObject errorBody=new JSONObject(response.errorBody().string());
                            Toast.makeText(view, errorBody.getString("errorMessage"), Toast.LENGTH_SHORT).show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
        }
    }


    private boolean checkValid(TextInputEditText editPhone, TextInputEditText editPassword, String phone, String password) {
        boolean valid = true;

        if (phone.isEmpty()) {
            editPhone.setError("Please enter your phone");
            valid = false;
        }

        if (password.isEmpty()) {
            editPassword.setError("Please enter your password");
            valid = false;
        }
        return valid;
    }
}

