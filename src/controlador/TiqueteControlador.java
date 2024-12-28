/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Heidy
 */

import dao.TiqueteDAO;
import dao.TiqueteDAOImpl;
import modelo.Tiquete;
import modelo.Cliente;
import java.util.List;

public class TiqueteControlador {
    private final TiqueteDAO tiqueteDAO;

    public TiqueteControlador() {
        // Se instancia el DAO
        this.tiqueteDAO = new TiqueteDAOImpl();
    }

    // Método para insertar un nuevo tiquete
    public Tiquete insertarTiquete(Tiquete tiquete) {
        if (tiquete == null) {
            throw new IllegalArgumentException("El tiquete no puede ser nulo");
        }
        if (tiquete.getTipo() == null || tiquete.getTipo().isEmpty()) {
            throw new IllegalArgumentException("El tipo de tiquete no puede estar vacío");
        }
        if (tiquete.getFechaAdquisicion() == null) {
            throw new IllegalArgumentException("La fecha de adquisición no puede ser nula");
        }
        if (tiquete.getEstadoAdquisicion() == null || tiquete.getEstadoAdquisicion().isEmpty()) {
            throw new IllegalArgumentException("El estado de adquisición no puede estar vacío");
        }
        if (tiquete.getClienteAsociado() == null) {
            throw new IllegalArgumentException("El cliente asociado no puede ser nulo");
        }

        // Llamar al método insertar del DAO y obtener el tiquete con el id asignado
        Tiquete tiqueteConId = tiqueteDAO.insertar(tiquete);

        // Imprimir un mensaje de éxito
        System.out.println("Tiquete insertado exitosamente con ID: " + tiqueteConId.getId());

        // Devolver el objeto tiquete con el ID asignado
        return tiqueteConId;
    }


    // Método para leer un tiquete por su ID
    public Tiquete obtenerTiquetePorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Tiquete tiquete = tiqueteDAO.leerPorId(id);
        if (tiquete == null) {
            System.out.println("No se encontró ningún tiquete con ID: " + id);
        }
        return tiquete;
    }

    // Método para obtener todos los tiquetes
    public List<Tiquete> obtenerTodosLosTiquetes() {
        return tiqueteDAO.leerTodos();
    }

    // Método para actualizar un tiquete
    public void actualizarTiquete(int id, Tiquete nuevoTiquete) {
        if (id <= 0 || nuevoTiquete == null) {
            throw new IllegalArgumentException("Datos inválidos para actualizar el tiquete");
        }
        if (nuevoTiquete.getTipo() == null || nuevoTiquete.getTipo().isEmpty()) {
            throw new IllegalArgumentException("El tipo de tiquete no puede estar vacío");
        }
        if (nuevoTiquete.getFechaAdquisicion() == null) {
            throw new IllegalArgumentException("La fecha de adquisición no puede ser nula");
        }
        if (nuevoTiquete.getEstadoAdquisicion() == null || nuevoTiquete.getEstadoAdquisicion().isEmpty()) {
            throw new IllegalArgumentException("El estado de adquisición no puede estar vacío");
        }
        if (nuevoTiquete.getClienteAsociado() == null) {
            throw new IllegalArgumentException("El cliente asociado no puede ser nulo");
        }

        Tiquete tiquete = tiqueteDAO.leerPorId(id);
        if (tiquete == null) {
            System.out.println("No se encontró ningún tiquete con ID: " + id);
            return;
        }

        tiquete.setTipo(nuevoTiquete.getTipo());
        tiquete.setFechaAdquisicion(nuevoTiquete.getFechaAdquisicion());
        tiquete.setEstadoAdquisicion(nuevoTiquete.getEstadoAdquisicion());
        tiquete.setClienteAsociado(nuevoTiquete.getClienteAsociado());

        tiqueteDAO.actualizar(tiquete);
        System.out.println("Tiquete actualizado exitosamente.");
    }

    // Método para eliminar un tiquete por su ID
    public void eliminarTiquete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Tiquete tiquete = tiqueteDAO.leerPorId(id);
        if (tiquete == null) {
            System.out.println("No se encontró ningún tiquete con ID: " + id);
            return;
        }

        tiqueteDAO.eliminar(id);
        System.out.println("Tiquete eliminado exitosamente.");
    }
    
    public Cliente obtenerClientePorTiquete(int tiqueteId) {
        // Obtener el Tiquete por ID
        Tiquete tiquete = tiqueteDAO.leerPorId(tiqueteId);

        if (tiquete != null) {
            // Retornar el cliente asociado al tiquete
            return tiquete.getClienteAsociado();
        } else {
            System.out.println("No se encontró el tiquete con ID: " + tiqueteId);
            return null;  // Retorna null si no se encuentra el tiquete
        }
    }

}
