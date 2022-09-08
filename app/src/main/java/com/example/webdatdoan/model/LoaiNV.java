package com.example.webdatdoan.model;

public class LoaiNV {

    private String MaLoaiNV;
    private String TenLoaiNV;
    private int SoLuongNV;

    public LoaiNV(String maLoaiNV, String tenLoaiNV, int soLuongNV) {
        MaLoaiNV = maLoaiNV;
        TenLoaiNV = tenLoaiNV;
        SoLuongNV = soLuongNV;
    }

    public void setMaLoaiNV(String maLoaiNV) {
        MaLoaiNV = maLoaiNV;
    }

    public void setTenLoaiNV(String tenLoaiNV) {
        TenLoaiNV = tenLoaiNV;
    }

    public void setSoLuongNV(int soLuongNV) {
        SoLuongNV = soLuongNV;
    }

    public String getMaLoaiNV() {
        return MaLoaiNV;
    }

    public String getTenLoaiNV() {
        return TenLoaiNV;
    }

    public int getSoLuongNV() {
        return SoLuongNV;
    }
}
