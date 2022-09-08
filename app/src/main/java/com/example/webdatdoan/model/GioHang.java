package com.example.webdatdoan.model;

import java.util.List;

public class GioHang {
    private MonAn monAn;
    private int soLuong;

    public GioHang(MonAn monAn, int soLuong) {
        this.monAn = monAn;
        this.soLuong = soLuong;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
