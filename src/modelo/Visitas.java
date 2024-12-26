/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Heidy
 */
public class Visitas {
    // Atributos
    private int id;
    private Cliente clienteAsociado; // Instancia de la clase Cliente
    private Tiquete tiqueteAsociado; // Instancia de la clase Tiquete

    // Constructor
    public Visitas(int id, Cliente clienteAsociado, Tiquete tiqueteAsociado) {
        this.id = id;
        this.clienteAsociado = clienteAsociado;
        this.tiqueteAsociado = tiqueteAsociado;
    }
    
    public Visitas(){
        
    }

    // Getters
    public int getId() {
        return id;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public Tiquete getTiqueteAsociado() {
        return tiqueteAsociado;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public void setTiqueteAsociado(Tiquete tiqueteAsociado) {
        this.tiqueteAsociado = tiqueteAsociado;
    }

    // Método para mostrar información de la visita
    @Override
    public String toString() {
        return "Visitas{" +
               "id=" + id +
               ", clienteAsociado=" + clienteAsociado.getNombre() + // Muestra el nombre del cliente
               ", tiqueteAsociado=" + tiqueteAsociado.getId() + // Muestra el ID del tiquete
               '}';
    }
}

