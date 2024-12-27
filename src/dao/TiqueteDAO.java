/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Heidy
 */

import modelo.Tiquete;
import java.util.List;

public interface TiqueteDAO {
    Tiquete insertar(Tiquete tiquete);
    Tiquete leerPorId(int id);
    List<Tiquete> leerTodos();
    void actualizar(Tiquete tiquete);
    void eliminar(int id);
}
