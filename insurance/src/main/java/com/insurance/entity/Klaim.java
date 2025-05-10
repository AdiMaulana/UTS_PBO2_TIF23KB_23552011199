package com.insurance.entity;

import java.sql.Date;

public class Klaim {
    private int id;
    private int polisId;
    private Date tanggal;
    private String status;

    public Klaim() {}

    public Klaim(int id, int polisId, Date tanggal, String status) {
        this.id = id;
        this.polisId = polisId;
        this.tanggal = tanggal;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPolisId() {
        return polisId;
    }

    public void setPolisId(int polisId) {
        this.polisId = polisId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
