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
import java.util.ArrayList;
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
    
    public Atraccion obtenerAtraccionPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la atracción no puede ser nulo ni vacío");
        }

        // Llamamos al DAO para obtener la atracción por nombre
        Atraccion atraccion = atraccionDAO.leerPorNombre(nombre);
        if (atraccion == null) {
            System.out.println("No se encontró ninguna atracción con el nombre: " + nombre);
        }
        return atraccion;
    }
    
   // Método para obtener todas las atracciones habilitadas
    public List<Atraccion> obtenerAtraccionesHabilitadas() {
        List<Atraccion> todasLasAtracciones = atraccionDAO.leerTodas();  // Obtener todas las atracciones
        List<Atraccion> atraccionesHabilitadas = new ArrayList<>();  // Crear una lista para las atracciones habilitadas

        // Filtrar las atracciones habilitadas
        for (Atraccion atraccion : todasLasAtracciones) {
            if ("Habilitada".equalsIgnoreCase(atraccion.getEstado())) {  // Verificar si el estado es "Habilitada"
                atraccionesHabilitadas.add(atraccion);  // Agregar a la lista de habilitadas
            }
        }

        return atraccionesHabilitadas;  // Devolver la lista de atracciones habilitadas
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
    
    // Método para comprobar si un cliente puede ingresar a la atracción según su altura
    public boolean comprobarAlturaMinima(double alturaCliente, int idAtraccion) {
        // Validar la altura del cliente
        if (alturaCliente <= 0) {
            throw new IllegalArgumentException("La altura del cliente debe ser mayor que 0");
        }

        // Obtener la atracción por ID
        Atraccion atraccion = atraccionDAO.leerPorId(idAtraccion);
        if (atraccion == null) {
            System.out.println("No se encontró ninguna atracción con ID: " + idAtraccion);
            return false;  // Si no se encuentra la atracción, devolvemos false
        }

        // Comparar la altura mínima de la atracción con la altura del cliente
        boolean cumpleAlturaMinima = alturaCliente >= atraccion.getAlturaMinima();  // Retorna true si la altura del cliente es suficiente

        if (!cumpleAlturaMinima) {
            // Si no cumple, se podría agregar un log o manejar de otra manera
            System.out.println("El cliente no cumple con la altura mínima para la atracción.");
        }

        return cumpleAlturaMinima;
    }

}
