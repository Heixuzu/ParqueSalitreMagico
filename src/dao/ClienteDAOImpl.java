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
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (cedula, nombre, telefono, email, estatura, edad, contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombre());
            stmt.setInt(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.setDouble(5, cliente.getEstatura());
            stmt.setInt(6, cliente.getEdad());
            stmt.setObject(7, cliente.getContacto(), Types.INTEGER); // Permite valores nulos
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente leerPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        try (Connection conn = ConexionDB.getConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCliente(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> leerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";
        try (Connection conn = ConexionDB.getConexion(); 
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                clientes.add(mapResultSetToCliente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET cedula = ?, nombre = ?, telefono = ?, email = ?, estatura = ?, edad = ?, contacto = ? WHERE id = ?";
        try (Connection conn = ConexionDB.getConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombre());
            stmt.setInt(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.setDouble(5, cliente.getEstatura());
            stmt.setInt(6, cliente.getEdad());
            stmt.setObject(7, cliente.getContacto(), Types.INTEGER);
            stmt.setInt(8, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (Connection conn = ConexionDB.getConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para mapear el ResultSet a un objeto Cliente
    private Cliente mapResultSetToCliente(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int cedula = rs.getInt("cedula");
        String nombre = rs.getString("nombre");
        int telefono = rs.getInt("telefono");
        String email = rs.getString("email");
        double estatura = rs.getDouble("estatura");
        int edad = rs.getInt("edad");
        Integer contacto = (rs.getObject("contacto") != null) ? rs.getInt("contacto") : null;

        return new Cliente(id, cedula, nombre, telefono, email, estatura, edad, contacto);
    }
}
