/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cotroller;


import enterti.EntityManager;
import enterti.KhachHang;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Controller {
    static public EntityManager entity ;
    public Controller() {
        entity = new EntityManager();
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
    public void deleteSelectedRow(JTable table) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) { // Check if any row is selected
            int selectedId = (int) table.getValueAt(selectedRow, 0);

            // Remove the corresponding entry from the HashMap
            entity.khachHangMap.remove(selectedId);

            // Remove the selected row from the table
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(selectedRow);
        }
    }
}
