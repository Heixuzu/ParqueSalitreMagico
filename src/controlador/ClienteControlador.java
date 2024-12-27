/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;
/**
 *
 * @author Heidy
 */
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import modelo.Cliente;
import java.util.List;

public class ClienteControlador {
    private final ClienteDAO clienteDAO;

    public ClienteControlador() {
        // Se instancia el DAO
        this.clienteDAO = new ClienteDAOImpl();
    }

    // Método para insertar un nuevo cliente
    public void insertarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (cliente.getCedula() <= 0) {
            throw new IllegalArgumentException("La cédula debe ser un número positivo");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (cliente.getTelefono() <= 0) {
            throw new IllegalArgumentException("El teléfono debe ser un número válido");
        }
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (cliente.getEstatura() <= 0) {
            throw new IllegalArgumentException("La estatura debe ser un valor positivo");
        }
        if (cliente.getEdad() <= 0) {
            throw new IllegalArgumentException("La edad debe ser un valor positivo");
        }

        clienteDAO.insertar(cliente);
        System.out.println("Cliente insertado exitosamente.");
    }

    // Método para leer un cliente por su ID
    public Cliente obtenerClientePorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Cliente cliente = clienteDAO.leerPorId(id);
        if (cliente == null) {
            System.out.println("No se encontró ningún cliente con ID: " + id);
        }
        return cliente;
    }
    
    // Método para obtener un cliente por su cédula
    public Cliente obtenerClientePorCedula(int cedula) {
        if (cedula <= 0) {
            throw new IllegalArgumentException("La cédula debe ser mayor que 0");
        }

        Cliente cliente = clienteDAO.leerPorCedula(cedula);
        if (cliente == null) {
            System.out.println("No se encontró ningún cliente con cédula: " + cedula);
        }
        return cliente;
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.leerTodos();
    }

    // Método para actualizar un cliente
    public void actualizarCliente(int id, Cliente nuevoCliente) {
        if (id <= 0 || nuevoCliente == null) {
            throw new IllegalArgumentException("Datos inválidos para actualizar el cliente");
        }
        if (nuevoCliente.getCedula() <= 0) {
            throw new IllegalArgumentException("La cédula debe ser un número positivo");
        }
        if (nuevoCliente.getNombre() == null || nuevoCliente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (nuevoCliente.getTelefono() <= 0) {
            throw new IllegalArgumentException("El teléfono debe ser un número válido");
        }
        if (nuevoCliente.getEmail() == null || nuevoCliente.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (nuevoCliente.getEstatura() <= 0) {
            throw new IllegalArgumentException("La estatura debe ser un valor positivo");
        }
        if (nuevoCliente.getEdad() <= 0) {
            throw new IllegalArgumentException("La edad debe ser un valor positivo");
        }

        Cliente cliente = clienteDAO.leerPorId(id);
        if (cliente == null) {
            System.out.println("No se encontró ningún cliente con ID: " + id);
            return;
        }

        cliente.setCedula(nuevoCliente.getCedula());
        cliente.setNombre(nuevoCliente.getNombre());
        cliente.setTelefono(nuevoCliente.getTelefono());
        cliente.setEmail(nuevoCliente.getEmail());
        cliente.setEstatura(nuevoCliente.getEstatura());
        cliente.setEdad(nuevoCliente.getEdad());
        cliente.setContacto(nuevoCliente.getContacto());

        clienteDAO.actualizar(cliente);
        System.out.println("Cliente actualizado exitosamente.");
    }

    // Método para eliminar un cliente por su ID
    public void eliminarCliente(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Cliente cliente = clienteDAO.leerPorId(id);
        if (cliente == null) {
            System.out.println("No se encontró ningún cliente con ID: " + id);
            return;
        }

        clienteDAO.eliminar(id);
        System.out.println("Cliente eliminado exitosamente.");
    }
}
