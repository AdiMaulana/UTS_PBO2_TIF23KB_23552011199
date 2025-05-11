package com.insurance.dao.impl;

import com.insurance.dao.NasabahDao;
import com.insurance.entity.Nasabah;
import com.insurance.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NasabahDaoImpl implements NasabahDao {

    @Override
    public void save(Nasabah nasabah) throws Exception {
        String sql = "INSERT INTO nasabah (nama, umur) VALUES (?, ?) ;";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nasabah.getNama());
            ps.setInt(2, nasabah.getUmur());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                nasabah.setId(rs.getInt(1));
            }
        }
    }

    @Override
    public Nasabah findById(int id) throws Exception {
        String sql = "SELECT * FROM nasabah WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Nasabah(rs.getInt("id"), rs.getString("nama"), rs.getInt("umur"));
            }
            return null;
        }
    }

    @Override
    public List<Nasabah> findAll() throws Exception {
        List<Nasabah> list = new ArrayList<>();
        String sql = "SELECT * FROM nasabah";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Nasabah(rs.getInt("id"), rs.getString("nama"), rs.getInt("umur")));
            }
        }
        return list;
    }
}
