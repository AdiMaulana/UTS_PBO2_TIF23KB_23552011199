package com.insurance.service;

import com.insurance.entity.Klaim;
import java.util.List;

public interface LayananAsuransi {
    void prosesKlaim();
    List<Klaim> semuaKlaim() throws Exception;
}
