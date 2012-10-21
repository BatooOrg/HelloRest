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
package org.batoo.jpa.hellorest.repository;
import java.util.List;

import org.batoo.jpa.hellorest.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;


/**
 * 
 * @author hceylan
 * @since $version
 */
@RestResource(path = "person")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	/**
	 * Returns the list of people with the name <code>name</code>.
	 * 
	 * @param name
	 *            the name of the person
	 * @return the list of persons the name <code>name</code>
	 * 
	 * @since $version
	 * @author hceylan
	 */
	@RestResource(path = "name", rel = "names")
	public List<Person> findByName(@Param("name") String name);
}
