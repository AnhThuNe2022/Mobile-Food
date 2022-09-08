package com.example.webdatdoan.model;

import java.util.Date;

public class GiamGia {
    private String maGiamGia;
    private String tenMaGiam;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private double soTienGiam;
    private String moTa;

    public GiamGia(String maGiamGia, String tenMaGiam, Date ngayBatDau, Date ngayKetThuc, double soTienGiam, String moTa) {
        this.maGiamGia = maGiamGia;
        this.tenMaGiam = tenMaGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soTienGiam = soTienGiam;
        this.moTa = moTa;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getTenMaGiam() {
        return tenMaGiam;
    }

    public void setTenMaGiam(String tenMaGiam) {
        this.tenMaGiam = tenMaGiam;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(double soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
