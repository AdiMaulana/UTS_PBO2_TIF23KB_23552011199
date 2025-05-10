package com.insurance.dao;

import com.insurance.entity.Polis;
import java.util.List;

public interface PolisDao {
    void save(Polis polis) throws Exception;
    Polis findById(int id) throws Exception;
    List<Polis> findByNasabahId(int nasabahId) throws Exception;
    List<Polis> findAll() throws Exception;
}
