/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.mapper.impl;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.springboot.domain.Categoria;
import pe.edu.cibertec.springboot.dto.CategoriaDto;
import pe.edu.cibertec.springboot.mapper.CategoriaMapper;

/**
 *
 * @author Java-LM
 */
@Component
public class CategoriaMapperDefaultImpl implements CategoriaMapper{

    @Override
    public CategoriaDto map(Categoria categoria) {
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(categoria.getId());
        categoriaDto.setNombre(categoria.getNombre());
        categoriaDto.setDescripcion(categoria.getDescripcion());
        return categoriaDto;
    }

    @Override
    public Categoria map(CategoriaDto categoriaDto) {
        return new Categoria(categoriaDto.getId(), categoriaDto.getNombre(), categoriaDto.getDescripcion());
    }
    
}
