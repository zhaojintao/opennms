package org.opennms.netmgt.enlinkd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.opennms.netmgt.dao.api.NodeDao;
import org.opennms.netmgt.model.LldpElement;
import org.opennms.netmgt.model.LldpLink;
import org.opennms.netmgt.model.OnmsCriteria;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.model.PrimaryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

public class EnhancedLinkdServiceImpl implements EnhancedLinkdService {
		
	private final static Logger LOG = LoggerFactory.getLogger(EnhancedLinkdServiceImpl.class);

    @Autowired
    private PlatformTransactionManager m_transactionManager;

	protected boolean m_ready = true;
	
	@Autowired
	private NodeDao m_nodeDao;

	public NodeDao getNodeDao() {
		return m_nodeDao;
	}

	public void setNodeDao(NodeDao nodeDao) {
		m_nodeDao = nodeDao;
	}

    @Override
	public List<LinkableNode> getSnmpNodeList() {
		final List<LinkableNode> nodes = new ArrayList<LinkableNode>();
		
		final OnmsCriteria criteria = new OnmsCriteria(OnmsNode.class);
        criteria.createAlias("ipInterfaces", "iface", OnmsCriteria.LEFT_JOIN);
        criteria.add(Restrictions.eq("type", "A"));
        criteria.add(Restrictions.eq("iface.isSnmpPrimary", PrimaryType.PRIMARY));
        for (final OnmsNode node : m_nodeDao.findMatching(criteria)) {
            final String sysObjectId = node.getSysObjectId();
            nodes.add(new LinkableNode(node.getId(), node.getPrimaryInterface().getIpAddress(), sysObjectId == null? "-1" : sysObjectId));
        }

        return nodes;
	}

	@Override
	public LinkableNode getSnmpNode(final int nodeid) {
		final OnmsCriteria criteria = new OnmsCriteria(OnmsNode.class);
        criteria.createAlias("ipInterfaces", "iface", OnmsCriteria.LEFT_JOIN);
        criteria.add(Restrictions.eq("type", "A"));
        criteria.add(Restrictions.eq("iface.isSnmpPrimary", PrimaryType.PRIMARY));
        criteria.add(Restrictions.eq("id", nodeid));
        final List<OnmsNode> nodes = m_nodeDao.findMatching(criteria);

        if (nodes.size() > 0) {
        	final OnmsNode node = nodes.get(0);
        	final String sysObjectId = node.getSysObjectId();
			return new LinkableNode(node.getId(), node.getPrimaryInterface().getIpAddress(), sysObjectId == null? "-1" : sysObjectId);
        } else {
        	return null;
        }
	}

	@Override
	public void reconcile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reconcile(int nodeid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reconcileLldp(int nodeId, Date now) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reconcileCdp(int nodeId, Date now) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reconcileOspf(int nodeId, Date now) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reconcileIpNetToMedia(int nodeId, Date now) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reconcileBridge(int nodeId, Date now) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store(int nodeId, LldpLink link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void store(int nodeId, LldpElement element) {
		if (element ==  null)
			return;
		final OnmsNode node = m_nodeDao.get(nodeId);
		if ( node == null )
			return;
		LldpElement dbelement = node.getLldpElement();
		dbelement.merge(element);
        node.setLldpElement(dbelement);

        m_nodeDao.saveOrUpdate(node);
		m_nodeDao.flush();
		
	}

	@Override
	public boolean ready() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
