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

import java.util.Objects;

import org.opennms.core.utils.LldpUtils;

public class LldpLinkInfo {

    private final Integer id;
    private final Integer nodeId;
    private final String lldpRemChassisId;
    private final String lldpRemPortId;
    private final LldpUtils.LldpPortIdSubType lldpRemPortIdSubType;
    private final String lldpPortId;
    private final LldpUtils.LldpPortIdSubType lldpPortIdSubType;
    private final String lldpPortDescr;
    private final Integer lldpPortIfindex;

    public LldpLinkInfo(Integer id, Integer nodeId, String lldpRemChassisId, String lldpRemPortId,
                        LldpUtils.LldpPortIdSubType lldpRemPortIdSubType, String lldpPortId,
                        LldpUtils.LldpPortIdSubType lldpPortIdSubType, String lldpPortDescr, Integer lldpPortIfindex) {
        this.id = id;
        this.nodeId = nodeId;
        this.lldpRemChassisId = lldpRemChassisId;
        this.lldpRemPortId = lldpRemPortId;
        this.lldpRemPortIdSubType = lldpRemPortIdSubType;
        this.lldpPortId = lldpPortId;
        this.lldpPortIdSubType = lldpPortIdSubType;
        this.lldpPortDescr = lldpPortDescr;
        this.lldpPortIfindex = lldpPortIfindex;
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

    public String getLldpRemChassisId() {
        return lldpRemChassisId;
    }

    public String getLldpRemPortId() {
        return lldpRemPortId;
    }

    public LldpUtils.LldpPortIdSubType getLldpRemPortIdSubType() {
        return lldpRemPortIdSubType;
    }

    public String getLldpPortId() {
        return lldpPortId;
    }

    public LldpUtils.LldpPortIdSubType getLldpPortIdSubType() {
        return lldpPortIdSubType;
    }

    public String getLldpPortDescr() {
        return lldpPortDescr;
    }

    public Integer getLldpPortIfindex() {
        return lldpPortIfindex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LldpLinkInfo that = (LldpLinkInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nodeId, that.nodeId) &&
                Objects.equals(lldpRemChassisId, that.lldpRemChassisId) &&
                Objects.equals(lldpRemPortId, that.lldpRemPortId) &&
                Objects.equals(lldpRemPortIdSubType, that.lldpRemPortIdSubType) &&
                Objects.equals(lldpPortId, that.lldpPortId) &&
                Objects.equals(lldpPortIdSubType, that.lldpPortIdSubType) &&
                Objects.equals(lldpPortDescr, that.lldpPortDescr) &&
                Objects.equals(lldpPortIfindex, that.lldpPortIfindex);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nodeId, lldpRemChassisId, lldpRemPortId, lldpRemPortIdSubType, lldpPortId, lldpPortIdSubType, lldpPortDescr, lldpPortIfindex);
    }

    @Override
    public String toString() {
        return "LldpLinkInfo{" +
                "id=" + id +
                ", nodeId=" + nodeId +
                ", lldpRemChassisId='" + lldpRemChassisId + '\'' +
                ", lldpRemPortId='" + lldpRemPortId + '\'' +
                ", lldpRemPortIdSubType='" + lldpRemPortIdSubType + '\'' +
                ", lldpPortId='" + lldpPortId + '\'' +
                ", lldpPortIdSubType='" + lldpPortIdSubType + '\'' +
                ", lldpPortDescr='" + lldpPortDescr + '\'' +
                ", lldpPortIfindex=" + lldpPortIfindex +
                '}';
    }
}
