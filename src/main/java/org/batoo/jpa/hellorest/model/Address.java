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

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author hceylan
 * @since $version
 */
@Entity
public class Address {

	@Id
	private Long id;

	@ElementCollection
	private List<String> addrLines;

	private String city;
	private String province;
	private String postalCode;

	@ManyToOne
	private Country country;

	/**
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Address() {
		super();
	}

	/**
	 * @param lines
	 *            the lines
	 * @param city
	 *            the city
	 * @param province
	 *            the province
	 * @param postalCode
	 *            the postalcode
	 * @param country
	 *            the country
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Address(List<String> lines, String city, String province, String postalCode, Country country) {
		super();

		this.addrLines = lines;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
	}

	/**
	 * Returns the addrLines of the Address.
	 * 
	 * @return the addrLines of the Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public List<String> getAddrLines() {
		return this.addrLines;
	}

	/**
	 * Returns the city of the Address.
	 * 
	 * @return the city of the Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Returns the country of the Address.
	 * 
	 * @return the country of the Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Country getCountry() {
		return this.country;
	}

	/**
	 * Returns the id of the Address.
	 * 
	 * @return the id of the Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Returns the postalCode of the Address.
	 * 
	 * @return the postalCode of the Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * Returns the province of the Address.
	 * 
	 * @return the province of the Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public String getProvince() {
		return this.province;
	}

	/**
	 * Sets the addrLines of the Address.
	 * 
	 * @param addrLines
	 *            the addrLines to set for Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setAddrLines(List<String> addrLines) {
		this.addrLines = addrLines;
	}

	/**
	 * Sets the city of the Address.
	 * 
	 * @param city
	 *            the city to set for Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Sets the country of the Address.
	 * 
	 * @param country
	 *            the country to set for Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Sets the id of the Address.
	 * 
	 * @param id
	 *            the id to set for Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the postalCode of the Address.
	 * 
	 * @param postalCode
	 *            the postalCode to set for Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Sets the province of the Address.
	 * 
	 * @param province
	 *            the province to set for Address
	 * 
	 * @since $version
	 * @author hceylan
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String toString() {
		return "Address [id=" + this.id + ", addrLines=" + this.addrLines + ", city=" + this.city + ", province=" + this.province + ", postalCode="
			+ this.postalCode + ", country=" + this.country + "]";
	}
}
