package com.insurance.service;

import com.insurance.entity.Polis;
import java.util.List;

public interface PolisService {
    void buatPolis(Polis polis) throws Exception;
    Polis cariPolisById(int id) throws Exception;
    List<Polis> cariPolisByNasabahId(int nasabahId) throws Exception;
    List<Polis> semuaPolis() throws Exception;
}
