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

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.batoo.jpa.hellorest.model.Country;
import org.batoo.jpa.hellorest.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author hceylan
 * @since $version
 */
@Named("entityLoader")
public class EntityLoader {

	private static final Logger LOG = LoggerFactory.getLogger(EntityLoader.class);

	@Inject
	private ProfileRepository profiles;

	/**
	 * @since $version
	 * @author hceylan
	 */
	@PostConstruct
	public void load() {
		final Country turkey = new Country("Turkey");
		final Country uk = new Country("UK");
		final Country us = new Country("US");

		this.profiles.save(Arrays.asList(turkey, uk, us));
		EntityLoader.LOG.info("Countries created");
	}
}
