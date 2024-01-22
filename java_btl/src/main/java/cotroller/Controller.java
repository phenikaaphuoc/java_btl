/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cotroller;


import enterti.EntityManager;
import enterti.HangHoa;
import enterti.KhachHang;
import enterti.NhanVien;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main_form.main_form;
import static main_form.main_form.controller;
public class Controller {
    static public EntityManager entity ;
    public Controller() {
        entity = new EntityManager();
    }
    public String getCurrentTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        return formattedDate;
    }
    public DefaultTableModel updateKhachHangTable(Map<Integer, KhachHang> khachHangMap, JTable table) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên");
        tableModel.addColumn("Địa Chỉ");
        tableModel.addColumn("SĐT");

        for (KhachHang khachHang : khachHangMap.values()) {
            Object[] rowData = {khachHang.getId(), khachHang.getTen(), khachHang.getDiaChi(), khachHang.getSdt()};
            tableModel.addRow(rowData);
        }

        table.setModel(tableModel); // Set the new model to the table directly

        return tableModel;
    }
    public DefaultTableModel updateHangHoaTable(Map<Integer, HangHoa> hangHoaMap, JTable table) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên");
        tableModel.addColumn("Thời gian vào");
        tableModel.addColumn("Giá");
        tableModel.addColumn("IDKH");

        for (HangHoa hangHoa : hangHoaMap.values()) {
            Object[] rowData = {hangHoa.getId(), hangHoa.getTen(), hangHoa.getTime(), hangHoa.getGia(),hangHoa.getIdKH()};
            tableModel.addRow(rowData);
        }

        table.setModel(tableModel); // Set the new model to the table directly

        return tableModel;
    }
    public DefaultTableModel updateNhanVienTable(Map<Integer, NhanVien> nhanVienMap, JTable table) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên");
        tableModel.addColumn("Thời gian");
        tableModel.addColumn("Lương");

        for (NhanVien nhanVien : nhanVienMap.values()) {
            Object[] rowData = {nhanVien.Id, nhanVien.ten,nhanVien.begin,nhanVien.luong};
            tableModel.addRow(rowData);
        }

        table.setModel(tableModel); // Set the new model to the table directly

        return tableModel;
    }
    public void deleteSelectedRow(JTable table) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) { // Check if any row is selected
            int selectedId = (int) table.getValueAt(selectedRow, 0);

            // Remove the corresponding entry from the HashMap
            entity.khachHangMap.remove(selectedId);

            // Remove the selected row from the table
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(selectedRow);
            entity.removeHangHoaByIdKH(selectedId);
            controller.showMessage("Xóa thành công ");
        }
    }
    public void deleteSelectedRowHangHoa(JTable table) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) { // Check if any row is selected
            int selectedId = (int) table.getValueAt(selectedRow, 0);

            // Remove the corresponding entry from the HashMap
            entity.hangHoaMap.remove(selectedId);

            // Remove the selected row from the table
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(selectedRow);
            controller.showMessage("Xóa thành công ");
        }
    }
    public void searchHangHoaByIdKhachHang(JTable tabel,int id){
       Map<Integer, HangHoa> result;
       result = entity.getHangHoaByIdKH(id);
       updateHangHoaTable(result, tabel);
       
    }
    public void searchKhachHangByID(JTable tabel,int id){
       Map<Integer, KhachHang> result;
       result = entity.getKhachHangByID(id);
       updateKhachHangTable(result, tabel);
       
    }
    public void searchNhanVienByID(JTable tabel,int id){
       Map<Integer, NhanVien> result;
       result = entity.getNhanVienByID(id);
       updateNhanVienTable(result, tabel);
       
    }
    public void searchNhanVienByName(JTable tabel,String name){
       Map<Integer, NhanVien> result;
       result = entity.getNhanVienByTen(name);
       updateNhanVienTable(result, tabel);
       
    }
    
    public void searchKhachHangByTen(JTable tabel,String ten){
       Map<Integer, KhachHang> result;
       result = entity.getKhachHangByTen(ten);
       updateKhachHangTable(result, tabel);
       
    }
    public void searchHangHoaByTen(JTable tabel,String ten){
       Map<Integer, HangHoa> result;
       result = entity.getHangHoaByTen(ten);
       updateHangHoaTable(result, tabel);
       
    }
    
    public void deleteSelectedRowNhanVien(JTable table) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) { // Check if any row is selected
            int selectedId = (int) table.getValueAt(selectedRow, 0);
            entity.nhanVienMap.remove(selectedId);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(selectedRow);
            controller.showMessage("Xóa thành công ");
        }
    }
    public void suaNhanVien(JTable table,  String id,String ten,String time, String luong){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        try {
            
            NhanVien nhanvien = new NhanVien(Integer.parseInt(id), ten, time, Float.parseFloat(luong));
            Object[] rowData = {nhanvien.Id, nhanvien.ten, nhanvien.begin, nhanvien.luong};
            entity.nhanVienMap.remove(id);
            entity.nhanVienMap.put(nhanvien.Id, nhanvien);
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                if (Integer.parseInt(tableModel.getValueAt(i, 0).toString()) == nhanvien.Id) {
                    tableModel.removeRow(i);
                }
            }
            tableModel.addRow(rowData);
        } catch (IllegalArgumentException e) {
            // Handle the case where idKH.getText() cannot be parsed as an integer
            showMessage(e.getMessage()); // Handle the exception appropriately
        }   
    }
    public void addKhachHang(JTable table,int id ,String ten,String diaChi ,String sdt ){
        
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        boolean check = true;
        try {
            KhachHang khachHang = new KhachHang(id, ten, diaChi, sdt);

            // Add data to jtKH
            Object[] rowData = {khachHang.getId(), khachHang.getTen(), khachHang.getDiaChi(), khachHang.getSdt()};
            tableModel.addRow(rowData);
            entity.khachHangMap.put(id, khachHang);
        } catch (IllegalArgumentException e) {
            // Handle the case where idKH.getText() cannot be parsed as an integer
            showMessage(e.getMessage());
            check = false;// Handle the exception appropriately
        }
        if(check == true){
             controller.showMessage("Thêm thành công");
        }
        

   }
    
    public void addHangHoa(JTable table, int id,  String ten,String  time, float gia,int idKH){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        boolean check = true;
        try {
            HangHoa hanghoa = new HangHoa(id, ten, time, gia, idKH);
            Object[] rowData = {hanghoa.getId(), hanghoa.getTen(), hanghoa.getTime(), hanghoa.getGia(),hanghoa.getidKH()};
            tableModel.addRow(rowData);
            entity.hangHoaMap.put(id, hanghoa);
        } catch (IllegalArgumentException e) {
            check = false;
            // Handle the case where idKH.getText() cannot be parsed as an integer
            showMessage(e.getMessage()); // Handle the exception appropriately
        }  
        if(check == true){
            showMessage("Them thanh cong");
        }
    }
    public void addNhanVien(JTable table,int id,String ten,String time,float luong){
        boolean check = true;
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        try {
            NhanVien nhanvien = new NhanVien(id, ten, time, luong);
            Object[] rowData = {nhanvien.Id, nhanvien.ten,nhanvien.begin,nhanvien.luong};
            tableModel.addRow(rowData);
            entity.nhanVienMap.put(id, nhanvien);
        } catch (IllegalArgumentException e) {
            check = false;
            showMessage(e.getMessage()); // Handle the exception appropriately
        } 
        if (check == true){
            showMessage("Them thanh cong");
        }
    }
    
    public void suaKhachHang(JTable table,int id ,String ten,String diaChi ,String sdt ){
        
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        try {
            
            KhachHang khachHang = new KhachHang(id, ten, diaChi, sdt);
            Object[] rowData = {khachHang.getId(), khachHang.getTen(), khachHang.getDiaChi(), khachHang.getSdt()};
            entity.khachHangMap.remove(id);
            entity.khachHangMap.put(id, khachHang);
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                if (Integer.parseInt(tableModel.getValueAt(i, 0).toString()) == id) {
                    tableModel.removeRow(i);
                }
            }
            tableModel.addRow(rowData);
        } catch (IllegalArgumentException e) {
            // Handle the case where idKH.getText() cannot be parsed as an integer
            showMessage(e.getMessage()); // Handle the exception appropriately
        }   
   }
    public void suaHangHoa(JTable table,String id_string ,String ten,String time ,String gia_string, int idKH ){
        
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        try {
            int id = Integer.parseInt(id_string);
            float gia = Float.parseFloat(gia_string);
            HangHoa hanghoa = new HangHoa(id, ten, time, gia, idKH);
            Object[] rowData = {hanghoa.getId(), hanghoa.getTen(), hanghoa.getTime(), hanghoa.getGia(),hanghoa.getidKH()};
            entity.hangHoaMap.remove(id);
            entity.hangHoaMap.put(id, hanghoa);
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                if (Integer.parseInt(tableModel.getValueAt(i, 0).toString()) == id) {
                    tableModel.removeRow(i);
                }
            }
            tableModel.addRow(rowData);
        } catch (IllegalArgumentException e ) {
            // Handle the case where idKH.getText() cannot be parsed as an integer
            showMessage(e.getMessage()); // Handle the exception appropriately
        }   
   }
   public void showMessage(String mess){
       JOptionPane.showMessageDialog(null, mess, "Information", JOptionPane.INFORMATION_MESSAGE);
   }
   public void updateID(JLabel label_kh){
       int idKH = entity.getMaxIDKH(entity.khachHangMap);
       label_kh.setText(String.valueOf(idKH));
   }
    
}
