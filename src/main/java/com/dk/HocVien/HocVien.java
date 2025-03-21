/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dk.HocVien;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AN515-57
 */
public class HocVien {
    private static int counter = 0;
    private  int maSo;
    private String hoTen;
    private Date ngaySinh;
    private String queQuan;
    private double []diem;
    
    {
     counter ++;
     this.setMaSo(counter);
    }

    public HocVien( String hoTen, Date ngaySinh, String queQuan, double[] diem) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;                                                        
        this.diem = diem;
    }

    public HocVien(String hoTen, Date ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }
   
    
    public void display() {
        System.out.println("Id : " + maSo);
        System.out.println("Your name : " + hoTen);
        System.out.println("Birthday : " + (ngaySinh != null ? new SimpleDateFormat("dd/MM/yyyy").format(ngaySinh) : "Not valid"));
        System.out.println("Country : " + queQuan);
        if (diem != null) {
            for (int i = 0; i < diem.length; i++) {
                System.out.println("Subject score " + (i + 1) + ": " + diem[i]);
            }
        } else {
            System.out.println("No have score");
        }
        System.out.println("------------------------------");
    }

    /**
     * @return the maSo
     */
    public int getMaSo() {
        return maSo;
    }

    /**
     * @param maSo the maSo to set
     */
    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the diem
     */
    public double[] getDiem() {
        return diem;
    }

    /**
     * @param diem the diem to set
     */
    public void setDiem(double[] diem) {
        this.diem = diem;
    }

   
}
