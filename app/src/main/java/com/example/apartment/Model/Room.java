package com.example.apartment.Model;

public class Room {
    private String ID,number,address,district,date,numberUnpayBill,apartmentName;

    public Room(String ID, String number, String address, String district, String date, String numberUnpayBill, String apartmentName) {
        this.ID = ID;
        this.number = number;
        this.address = address;
        this.district = district;
        this.date = date;
        this.numberUnpayBill = numberUnpayBill;
        this.apartmentName = apartmentName;
    }

    public String getID() {
        return ID;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getDate() {
        return date;
    }

    public String getNumberUnpayBill() {
        return numberUnpayBill;
    }

    public String getApartmentName() {
        return apartmentName;
    }
}
