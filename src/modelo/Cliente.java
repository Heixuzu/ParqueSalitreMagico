/*
 * Click nbfs://SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Heidy
 */
public class Cliente {
    // Atributos
    private int id;
    private int cedula; // Ahora en la segunda posición
    private String nombre;
    private int telefono;
    private String email;
    private double estatura;
    private int edad;
    private Integer contacto; // Usamos Integer para manejar el caso de "no aplica"

    // Constructor
    public Cliente(int id, int cedula, String nombre, int telefono, String email, double estatura, int edad, Integer contacto) {
        this.id = id;
        this.cedula = cedula; // Asignar la cédula aquí
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.estatura = estatura;
        this.edad = edad;
        this.contacto = (edad < 18) ? contacto : null; // Validar si es menor de 18 para asignar contacto
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCedula() {
        return cedula; // Obtener la cédula
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

    public double getEstatura() {
        return estatura;
    }

    public int getEdad() {
        return edad;
    }

    public Integer getContacto() {
        return contacto;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula; // Asignar cédula
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

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public void setEdad(int edad) {
        this.edad = edad;

        // Si la edad cambia, verifica si el contacto debe ser nulo
        if (edad >= 18) {
            this.contacto = null;
        }
    }

    public void setContacto(Integer contacto) {
        // Validar si el cliente es menor de 18 años
        if (this.edad < 18) {
            this.contacto = contacto;
        } else {
            throw new IllegalArgumentException("Solo se puede asignar un contacto si el cliente es menor de 18 años.");
        }
    }

    // Método para mostrar información del cliente (opcional)
    @Override
    public String toString() {
        return "Cliente{" +
               "id=" + id +
               ", cedula=" + cedula +  // Mostrar la cédula
               ", nombre='" + nombre + '\'' +
               ", telefono=" + telefono +
               ", email='" + email + '\'' +
               ", estatura=" + estatura +
               ", edad=" + edad +
               ", contacto=" + (contacto != null ? contacto : "No aplica") +
               '}';
    }
}
