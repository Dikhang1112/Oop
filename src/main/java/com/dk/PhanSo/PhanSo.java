/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dk.PhanSo;

/**
 *
 * @author AN515-57
 */
public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
   
    private int ucln(int a, int b)
    {
        while (b != 0) {   
            int temp = b;
            b= a % b;
            a = temp;
        }
        return Math.abs(a);
    }
    /**
     * @return the tuSo
     */
    public int getTuSo() {
        return tuSo;
    }

    /**
     * @param tuSo the tuSo to set
     */
    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    /**
     * @return the mauSo
     */
    public int getMauSo() {
        return mauSo;
    }

    /**
     * @param mauSo the mauSo to set
     */
    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }
    
    public void display()
    {
        System.out.printf("Phan so cua ban la:%d/%d\n", this.tuSo,this.mauSo);
    }
    public void rutGon() {
        int uc = ucln(this.tuSo,this.mauSo);
        this.tuSo /= uc;
        this.mauSo /= uc;
    }
    //method cong phan so
    public PhanSo cong(PhanSo other)
    {
     int tuTong = this.tuSo* other.mauSo + other.tuSo * this.mauSo;
     int mauTong = this.mauSo * other.mauSo;
     PhanSo ketQua = new PhanSo(tuTong,mauTong);
     ketQua.rutGon();
     return ketQua;
    }
    //So sanh
    public int soSanh(PhanSo ps) {
        // Để so sánh hai phân số a/b và c/d, ta so sánh a*d với b*c
        long tich1 = (long) this.tuSo * ps.mauSo; // Dùng long để tránh tràn số
        long tich2 = (long) this.mauSo * ps.tuSo;

        if (tich1 < tich2) {
            return -1; // Phân số hiện tại nhỏ hơn
        } else if (tich1 > tich2) {
            return 1; // Phân số hiện tại lớn hơn
        } else {
            return 0; // Hai phân số bằng nhau
        }
    }   
 }
