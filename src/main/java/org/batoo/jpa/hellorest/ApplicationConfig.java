/*
 * Copyright (c) 2012 - Batoo Software ve Consultancy Ltd.
 * 
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.batoo.jpa.hellorest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.BatooJpaDialect;
import org.springframework.orm.jpa.vendor.BatooJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author hceylan
 * @since $version
 */
@Configuration
@ComponentScan(basePackageClasses = ApplicationConfig.class)
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationConfig {

	/**
	 * 
	 * <p>
	 * true for Batoo.
	 * <p>
	 * false for Hibernate
	 */
	private static final boolean BATOO_OR_HIBERNATE = true;

	/**
	 * Returns the entity manager factory.
	 * 
	 * @return the entity manager factory
	 * 
	 * @since $version
	 * @author hceylan
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		final AbstractJpaVendorAdapter vendorAdapter = ApplicationConfig.BATOO_OR_HIBERNATE ? new BatooJpaVendorAdapter() : new HibernateJpaVendorAdapter();

		vendorAdapter.setDatabase(Database.MYSQL);
		// vendorAdapter.setShowSql(true);

		final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(this.getClass().getPackage().getName());

		factory.setDataSource(this.getDatasource());

		final Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		properties.put("org.batoo.jpa.ddl", "DROP");
		factory.setJpaProperties(properties);

		factory.afterPropertiesSet();

		return factory.getObject();
	}

	/**
	 * Returns the datasource.
	 * 
	 * @return the datasource
	 * 
	 * @since $version
	 * @author hceylan
	 */
	@Bean
	public DataSourceImpl getDatasource() {
		final DataSourceImpl dataSource = new DataSourceImpl();

		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://dbhost:3306/benchmark?zeroDateTimeBehavior=convertToNull");
		dataSource.setUsername("benchmark");
		dataSource.setPassword("benchmark");
		dataSource.setMaxConnectionsPerPartition(100);
		dataSource.setMinConnectionsPerPartition(25);
		dataSource.setReleaseHelperThreads(0);

		return dataSource;
	}

	/**
	 * Returns the JPA Dialect.
	 * 
	 * @return the JPA Dialect
	 * 
	 * @since $version
	 * @author hceylan
	 */
	@Bean
	public JpaDialect jpaDialect() {
		return ApplicationConfig.BATOO_OR_HIBERNATE ? new BatooJpaDialect() : new HibernateJpaDialect();
	}

	/**
	 * Return the tranction manager.
	 * 
	 * @return the tranction manager
	 * 
	 * @since $version
	 * @author hceylan
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		final JpaTransactionManager txManager = new JpaTransactionManager();

		txManager.setEntityManagerFactory(this.entityManagerFactory());

		return txManager;
	}
}
