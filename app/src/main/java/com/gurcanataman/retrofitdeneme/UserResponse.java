package com.gurcanataman.retrofitdeneme;

/**
 * Created by gurcanataman on 27.11.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("hata")
    @Expose
    private Boolean hata;
    @SerializedName("mesaj")
    @Expose
    private String mesaj;
    @SerializedName("code")
    @Expose
    private String code;

    public Boolean getHata() {
        return hata;
    }

    public void setHata(Boolean hata) {
        this.hata = hata;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}