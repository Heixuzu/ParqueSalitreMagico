/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Heidy
 */
public class Tiquete {
    // Atributos
    private int id;
    private String tipo; // Ej.: "Premium", "Estandar", "Exclusivo"
    private LocalDate fechaAdquisicion;
    private String estadoAdquisicion; // Ej.: "Activo", "Usado", "Cancelado"
    private Cliente clienteAsociado; // Objeto Cliente en lugar de un ID de cliente

    // Constructor para insertar
    public Tiquete(String tipo, LocalDate fechaAdquisicion, String estadoAdquisicion, Cliente clienteAsociado) {
        setTipo(tipo); // Validar tipo al asignarlo
        this.fechaAdquisicion = fechaAdquisicion;
        setEstadoAdquisicion(estadoAdquisicion); // Validar estado al asignarlo
        this.clienteAsociado = clienteAsociado;
    }       

    // Constructor para leer, actualizar y eliminar
    public Tiquete(int id, String tipo, LocalDate fechaAdquisicion, String estadoAdquisicion, Cliente clienteAsociado) {
        this.id = id;
        setTipo(tipo); // Validar tipo al asignarlo
        this.fechaAdquisicion = fechaAdquisicion;
        setEstadoAdquisicion(estadoAdquisicion); // Validar estado al asignarlo
        this.clienteAsociado = clienteAsociado;
    }

    public Tiquete() {
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public String getEstadoAdquisicion() {
        return estadoAdquisicion;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        // Validar que el tipo sea uno de los valores permitidos
        if (tipo.equalsIgnoreCase("Premium") || 
            tipo.equalsIgnoreCase("Estandar") || 
            tipo.equalsIgnoreCase("Exclusivo")) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo de tiquete no válido: " + tipo);
        }
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public void setEstadoAdquisicion(String estadoAdquisicion) {
        // Validar que el estado sea uno de los valores permitidos
        if (estadoAdquisicion.equalsIgnoreCase("Activo") || 
            estadoAdquisicion.equalsIgnoreCase("Usado") || 
            estadoAdquisicion.equalsIgnoreCase("Cancelado")) {
            this.estadoAdquisicion = estadoAdquisicion;
        } else {
            throw new IllegalArgumentException("Estado de adquisición no válido: " + estadoAdquisicion);
        }
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    // Método para mostrar información del tiquete
    @Override
    public String toString() {
        return "Tiquete{" +
               "id=" + id +
               ", tipo='" + tipo + '\'' +
               ", fechaAdquisicion=" + fechaAdquisicion +
               ", estadoAdquisicion='" + estadoAdquisicion + '\'' +
               ", clienteAsociado=" + clienteAsociado.getNombre() + // Muestra el nombre del cliente
               '}';
    }

}
