/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enterti;

public class KhachHang {
    public int id;
    public String ten;
    public String diaChi;
    public String sdt;

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public KhachHang(int id, String ten, String diaChi, String sdt) {
        setId(id);
        setTen(ten);
        setDiaChi(diaChi);
        setSdt(sdt);
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID khách hàng phải là số nguyên không âm.");
        }
        this.id = id;
    }

    public void setTen(String ten) {
        if (ten == null || ten.length() < 1 || ten.length() > 10) {
            throw new IllegalArgumentException("Tên khách hàng phải là một chuỗi có độ dài từ 1 đến 10 ký tự.");
        }
        this.ten = ten;
    }

    public void setDiaChi(String diaChi) {
        // Bạn có thể thêm kiểm tra địa chỉ ở đây nếu cần thiết
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        // Bạn có thể thêm kiểm tra số điện thoại ở đây nếu cần thiết
        this.sdt = sdt;
    }

    // Các phương thức khác của lớp KhachHang

    public static void main(String[] args) {
        // Sử dụng lớp KhachHang
        try {
            KhachHang khachHang = new KhachHang(201, "Alice", "123 Main Street", "0123456789");
            System.out.println("Khách hàng được tạo thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
