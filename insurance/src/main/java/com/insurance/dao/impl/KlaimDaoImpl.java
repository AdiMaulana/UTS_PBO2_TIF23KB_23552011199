package com.insurance.dao.impl;

import com.insurance.dao.KlaimDao;
import com.insurance.entity.Klaim;
import com.insurance.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlaimDaoImpl implements KlaimDao {

    @Override
    public void save(Klaim klaim) throws Exception {
        String sql = "INSERT INTO klaim (polis_id, tanggal, status) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, klaim.getPolisId());
            ps.setDate(2, klaim.getTanggal());
            ps.setString(3, klaim.getStatus());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Klaim> findByPolisId(int polisId) throws Exception {
        List<Klaim> list = new ArrayList<>();
        String sql = "SELECT * FROM klaim WHERE polis_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, polisId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Klaim k = new Klaim(
                    rs.getInt("id"),
                    rs.getInt("polis_id"),
                    rs.getDate("tanggal"),
                    rs.getString("status")
                );
                list.add(k);
            }
        }
        return list;
    }
}
