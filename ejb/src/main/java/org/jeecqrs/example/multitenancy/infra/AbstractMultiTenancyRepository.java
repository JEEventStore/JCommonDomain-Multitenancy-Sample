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

}