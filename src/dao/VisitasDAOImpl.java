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
import modelo.Visitas;
import modelo.Cliente;
import modelo.Tiquete;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitasDAOImpl implements VisitasDAO {

    @Override
    public void insertar(Visitas visita) {
        String sql = "INSERT INTO Visitas (cliente_id, tiquete_id) VALUES (?, ?)";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, visita.getClienteAsociado().getId());
            stmt.setInt(2, visita.getTiqueteAsociado().getId());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    visita.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Visitas leerPorId(int id) {
        Visitas visita = null;
        String sql = """
            SELECT v.id, v.cliente_id, v.tiquete_id, 
                   c.cedula AS cliente_cedula, c.nombre AS cliente_nombre, 
                   c.telefono AS cliente_telefono, c.email AS cliente_email, 
                   c.estatura AS cliente_estatura, c.edad AS cliente_edad, 
                   c.contacto AS cliente_contacto,
                   t.tipo AS tiquete_tipo, t.fechaAdquisicion AS tiquete_fechaAdquisicion, 
                   t.estadoAdquisicion AS tiquete_estadoAdquisicion
            FROM Visitas v
            JOIN Cliente c ON v.cliente_id = c.id
            JOIN Tiquete t ON v.tiquete_id = t.id
            WHERE v.id = ?
        """;

        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    // Crear el cliente
                    Cliente cliente = new Cliente(
                        resultSet.getInt("cliente_id"),
                        resultSet.getInt("cliente_cedula"),
                        resultSet.getString("cliente_nombre"),
                        resultSet.getInt("cliente_telefono"),
                        resultSet.getString("cliente_email"),
                        resultSet.getDouble("cliente_estatura"),
                        resultSet.getInt("cliente_edad"),
                        resultSet.getObject("cliente_contacto", Integer.class) // Manejar null
                    );

                    // Crear el tiquete
                    Tiquete tiquete = new Tiquete(
                        resultSet.getInt("tiquete_id"),
                        resultSet.getString("tiquete_tipo"),
                        resultSet.getDate("tiquete_fechaAdquisicion").toLocalDate(),
                        resultSet.getString("tiquete_estadoAdquisicion"),
                        cliente // Esto puede variar según la relación esperada
                    );

                    // Crear la visita
                    visita = new Visitas(
                        resultSet.getInt("id"),
                        cliente,
                        tiquete
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visita;
    }


    @Override
    public List<Visitas> leerTodas() {
        List<Visitas> visitas = new ArrayList<>();
        String sql = """
            SELECT v.id, v.cliente_id, v.tiquete_id, 
                   c.cedula AS cliente_cedula, c.nombre AS cliente_nombre, 
                   c.telefono AS cliente_telefono, c.email AS cliente_email, 
                   c.estatura AS cliente_estatura, c.edad AS cliente_edad, 
                   c.contacto AS cliente_contacto,
                   t.tipo AS tiquete_tipo, t.fechaAdquisicion AS tiquete_fechaAdquisicion, 
                   t.estadoAdquisicion AS tiquete_estadoAdquisicion
            FROM Visitas v
            JOIN Cliente c ON v.cliente_id = c.id
            JOIN Tiquete t ON v.tiquete_id = t.id
        """;

        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                // Crear el cliente
                Cliente cliente = new Cliente(
                    resultSet.getInt("cliente_id"),
                    resultSet.getInt("cliente_cedula"),
                    resultSet.getString("cliente_nombre"),
                    resultSet.getInt("cliente_telefono"),
                    resultSet.getString("cliente_email"),
                    resultSet.getDouble("cliente_estatura"),
                    resultSet.getInt("cliente_edad"),
                    resultSet.getObject("cliente_contacto", Integer.class) // Manejar null
                );

                // Crear el tiquete
                Tiquete tiquete = new Tiquete(
                    resultSet.getInt("tiquete_id"),
                    resultSet.getString("tiquete_tipo"),
                    resultSet.getDate("tiquete_fechaAdquisicion").toLocalDate(),
                    resultSet.getString("tiquete_estadoAdquisicion"),
                    cliente // Esto puede variar según la relación esperada
                );

                // Crear la visita
                Visitas visita = new Visitas(
                    resultSet.getInt("id"),
                    cliente,
                    tiquete
                );
                visitas.add(visita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitas;
    }


    @Override
    public void actualizar(Visitas visita) {
        String sql = "UPDATE Visitas SET cliente_id = ?, tiquete_id = ? WHERE id = ?";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, visita.getClienteAsociado().getId());
            stmt.setInt(2, visita.getTiqueteAsociado().getId());
            stmt.setInt(3, visita.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Visitas WHERE id = ?";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

