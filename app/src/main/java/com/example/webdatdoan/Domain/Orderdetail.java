package com.example.webdatdoan.Domain;

public class Orderdetail {
    private  String tenMonAn;
    private int soLuong;
    private double donGia;
    private int anh;

    public Orderdetail(String tenMonAn, int soLuong, double donGia, int anh) {
        this.tenMonAn = tenMonAn;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.anh = anh;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
