/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Heidy
 */

public class Persona {
    // Atributos comunes
    private int id;
    private int cedula;
    private String nombre;
    private int telefono;
    private String email;

    // Constructor
    public Persona(int id, int cedula, String nombre, int telefono, String email) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Persona(){
        
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método común
    @Override
    public String toString() {
        return "Persona{" +
               "id=" + id +
               ", cedula=" + cedula +
               ", nombre='" + nombre + '\'' +
               ", telefono=" + telefono +
               ", email='" + email + '\'' +
               '}';
    }
}

