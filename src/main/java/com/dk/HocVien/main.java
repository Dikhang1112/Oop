/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dk.HocVien;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AN515-57
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        QuanLyHocVien qlhv = new QuanLyHocVien();
//        System.out.println("Enter the first student: ");
//        qlhv.nhapHocVien();
//        qlhv.displayDs();
        System.out.println("Du lieu hoc sinh doc tu File la:");
        qlhv.docFile("src/main/resources/data.txt");
        qlhv.displayDs();
        System.out.println("Tim kiem hoc sinh theo ma so:");
        qlhv.timKiemTheoMaSo(1).forEach(hv -> System.out.println(hv.getHoTen())); //Lay ho ten cua hoc vien co Id tu truyen
        System.out.println("Tim kiem hoc sinh theo que quan:");
        qlhv.timKiemTheoQueQuan("HCM").forEach(hv -> System.out.println(hv.getHoTen()));
        System.out.println("Danh sach cac hoc vien da duoc sap xep theo diem la:");
        qlhv.sapXepTheoDiemTrungBinh().forEach(hv -> {
            System.out.printf("%s - Diem TB: %f \n",hv.getHoTen(),qlhv.tinhDiemTrungBinh(hv.getDiem()));
        });
        //Xuat thong tin cac hoc sinh duoc hoc bong ra file output
        System.out.println("Ghi danh sach hoc vien co hoc bong vao file output.txt...");
        try (PrintWriter writer = new PrintWriter("src/main/resources/output.txt")) {
            List<HocVien> dsHocBong = qlhv.coHocBong();
            if (dsHocBong.isEmpty()) {
                writer.println("Khong co hoc vien nao du dieu kien hoc bong.");
            } else {
                for (HocVien hv : dsHocBong) {
                    double diemTB = qlhv.tinhDiemTrungBinh(hv.getDiem());
                    writer.printf("%s - %s - %.2f%n", hv.getMaSo(), hv.getHoTen(), diemTB);
                }
            }
            System.out.println("Ghi file thanh cong!");
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
        // Thống kê theo độ tuổi
        System.out.println("Thong ke so luong hoc vien theo do tuoi:");
        Map<String, Long> thongKe = qlhv.thongKeTheoDoTuoi();
        thongKe.forEach((nhomTuoi, soLuong) -> {
            System.out.printf("%s: %d hoc vien%n", nhomTuoi, soLuong);
        });
    }
}
