package com.example.apartment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Room implements Serializable {
    @SerializedName("_id")
    @Expose
    private String id;
    private String roomNumber;
    private String code;
    private User user;
    private Apartment apartment;
    private String unpayBill, totalBill;
    private String signDate, expiredDate;

    public String getUnpayBill() {
        return unpayBill != null ? unpayBill : "0";
    }

    public void setUnpayBill(String unpayBill) {
        this.unpayBill = unpayBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public String getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCode() {
        return code;
    }

    public String getTotalBill() {
        return totalBill!=null?totalBill : "0";
    }

    public String getSignDate() {
        return signDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public Room(String id, String roomNumber, String code, String unpayBill, String totalBill, String signDate, String expiredDate) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.code = code;
        this.unpayBill = unpayBill;
        this.totalBill = totalBill;
        this.signDate = signDate;
        this.expiredDate = expiredDate;
    }
}
