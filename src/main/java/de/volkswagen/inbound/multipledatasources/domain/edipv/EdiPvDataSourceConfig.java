package de.volkswagen.inbound.multipledatasources.domain.edipv;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "de.volkswagen.inbound.multipledatasources.domain.edipv",
        entityManagerFactoryRef = "ediPvEntityManagerFactory",
        transactionManagerRef = "ediPvTransactionManager")
public class EdiPvDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="edipv.datasource")
    public DataSource ediPvDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean ediPvEntityManagerFactory(final EntityManagerFactoryBuilder builder)
    {
        return builder
                .dataSource(ediPvDataSource())
                .packages("de.volkswagen.inbound.multipledatasources.domain.edipv")
                .build();
    }

    @Bean
    @Primary
    public JpaTransactionManager ediPvTransactionManager(@Qualifier("ediPvEntityManagerFactory") final EntityManagerFactory factory)
    {
        return new JpaTransactionManager(factory);
    }
}
