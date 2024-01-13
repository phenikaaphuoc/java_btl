package enterti;
import java.util.HashMap;
import java.util.Map;

public class EntityManager {
    private Map<Integer, HangHoa> hangHoaMap;
    private Map<Integer, NhanVien> nhanVienMap;
    private Map<Integer, KhachHang> khachHangMap;

    public EntityManager() {
        this.hangHoaMap = new HashMap<>();
        this.nhanVienMap = new HashMap<>();
        this.khachHangMap = new HashMap<>();
    }

    // Phương thức thêm đối tượng vào EntityManager
    public void addHangHoa(HangHoa hangHoa) {
        hangHoaMap.put(hangHoa.getId(), hangHoa);
    }

    public void addNhanVien(NhanVien nhanVien) {
        nhanVienMap.put(nhanVien.getId(), nhanVien);
    }

    public void addKhachHang(KhachHang khachHang) {
        khachHangMap.put(khachHang.getId(), khachHang);
    }

    // Phương thức tìm kiếm đối tượng theo ID
    public HangHoa findHangHoaById(int maHang) {
        return hangHoaMap.get(maHang);
    }

    public NhanVien findNhanVienById(int maNhanVien) {
        return nhanVienMap.get(maNhanVien);
    }

    public KhachHang findKhachHangById(int id) {
        return khachHangMap.get(id);
    }

    // Phương thức xóa đối tượng theo ID
    public void removeHangHoaById(int maHang) {
        hangHoaMap.remove(maHang);
    }

    public void removeNhanVienById(int maNhanVien) {
        nhanVienMap.remove(maNhanVien);
    }

    public void removeKhachHangById(int id) {
        khachHangMap.remove(id);
    }
    
    

    // Các phương thức khác của lớp EntityManager

    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager();

        // Thêm các đối tượng vào EntityManager
        entityManager.addHangHoa(new HangHoa(1, "Sách", "2024-01-13", 50.0f, 101));
        entityManager.addNhanVien(new NhanVien(101, "John", "2024-01-13", 5000.0f));
        entityManager.addKhachHang(new KhachHang(201, "Alice", "123 Main Street", "0123456789"));

        // Tìm kiếm và xóa đối tượng theo ID
        HangHoa foundHangHoa = entityManager.findHangHoaById(1);
        if (foundHangHoa != null) {
            System.out.println("Tìm thấy hàng hóa: " + foundHangHoa.getTen());
            entityManager.removeHangHoaById(1);
            System.out.println("Hàng hóa đã được xóa.");
        }

        NhanVien foundNhanVien = entityManager.findNhanVienById(101);
        if (foundNhanVien != null) {
            System.out.println("Tìm thấy nhân viên: " + foundNhanVien.getTen());
            entityManager.removeNhanVienById(101);
            System.out.println("Nhân viên đã được xóa.");
        }

        KhachHang foundKhachHang = entityManager.findKhachHangById(201);
        if (foundKhachHang != null) {
            System.out.println("Tìm thấy khách hàng: " + foundKhachHang.getTen());
            entityManager.removeKhachHangById(201);
            System.out.println("Khách hàng đã được xóa.");
        }
    }
}

