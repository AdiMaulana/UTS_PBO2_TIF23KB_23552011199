package com.insurance.dao;

import com.insurance.entity.Nasabah;
import java.util.List;

public interface NasabahDao {
    void save(Nasabah nasabah) throws Exception;
    Nasabah findById(int id) throws Exception;
    List<Nasabah> findAll() throws Exception;
}
