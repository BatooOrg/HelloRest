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
package org.batoo.jpa.hellorest.servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.batoo.jpa.hellorest.ApplicationConfig;
import org.springframework.data.rest.webmvc.RepositoryRestExporterServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


/**
 * 
 * @author hceylan
 * @since $version
 */
public class RestExporterWebInitializer implements WebApplicationInitializer {

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		final AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(ApplicationConfig.class);

		ctx.addListener(new ContextLoaderListener(rootCtx));

		final RepositoryRestExporterServlet exporter = new RepositoryRestExporterServlet();

		final ServletRegistration.Dynamic reg = ctx.addServlet("rest-exporter", exporter);
		reg.setLoadOnStartup(1);
		reg.addMapping("/*");
	}
}
