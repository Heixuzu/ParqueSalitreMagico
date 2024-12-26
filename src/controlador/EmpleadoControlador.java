/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Heidy
 */
import dao.EmpleadoDAO;
import dao.EmpleadoDAOImpl;
import modelo.Empleado;
import java.util.List;

public class EmpleadoControlador {
    private final EmpleadoDAO empleadoDAO;

    public EmpleadoControlador() {
        // Se instancia el DAO
        this.empleadoDAO = new EmpleadoDAOImpl();
    }

    // Método para insertar un nuevo empleado
    public void insertarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        if (empleado.getCedula() <= 0) {
            throw new IllegalArgumentException("La cédula debe ser un número positivo");
        }
        if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (empleado.getTelefono() <= 0) {
            throw new IllegalArgumentException("El teléfono debe ser un número válido");
        }
        if (empleado.getEmail() == null || empleado.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (empleado.getHorario() == null || empleado.getHorario().isEmpty()) {
            throw new IllegalArgumentException("El horario no puede estar vacío");
        }
        if (empleado.getTipo() == null || empleado.getTipo().isEmpty()) {
            throw new IllegalArgumentException("El tipo de empleado no puede estar vacío");
        }
        if (!empleado.getTipo().matches("Administrativo|Logística|Publicidad|Operador|Mantenimiento")) {
            throw new IllegalArgumentException("El tipo de empleado no es válido");
        }

        empleadoDAO.insertar(empleado);
        System.out.println("Empleado insertado exitosamente.");
    }

    // Método para leer un empleado por su ID
    public Empleado obtenerEmpleadoPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Empleado empleado = empleadoDAO.leerPorId(id);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ID: " + id);
        }
        return empleado;
    }

    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoDAO.leerTodos();
    }

    // Método para actualizar un empleado
    public void actualizarEmpleado(int id, Empleado nuevoEmpleado) {
        if (id <= 0 || nuevoEmpleado == null) {
            throw new IllegalArgumentException("Datos inválidos para actualizar el empleado");
        }
        if (nuevoEmpleado.getCedula() <= 0) {
            throw new IllegalArgumentException("La cédula debe ser un número positivo");
        }
        if (nuevoEmpleado.getNombre() == null || nuevoEmpleado.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (nuevoEmpleado.getTelefono() <= 0) {
            throw new IllegalArgumentException("El teléfono debe ser un número válido");
        }
        if (nuevoEmpleado.getEmail() == null || nuevoEmpleado.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (nuevoEmpleado.getHorario() == null || nuevoEmpleado.getHorario().isEmpty()) {
            throw new IllegalArgumentException("El horario no puede estar vacío");
        }
        if (nuevoEmpleado.getTipo() == null || nuevoEmpleado.getTipo().isEmpty()) {
            throw new IllegalArgumentException("El tipo de empleado no puede estar vacío");
        }
        if (!nuevoEmpleado.getTipo().matches("Administrativo|Logística|Publicidad|Operador|Mantenimiento")) {
            throw new IllegalArgumentException("El tipo de empleado no es válido");
        }

        Empleado empleado = empleadoDAO.leerPorId(id);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ID: " + id);
            return;
        }

        empleado.setCedula(nuevoEmpleado.getCedula());
        empleado.setNombre(nuevoEmpleado.getNombre());
        empleado.setTelefono(nuevoEmpleado.getTelefono());
        empleado.setEmail(nuevoEmpleado.getEmail());
        empleado.setHorario(nuevoEmpleado.getHorario());
        empleado.setTipo(nuevoEmpleado.getTipo());

        empleadoDAO.actualizar(empleado);
        System.out.println("Empleado actualizado exitosamente.");
    }

    // Método para eliminar un empleado por su ID
    public void eliminarEmpleado(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }

        Empleado empleado = empleadoDAO.leerPorId(id);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ID: " + id);
            return;
        }

        empleadoDAO.eliminar(id);
        System.out.println("Empleado eliminado exitosamente.");
    }
}
