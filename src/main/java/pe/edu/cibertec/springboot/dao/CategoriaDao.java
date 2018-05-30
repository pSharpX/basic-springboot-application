/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.dao;

import java.util.List;
import pe.edu.cibertec.springboot.domain.Categoria;

/**
 *
 * @author Java-LM
 */
public interface CategoriaDao {
    
    List<Categoria> obtenerTodos();
    Categoria crear(Categoria categoria);
    Categoria busquedaPorNombre(String nombre);
}
