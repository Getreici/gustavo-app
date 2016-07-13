package com.gustavo.web.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gustavo.web.controller.UserController;
import com.gustavo.web.repository.UserRepository;
import com.gustavo.web.service.UserService;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableJpaRepositories("com.gustavo.web.*")
@PropertySource("classpath:application-${ENVIRONMENT}.properties")
@EnableTransactionManagement
public class DataConfiguration {

	private static final String DATABASE_DRIVER = "db.driver";
	private static final String DATABASE_PASSWORD = "db.password";
	private static final String DATABASE_URL = "db.url";
	private static final String DATABASE_USERNAME = "db.username";

	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

	@Resource
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty(DATABASE_DRIVER));
		dataSource.setJdbcUrl(environment.getRequiredProperty(DATABASE_URL));
		dataSource.setUsername(environment.getRequiredProperty(DATABASE_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));
		dataSource.setIdleConnectionTestPeriodInMinutes(30);
		dataSource.setIdleMaxAgeInMinutes(60);
		dataSource.setMaxConnectionsPerPartition(15);
		dataSource.setMinConnectionsPerPartition(5);
		dataSource.setPartitionCount(1);
		dataSource.setAcquireIncrement(5);
		dataSource.setStatementsCacheSize(100);

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		Properties jpaProterties = new Properties();
		jpaProterties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
		jpaProterties.put(HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(HIBERNATE_FORMAT_SQL));
		jpaProterties.put(HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(HIBERNATE_NAMING_STRATEGY));
		jpaProterties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
		entityManagerFactoryBean.setJpaProperties(jpaProterties);

		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws ClassNotFoundException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}
}
