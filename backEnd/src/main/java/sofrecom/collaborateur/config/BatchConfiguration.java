/*
package sofrecom.collaborateur.config;

import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import sofrecom.collaborateur.model.DAOUser;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;
    
    
	@Autowired

    
    @Bean
    public FlatFileItemReader<DAOUser> reader() {
        BeanWrapperFieldSetMapper<DAOUser> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(DAOUser.class);
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(String s) {
            	return Date.valueOf(s);
            }
        });
        fieldSetMapper.setConversionService(conversionService);

        FlatFileItemReader<DAOUser> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("users.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<DAOUser>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
            	setDelimiter(";");
                setNames(new String[] { "dateIntegration","email","fullname","matricule","password","username","maanager" });
            }});
            setFieldSetMapper(fieldSetMapper);
        }});
        return reader;
    }


    
    @Bean
    public JdbcBatchItemWriter<DAOUser> writer() {
        JdbcBatchItemWriter<DAOUser> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO user ( date_integration,email,fullname,matricule,password,username,manager_id) VALUES ( :dateIntegration,:email,:fullname,:matricule,:password,:username,:manager)");
        writer.setDataSource(dataSource);
        return writer;
    }

   @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
   
  public UserItemProcessor processor() {
	   return new UserItemProcessor();
   }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step")
                .<DAOUser, DAOUser> chunk(5)
                .reader(reader())
          //      .processor(processor())
                .writer(writer())
                .allowStartIfComplete(true)
                .build();
    } 
    

}
*/
