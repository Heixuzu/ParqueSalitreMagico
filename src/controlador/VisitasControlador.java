/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Heidy
 */

import dao.VisitasDAO;
import dao.VisitasDAOImpl;
import modelo.Visitas;

import java.util.List;

public class VisitasControlador {
    private final VisitasDAO visitasDAO;

    public VisitasControlador() {
        // Se instancia el DAO
        this.visitasDAO = new VisitasDAOImpl();
    }

    // Método para insertar una nueva visita
    public void insertarVisita(Visitas visita) {
        if (visita == null) {
            throw new IllegalArgumentException("La visita no puede ser nula");
        }

        visitasDAO.insertar(visita);
        System.out.println("Visita insertada exitosamente.");
    }

    // Método para leer una visita por su ID
    public Visitas obtenerVisitaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Visitas visita = visitasDAO.leerPorId(id);
        if (visita == null) {
            System.out.println("No se encontró ninguna visita con ID: " + id);
        }
        return visita;
    }

    // Método para obtener todas las visitas
    public List<Visitas> obtenerTodasLasVisitas() {
        return visitasDAO.leerTodas();
    }

    // Método para actualizar una visita
    public void actualizarVisita(int id, Visitas nuevaVisita) {
        if (id <= 0 || nuevaVisita == null) {
            throw new IllegalArgumentException("Datos inválidos para actualizar la visita");
        }

        Visitas visita = visitasDAO.leerPorId(id);
        if (visita == null) {
            System.out.println("No se encontró ninguna visita con ID: " + id);
            return;
        }

        visita.setClienteAsociado(nuevaVisita.getClienteAsociado());
        visita.setTiqueteAsociado(nuevaVisita.getTiqueteAsociado());

        visitasDAO.actualizar(visita);
        System.out.println("Visita actualizada exitosamente.");
    }

    // Método para eliminar una visita por su ID
    public void eliminarVisita(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Visitas visita = visitasDAO.leerPorId(id);
        if (visita == null) {
            System.out.println("No se encontró ninguna visita con ID: " + id);
            return;
        }

        visitasDAO.eliminar(id);
        System.out.println("Visita eliminada exitosamente.");
    }
}
