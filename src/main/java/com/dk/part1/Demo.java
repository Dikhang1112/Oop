/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.dk.part1;

/**
 *
 * @author AN515-57
 */
public class Demo {

    public static void main(String[] args) {
        Diem A = new Diem(5.2,5);
        Diem B = new Diem (2,5);
        Diem C = new Diem (1,2);
        Diem D = new Diem (3,2);
        A.display();
//      double kc  =  A.distance(B);
//        System.out.println("Khoang cach cua 2 diem la:" + kc);
        DoanThang AB = new DoanThang(A,B);
        DoanThang CD = new DoanThang (C,D);
//          double kc = AB.calLength();
//          System.out.println("Do dai cua doan thang la:" + kc);
//          //Tinh trung diem cua doan thang
//          AB.trungDiem().display();
            if(AB.isParallel(CD))
                System.out.println("2 doan thang nay song song");
            else
                System.out.println("2 doan thang nay khong song song");
          
    }
}
