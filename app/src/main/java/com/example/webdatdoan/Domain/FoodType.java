package com.example.webdatdoan.Domain;

public class FoodType {

String maLoaiMonAn;
String TenLoaiMoAn;

    public FoodType(String maLoaiMonAn, String tenLoaiMoAn) {
        this.maLoaiMonAn = maLoaiMonAn;
        TenLoaiMoAn = tenLoaiMoAn;
    }

    public String getMaLoaiMonAn() {
        return maLoaiMonAn;
    }

    public void setMaLoaiMonAn(String maLoaiMonAn) {
        this.maLoaiMonAn = maLoaiMonAn;
    }

    public String getTenLoaiMoAn() {
        return TenLoaiMoAn;
    }

    public void setTenLoaiMoAn(String tenLoaiMoAn) {
        TenLoaiMoAn = tenLoaiMoAn;
    }
}
