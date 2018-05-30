/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.example;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Java-LM
 */

class Imagen{
    byte[] data;
}

interface ImagenService{
    Imagen obtenerImagen(String ruta);
}

class ImagenServiceImpl implements ImagenService{

    @Override
    public Imagen obtenerImagen(String ruta) {
        System.out.println("Obteniendo imagen de disco para ruta: " + ruta);
        return new Imagen();
    }
    
}

class ImagenServiceProxyImpl implements ImagenService{    
    private  ImagenService imagenService;
    private Map<String, Imagen> mapaImagenes;

    public ImagenServiceProxyImpl(ImagenService imagenService) {
        this.imagenService = imagenService;
        mapaImagenes = new HashMap<>();
    }
    
    @Override
    public Imagen obtenerImagen(String ruta) {
        System.out.println("Obteniendo imagen de memoria para la ruta: " + ruta);
        Imagen imagen = mapaImagenes.get(ruta);
        if(imagen == null){
            imagen = imagenService.obtenerImagen(ruta);
            mapaImagenes.put(ruta, imagen);
        }        
        return imagen;
    }
    
}

public class ProxyExample {
    static ImagenService obtenerImagenService(){
        return new ImagenServiceProxyImpl(new ImagenServiceImpl());
    }
    
    public static void main(String[] args) {
        // este es el cleinte de nuestro proxy
        ImagenService imagenService = obtenerImagenService();
        imagenService.obtenerImagen("prueba");
        imagenService.obtenerImagen("prueba");
        imagenService.obtenerImagen("prueba");
        
        imagenService.obtenerImagen("ejemplo");
        imagenService.obtenerImagen("ejemplo");
        imagenService.obtenerImagen("ejemplo");
    } 
}
