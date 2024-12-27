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
import modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    @Override
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO Empleado (cedula, nombre, telefono, email, horario, tipo)" + " VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empleado.getCedula());
            stmt.setString(2, empleado.getNombre());
            stmt.setInt(3, empleado.getTelefono());
            stmt.setString(4, empleado.getEmail());
            stmt.setString(5, empleado.getHorario());
            stmt.setString(6, empleado.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Empleado leerPorId(int id) {
        String sql = "SELECT * FROM Empleado WHERE id = ?"; 
        Empleado empleado = null;
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                empleado = new Empleado(
                    rs.getInt("id"),
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs.getString("email"),
                    rs.getString("horario"),
                    rs.getString("tipo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return empleado;
    }

    @Override
    public List<Empleado> leerTodos() {
        String sql = "SELECT * FROM Empleado";
        List<Empleado> empleados = new ArrayList<>();
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                    rs.getInt("id"),
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs.getString("email"),
                    rs.getString("horario"),
                    rs.getString("tipo")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return empleados;
    }

    @Override
    public void actualizar(Empleado empleado) {
        String sql = "UPDATE Empleado SET cedula = ?, nombre = ?, telefono = ?, email = ?, horario = ?, tipo = ? WHERE id = ?";
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empleado.getCedula());
            stmt.setString(2, empleado.getNombre());
            stmt.setInt(3, empleado.getTelefono());
            stmt.setString(4, empleado.getEmail());
            stmt.setString(5, empleado.getHorario());
            stmt.setString(6, empleado.getTipo());
            stmt.setInt(7, empleado.getId());

            stmt.executeUpdate();
   
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Empleado WHERE id = ?";
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el empleado", e);
        }
    }
}
