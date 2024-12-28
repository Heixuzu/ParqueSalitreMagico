/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Heidy
 */
import modelo.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    void insertar(Empleado empleado);
    Empleado leerPorId(int id);
    Empleado leerPorCedula(int cedula);
    List<Empleado> leerTodos();
    void actualizar(Empleado empleado);
    void eliminar(int id);
}
