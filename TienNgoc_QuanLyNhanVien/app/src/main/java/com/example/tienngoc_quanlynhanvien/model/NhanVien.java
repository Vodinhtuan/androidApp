package com.example.tienngoc_quanlynhanvien.model;
import java.io.Serializable;

public class NhanVien implements Serializable {
    private String idnv;
    private String tennv;
    private Boolean gioitinh;

    public NhanVien() {

    }

    public NhanVien(String idnv, String tennv, Boolean gioitinh) {
        this.idnv = idnv;
        this.tennv = tennv;
        this.gioitinh = gioitinh;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
}
