package com.example.apartment.Model;

import java.io.Serializable;

public class Room implements Serializable {
    private String ID,number,address,district,signDate,ExpiredDate,apartmentName,ownerName;
    private int numberUnpayBill,totalBill;

    public Room(String ID, String number, String address, String district, String signDate
            , String expiredDate, String apartmentName, int numberUnpayBill, int totalBill,String ownerName) {
        this.ID = ID;
        this.number = number;
        this.address = address;
        this.district = district;
        this.signDate = signDate;
        ExpiredDate = expiredDate;
        this.apartmentName = apartmentName;
        this.numberUnpayBill = numberUnpayBill;
        this.totalBill = totalBill;
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        ExpiredDate = expiredDate;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public int getNumberUnpayBill() {
        return numberUnpayBill;
    }

    public void setNumberUnpayBill(int numberUnpayBill) {
        this.numberUnpayBill = numberUnpayBill;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }
}
