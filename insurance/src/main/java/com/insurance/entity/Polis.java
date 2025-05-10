package com.insurance.entity;

public class Polis {
    private int id;
    private int nasabahId;
    private String jenis;
    private double premi;

    public Polis() {}

    public Polis(int id, int nasabahId, String jenis, double premi) {
        this.id = id;
        this.nasabahId = nasabahId;
        this.jenis = jenis;
        this.premi = premi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNasabahId() {
        return nasabahId;
    }

    public void setNasabahId(int nasabahId) {
        this.nasabahId = nasabahId;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getPremi() {
        return premi;
    }

    public void setPremi(double premi) {
        this.premi = premi;
    }
}
