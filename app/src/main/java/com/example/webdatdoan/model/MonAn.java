package com.example.webdatdoan.model;

public class MonAn {
    private String maMonAn;
    private String tenMonAn;
    private String loaiMonAn;
    private String moTa;
    private int soLuongTonKho;
    private String anh;
    private Double donGia;
    private String donViTinh;

    public MonAn(String tenMonAn, String loaiMonAn, String moTa, int soLuongTonKho, String anh, Double donGia, String donViTinh) {
        this.tenMonAn = tenMonAn;
        this.loaiMonAn = loaiMonAn;
        this.moTa = moTa;
        this.soLuongTonKho = soLuongTonKho;
        this.anh = anh;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
    }

    public MonAn(String maMonAn, String tenMonAn, String loaiMonAn, String moTa, int soLuongTonKho, String anh, Double donGia, String donViTinh) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.loaiMonAn = loaiMonAn;
        this.moTa = moTa;
        this.soLuongTonKho = soLuongTonKho;
        this.anh = anh;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
    }


    public String getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(String loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
}
