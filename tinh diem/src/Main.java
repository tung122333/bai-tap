import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nhap diem chuyen can: ");
        double diemChuyenCan = scanner.nextDouble();

        System.out.print("nhap diem giua ky: ");
        double diemGiuaKy = scanner.nextDouble();

        System.out.print("nhap diem cuoi ky: ");
        double diemCuoiKy = scanner.nextDouble();

        double diemTongKet = diemChuyenCan * 0.1 + diemGiuaKy * 0.3 + diemCuoiKy * 0.6;

        System.out.printf("diem tong ket: %.2f\n", diemTongKet);
        scanner.close();
    }
}