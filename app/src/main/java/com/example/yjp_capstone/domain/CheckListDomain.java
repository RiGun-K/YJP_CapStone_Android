package com.example.yjp_capstone.domain;

public class CheckListDomain {
    String itemName;
    boolean status;

    public CheckListDomain(String itemName, boolean status) {
        this.itemName = itemName;
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
