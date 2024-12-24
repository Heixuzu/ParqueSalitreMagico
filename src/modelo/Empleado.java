/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Heidy
 */
public class Empleado {
    // Atributos
    private int id;
    private String nombre;
    private int telefono;
    private String email;
    private String horario;
    private String tipo; // Administrativos, Logística, Publicidad, Operador, Mantenimiento

    // Constructor
    public Empleado(int id, String nombre, int telefono, String email, String horario, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.horario = horario;
        setTipo(tipo); // Validar tipo al asignarlo
    }

    // Getters
    public int getId() {
        return id;
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

    public String getHorario() {
        return horario;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
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

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setTipo(String tipo) {
        // Validar que el tipo sea uno de los valores permitidos
        if (tipo.equalsIgnoreCase("Administrativo") || 
            tipo.equalsIgnoreCase("Logística") || 
            tipo.equalsIgnoreCase("Publicidad") || 
            tipo.equalsIgnoreCase("Operador") || 
            tipo.equalsIgnoreCase("Mantenimiento")) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo de empleado no válido: " + tipo);
        }
    }

    // Método para mostrar información del empleado
    @Override
    public String toString() {
        return "Empleado{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", telefono=" + telefono +
               ", email='" + email + '\'' +
               ", horario='" + horario + '\'' +
               ", tipo='" + tipo + '\'' +
               '}';
    }
}

