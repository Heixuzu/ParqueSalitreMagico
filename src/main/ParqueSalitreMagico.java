/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import controlador.AtraccionControlador;
import controlador.EstacionControlador;
import controlador.VisitasControlador;
import controlador.ClienteControlador;
import controlador.EmpleadoControlador;
import controlador.TiqueteControlador;
import dao.EstacionDAO;
import java.time.LocalDate;
import modelo.Cliente;
import modelo.Tiquete;
import modelo.Visitas;
import modelo.Estacion;
import dao.EstacionDAOImpl;
import java.util.List;
import modelo.Atraccion;
import modelo.Empleado;
import vista.Inicio;

/**
 *
 * @author Heidy
 */
public class ParqueSalitreMagico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Inicio inicio = new Inicio();
            inicio.setLocationRelativeTo(null);
            inicio.setVisible(true);
        });
    }
}
 