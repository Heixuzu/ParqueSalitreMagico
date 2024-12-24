/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EstacionDAO;
import dao.EstacionDAOImpl;
import modelo.Estacion;
import java.util.List;

public class EstacionControlador {
    private final EstacionDAO estacionDAO;

    public EstacionControlador() {
        // Se instancia el DAO
        this.estacionDAO = new EstacionDAOImpl();
    }

    // Método para insertar una nueva estación
    public void insertarEstacion(String ubicacion, String estado) {
        if (ubicacion == null || ubicacion.isEmpty() || estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("Ubicación y estado no pueden estar vacíos");
        }
        if (!estado.equalsIgnoreCase("Habilitada") && !estado.equalsIgnoreCase("Deshabilitada")) {
            throw new IllegalArgumentException("El estado debe ser 'Habilitada' o 'Deshabilitada'");
        }

        Estacion estacion = new Estacion();
        estacion.setUbicacion(ubicacion);
        estacion.setEstado(estado);

        estacionDAO.insertar(estacion);
        System.out.println("Estación insertada exitosamente.");
    }

    // Método para leer una estación por su ID
    public Estacion obtenerEstacionPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Estacion estacion = estacionDAO.leerPorId(id);
        if (estacion == null) {
            System.out.println("No se encontró ninguna estación con ID: " + id);
        }
        return estacion;
    }

    // Método para obtener todas las estaciones
    public List<Estacion> obtenerTodasLasEstaciones() {
        return estacionDAO.leerTodas();
    }

    // Método para actualizar una estación
    public void actualizarEstacion(int id, String nuevaUbicacion, String nuevoEstado) {
        if (id <= 0 || nuevaUbicacion == null || nuevaUbicacion.isEmpty() || nuevoEstado == null || nuevoEstado.isEmpty()) {
            throw new IllegalArgumentException("Datos inválidos para actualizar la estación");
        }
        if (!nuevoEstado.equalsIgnoreCase("Habilitada") && !nuevoEstado.equalsIgnoreCase("Inhabilitada")) {
            throw new IllegalArgumentException("El estado debe ser 'Habilitada' o 'Inhabilitada'");
        }

        Estacion estacion = estacionDAO.leerPorId(id);
        if (estacion == null) {
            System.out.println("No se encontró ninguna estación con ID: " + id);
            return;
        }

        estacion.setUbicacion(nuevaUbicacion);
        estacion.setEstado(nuevoEstado);
        estacionDAO.actualizar(estacion);
        System.out.println("Estación actualizada exitosamente.");
    }

    // Método para eliminar una estación por su ID
    public void eliminarEstacion(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Estacion estacion = estacionDAO.leerPorId(id);
        if (estacion == null) {
            System.out.println("No se encontró ninguna estación con ID: " + id);
            return;
        }

        estacionDAO.eliminar(id);
        System.out.println("Estación eliminada exitosamente.");
    }
}


