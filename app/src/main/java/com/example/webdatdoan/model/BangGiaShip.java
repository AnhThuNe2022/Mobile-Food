package com.example.webdatdoan.model;


public class BangGiaShip {

    private String maShip;
    private String khoangCach;
    private double soTien;

    public BangGiaShip(String maShip, String khoangCach, double soTien) {
        this.maShip = maShip;
        this.khoangCach = khoangCach;
        this.soTien = soTien;
    }

    public String getMaShip() {
        return maShip;
    }

    public void setMaShip(String maShip) {
        this.maShip = maShip;
    }

    public String getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(String khoangCach) {
        this.khoangCach = khoangCach;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
}
