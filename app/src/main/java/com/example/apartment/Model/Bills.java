package com.example.apartment.Model;

import java.io.Serializable;

public class Bills implements Serializable {
    private String code, type, dateExpired, apartment;
    private int room;
    private String costTotal;

    public Bills(String code, String type, String dateExpired, String apartment, int room, String costTotal) {
        this.code = code;
        this.type = type;
        this.dateExpired = dateExpired;
        this.apartment = apartment;
        this.room = room;
        this.costTotal = costTotal;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getDateExpired() {
        return dateExpired;
    }

    public String getApartment() {
        return apartment;
    }

    public int getRoom() {
        return room;
    }

    public String getCostTotal() {
        return costTotal;
    }
}
