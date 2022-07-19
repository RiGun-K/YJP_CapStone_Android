package com.example.yjp_capstone.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UseStorageBox {
   long storageCode;
   String storageName;
   long boxCode;
   String boxName;
   String boxState;
   long useCode;
   String useState;
   String del;
   String moveUseCode;

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

    public long getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(long boxCode) {
        this.boxCode = boxCode;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public String getBoxState() {
        return boxState;
    }

    public void setBoxState(String boxState) {
        this.boxState = boxState;
    }

    public long getUseCode() {
        return useCode;
    }

    public void setUseCode(long useCode) {
        this.useCode = useCode;
    }

    public String getUseState() {
        return useState;
    }

    public void setUseState(String useState) {
        this.useState = useState;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getMoveUseCode() {
        return moveUseCode;
    }

    public void setMoveUseCode(String moveUseCode) {
        this.moveUseCode = moveUseCode;
    }
}
