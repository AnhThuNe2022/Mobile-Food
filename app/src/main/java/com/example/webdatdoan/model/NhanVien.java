package com.example.webdatdoan.model;

import java.util.Date;

public class NhanVien {

    private String maNV;
    private String tenNV;
    private LoaiNV loaiNV;
    private String diaChi;
    private int gioiTinh;
    private Date ngaySinh;
    private String CMND;

    public NhanVien(String maNV, String tenNV, LoaiNV loaiNV, String diaChi, int gioiTinh, Date ngaySinh, String CMND) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.loaiNV = loaiNV;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.CMND = CMND;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public LoaiNV getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(LoaiNV loaiNV) {
        this.loaiNV = loaiNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }
}
