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

/**
 *
 * @author Heidy
 */
public class ParqueSalitreMagico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente(1,12345678, "Juan Pérez", 987654321, "juan.perez@example.com", 1.75, 25, null);
        Cliente cliente2 = new Cliente(87654321, "Ana Gómez", 123456789, "ana.gomez@example.com", 1.60, 16, 345678901);
        Cliente cliente3 = new Cliente( 11223344, "Carlos Torres", 112233445, "carlos.torres@example.com", 1.80, 30, null);

        // Mostrar información de los clientes
        System.out.println("Clientes:");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        
        // Crear objetos Tiquete
        Tiquete tiquete1 = new Tiquete( 1,"Premium", LocalDate.now(), "Activo", cliente1);
        Tiquete tiquete2 = new Tiquete( "Estandar", LocalDate.now().minusDays(5), "Usado", cliente1);
        Tiquete tiquete3 = new Tiquete( "Exclusivo", LocalDate.now().minusMonths(1), "Cancelado", cliente3);

        // Mostrar los objetos
        System.out.println(tiquete1);
        System.out.println(tiquete2);
        System.out.println(tiquete3);
        
        // Crear objetos Atraccion
        Atraccion atraccion1 = new Atraccion(1, "Montaña Rusa", "Una montaña rusa de alta velocidad.", "Adrenalina", "No apto para personas con problemas de corazón", "Habilitada", 1.2);
        Atraccion atraccion2 = new Atraccion(2, "Carrusel", "Un carrusel tradicional para toda la familia.", "Familiar", "Apto para todas las edades", "Mantenimiento", 0.9);
        Atraccion atraccion3 = new Atraccion( "Bungee Jumping", "Salto en bungee desde una plataforma alta.", "Adrenalina", "Solo para personas mayores de 18 años", "Daño", 1.5);

        // Mostrar información de las atracciones
        System.out.println(atraccion1);
        System.out.println(atraccion2);
        System.out.println(atraccion3);
        
        Visitas visita1 = new Visitas( cliente1, tiquete1);
        
        // Mostrar los objetos
        System.out.println(visita1);
        
        
        // Crear el controlador
        TiqueteControlador tiqueteControlador = new TiqueteControlador();
        
        VisitasControlador visitasControlador = new VisitasControlador();
        
        AtraccionControlador atraccionControlador = new AtraccionControlador();
        
        atraccionControlador.insertarAtraccion(atraccion3);
        

        
       
             
    }
}
 