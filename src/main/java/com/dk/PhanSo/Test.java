/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dk.PhanSo;

/**
 *
 * @author AN515-57
 */
public class Test {
    public static void main(String[] args) {
        PhanSo a = new PhanSo (3,6);
        PhanSo b = new PhanSo(7,21);
        PhanSo tong = a.cong(b);
        a.rutGon();
        b.rutGon();
        a.display();
        b.display();
//        tong.display();
          int soSanh = a.soSanh(b);
          if (soSanh == -1)
              System.out.println(" a < b");
          else if (soSanh == 1)
              System.out.println("a > b");
          else
              System.out.println(" a =  b");
    }
    
}
