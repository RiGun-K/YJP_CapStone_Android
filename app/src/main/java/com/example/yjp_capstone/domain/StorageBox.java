package com.example.yjp_capstone.domain;

public class StorageBox {

    private long storageBoxCode;

    private Storage storageCode;

    private String storageBoxName;

    private String storageBoxType;

    private int storageBoxPrice;

    private String storageBoxState ;

    public StorageBox() {
    }

    public long getStorageBoxCode() {
        return storageBoxCode;
    }

    public void setStorageBoxCode(long storageBoxCode) {
        this.storageBoxCode = storageBoxCode;
    }

    public Storage getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(Storage storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageBoxName() {
        return storageBoxName;
    }

    public void setStorageBoxName(String storageBoxName) {
        this.storageBoxName = storageBoxName;
    }

    public String getStorageBoxType() {
        return storageBoxType;
    }

    public void setStorageBoxType(String storageBoxType) {
        this.storageBoxType = storageBoxType;
    }

    public int getStorageBoxPrice() {
        return storageBoxPrice;
    }

    public void setStorageBoxPrice(int storageBoxPrice) {
        this.storageBoxPrice = storageBoxPrice;
    }

    public String getStorageBoxState() {
        return storageBoxState;
    }

    public void setStorageBoxState(String storageBoxState) {
        this.storageBoxState = storageBoxState;
    }
}



