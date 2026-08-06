import java.util.ArrayList;
import java.util.Scanner;

// Yeukau 1: Lop Nguoi de quan ly cac thong tin ca nhan cua moi giao vien
class Nguoi {
    protected String hoTen;
    protected int tuoi;
    protected String queQuan;
    protected String maSoGV;

    public Nguoi() {}

    public Nguoi(String hoTen, int tuoi, String queQuan, String maSoGV) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.maSoGV = maSoGV;
    }

    public String getMaSoGV() {
        return maSoGV;
    }

    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap que quan: ");
        queQuan = sc.nextLine();
        System.out.print("Nhap ma so GV: ");
        maSoGV = sc.nextLine();
    }

    public void hienThiThongTin() {
        System.out.println("Ma GV: " + maSoGV + " | Ho ten: " + hoTen + " | Tuoi: " + tuoi + " | Que quan: " + queQuan);
    }
}

// Yeukau 2 & Yeukau 4: Lop CBGV ke thua Nguoi, tinh luong thuc linh
class CBGV extends Nguoi {
    private double luongCung;
    private double luongThuong;
    private double tienPhat;
    private double luongThucLinh;

    public CBGV() {}

    public CBGV(String hoTen, int tuoi, String queQuan, String maSoGV, double luongCung, double luongThuong, double tienPhat) {
        super(hoTen, tuoi, queQuan, maSoGV);
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.tienPhat = tienPhat;
        tinhLuongThucLinh();
    }

    // Yeukau 4: Thuc linh = luong cung + luong thuong - luong phat
    public double tinhLuongThucLinh() {
        luongThucLinh = luongCung + luongThuong - tienPhat;
        return luongThucLinh;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhap luong cung: ");
        luongCung = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap luong thuong: ");
        luongThuong = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap tien phat: ");
        tienPhat = Double.parseDouble(sc.nextLine());
        tinhLuongThucLinh();
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("-> Luong cung: " + luongCung + " | Thuong: " + luongThuong + " | Phat: " + tienPhat + " => Thuc linh: " + tinhLuongThucLinh());
    }
}

// Yeukau 3: Lop quan ly cac can bo giang vien (them, xoa)
class QuanLyCBGV {
    private ArrayList<CBGV> ds = new ArrayList<>();

    // Them can bo giang vien
    public void them(CBGV cbgv) {
        ds.add(cbgv);
        System.out.println("Them can bo giang vien thanh cong!");
    }

    // Xoa can bo giang vien theo ma so GV
    public void xoa(String maSoGV) {
        boolean timThay = false;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaSoGV().equalsIgnoreCase(maSoGV)) {
                ds.remove(i);
                timThay = true;
                System.out.println("Xoa thanh cong giang vien co ma so: " + maSoGV);
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay giang vien co ma so: " + maSoGV);
        }
    }

    // Hien thi danh sach giang vien va luong thuc linh
    public void hienThi() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach giang vien trong!");
            return;
        }
        System.out.println("\n DANH SACH CAN BO GIANG VIEN");
        for (CBGV cbgv : ds) {
            cbgv.hienThiThongTin();
        }
    }
}

// Lop Main chua phuong thuc main
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyCBGV ql = new QuanLyCBGV();

        while (true) {
            System.out.println("1. Them can bo giang vien");
            System.out.println("2. Xoa can bo giang vien theo ma so GV");
            System.out.println("3. Hien thi danh sach & luong");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    CBGV cbgv = new CBGV();
                    cbgv.nhapThongTin(sc);
                    ql.them(cbgv);
                    break;
                case 2:
                    System.out.print("Nhap ma so GV can xoa: ");
                    String ma = sc.nextLine();
                    ql.xoa(ma);
                    break;
                case 3:
                    ql.hienThi();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}