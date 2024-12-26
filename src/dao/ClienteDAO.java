/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Heidy
 */

import modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    void insertar(Cliente cliente);
    Cliente leerPorId(int id);
    List<Cliente> leerTodos();
    void actualizar(Cliente cliente);
    void eliminar(int id);
}

