package com.insurance.service;

import com.insurance.entity.Nasabah;
import java.util.List;

public interface NasabahService {
    void tambahNasabah(Nasabah nasabah) throws Exception;
    Nasabah cariNasabahById(int id) throws Exception;
    List<Nasabah> semuaNasabah() throws Exception;
}
