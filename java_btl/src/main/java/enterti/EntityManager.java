package enterti;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class EntityManager {
    private static Map<Integer, HangHoa> hangHoaMap;
    private static Map<Integer, NhanVien> nhanVienMap;
    private static Map<Integer, KhachHang> khachHangMap;

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
    public void saveAllToFile() {
        String fileName = "nhanvien.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(nhanVienMap);
            System.out.println("Đã ghi dữ liệu thành công vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        fileName = "hanghoa.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(hangHoaMap);
            System.out.println("Đã ghi dữ liệu thành công vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        fileName = "khachhang.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(khachHangMap);
            System.out.println("Đã ghi dữ liệu thành công vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    public void loadAllFromFile() {
        loadFromFile("hanghoa.dat", hangHoaMap);
        loadFromFile("nhanvien.dat", nhanVienMap);
        loadFromFile("khachhang.dat", khachHangMap);

    }

    private <T> void loadFromFile(String fileName, Map<Integer, T> dataMap) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            Map<Integer, T> loadedData = (Map<Integer, T>) ois.readObject();
            dataMap.clear();
            dataMap.putAll(loadedData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Các phương thức khác của lớp EntityManager

    public static void main(String[] args) {
       EntityManager entityManager = new EntityManager();
       entityManager.addHangHoa(new HangHoa(1, "Sách", "2024-01-13", 50.0f, 101));
        entityManager.addNhanVien(new NhanVien(101, "John", "2024-01-13", 5000.0f));
        entityManager.addKhachHang(new KhachHang(201, "Alice", "123 Main Street", "0123456789"));

        // Save data to files
        entityManager.saveAllToFile();

        // Clear existing data
        hangHoaMap.clear();
        nhanVienMap.clear();
        khachHangMap.clear();

        // Load data from files
        entityManager.loadAllFromFile();

        // Print loaded data
        System.out.println("Loaded HangHoa Map:");
        printMap(hangHoaMap);

        System.out.println("\nLoaded NhanVien Map:");
        printMap(nhanVienMap);

        System.out.println("\nLoaded KhachHang Map:");
        printMap(khachHangMap);
    }
    private static <T> void printMap(Map<Integer, T> map) {
        for (Map.Entry<Integer, T> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
