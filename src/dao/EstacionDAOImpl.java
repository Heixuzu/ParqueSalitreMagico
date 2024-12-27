/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Heidy
 */

import basededatos.ConexionDB;
import modelo.Estacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstacionDAOImpl implements EstacionDAO {

    @Override
    public void insertar(Estacion estacion) {
        String sql = "INSERT INTO Estacion (ubicacion, estado) VALUES (?, ?)";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estacion.getUbicacion());
            stmt.setString(2, estacion.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estacion leerPorId(int id) {
        Estacion estacion = null;
        String sql = "SELECT * FROM Estacion WHERE id = ?";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    estacion = new Estacion();
                    estacion.setId(resultSet.getInt("id"));
                    estacion.setUbicacion(resultSet.getString("ubicacion"));
                    estacion.setEstado(resultSet.getString("estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estacion;
    }

    @Override
    public List<Estacion> leerTodas() {
        List<Estacion> estaciones = new ArrayList<>();
        String sql = "SELECT * FROM Estacion";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                Estacion estacion = new Estacion();
                estacion.setId(resultSet.getInt("id"));
                estacion.setUbicacion(resultSet.getString("ubicacion"));
                estacion.setEstado(resultSet.getString("estado"));
                estaciones.add(estacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estaciones;
    }

    @Override
    public void actualizar(Estacion estacion) {
        String sql = "UPDATE Estacion SET ubicacion = ?, estado = ? WHERE id = ?";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estacion.getUbicacion());
            stmt.setString(2, estacion.getEstado());
            stmt.setInt(3, estacion.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Estacion WHERE id = ?";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

