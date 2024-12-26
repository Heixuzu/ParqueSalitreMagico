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
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, visita.getClienteAsociado().getId());
            preparedStatement.setInt(2, visita.getTiqueteAsociado().getId());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
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
        String sql = "SELECT * FROM Visitas WHERE id = ?";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(resultSet.getInt("cliente_id"));
                    // Completar atributos del cliente si es necesario

                    Tiquete tiquete = new Tiquete();
                    tiquete.setId(resultSet.getInt("tiquete_id"));
                    // Completar atributos del tiquete si es necesario

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
        String sql = "SELECT * FROM Visitas";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("cliente_id"));
                // Completar atributos del cliente si es necesario

                Tiquete tiquete = new Tiquete();
                tiquete.setId(resultSet.getInt("tiquete_id"));
                // Completar atributos del tiquete si es necesario

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
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, visita.getClienteAsociado().getId());
            preparedStatement.setInt(2, visita.getTiqueteAsociado().getId());
            preparedStatement.setInt(3, visita.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Visitas WHERE id = ?";
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

