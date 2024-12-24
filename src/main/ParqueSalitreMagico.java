/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import controlador.EstacionControlador;
import dao.EstacionDAO;
import java.time.LocalDate;
import modelo.Cliente;
import modelo.Tiquete;
import modelo.Visitas;
import modelo.Estacion;
import dao.EstacionDAOImpl;

/**
 *
 * @author Heidy
 */
public class ParqueSalitreMagico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EstacionControlador controlador = new EstacionControlador();

        // Insertar una estación
        controlador.insertarEstacion("Zona Norte", "Habilitada");

        // Leer una estación por ID
        Estacion estacion = controlador.obtenerEstacionPorId(1);
        if (estacion != null) {
            System.out.println("Estación encontrada: " + estacion);
        }

        // Actualizar una estación
        controlador.actualizarEstacion(1, "Zona Sur", "Inhabilitada");

        // Eliminar una estación
        controlador.eliminarEstacion(1);
    }
}
