package enterti;

import java.io.Serializable;

public class HangHoa implements Serializable{
    public int id;
    public String ten;
    public String time;
    public float gia;
    public int idKH;

    public HangHoa(int id, String ten, String time, float gia, int idKH) {
        setid(id);
        setten(ten);
        settime(time);
        setgia(gia);
        setidKH(idKH);
    }

    public void setid(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Mã hàng hóa phải là số nguyên không âm.");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getTime() {
        return time;
    }

    public float getGia() {
        return gia;
    }

    public int getIdKH() {
        return idKH;
    }

    public int getid() {
        return id;
    }

    public String getten() {
        return ten;
    }

    public String gettime() {
        return time;
    }

    public float getgia() {
        return gia;
    }

    public int getidKH() {
        return idKH;
    }

    public void setten(String ten) {
        if (ten == null || ten.length() < 1 || ten.length() > 10) {
            throw new IllegalArgumentException("Tên hàng hóa phải là một chuỗi có độ dài từ 1 đến 10 ký tự.");
        }
        this.ten = ten;
    }

    public void settime(String time) {
        // Bạn có thể thêm kiểm tra thời gian vào kho ở đây nếu cần thiết
        this.time = time;
    }

    public void setgia(float gia) {
        if (gia < 0) {
            throw new IllegalArgumentException("Giá trị hàng hóa phải là số không âm.");
        }
        this.gia = gia;
    }

    public void setidKH(int idKH) {
        if (idKH < 0) {
            throw new IllegalArgumentException("ID khách hàng phải là số nguyên không âm.");
        }
        this.idKH = idKH;
    }

    // Các phương thức khác của lớp HangHoa

    public static void main(String[] args) {
        // Sử dụng lớp HangHoa
        try {
            HangHoa hangHoa = new HangHoa(1, "Sách", "2024-01-13", 50.0f, 101);
            System.out.println("Hàng hóa được tạo thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
