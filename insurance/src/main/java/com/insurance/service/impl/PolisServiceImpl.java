package com.insurance.service.impl;

import com.insurance.dao.PolisDao;
import com.insurance.dao.impl.PolisDaoImpl;
import com.insurance.entity.Polis;
import com.insurance.service.PolisService;

import java.util.List;

public class PolisServiceImpl implements PolisService {

    private PolisDao polisDao;

    public PolisServiceImpl() {
        this.polisDao = new PolisDaoImpl();
    }

    public PolisServiceImpl(PolisDao polisDao) {
        this.polisDao = polisDao;
    }

    @Override
    public void buatPolis(Polis polis) throws Exception {
        if (polis.getPremi() < 0) {
            throw new IllegalArgumentException("Premi tidak boleh negatif");
        }
        polisDao.save(polis);
    }

    @Override
    public Polis cariPolisById(int id) throws Exception {
        return polisDao.findById(id);
    }

    @Override
    public List<Polis> cariPolisByNasabahId(int nasabahId) throws Exception {
        return polisDao.findByNasabahId(nasabahId);
    }

    @Override
    public List<Polis> semuaPolis() throws Exception {
        return polisDao.findAll();
    }
}
