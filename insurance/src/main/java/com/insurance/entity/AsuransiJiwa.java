package com.insurance.entity;

import com.insurance.constant;

public class AsuransiJiwa extends Asuransi {
    private double nilaiPertanggungan;

    public AsuransiJiwa(double nilaiPertanggungan) {
        this.jenis = constant.AS_JIWA;
        this.nilaiPertanggungan = nilaiPertanggungan;
    }

    @Override
    public double hitungPremi() {
        premi = nilaiPertanggungan * 0.05;
        return premi;
    }
}
