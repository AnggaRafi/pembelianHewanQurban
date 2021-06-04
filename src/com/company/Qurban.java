package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Qurban {
    private JPanel panel1;
    private JTextArea sapiIsi;
    private JTextArea kambingIsi;
    private JTextArea untaIsi;
    private JTextArea areaKonfirmasi;
    private JTextField isiNama;
    private JTextField isiAlamat;
    private JComboBox isiSupplier;
    private JTextField isiSapi;
    private JTextField isiKambing;
    private JTextField isiUnta;
    private JButton Submit;
    private JButton Clear;
    private JButton Finish;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Form Pemesanan Hewan Ternak untuk Qurban");
        frame.setContentPane(new Qurban().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public Qurban() {

        isiSupplier.addItem("");
        isiSupplier.addItem("PT Ternak Nusantara");
        isiSupplier.addItem("PT Ternak Impor");

        isiSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isiSupplier.getSelectedItem().equals("PT Ternak Nusantara")){
                    sapiIsi.setText("Harga 1 Sapi = Rp14.000.000");
                    kambingIsi.setText("Harga 1 Kambing = Rp1.500.000");
                    untaIsi.setText("PT Ternak Nusantara tidak menjual unta!");
                }
                else if (isiSupplier.getSelectedItem().equals("PT Ternak Impor")){
                    sapiIsi.setText("Harga 1 Sapi = Rp15.000.000");
                    kambingIsi.setText("Harga 1 Kambing = Rp2.500.000");
                    untaIsi.setText("Harga 1 Unta = Rp34.000.000");
                }
                else {
                    sapiIsi.setText("");
                    kambingIsi.setText("");
                    untaIsi.setText("");
                }
            }
        });

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hargaPersapi, hargaPerkambing, hargaPerunta;
                if (!isiNama.getText().equals("") && !isiAlamat.getText().equals("")) {
                    if (!isiSupplier.getSelectedItem().equals("")) {
                        if (isiSupplier.getSelectedItem().equals("PT Ternak Nusantara")) {
                            hargaPersapi = 14000000;
                            hargaPerkambing = 1500000;
                            hargaPerunta = 0;
                        } else {
                            hargaPersapi = 15000000;
                            hargaPerkambing = 2500000;
                            hargaPerunta = 34000000;
                        }
                        if (!isiSapi.getText().equals("") && !isiKambing.getText().equals("") && !isiUnta.getText().equals("")) {
                            Integer jumlahSapi = Integer.parseInt(isiSapi.getText());
                            Integer jumlahKambing = Integer.parseInt(isiKambing.getText());
                            Integer jumlahUnta = Integer.parseInt(isiUnta.getText());

                            int totalSapi = jumlahSapi * hargaPersapi;
                            int totalKambing = jumlahKambing * hargaPerkambing;
                            int totalUnta = jumlahUnta * hargaPerunta;

                            areaKonfirmasi.setText("Nama : " + isiNama.getText() + "\nAlamat : " + isiAlamat.getText() + "\nSupplier : "
                                    + isiSupplier.getSelectedItem() + "\nTotal Harga Sapi : Rp" + totalSapi + "\nTotal Harga Kambing : Rp"
                                    + totalKambing + "\nTotal Harga Unta : Rp" + totalUnta + "\nTotal Harga : Rp" + (totalKambing + totalSapi + totalUnta));
                        } else {
                            JOptionPane.showMessageDialog(null,"Anda belum memasukkan jumlah hewan!");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Anda belum memilih supplier!");
                        areaKonfirmasi.setText("");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Anda belum memasukkan Nama / Alamat!");
                }
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isiNama.setText("");
                isiAlamat.setText("");
                isiSupplier.setSelectedItem("");
                isiSapi.setText("");
                isiKambing.setText("");
                isiUnta.setText("");
                areaKonfirmasi.setText("");
            }
        });

        Finish.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!areaKonfirmasi.getText().equals(""))
                {
                    for (int i = 3 ; i>0 ; i--){
                        JOptionPane.showMessageDialog(null,i);
                    }
                    JOptionPane.showMessageDialog(null,"Pesanan Anda Sedang Diproses!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Anda belum men-submit pesanan!");
                }
            }
        });

        isiNama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (!isiNama.getText().equals(""))
                areaKonfirmasi.setText("Berhasil");
            }
        });
    }
}


// Modul 1 (Tipe data, Variabel, Array)
// Modul 2 (Pengkondisian)
// Modul 3 (Perulangan)
// Modul 4 (Function & Method)
// Modul 5 (Class & Constructor)
// Modul 6 (UDT, Setter, dan Getter)
// Modul 8 (Stack & Queue)