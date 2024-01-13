package enterti;

import java.io.Serializable;

public class NhanVien  implements Serializable{
    public int Id;
    public String ten;
    public String begin;
    public float luong;

    public NhanVien(int Id, String ten, String begin, float luong) {
        setId(Id);
        setten(ten);
        setbegin(begin);
        setLuong(luong);
    }

    public void setId(int Id) {
        if (Id < 0) {
            throw new IllegalArgumentException("Mã nhân viên phải là số nguyên không âm.");
        }
        this.Id= Id;
    }

    public void setten(String ten) {
        if (ten == null || ten.length() < 1 || ten.length() > 10) {
            throw new IllegalArgumentException("Tên nhân viên phải là một chuỗi có độ dài từ 1 đến 10 ký tự.");
        }
        this.ten = ten;
    }

    public void setbegin(String begin) {
        // Bạn có thể thêm kiểm tra thời gian vào làm ở đây nếu cần thiết
        this.begin = begin;
    }

    public void setLuong(float luong) {
        if (luong < 0) {
            throw new IllegalArgumentException("Lương nhân viên phải là số không âm.");
        }
        this.luong = luong;
    }

    // Các phương thức khác của lớp NhanVien

    public static void main(String[] args) {
        // Sử dụng lớp NhanVien
        try {
            NhanVien nhanVien = new NhanVien(101, "John", "2024-01-13", 5000.0f);
            System.out.println("Nhân viên được tạo thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    

    public String getTen() {
        return ten;
    }

    public String getBegin() {
        return begin;
    }

    public float getLuong() {
        return luong;
    }

    Integer getId() {
        return Id;
    }
}
