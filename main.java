package ThiCuoiKy;vuthu2008110121

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static NhapThongTin nhapThongTin = new NhapThongTin(); 
    public static void main(String[] args)    {
        
        int choose;
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        try {
            String ngayNhapKho = "20-11-2001";
            String ngaySX = "21-11-2001";
            String ngayHetHan = "20-12-2001";
        
            HangHoa hangHoa0 = new HangSanhSu("1111", "ly huong", 50000, 50,dateFormat.parse(ngayNhapKho) , "Bui Van Thanh That");
            HangHoa hangHoa1 = new HangDienMay("1112", "may lanh",2000000, 3, 11, 35);
            HangHoa hangHoa2 = new HangThucPham("1113","thit bo", 100000, 5, dateFormat.parse(ngaySX), dateFormat.parse(ngayHetHan));
            HangHoa hangHoa3 = new HangSanhSu("1114", "chen su", 10000, 3,dateFormat.parse(ngayNhapKho), "Bui Van Thanh That");
            HangHoa hangHoa4 = new HangDienMay("1115", "tu lanh", 4000000, 1, 10, 35);
            HangHoa hangHoa5 = new HangThucPham("1116", "thit nguoi", 50000,5, dateFormat.parse(ngaySX), dateFormat.parse(ngayHetHan));
            HangHoa hangHoa6 = new HangSanhSu("1117", "to su",10000, 5, dateFormat.parse(ngayNhapKho),"Bui Van Thanh That");
            HangHoa hangHoa7 = new HangDienMay("1118", "cuc sac", 20000, 5,10, 35);
            HangHoa hangHoa8 = new HangThucPham("1119", "thit ba roi",90000,10,dateFormat.parse(ngaySX), dateFormat.parse(ngayHetHan));
            HangHoa hangHoa9 = new HangSanhSu("1120", "muong su", 20000, 10, dateFormat.parse(ngayNhapKho), "Bui Van Thanh That");
            HangHoa hangHoa10 = new HangDienMay("1121", "may quat phun suong",100000, 10, 11, 35);
            danhSachHangHoa.input(hangHoa0);
            danhSachHangHoa.input(hangHoa1);
            danhSachHangHoa.input(hangHoa2);
            danhSachHangHoa.input(hangHoa3);
            danhSachHangHoa.input(hangHoa4);
            danhSachHangHoa.input(hangHoa5);
            danhSachHangHoa.input(hangHoa6);
            danhSachHangHoa.input(hangHoa7);
            danhSachHangHoa.input(hangHoa8);
            danhSachHangHoa.input(hangHoa9);
            danhSachHangHoa.input(hangHoa10);
       
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        

        do{
            System.out.println("      MENU      ");
            System.out.println("------------------");
            System.out.println("1.Nhap Thong Tin");
            System.out.println("2.In Danh Sach");
            System.out.println("3.Tim Hang");
            System.out.println("4.Xoa Hang");
            System.out.println("5.Sua hang hoa");
            System.out.println("6.Thong Ke");
            System.out.println("7.Phan Loai Hang Hoa");
            System.out.println("8.Luu Tap Tin");
            System.out.println("9.Thoat");
            System.out.println("Xin Vui Long Chon:");
            
            choose = danhSachHangHoa.input.nextInt();
            switch(choose){
                
                case 1: 
                try {
                    HangHoa hangHoa = nhapThongTin.inputHangHoa();
                    danhSachHangHoa.input(hangHoa);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
               
               break;
                case 2:
                System.out.println(); danhSachHangHoa.printList();
                break;
                case 3 : 
                danhSachHangHoa.search();
                break;
                case 4: 
                danhSachHangHoa.delete();
                break;
                case 5:
                danhSachHangHoa.input.nextLine();
                System.out.println("Nhap Ma De Sua:");
                String maHang1 = danhSachHangHoa.input.nextLine();
                danhSachHangHoa.suThongTin(maHang1);
                System.out.println("Menu sua thong tin:");
                try {
                    HangHoa hangHoa3HangHoa = nhapThongTin.inputHangHoa();
                    danhSachHangHoa.input(hangHoa3HangHoa);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
                break;
                
                 
                case 6: danhSachHangHoa.statistical();break;
                case 7 : danhSachHangHoa.arrangeGoods();break;
                case 8 :  break;
               
                case 9:  System.out.println("Goodbye");break;
                default: System.out.println("Loi Vui Long Nhap Lai!!!");break;
            }
        }while(choose != 9);
        // nhap
       
      
       
        
      
       
    }

        
    
}