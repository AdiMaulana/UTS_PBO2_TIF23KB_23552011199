package com.insurance.entity;

public abstract class Asuransi {
    protected String jenis;
    protected double premi;

    public abstract double hitungPremi();

    public String getJenis() {
        return jenis;
    }

    public double getPremi() {
        return premi;
    }
}
