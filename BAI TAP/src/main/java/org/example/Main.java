package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sinh vien: ");
        String maSV = sc.nextLine();

        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();

        double diemCC = nhapDiem(sc, "Diem chuyen can");
        double diemGK = nhapDiem(sc, "Diem giua ky");
        double diemCK = nhapDiem(sc, "Diem cuoi ky");

        double diemTK = tinhDiemTongKet(diemCC, diemGK, diemCK);
        String xepLoai = xepLoai(diemTK);

        System.out.println("\nKet qua:");
        System.out.printf("%s - %s - %.2f - %s\n", maSV, hoTen, diemTK, xepLoai);
    }

    public static double tinhDiemTongKet(double diemCC, double diemGK, double diemCK) {
        return diemCC * 0.10 + diemGK * 0.30 + diemCK * 0.60;
    }

    public static String xepLoai(double diemTK) {
        if (diemTK >= 8.5) {
            return "A";
        } else if (diemTK >= 7.0) {
            return "B";
        } else if (diemTK >= 5.5) {
            return "C";
        } else if (diemTK >= 4.0) {
            return "D";
        } else {
            return "F";
        }
    }

    public static double nhapDiem(Scanner sc, String tenDiem) {
        double diem;
        while (true) {
            System.out.print("Nhap diem " + tenDiem + ": ");
            diem = sc.nextDouble();
            if (diem >= 0 && diem <= 10) {
                return diem;
            }
            System.out.println("Diem " + diem + " khong hop le vui long nhap lai .");
        }
    }
}
