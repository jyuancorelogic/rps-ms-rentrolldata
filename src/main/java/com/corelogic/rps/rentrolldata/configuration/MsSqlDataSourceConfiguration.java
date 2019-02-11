package com.corelogic.rps.rentrolldata.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.corelogic.rps.rentrolldata.audit.data.RentrollRequest;
import com.corelogic.rps.rentrolldata.audit.data.RentrollRequestMessage;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "msSqlEntityManagerFactory",
        transactionManagerRef = "msSqlTransactionManager",
        basePackages = {"com.corelogic.rps.rentrolldata"}
)
public class MsSqlDataSourceConfiguration {

    @Bean(name = "msSqlDataSource")
    @ConfigurationProperties(prefix = "mssql.datasource")
    public DataSource msSqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("msSqlJpaVendorAdapter")
    @ConfigurationProperties(prefix = "mssql.jpa")
    public JpaVendorAdapter msSqlJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean(name = "msSqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean msSqlEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                            @Qualifier("msSqlDataSource") DataSource dataSource,
                                                                            @Qualifier("msSqlJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean = builder
                .dataSource(dataSource)
                .packages(RentrollRequest.class, RentrollRequestMessage.class,VendorRequestParams.class)
                .persistenceUnit("mssql")
                .build();
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        return bean;
    }

    @Bean(name = "msSqlTransactionManager")
    public PlatformTransactionManager msSqlTransactionManager(@Qualifier("msSqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
