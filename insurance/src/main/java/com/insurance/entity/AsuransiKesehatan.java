package com.insurance.entity;

import com.insurance.constant;

public class AsuransiKesehatan extends Asuransi {
    private double biayaDasar;

    public AsuransiKesehatan(double biayaDasar) {
        this.jenis = constant.AS_KESEHATAN;
        this.biayaDasar = biayaDasar;
    }

    @Override
    public double hitungPremi() {
        premi = biayaDasar * 1.2;
        return premi;
    }
}