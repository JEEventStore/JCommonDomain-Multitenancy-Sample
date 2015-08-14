package org.jeecqrs.example.multitenancy.domain.common;

import org.jeecqrs.common.Identity;

public abstract class AbstractMultiTenancyEventSourcedAggregateRoot<T, ID extends Identity>
	extends org.jeecqrs.common.domain.model.multitenancy.AbstractTenantESAR<T, ID, TenantId> {

}
