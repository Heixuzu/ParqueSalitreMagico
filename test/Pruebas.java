
import controlador.AtraccionControlador;
import controlador.ClienteControlador;
import controlador.EmpleadoControlador;
import controlador.EstacionControlador;
import controlador.TiqueteControlador;
import controlador.VisitasControlador;
import java.time.LocalDate;
import modelo.Atraccion;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Estacion;
import modelo.Tiquete;
import modelo.Visitas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Heidy
 */
public class Pruebas {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, 12345678, "Juan Pérez", 987654321, "juan.perez@example.com", 1.75, 25, null);
        Cliente cliente2 = new Cliente(2, 87654321, "Ana Gómez", 123456789, "ana.gomez@example.com", 1.60, 16, 345678901);
        Cliente cliente3 = new Cliente(3, 11223344, "Carlos Torres", 112233445, "carlos.torres@example.com", 1.80, 30, null);

        // Mostrar información de los clientes
        System.out.println("Clientes:");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        
        // Crear objetos Tiquete
        Tiquete tiquete1 = new Tiquete(101, "Premium", LocalDate.now(), "Activo", cliente1);
        Tiquete tiquete2 = new Tiquete(102, "Exclusivo", LocalDate.now().minusDays(5), "Usado", cliente2);
        Tiquete tiquete3 = new Tiquete(103, "Estandar", LocalDate.now().minusMonths(1), "Cancelado", cliente3);

        // Mostrar los objetos
        System.out.println(tiquete1);
        System.out.println(tiquete2);
        System.out.println(tiquete3);
        
        // Crear objetos Visita
        Visitas visita1 = new Visitas(201, cliente1, tiquete1);
        Visitas visita2 = new Visitas(202, cliente2, tiquete2);
        Visitas visita3 = new Visitas(203, cliente3, tiquete3);

        // Mostrar los objetos
        System.out.println(visita1);
        System.out.println(visita2);
        System.out.println(visita3);
        
        // Crear objetos de Empleado
        Empleado administrativo = new Empleado(101, "Carlos Martínez", 12345678, "carlos.martinez@example.com", "Mañana", "Administrativo");
        Empleado logistica = new Empleado(102, "Laura Gómez", 87654321, "laura.gomez@example.com", "Tarde", "Logística");
        Empleado publicidad = new Empleado(103, "Sofía Pérez", 45678912, "sofia.perez@example.com", "Noche", "Publicidad");
        Empleado operador = new Empleado(104, "Luis Hernández", 32165487, "luis.hernandez@example.com", "Mañana", "Operador");
        Empleado mantenimiento = new Empleado(105, "Ana López", 78912345, "ana.lopez@example.com", "Tarde", "Mantenimiento");
        


        
        // Crear estaciones
        Estacion estacion1 = new Estacion(1, "Punto Central", "Habilitada");
        Estacion estacion2 = new Estacion(2, "Estación Oasis", "Inhabilitada");
        Estacion estacion3 = new Estacion(3, "Estacion Alegría", "Habilitada");

        // Mostrar las estaciones
        System.out.println(estacion1);
        System.out.println(estacion2);
        System.out.println(estacion3);
        
        // Crear objetos Atraccion
        Atraccion atraccion1 = new Atraccion(1, "Montaña Rusa", "Una montaña rusa de alta velocidad.", "Adrenalina", "No apto para personas con problemas de corazón", "Habilitada", 1.6);
        Atraccion atraccion2 = new Atraccion(2, "Carrusel", "Un carrusel tradicional para toda la familia.", "Familiar", "Apto para todas las edades", "Habilitada", 1.2);
        Atraccion atraccion3 = new Atraccion(3, "Bungee Jumping", "Salto en bungee desde una plataforma alta.", "Adrenalina", "No apto para personas con problemas de corazón", "Habilitada", 1.5);

        // Mostrar información de las atracciones
        System.out.println(atraccion1);
        System.out.println(atraccion2);
        System.out.println(atraccion3);
        
        // Crear el controlador
        TiqueteControlador tiqueteControlador = new TiqueteControlador();
        
        VisitasControlador visitasControlador = new VisitasControlador();
        
        AtraccionControlador atraccionControlador = new AtraccionControlador();
        
        ClienteControlador clienteControlador = new ClienteControlador();
        
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        
        EstacionControlador estacionControlador = new EstacionControlador();
        
        empleadoControlador.insertarEmpleado(administrativo);
        empleadoControlador.insertarEmpleado(logistica);
        empleadoControlador.insertarEmpleado(publicidad);
        empleadoControlador.insertarEmpleado(operador);
        empleadoControlador.insertarEmpleado(mantenimiento);
        
        System.out.println(tiqueteControlador.obtenerTodosLosTiquetes());     
        
        System.out.println(visitasControlador.obtenerTodasLasVisitas());
        
        System.out.println(clienteControlador.obtenerTodosLosClientes());
        
        System.out.println(empleadoControlador.obtenerTodosLosEmpleados());

    }
}
