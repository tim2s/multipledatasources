package de.volkswagen.inbound.multipledatasources.domain.ldb;

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
        basePackages = "de.volkswagen.inbound.multipledatasources.domain.ldb",
        entityManagerFactoryRef = "ldbEntityManagerFactory",
        transactionManagerRef = "ldbTransactionManager")
public class LdbDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "ldb.datasource")
    public DataSource ldbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean ldbEntityManagerFactory(final EntityManagerFactoryBuilder builder)
    {
        return builder
                .dataSource(ldbDataSource())
                .packages("de.volkswagen.inbound.multipledatasources.domain.ldb")
                .build();
    }

    @Bean
    public JpaTransactionManager ldbTransactionManager(@Qualifier("ldbEntityManagerFactory") final EntityManagerFactory factory)
    {
        return new JpaTransactionManager(factory);
    }
}
