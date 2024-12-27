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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Atraccion;

/**
 * Implementación de la interfaz AtraccionDAO utilizando JDBC.
 */
public class AtraccionDAOImpl implements AtraccionDAO {

    @Override
    public void insertar(Atraccion atraccion) {
        String sql = "INSERT INTO atraccion (nombre, descripcion, clasificacion, condicionesuso, estado, alturaminima) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atraccion.getNombre());
            stmt.setString(2, atraccion.getDescripcion());
            stmt.setString(3, atraccion.getClasificacion());
            stmt.setString(4, atraccion.getCondicionesUso());
            stmt.setString(5, atraccion.getEstado());
            stmt.setDouble(6, atraccion.getAlturaMinima());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Atraccion leerPorId(int id) {
        String sql = "SELECT * FROM atraccion WHERE id = ?";
        Atraccion atraccion = null;
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    atraccion = new Atraccion(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("clasificacion"),
                        rs.getString("condicionesuso"),
                        rs.getString("estado"),
                        rs.getDouble("alturaminima")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atraccion;
    }
    
    // Método para obtener una atracción por su nombre
    public Atraccion leerPorNombre(String nombre) {
        String sql = "SELECT * FROM atraccion WHERE nombre = ?";
        Atraccion atraccion = null;
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    atraccion = new Atraccion(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("clasificacion"),
                        rs.getString("condicionesuso"),
                        rs.getString("estado"),
                        rs.getDouble("alturaminima")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atraccion;
    }

    @Override
    public List<Atraccion> leerTodas() {
        String sql = "SELECT * FROM atraccion";
        List<Atraccion> atracciones = new ArrayList<>();
        try (Connection conn = ConexionDB.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Atraccion atraccion = new Atraccion(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("clasificacion"),
                    rs.getString("condicionesuso"),
                    rs.getString("estado"),
                    rs.getDouble("alturaminima")
                );
                atracciones.add(atraccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atracciones;
    }

    @Override
    public void actualizar(Atraccion atraccion) {
        String sql = "UPDATE atraccion SET nombre = ?, descripcion = ?, clasificacion = ?, condicionesuso = ?, estado = ?, alturaminima = ? " +
                     "WHERE id = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atraccion.getNombre());
            stmt.setString(2, atraccion.getDescripcion());
            stmt.setString(3, atraccion.getClasificacion());
            stmt.setString(4, atraccion.getCondicionesUso());
            stmt.setString(5, atraccion.getEstado());
            stmt.setDouble(6, atraccion.getAlturaMinima());
            stmt.setInt(7, atraccion.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM atraccion WHERE id = ?";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

