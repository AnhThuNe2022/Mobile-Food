package com.example.webdatdoan.model;

public class TaiKhoan {
    private String SDT;
    private String matKhau;
    private KhachHang khachHang;


    public TaiKhoan(String SDT, String matKhau, KhachHang khachHang) {
        this.SDT = SDT;
        this.matKhau = matKhau;
        this.khachHang = khachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
