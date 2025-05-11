package com.insurance;

import com.insurance.entity.Asuransi;
import com.insurance.entity.AsuransiKesehatan;
import com.insurance.entity.AsuransiJiwa;
import com.insurance.entity.Klaim;
import com.insurance.entity.Nasabah;
import com.insurance.entity.Polis;
import com.insurance.service.LayananAsuransi;
import com.insurance.service.impl.LayananAsuransiServiceImpl;
import com.insurance.service.NasabahService;
import com.insurance.service.impl.NasabahServiceImpl;
import com.insurance.service.PolisService;
import com.insurance.service.impl.PolisServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    // Service Nasabah
    private static NasabahService nasabahService = new NasabahServiceImpl();
    // Service Polis
    private static PolisService polisService = new PolisServiceImpl();
    // Service LayananAsuransi (untuk proses klaim)
    private static LayananAsuransi layananAsuransi = new LayananAsuransiServiceImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Kasir Asuransi ===");
            System.out.println("1. Tambah Nasabah");
            System.out.println("2. Tampilkan Semua Nasabah");
            System.out.println("3. Hitung Premi Asuransi");
            System.out.println("4. Buat Polis");
            System.out.println("5. Tampilkan Semua Polis");
            System.out.println("6. Proses Klaim");
            System.out.println("7. Tampilkan Semua Klaim");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilih = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (pilih) {
                    case 1:
                        tambahNasabah();
                        break;
                    case 2:
                        tampilkanNasabah();
                        break;
                    case 3:
                        hitungPremi();
                        break;
                    case 4:
                        buatPolis();
                        break;
                    case 5:
                        tampilkanSemuaPolis();
                        break;
                    case 6:
                        layananAsuransi.prosesKlaim();
                        break;
                    case 7:
                        tampilkanSemuaKlaim();
                        break;
                    case 0:
                        System.out.println("Terima kasih!");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private static void tambahNasabah() {
        try {
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Umur: ");
            int umur = scanner.nextInt();
            scanner.nextLine();

            Nasabah nasabah = new Nasabah();
            nasabah.setNama(nama);
            nasabah.setUmur(umur);

            nasabahService.tambahNasabah(nasabah);
            System.out.println("Nasabah berhasil ditambahkan dengan ID: " + nasabah.getId());
        } catch (Exception e) {
            System.err.println("Gagal menambahkan nasabah: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void tampilkanNasabah() throws Exception {
        nasabahService = new NasabahServiceImpl();
        List<Nasabah> list = nasabahService.semuaNasabah();
        System.out.println("Daftar Nasabah:");
        for (Nasabah n : list) {
            System.out.printf("ID: %d, Nama: %s, Umur: %d\n", n.getId(), n.getNama(), n.getUmur());
        }
    }

    private static void hitungPremi() {
        System.out.println("Hitung Premi Asuransi");
        System.out.print("Pilih jenis asuransi (kesehatan/jiwa): ");
        String jenis = scanner.nextLine().toLowerCase();

        Asuransi asuransi;
        if (jenis.equals("kesehatan")) {
            System.out.print("Masukkan biaya dasar: ");
            double biaya = scanner.nextDouble();
            scanner.nextLine();
            asuransi = new AsuransiKesehatan(biaya);

        } else if (jenis.equals("jiwa")) {
            System.out.print("Masukkan nilai pertanggungan: ");
            double nilai = scanner.nextDouble();
            scanner.nextLine();
            asuransi = new AsuransiJiwa(nilai);

        } else {
            System.out.println("Jenis asuransi tidak valid!");
            return;
        }

        double premi = asuransi.hitungPremi();
        System.out.println("Premi yang harus dibayar: " + premi);
    }

    private static void buatPolis() throws Exception {
        try {
            System.out.print("Masukkan ID Nasabah: ");
            int nasabahId = scanner.nextInt();
            scanner.nextLine();

            Nasabah nasabah = nasabahService.cariNasabahById(nasabahId);
            if (nasabah == null) {
                System.out.println("Nasabah tidak ditemukan!");
                return;
            }

            System.out.print("Jenis asuransi (kesehatan/jiwa): ");
            String jenis = scanner.nextLine().toLowerCase();

            double premi;
            if (jenis.equals("kesehatan")) {
                System.out.print("Masukkan biaya dasar: ");
                double biaya = scanner.nextDouble();
                scanner.nextLine();
                AsuransiKesehatan kesehatan = new AsuransiKesehatan(biaya);
                premi = kesehatan.hitungPremi();
            } else if (jenis.equals("jiwa")) {
                System.out.print("Masukkan nilai pertanggungan: ");
                double nilai = scanner.nextDouble();
                scanner.nextLine();
                AsuransiJiwa jiwa = new AsuransiJiwa(nilai);
                premi = jiwa.hitungPremi();
            } else {
                System.out.println("Jenis asuransi tidak valid!");
                return;
            }

            Polis polis = new Polis();
            polis.setNasabahId(nasabahId);
            polis.setJenis(jenis);
            polis.setPremi(premi);

            polisService.buatPolis(polis);
            System.out.println("Polis berhasil dibuat dengan premi: " + premi);
        } catch (Exception e) {
            System.err.println("Gagal membuat polis premi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void tampilkanSemuaPolis() throws Exception {
        List<Polis> list = polisService.semuaPolis();
        System.out.println("Daftar Polis:");
        for (Polis p : list) {
            System.out.printf("ID: %d, Nasabah ID: %d, Jenis: %s, Premi: %.2f\n",
                    p.getId(), p.getNasabahId(), p.getJenis(), p.getPremi());
        }
    }
    
    private static void tampilkanSemuaKlaim() {
    try {
        List<Klaim> list = layananAsuransi.semuaKlaim();
        System.out.println("Daftar Klaim Asuransi:");
        if (list.isEmpty()) {
            System.out.println("Belum ada data klaim.");
            return;
        }
        for (Klaim k : list) {
            System.out.printf("ID Klaim: %d, Polis ID: %d, Tanggal: %s, Status: %s\n",
                    k.getId(), k.getPolisId(), k.getTanggal().toString(), k.getStatus());
        }
    } catch (Exception e) {
        System.err.println("Gagal menampilkan klaim: " + e.getMessage());
        e.printStackTrace();
    }
}
}
