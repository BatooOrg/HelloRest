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
package org.springframework.orm.jpa.vendor;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.spi.PersistenceProvider;

import org.batoo.jpa.core.BatooPersistenceProvider;
import org.springframework.orm.jpa.JpaDialect;


/**
 * {@link org.springframework.orm.jpa.JpaVendorAdapter} implementation for Batoo JPA. Developed and tested against BAtoo JPA 0.1.x
 * 
 * <p>
 * Exposes Batoo JPA's persistence provider and EntityManager extension interface, and supports {@link AbstractJpaVendorAdapter}'s common
 * configuration settings.
 * 
 * @author hceylan
 * @since $version
 */
public class BatooJpaVendorAdapter extends AbstractJpaVendorAdapter {

	private final PersistenceProvider persistenceProvider = new BatooPersistenceProvider();

	private final BatooJpaDialect jpaDialect = new BatooJpaDialect();

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public JpaDialect getJpaDialect() {
		return this.jpaDialect;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Map<String, Object> getJpaPropertyMap() {
		final Map<String, Object> jpaProperties = new HashMap<String, Object>();

		if (this.isGenerateDdl()) {
			jpaProperties.put("org.batoo.jpa.ddl", "UPDATE");
		}

		if (this.isShowSql()) {
			jpaProperties.put("org.batoo.jpa.sql_logging", "STDOUT");
		}

		return jpaProperties;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public PersistenceProvider getPersistenceProvider() {
		return this.persistenceProvider;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String getPersistenceProviderRootPackage() {
		return "org.batoo.jpa";
	}
}
