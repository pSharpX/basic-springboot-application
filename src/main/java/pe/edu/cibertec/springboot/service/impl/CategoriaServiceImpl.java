/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.service.impl;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.springboot.application.annotation.BusinessService;
import pe.edu.cibertec.springboot.dao.CategoriaDao;
import pe.edu.cibertec.springboot.domain.Categoria;
import pe.edu.cibertec.springboot.dto.CategoriaDto;
import pe.edu.cibertec.springboot.mapper.CategoriaMapper;
import pe.edu.cibertec.springboot.service.CategoriaService;
import pe.edu.cibertec.springboot.utils.Precondiciones;
import pe.edu.cibertec.springboot.utils.SoporteCache;

/**
 *
 * @author Java-LM
 */
//@Service
@BusinessService
public class CategoriaServiceImpl 
        implements CategoriaService, SoporteCache<CategoriaDto>{
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Autowired
    private CategoriaMapper categoriaMapper;
    
    @Override
    public List<CategoriaDto> obtenerTodos() {
        return categoriaMapper.mapToListOf(categoriaDao.obtenerTodos());
    }

    @Override
    public CategoriaDto crear(CategoriaDto categoriaDto, @NotNull Long idUsuario) {
        Precondiciones.revisarArgumento(categoriaDto != null, 
                "Objeto a insertar es nulo");
        Precondiciones.revisarArgumento(categoriaDto.getNombre(), 
                "Nombre de categoia es inválida");
        //regla: el nombre de la categoria debe tener por lo menos 4 caracteres
        categoriaDto.setNombre(categoriaDto.getNombre().trim());
        Precondiciones.revisarArgumento(categoriaDto.getNombre().length() >= 4, 
                "Nombre de categria debe tener por lo menos 4 caracteres.");
        Precondiciones.revisarArgumento(categoriaDto.getNombre().length() <= 100, 
                "Nombre de categria debe tener como máximo 100 caracteres.");
        
        Precondiciones.revisarArgumento(
                categoriaDao.busquedaPorNombre(categoriaDto.getNombre()) == null,
                String.format("Categoria con nombre %s ya existe", categoriaDto.getNombre()));
        
        Categoria nuevaCategoria = categoriaMapper.map(categoriaDto);
        nuevaCategoria.setFechaCreacion(new Date());
        nuevaCategoria.setIdUsuarioCreacion(idUsuario);
        return categoriaMapper.map(categoriaDao.crear(nuevaCategoria));
    }

    @Override
    public CategoriaDto obtenerPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdentificador() {
        return "ALL_CATEGORIAS";
    }
    
}
