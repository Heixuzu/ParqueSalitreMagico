
import controlador.AtraccionControlador;
import controlador.ClienteControlador;
import controlador.EmpleadoControlador;
import controlador.EstacionControlador;
import controlador.TiqueteControlador;
import controlador.VisitasControlador;
import java.time.LocalDate;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import modelo.Atraccion;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Estacion;
import modelo.Tiquete;
import modelo.Visitas;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Heidy
 */
public class Pruebas { 
    
    @Test
    public void testModeloAtraccion() {
        // Crear un objeto Atraccion con todos los parámetros del constructor
        Atraccion atraccion = new Atraccion(1, 
                                            "Montaña Rusa", 
                                            "Una montaña rusa increíble", 
                                            "Adrenalina", 
                                            "No apto para personas con problemas de corazón.", 
                                            "Habilitada", 
                                            1.5);

        // Comprobar que los atributos se asignan correctamente
        assertEquals(1, atraccion.getId());
        assertEquals("Montaña Rusa", atraccion.getNombre());
        assertEquals("Una montaña rusa increíble", atraccion.getDescripcion());
        assertEquals("Adrenalina", atraccion.getClasificacion());
        assertEquals("No apto para personas con problemas de corazón.", atraccion.getCondicionesUso());
        assertEquals("Habilitada", atraccion.getEstado());
        assertEquals(1.5, atraccion.getAlturaMinima(), 0.01);
    }
    
    @Test
    public void testModeloEmpleado() {
        // Crear un objeto Empleado con todos los parámetros del constructor
        Empleado empleado = new Empleado(1, // ID
                                          12345678, // Cédula
                                          "Juan Pérez", // Nombre
                                          987654321, // Teléfono
                                          "juan.perez@example.com", // Email
                                          "Mañana", // Horario
                                          "Administrativo"); // Tipo

        // Comprobar que los atributos se asignan correctamente
        assertEquals(1, empleado.getId());
        assertEquals(12345678, empleado.getCedula());
        assertEquals("Juan Pérez", empleado.getNombre());
        assertEquals(987654321, empleado.getTelefono());
        assertEquals("juan.perez@example.com", empleado.getEmail());
        assertEquals("mañana", empleado.getHorario()); // Normalizado a minúsculas
        assertEquals("Administrativo", empleado.getTipo());
    }
    
    @Test
    public void testModeloEstacion() {
        // Crear un objeto Estacion con todos los parámetros del constructor
        Estacion estacion = new Estacion(1, "Centro", "Habilitada");

        // Comprobar que los atributos se asignan correctamente
        assertEquals(1, estacion.getId());
        assertEquals("Centro", estacion.getUbicacion());
        assertEquals("Habilitada", estacion.getEstado());
    }
    
    @Test
    public void testModeloTiquete() {
        // Crear un cliente asociado
        Cliente cliente = new Cliente(
            12345678,    // Cédula
            "Ana Pérez", // Nombre
            123456789,   // Teléfono
            "ana.perez@example.com", // Email
            1.65,        // Estatura
            16,          // Edad
            987654321    // Contacto (requerido porque es menor de edad)
        );

        // Crear un objeto Tiquete
        Tiquete tiquete = new Tiquete("Premium", LocalDate.now(), "Activo", cliente);

        // Verificar los valores iniciales
        assertEquals("Premium", tiquete.getTipo());
        assertEquals("Activo", tiquete.getEstadoAdquisicion());
        assertEquals(cliente, tiquete.getClienteAsociado());
    }
    
    @Test
    public void testModeloVisitas() {
        // Crear objetos asociados
        Cliente cliente = new Cliente(12345678, "Ana Pérez", 123456789, "ana.perez@example.com", 1.65, 30, null);
        Tiquete tiquete = new Tiquete("Premium", LocalDate.now(), "Activo", cliente);

        // Crear objeto Visitas usando el constructor
        Visitas visita = new Visitas(cliente, tiquete);

        // Validar atributos con getters
        assertEquals("El cliente asociado no coincide", cliente, visita.getClienteAsociado());
        assertEquals("El tiquete asociado no coincide", tiquete, visita.getTiqueteAsociado());
    }

}

