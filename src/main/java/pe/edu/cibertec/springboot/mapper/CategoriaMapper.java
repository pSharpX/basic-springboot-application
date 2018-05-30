/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.mapper;

import java.util.List;
import java.util.stream.Collectors;
import pe.edu.cibertec.springboot.domain.Categoria;
import pe.edu.cibertec.springboot.dto.CategoriaDto;

/**
 *
 * @author Java-LM
 */
public interface CategoriaMapper {
    CategoriaDto map(Categoria categoria);
    Categoria map(CategoriaDto categoria);
    
    default List<CategoriaDto> mapToListOf(List<Categoria> categorias){
        return categorias.stream().map(this::map).collect(Collectors.toList());
    }
}
