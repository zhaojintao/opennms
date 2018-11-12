/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2018 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2018 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.model;

import java.net.InetAddress;
import java.util.Objects;

public class OspfLinkInfo {
    private final Integer id;
    private final Integer nodeId;
    private final InetAddress ospfIpAddr;
    private final InetAddress ospfRemIpAddr;
    private final Integer ospfIfIndex;

    public OspfLinkInfo(Integer id, Integer nodeId, InetAddress ospfIpAddr, InetAddress ospfRemIpAddr, Integer ospfIfIndex) {
        this.id = id;
        this.nodeId = nodeId;
        this.ospfIpAddr = ospfIpAddr;
        this.ospfRemIpAddr = ospfRemIpAddr;
        this.ospfIfIndex = ospfIfIndex;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public String getNodeIdAsString() {
        if (getNodeId() != null) {
            return getNodeId().toString();
        }
        return null;
    }

    public InetAddress getOspfIpAddr() {
        return ospfIpAddr;
    }

    public InetAddress getOspfRemIpAddr() {
        return ospfRemIpAddr;
    }

    public Integer getOspfIfIndex() {
        return ospfIfIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OspfLinkInfo that = (OspfLinkInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nodeId, that.nodeId) &&
                Objects.equals(ospfIpAddr, that.ospfIpAddr) &&
                Objects.equals(ospfRemIpAddr, that.ospfRemIpAddr) &&
                Objects.equals(ospfIfIndex, that.ospfIfIndex);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nodeId, ospfIpAddr, ospfRemIpAddr, ospfIfIndex);
    }

    @Override
    public String toString() {
        return "OspfLinkInfo{" +
                "id=" + id +
                ", nodeId=" + nodeId +
                ", ospfIpAddr=" + ospfIpAddr +
                ", ospfRemIpAddr=" + ospfRemIpAddr +
                ", ospfIfIndex=" + ospfIfIndex +
                '}';
    }
}
