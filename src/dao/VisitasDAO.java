/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Heidy
 */

import modelo.Visitas;
import java.util.List;

public interface VisitasDAO {
    void insertar(Visitas visita);
    Visitas leerPorId(int id);
    List<Visitas> leerTodas();
    void actualizar(Visitas visita);
    void eliminar(int id);
}
