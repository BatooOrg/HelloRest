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
package org.batoo.jpa.hellorest.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;


/**
 * 
 * @author hceylan
 * @since $version
 */
@Entity
public class Country {

	@Id
	@TableGenerator(name = "countryId")
	@GeneratedValue(generator = "countryId", strategy = GenerationType.TABLE)
	private Long id;

	private String name;

	/**
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Country() {
		super();
	}

	/**
	 * @param name
	 *            the name of the country
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Country(String name) {
		super();

		this.name = name;
	}

	/**
	 * Returns the id of the Country.
	 * 
	 * @return the id of the Country
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Returns the name of the Country.
	 * 
	 * @return the name of the Country
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the id of the Country.
	 * 
	 * @param id
	 *            the id to set for Country
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the name of the Country.
	 * 
	 * @param name
	 *            the name to set for Country
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String toString() {
		return "Country [id=" + this.id + ", name=" + this.name + "]";
	}
}
