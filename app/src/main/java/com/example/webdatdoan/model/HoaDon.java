package com.example.webdatdoan.model;

import java.util.Date;
import java.util.List;

public class HoaDon {
    private String maHoaDon;
    private String maKH;
    private String nhanVienDuyetDon;
    private String nhanVienShip;
    private int trangThai; // tt = 0 : đang vận chuyển; tt = 1 : Đã hoàn thành
    private Date ngayDat;
    private String date;
    private String phuongThucThanhToan;
    private List<HoaDonChiTiet> hoaDonChiTiet;
    private  List<HoaDonGiamGia> hoaDonGiamGias;
    private  String diaChiNhanHang;
    private  String sdtNhanHang;
    private double tongTien;

    public HoaDon(String maHoaDon, String maKH, String ngayDat,  double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maKH = maKH;
        this.date = ngayDat;
        this.tongTien = tongTien;
    }

    public HoaDon(String maHoaDon, String maKH, String nhanVienDuyetDon, String nhanVienShip, int trangThai, Date ngayDat, String phuongThucThanhToan, List<HoaDonChiTiet> hoaDonChiTiet, List<HoaDonGiamGia> hoaDonGiamGias, String diaChiNhanHang, String sdtNhanHang) {
        this.maHoaDon = maHoaDon;
        this.maKH = maKH;
        this.nhanVienDuyetDon = nhanVienDuyetDon;
        this.nhanVienShip = nhanVienShip;
        this.trangThai = trangThai;
        this.ngayDat = ngayDat;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.hoaDonChiTiet = hoaDonChiTiet;
        this.hoaDonGiamGias = hoaDonGiamGias;
        this.diaChiNhanHang = diaChiNhanHang;
        this.sdtNhanHang = sdtNhanHang;
    }


    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getSdtNhanHang() {
        return sdtNhanHang;
    }

    public void setSdtNhanHang(String sdtNhanHang) {
        this.sdtNhanHang = sdtNhanHang;
    }

    public List<HoaDonGiamGia> getHoaDonGiamGias() {
        return hoaDonGiamGias;
    }

    public void setHoaDonGiamGias(List<HoaDonGiamGia> hoaDonGiamGias) {
        this.hoaDonGiamGias = hoaDonGiamGias;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNhanVienDuyetDon() {
        return nhanVienDuyetDon;
    }

    public void setNhanVienDuyetDon(String nhanVienDuyetDon) {
        this.nhanVienDuyetDon = nhanVienDuyetDon;
    }

    public String getNhanVienShip() {
        return nhanVienShip;
    }

    public void setNhanVienShip(String nhanVienShip) {
        this.nhanVienShip = nhanVienShip;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public List<HoaDonChiTiet> getHoaDonChiTiet() {
        return hoaDonChiTiet;
    }

    public void setHoaDonChiTiet(List<HoaDonChiTiet> hoaDonChiTiet) {
        this.hoaDonChiTiet = hoaDonChiTiet;
    }
    public  double getTongTien() {
        return tongTien;
    }

    public void setTongTien( double tongTien) {
        this.tongTien = tongTien;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
