package com.insurance.dao.impl;

import com.insurance.dao.PolisDao;
import com.insurance.entity.Polis;
import com.insurance.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PolisDaoImpl implements PolisDao {

    @Override
    public void save(Polis polis) throws Exception {
        String sql = "INSERT INTO polis (nasabah_id, jenis, premi) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, polis.getNasabahId());
            ps.setString(2, polis.getJenis());
            ps.setDouble(3, polis.getPremi());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                polis.setId(rs.getInt(1));
            }
        }
    }

    @Override
    public Polis findById(int id) throws Exception {
        String sql = "SELECT * FROM polis WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Polis(
                    rs.getInt("id"),
                    rs.getInt("nasabah_id"),
                    rs.getString("jenis"),
                    rs.getDouble("premi")
                );
            }
            return null;
        }
    }

    @Override
    public List<Polis> findByNasabahId(int nasabahId) throws Exception {
        List<Polis> list = new ArrayList<>();
        String sql = "SELECT * FROM polis WHERE nasabah_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nasabahId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Polis p = new Polis(
                    rs.getInt("id"),
                    rs.getInt("nasabah_id"),
                    rs.getString("jenis"),
                    rs.getDouble("premi")
                );
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<Polis> findAll() throws Exception {
        List<Polis> list = new ArrayList<>();
        String sql = "SELECT * FROM polis";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Polis p = new Polis(
                    rs.getInt("id"),
                    rs.getInt("nasabah_id"),
                    rs.getString("jenis"),
                    rs.getDouble("premi")
                );
                list.add(p);
            }
        }
        return list;
    }
}
