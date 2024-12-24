/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Heidy
 */
import modelo.Estacion;
import java.util.List;

public interface EstacionDAO {
    void insertar(Estacion estacion);
    Estacion leerPorId(int id);
    List<Estacion> leerTodas();
    void actualizar(Estacion estacion);
    void eliminar(int id);
}
