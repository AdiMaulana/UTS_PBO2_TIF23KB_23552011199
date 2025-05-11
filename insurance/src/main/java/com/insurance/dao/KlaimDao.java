package com.insurance.dao;

import com.insurance.entity.Klaim;
import java.util.List;

public interface KlaimDao {
    void save(Klaim klaim) throws Exception;
    List<Klaim> getSemuaKlaim() throws Exception;
    List<Klaim> findByPolisId(int polisId) throws Exception;
}
