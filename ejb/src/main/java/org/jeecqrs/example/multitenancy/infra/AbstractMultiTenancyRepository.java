package org.jeecqrs.example.multitenancy.infra;

import javax.ejb.EJB;
import org.jeecqrs.common.Identity;
import org.jeecqrs.common.domain.model.multitenancy.AbstractTenantESAR;
import org.jeecqrs.common.persistence.jeeventstore.AbstractMultiTenancyEventStoreRepository;
import org.jeecqrs.example.multitenancy.domain.common.TenantId;
import org.jeeventstore.EventStore;

/**
 *
 * @param <T>  the AR type
 * @param <ID>  the type used to identify the ARs
 */
public abstract class AbstractMultiTenancyRepository<T extends AbstractTenantESAR<T, ID, TenantId>, ID extends Identity>
        extends AbstractMultiTenancyEventStoreRepository<T, ID, TenantId> {

    @EJB
    private EventStore eventStore;

    @Override
    protected String bucketId() {
        return Resources.DOMAIN_BUCKET_ID;
    }

    @Override
    protected EventStore eventStore() {
        return eventStore;
    }

    @Override
    public T ofIdentity(TenantId tenantId, ID id) {
        return super.ofIdentity(tenantId, id);
    }

    @Override
    public void add(T obj, Identity commitId) {
        super.add(obj, commitId);
    }

    @Override
    public void save(T obj, Identity commitId) {
        super.save(obj, commitId);
    }

    @Override
    public boolean exists(TenantId tenantId, ID id) {
        return super.exists(tenantId, id);
    }

}