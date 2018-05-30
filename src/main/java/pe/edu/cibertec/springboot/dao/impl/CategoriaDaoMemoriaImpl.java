/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.springboot.dao.CategoriaDao;
import pe.edu.cibertec.springboot.domain.Categoria;

/**
 *
 * @author Java-LM
 */
@Repository
public class CategoriaDaoMemoriaImpl implements CategoriaDao{
    
    private Map<Long, Categoria> mapaCategorias;
    private Map<String, Categoria> mapaIndiceCategoriasPorNombre;
    private AtomicLong semilla;
    
    @PostConstruct
    public void init(){
        mapaCategorias = new ConcurrentHashMap<>();
        mapaIndiceCategoriasPorNombre= new ConcurrentHashMap<>();
        semilla = new AtomicLong(1);
        
        crear(new Categoria(0L, "Juguetes", "Juguetes"));
        crear(new Categoria(0L, "Deportes", "Deportes"));
        crear(new Categoria(0L, "Adulto", "Adulto"));
        crear(new Categoria(0L, "Niños", "Niños"));
    }
    
    
    @Override
    public Categoria crear(Categoria categoria){
        Categoria nuevaCategoria = new Categoria(semilla.getAndIncrement(), categoria.getNombre(), categoria.getDescripcion());
        nuevaCategoria.setFechaCreacion(categoria.getFechaCreacion());
        mapaCategorias.put(nuevaCategoria.getId(), nuevaCategoria);
        mapaIndiceCategoriasPorNombre.put(nuevaCategoria.getNombre(), nuevaCategoria);
        return nuevaCategoria;
    }

    @Override
    public List<Categoria> obtenerTodos() {
        return new ArrayList<>(mapaCategorias.values());
    }

    @Override
    public Categoria busquedaPorNombre(String nombre) {
        return mapaIndiceCategoriasPorNombre.get(nombre);
    }
    
}
