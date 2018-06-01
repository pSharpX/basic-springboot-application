/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.application;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import pe.edu.cibertec.springboot.batch.CategoriaItemProcessor;
import pe.edu.cibertec.springboot.batch.notification.JobCompletionNotificationListener;
import pe.edu.cibertec.springboot.domain.Categoria;

/**
 *
 * @author CHRISTIAN
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {
    
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<Categoria> reader() {
        return new FlatFileItemReaderBuilder<Categoria>()
            .name("personItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"firstName", "lastName"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Categoria>() {{
                setTargetType(Categoria.class);
            }})
            .build();
    }

    @Bean
    public CategoriaItemProcessor processor() {
        return new CategoriaItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Categoria> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Categoria>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
            .dataSource(dataSource)
            .build();
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Categoria> writer) {
        return stepBuilderFactory.get("step1")
            .<Categoria, Categoria> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
    // end::jobstep[]
    
}
