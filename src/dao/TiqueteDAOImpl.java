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
import modelo.Tiquete;
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TiqueteDAOImpl implements TiqueteDAO {
    // Método para insertar un nuevo tiquete
    @Override
    public void insertar(Tiquete tiquete) {
        String sql = "INSERT INTO Tiquete (tipo, fechaAdquisicion, estadoAdquisicion, cliente_id) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tiquete.getTipo());
            ps.setDate(2, Date.valueOf(tiquete.getFechaAdquisicion()));
            ps.setString(3, tiquete.getEstadoAdquisicion());
            ps.setInt(4, tiquete.getClienteAsociado().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer un tiquete por su ID
    @Override
    public Tiquete leerPorId(int id) {
        String sql = "SELECT t.id, t.tipo, t.fechaAdquisicion, t.estadoAdquisicion, c.id as cliente_id, c.cedula, c.nombre, c.telefono, c.email, c.estatura, c.edad, c.contacto " +
                     "FROM Tiquete t " +
                     "JOIN Cliente c ON t.cliente_id = c.id " +
                     "WHERE t.id = ?";
        try (Connection con = ConexionDB.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Crear un objeto Cliente con los datos obtenidos
                Cliente cliente = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("email"),
                        rs.getDouble("estatura"),
                        rs.getInt("edad"),
                        rs.getObject("contacto", Integer.class) // Puede ser null, por eso usamos getObject
                );

                // Crear y devolver el objeto Tiquete con el cliente asociado
                return new Tiquete(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getDate("fechaAdquisicion").toLocalDate(),
                        rs.getString("estadoAdquisicion"),
                        cliente
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para leer todos los tiquetes
    @Override
    public List<Tiquete> leerTodos() {
        List<Tiquete> tiquetes = new ArrayList<>();
        String sql = "SELECT t.id, t.tipo, t.fechaAdquisicion, t.estadoAdquisicion, c.id as cliente_id, c.cedula, c.nombre, c.telefono, c.email, c.estatura, c.edad, c.contacto " +
                     "FROM Tiquete t " +
                     "JOIN Cliente c ON t.cliente_id = c.id";

        try (Connection con = ConexionDB.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Crear un objeto Cliente con los datos obtenidos
                Cliente cliente = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("email"),
                        rs.getDouble("estatura"),
                        rs.getInt("edad"),
                        rs.getObject("contacto", Integer.class) // Puede ser null, por eso usamos getObject
                );

                // Crear el objeto Tiquete con el cliente asociado y agregarlo a la lista
                Tiquete tiquete = new Tiquete(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getDate("fechaAdquisicion").toLocalDate(),
                        rs.getString("estadoAdquisicion"),
                        cliente
                );
                tiquetes.add(tiquete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tiquetes;
    }

    // Método para actualizar un tiquete
    @Override
    public void actualizar(Tiquete tiquete) {
        String sql = "UPDATE Tiquete SET tipo = ?, fechaAdquisicion = ?, estadoAdquisicion = ?, cliente_id = ? WHERE id = ?";

        try (Connection con = ConexionDB.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tiquete.getTipo());
            ps.setDate(2, Date.valueOf(tiquete.getFechaAdquisicion()));
            ps.setString(3, tiquete.getEstadoAdquisicion());
            ps.setInt(4, tiquete.getClienteAsociado().getId());
            ps.setInt(5, tiquete.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un tiquete por su ID
    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Tiquete WHERE id = ?";

        try (Connection con = ConexionDB.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
