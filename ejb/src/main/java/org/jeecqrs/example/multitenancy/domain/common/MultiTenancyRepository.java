package org.jeecqrs.example.multitenancy.domain.common;

import org.jeecqrs.common.Identity;

public interface MultiTenancyRepository<T, ID extends Identity> 
    extends org.jeecqrs.common.domain.model.multitenancy.MultiTenancyRepository<T, ID, TenantId, Identity>{

}