/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.service;

import java.util.List;
import pe.edu.cibertec.springboot.dto.CategoriaDto;

/**
 *
 * @author Java-LM
 */
public interface CategoriaService {
    List<CategoriaDto> obtenerTodos();
    CategoriaDto crear(CategoriaDto categoriaDto, Long idUsuario);
    public CategoriaDto obtenerPorId(Long id);
}
