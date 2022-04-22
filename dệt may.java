package thicuoiky;vuthu2008110121
import java.util.Date;

public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanhTheoThang;
    private double congSuat;
    
    
    

    
    public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTonKho, int thoiGianBaoHanhTheoThang,
            double congSuat) {
        super(maHang, tenHang, donGia, soLuongTonKho);
        this.thoiGianBaoHanhTheoThang = thoiGianBaoHanhTheoThang;
        this.congSuat = congSuat;
    }



    public HangDienMay(int thoiGianBaoHanhTheoThang, double congSuat) {
        this.thoiGianBaoHanhTheoThang = thoiGianBaoHanhTheoThang;
        this.congSuat = congSuat;
    }



    public HangDienMay() {
    }
    
    

    public int getThoiGianBaoHanhTheoThang() {
        return thoiGianBaoHanhTheoThang;
    }

    public void setThoiGianBaoHanhTheoThang(int thoiGianBaoHanhTheoThang) {
        if(thoiGianBaoHanhTheoThang >= 0){
            this.thoiGianBaoHanhTheoThang = thoiGianBaoHanhTheoThang;
        }else{
            System.out.println("Thoi Gian Bao Hanh Lon Hon 0!!!");
        }
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        if(congSuat > 0){
            this.congSuat = congSuat;
        }else{
            System.out.println("Quyen Luc Phai Lon Hon 0!!!");
        }
    }

    @Override
    public double tinhTien() {
        // TODO Auto-generated method stub
        double tien = 0;
        tien = this.getDonGia() * 0.1;
        return tien;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Hang dien may " + super.toString() + " Thoi gian bao hanh: " +thoiGianBaoHanhTheoThang +" CongSuat: " + congSuat + " thue: " + tinhTien()  + " ]";
    }

    @Override
    public void kiemTraHSD() {
        // TODO Auto-generated method stub
        
        if(this.getSoLuongTonKho() < 3){
            System.out.println("Hang Ban Chay!!!");
        }else{
            System.out.println("Hang Ban Cham !!!");
        }
    }



   
    
    
    
    
}