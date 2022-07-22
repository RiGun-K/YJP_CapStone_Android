package com.example.yjp_capstone.domain;

import java.util.ArrayList;
import java.util.List;


public class Storage {  // 보관소

    private long storageCode;
    private String storageName;
    private String storageZipcode;
    private String storageAddress;
    private String storageDetailAddress;
    private String storageTel;
    private double latitude;//위도
    private double longitude;//경도
    private String storageState = "1";
    private String filename;
    private String filePath;

    private List<StorageBox> storageBoxes = new ArrayList<>();


    public Storage() {
    }


    public long getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(long storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageZipcode() {
        return storageZipcode;
    }

    public void setStorageZipcode(String storageZipcode) {
        this.storageZipcode = storageZipcode;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    public String getStorageDetailAddress() {
        return storageDetailAddress;
    }

    public void setStorageDetailAddress(String storageDetailAddress) {
        this.storageDetailAddress = storageDetailAddress;
    }

    public String getStorageState() {
        return storageState;
    }

    public void setStorageState(String storageState) {
        this.storageState = storageState;
    }

    public String getStorageTel() {
        return storageTel;
    }

    public void setStorageTel(String storageTel) {
        this.storageTel = storageTel;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<StorageBox> getStorageBoxes() {
        return storageBoxes;
    }

    public void setStorageBoxes(List<StorageBox> storageBoxes) {
        this.storageBoxes = storageBoxes;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storageCode=" + storageCode +
                ", storageName='" + storageName + '\'' +
                ", storageZipcode='" + storageZipcode + '\'' +
                ", storageAddress='" + storageAddress + '\'' +
                ", storageDetailAddress='" + storageDetailAddress + '\'' +
                ", storageTel='" + storageTel + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", storageState='" + storageState + '\'' +
                ", filename='" + filename + '\'' +
                ", filePath='" + filePath + '\'' +
                ", storageBoxes=" + storageBoxes +
                '}';
    }
}
