package com.example.apartment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Bills implements Serializable {
    @SerializedName("_id")
    @Expose
    private String id;
    private Apartment apartment;
    private Room room;
    private User user;
    private User manager;
    private String code, type,createdTime,description,status, expiredTime;
    private int total,oldNumber,newNumber,usedNumber;

    public Bills(String id, String code, String type, String createTime, String description, String status, String expiredTime, int total, int oldNumber, int newNumber, int usedNumber) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.createdTime = createTime;
        this.description = description;
        this.status = status;
        this.expiredTime = expiredTime;
        this.total = total;
        this.oldNumber = oldNumber;
        this.newNumber = newNumber;
        this.usedNumber = usedNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreateTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setOldNumber(int oldNumber) {
        this.oldNumber = oldNumber;
    }

    public void setNewNumber(int newNumber) {
        this.newNumber = newNumber;
    }

    public void setUsedNumber(int usedNumber) {
        this.usedNumber = usedNumber;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getId() {
        return id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Room getRoom() {
        return room;
    }

    public User getUser() {
        return user;
    }

    public User getManager() {
        return manager;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getExpiredTime() {
        return expiredTime;
    }

    public int getTotal() {
        return total;
    }

    public int getOldNumber() {
        return oldNumber;
    }

    public int getNewNumber() {
        return newNumber;
    }

    public int getUsedNumber() {
        return usedNumber;
    }
}
