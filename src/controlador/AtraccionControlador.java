/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Heidy
 */

import dao.AtraccionDAO;
import dao.AtraccionDAOImpl;
import modelo.Atraccion;
import java.util.List;

public class AtraccionControlador {
    private final AtraccionDAO atraccionDAO;

    public AtraccionControlador() {
        // Instancia del DAO
        this.atraccionDAO = new AtraccionDAOImpl();
    }

    // Método para insertar una nueva atracción
    public void insertarAtraccion(Atraccion atraccion) {
        if (atraccion == null) {
            throw new IllegalArgumentException("La atracción no puede ser nula");
        }
        if (atraccion.getNombre() == null || atraccion.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (atraccion.getDescripcion() == null || atraccion.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (atraccion.getClasificacion() == null || 
           (!atraccion.getClasificacion().equals("Familiar") && 
            !atraccion.getClasificacion().equals("Adrenalina") && 
            !atraccion.getClasificacion().equals("Infantil"))) {
            throw new IllegalArgumentException("Clasificación inválida");
        }
        if (atraccion.getEstado() == null || 
           (!atraccion.getEstado().equals("Habilitada") && 
            !atraccion.getEstado().equals("Daño") && 
            !atraccion.getEstado().equals("Mantenimiento"))) {
            throw new IllegalArgumentException("Estado inválido");
        }
        if (atraccion.getAlturaMinima() < 0) {
            throw new IllegalArgumentException("La altura mínima debe ser un valor positivo");
        }

        atraccionDAO.insertar(atraccion);
        System.out.println("Atracción insertada exitosamente.");
    }

    // Método para obtener una atracción por ID
    public Atraccion obtenerAtraccionPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Atraccion atraccion = atraccionDAO.leerPorId(id);
        if (atraccion == null) {
            System.out.println("No se encontró ninguna atracción con ID: " + id);
        }
        return atraccion;
    }

    // Método para obtener todas las atracciones
    public List<Atraccion> obtenerTodasLasAtracciones() {
        return atraccionDAO.leerTodas();
    }

    // Método para actualizar una atracción
    public void actualizarAtraccion(int id, Atraccion nuevaAtraccion) {
        if (id <= 0 || nuevaAtraccion == null) {
            throw new IllegalArgumentException("Datos inválidos para actualizar la atracción");
        }
        if (nuevaAtraccion.getNombre() == null || nuevaAtraccion.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (nuevaAtraccion.getDescripcion() == null || nuevaAtraccion.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (nuevaAtraccion.getClasificacion() == null || 
           (!nuevaAtraccion.getClasificacion().equals("Familiar") && 
            !nuevaAtraccion.getClasificacion().equals("Adrenalina") && 
            !nuevaAtraccion.getClasificacion().equals("Infantil"))) {
            throw new IllegalArgumentException("Clasificación inválida");
        }
        if (nuevaAtraccion.getEstado() == null || 
           (!nuevaAtraccion.getEstado().equals("Habilitada") && 
            !nuevaAtraccion.getEstado().equals("Daño") && 
            !nuevaAtraccion.getEstado().equals("Mantenimiento"))) {
            throw new IllegalArgumentException("Estado inválido");
        }
        if (nuevaAtraccion.getAlturaMinima() < 0) {
            throw new IllegalArgumentException("La altura mínima debe ser un valor positivo");
        }

        Atraccion atraccion = atraccionDAO.leerPorId(id);
        if (atraccion == null) {
            System.out.println("No se encontró ninguna atracción con ID: " + id);
            return;
        }

        atraccion.setNombre(nuevaAtraccion.getNombre());
        atraccion.setDescripcion(nuevaAtraccion.getDescripcion());
        atraccion.setClasificacion(nuevaAtraccion.getClasificacion());
        atraccion.setCondicionesUso(nuevaAtraccion.getCondicionesUso());
        atraccion.setEstado(nuevaAtraccion.getEstado());
        atraccion.setAlturaMinima(nuevaAtraccion.getAlturaMinima());

        atraccionDAO.actualizar(atraccion);
        System.out.println("Atracción actualizada exitosamente.");
    }

    // Método para eliminar una atracción por ID
    public void eliminarAtraccion(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Atraccion atraccion = atraccionDAO.leerPorId(id);
        if (atraccion == null) {
            System.out.println("No se encontró ninguna atracción con ID: " + id);
            return;
        }

        atraccionDAO.eliminar(id);
        System.out.println("Atracción eliminada exitosamente.");
    }
}
