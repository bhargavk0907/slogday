package slog.day.config;




import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SuppressWarnings("ALL")
@ConfigurationProperties
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"slog.day.repository"}, entityManagerFactoryRef = "dsEmFactory", transactionManagerRef = "dsTransactionManager")
public class DataSource {

 
    @Primary
    @Bean
    @ConfigurationProperties("spring.dataSource")
    public DataSourceProperties dSProperties() {
        return new DataSourceProperties();
    }

   
    @Primary
    @Bean(name = "ds")
    public javax.sql.DataSource ds(@Qualifier("dsProperties") DataSourceProperties dsProperties) {
        return dsProperties.initializeDataSourceBuilder().build();

    }
    @Primary
    @Bean(name = "dsEmFactory")
    public LocalContainerEntityManagerFactoryBean dsEmFactory(@Qualifier("ds") javax.sql.DataSource ds, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(ds).packages("slog.day.entity").build();
    }

    @Primary
    @Bean(name = "dsTransactionManager")
    public PlatformTransactionManager dsTransactionManager(EntityManagerFactory dsEmFactory) {
        return new JpaTransactionManager(dsEmFactory);
    }

}