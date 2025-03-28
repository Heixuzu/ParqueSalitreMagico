/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import basededatos.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Heidy
 */
public class Estacion {
    // Atributos
    private int id;
    private String ubicacion;
    private String estado; // "Habilitada" o "Inhabilitada"
    
    //Constructor para insertar
    public Estacion(String ubicacion, String estado) {
        this.ubicacion = ubicacion;
        setEstado(estado); // Validar estado
    }
    
    // Constructor para leer, actualizar y eiminar
    public Estacion(int id, String ubicacion, String estado) {
        this.id = id;
        this.ubicacion = ubicacion;
        setEstado(estado); // Validar estado
    }

    public Estacion() {
        
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstado(String estado) {
        // Validar que el estado sea "Habilitada" o "Inhabilitada"
        if (estado.equalsIgnoreCase("Habilitada") || estado.equalsIgnoreCase("Inhabilitada")) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("Estado no válido: " + estado);
        }
    }

    // Método para mostrar información de la estación
    @Override
    public String toString() {
        return "Estacion{" +
               "id=" + id +
               ", ubicacion='" + ubicacion + '\'' +
               ", estado='" + estado + '\'' +
               '}';
    }   

}

