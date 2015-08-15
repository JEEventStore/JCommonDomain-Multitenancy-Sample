package org.jeecqrs.example.multitenancy.domain.common;

import org.jeecqrs.common.domain.model.multitenancy.MultiTenancyDomainEvent;

public abstract class AbstractMultiTenancyDomainEvent<T> 
	extends org.jeecqrs.common.domain.model.multitenancy.AbstractMultiTenancyDomainEvent<T, TenantId>
	implements MultiTenancyDomainEvent<T, TenantId> {

    public AbstractMultiTenancyDomainEvent(TenantId tenantId) {
        super(tenantId);
    }

}
