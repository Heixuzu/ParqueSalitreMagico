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
        String sql = "INSERT INTO Cliente (cedula, nombre, telefono, email, estatura, edad, contacto)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
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
        Cliente cliente = null;
        
        try (Connection conn = ConexionDB.getConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs.getString("email"),
                    rs.getDouble("estatura"),
                    rs.getInt("edad"),
                    (rs.getObject("contacto") != null) ? rs.getInt("contacto") : null    
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public Cliente leerPorCedula(int cedula) {
        String sql = "SELECT * FROM Cliente WHERE cedula = ?";
        Cliente cliente = null;

        try (Connection conn = ConexionDB.getConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cedula);  // Establecer la cédula en la consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Crear el objeto Cliente con los datos obtenidos de la base de datos
                cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs.getString("email"),
                    rs.getDouble("estatura"),
                    rs.getInt("edad"),
                    (rs.getObject("contacto") != null) ? rs.getInt("contacto") : null    
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> leerTodos() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();
        
        try (Connection conn = ConexionDB.getConexion(); 
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs.getString("email"),
                    rs.getDouble("estatura"),
                    rs.getInt("edad"),
                    (rs.getObject("contacto") != null) ? rs.getInt("contacto") : null    
                );
                clientes.add(cliente);
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

}
