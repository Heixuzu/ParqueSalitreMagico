/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
/**
 *
 * @author Heidy
 */
import dao.EstacionDAO;
import dao.EstacionDAOImpl;
import java.util.ArrayList;
import modelo.Estacion;
import java.util.List;

public class EstacionControlador {
    private final EstacionDAO estacionDAO;

    public EstacionControlador() {
        // Se instancia el DAO
        this.estacionDAO = new EstacionDAOImpl();
    }

    // Método para insertar una nueva estación
    public void insertarEstacion(Estacion estacion) {
        if (estacion == null) {
            throw new IllegalArgumentException("La estación no puede ser nula");
        }
        if (estacion.getUbicacion() == null || estacion.getUbicacion().isEmpty() || 
            estacion.getEstado() == null || estacion.getEstado().isEmpty()) {
            throw new IllegalArgumentException("Ubicación y estado no pueden estar vacíos");
        }
        if (!estacion.getEstado().equalsIgnoreCase("Habilitada") && 
            !estacion.getEstado().equalsIgnoreCase("Inhabilitada")) {
            throw new IllegalArgumentException("El estado debe ser 'Habilitada' o 'Inhabilitada'");
        }

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
    
    public List<Estacion> obtenerEstacionesHabilitadas() {
        List<Estacion> todasLasEstaciones = obtenerTodasLasEstaciones(); // Obtiene todas las estaciones
        List<Estacion> estacionesHabilitadas = new ArrayList<>();

        // Filtrar solo las estaciones habilitadas
        for (Estacion estacion : todasLasEstaciones) {
            if (estacion.getEstado().equalsIgnoreCase("Habilitada")) {
                estacionesHabilitadas.add(estacion);
            }
        }

        return estacionesHabilitadas;
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


