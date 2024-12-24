/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import java.time.LocalDate;
import modelo.Cliente;
import modelo.Tiquete;
import modelo.Visitas;


/**
 *
 * @author Heidy
 */
public class ParqueSalitreMagico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Crear un cliente
        Cliente cliente1 = new Cliente(1, "Juan Pérez", 123456789, "juan.perez@example.com", 1.75, 25, null);

        // Crear un tiquete asociado al cliente
        Tiquete tiquete1 = new Tiquete(101, "Adulto", LocalDate.now(), "Activo", cliente1);

        // Crear una visita asociada al cliente y al tiquete
        Visitas visita1 = new Visitas(1001, cliente1, tiquete1);


        // Crear otro cliente
        Cliente cliente2 = new Cliente(2, "Ana García", 987654321, "ana.garcia@example.com", 1.65, 17, 987654321);

        // Crear un tiquete para el nuevo cliente
        Tiquete tiquete2 = new Tiquete(102, "Niño", LocalDate.now(), "Activo", cliente2);

        // Crear una visita asociada al nuevo cliente y tiquete
        Visitas visita2 = new Visitas(1002, cliente2, tiquete2);

        // Mostrar la información de la segunda visita
        System.out.println(visita2);
    }
    
}
