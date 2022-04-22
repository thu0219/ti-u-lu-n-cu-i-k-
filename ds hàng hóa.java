package "thicuoiki"
 import java.io.file;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.print.Doc;
import javax.sql.rowset.spi.SyncResolver;
public class DanhSachHangHoa {
    static public Scanner input = new Scanner(System.in);
    public List<HangHoa> danhSach = new ArrayList<>();
    public void input(HangHoa hangHoa){
        this.danhSach.add(hangHoa);
    }
    public void printList() {
        for (HangHoa hangHoa : danhSach) {
            System.out.println(hangHoa);
            System.out.println("Kiem Tra Ti Le Dau Ra");
            try {
                hangHoa.kiemTraHSD();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            
        }
    }
    
    public void delete(){
        System.out.println("Vui Long Chon Phuong Phap Xoa:");
        System.out.println("1.Bang Ma      2. Bang Ten ");
        System.out.println("Xin Vui Long Chon: ");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
            input.nextLine();
            System.out.println("Nhap Ma Mat Hang De Xoa:");
            String deleteCode = input.nextLine();
            HangHoa hangHoa1 = null;
            for (HangHoa hangHoa : danhSach) {
                if(hangHoa.getMaHang().equalsIgnoreCase(deleteCode)){
                    hangHoa1 =  hangHoa;
                    break;
                }
            }
            if(hangHoa1 != null){
                danhSach.remove(hangHoa1);
                System.out.println("Muc Da Bi Xoa");
            }else{
                System.out.println("Khong Tim Thay Ma Muc Can Xoa Trong Danh Sach ");
            }
                break;
            case 2:
            input.nextLine();
            System.out.println("Nhap Ten Cua Muc Bi Xoa:");
            String name = input.nextLine();
            HangHoa hangHoa5 = null;
            for (HangHoa hangHoa : danhSach) {
                if(hangHoa.getTenHang().equalsIgnoreCase(name)){
                    hangHoa5 =  hangHoa;
                    break;
                }
            }
            if(hangHoa5 != null){
                danhSach.remove(hangHoa5);
                System.out.println("Muc Da Bi Xoa");
            }else{
                System.out.println("Khong Tim Thay Ma Muc Can Xoa Trong Danh Sach ");
            } break;
            default:System.out.println("Loi Vui Long Thu Lai !!!");
                break;
        }
        
    }
    public void search(){
        
       System.out.println("Vui Long Chon Phuong Phap Tim Kiem:");
       System.out.println("1.Theo Ma Hang     2. Theo Ten Hang    3 .Theo Gia Hang Hoa");
       System.out.println("Moi ban lua chon:");
        int  choose = input.nextInt();
        switch (choose) {
            case 1:
            input.nextLine();
            System.out.println("Nhap ma can tim:");
            String maTim = input.nextLine();
            HangHoa hangHoa3HangHoa = null;
            for (HangHoa hangHoa : danhSach) {
           
                if(hangHoa.getMaHang().equalsIgnoreCase(maTim)){
                    hangHoa3HangHoa =  hangHoa;
                    break;
                }
            } if(hangHoa3HangHoa != null){
                
                System.out.println(hangHoa3HangHoa);
            }else{
                System.out.println("Ma hang hoa can tim trong danh sach khong thay");
            }
            break;
            case 2:
            input.nextLine();
            System.out.println("Nhap ten can tim:");
            String tenTim = input.nextLine();
            HangHoa hangHoa2HangHoa = null;
            for (HangHoa hangHoa : danhSach) {
           
                if(hangHoa.getTenHang().equalsIgnoreCase(tenTim)){
                    hangHoa2HangHoa = hangHoa;
                }
            }
            if(hangHoa2HangHoa != null){
                
                System.out.println(hangHoa2HangHoa);
            }else{
                System.out.println("Ten hang hoa can tim khong thay trong danh sach ");
            }
                break;
            case 3: 
            input.nextLine();
            System.out.println("Nhap gia can tim:");
            double gia = input.nextDouble();
            HangHoa hoaHoa = new HangHoa();
           
                for (HangHoa hangHoa : danhSach) {
                    if(hangHoa.getDonGia() == gia){
                        System.out.println(hangHoa);
                    }
                }
            
           
           break;
           
           
            default: System.out.println("Loi! vui long thuc hien lai");break;
                
        }
        
        
    }
    public void suThongTin(String maHang)  {
        HangHoa hangHoa2 = null;
        for (HangHoa hangHoa : danhSach) {
            if(hangHoa.getMaHang().equalsIgnoreCase(maHang)){
                hangHoa2 = hangHoa;
                break;
            }
        }if(hangHoa2 != null){
            danhSach.remove(hangHoa2);
           
            
        }else{
            System.out.println("Ma hang hoa tim trong danh sach khong thay");
        }
        
    }
    public void statistical(){
        int soLuong = 0;
        double donGia = 0;
        int soLuong1 = 0;
        double donGia1 = 0;
        int soLuong2 = 0;
        double donGia2 = 0;
        for (HangHoa hangHoa : danhSach) {
            if(hangHoa instanceof HangSanhSu){
                soLuong = soLuong + hangHoa.getSoLuongTonKho();
                donGia = donGia + hangHoa.getDonGia()*hangHoa.getSoLuongTonKho();
            }else if(hangHoa instanceof HangDienMay){
                soLuong1 = soLuong1 + hangHoa.getSoLuongTonKho();
                donGia1 = donGia1 + hangHoa.getDonGia()*hangHoa.getSoLuongTonKho();
            }else if(hangHoa instanceof HangThucPham){
                soLuong2 = soLuong2 + hangHoa.getSoLuongTonKho();
                donGia2 = donGia2 + hangHoa.getDonGia()*hangHoa.getSoLuongTonKho();
            }
        }
        System.out.println("        DAY LA THONG KE CAC MAT TON KHO             ");
        System.out.println("------------------------------------------------------");
        System.out.println("Tong so luong hang sanh su con ton kho la: " + soLuong );
        System.out.println("Tong so tien hang sanh su ton kho la: " + donGia);
        System.out.println("Tong so luong hang dien may con ton kho la: " + soLuong1 );
        System.out.println("Tong so tien hang dien may ton kho la: " + donGia1);
        System.out.println("Tong so luong hang thuc pham con ton kho la: " + soLuong2 );
        System.out.println("Tong so tien hang thuc pham ton kho la: " + donGia2);
      
       
    }
    public void arrangeGoods(){
        System.out.println("Lua chon phuong thuc sap xep:");
        System.out.println("1. Theo ma  2. Theo loai hang");
        System.out.println("Moi ban lua chon:");
        int choose = input.nextInt();
        switch(choose){
            case 1:Collections.sort(danhSach, new HangHoa() {
                @Override
                public int compare(HangHoa o1, HangHoa o2) {
                // TODO Auto-generated method stub
                return o1.getMaHang().compareTo(o2.getMaHang()) ;
                
                }
            
                
           }); 
           for (HangHoa hangHoa : danhSach) {
            System.out.println(hangHoa);
            System.out.println("Kiem Tra Ti Le");
            try {
                hangHoa.kiemTraHSD();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            
        }break;
           case 2: 
            System.out.println("Day la hang sanh su");
            System.out.println("_______________________");
           for (HangHoa hangHoa : danhSach) {
               if(hangHoa instanceof HangSanhSu){
                   
                   System.out.println(hangHoa);
               }
           }
           System.out.println("Day la hang dien may");
            System.out.println("________________________");
            for (HangHoa hangHoa : danhSach) {
               if(hangHoa instanceof HangDienMay){
                   
                   System.out.println(hangHoa);
               }
           }
            System.out.println("Day la hang thuc pham");
            System.out.println("_________________________");
            for (HangHoa hangHoa : danhSach) {
               if(hangHoa instanceof HangThucPham){
                   
                    System.out.println(hangHoa);
               }
           }break;
           default : System.out.println("Lua chon sai vui long thuc hien lai");break;
        }
       
    }
     
        
    }