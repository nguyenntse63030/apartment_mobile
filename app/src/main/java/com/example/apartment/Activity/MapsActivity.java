package com.example.apartment.Activity;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.apartment.Contract.MapActivityContract;
import com.example.apartment.Presenter.MapActivityPresenterImpl;
import com.example.apartment.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapActivityContract.MapActivityPresenter presenter;
    private RadioGroup radioGroupType,radioGroupApartment;
    private RadioButton btnFood,btnHospital,btnSchool,btnRestaurant,btnQuocCuong,btnIHome;
    public static final LatLng IHome = new LatLng(10.8350545,106.7974577);
    public static final  LatLng QuocCuong = new LatLng(10.869500, 106.686694);
    private LatLng latLngApartment=QuocCuong;
    private String placeType = "food";
    private Button btnFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        btnFood = findViewById(R.id.btnFood);
        btnHospital = findViewById(R.id.btnHospital);
        btnSchool = findViewById(R.id.btnSchool);
        btnRestaurant = findViewById(R.id.btnRestaurant);
        btnQuocCuong = findViewById(R.id.btnQuocCuong);
        btnIHome = findViewById(R.id.btnIHome);
        radioGroupApartment = findViewById(R.id.radioGroupApartment);
        radioGroupType = findViewById(R.id.radioGroupType);
        btnFind = findViewById(R.id.btnFind);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        presenter = new MapActivityPresenterImpl(mMap,this);
        presenter.viewMap(latLngApartment,placeType);
        btnQuocCuong.setChecked(true);
        btnFood.setChecked(true);
        radioGroupApartment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btnIHome:{
                        latLngApartment=IHome;
                        break;
                    }
                    case R.id.btnQuocCuong:{
                        latLngApartment=QuocCuong;
                        break;
                    }
                }
            }
        });
        radioGroupType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btnFood:{
                        placeType="food";
                        break;
                    }
                    case R.id.btnHospital:{
                        placeType="hospital";
                        break;
                    }
                    case R.id.btnRestaurant:{
                        placeType="restaurant";
                        break;
                    }
                    case R.id.btnSchool:{
                        placeType="school";
                        break;
                    }
                }
            }
        });
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.viewMap(latLngApartment,placeType);
            }
        });
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void clickToBack(View view) {
        finish();
    }
}
