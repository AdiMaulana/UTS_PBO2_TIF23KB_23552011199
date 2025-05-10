package com.insurance.service.impl;

import com.insurance.dao.KlaimDao;
import com.insurance.dao.impl.KlaimDaoImpl;
import com.insurance.dao.PolisDao;
import com.insurance.dao.impl.PolisDaoImpl;
import com.insurance.entity.Klaim;
import com.insurance.entity.Polis;
import com.insurance.service.LayananAsuransi;

import java.sql.Date;
import java.util.Scanner;

public class LayananAsuransiServiceImpl implements LayananAsuransi {

    private KlaimDao klaimDao = new KlaimDaoImpl();
    private PolisDao polisDao = new PolisDaoImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void prosesKlaim() {
        try {
            System.out.print("Masukkan ID Polis untuk klaim: ");
            int polisId = scanner.nextInt();
            scanner.nextLine();

            Polis polis = polisDao.findById(polisId);
            if (polis == null) {
                System.out.println("Polis tidak ditemukan!");
                return;
            }

            System.out.print("Masukkan tanggal klaim (YYYY-MM-DD): ");
            String tanggalStr = scanner.nextLine();
            Date tanggal = Date.valueOf(tanggalStr);

            System.out.print("Masukkan status klaim (pending/approved/rejected): ");
            String status = scanner.nextLine();

            Klaim klaim = new Klaim();
            klaim.setPolisId(polisId);
            klaim.setTanggal(tanggal);
            klaim.setStatus(status);

            klaimDao.save(klaim);

            System.out.println("Klaim berhasil diproses untuk polis ID " + polisId);

        } catch (Exception e) {
            System.err.println("Error saat proses klaim: " + e.getMessage());
        }
    }
}
