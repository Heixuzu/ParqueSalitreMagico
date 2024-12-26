/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Atraccion;

/**
 *
 * @author Heidy
 */
public interface AtraccionDAO {
    void insertar(Atraccion atraccion);
    Atraccion leerPorId(int id);
    List<Atraccion> leerTodas();
    void actualizar(Atraccion atraccion);
    void eliminar(int id);
}
