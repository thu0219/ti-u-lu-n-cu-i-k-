package ThiCuoiKy;vuthu2008110121

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NhapThongTin   {
    static  
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static HangHoa hangHoa = new HangSanhSu();
    public Scanner input = new Scanner(System.in);

    public HangHoa inputHangHoa() throws ParseException  {
        int choose;
        HangHoa hangHoa = null;
        System.out.println("Vui Long Chon Hang De Nhap");
        System.out.println("-------------------------------------");
        System.out.println("1.Hang Sanh Su ");
        System.out.println("2.Hang Dien May");
        System.out.println("3.Hang Thuc Pham");
        System.out.println("4.Thoat");
        System.out.println("Xin Vui Long Chon:");
        choose = input.nextInt();
        switch(choose){
            case 1:
            input.nextLine();
            System.out.println("Nhap Ma Hang:");
            String commodityCodes = input.nextLine();
            System.out.println("Nhap Ten Hang:");
            String goodsName =input.nextLine();
            System.out.println("Nhap Gia:");
            Double price = input.nextDouble();
            System.out.println("Nhap So Luong Hang Ton Kho:");
            int quantityInStock = input.nextInt();
            System.out.println("Nhap Ngay Kho Theo Dinh Dang dd-MM-yyyy: ");
            
            String date = input.next();
           
            Date date2 = null;
            try {
                //Parsing the String
                date2 = dateFormat.parse(date);
                input.nextLine();
                System.out.println("Nhap nha san xuat:");
                String nhaSX = input.nextLine();
                hangHoa = new HangSanhSu(commodityCodes, goodsName, price, quantityInStock, dateFormat.parse(date), nhaSX);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
            break;
            case 2: 
            input.nextLine();
            System.out.println("Nhap Ma Hang:");
            String commodityCodes2 = input.nextLine();
            System.out.println("Nhap Ten Hang:");
            String goodsName2 =input.nextLine();
            System.out.println("Nhap Gia:");
            Double price2 = input.nextDouble();
            System.out.println("Nhap So Luong Hang Ton Kho:");
            int quantityInStock2 = input.nextInt();
            System.out.println("Nhap So Thang Bao Hanh:");
            int thoiGianBaoHanhTheoThang = input.nextInt();
            System.out.println("Nhap Dung Luong:");
            double congSuat = input.nextDouble();
            hangHoa = new HangDienMay(commodityCodes2, goodsName2, price2, quantityInStock2, thoiGianBaoHanhTheoThang, congSuat);
            
            break;
            case 3:
            input.nextLine();
            System.out.println("Nhap Ma Hang:");
            String commodityCodes3 = input.nextLine();
            System.out.println("Nhap Ten Hang:");
            String goodsName3 =input.nextLine();
            System.out.println("Nhap Gia:");
            Double price3 = input.nextDouble();
            System.out.println("Nhap So Luong Hang Ton Kho:");
            int quantityInStock3 = input.nextInt();
            input.nextLine();
            System.out.println("Nhap Ngay San Xuat Theo dd-MM-yyyy: ");
            String ngaySX = input.nextLine();
            Date date3 = null;
            try {
                //Parsing the String
                date3 = dateFormat.parse(ngaySX);
               } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Nhap Ngay Het Han by dd-MM-yyyy: ");
            String ngayHetHan = input.nextLine();
            try {
                date2 = dateFormat.parse(ngayHetHan);
               
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
           hangHoa = new HangThucPham(commodityCodes3, goodsName3, price3, quantityInStock3, dateFormat.parse(ngaySX), dateFormat.parse(ngayHetHan));
            break;
            case 4: System.out.println("Hen Gap Lai!!!"); break;
            default: System.out.println("Ban Da Lua Chon Sai,Hay Thu Lai!!!");
        }

    
            return hangHoa;
       
    }
    
    
}