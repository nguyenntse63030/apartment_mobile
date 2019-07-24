package com.example.apartment.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.apartment.Contract.MapActivityContract;
import com.example.apartment.Map.GetNearbyPlacesData;
import com.example.apartment.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivityPresenterImpl implements MapActivityContract.MapActivityPresenter {
    private GoogleMap mMap;
    private Context context;

    public MapActivityPresenterImpl(GoogleMap mMap, Context context) {
        this.mMap = mMap;
        this.context = context;
    }


    private String getUrl(double latitude, double longitude, String nearbyPlace) {
        String googlePlacesUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        googlePlacesUrl += "location=" + latitude + "," + longitude;
        googlePlacesUrl += "&radius=" + "3000";
        googlePlacesUrl += "&type=" + nearbyPlace;
        googlePlacesUrl += "&sensor=true";
        googlePlacesUrl += "&key=" + context.getString(R.string.google_maps_key);
        Log.d("getUrl", googlePlacesUrl);
        return (googlePlacesUrl);
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//    }

    @Override
    public void viewMap(LatLng latLng, String placeType) {
        mMap.clear();
//        Location location = getMyLocation();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng , 17));
        mMap.addMarker(new MarkerOptions().position(latLng));
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();
        String url = getUrl(latLng.latitude, latLng.longitude, placeType);
        Object[] DataTransfer = new Object[2];
        DataTransfer[0] = mMap;
        DataTransfer[1] = url;
        getNearbyPlacesData.execute(DataTransfer);
    }

}
