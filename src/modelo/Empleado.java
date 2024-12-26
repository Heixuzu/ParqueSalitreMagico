/*
 * Click nbfs://SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Heidy
 */

public class Empleado extends Persona {
    // Atributos
    private String horario;
    private String tipo; // Administrativos, Logística, Publicidad, Operador, Mantenimiento
    
    //Constructor para insertar
    public Empleado(int cedula, String nombre, int telefono, String email, String horario, String tipo) {
        super(cedula, nombre, telefono, email); // Llama al constructor de la clase Persona
        setHorario(horario); // Validar horario al asignarlo
        setTipo(tipo);       // Validar tipo al asignarlo
    }    
    
    // Constructor para leer, actualizar y eiminar
    public Empleado(int id, int cedula, String nombre, int telefono, String email, String horario, String tipo) {
        super(id, cedula, nombre, telefono, email); // Llama al constructor de la clase Persona
        setHorario(horario); // Validar horario al asignarlo
        setTipo(tipo);       // Validar tipo al asignarlo
    }
    
    public Empleado() {
        
    }

    // Getters
    public String getHorario() {
        return horario;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setHorario(String horario) {
        // Validar que el horario sea "mañana", "tarde" o "noche"
        if (horario.equalsIgnoreCase("Mañana") || 
            horario.equalsIgnoreCase("Tarde") || 
            horario.equalsIgnoreCase("Noche")) {
            this.horario = horario.toLowerCase(); // Normaliza a minúsculas
        } else {
            throw new IllegalArgumentException("Horario no válido. Debe ser 'mañana', 'tarde' o 'noche'.");
        }
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
               "id=" + getId() +
               ", cedula=" + getCedula() +
               ", nombre='" + getNombre() + '\'' +
               ", telefono=" + getTelefono() +
               ", email='" + getEmail() + '\'' +
               ", horario='" + horario + '\'' +
               ", tipo='" + tipo + '\'' +
               '}';
    }
}
