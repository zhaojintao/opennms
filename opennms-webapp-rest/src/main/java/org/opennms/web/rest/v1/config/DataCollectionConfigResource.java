/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2014 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2014 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.web.rest.v1.config;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.opennms.core.config.api.ConfigurationResourceException;
import org.opennms.core.xml.AbstractJaxbConfigDao;
import org.opennms.netmgt.config.api.DataCollectionConfigDao;
import org.opennms.netmgt.config.datacollection.DatacollectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DataCollectionConfigResource implements InitializingBean {
    private static final Logger LOG = LoggerFactory.getLogger(DataCollectionConfigResource.class);

    @Resource(name="dataCollectionConfigDao")
    private DataCollectionConfigDao m_dataCollectionConfigDao;

    public void setDataCollectionConfigDao(final DataCollectionConfigDao dao) {
        m_dataCollectionConfigDao = dao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(m_dataCollectionConfigDao, "DataCollectionConfigDao must be set!");
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
    public Response getDataCollectionConfiguration() throws ConfigurationResourceException {
        LOG.debug("getDatacollectionConfigurationForLocation()");

        final DatacollectionConfig dcc = m_dataCollectionConfigDao.getRootDataCollection();
        if (dcc == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(dcc.toDataCollectionConfig()).build();
    }
}
