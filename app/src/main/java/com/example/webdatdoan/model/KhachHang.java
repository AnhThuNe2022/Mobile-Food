package com.example.webdatdoan.model;

import java.util.Date;
import java.util.List;

public class KhachHang {

    private  String maKH;
    private  String tenKH;
    private  String diaChi;
    private int gioiTinh; // Nam = 1, Nữ = 0;
    private Date ngaySinh;
    private List<GioHang> listGioHang;

    public KhachHang(String maKH, String tenKH, String diaChi, int gioiTinh, Date ngaySinh, List<GioHang> listGioHang) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.listGioHang = listGioHang;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public List<GioHang> getListGioHang() {
        return listGioHang;
    }

    public void setListGioHang(List<GioHang> listGioHang) {
        this.listGioHang = listGioHang;
    }
}
