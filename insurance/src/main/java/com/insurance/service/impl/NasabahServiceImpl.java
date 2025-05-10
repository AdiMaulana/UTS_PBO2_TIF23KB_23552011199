package com.insurance.service.impl;

import com.insurance.dao.NasabahDao;
import com.insurance.dao.impl.NasabahDaoImpl;
import com.insurance.entity.Nasabah;
import com.insurance.service.NasabahService;
import java.util.List;

public class NasabahServiceImpl implements NasabahService {

    private NasabahDao nasabahDao;

    public NasabahServiceImpl() {
        this.nasabahDao = new NasabahDaoImpl();
    }

    public NasabahServiceImpl(NasabahDao nasabahDao) {
        this.nasabahDao = nasabahDao;
    }

    @Override
    public void tambahNasabah(Nasabah nasabah) throws Exception {
        if (nasabah.getUmur() < 0) {
            throw new IllegalArgumentException("Umur tidak valid");
        }
        nasabahDao.save(nasabah);
    }

    @Override
    public Nasabah cariNasabahById(int id) throws Exception {
        return nasabahDao.findById(id);
    }

    @Override
    public List<Nasabah> semuaNasabah() throws Exception {
        return nasabahDao.findAll();
    }
}
