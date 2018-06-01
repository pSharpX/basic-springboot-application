/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import pe.edu.cibertec.springboot.domain.Categoria;

/**
 *
 * @author CHRISTIAN
 */
public class CategoriaItemProcessor implements ItemProcessor<Categoria, Categoria> {

    private static final Logger log = LoggerFactory.getLogger(CategoriaItemProcessor.class);
    
    @Override
    public Categoria process(Categoria i) throws Exception {
        /*
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
