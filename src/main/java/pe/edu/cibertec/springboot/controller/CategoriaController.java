/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.springboot.dto.CategoriaDto;
import pe.edu.cibertec.springboot.service.CategoriaService;

/**
 *
 * @author Java-LM
 */
@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping(path = {"", "/"})
    public List<CategoriaDto> obtenerCategorias(){
        return categoriaService.obtenerTodos();
    }
    
    @PostMapping
    public CategoriaDto crearCategoria(@RequestBody CategoriaDto categoriaDto){
//        return categoriaService.crear(categoriaDto, 0L);
        return categoriaService.crear(categoriaDto, null);
    }
    
    @GetMapping(path = {"/{id}", "/{id}/"})
    public CategoriaDto obtenerCategoriaPorId(@PathVariable("id") Long id){
        return categoriaService.obtenerPorId(id);
    }
}
