/*
 * Click nbfs://SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Heidy
 */

public class Cliente extends Persona {
    // Atributos específicos
    private double estatura;
    private int edad;
    private Integer contacto;

    // Constructor
    public Cliente(int id, int cedula, String nombre, int telefono, String email, double estatura, int edad, Integer contacto) {
        super(id, cedula, nombre, telefono, email); // Llama al constructor de Persona
        this.estatura = estatura;
        this.edad = edad;
        this.contacto = (edad < 18) ? contacto : null;
    }
    
    public Cliente(){
        
    }

    // Getters y setters específicos
    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
        if (edad >= 18) {
            this.contacto = null;
        }
    }

    public Integer getContacto() {
        return contacto;
    }

    public void setContacto(Integer contacto) {
        if (this.edad < 18) {
            this.contacto = contacto;
        } else {
            throw new IllegalArgumentException("Solo se puede asignar un contacto si el cliente es menor de 18 años.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Cliente{" +
               "estatura=" + estatura +
               ", edad=" + edad +
               ", contacto=" + (contacto != null ? contacto : "No aplica") +
               '}';
    }
}
