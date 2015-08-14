package org.jeecqrs.example.multitenancy.domain.common;

import org.jeecqrs.common.domain.model.AbstractDomainEvent;
import org.jeecqrs.common.domain.model.multitenancy.MultiTenancyDomainEvent;

public abstract class AbstractMultiTenancyDomainEvent<T> 
	extends AbstractDomainEvent<T>
	implements MultiTenancyDomainEvent<T, TenantId> {

    private final TenantId tenantId;

    public AbstractMultiTenancyDomainEvent(TenantId tenantId) {
        if (tenantId == null)
            throw new NullPointerException("tenantId must not be null");
	this.tenantId = tenantId;
    }

    @Override
    public final TenantId tenantId() {
	return tenantId;
    }

}
