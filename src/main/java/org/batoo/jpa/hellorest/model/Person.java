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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.springframework.data.rest.repository.annotation.RestResource;


/**
 * @author Jon Brisbin <jon@jbrisbin.com>
 */
@Entity
public class Person {

	@Id
	private Long id;

	private String name;

	@Version
	private Long version;

	@RestResource(exported = true, path = "addresses")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Address> addresses;

	/**
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Person() {
		super();
	}

	/**
	 * @param name
	 *            the name
	 * @param addresses
	 *            the addresses
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Person(String name, List<Address> addresses) {
		super();

		this.name = name;
		this.addresses = addresses;
	}

	/**
	 * Returns the addresses of the Person.
	 * 
	 * @return the addresses of the Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public List<Address> getAddresses() {
		return this.addresses;
	}

	/**
	 * Returns the id of the Person.
	 * 
	 * @return the id of the Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Returns the name of the Person.
	 * 
	 * @return the name of the Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the version of the Person.
	 * 
	 * @return the version of the Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Long getVersion() {
		return this.version;
	}

	/**
	 * Sets the addresses of the Person.
	 * 
	 * @param addresses
	 *            the addresses to set for Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Sets the id of the Person.
	 * 
	 * @param id
	 *            the id to set for Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the name of the Person.
	 * 
	 * @param name
	 *            the name to set for Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the version of the Person.
	 * 
	 * @param version
	 *            the version to set for Person
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String toString() {
		return "Person [id=" + this.id + ", name=" + this.name + ", version=" + this.version + ", addresses=" + this.addresses + "]";
	}
}
