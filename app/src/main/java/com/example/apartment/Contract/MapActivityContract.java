package com.example.apartment.Contract;

import com.google.android.gms.maps.model.LatLng;

public class MapActivityContract {
    public interface MapActivityPresenter{
        void viewMap(LatLng latLng,String place);
    }
}
