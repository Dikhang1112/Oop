/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dk.HocVien;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author AN515-57
 */
public class QuanLyHocVien {
    private ArrayList<HocVien> ds;

    public QuanLyHocVien() {
        ds = new ArrayList<>();
    }
//     public HocVien nhapHocVien()
//     {
//      Scanner sc = new Scanner (System.in);
//      System.out.print("Enter your name: ");
//      String hoTen = sc.nextLine();
//      System.out.print("Enter your birthday: ");
//      String date = sc.nextLine();
//      Date ngaySinh;
//      try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            ngaySinh = sdf.parse(date);
//        } catch (Exception e) {
//            System.out.println("Your birthday is not valid!!");
//            ngaySinh = null;
//        }
//         System.out.print("Enter your country: ");
//         String queQuan = sc.nextLine();
//         System.out.print("Enter the number of subjects:");
//         int soMon = sc.nextInt();
//         double []diem = new double[soMon];
//         for ( int i = 0; i < soMon; i++)
//         {
//             System.out.printf("Enter score %d:  \n",i + 1);
//             diem[i] = sc.nextDouble();
//         }
//         HocVien hv = new HocVien(hoTen,ngaySinh,queQuan,diem);
//         getDs().add(hv);
//         return hv;
//     }
     
     public void displayDs()
     {
         System.out.println("Danh sach hoc sinh: ");
         for ( HocVien hv : ds)
             hv.display();
     }
     
     public void docFile(String fileName) throws FileNotFoundException {
    try {
        File file = new File(fileName);
        Scanner scFile = new Scanner(file);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (scFile.hasNextLine()) {
            String hoTen = scFile.nextLine();
            if (!scFile.hasNextLine()) {
                System.out.println("Ho ten khong hop le " + hoTen);
                break;
            }
            String queQuan = scFile.nextLine();
            String ngaySinhStr = scFile.nextLine();
            Date ngaySinh;
            try {
                ngaySinh = sdf.parse(ngaySinhStr);
            } catch (Exception e) {
                System.out.println("Ngay sinh khong hop le !!");
                ngaySinh = null;
            }

            String diemStr = scFile.nextLine();
            String[] diemArrStr = diemStr.split("\\s+"); // Tách chuỗi thành mảng các chuỗi con
            double[] diem = new double[3]; // Mảng lưu 3 điểm
            try {
                if (diemArrStr.length != 3) {
                    throw new Exception("Invalid number of scores");
                }
                for (int i = 0; i < 3; i++) {
                    diem[i] = Double.parseDouble(diemArrStr[i]); // Chuyển đổi từ String sang double
                }
            } catch (Exception e) {
                System.out.println("Khong co diem " + hoTen );
                diem = new double[]{0.0, 0.0, 0.0}; // Giá trị mặc định nếu lỗi
            }

            // Tạo học viên và thêm vào danh sách
            HocVien hv = new HocVien(hoTen, ngaySinh, queQuan, diem);
            ds.add(hv);
        }
        scFile.close();
        System.out.println("Doc file thanh cong !!");
    } catch (FileNotFoundException e) {
        System.out.println("Khong tim thay file  : " + fileName);
    }
}
     public List<HocVien> timKiemTheoMaSo(int maSo) {
    return ds.stream().filter(hv -> hv.getMaSo() == maSo).collect(Collectors.toList());
}

// Tìm kiếm theo tên
public List<HocVien> timKiemTheoTen(String ten) {
    return ds.stream().filter(hv -> ten != null && !ten.isEmpty() && hv.getHoTen().toLowerCase().contains(ten.toLowerCase())).collect(Collectors.toList());
}

// Tìm kiếm theo quê quán
public List<HocVien> timKiemTheoQueQuan(String que) {
    return ds.stream().filter(hv -> que != null && !que.isEmpty() && hv.getQueQuan().toLowerCase().contains(que.toLowerCase())).collect(Collectors.toList());
}

//Filter cac hoc sinh duoc hoc bong
public List<HocVien> coHocBong() {
    return ds.stream().filter(hv -> tinhDiemTrungBinh(hv.getDiem()) >= 8).collect(Collectors.toList());
}

public List<HocVien> sapXepTheoDiemTrungBinh() {
    return ds.stream()
            .sorted((hv1, hv2) -> {
                double diemTB1 = tinhDiemTrungBinh(hv1.getDiem());
                double diemTB2 = tinhDiemTrungBinh(hv2.getDiem());
                return Double.compare(diemTB2, diemTB1); // Sắp xếp giảm dần
            }).collect(Collectors.toList());
}
    /**
     * @return the ds
     */
    public ArrayList<HocVien> getDs() {
        return ds;
    }
    
    public double tinhDiemTrungBinh(double []diem)
    {
     if(diem == null || diem.length == 0)
        return 0;
     double tongDiem = 0.0;
     for (double d : diem)
         tongDiem += d;
    return tongDiem / diem.length;
    }
    // Thong ke do tuoi
    public Map<String, Long> thongKeTheoDoTuoi() {
        // Ngày hiện tại (21/03/2025)
        LocalDate ngayHienTai = LocalDate.now();

        // Tạo Map để lưu kết quả thống kê
        Map<String, Long> ketQua = new HashMap<>();

        // Nhóm tuổi < 18
        long soLuongNhoHon18 = ds.stream().filter(hv -> hv.getNgaySinh() != null) .filter(hv -> {
                    LocalDate ngaySinh = hv.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int tuoi = Period.between(ngaySinh, ngayHienTai).getYears();
                    return tuoi < 18;
                })
                .count();
        ketQua.put("Nho hon 18", soLuongNhoHon18);

        // Nhóm tuổi từ 18 đến 23
        long soLuongTu18Den23 = ds.stream().filter(hv -> hv.getNgaySinh() != null).filter(hv -> {
                    LocalDate ngaySinh = hv.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int tuoi = Period.between(ngaySinh, ngayHienTai).getYears();
                    return tuoi >= 18 && tuoi <= 23;
                })
                .count();
        ketQua.put("Tu 18 den 23", soLuongTu18Den23);

        // Nhóm tuổi từ 24 trở lên
        long soLuongTu24TroLen = ds.stream().filter(hv -> hv.getNgaySinh() != null).filter(hv -> {
                    LocalDate ngaySinh = hv.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int tuoi = Period.between(ngaySinh, ngayHienTai).getYears();
                    return tuoi >= 24;
                })
                .count();
        ketQua.put("Tu 24 tro len", soLuongTu24TroLen);
        return ketQua;
    }
           
}
