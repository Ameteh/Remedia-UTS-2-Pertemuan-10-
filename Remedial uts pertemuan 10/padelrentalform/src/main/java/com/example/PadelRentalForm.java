package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class PadelRentalForm extends JFrame {
    private DefaultTableModel tableModel;
    private JTextField tfName, tfNoHP, tfTanggal, tfJamMulai, tfJamSelesai;
    private ArrayList<DataPadel> padels = new ArrayList<>();
    private JComboBox<String> cbLapangan;
    private JTable drinkTable;
    private int IdN = 1;

    public PadelRentalForm() {
        this.padels = padels;
        setTitle("Form Sewa Lapangan Padel");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tfName = new JTextField();
        tfNoHP = new JTextField();
        tfTanggal = new JTextField("yyyy-mm-dd");
        tfJamMulai = new JTextField("08:00");
        tfJamSelesai = new JTextField("09:00");
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama", "No. Hp", "Tanggal", "Jam Mulai", "Jam Selesai", "Lapangan"}, 0);
        drinkTable = new JTable(tableModel);

        String[] lapanganOptions = { "Lapangan 1", "Lapangan 2", "Lapangan 3", "Lapangan 4" };
        cbLapangan = new JComboBox<>(lapanganOptions);

        JButton addBtn = new JButton("Simpan");
        JButton editBtn = new JButton("Ubah");
        JButton deleteBtn = new JButton("Hapus");

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        inputPanel.add(new JLabel("Name Penyewa:")); 
        inputPanel.add(tfName);
        inputPanel.add(new JLabel("No HP:")); 
        inputPanel.add(tfNoHP);
        inputPanel.add(new JLabel("Tanggal Sewa:")); 
        inputPanel.add(tfTanggal);
        inputPanel.add(new JLabel("Jam Mulai:")); 
        inputPanel.add(tfJamMulai);
        inputPanel.add(new JLabel("Jam Selesai:")); 
        inputPanel.add(tfJamSelesai);
        inputPanel.add(new JLabel("Lapangan:")); 
        inputPanel.add(cbLapangan);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(inputPanel);
        topPanel.add(buttonPanel);

            add(topPanel, BorderLayout.NORTH);
            JScrollPane scrollPane = new JScrollPane(drinkTable);
         add(scrollPane);




        drinkTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = drinkTable.getSelectedRow();
            if (selectedRow != -1) {
                tfName.setText(String.valueOf(tableModel.getValueAt(selectedRow, 1)));
                tfNoHP.setText(String.valueOf(tableModel.getValueAt(selectedRow, 2)));
                tfTanggal.setText(String.valueOf(tableModel.getValueAt(selectedRow, 3)));
                tfJamMulai.setText(String.valueOf(tableModel.getValueAt(selectedRow, 4)));
                tfJamSelesai.setText(String.valueOf(tableModel.getValueAt(selectedRow, 5)));
                cbLapangan.setSelectedItem(tableModel.getValueAt(selectedRow, 6));
            }
        });

        addBtn.addActionListener(e -> {
            String Name = tfName.getText();
            String nohpText = tfNoHP.getText();
            String tanggal = tfTanggal.getText();
            String jamMulai = tfJamMulai.getText();
            String jamSelesai = tfJamSelesai.getText();
            String lapangan = (String) cbLapangan.getSelectedItem();

              try {
                JOptionPane.showMessageDialog(this, "Pemesanan berhasil ditambahkan!");
                int nohp = Integer.parseInt(nohpText);
                int currentId = IdN++;
                DataPadel padel = new DataPadel(currentId, Name, nohp, tanggal, jamMulai, jamSelesai, lapangan);
                padels.add(padel);
                tableModel.addRow(new Object[]{currentId, Name, nohp, tanggal, jamMulai, jamSelesai, lapangan});

                tfName.setText("");
                tfNoHP.setText("");
                tfTanggal.setText("yyyy-mm-dd");
                tfJamMulai.setText("");
                tfJamSelesai.setText("");
                cbLapangan.getSelectedItem();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error");
            }
        });

          editBtn.addActionListener(e -> {
            int selectedRow = drinkTable.getSelectedRow();
            String name = tfName.getText();
            String nohpText = tfNoHP.getText();
            String tanggal = tfTanggal.getText();
            String jamMulai = tfJamMulai.getText();
            String jamSelesai = tfJamSelesai.getText();
            String lapangan = (String) cbLapangan.getSelectedItem();

            try {
                JOptionPane.showMessageDialog(this, "Pemesanan berhasil diubah!");
                int nohp = Integer.parseInt(nohpText);
                DataPadel padel = padels.get(selectedRow);
                padel.setName(name);
                padel.setNoHP(nohp);
                padel.setTanggal(tanggal);
                padel.setJamMulai(jamMulai);
                padel.setJamSelesai(jamSelesai);
                padel.setLapangan(lapangan);

                tableModel.setValueAt(name, selectedRow, 1);
                tableModel.setValueAt(nohp, selectedRow, 2);
                tableModel.setValueAt(tanggal, selectedRow, 3);
                tableModel.setValueAt(jamMulai, selectedRow, 4);
                tableModel.setValueAt(jamSelesai, selectedRow, 5);
                tableModel.setValueAt(lapangan, selectedRow, 6);

                tfName.setText("");
                tfNoHP.setText("");
                tfTanggal.setText("yyyy-mm-dd");
                tfJamMulai.setText("");
                tfJamSelesai.setText("");
                cbLapangan.getSelectedItem();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error");
            }
        });

        deleteBtn.addActionListener(e -> {
            int selectedRow = drinkTable.getSelectedRow();

            if (selectedRow != 1) {
                JOptionPane.showMessageDialog(this, "Pemesanan berhasil dihapus!");
                padels.remove(selectedRow);
                tableModel.removeRow(selectedRow);

                tfName.setText("");
                tfNoHP.setText("");
                tfTanggal.setText("yyyy-mm-dd");
                tfJamMulai.setText("");
                tfJamSelesai.setText("");
                cbLapangan.getSelectedIndex();
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        });
    }

    private void loadPadelDataData(ArrayList<DataPadel> padels) {
        for (DataPadel padel : padels) {
            tableModel.addRow(new Object[]{
                padel.getId(), padel.getName(), padel.getNoHP(), padel.getTanggal(), padel.getJamMulai(), padel.getJamSelesai(), padel.getLapangan()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PadelRentalForm().setVisible(true));
    }
}